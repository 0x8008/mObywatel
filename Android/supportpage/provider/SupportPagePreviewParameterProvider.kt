1    package pl.gov.coi.common.ui.ds.supportpage.provider
2    
3    import pl.gov.coi.common.domain.label.Label
4    import pl.gov.coi.common.ui.R
5    import pl.gov.coi.common.ui.ds.button.ButtonData
6    import pl.gov.coi.common.ui.ds.button.common.ButtonSize
7    import pl.gov.coi.common.ui.ds.button.common.ButtonType
8    import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
9    import pl.gov.coi.common.ui.ds.inforow.model.InfoRowData
10   import pl.gov.coi.common.ui.ds.inforow.model.InfoRowListData
11   import pl.gov.coi.common.ui.ds.supportpage.SupportPageData
12   import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
13   import pl.gov.coi.common.ui.preview.ScreenShotTestData
14   
15   class SupportPagePreviewParameterProvider : CustomPreviewParameterProvider<SupportPageData<*>>() {
16     override val screenShotTestValues: Sequence<ScreenShotTestData<SupportPageData<*>>>
17       get() = sequenceOf(
18         ScreenShotTestData(
19           screenShotTestName = "SupportPageData",
20           value = SupportPageData(
21             topBarTitle = "Top bar title".toLabel(),
22             topBarIconMainResId = null,
23             onTopBarIconMainClick = null,
24             topBarIconMenuResId = null,
25             onTopBarIconMenuClick = null,
26             iconResId = R.drawable.ag005_globe,
27             iconContentDescription = Label.EMPTY,
28             title = "Title Size XXL medium 24 Color - black 900".toLabel(),
29             message = "Description text Size - M, Color - grey 900".toLabel(),
30             contentData = Unit,
31             buttonData = null,
32           ),
33         ),
34         ScreenShotTestData(
35           screenShotTestName = "SupportPageDataExample",
36           value = SupportPageData(
37             topBarTitle = "Wybierz język".toLabel(),
38             topBarIconMainResId = R.drawable.ab004_arrow_left,
39             onTopBarIconMainClick = {},
40             topBarIconMenuResId = null,
41             onTopBarIconMenuClick = null,
42             iconResId = R.drawable.ag005_globe,
43             iconContentDescription = Label.EMPTY,
44             title = "Top bar title".toLabel(),
45             message = "Nie można zmienić języka w Ustawieniach.".toLabel(),
46             contentData = InfoRowListData(
47               items = listOf(
48                 InfoRowData.Bullet(
49                   description = "Support text\nSIZE M: Roboto Normal Gray 900".toLabel(),
50                 ),
51                 InfoRowData.Bullet(
52                   description = "Support text\nSIZE M: Roboto Normal Gray 900".toLabel(),
53                 ),
54               ),
55             ),
56             buttonData = ButtonData(
57               buttonSize = ButtonSize.Large(),
58               buttonVariant = ButtonVariant.Primary,
59               buttonType = ButtonType.WithText(
60                 label = "Dalej".toLabel(),
61               ),
62               onClick = {},
63             ),
64           ),
65         ),
66       )
67   }
68   