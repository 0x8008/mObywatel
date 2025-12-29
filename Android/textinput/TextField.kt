1    package pl.gov.coi.common.ui.ds.textinput
2    
3    import android.content.Context
4    import androidx.compose.foundation.BorderStroke
5    import androidx.compose.foundation.clickable
6    import androidx.compose.foundation.interaction.MutableInteractionSource
7    import androidx.compose.foundation.interaction.PressInteraction
8    import androidx.compose.foundation.layout.Arrangement
9    import androidx.compose.foundation.layout.Box
10   import androidx.compose.foundation.layout.Row
11   import androidx.compose.foundation.layout.Spacer
12   import androidx.compose.foundation.layout.fillMaxWidth
13   import androidx.compose.foundation.layout.heightIn
14   import androidx.compose.foundation.layout.padding
15   import androidx.compose.foundation.layout.width
16   import androidx.compose.foundation.text.BasicTextField
17   import androidx.compose.foundation.text.KeyboardOptions
18   import androidx.compose.material.Card
19   import androidx.compose.runtime.Composable
20   import androidx.compose.runtime.LaunchedEffect
21   import androidx.compose.runtime.getValue
22   import androidx.compose.runtime.mutableStateOf
23   import androidx.compose.runtime.remember
24   import androidx.compose.runtime.setValue
25   import androidx.compose.ui.Alignment
26   import androidx.compose.ui.ExperimentalComposeUiApi
27   import androidx.compose.ui.Modifier
28   import androidx.compose.ui.focus.FocusManager
29   import androidx.compose.ui.graphics.Color
30   import androidx.compose.ui.graphics.SolidColor
31   import androidx.compose.ui.platform.LocalContext
32   import androidx.compose.ui.semantics.Role
33   import androidx.compose.ui.semantics.contentDescription
34   import androidx.compose.ui.semantics.editableText
35   import androidx.compose.ui.semantics.invisibleToUser
36   import androidx.compose.ui.semantics.semantics
37   import androidx.compose.ui.semantics.testTag
38   import androidx.compose.ui.semantics.testTagsAsResourceId
39   import androidx.compose.ui.text.AnnotatedString
40   import androidx.compose.ui.text.input.PasswordVisualTransformation
41   import androidx.compose.ui.text.input.VisualTransformation
42   import androidx.compose.ui.text.style.TextAlign
43   import pl.gov.coi.common.domain.label.CommonUILabelProvider
44   import pl.gov.coi.common.domain.label.Label
45   import pl.gov.coi.common.domain.label.toLabel
46   import pl.gov.coi.common.domain.validators.ValidationState
47   import pl.gov.coi.common.ui.R
48   import pl.gov.coi.common.ui.ds.custom.icon.Icon
49   import pl.gov.coi.common.ui.ds.custom.icon.IconData
50   import pl.gov.coi.common.ui.ds.custom.icon.IconSize
51   import pl.gov.coi.common.ui.ds.textinput.model.TextInputData
52   import pl.gov.coi.common.ui.ds.textinput.visualtransformation.MaskVisualTransformation
53   import pl.gov.coi.common.ui.focus.FocusHost
54   import pl.gov.coi.common.ui.focus.FocusHost.Companion.focusHost
55   import pl.gov.coi.common.ui.text.CustomText
56   import pl.gov.coi.common.ui.theme.AppTheme
57   import pl.gov.coi.common.ui.utils.NoRippleInteractionSource
58   import pl.gov.coi.common.ui.utils.getResourceEntryNameIcon
59   import pl.gov.coi.common.ui.utils.textWithDotAndSpaceOrEmpty
60   
61   @OptIn(ExperimentalComposeUiApi::class)
62   @Composable
63   internal fun TextField(
64     data: TextInputData,
65     focusHost: FocusHost,
66     focusManager: FocusManager,
67   ) {
68     var isPasswordVisible by remember { mutableStateOf(false) }
69     val inputInteractionSource = remember { MutableInteractionSource() }
70   
71     if (focusHost.isFocused) {
72       LaunchedEffect(inputInteractionSource) {
73         inputInteractionSource.interactions.collect {
74           if (it is PressInteraction.Release) {
75             focusHost.bringIntoView(withKeyboardAnimationDelay = true)
76           }
77         }
78       }
79     }
80   
81     Card(
82       border = BorderStroke(
83         width = when {
84           focusHost.isFocused -> AppTheme.dimensions.spacing25
85           else -> AppTheme.dimensions.strokeWidth
86         },
87         color = when {
88           data.validationState is ValidationState.Invalid -> AppTheme.colors.supportRed100
89           focusHost.isFocused -> AppTheme.colors.primary900
90           !data.enabled -> AppTheme.colors.neutral30
91           else -> AppTheme.colors.neutral80
92         },
93       ),
94       backgroundColor = Color.White,
95       elevation = AppTheme.elevations.level0,
96     ) {
97       BasicTextField(
98         modifier = Modifier
99           .focusHost(focusHost = focusHost)
100          .semantics { testTagsAsResourceId = true }
101          .semantics {
102            contentDescription = data.contentDescription()
103            editableText = AnnotatedString(data.value.text)
104            testTag = data.testTag ?: data.label?.tag
105              .let { tag -> "${tag}EditText" }
106              .let { tag -> "$tag${data.indexTag?.let { "_${data.indexTag}" } ?: ""}" }
107          }
108          .fillMaxWidth()
109          .heightIn(min = AppTheme.dimensions.spacing700),
110        keyboardOptions = KeyboardOptions(
111          keyboardType = data.keyboardType,
112          imeAction = data.imeAction,
113        ),
114        keyboardActions = data.keyboardAction(focusManager),
115        value = data.value.text,
116        onValueChange = { value ->
117          if (data is TextInputData.Masked) {
118            data.maskType.run {
119              if (filter(value)) data.onValueChanged(value)
120            }
121          } else {
122            data.onValueChanged(value)
123          }
124        },
125        interactionSource = inputInteractionSource,
126        visualTransformation = when (data) {
127          is TextInputData.Masked -> MaskVisualTransformation(data.maskType)
128          is TextInputData.Password -> if (isPasswordVisible) {
129            VisualTransformation.None
130          } else {
131            PasswordVisualTransformation()
132          }
133  
134          else -> VisualTransformation.None
135        },
136        enabled = data.enabled,
137        textStyle = AppTheme.typography.bodyLargeRegular.copy(
138          color = if (data.enabled) {
139            AppTheme.colors.neutral500
140          } else {
141            AppTheme.colors.neutral60
142          },
143          textAlign = data.textAlign ?: TextAlign.Start,
144        ),
145        singleLine = data.singleLine,
146        cursorBrush = SolidColor(AppTheme.colors.primary900),
147        decorationBox = { innerTextField ->
148          Row(
149            modifier = Modifier
150              .padding(all = AppTheme.dimensions.spacing200)
151              .fillMaxWidth(),
152            verticalAlignment = if (!data.singleLine) Alignment.Top else Alignment.CenterVertically,
153            horizontalArrangement = Arrangement.Start,
154          ) {
155            LeftIcon(data = data)
156            when (data) {
157              is TextInputData.Masked ->
158                Box(modifier = Modifier.weight(1F)) {
159                  Placeholder(data = data)
160                  innerTextField()
161                }
162              else ->
163                Box(modifier = Modifier.weight(1F)) {
164                  Hint(data = data)
165                  innerTextField()
166                }
167            }
168            RightIcon(
169              data = data,
170              isFocused = focusHost.isFocused,
171              isPasswordVisible = isPasswordVisible,
172            ) { passwordVisible ->
173              isPasswordVisible = passwordVisible
174            }
175          }
176        },
177      )
178    }
179  }
180  
181  private fun TextInputData.contentDescription() =
182    (
183      label.textWithDotAndSpaceOrEmpty() +
184        when (validationState) {
185          is ValidationState.Invalid -> (validationState as ValidationState.Invalid).message.textWithDotAndSpaceOrEmpty()
186          else -> helperText.textWithDotAndSpaceOrEmpty()
187        }
188      ).trim()
189  
190  @Composable
191  private fun LeftIcon(data: TextInputData) {
192    when (data) {
193      is TextInputData.Search -> SearchIcon(
194        iconTestTag = data.testTag?.let { tag -> tag + "SearchIcon" },
195        enabled = data.enabled,
196      )
197      else -> Unit
198    }
199  }
200  
201  @Composable
202  private fun RightIcon(
203    data: TextInputData,
204    isFocused: Boolean,
205    isPasswordVisible: Boolean,
206    changePasswordVisibility: (Boolean) -> Unit,
207  ) {
208    val context = LocalContext.current
209  
210    val isValueNotEmpty = data.value.text.isNotEmpty()
211    val isNotPasswordInputType = (data is TextInputData.Password).not()
212  
213    when {
214      isValueNotEmpty && isFocused && isNotPasswordInputType && data.removableIconVisible ->
215        RemoveIconButton(
216          context = context,
217          iconButtonTestTag = data.testTag?.let { tag -> tag + "RemoveIconButton" },
218          enabled = data.enabled,
219          onValueChanged = data.onValueChanged,
220          indexTag = data.indexTag,
221          contentDescription = with(CommonUILabelProvider.inputIconRemoveLabel()) {
222            "$text ${data.label?.text.orEmpty()}".trim().toLabel(tag = tag)
223          },
224        )
225  
226      data is TextInputData.Password -> PasswordIconButton(
227        iconButtonTestTag = data.testTag?.let { tag -> tag + "PasswordIconButton" },
228        isPasswordVisible = isPasswordVisible,
229        isFocused = isFocused,
230        enabled = data.enabled,
231        context = context,
232        onClicked = {
233          changePasswordVisibility(!isPasswordVisible)
234          data.onPasswordVisibilityChanged(isPasswordVisible)
235        },
236        iconContentDescription = data.iconContentDescription,
237        indexTag = data.indexTag,
238      )
239    }
240  }
241  
242  @Composable
243  private fun Hint(data: TextInputData) {
244    with(data) {
245      if (value.text.isEmpty() && enabled && hint != null) {
246        CustomText(
247          testTag = testTag?.let { tag -> tag + "HintText" },
248          label = hint,
249          style = AppTheme.typography.bodyLargeRegular,
250          color = AppTheme.colors.neutral100,
251          focusable = false,
252        )
253      }
254    }
255  }
256  
257  @Composable
258  private fun Placeholder(data: TextInputData.Masked) {
259    with(data) {
260      if (value.text.isEmpty()) {
261        CustomText(
262          testTag = testTag?.let { tag -> tag + "PlaceholderText" },
263          label = data.maskType.getPlaceholderValue().takeIf { placeholder -> placeholder.isNotBlank() } ?: data.hint,
264          style = AppTheme.typography.bodyLargeRegular,
265          color = AppTheme.colors.neutral100,
266          focusable = false,
267        )
268      }
269    }
270  }
271  
272  @Composable
273  private fun SearchIcon(
274    iconTestTag: String?,
275    enabled: Boolean,
276  ) {
277    Row {
278      Icon(
279        data = IconData.Standard(
280          testTag = iconTestTag,
281          iconResId = R.drawable.ab002_search,
282          iconSize = IconSize.SIZE24,
283          iconColorProvider = {
284            when (enabled) {
285              true -> AppTheme.colors.neutral200
286              else -> AppTheme.colors.neutral60
287            }
288          },
289          contentDescription = Label.EMPTY,
290        ),
291      )
292      Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
293    }
294  }
295  
296  @OptIn(ExperimentalComposeUiApi::class)
297  @Composable
298  private fun RemoveIconButton(
299    iconButtonTestTag: String?,
300    context: Context,
301    enabled: Boolean,
302    onValueChanged: (String) -> Unit,
303    contentDescription: Label,
304    indexTag: Int? = null,
305  ) {
306    Icon(
307      modifier = Modifier
308        .semantics { testTagsAsResourceId = true }
309        .semantics {
310          testTag = iconButtonTestTag ?: getResourceEntryNameIcon(R.drawable.aa018_fail, context)
311            .let { tag -> "$tag${indexTag?.let { "_$indexTag" } ?: ""}" }
312        }
313        .clickable(
314          enabled = enabled,
315          role = Role.Button,
316          indication = null,
317          interactionSource = NoRippleInteractionSource(),
318          onClick = { onValueChanged("") },
319        ),
320      data = IconData.Standard(
321        testTag = iconButtonTestTag?.let { tag -> tag + "Icon" },
322        iconResId = R.drawable.aa018_fail,
323        iconSize = IconSize.SIZE24,
324        iconColorProvider = {
325          when (enabled) {
326            true -> AppTheme.colors.neutral200
327            else -> AppTheme.colors.neutral60
328          }
329        },
330        contentDescription = contentDescription,
331      ),
332    )
333  }
334  
335  @OptIn(ExperimentalComposeUiApi::class)
336  @Composable
337  private fun PasswordIconButton(
338    iconButtonTestTag: String?,
339    isPasswordVisible: Boolean,
340    isFocused: Boolean,
341    enabled: Boolean,
342    context: Context,
343    onClicked: () -> Unit,
344    iconContentDescription: TextInputData.Password.IconContentDescription,
345    indexTag: Int? = null,
346  ) {
347    val passwordVisibilityIcon = when (isPasswordVisible) {
348      true -> R.drawable.aa023_hide_password
349      else -> R.drawable.aa022_show_password
350    }
351    val contentDescription = when (isPasswordVisible) {
352      true -> iconContentDescription.whenPasswordVisible
353      false -> iconContentDescription.whenPasswordHidden
354    }
355    Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
356    Icon(
357      modifier = Modifier
358        .semantics {
359          when (isFocused) {
360            true -> {
361              testTagsAsResourceId = true
362              testTag = iconButtonTestTag ?: getResourceEntryNameIcon(passwordVisibilityIcon, context)
363                .let { tag -> "$tag${indexTag?.let { "_$$indexTag" } ?: ""}" }
364            }
365  
366            else -> invisibleToUser()
367          }
368        }
369        .clickable(
370          enabled = enabled,
371          role = Role.Button,
372          indication = null,
373          interactionSource = NoRippleInteractionSource(),
374          onClick = onClicked,
375        ),
376      data = IconData.Standard(
377        testTag = iconButtonTestTag?.let { tag -> tag + "Icon" },
378        iconResId = passwordVisibilityIcon,
379        iconSize = IconSize.SIZE24,
380        iconColorProvider = {
381          when (enabled) {
382            true -> AppTheme.colors.neutral200
383            else -> AppTheme.colors.neutral60
384          }
385        },
386        contentDescription = contentDescription,
387      ),
388    )
389  }
390  