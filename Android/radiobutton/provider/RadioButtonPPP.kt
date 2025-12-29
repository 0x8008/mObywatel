1    package pl.gov.coi.common.ui.ds.radiobutton.provider
2    
3    import android.content.Context
4    import androidx.compose.runtime.Composable
5    import pl.gov.coi.common.domain.Mapper
6    import pl.gov.coi.common.domain.label.Label
7    import pl.gov.coi.common.domain.label.toLabel
8    import pl.gov.coi.common.ui.ds.dropdownbutton.DropDownButton
9    import pl.gov.coi.common.ui.ds.dropdownbutton.DropDownButtonData
10   import pl.gov.coi.common.ui.preview.CustomWrappedDataPreviewParameterProvider
11   import pl.gov.coi.common.ui.preview.ScreenShotTestDataProvider
12   import pl.gov.coi.common.ui.preview.WrappedValue
13   import pl.gov.coi.common.ui.ds.radiobutton.RadioButtonData
14   import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonCustomContent
15   import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonItemData
16   import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonRow
17   import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonSupportText
18   import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonVariant
19   
20   class RadioButtonPPP : CustomWrappedDataPreviewParameterProvider<
21     Unit,
22     RadioButtonData?,
23     Mapper<Unit, RadioButtonData?>,
24     RadioButtonData,
25     >() {
26   
27     override fun mapper(context: Context): Mapper<Unit, RadioButtonData?> = object : Mapper<Unit, RadioButtonData?> {
28       override fun invoke(p1: Unit): RadioButtonData? = null
29     }
30   
31     override val screenShotTestValues: Sequence<ScreenShotTestDataProvider<RadioButtonData>> = sequenceOf(
32       ScreenShotTestDataProvider(
33         screenShotTestName = "RadioButtonDefault",
34         wrappedValue = WrappedValue {
35           provideRadioButton(
36             radioButtonVariant = RadioButtonVariant.Default,
37           )
38         },
39       ),
40       ScreenShotTestDataProvider(
41         screenShotTestName = "RadioButtonDefaultDisabled",
42         wrappedValue = WrappedValue {
43           provideRadioButton(
44             radioButtonVariant = RadioButtonVariant.Default,
45             selectedIndex = 0,
46             enabled = false,
47           )
48         },
49       ),
50       ScreenShotTestDataProvider(
51         screenShotTestName = "RadioButtonDefaultWithOptionals",
52         wrappedValue = WrappedValue {
53           provideRadioButton(
54             radioButtonVariant = RadioButtonVariant.Default,
55             selectedIndex = 0,
56             label = provideLabel(),
57             state = provideHelperText(),
58             onClickHelperIcon = {},
59             description = provideDescription(),
60             content = CustomContent(),
61           )
62         },
63       ),
64   
65       ScreenShotTestDataProvider(
66         screenShotTestName = "RadioButtonDefaultError",
67         wrappedValue = WrappedValue {
68           provideRadioButton(
69             radioButtonVariant = RadioButtonVariant.Default,
70             selectedIndex = 1,
71             label = provideLabel(),
72             state = provideError(),
73           )
74         },
75       ),
76       ScreenShotTestDataProvider(
77         screenShotTestName = "RadioButtonContentBox",
78         wrappedValue = WrappedValue {
79           provideRadioButton(
80             radioButtonVariant = RadioButtonVariant.ContentBox,
81             selectedIndex = 0,
82           )
83         },
84       ),
85       ScreenShotTestDataProvider(
86         screenShotTestName = "RadioButtonContentBoxDisabled",
87         wrappedValue = WrappedValue {
88           provideRadioButton(
89             radioButtonVariant = RadioButtonVariant.ContentBox,
90             selectedIndex = 0,
91             enabled = false,
92           )
93         },
94       ),
95       ScreenShotTestDataProvider(
96         screenShotTestName = "RadioButtonContentBoxWithOptionals",
97         wrappedValue = WrappedValue {
98           provideRadioButton(
99             radioButtonVariant = RadioButtonVariant.ContentBox,
100            selectedIndex = 1,
101            label = provideLabel(),
102            state = provideHelperText(),
103            onClickHelperIcon = {},
104            description = provideDescription(),
105            content = CustomContent(),
106          )
107        },
108      ),
109      ScreenShotTestDataProvider(
110        screenShotTestName = "RadioButtonContentBoxError",
111        wrappedValue = WrappedValue {
112          provideRadioButton(
113            radioButtonVariant = RadioButtonVariant.ContentBox,
114            selectedIndex = 1,
115            label = provideLabel(),
116            state = provideError(),
117          )
118        },
119      ),
120    )
121  
122    private fun provideRadioButton(
123      radioButtonVariant: RadioButtonVariant,
124      state: RadioButtonSupportText = RadioButtonSupportText.Helper(),
125      selectedIndex: Int? = null,
126      label: Label? = null,
127      description: Label? = null,
128      onClickHelperIcon: (() -> Unit)? = null,
129      content: RadioButtonCustomContent? = null,
130      enabled: Boolean = true,
131    ) = RadioButtonData(
132      items = listOf(
133        RadioButtonRow(
134          onClick = {},
135          label = provideLabel(),
136          content = content,
137          item = RadioButtonItemData(
138            enabled = enabled,
139            isSelected = selectedIndex == 0,
140          ),
141          description = description,
142        ),
143        RadioButtonRow(
144          onClick = {},
145          label = provideLabel(),
146          content = content,
147          item = RadioButtonItemData(
148            enabled = enabled,
149            isSelected = selectedIndex == 1,
150          ),
151        ),
152      ),
153      radioButtonVariant = radioButtonVariant,
154      supportText = state,
155      label = label,
156      onClickHelperIcon = onClickHelperIcon,
157    )
158  
159    private fun provideLabel() = "Etykieta".toLabel("")
160  
161    private fun provideDescription() = "Description".toLabel("")
162  
163    private fun provideHelperText() = RadioButtonSupportText.Helper(helperText = "HelperText".toLabel(""))
164  
165    private fun provideError() = RadioButtonSupportText.Error(errorText = "Error".toLabel(""))
166  
167    class CustomContent : RadioButtonCustomContent {
168      override fun content(): @Composable () -> Unit = {
169        DropDownButton(
170          data = DropDownButtonData(
171            label = "Test".toLabel(""),
172            items = listOf(
173              "Option 1".toLabel(""),
174              "Option 2".toLabel(""),
175              "Option 3".toLabel(""),
176            ),
177            placeholder = "Choose".toLabel(""),
178            onClick = {},
179          ),
180        )
181      }
182    }
183  }
184  