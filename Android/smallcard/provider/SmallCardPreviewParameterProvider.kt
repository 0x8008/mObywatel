1    package pl.gov.coi.common.ui.ds.smallcard.provider
2    
3    import pl.gov.coi.common.ui.R
4    import pl.gov.coi.common.ui.ds.smallcard.SmallCardData
5    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
6    import pl.gov.coi.common.ui.preview.ScreenShotTestData
7    import pl.gov.coi.common.ui.theme.AppTheme
8    
9    class SmallCardPreviewParameterProvider : CustomPreviewParameterProvider<SmallCardData>() {
10     override val screenShotTestValues: Sequence<ScreenShotTestData<SmallCardData>> = sequenceOf(
11       ScreenShotTestData(
12         screenShotTestName = "SmallCard",
13         value = SmallCardData(
14           title = "Naruszenie środowiskowe".toLabel(),
15           iconResId = R.drawable.da002_naruszenie_srodowiskowe,
16           iconColorProvider = { AppTheme.colors.serviceLeafy100 },
17           onClick = {},
18         ),
19       ),
20     )
21   }
22   