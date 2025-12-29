1    package pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttonitem
2    
3    import android.content.Context
4    import pl.gov.coi.common.domain.Mapper
5    import pl.gov.coi.common.ui.preview.CustomWrappedDataPreviewParameterProvider
6    import pl.gov.coi.common.ui.preview.ScreenShotTestDataProvider
7    import pl.gov.coi.common.ui.preview.WrappedValue
8    import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonItemData
9    
10   class RadioButtonItemPPP : CustomWrappedDataPreviewParameterProvider<
11     Unit,
12     RadioButtonItemData?,
13     Mapper<Unit, RadioButtonItemData?>,
14     RadioButtonItemData,
15     >() {
16   
17     override fun mapper(context: Context) = object : Mapper<Unit, RadioButtonItemData?> {
18       override fun invoke(p1: Unit): RadioButtonItemData? = null
19     }
20   
21     override val screenShotTestValues: Sequence<ScreenShotTestDataProvider<RadioButtonItemData>> = sequenceOf(
22       ScreenShotTestDataProvider(
23         screenShotTestName = "RadioButtonItemUnselected",
24         wrappedValue = WrappedValue {
25           provideRadioButtonItemData(
26             enabled = true,
27             isSelected = false,
28             isError = false,
29           )
30         },
31       ),
32       ScreenShotTestDataProvider(
33         screenShotTestName = "RadioButtonItemUnselectedDisabled",
34         wrappedValue = WrappedValue {
35           provideRadioButtonItemData(
36             enabled = false,
37             isSelected = false,
38             isError = false,
39           )
40         },
41       ),
42       ScreenShotTestDataProvider(
43         screenShotTestName = "RadioButtonItemSelected",
44         wrappedValue = WrappedValue {
45           provideRadioButtonItemData(
46             enabled = true,
47             isSelected = true,
48             isError = false,
49           )
50         },
51       ),
52       ScreenShotTestDataProvider(
53         screenShotTestName = "RadioButtonItemSelectedDisabled",
54         wrappedValue = WrappedValue {
55           provideRadioButtonItemData(
56             enabled = false,
57             isSelected = true,
58             isError = false,
59           )
60         },
61       ),
62       ScreenShotTestDataProvider(
63         screenShotTestName = "RadioButtonItemUnselectedError",
64         wrappedValue = WrappedValue {
65           provideRadioButtonItemData(
66             enabled = true,
67             isSelected = false,
68             isError = true,
69           )
70         },
71       ),
72       ScreenShotTestDataProvider(
73         screenShotTestName = "RadioButtonItemSelectedError",
74         wrappedValue = WrappedValue {
75           provideRadioButtonItemData(
76             enabled = true,
77             isSelected = true,
78             isError = true,
79           )
80         },
81       ),
82     )
83   
84     private fun provideRadioButtonItemData(
85       enabled: Boolean,
86       isSelected: Boolean,
87       isError: Boolean,
88     ) = RadioButtonItemData(
89       enabled = enabled,
90       isSelected = isSelected,
91       isError = isError,
92     )
93   }
94   