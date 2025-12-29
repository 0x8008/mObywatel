1    package pl.gov.coi.common.ui.ds.servicewelcomepage.provider
2    
3    import pl.gov.coi.common.domain.label.Label
4    import pl.gov.coi.common.ui.R
5    import pl.gov.coi.common.ui.ds.alert.AlertData
6    import pl.gov.coi.common.ui.ds.button.ButtonData
7    import pl.gov.coi.common.ui.ds.button.common.ButtonSize
8    import pl.gov.coi.common.ui.ds.button.common.ButtonType
9    import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
10   import pl.gov.coi.common.ui.ds.header.HeaderData
11   import pl.gov.coi.common.ui.ds.inforow.model.InfoRowData
12   import pl.gov.coi.common.ui.ds.inforow.model.InfoRowListData
13   import pl.gov.coi.common.ui.ds.servicewelcomepage.ServiceWelcomePageData
14   import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
15   import pl.gov.coi.common.ui.preview.ScreenShotTestData
16   import pl.gov.coi.common.ui.theme.AppTheme
17   
18   class ServiceWelcomePagePreviewParameterProvider : CustomPreviewParameterProvider<ServiceWelcomePageData<*>>() {
19     override val screenShotTestValues: Sequence<ScreenShotTestData<ServiceWelcomePageData<*>>>
20       get() = sequenceOf(
21         ScreenShotTestData(
22           screenShotTestName = "ServiceWelcomePageData",
23           value = ServiceWelcomePageData(
24             topBarTitle = "Top bar title".toLabel(),
25             topBarIconMainResId = R.drawable.ab004_arrow_left,
26             onTopBarIconMainClick = {},
27             topBarIconMenuResId = R.drawable.c1_info,
28             onTopBarIconMenuClick = {},
29             headerData = HeaderData(
30               iconResId = R.drawable.da015_historia_pojazdu,
31               iconColorProvider = { AppTheme.colors.headerCeladon100 },
32               iconBackgroundColorProvider = { AppTheme.colors.headerGrass30 },
33               title = "Title Size XXL Color - black 900".toLabel(),
34               message = "Description text Size - M, Color - grey 900".toLabel(),
35             ),
36             contentData = Unit,
37             buttonData = null,
38           ),
39         ),
40         ScreenShotTestData(
41           screenShotTestName = "ServiceWelcomePageDataWithContent",
42           value = ServiceWelcomePageData(
43             topBarTitle = "Top bar title".toLabel(),
44             topBarIconMainResId = R.drawable.ab004_arrow_left,
45             onTopBarIconMainClick = {},
46             topBarIconMenuResId = R.drawable.c1_info,
47             onTopBarIconMenuClick = {},
48             headerData = HeaderData(
49               iconResId = R.drawable.da015_historia_pojazdu,
50               iconColorProvider = { AppTheme.colors.headerCeladon100 },
51               iconBackgroundColorProvider = { AppTheme.colors.headerGrass30 },
52               title = "Title Size XXL Color - black 900".toLabel(),
53               message = "Description text Size - M, Color - grey 900".toLabel(),
54             ),
55             alertData = AlertData.Warning(
56               title = "Alert title example".toLabel(),
57               bodyText = "Alert body text".toLabel(),
58               alertContentDescription = Label.EMPTY,
59             ),
60             contentData = InfoRowListData(
61               items = listOf(
62                 InfoRowData.Bullet(
63                   description = "Support text\nSIZE M: Roboto Normal Gray 900".toLabel(),
64                 ),
65                 InfoRowData.Bullet(
66                   description = "Support text\nSIZE M: Roboto Normal Gray 900".toLabel(),
67                 ),
68               ),
69             ),
70             buttonData = ButtonData(
71               buttonSize = ButtonSize.Large(),
72               buttonVariant = ButtonVariant.Primary,
73               buttonType = ButtonType.WithText(
74                 label = "Sprawdź".toLabel(),
75               ),
76               onClick = {},
77             ),
78           ),
79         ),
80   
81         ScreenShotTestData(
82           screenShotTestName = "ServiceWelcomePageDataWithStepsContent",
83           value = ServiceWelcomePageData(
84             topBarTitle = "Top bar title".toLabel(),
85             topBarIconMainResId = R.drawable.ab004_arrow_left,
86             onTopBarIconMainClick = {},
87             topBarIconMenuResId = R.drawable.c1_info,
88             onTopBarIconMenuClick = {},
89             headerData = HeaderData(
90               iconResId = R.drawable.da015_historia_pojazdu,
91               iconColorProvider = { AppTheme.colors.headerCeladon100 },
92               iconBackgroundColorProvider = { AppTheme.colors.headerGrass30 },
93               title = "Title Size XXL Color - black 900".toLabel(),
94               message = "Description text Size - M, Color - grey 900".toLabel(),
95             ),
96             contentData = InfoRowListData(
97               items = listOf(
98                 InfoRowData.Bullet(
99                   description = "Support text\nSIZE M: Roboto Normal Gray 900".toLabel(),
100                ),
101                InfoRowData.Bullet(
102                  description = "Support text\nSIZE M: Roboto Normal Gray 900".toLabel(),
103                ),
104              ),
105            ),
106            buttonData = ButtonData(
107              buttonSize = ButtonSize.Large(),
108              buttonVariant = ButtonVariant.Primary,
109              buttonType = ButtonType.WithText(
110                label = "Sprawdź".toLabel(),
111              ),
112              onClick = {},
113            ),
114          ),
115        ),
116      )
117  }
118  