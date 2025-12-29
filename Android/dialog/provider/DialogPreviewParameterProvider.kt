1    package pl.gov.coi.common.ui.ds.dialog.provider
2    
3    import androidx.compose.runtime.Composable
4    import androidx.compose.ui.text.buildAnnotatedString
5    import androidx.compose.ui.text.font.FontWeight
6    import pl.gov.coi.common.ui.R
7    import pl.gov.coi.common.ui.ds.button.ButtonData
8    import pl.gov.coi.common.ui.ds.button.common.ButtonSize
9    import pl.gov.coi.common.ui.ds.button.common.ButtonState
10   import pl.gov.coi.common.ui.ds.button.common.ButtonType
11   import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
12   import pl.gov.coi.common.ui.ds.dialog.DialogData
13   import pl.gov.coi.common.ui.ds.dialog.DialogIconData
14   import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
15   import pl.gov.coi.common.ui.preview.ScreenShotTestData
16   import pl.gov.coi.common.ui.theme.AppTheme
17   import pl.gov.coi.common.ui.theme.withStyle
18   
19   class DialogPreviewParameterProvider() : CustomPreviewParameterProvider<DialogData>() {
20     override val screenShotTestValues: Sequence<ScreenShotTestData<DialogData>> = sequenceOf(
21       ScreenShotTestData(
22         screenShotTestName = "DialogLongTextOneButton",
23         value = provideDialogLongTextOneButton(),
24       ),
25       ScreenShotTestData(
26         screenShotTestName = "DialogLongTextTwoButtons",
27         value = provideDialogLongTextTwoButtons(),
28       ),
29       ScreenShotTestData(
30         screenShotTestName = "DialogLongTextThreeButtons",
31         value = provideDialogLongTextThreeButtons(),
32       ),
33       ScreenShotTestData(
34         screenShotTestName = "DialogOnlyTitleOneButton",
35         value = provideDialogOnlyTitleOneButton(),
36       ),
37       ScreenShotTestData(
38         screenShotTestName = "DialogShortTextColoredButton",
39         value = provideDialogShortTextColoredButton(),
40       ),
41       ScreenShotTestData(
42         screenShotTestName = "DialogShortTextWithIcon",
43         value = provideDialogShortTextWithIcon(),
44       ),
45       ScreenShotTestData(
46         screenShotTestName = "DialogHighlightedTextTwoButtons",
47         value = provideDialogHighlightedTextTwoButtons(),
48       ),
49     )
50   
51     private fun provideLongText() =
52       "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laoreet. " +
53         "Proin gravida dolor sit amet lacus accumsan et viverra justo commodo. Proin sodales pulvinar tempor. " +
54         "Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus."
55   
56     private fun provideDialogLongTextOneButton() =
57       DialogData.WithText(
58         title = "Dialog Title".toLabel(),
59         body = provideLongText().toLabel(),
60         primaryButtonData =
61         ButtonData(
62           buttonVariant = ButtonVariant.Tertiary,
63           buttonType = ButtonType.WithText(
64             label = "Primary button".toLabel(),
65           ),
66           buttonSize = ButtonSize.Small,
67           onClick = {},
68         ),
69       ) {}
70   
71     private fun provideDialogLongTextTwoButtons() = provideDialogLongTextOneButton().copy(
72       secondaryButtonData = ButtonData(
73         buttonVariant = ButtonVariant.Tertiary,
74         buttonType = ButtonType.WithText(
75           label = "Secondary button".toLabel(),
76         ),
77         buttonSize = ButtonSize.Small,
78         onClick = {},
79       ),
80     )
81   
82     private fun provideDialogLongTextThreeButtons() = DialogData.WithThreeButtons(
83       title = "Dialog Title".toLabel(),
84       body = provideLongText().toLabel(),
85       primaryButtonData = ButtonData(
86         buttonVariant = ButtonVariant.Tertiary,
87         buttonType = ButtonType.WithText(
88           label = "Primary button".toLabel(),
89         ),
90         buttonSize = ButtonSize.Small,
91         onClick = {},
92       ),
93       secondaryButtonData = ButtonData(
94         buttonVariant = ButtonVariant.Tertiary,
95         buttonType = ButtonType.WithText(
96           label = "Secondary button".toLabel(),
97         ),
98         buttonSize = ButtonSize.Small,
99         onClick = {},
100      ),
101      tertiaryButtonData =
102      ButtonData(
103        buttonVariant = ButtonVariant.Tertiary,
104        buttonType = ButtonType.WithText(
105          label = "Tertiary button".toLabel(),
106        ),
107        buttonSize = ButtonSize.Small,
108        onClick = {},
109      ),
110    ) {}
111  
112    private fun provideDialogOnlyTitleOneButton() = DialogData.WithText(
113      title = "Dialog Title".toLabel(),
114      primaryButtonData = ButtonData(
115        buttonVariant = ButtonVariant.Tertiary,
116        buttonType = ButtonType.WithText(
117          label = "Primary button".toLabel(),
118        ),
119        buttonSize = ButtonSize.Small,
120        onClick = {},
121      ),
122    ) {}
123  
124    private fun provideDialogShortTextColoredButton() = DialogData.WithText(
125      title = "Dialog Title".toLabel(),
126      body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laoreet.".toLabel(),
127      primaryButtonData = ButtonData(
128        buttonVariant = ButtonVariant.Tertiary,
129        buttonType = ButtonType.WithText(
130          label = "Primary button".toLabel(),
131        ),
132        buttonSize = ButtonSize.Small,
133        onClick = {},
134      ),
135      secondaryButtonData = ButtonData(
136        buttonState = ButtonState.Destructive,
137        buttonVariant = ButtonVariant.Tertiary,
138        buttonType = ButtonType.WithText(
139          label = "Secondary button".toLabel(),
140        ),
141        buttonSize = ButtonSize.Small,
142        onClick = {},
143      ),
144    ) {}
145  
146    private fun provideDialogShortTextWithIcon() = DialogData.WithIcon(
147      icon = DialogIconData(
148        iconResId = R.drawable.aa025_star,
149        iconColorProvider = { AppTheme.colors.supportRed100 },
150      ),
151      title = "Dialog Title".toLabel(),
152      body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laoreet.".toLabel(),
153      primaryButtonData = ButtonData(
154        buttonVariant = ButtonVariant.Tertiary,
155        buttonType = ButtonType.WithText(
156          label = "Primary button".toLabel(),
157        ),
158        buttonSize = ButtonSize.Small,
159        onClick = {},
160      ),
161      secondaryButtonData = ButtonData(
162        buttonVariant = ButtonVariant.Tertiary,
163        buttonType = ButtonType.WithText(
164          label = "Secondary button".toLabel(),
165        ),
166        buttonSize = ButtonSize.Small,
167        onClick = {},
168      ),
169    ) {}
170  
171    private fun provideDialogHighlightedTextTwoButtons() = provideDialogLongTextTwoButtons().copy(
172      annotatedBody = { getAnnotatedString() },
173    )
174  
175    @Composable
176    private fun getAnnotatedString() =
177      buildAnnotatedString {
178        val spanStyle = AppTheme.typography.bodyLargeRegular
179        withStyle(spanStyle) {
180          append("Normal text")
181        }
182        withStyle(
183          spanStyle.copy(
184            fontWeight = FontWeight.Bold,
185            color = AppTheme.colors.primary900,
186          ),
187        ) {
188          append(" Highlighted text")
189        }
190        withStyle(spanStyle) {
191          append(" Normal text")
192        }
193      }
194  
195  }
196  