1    package pl.gov.coi.common.ui.ds.textarea
2    
3    import androidx.compose.foundation.BorderStroke
4    import androidx.compose.foundation.background
5    import androidx.compose.foundation.layout.Box
6    import androidx.compose.foundation.layout.Column
7    import androidx.compose.foundation.layout.Spacer
8    import androidx.compose.foundation.layout.fillMaxWidth
9    import androidx.compose.foundation.layout.height
10   import androidx.compose.foundation.layout.padding
11   import androidx.compose.foundation.layout.wrapContentHeight
12   import androidx.compose.foundation.text.BasicTextField
13   import androidx.compose.foundation.text.KeyboardOptions
14   import androidx.compose.material.Card
15   import androidx.compose.material.Text
16   import androidx.compose.runtime.Composable
17   import androidx.compose.runtime.getValue
18   import androidx.compose.runtime.mutableStateOf
19   import androidx.compose.runtime.remember
20   import androidx.compose.runtime.setValue
21   import androidx.compose.ui.ExperimentalComposeUiApi
22   import androidx.compose.ui.Modifier
23   import androidx.compose.ui.graphics.Color
24   import androidx.compose.ui.graphics.SolidColor
25   import androidx.compose.ui.layout.onGloballyPositioned
26   import androidx.compose.ui.layout.positionInWindow
27   import androidx.compose.ui.semantics.contentDescription
28   import androidx.compose.ui.semantics.LiveRegionMode
29   import androidx.compose.ui.semantics.liveRegion
30   import androidx.compose.ui.semantics.editableText
31   import androidx.compose.ui.semantics.semantics
32   import androidx.compose.ui.semantics.stateDescription
33   import androidx.compose.ui.semantics.testTag
34   import androidx.compose.ui.semantics.testTagsAsResourceId
35   import androidx.compose.ui.text.AnnotatedString
36   import androidx.compose.ui.text.SpanStyle
37   import androidx.compose.ui.text.buildAnnotatedString
38   import androidx.compose.ui.text.font.FontWeight
39   import androidx.compose.ui.text.input.KeyboardType
40   import androidx.compose.ui.text.input.VisualTransformation
41   import androidx.compose.ui.text.style.TextAlign
42   import androidx.compose.ui.text.style.TextOverflow
43   import androidx.compose.ui.text.withStyle
44   import androidx.compose.ui.tooling.preview.Preview
45   import androidx.compose.ui.tooling.preview.PreviewParameter
46   import androidx.compose.ui.unit.IntOffset
47   import pl.gov.coi.common.ui.ds.errortext.ErrorText
48   import pl.gov.coi.common.ui.ds.helpertext.HelperText
49   import pl.gov.coi.common.ui.ds.textarea.provider.TextAreaPPP
50   import pl.gov.coi.common.ui.focus.FocusHost
51   import pl.gov.coi.common.ui.focus.FocusHost.Companion.focusHost
52   import pl.gov.coi.common.ui.focus.FocusHost.Companion.focusHostBringIntoView
53   import pl.gov.coi.common.ui.focus.createFocusHost
54   import pl.gov.coi.common.ui.text.CustomText
55   import pl.gov.coi.common.ui.theme.AppTheme
56   import pl.gov.coi.common.ui.utils.textWithDotAndSpaceOrEmpty
57   
58   @OptIn(ExperimentalComposeUiApi::class)
59   @Composable
60   fun TextArea(
61     data: TextAreaData,
62     focusHost: FocusHost = createFocusHost(),
63   ) {
64     var inputFieldCoordinates by remember { mutableStateOf(IntOffset(0, 0)) }
65   
66     Column(
67       modifier = Modifier
68         .fillMaxWidth()
69         .wrapContentHeight()
70         .onGloballyPositioned { coordinates ->
71           inputFieldCoordinates = IntOffset(
72             x = coordinates.positionInWindow().x.toInt(),
73             y = coordinates.positionInWindow().y.toInt(),
74           )
75         },
76     ) {
77       data.label?.let { label ->
78         CustomText(
79           testTag = data.testTag?.let { tag -> tag + "Text" },
80           label = label,
81           style = AppTheme.typography.bodyMediumRegular,
82           color = if (data.enabled) AppTheme.colors.neutral200 else AppTheme.colors.neutral60,
83           indexTag = data.indexTag,
84           ignoreForAccessibility = true,
85         )
86         Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
87       }
88       Card(
89         border = BorderStroke(
90           width = getBorderWidth(focusHost),
91           color = getCardBorderColor(
92             enabled = data.enabled,
93             state = data.state,
94             isFocused = focusHost.isFocused,
95           ),
96         ),
97         backgroundColor = Color.White,
98         elevation = AppTheme.elevations.level0,
99       ) {
100        BasicTextField(
101          keyboardOptions = KeyboardOptions(
102            keyboardType = KeyboardType.Text,
103            imeAction = data.imeAction,
104          ),
105          enabled = data.enabled,
106          cursorBrush = getCursorBrushColor(
107            state = data.state,
108            isFocused = focusHost.isFocused,
109          ),
110          modifier = Modifier
111            .fillMaxWidth()
112            .focusHostBringIntoView(focusHost = focusHost)
113            .focusHost(focusHost = focusHost)
114            .semantics { testTagsAsResourceId = true }
115            .semantics {
116              contentDescription = data.contentDescription()
117              editableText = AnnotatedString(data.content)
118              testTag = data.testTag?.let { tag -> tag + "EditText" } ?: data.label?.tag ?: "Undefined"
119                .let { tag -> "EditText $tag${data.indexTag?.let { "_${data.indexTag}" } ?: ""}" }
120            }
121            .semantics {
122              if (data.state is TextAreaDataState.Error) {
123                liveRegion = LiveRegionMode.Assertive
124                stateDescription = data.state.errorLabel.text
125              }
126            },
127          value = data.content,
128          onValueChange = { text ->
129            data.onValueChanged(text)
130            if (data.counterState is CounterState.Visible) {
131              data.counterState.onCharsLimitReached(text.length > data.counterState.maxLength)
132            }
133          },
134          minLines = getMinLines(textAreaType = data.type),
135          maxLines = getMaxLines(textAreaType = data.type),
136          visualTransformation = VisualTransformation.None,
137          textStyle = AppTheme.typography.bodyLargeRegular.copy(
138            color = if (data.enabled) AppTheme.colors.neutral500 else AppTheme.colors.neutral60,
139          ),
140          decorationBox = { innerTextField ->
141            Column(
142              modifier = Modifier.padding(
143                all = AppTheme.dimensions.spacing100,
144              ),
145            ) {
146              Box(
147                modifier = Modifier.padding(
148                  all = AppTheme.dimensions.spacing100,
149                ),
150              ) {
151                if (data.content.isEmpty()) {
152                  CustomText(
153                    testTag = data.testTag?.let { tag -> tag + "HintText" },
154                    label = data.hint,
155                    overflow = TextOverflow.Ellipsis,
156                    style = AppTheme.typography.bodyLargeRegular,
157                    color = if (data.enabled) AppTheme.colors.neutral100 else AppTheme.colors.neutral60,
158                    focusable = false,
159                  )
160                }
161                innerTextField()
162              }
163              if (data.counterState is CounterState.Visible) {
164                buildCounter(
165                  state = data.state,
166                  enabled = data.enabled,
167                  contentLength = data.content.length,
168                  maxLength = data.counterState.maxLength,
169                )
170              }
171            }
172          },
173        )
174      }
175      when (data.state) {
176        is TextAreaDataState.Default ->
177          if (data.state.helperLabel.isNotBlank()) {
178            Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
179            HelperText(
180              testTag = data.testTag?.let { tag -> tag + "HelperText" },
181              helperLabel = data.state.helperLabel,
182              ignoreForAccessibility = true,
183            )
184          }
185  
186        is TextAreaDataState.Error -> {
187          Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
188          ErrorText(
189            testTag = data.testTag?.let { tag -> tag + "ErrorText" },
190            errorText = data.state.errorLabel,
191            ignoreForAccessibility = true,
192          )
193        }
194      }
195    }
196  }
197  
198  @Composable
199  private fun getBorderWidth(focusHost: FocusHost) = if (focusHost.isFocused) {
200    AppTheme.dimensions.spacing25
201  } else {
202    AppTheme.dimensions.strokeWidth
203  }
204  
205  @Composable
206  private fun getCursorBrushColor(
207    state: TextAreaDataState,
208    isFocused: Boolean,
209  ) = when (state) {
210    is TextAreaDataState.Error -> SolidColor(AppTheme.colors.supportRed100)
211    else -> SolidColor(
212      value = if (isFocused) {
213        AppTheme.colors.primary900
214      } else {
215        AppTheme.colors.neutral100
216      },
217    )
218  }
219  
220  @Composable
221  private fun getMinLines(
222    textAreaType: TextAreaType,
223  ) = if (textAreaType is TextAreaType.Fix) {
224    textAreaType.lines
225  } else {
226    1
227  }
228  
229  @Composable
230  private fun getMaxLines(
231    textAreaType: TextAreaType,
232  ) = when (textAreaType) {
233    is TextAreaType.Fix -> textAreaType.lines
234    is TextAreaType.Flexible -> textAreaType.maxLines
235  }
236  
237  @Composable
238  private fun getCardBorderColor(
239    enabled: Boolean,
240    state: TextAreaDataState,
241    isFocused: Boolean,
242  ) = when {
243    enabled.not() -> AppTheme.colors.neutral30
244    state is TextAreaDataState.Error -> AppTheme.colors.supportRed100
245    isFocused -> AppTheme.colors.primary900
246    else -> AppTheme.colors.neutral80
247  }
248  
249  @Composable
250  private fun buildCounter(
251    state: TextAreaDataState,
252    enabled: Boolean,
253    contentLength: Int,
254    maxLength: Int,
255  ) {
256    val annotatedString = buildAnnotatedString {
257      withStyle(
258        style = SpanStyle(
259          fontStyle = AppTheme.typography.bodySmallRegular.fontStyle,
260          fontWeight = when (state) {
261            is TextAreaDataState.Error -> FontWeight.Bold
262            else -> FontWeight.Normal
263          },
264          color = when {
265            enabled.not() -> AppTheme.colors.neutral60
266            state is TextAreaDataState.Error -> AppTheme.colors.supportRed100
267            else -> AppTheme.colors.neutral200
268          },
269        ),
270      ) {
271        append("$contentLength")
272      }
273      withStyle(
274        style = SpanStyle(
275          fontStyle = AppTheme.typography.bodySmallRegular.fontStyle,
276          color = if (enabled) AppTheme.colors.neutral200 else AppTheme.colors.neutral60,
277        ),
278      ) {
279        append("/$maxLength")
280      }
281    }
282    Text(
283      modifier = Modifier.fillMaxWidth(),
284      textAlign = TextAlign.End,
285      style = AppTheme.typography.bodySmallRegular,
286      text = annotatedString,
287    )
288  }
289  
290  private fun TextAreaData.contentDescription() =
291    (label.textWithDotAndSpaceOrEmpty() +
292      (when (state) {
293        is TextAreaDataState.Default -> state.helperLabel
294        is TextAreaDataState.Error -> state.errorLabel
295      }).textWithDotAndSpaceOrEmpty()).trim()
296  
297  @Preview
298  @Composable
299  fun TextAreaPreview(
300    @PreviewParameter(TextAreaPPP::class)
301    data: TextAreaData,
302  ) {
303    Box(modifier = Modifier.background(AppTheme.colors.white)) {
304      TextArea(
305        data = data,
306      )
307    }
308  }
309  