1    package pl.gov.coi.common.ui.ds.progressbar.provider
2    
3    import pl.gov.coi.common.ui.ds.progressbar.ProgressBarData
4    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
5    import pl.gov.coi.common.ui.preview.ScreenShotTestData
6    
7    class ProgressBarPreviewParameterProvider : CustomPreviewParameterProvider<ProgressBarData>() {
8    
9      override val screenShotTestValues: Sequence<ScreenShotTestData<ProgressBarData>> = sequenceOf(
10       ScreenShotTestData(
11         screenShotTestName = "ProgressBar",
12         value = ProgressBarData.Bar(value = 50),
13       ),
14       ScreenShotTestData(
15         screenShotTestName = "ProgressBarWithOptionalLabel",
16         value = ProgressBarData.IndicatorBar(value = 75, label = "75%".toLabel()),
17       ),
18     )
19   }
20   