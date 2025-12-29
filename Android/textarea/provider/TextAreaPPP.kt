1    package pl.gov.coi.common.ui.ds.textarea.provider
2    
3    import pl.gov.coi.common.ui.ds.textarea.CounterState
4    import pl.gov.coi.common.ui.ds.textarea.TextAreaData
5    import pl.gov.coi.common.ui.ds.textarea.TextAreaDataState
6    import pl.gov.coi.common.ui.ds.textarea.TextAreaType
7    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
8    import pl.gov.coi.common.ui.preview.ScreenShotTestData
9    
10   class TextAreaPPP : CustomPreviewParameterProvider<TextAreaData>() {
11     override val screenShotTestValues: Sequence<ScreenShotTestData<TextAreaData>> = sequenceOf(
12       ScreenShotTestData(
13         screenShotTestName = "FlexibleEmpty",
14         value = TextAreaData(
15           type = TextAreaType.Flexible(),
16           hint = "Flexible text area - hint".toLabel(),
17           counterState = CounterState.Hidden,
18           onValueChanged = {},
19           state = TextAreaDataState.Default(),
20         ),
21       ),
22       ScreenShotTestData(
23         screenShotTestName = "FlexibleWithCounterAndLabel",
24         value = TextAreaData(
25           label = "Flexible - WithCounterAndLabel".toLabel(),
26           type = TextAreaType.Flexible(),
27           state = TextAreaDataState.Default(),
28           hint = "Flexible text area - hint".toLabel(),
29           counterState = CounterState.Visible(
30             maxLength = 400,
31             onCharsLimitReached = {},
32           ),
33           onValueChanged = {},
34         ),
35       ),
36       ScreenShotTestData(
37         screenShotTestName = "FlexibleWithLabel",
38         value = TextAreaData(
39           label = "Flexible - WithLabel".toLabel(),
40           type = TextAreaType.Flexible(),
41           state = TextAreaDataState.Default(),
42           hint = "Flexible text area - hint".toLabel(),
43           counterState = CounterState.Hidden,
44           onValueChanged = {},
45         ),
46       ),
47       ScreenShotTestData(
48         screenShotTestName = "FlexibleWithCounterLabelAndHelper",
49         value = TextAreaData(
50           label = "Flexible - WithCounterLabelAndHelper".toLabel(),
51           type = TextAreaType.Flexible(),
52           state = TextAreaDataState.Default(helperLabel = "HelperText".toLabel()),
53           hint = "Flexible text area - hint".toLabel(),
54           counterState = CounterState.Hidden,
55           onValueChanged = {},
56         ),
57       ),
58       ScreenShotTestData(
59         screenShotTestName = "FlexibleWithCounterLabelAndHelperDisabled",
60         value = TextAreaData(
61           label = "Flexible - FlexibleWithCounterLabelAndHelperDisabled".toLabel(),
62           type = TextAreaType.Flexible(),
63           enabled = false,
64           state = TextAreaDataState.Default(helperLabel = "HelperText".toLabel()),
65           hint = "Flexible text area - hint".toLabel(),
66           counterState = CounterState.Visible(
67             maxLength = 200,
68           ),
69           onValueChanged = {},
70         ),
71       ),
72       ScreenShotTestData(
73         screenShotTestName = "FlexibleWithCounterAndContentDisabled",
74         value = TextAreaData(
75           label = "Flexible - FlexibleWithCounterAndContentDisabled".toLabel(),
76           type = TextAreaType.Flexible(maxLines = 6),
77           enabled = false,
78           state = TextAreaDataState.Default(),
79           counterState = CounterState.Visible(
80             maxLength = 255,
81           ),
82           onValueChanged = {},
83           content = "TextArea content",
84         ),
85       ),
86       ScreenShotTestData(
87         screenShotTestName = "FlexibleWithCounterLabelAndInvalid",
88         value = TextAreaData(
89           label = "Flexible - WithCounterLabelAndInvalid".toLabel(),
90           type = TextAreaType.Flexible(),
91           state = TextAreaDataState.Default(helperLabel = "HelperText".toLabel()),
92           hint = "Flexible text area - hint".toLabel(),
93           counterState = CounterState.Visible(
94             maxLength = 400,
95             onCharsLimitReached = {},
96           ),
97           onValueChanged = {},
98         ),
99       ),
100      ScreenShotTestData(
101        screenShotTestName = "FixWithCounterLabelAndHelper",
102        value = TextAreaData(
103          label = "Fix - WithCounterLabelAndHelper".toLabel(),
104          type = TextAreaType.Fix(),
105          state = TextAreaDataState.Default(helperLabel = "HelperText".toLabel()),
106          hint = "Fix text area - hint".toLabel(),
107          counterState = CounterState.Hidden,
108          onValueChanged = {},
109        ),
110      ),
111      ScreenShotTestData(
112        screenShotTestName = "FixEmpty",
113        value = TextAreaData(
114          label = "Fix - FixEmpty".toLabel(),
115          type = TextAreaType.Fix(),
116          state = TextAreaDataState.Default(helperLabel = "HelperText".toLabel()),
117          hint = "Fix text area - hint".toLabel(),
118          counterState = CounterState.Hidden,
119          onValueChanged = {},
120        ),
121      ),
122      ScreenShotTestData(
123        screenShotTestName = "FixWithCounterLabelAndInvalid",
124        value = TextAreaData(
125          label = "Fix - WithCounterLabelAndInvalid".toLabel(),
126          type = TextAreaType.Flexible(),
127          state = TextAreaDataState.Error(errorLabel = "Invalid Fix".toLabel()),
128          hint = "Flexible text area - hint".toLabel(),
129          counterState = CounterState.Visible(
130            maxLength = 400,
131            onCharsLimitReached = {},
132          ),
133          onValueChanged = {},
134        ),
135      ),
136    )
137  }
138  