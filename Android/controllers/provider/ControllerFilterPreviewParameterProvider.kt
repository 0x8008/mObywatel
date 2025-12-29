1    package pl.gov.coi.common.ui.ds.controllers.provider
2    
3    import pl.gov.coi.common.domain.label.toLabel
4    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
5    import pl.gov.coi.common.ui.preview.ScreenShotTestData
6    import pl.gov.coi.common.ui.ds.controllers.ControllersData
7    
8    class ControllerFilterPreviewParameterProvider : CustomPreviewParameterProvider<ControllersData.Filter>() {
9      override val screenShotTestValues: Sequence<ScreenShotTestData<ControllersData.Filter>> = sequenceOf(
10       ScreenShotTestData(
11         screenShotTestName = "ControllerFilterFirstSelected",
12         value = provideControllerFilterFirstSelectedPreviewData(),
13       ),
14       ScreenShotTestData(
15         screenShotTestName = "ControllerFilterThirdSelected",
16         value = provideControllerFilterThirdSelectedPreviewData(),
17       ),
18       ScreenShotTestData(
19         screenShotTestName = "ControllerFilterShortLabel",
20         value = provideControllerFilterShortLabelPreviewData(),
21       ),
22     )
23   }
24   
25   private fun provideControllerFilterFirstSelectedPreviewData() =
26     ControllersData.Filter(
27       items = listOf(
28         "Główne",
29         "Tymczasowe",
30         "Niezdeklarowane",
31         "Nieważne",
32       ).map { it.toLabel(tag = it) },
33       selectedItemIndex = 0,
34       onClick = {},
35     )
36   
37   private fun provideControllerFilterThirdSelectedPreviewData() =
38     ControllersData.Filter(
39       items = listOf(
40         "Główne",
41         "Tymczasowe",
42         "Niezdeklarowane",
43         "Nieważne",
44       ).map { it.toLabel(tag = it) },
45       selectedItemIndex = 2,
46       onClick = {},
47     )
48   
49   private fun provideControllerFilterShortLabelPreviewData() =
50     ControllersData.Filter(
51       items = listOf(
52         "a",
53         "b",
54         "c",
55         "d",
56         "e",
57         "f",
58         "g",
59         "h",
60         "i",
61         "j",
62         "k",
63       ).map { it.toLabel(tag = it) },
64       selectedItemIndex = 1,
65       onClick = {},
66     )
67   