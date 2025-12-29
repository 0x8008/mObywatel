1    package pl.gov.coi.common.ui.ds.badge.provider
2    
3    import pl.gov.coi.common.ui.ds.badge.BadgeData
4    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
5    import pl.gov.coi.common.ui.preview.ScreenShotTestData
6    
7    class BadgePreviewParameterProvider : CustomPreviewParameterProvider<BadgeData>() {
8      override val screenShotTestValues: Sequence<ScreenShotTestData<BadgeData>> = sequenceOf(
9        ScreenShotTestData(
10         screenShotTestName = "BadgeDataDefault",
11         value = BadgeData.BadgeDefault,
12       ),
13     )
14   }
15   