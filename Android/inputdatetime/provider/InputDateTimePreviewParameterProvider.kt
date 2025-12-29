1    package pl.gov.coi.common.ui.ds.inputdatetime.provider
2    
3    import pl.gov.coi.common.domain.label.toLabel
4    import pl.gov.coi.common.domain.validators.ValidationState
5    import pl.gov.coi.common.ui.ds.inputdatetime.InputDateTimeData
6    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
7    import pl.gov.coi.common.ui.preview.ScreenShotTestData
8    
9    class InputDateTimePreviewParameterProvider : CustomPreviewParameterProvider<InputDateTimeData>() {
10     override val screenShotTestValues: Sequence<ScreenShotTestData<InputDateTimeData>> = sequenceOf(
11       ScreenShotTestData(
12         screenShotTestName = "InputDateEnabledPlaceholder",
13         value = provideInputDateEnabledPlaceholderPreviewData(),
14       ),
15       ScreenShotTestData(
16         screenShotTestName = "InputDateEnabledSelectedDate",
17         value = provideInputDateEnabledSelectedDatePreviewData(),
18       ),
19       ScreenShotTestData(
20         screenShotTestName = "InputDateErrorPlaceholder",
21         value = provideInputDateErrorPlaceholderPreviewData(),
22       ),
23       ScreenShotTestData(
24         screenShotTestName = "InputDateErrorSelectedDate",
25         value = provideInputDateErrorSelectedDatePreviewData(),
26       ),
27       ScreenShotTestData(
28         screenShotTestName = "InputDateErrorLongMessage",
29         value = provideInputDateErrorLongMessagePreviewData(),
30       ),
31       ScreenShotTestData(
32         screenShotTestName = "InputDateDisabledPlaceholder",
33         value = provideInputDateDisabledPlaceholderPreviewData(),
34       ),
35       ScreenShotTestData(
36         screenShotTestName = "InputDateDisabledSelectedDate",
37         value = provideInputDateDisabledSelectedDatePreviewData(),
38       ),
39     )
40   }
41   
42   fun provideInputDateEnabledPlaceholderPreviewData() =
43     InputDateTimeData(
44       label = "Label".toLabel(""),
45       helperText = "Helper text.".toLabel(""),
46       type = InputDateTimeData.Type.Date,
47       onClick = {},
48     )
49   
50   fun provideInputDateEnabledSelectedDatePreviewData() =
51     InputDateTimeData(
52       inputText = "29.04.2024",
53       label = "Label".toLabel(""),
54       type = InputDateTimeData.Type.Date,
55       helperText = "Helper text.".toLabel(""),
56       onClick = {},
57     )
58   
59   fun provideInputDateErrorPlaceholderPreviewData() =
60     InputDateTimeData(
61       label = "Label".toLabel(""),
62       helperText = "Helper text.".toLabel(""),
63       type = InputDateTimeData.Type.Date,
64       validationState = ValidationState.Invalid(
65         message = "Error text.".toLabel(""),
66       ),
67       onClick = {},
68     )
69   
70   fun provideInputDateErrorSelectedDatePreviewData() =
71     InputDateTimeData(
72       inputText = "29.04.2024",
73       label = "Label".toLabel(""),
74       type = InputDateTimeData.Type.Date,
75       helperText = "Helper text.".toLabel(""),
76       validationState = ValidationState.Invalid(
77         message = "Error text.".toLabel(""),
78       ),
79       onClick = {},
80     )
81   
82   fun provideInputDateErrorLongMessagePreviewData() =
83     InputDateTimeData(
84       inputText = "29.04.2024",
85       label = "Label".toLabel(""),
86       type = InputDateTimeData.Type.Date,
87       helperText = "Helper text.".toLabel(""),
88       validationState = ValidationState.Invalid(
89         message = ("Podczas walidacji tekst pomocniczy zostaje zastąpiony tekstem błędu (komponent validation error). " +
90           "Validation error dla komunikatu o długości powyżej jednej linii.").toLabel(""),
91       ),
92       onClick = {},
93     )
94   
95   fun provideInputDateDisabledPlaceholderPreviewData() =
96     InputDateTimeData(
97       label = "Label".toLabel(""),
98       type = InputDateTimeData.Type.Date,
99       helperText = "Helper text.".toLabel(""),
100      enabled = false,
101      onClick = {},
102    )
103  
104  fun provideInputDateDisabledSelectedDatePreviewData() =
105    InputDateTimeData(
106      inputText = "29.04.2024",
107      label = "Label".toLabel(""),
108      type = InputDateTimeData.Type.Date,
109      helperText = "Helper text.".toLabel(""),
110      enabled = false,
111      onClick = {},
112    )
113  