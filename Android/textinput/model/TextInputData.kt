1    package pl.gov.coi.common.ui.ds.textinput.model
2    
3    import androidx.compose.foundation.text.KeyboardActions
4    import androidx.compose.ui.focus.FocusManager
5    import androidx.compose.ui.text.input.ImeAction
6    import androidx.compose.ui.text.input.KeyboardType
7    import androidx.compose.ui.text.style.TextAlign
8    import pl.gov.coi.common.domain.label.CommonUILabelProvider
9    import pl.gov.coi.common.domain.label.Label
10   import pl.gov.coi.common.domain.validators.ValidationState
11   import pl.gov.coi.common.ui.ds.button.buttontext.ButtonTextData
12   import pl.gov.coi.common.ui.ds.textinput.visualtransformation.MaskType
13   
14   sealed class TextInputData(
15     open val testTag: String?,
16     open val label: Label?,
17     open val value: Label = Label.EMPTY,
18     open val hint: Label?,
19     open val validationState: ValidationState,
20     open val helperText: Label?,
21     open val infoButtonData: ButtonTextData?,
22     open val onValueChanged: (String) -> Unit,
23     open val enabled: Boolean,
24     open val imeAction: ImeAction,
25     open val keyboardAction: (FocusManager) -> KeyboardActions,
26     open val singleLine: Boolean,
27     open val textAlign: TextAlign? = null,
28     open val removableIconVisible: Boolean,
29     open val indexTag: Int? = null,
30   ) {
31   
32     abstract val keyboardType: KeyboardType
33   
34     data class Text(
35       override val testTag: String? = null,
36       override val label: Label? = null,
37       override val hint: Label? = null,
38       override val value: Label,
39       override val validationState: ValidationState = ValidationState.Default,
40       override val helperText: Label? = null,
41       override val infoButtonData: ButtonTextData? = null,
42       override val onValueChanged: (String) -> Unit,
43       override val enabled: Boolean = true,
44       override val imeAction: ImeAction = ImeAction.Done,
45       override val keyboardAction: (FocusManager) -> KeyboardActions = { KeyboardActions.Default },
46       override val singleLine: Boolean = true,
47       override val textAlign: TextAlign? = null,
48       override val removableIconVisible: Boolean = true,
49       override val indexTag: Int? = null,
50     ) : TextInputData(
51       testTag = testTag,
52       label = label,
53       value = value,
54       hint = hint,
55       validationState = validationState,
56       helperText = helperText,
57       infoButtonData = infoButtonData,
58       onValueChanged = onValueChanged,
59       enabled = enabled,
60       imeAction = imeAction,
61       singleLine = singleLine,
62       textAlign = textAlign,
63       removableIconVisible = removableIconVisible,
64       indexTag = indexTag,
65       keyboardAction = keyboardAction,
66     ) {
67       override val keyboardType: KeyboardType = KeyboardType.Text
68     }
69   
70     data class Number(
71       override val testTag: String? = null,
72       override val label: Label? = null,
73       override val hint: Label? = null,
74       override val value: Label,
75       override val validationState: ValidationState = ValidationState.Default,
76       override val helperText: Label? = null,
77       override val infoButtonData: ButtonTextData? = null,
78       override val onValueChanged: (String) -> Unit,
79       override val enabled: Boolean = true,
80       override val imeAction: ImeAction = ImeAction.Done,
81       override val keyboardAction: (FocusManager) -> KeyboardActions = { KeyboardActions.Default },
82       override val singleLine: Boolean = true,
83       override val textAlign: TextAlign? = null,
84       override val removableIconVisible: Boolean = true,
85       override val indexTag: Int? = null,
86       val isPhoneNumberPrefix: Boolean = false,
87     ) : TextInputData(
88       testTag = testTag,
89       label = label,
90       value = value,
91       hint = hint,
92       validationState = validationState,
93       helperText = helperText,
94       infoButtonData = infoButtonData,
95       onValueChanged = onValueChanged,
96       enabled = enabled,
97       imeAction = imeAction,
98       singleLine = singleLine,
99       textAlign = textAlign,
100      removableIconVisible = removableIconVisible,
101      indexTag = indexTag,
102      keyboardAction = keyboardAction,
103    ) {
104      override val keyboardType: KeyboardType = when (isPhoneNumberPrefix) {
105        true -> KeyboardType.Phone
106        false -> KeyboardType.Number
107      }
108    }
109  
110    data class Password(
111      override val testTag: String? = null,
112      override val label: Label? = null,
113      override val hint: Label? = null,
114      override val value: Label,
115      override val validationState: ValidationState = ValidationState.Default,
116      override val helperText: Label? = null,
117      override val infoButtonData: ButtonTextData? = null,
118      override val onValueChanged: (String) -> Unit,
119      override val enabled: Boolean = true,
120      override val imeAction: ImeAction = ImeAction.Done,
121      override val keyboardAction: (FocusManager) -> KeyboardActions = { KeyboardActions.Default },
122      override val singleLine: Boolean = true,
123      override val textAlign: TextAlign? = null,
124      override val removableIconVisible: Boolean = false,
125      override val keyboardType: KeyboardType = KeyboardType.Password,
126      val iconContentDescription: IconContentDescription = IconContentDescription(),
127      val onPasswordVisibilityChanged: (Boolean) -> Unit = {},
128    ) : TextInputData(
129      testTag = testTag,
130      label = label,
131      value = value,
132      hint = hint,
133      validationState = validationState,
134      helperText = helperText,
135      infoButtonData = infoButtonData,
136      onValueChanged = onValueChanged,
137      enabled = enabled,
138      imeAction = imeAction,
139      singleLine = singleLine,
140      textAlign = textAlign,
141      removableIconVisible = removableIconVisible,
142      keyboardAction = keyboardAction,
143    ) {
144      data class IconContentDescription(
145        val whenPasswordVisible: Label = CommonUILabelProvider.inputIconHidePasswordLabel(),
146        val whenPasswordHidden: Label = CommonUILabelProvider.inputIconShowPasswordLabel(),
147      )
148    }
149  
150    data class Search(
151      override val testTag: String? = null,
152      override val label: Label? = null,
153      override val hint: Label? = null,
154      override val value: Label,
155      override val validationState: ValidationState = ValidationState.Default,
156      override val helperText: Label? = null,
157      override val infoButtonData: ButtonTextData? = null,
158      override val onValueChanged: (String) -> Unit,
159      override val enabled: Boolean = true,
160      override val imeAction: ImeAction = ImeAction.Done,
161      override val keyboardAction: (FocusManager) -> KeyboardActions = { KeyboardActions.Default },
162      override val singleLine: Boolean = true,
163      override val textAlign: TextAlign? = null,
164      override val removableIconVisible: Boolean = false,
165      override val indexTag: Int? = null,
166    ) : TextInputData(
167      testTag = testTag,
168      label = label,
169      value = value,
170      hint = hint,
171      validationState = validationState,
172      helperText = helperText,
173      infoButtonData = infoButtonData,
174      onValueChanged = onValueChanged,
175      enabled = enabled,
176      imeAction = imeAction,
177      singleLine = singleLine,
178      textAlign = textAlign,
179      removableIconVisible = removableIconVisible,
180      indexTag = indexTag,
181      keyboardAction = keyboardAction,
182    ) {
183      override val keyboardType: KeyboardType = KeyboardType.Text
184    }
185  
186    data class Pin(
187      override val testTag: String? = null,
188      override val label: Label? = null,
189      override val value: Label,
190      override val validationState: ValidationState = ValidationState.Default,
191      override val helperText: Label? = null,
192      override val infoButtonData: ButtonTextData? = null,
193      override val onValueChanged: (String) -> Unit,
194      override val enabled: Boolean = true,
195      override val imeAction: ImeAction = ImeAction.Done,
196      override val keyboardAction: (FocusManager) -> KeyboardActions = { KeyboardActions.Default },
197      override val singleLine: Boolean = true,
198      override val textAlign: TextAlign? = null,
199      override val removableIconVisible: Boolean = false,
200      val length: Int = PIN_LENGTH_DEFAULT_VALUE,
201    ) : TextInputData(
202      testTag = testTag,
203      label = label,
204      value = value,
205      hint = null,
206      validationState = validationState,
207      helperText = helperText,
208      infoButtonData = infoButtonData,
209      onValueChanged = onValueChanged,
210      enabled = enabled,
211      imeAction = imeAction,
212      singleLine = singleLine,
213      textAlign = textAlign,
214      removableIconVisible = removableIconVisible,
215      keyboardAction = keyboardAction,
216    ) {
217      override val keyboardType: KeyboardType = KeyboardType.NumberPassword
218    }
219  
220    data class Masked(
221      override val testTag: String? = null,
222      override val label: Label? = null,
223      override val value: Label,
224      override val hint: Label? = null,
225      override val validationState: ValidationState = ValidationState.Default,
226      override val helperText: Label? = null,
227      override val infoButtonData: ButtonTextData? = null,
228      override val onValueChanged: (String) -> Unit,
229      override val enabled: Boolean = true,
230      override val imeAction: ImeAction = ImeAction.Done,
231      override val keyboardAction: (FocusManager) -> KeyboardActions = { KeyboardActions.Default },
232      override val singleLine: Boolean = true,
233      override val textAlign: TextAlign? = null,
234      override val removableIconVisible: Boolean = true,
235      override val indexTag: Int? = null,
236      val maskType: MaskType,
237      override val keyboardType: KeyboardType = KeyboardType.Text,
238    ) : TextInputData(
239      testTag = testTag,
240      label = label,
241      value = value,
242      hint = null,
243      validationState = validationState,
244      helperText = helperText,
245      infoButtonData = infoButtonData,
246      onValueChanged = onValueChanged,
247      enabled = enabled,
248      imeAction = imeAction,
249      singleLine = singleLine,
250      textAlign = textAlign,
251      removableIconVisible = removableIconVisible,
252      indexTag = indexTag,
253      keyboardAction = keyboardAction,
254    )
255  
256    data class PhoneNumber(
257      override val testTag: String? = null,
258      override val label: Label?,
259      override val validationState: ValidationState = ValidationState.Default,
260      val countryCodeValue: Label?,
261      val phoneNumberValue: Label?,
262      val onCountryCodeChanged: (String) -> Unit,
263      val onPhoneNumberChanged: (String) -> Unit,
264      val isCountryCodeCorrect: Boolean? = null,
265      val isPhoneNumberCorrect: Boolean? = null,
266      val countryCodeTextAlign: TextAlign = TextAlign.Center,
267      val phoneNumberTextAlign: TextAlign? = null,
268      override val imeAction: ImeAction = ImeAction.Done,
269      override val indexTag: Int? = null,
270    ) : TextInputData(
271      testTag = testTag,
272      label = label,
273      value = Label.EMPTY,
274      hint = null,
275      validationState = validationState,
276      helperText = null,
277      infoButtonData = null,
278      onValueChanged = {},
279      enabled = true,
280      imeAction = imeAction,
281      singleLine = true,
282      textAlign = null,
283      removableIconVisible = false,
284      keyboardAction = { KeyboardActions.Default },
285    ) {
286      override val keyboardType: KeyboardType = KeyboardType.Phone
287  
288      val countryCodeNumber = Number(
289        testTag = testTag?.let { tag -> tag + "CountryCodeText" },
290        label = label?.addToTag(addStringToTag = COUNTRY_CODE_SUFFIX),
291        indexTag = indexTag,
292        hint = null,
293        value = countryCodeValue ?: Label.EMPTY,
294        onValueChanged = onCountryCodeChanged,
295        validationState = when (isCountryCodeCorrect) {
296          true -> ValidationState.Valid
297          false -> ValidationState.Invalid(message = Label.EMPTY)
298          null -> ValidationState.Default
299        },
300        isPhoneNumberPrefix = true,
301        removableIconVisible = false,
302        textAlign = countryCodeTextAlign,
303        imeAction = ImeAction.Next,
304      )
305  
306      val phoneNumber = Number(
307        testTag = testTag?.let { tag -> tag + "PhoneNumberText" },
308        label = label?.addToTag(addStringToTag = PHONE_NUMBER_SUFFIX),
309        indexTag = indexTag,
310        value = phoneNumberValue ?: Label.EMPTY,
311        onValueChanged = onPhoneNumberChanged,
312        validationState = when (isPhoneNumberCorrect) {
313          true -> ValidationState.Valid
314          false -> ValidationState.Invalid(message = Label.EMPTY)
315          null -> ValidationState.Default
316        },
317        textAlign = phoneNumberTextAlign,
318        imeAction = imeAction,
319      )
320    }
321  }
322  
323  private const val PIN_LENGTH_DEFAULT_VALUE = 4
324  private const val COUNTRY_CODE_SUFFIX = "_CountryCode"
325  private const val PHONE_NUMBER_SUFFIX = "_PhoneNumber"
326  