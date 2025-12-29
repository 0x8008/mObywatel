1    package pl.gov.coi.common.ui.ds.bottomnavigation.provider
2    
3    import pl.gov.coi.common.ui.R
4    import pl.gov.coi.common.ui.ds.bottomnavigation.BottomNavigationData
5    import pl.gov.coi.common.ui.ds.bottomnavigation.BottomNavigationItem
6    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
7    import pl.gov.coi.common.ui.preview.ScreenShotTestData
8    
9    class BottomNavigationPreviewParameterProvider :
10     CustomPreviewParameterProvider<BottomNavigationData>() {
11     override val screenShotTestValues: Sequence<ScreenShotTestData<BottomNavigationData>> =
12       sequenceOf(
13         ScreenShotTestData(
14           screenShotTestName = "BottomNavigationFiveElements",
15           value = BottomNavigationData(
16             items = listOf(
17               BottomNavigationItem(
18                 label = "Start".toLabel(),
19                 unselectedIconResId = R.drawable.ab001_home,
20                 selectedIconResId = R.drawable.b001_home,
21                 onClickAction = {},
22               ),
23               BottomNavigationItem(
24                 label = "Dokumenty".toLabel(),
25                 unselectedIconResId = R.drawable.ad005_framed_person,
26                 selectedIconResId = R.drawable.b002_framed_person,
27                 onClickAction = {},
28               ),
29               BottomNavigationItem(
30                 label = "Usługi".toLabel(),
31                 unselectedIconResId = R.drawable.ac001_services,
32                 selectedIconResId = R.drawable.b004_services,
33                 onClickAction = {},
34               ),
35               BottomNavigationItem(
36                 label = "Kod QR".toLabel(),
37                 unselectedIconResId = R.drawable.ai001_scanner_qr,
38                 selectedIconResId = R.drawable.b003_scanner_qr,
39                 onClickAction = {},
40               ),
41               BottomNavigationItem(
42                 label = "Więcej".toLabel(),
43                 unselectedIconResId = R.drawable.ab010_more,
44                 selectedIconResId = R.drawable.b005_more,
45                 onClickAction = {},
46               ),
47             ),
48             selectedItemIndex = 0,
49           ),
50         ),
51         ScreenShotTestData(
52           screenShotTestName = "BottomNavigationTwoElements",
53           value = BottomNavigationData(
54             items = listOf(
55               BottomNavigationItem(
56                 label = "Start".toLabel(),
57                 unselectedIconResId = R.drawable.ab001_home,
58                 selectedIconResId = R.drawable.b001_home,
59                 onClickAction = {},
60               ),
61               BottomNavigationItem(
62                 label = "Więcej".toLabel(),
63                 unselectedIconResId = R.drawable.ab010_more,
64                 selectedIconResId = R.drawable.b005_more,
65                 onClickAction = {},
66               ),
67             ),
68             selectedItemIndex = 0,
69           ),
70         ),
71       )
72   }
73   