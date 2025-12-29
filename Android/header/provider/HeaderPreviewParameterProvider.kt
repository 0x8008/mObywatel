1    package pl.gov.coi.common.ui.ds.header.provider
2    
3    import pl.gov.coi.common.ui.R
4    import pl.gov.coi.common.ui.ds.header.HeaderData
5    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
6    import pl.gov.coi.common.ui.preview.ScreenShotTestData
7    import pl.gov.coi.common.ui.theme.AppTheme
8    
9    class HeaderPreviewParameterProvider : CustomPreviewParameterProvider<HeaderData>() {
10     override val screenShotTestValues: Sequence<ScreenShotTestData<HeaderData>> = sequenceOf(
11       ScreenShotTestData(
12         screenShotTestName = "Header",
13         value = HeaderData(
14           iconResId = R.drawable.da015_historia_pojazdu,
15           iconColorProvider = { AppTheme.colors.headerCeladon100 },
16           iconBackgroundColorProvider = { AppTheme.colors.headerGrass30 },
17           title = "Title Size XXL Color - black 900".toLabel(),
18           message = "Description text Size - M, Color - grey 900".toLabel(),
19         ),
20       ),
21     )
22   }
23   