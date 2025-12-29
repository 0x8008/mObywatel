1    package pl.gov.coi.common.ui.ds.menus.provider
2    
3    import pl.gov.coi.common.ui.R
4    import pl.gov.coi.common.ui.ds.menus.MenuData
5    import pl.gov.coi.common.ui.ds.menus.MenuItem
6    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
7    import pl.gov.coi.common.ui.preview.ScreenShotTestData
8    
9    class MenuPreviewParameterProvider : CustomPreviewParameterProvider<MenuData>() {
10     override val screenShotTestValues: Sequence<ScreenShotTestData<MenuData>>
11       get() = sequenceOf(
12         ScreenShotTestData(
13           screenShotTestName = "Menu",
14           value = provideMenuData(),
15         ),
16       )
17   
18     private fun provideMenuData() = MenuData(
19       isMenuVisible = true,
20       onMenuClose = {},
21       items = listOf(
22         MenuItem(
23           label = "Opcja 1".toLabel(),
24           leftIconResId = R.drawable.ah001_like,
25           rightIconResId = R.drawable.ah001_like,
26           onItemClick = {},
27         ),
28         MenuItem(
29           label = "Opcja 2".toLabel(),
30           leftIconResId = R.drawable.aa002_delete,
31           rightIconResId = R.drawable.aa002_delete,
32           onItemClick = {},
33         ),
34         MenuItem(
35           label = "Opcja 3".toLabel(),
36           leftIconResId = R.drawable.ah002_dislike,
37           rightIconResId = R.drawable.ah002_dislike,
38           onItemClick = {},
39         ),
40       ),
41     )
42   }
43   