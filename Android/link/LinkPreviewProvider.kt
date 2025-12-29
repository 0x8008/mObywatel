1    package pl.gov.coi.common.ui.ds.link
2    
3    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
4    import pl.gov.coi.common.ui.preview.ScreenShotTestData
5    
6    class LinkPreviewProvider : CustomPreviewParameterProvider<LinkData>() {
7      override val screenShotTestValues: Sequence<ScreenShotTestData<LinkData>> = sequenceOf(
8        ScreenShotTestData(
9          screenShotTestName = "LinkEnabled",
10         value = LinkData(
11           label = "Link".toLabel(),
12           linkType = LinkData.LinkType.WEBSITE,
13           url = "",
14           onClick = {},
15         ),
16       ),
17       ScreenShotTestData(
18         screenShotTestName = "LinkDisabled",
19         value = LinkData(
20           label = "Link".toLabel(),
21           linkType = LinkData.LinkType.WEBSITE,
22           url = "",
23           enabled = false,
24           onClick = {},
25         ),
26       ),
27     )
28   }
29   