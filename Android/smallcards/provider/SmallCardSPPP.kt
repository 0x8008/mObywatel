1    package pl.gov.coi.common.ui.ds.smallcards.provider
2    
3    import pl.gov.coi.common.ui.R
4    import pl.gov.coi.common.ui.ds.smallcards.SmallCardSData
5    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
6    import pl.gov.coi.common.ui.preview.ScreenShotTestData
7    import pl.gov.coi.common.ui.theme.AppTheme
8    
9    class SmallCardSPPP : CustomPreviewParameterProvider<SmallCardSData>() {
10     override val screenShotTestValues: Sequence<ScreenShotTestData<SmallCardSData>> = sequenceOf(
11       ScreenShotTestData(
12         screenShotTestName = "SmallCard Confirm identity",
13         value = SmallCardSData(
14           title = "Potwierdź dane".toLabel(),
15           iconResId = R.drawable.ai002_confirm_identity,
16           iconColorProvider = { AppTheme.colors.primary900 },
17           onClick = {},
18         ),
19       ),
20       ScreenShotTestData(
21         screenShotTestName = "SmallCard Delete",
22         value = SmallCardSData(
23           title = "Usuń".toLabel(),
24           iconResId = R.drawable.aa002_delete,
25           iconColorProvider = { AppTheme.colors.supportRed100 },
26           onClick = {},
27         ),
28       ),
29     )
30   }
31   