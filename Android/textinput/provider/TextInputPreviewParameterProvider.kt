1    package pl.gov.coi.common.ui.ds.textinput.provider
2    
3    import pl.gov.coi.common.domain.label.Label
4    import pl.gov.coi.common.domain.validators.ValidationState
5    import pl.gov.coi.common.ui.ds.button.buttontext.ButtonTextData
6    import pl.gov.coi.common.ui.ds.textinput.model.TextInputData
7    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
8    import pl.gov.coi.common.ui.preview.ScreenShotTestData
9    
10   class TextInputPreviewParameterProvider : CustomPreviewParameterProvider<TextInputData>() {
11   
12     override val screenShotTestValues: Sequence<ScreenShotTestData<TextInputData>> = sequenceOf(
13       ScreenShotTestData(
14         screenShotTestName = "TextInputText",
15         value = provideTextInputText(),
16       ),
17       ScreenShotTestData(
18         screenShotTestName = "TextInputTextWithOptionals",
19         value = provideTextInputTextWithOptionals(),
20       ),
21       ScreenShotTestData(
22         screenShotTestName = "TextInputTextError",
23         value = provideTextInputTextError(),
24       ),
25       ScreenShotTestData(
26         screenShotTestName = "TextInputTextDisabled",
27         value = provideTextInputTextDisabled(),
28       ),
29       ScreenShotTestData(
30         screenShotTestName = "TextInputNumber",
31         value = provideTextInputNumber(),
32       ),
33       ScreenShotTestData(
34         screenShotTestName = "TextInputPassword",
35         value = provideTextInputPassword(),
36       ),
37       ScreenShotTestData(
38         screenShotTestName = "TextInputSearch",
39         value = provideTextInputSearch(),
40       ),
41       ScreenShotTestData(
42         screenShotTestName = "TextInputPin",
43         value = provideTextInputPin(),
44       ),
45       ScreenShotTestData(
46         screenShotTestName = "TextInputPinError",
47         value = provideTextInputPinError(),
48       ),
49       ScreenShotTestData(
50         screenShotTestName = "TextInputPinDisabled",
51         value = provideTextInputPinDisabled(),
52       ),
53       ScreenShotTestData(
54         screenShotTestName = "TextInputPhoneNumberFilled",
55         value = provideTextInputPhoneNumberFilled(),
56       ),
57       ScreenShotTestData(
58         screenShotTestName = "TextInputPhoneNumberInvalidNumber",
59         value = provideTextInputPhoneNumberInvalidNumber(),
60       ),
61       ScreenShotTestData(
62         screenShotTestName = "TextInputPhoneNumberInvalidPrefix",
63         value = provideTextInputPhoneNumberInvalidCountryCode(),
64       ),
65       ScreenShotTestData(
66         screenShotTestName = "TextInputPhoneNumberLong",
67         value = provideTextInputPhoneNumberLong(),
68       ),
69       ScreenShotTestData(
70         screenShotTestName = "TextInputSearchLong",
71         value = provideTextInputSearchLong(),
72       ),
73     )
74   
75     private fun provideTextInputText() = TextInputData.Text(
76       label = "Etykieta".toLabel(),
77       value = Label.EMPTY,
78       onValueChanged = {},
79     )
80   
81     private fun provideTextInputTextWithOptionals() = TextInputData.Text(
82       label = "Etykieta".toLabel(),
83       hint = "Tekst zastępczy (hint)".toLabel(),
84       value = Label.EMPTY,
85       helperText = "Tekst pomocniczy (helper text)".toLabel(),
86       infoButtonData = ButtonTextData(
87         label = "Info button".toLabel(),
88         onClick = {},
89       ),
90       onValueChanged = {},
91     )
92   
93     private fun provideTextInputTextError() = TextInputData.Text(
94       label = "Etykieta".toLabel(),
95       hint = "Tekst zastępczy (hint)".toLabel(),
96       value = Label.EMPTY,
97       validationState = ValidationState.Invalid(
98         message = "Tekst błędu".toLabel(),
99       ),
100      helperText = null,
101      infoButtonData = null,
102      onValueChanged = {},
103    )
104  
105    private fun provideTextInputTextDisabled() = TextInputData.Text(
106      label = "Etykieta".toLabel(),
107      hint = "Tekst zastępczy (hint)".toLabel(),
108      value = Label.EMPTY,
109      helperText = "Tekst pomocniczy (helper text)".toLabel(),
110      infoButtonData = null,
111      enabled = false,
112      onValueChanged = {},
113    )
114  
115    private fun provideTextInputNumber() = TextInputData.Number(
116      label = "Etykieta".toLabel(),
117      hint = "Tekst zastępczy (hint)".toLabel(),
118      value = "1234".toLabel(),
119      onValueChanged = {},
120    )
121  
122    private fun provideTextInputPassword() = TextInputData.Password(
123      label = "Hasło".toLabel(),
124      value = "123".toLabel(),
125      onValueChanged = {},
126    )
127  
128    private fun provideTextInputSearch() = TextInputData.Search(
129      hint = "Wyszukaj (hint)".toLabel(),
130      value = Label.EMPTY,
131      onValueChanged = {},
132    )
133  
134    private fun provideTextInputPin() = TextInputData.Pin(
135      label = "Etykieta".toLabel(),
136      value = "123".toLabel(),
137      onValueChanged = {},
138    )
139  
140    private fun provideTextInputPinError() = TextInputData.Pin(
141      label = "Etykieta".toLabel(),
142      value = "1234".toLabel(),
143      validationState = ValidationState.Invalid(
144        message = "Tekst błędu".toLabel(),
145      ),
146      onValueChanged = {},
147    )
148  
149    private fun provideTextInputPinDisabled() = TextInputData.Pin(
150      label = "Etykieta".toLabel(),
151      value = "1234".toLabel(),
152      enabled = false,
153      onValueChanged = {},
154    )
155  
156    private fun provideTextInputPhoneNumberFilled() = TextInputData.PhoneNumber(
157      label = "Numer telefonu".toLabel(),
158      countryCodeValue = "+48".toLabel(),
159      phoneNumberValue = "123456789".toLabel(),
160      onCountryCodeChanged = {},
161      onPhoneNumberChanged = {},
162      isCountryCodeCorrect = null,
163      isPhoneNumberCorrect = null,
164      validationState = ValidationState.Default,
165    )
166  
167    private fun provideTextInputPhoneNumberInvalidNumber() = TextInputData.PhoneNumber(
168      label = "Numer telefonu".toLabel(),
169      countryCodeValue = "+48".toLabel(),
170      phoneNumberValue = "12345".toLabel(),
171      onCountryCodeChanged = {},
172      onPhoneNumberChanged = {},
173      isCountryCodeCorrect = null,
174      isPhoneNumberCorrect = false,
175      validationState = ValidationState.Invalid(message = "Niepoprawny numer".toLabel()),
176    )
177  
178    private fun provideTextInputPhoneNumberInvalidCountryCode() = TextInputData.PhoneNumber(
179      label = "Numer telefonu".toLabel(),
180      countryCodeValue = "+48".toLabel(),
181      phoneNumberValue = "12345".toLabel(),
182      onCountryCodeChanged = {},
183      onPhoneNumberChanged = {},
184      isCountryCodeCorrect = false,
185      isPhoneNumberCorrect = true,
186      validationState = ValidationState.Invalid(message = "Niepoprawny prefix".toLabel()),
187    )
188  
189    private fun provideTextInputPhoneNumberLong() = TextInputData.PhoneNumber(
190      label = "Numer telefonu".toLabel(),
191      countryCodeValue = "+48".toLabel(),
192      phoneNumberValue = "123456789123456789123456789".toLabel(),
193      onCountryCodeChanged = {},
194      onPhoneNumberChanged = {},
195      isCountryCodeCorrect = null,
196      isPhoneNumberCorrect = null,
197      validationState = ValidationState.Default,
198    )
199  
200    private fun provideTextInputSearchLong() = TextInputData.Search(
201      hint = "Wyszukaj (hint)".toLabel(),
202      value = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt.".toLabel(),
203      onValueChanged = {},
204    )
205  }
206  