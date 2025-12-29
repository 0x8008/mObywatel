1    package pl.gov.coi.common.ui.ds.statusbadge
2    
3    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
4    import pl.gov.coi.common.ui.preview.ScreenShotTestData
5    
6    class StatusBadgePreviewProvider : CustomPreviewParameterProvider<StatusBadgeData>() {
7    
8      override val screenShotTestValues: Sequence<ScreenShotTestData<StatusBadgeData>>
9        get() = sequenceOf(
10         ScreenShotTestData(
11           screenShotTestName = " StatusBadgeDataDotPositive",
12           value = StatusBadgeData.WithDot(
13             label = "Roboto, Medium, 16, Neutral-500".toLabel(),
14             status = StatusBadgeWithDotStatus.POSITIVE,
15           ),
16         ),
17         ScreenShotTestData(
18           screenShotTestName = " StatusBadgeDataDotInformative",
19           value = StatusBadgeData.WithDot(
20             label = "Roboto, Medium, 16, Neutral-500".toLabel(),
21             status = StatusBadgeWithDotStatus.INFORMATIVE,
22           ),
23         ),
24         ScreenShotTestData(
25           screenShotTestName = " StatusBadgeDataDotNegative",
26           value = StatusBadgeData.WithDot(
27             label = "Roboto, Medium, 16, Neutral-500".toLabel(),
28             status = StatusBadgeWithDotStatus.NEGATIVE,
29           ),
30         ),
31         ScreenShotTestData(
32           screenShotTestName = " StatusBadgeDataDotWarning",
33           value = StatusBadgeData.WithDot(
34             label = "Roboto, Medium, 16, Neutral-500".toLabel(),
35             status = StatusBadgeWithDotStatus.WARNING,
36           ),
37         ),
38         ScreenShotTestData(
39           screenShotTestName = " StatusBadgeDataPositive",
40           value = StatusBadgeData.WithIcon(
41             label = "Roboto, Regular, 12, Neutral-500".toLabel(),
42             status = StatusBadgeWithIconStatus.POSITIVE,
43           ),
44         ),
45         ScreenShotTestData(
46           screenShotTestName = " StatusBadgeDataNegative",
47           value = StatusBadgeData.WithIcon(
48             label = "Roboto, Regular, 12, Neutral-500".toLabel(),
49             status = StatusBadgeWithIconStatus.NEGATIVE,
50           ),
51         ),
52         ScreenShotTestData(
53           screenShotTestName = " StatusBadgeDataNotice",
54           value = StatusBadgeData.WithIcon(
55             label = "Roboto, Regular, 12, Neutral-500".toLabel(),
56             status = StatusBadgeWithIconStatus.NOTICE,
57           ),
58         ),
59         ScreenShotTestData(
60           screenShotTestName = " StatusBadgeDataInformative",
61           value = StatusBadgeData.WithIcon(
62             label = "Roboto, Regular, 12, Neutral-500".toLabel(),
63             status = StatusBadgeWithIconStatus.INFORMATIVE,
64           ),
65         ),
66         ScreenShotTestData(
67           screenShotTestName = " StatusBadgeDataNeutral",
68           value = StatusBadgeData.WithIcon(
69             label = "Roboto, Regular, 12, Neutral-500".toLabel(),
70             status = StatusBadgeWithIconStatus.MINUS,
71           ),
72         ),
73         ScreenShotTestData(
74           screenShotTestName = " StatusBadgeDataWithoutBorderPositive",
75           value = StatusBadgeData.WithIcon(
76             label = "Roboto, Regular, 16, Neutral-500".toLabel(),
77             status = StatusBadgeWithIconStatus.POSITIVE,
78             withBorder = false,
79           ),
80         ),
81         ScreenShotTestData(
82           screenShotTestName = " StatusBadgeDataWithoutBorderNegative",
83           value = StatusBadgeData.WithIcon(
84             label = "Roboto, Regular, 16, Neutral-500".toLabel(),
85             status = StatusBadgeWithIconStatus.NEGATIVE,
86             withBorder = false,
87           ),
88         ),
89         ScreenShotTestData(
90           screenShotTestName = " StatusBadgeDataWithoutBorderNotice",
91           value = StatusBadgeData.WithIcon(
92             label = "Roboto, Regular, 16, Neutral-500".toLabel(),
93             status = StatusBadgeWithIconStatus.NOTICE,
94             withBorder = false,
95           ),
96         ),
97         ScreenShotTestData(
98           screenShotTestName = " StatusBadgeDataWithoutBorderInformative",
99           value = StatusBadgeData.WithIcon(
100            label = "Roboto, Regular, 16, Neutral-500".toLabel(),
101            status = StatusBadgeWithIconStatus.INFORMATIVE,
102            withBorder = false,
103          ),
104        ),
105        ScreenShotTestData(
106          screenShotTestName = " StatusBadgeDataWithoutBorderNeutral",
107          value = StatusBadgeData.WithIcon(
108            label = "Roboto, Regular, 16, Neutral-500".toLabel(),
109            status = StatusBadgeWithIconStatus.MINUS,
110            withBorder = false,
111          ),
112        ),
113      )
114  }
115  