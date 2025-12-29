1    package pl.gov.coi.common.ui.ds.inforow.provider
2    
3    import pl.gov.coi.common.ui.R
4    import pl.gov.coi.common.ui.ds.inforow.model.InfoRowData
5    import pl.gov.coi.common.ui.ds.inforow.model.InfoRowListData
6    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
7    import pl.gov.coi.common.ui.preview.ScreenShotTestData
8    import pl.gov.coi.common.ui.theme.AppTheme
9    
10   class InfoRowPPP : CustomPreviewParameterProvider<InfoRowListData>() {
11     override val screenShotTestValues: Sequence<ScreenShotTestData<InfoRowListData>> = sequenceOf(
12       ScreenShotTestData(
13         screenShotTestName = "InfoRowBullet",
14         value = InfoRowListData(
15           listOf(
16             InfoRowData.Bullet(
17               description = ("Bullet info row description Bullet info row description " +
18                 "Bullet info row description Bullet info row description Bullet info row description " +
19                 "Bullet info row description Bullet info row description ").toLabel(),
20             ),
21             InfoRowData.Bullet(
22               description = "Bullet info row description".toLabel(),
23             ),
24           ),
25         ),
26       ),
27       ScreenShotTestData(
28         screenShotTestName = "InfoRowDefault",
29         value = InfoRowListData(
30           listOf(
31             InfoRowData.Default(
32               title = "Title label 1".toLabel(),
33               description = ("Description label 1 Description label 1 Description label 1 " +
34                 "Description label 1 Description label 1").toLabel(),
35               iconResId = R.drawable.aa037_rounded_plus,
36               iconColorProvider = { AppTheme.colors.supportGreen100 },
37             ),
38             InfoRowData.Default(
39               title = "Title label 2".toLabel(),
40               description = "Description label 2".toLabel(),
41               iconResId = R.drawable.aa002_delete,
42               iconColorProvider = { AppTheme.colors.supportRed100 },
43             ),
44           ),
45         ),
46       ),
47     )
48   }
49   