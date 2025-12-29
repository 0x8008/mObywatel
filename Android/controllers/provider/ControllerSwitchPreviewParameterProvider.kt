1    package pl.gov.coi.common.ui.ds.controllers.provider
2    
3    import pl.gov.coi.common.domain.label.toLabel
4    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
5    import pl.gov.coi.common.ui.preview.ScreenShotTestData
6    import pl.gov.coi.common.ui.ds.controllers.ControllersData
7    
8    class ControllerSwitchPreviewParameterProvider : CustomPreviewParameterProvider<ControllersData.Switch>() {
9      override val screenShotTestValues: Sequence<ScreenShotTestData<ControllersData.Switch>> = sequenceOf(
10       ScreenShotTestData(
11         screenShotTestName = "ControllerSwitchTabLeftSelected",
12         value = provideControllerSwitchTabLeftSelectedPreviewData(),
13       ),
14       ScreenShotTestData(
15         screenShotTestName = "ControllerSwitchTabRightSelected",
16         value = provideControllerSwitchTabRightSelectedPreviewData(),
17       ),
18       ScreenShotTestData(
19         screenShotTestName = "ControllerSwitchTab",
20         value = provideControllerSwitchTabLongLabelsPreviewData(),
21       ),
22     )
23   
24     private fun provideControllerSwitchTabLeftSelectedPreviewData() =
25       ControllersData.Switch(
26         leftItem = ControllersData.Switch.TabItem(
27           label = "Left".toLabel(),
28           type = ControllersData.Switch.Type.LEFT,
29         ),
30         rightItem = ControllersData.Switch.TabItem(
31           label = "Right".toLabel(),
32           type = ControllersData.Switch.Type.RIGHT,
33         ),
34         selectedItemType = ControllersData.Switch.Type.LEFT,
35         onClick = {},
36       )
37   
38     private fun provideControllerSwitchTabRightSelectedPreviewData() =
39       ControllersData.Switch(
40         leftItem = ControllersData.Switch.TabItem(
41           label = "Left".toLabel(),
42           type = ControllersData.Switch.Type.LEFT,
43         ),
44         rightItem = ControllersData.Switch.TabItem(
45           label = "Right".toLabel(),
46           type = ControllersData.Switch.Type.RIGHT,
47         ),
48         selectedItemType = ControllersData.Switch.Type.RIGHT,
49         onClick = {},
50       )
51   
52     private fun provideControllerSwitchTabLongLabelsPreviewData() =
53       ControllersData.Switch(
54         leftItem = ControllersData.Switch.TabItem(
55           label = "Zaległe i nieopłacone mandaty".toLabel(),
56           type = ControllersData.Switch.Type.LEFT,
57         ),
58         rightItem = ControllersData.Switch.TabItem(
59           label = "Opłacone mandaty".toLabel(),
60           type = ControllersData.Switch.Type.RIGHT,
61         ),
62         selectedItemType = ControllersData.Switch.Type.LEFT,
63         onClick = {},
64       )
65   }
66   