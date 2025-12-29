1    package pl.gov.coi.common.ui.ds.button
2    
3    import android.annotation.SuppressLint
4    import androidx.compose.foundation.BorderStroke
5    import androidx.compose.foundation.interaction.MutableInteractionSource
6    import androidx.compose.foundation.interaction.collectIsFocusedAsState
7    import androidx.compose.foundation.layout.PaddingValues
8    import androidx.compose.foundation.layout.fillMaxWidth
9    import androidx.compose.foundation.layout.heightIn
10   import androidx.compose.foundation.layout.size
11   import androidx.compose.foundation.shape.CircleShape
12   import androidx.compose.material3.Button
13   import androidx.compose.material3.ButtonDefaults
14   import androidx.compose.material3.ExperimentalMaterial3Api
15   import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
16   import androidx.compose.runtime.Composable
17   import androidx.compose.runtime.CompositionLocalProvider
18   import androidx.compose.runtime.remember
19   import androidx.compose.ui.ExperimentalComposeUiApi
20   import androidx.compose.ui.Modifier
21   import androidx.compose.ui.graphics.Color
22   import androidx.compose.ui.platform.LocalContext
23   import androidx.compose.ui.platform.LocalFocusManager
24   import androidx.compose.ui.semantics.clearAndSetSemantics
25   import androidx.compose.ui.semantics.contentDescription
26   import androidx.compose.ui.semantics.semantics
27   import androidx.compose.ui.semantics.testTag
28   import androidx.compose.ui.semantics.testTagsAsResourceId
29   import androidx.compose.ui.text.style.TextAlign
30   import androidx.compose.ui.tooling.preview.Preview
31   import androidx.compose.ui.tooling.preview.PreviewParameter
32   import pl.gov.coi.common.ui.ds.button.common.ButtonSize
33   import pl.gov.coi.common.ui.ds.button.common.ButtonState
34   import pl.gov.coi.common.ui.ds.button.common.ButtonType
35   import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
36   import pl.gov.coi.common.ui.ds.custom.icon.Icon
37   import pl.gov.coi.common.ui.ds.custom.icon.IconData
38   import pl.gov.coi.common.ui.ds.custom.icon.IconSize
39   import pl.gov.coi.common.ui.text.CustomText
40   import pl.gov.coi.common.ui.theme.AppTheme
41   import pl.gov.coi.common.ui.utils.MultipleEventsCutter
42   import pl.gov.coi.common.ui.utils.defaultBorderFocus
43   import pl.gov.coi.common.ui.utils.get
44   import pl.gov.coi.common.ui.utils.getResourceEntryNameIcon
45   
46   
47   @SuppressLint("UnrememberedMutableInteractionSource")
48   @Composable
49   fun Button(data: ButtonData) {
50     val focusManager = LocalFocusManager.current
51     val multipleEventsCutter = remember { MultipleEventsCutter.get() }
52     val interactionSource = remember { MutableInteractionSource() }
53     val isFocused = interactionSource.collectIsFocusedAsState()
54   
55     val contentColor = getContentColor(
56       buttonState = data.buttonState,
57       buttonSize = data.buttonSize,
58       buttonVariant = data.buttonVariant,
59     )
60   
61     LayoutWithoutMinimumInteractiveComponentPadding {
62       Button(
63         modifier = getButtonTypeModifier(data)
64           .defaultBorderFocus(
65             isFocused = isFocused,
66             shape = getButtonShape(
67               buttonType = data.buttonType,
68               buttonSize = data.buttonSize,
69             ),
70           ),
71         shape = getButtonShape(
72           buttonType = data.buttonType,
73           buttonSize = data.buttonSize,
74         ),
75         interactionSource = interactionSource,
76         contentPadding = getPaddingValues(data),
77         colors = getButtonColors(data),
78         onClick = {
79           multipleEventsCutter.processEvent {
80             data.onClick()
81             focusManager.clearFocus(force = true)
82           }
83         },
84         border = getBorderStroke(data),
85         enabled = data.buttonState == ButtonState.Enabled || data.buttonState == ButtonState.Destructive,
86         elevation = ButtonDefaults.buttonElevation(
87           AppTheme.elevations.level0,
88           AppTheme.elevations.level0,
89           AppTheme.elevations.level0,
90           AppTheme.elevations.level0,
91           AppTheme.elevations.level0,
92         ),
93       ) {
94         when (data.buttonType) {
95           is ButtonType.WithIcon -> ButtonIcon(
96             testTag = data.testTag,
97             buttonType = data.buttonType,
98             color = contentColor,
99           )
100  
101          is ButtonType.WithText -> ButtonText(
102            testTag = data.testTag,
103            buttonSize = data.buttonSize,
104            buttonType = data.buttonType,
105            color = contentColor,
106          )
107        }
108      }
109    }
110  }
111  
112  @Composable
113  private fun getButtonColors(data: ButtonData) =
114    ButtonDefaults.buttonColors(
115      containerColor = getContainerColor(
116        buttonState = data.buttonState,
117        buttonSize = data.buttonSize,
118        buttonVariant = data.buttonVariant,
119      ),
120      contentColor = getContentColor(
121        buttonState = data.buttonState,
122        buttonSize = data.buttonSize,
123        buttonVariant = data.buttonVariant,
124      ),
125      disabledContainerColor = getContainerColor(
126        buttonState = data.buttonState,
127        buttonSize = data.buttonSize,
128        buttonVariant = data.buttonVariant,
129      ),
130      disabledContentColor = getContentColor(
131        buttonState = data.buttonState,
132        buttonSize = data.buttonSize,
133        buttonVariant = data.buttonVariant,
134      ),
135    )
136  
137  @Composable
138  private fun ButtonIcon(
139    testTag: String?,
140    buttonType: ButtonType.WithIcon,
141    color: Color,
142  ) {
143    val iconData = IconData.Standard(
144      testTag = testTag?.let { tag -> tag + "Icon" },
145      iconResId = buttonType.iconResId,
146      iconSize = IconSize.SIZE24,
147      iconColorProvider = { color },
148      contentDescription = buttonType.contentDescription,
149    )
150    Icon(data = iconData)
151  }
152  
153  @Composable
154  private fun ButtonText(
155    testTag: String?,
156    buttonSize: ButtonSize,
157    buttonType: ButtonType.WithText,
158    color: Color,
159  ) {
160    CustomText(
161      testTag = testTag?.let { tag -> tag + "Text" },
162      modifier = Modifier.clearAndSetSemantics {},
163      label = buttonType.label,
164      color = color,
165      textAlign = TextAlign.Center,
166      style = when (buttonSize) {
167        is ButtonSize.Large -> AppTheme.typography.bodyLargeMedium
168        ButtonSize.Small -> AppTheme.typography.bodyMediumMedium
169      },
170    )
171  }
172  
173  @Composable
174  private fun getButtonTypeModifier(data: ButtonData) = when (data.buttonType) {
175    is ButtonType.WithIcon -> getButtonWithIconModifier(buttonType = data.buttonType, buttonSize = data.buttonSize)
176    is ButtonType.WithText -> getButtonWithTextModifier(buttonType = data.buttonType, buttonSize = data.buttonSize)
177  }
178  
179  @Composable
180  private fun getPaddingValues(data: ButtonData) = when (data.buttonType) {
181    is ButtonType.WithIcon -> PaddingValues(all = AppTheme.dimensions.zero)
182    is ButtonType.WithText -> when (data.buttonSize) {
183      is ButtonSize.Large -> PaddingValues(
184        vertical = AppTheme.dimensions.spacing100,
185        horizontal = AppTheme.dimensions.spacing200,
186      )
187      ButtonSize.Small -> PaddingValues(
188        vertical = AppTheme.dimensions.spacing50,
189        horizontal = AppTheme.dimensions.spacing200,
190      )
191    }
192  }
193  
194  @Composable
195  private fun getBorderStroke(data: ButtonData) = when (data.buttonVariant) {
196    is ButtonVariant.Secondary -> BorderStroke(
197      width = AppTheme.dimensions.strokeWidth,
198      color = when (data.buttonState) {
199        ButtonState.Enabled -> getSecondaryEnabledButtonColor(data.buttonVariant)
200        ButtonState.Destructive -> AppTheme.colors.supportRed100
201        ButtonState.Disabled -> AppTheme.colors.neutral30
202      },
203    )
204    else -> null
205  }
206  
207  @Composable
208  private fun getContainerColor(
209    buttonSize: ButtonSize,
210    buttonVariant: ButtonVariant,
211    buttonState: ButtonState,
212  ): Color = when (buttonSize) {
213    is ButtonSize.Large -> when (buttonVariant) {
214      ButtonVariant.Primary -> when (buttonState) {
215        ButtonState.Enabled -> AppTheme.colors.primary900
216        ButtonState.Destructive -> AppTheme.colors.supportRed100
217        ButtonState.Disabled -> AppTheme.colors.neutral30
218      }
219      is ButtonVariant.Secondary -> Color.Transparent
220      ButtonVariant.Tertiary -> Color.Transparent
221    }
222    ButtonSize.Small -> when (buttonVariant) {
223      ButtonVariant.Primary -> when (buttonState) {
224        ButtonState.Enabled -> AppTheme.colors.secondary900
225        ButtonState.Destructive -> AppTheme.colors.supportRed20
226        ButtonState.Disabled -> AppTheme.colors.neutral30
227      }
228      is ButtonVariant.Secondary -> Color.Transparent
229      ButtonVariant.Tertiary -> Color.Transparent
230    }
231  }
232  
233  @Composable
234  private fun getContentColor(
235    buttonSize: ButtonSize,
236    buttonVariant: ButtonVariant,
237    buttonState: ButtonState,
238  ): Color = when (buttonSize) {
239    is ButtonSize.Large -> when (buttonVariant) {
240      ButtonVariant.Primary -> when (buttonState) {
241        ButtonState.Enabled -> AppTheme.colors.white
242        ButtonState.Destructive -> AppTheme.colors.white
243        ButtonState.Disabled -> AppTheme.colors.neutral60
244      }
245      is ButtonVariant.Secondary -> when (buttonState) {
246        ButtonState.Enabled -> getSecondaryEnabledButtonColor(buttonVariant)
247        ButtonState.Destructive -> getSecondaryDestructiveButtonColor(buttonVariant)
248        ButtonState.Disabled -> AppTheme.colors.neutral60
249      }
250      ButtonVariant.Tertiary -> when (buttonState) {
251        ButtonState.Enabled -> AppTheme.colors.primary900
252        ButtonState.Destructive -> AppTheme.colors.supportRed100
253        ButtonState.Disabled -> AppTheme.colors.neutral60
254      }
255    }
256    ButtonSize.Small -> when (buttonVariant) {
257      is ButtonVariant.Secondary -> when (buttonState) {
258        ButtonState.Enabled -> getSecondaryEnabledButtonColor(buttonVariant)
259        ButtonState.Destructive -> getSecondaryDestructiveButtonColor(buttonVariant)
260        ButtonState.Disabled -> AppTheme.colors.neutral60
261      }
262      else -> when (buttonState) {
263        ButtonState.Enabled -> AppTheme.colors.primary900
264        ButtonState.Destructive -> AppTheme.colors.supportRed100
265        ButtonState.Disabled -> AppTheme.colors.neutral60
266      }
267    }
268  }
269  
270  @Composable
271  private fun getSecondaryDestructiveButtonColor(buttonVariant: ButtonVariant.Secondary) =
272    if (buttonVariant.reversedColor) {
273      AppTheme.colors.white
274    } else {
275      AppTheme.colors.supportRed100
276    }
277  
278  @Composable
279  private fun getSecondaryEnabledButtonColor(buttonVariant: ButtonVariant.Secondary) =
280    if (buttonVariant.reversedColor) {
281      AppTheme.colors.white
282    } else {
283      AppTheme.colors.primary900
284    }
285  
286  @Composable
287  private fun getButtonWithIconSize(buttonSize: ButtonSize) = when (buttonSize) {
288    is ButtonSize.Large -> AppTheme.dimensions.spacing600
289    ButtonSize.Small -> AppTheme.dimensions.spacing400
290  }
291  
292  @Composable
293  private fun getButtonShape(buttonType: ButtonType, buttonSize: ButtonSize) = when (buttonType) {
294    is ButtonType.WithIcon -> CircleShape
295    is ButtonType.WithText -> when (buttonSize) {
296      is ButtonSize.Large -> AppTheme.shapes.radius300
297      ButtonSize.Small -> AppTheme.shapes.radius200
298    }
299  }
300  
301  @OptIn(ExperimentalComposeUiApi::class)
302  @Composable
303  private fun getButtonWithTextModifier(buttonType: ButtonType.WithText, buttonSize: ButtonSize) = when (buttonSize) {
304    is ButtonSize.Large ->
305      Modifier
306        .heightIn(min = AppTheme.dimensions.spacing600)
307        .semantics {
308          testTagsAsResourceId = true
309          testTag = buttonType.testTag ?: buttonType.label.tag
310          contentDescription = buttonType.contentDescription.takeIf { it.isNotEmpty() }?.text ?: buttonType.label.text
311        }
312        .then(
313          if (buttonSize.fillMaxWidth) {
314            Modifier.fillMaxWidth()
315          } else {
316            Modifier
317          },
318        )
319  
320    ButtonSize.Small ->
321      Modifier
322        .heightIn(min = AppTheme.dimensions.spacing400)
323        .semantics {
324          testTagsAsResourceId = true
325          testTag = buttonType.testTag ?: buttonType.label.tag
326          contentDescription = buttonType.contentDescription.takeIf { it.isNotEmpty() }?.text ?: buttonType.label.text
327        }
328  }
329  
330  @Composable
331  private fun getButtonWithIconModifier(buttonType: ButtonType.WithIcon, buttonSize: ButtonSize): Modifier {
332    val localContext = LocalContext.current
333    return Modifier
334      .size(size = getButtonWithIconSize(buttonSize))
335      .semantics {
336        testTag = buttonType.testTag ?: getResourceEntryNameIcon(buttonType.iconResId, localContext)
337        contentDescription = buttonType.contentDescription.text
338      }
339  }
340  
341  @OptIn(ExperimentalMaterial3Api::class)
342  @Composable
343  private fun LayoutWithoutMinimumInteractiveComponentPadding(content: @Composable () -> Unit) {
344    CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
345      content()
346    }
347  }
348  
349  @Preview
350  @Composable
351  fun ButtonPreview(@PreviewParameter(ButtonPPP::class) buttonData: ButtonData) {
352    Button(data = buttonData)
353  }
354  