1    package pl.gov.coi.common.ui.ds.topappbar
2    
3    import pl.gov.coi.common.domain.label.toLabel
4    import pl.gov.coi.common.ui.R
5    import pl.gov.coi.common.ui.ds.progressbar.ProgressBarData
6    import pl.gov.coi.common.ui.ds.topappbar.MenuType.MenuButtonData
7    import pl.gov.coi.common.ui.ds.topappbar.MenuType.MenuButtonData.MenuIcon
8    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
9    import pl.gov.coi.common.ui.preview.ScreenShotTestData
10   import pl.gov.coi.common.ui.theme.AppTheme
11   
12   private val NOTIFICATION = object : MenuIcon {
13     override val iconResId = R.drawable.ab013_notifications
14     override val contentDescription = "Powiadomienia".toLabel("Powiadomienia")
15   }
16   
17   class TopAppBarPPP : CustomPreviewParameterProvider<TopAppBarData>() {
18     override val screenShotTestValues: Sequence<ScreenShotTestData<TopAppBarData>> = sequenceOf(
19       ScreenShotTestData(
20         screenShotTestName = "MediumTopAppBar",
21         value = getMediumTopAppBar(),
22       ),
23       ScreenShotTestData(
24         screenShotTestName = "LargeTopAppBar",
25         value = getLargeTopAppBar(),
26       ),
27       ScreenShotTestData(
28         screenShotTestName = "SmallDefaultTopAppBar - Center",
29         value = getSmallDefaultTopAppBar(titleAlignment = TitleAlignment.Center),
30       ),
31       ScreenShotTestData(
32         screenShotTestName = "SmallDefaultTopAppBar - Left",
33         value = getSmallDefaultTopAppBar(titleAlignment = TitleAlignment.Left),
34       ),
35       ScreenShotTestData(
36         screenShotTestName = "SmallDefaultIconListTopAppBar - Center",
37         value = getSmallDefaultIconListTopAppBar(titleAlignment = TitleAlignment.Center),
38       ),
39       ScreenShotTestData(
40         screenShotTestName = "SmallDefaultIconListTopAppBar - Left",
41         value = getSmallDefaultIconListTopAppBar(titleAlignment = TitleAlignment.Left),
42       ),
43       ScreenShotTestData(
44         screenShotTestName = "SmallDefaultLogoNoTitleTopAppBar",
45         value = getSmallDefaultNoTitleTopAppBar(),
46       ),
47       ScreenShotTestData(
48         screenShotTestName = "SmallDefaultLogoNoActionsTopAppBar",
49         value = getSmallDefaultNoActionsTopAppBar(),
50       ),
51       ScreenShotTestData(
52         screenShotTestName = "SmallDefaultLogoTopNoNavigationAppBar",
53         value = getSmallDefaultNoNavigationTopAppBar(),
54       ),
55       ScreenShotTestData(
56         screenShotTestName = "SmallLogoTopAppBar",
57         value = getSmallLogoTopAppBar(),
58       ),
59       ScreenShotTestData(
60         screenShotTestName = "SmallSygnetTopAppBar",
61         value = getSmallSygnetTopAppBar(),
62       ),
63       ScreenShotTestData(
64         screenShotTestName = "SmallDefaultWithProgressTopAppBar",
65         value = getSmallDefaultWithProgressTopAppBar(),
66       ),
67     )
68   
69     private fun getSmallDefaultNoTitleTopAppBar(): TopAppBarData = TopAppBarData.Small.Default(
70       alignment = TitleAlignment.Center,
71       navigationButtonData = NavigationButtonData(
72         icon = NavigationButtonData.Icon.BACK_ARROW,
73         onClick = {},
74       ),
75       menuType = MenuType.Icon(
76         menuButtonData = MenuButtonData(
77           icon = NOTIFICATION,
78           iconColorProvider = { AppTheme.colors.neutral200 },
79           onClick = {},
80         ),
81       ),
82     )
83   
84     private fun getSmallDefaultNoActionsTopAppBar(): TopAppBarData = TopAppBarData.Small.Default(
85       title = "Small Title".toLabel(),
86       alignment = TitleAlignment.Center,
87       navigationButtonData = NavigationButtonData(
88         icon = NavigationButtonData.Icon.BACK_ARROW,
89         onClick = {},
90       ),
91     )
92   
93     private fun getSmallDefaultNoNavigationTopAppBar(): TopAppBarData = TopAppBarData.Small.Default(
94       title = "Small Title".toLabel(),
95       alignment = TitleAlignment.Center,
96       menuType = MenuType.Icon(
97         menuButtonData = MenuButtonData(
98           icon = NOTIFICATION,
99           iconColorProvider = { AppTheme.colors.neutral200 },
100          onClick = {},
101        ),
102      ),
103    )
104  
105    private fun getSmallDefaultWithProgressTopAppBar(): TopAppBarData = TopAppBarData.Small.Default(
106      title = "Small Title".toLabel(),
107      alignment = TitleAlignment.Center,
108      navigationButtonData = NavigationButtonData(
109        icon = NavigationButtonData.Icon.BACK_ARROW,
110        onClick = {},
111      ),
112      menuType = MenuType.Icon(
113        menuButtonData = MenuButtonData(
114          icon = NOTIFICATION,
115          onClick = {},
116        ),
117      ),
118      progressBarData = ProgressBarData.IndicatorBar(
119        value = 45,
120        label = "45%".toLabel(),
121      ),
122    )
123  
124    private fun getSmallSygnetTopAppBar(): TopAppBarData = TopAppBarData.Small.Sygnet(
125      menuType = MenuType.Icon(
126        menuButtonData = MenuButtonData(
127          icon = NOTIFICATION,
128          onClick = {},
129        ),
130      ),
131    )
132  
133    private fun getSmallLogoTopAppBar(): TopAppBarData = TopAppBarData.Small.Logo()
134  
135    private fun getSmallDefaultTopAppBar(
136      titleAlignment: TitleAlignment,
137    ): TopAppBarData = TopAppBarData.Small.Default(
138      title = "Small Title".toLabel(),
139      alignment = titleAlignment,
140      navigationButtonData = NavigationButtonData(
141        icon = NavigationButtonData.Icon.BACK_ARROW,
142        onClick = {},
143      ),
144      menuType = MenuType.Icon(
145        menuButtonData = MenuButtonData(
146          icon = NOTIFICATION,
147          onClick = {},
148        ),
149      ),
150    )
151  
152    private fun getSmallDefaultIconListTopAppBar(
153      titleAlignment: TitleAlignment,
154    ): TopAppBarData = TopAppBarData.Small.Default(
155      title = "Small Title".toLabel(),
156      alignment = titleAlignment,
157      navigationButtonData = NavigationButtonData(
158        icon = NavigationButtonData.Icon.BACK_ARROW,
159        onClick = {},
160      ),
161      menuType = MenuType.IconList(
162        listOf(
163          MenuButtonData(
164            icon = MenuButtonData.DefaultMenuIcon.CLOSE,
165            iconColorProvider = { AppTheme.colors.neutral200 },
166            onClick = {},
167          ),
168          MenuButtonData(
169            icon = NOTIFICATION,
170            iconColorProvider = { AppTheme.colors.neutral200 },
171            onClick = {},
172          ),
173        ),
174      ),
175  
176    )
177  
178    private fun getLargeTopAppBar() = TopAppBarData.Large(
179      title = "Large Large Large Large Large Large ".toLabel(),
180      navigationButtonData = NavigationButtonData(
181        icon = NavigationButtonData.Icon.BACK_ARROW,
182        onClick = {},
183      ),
184      menuType = MenuType.IconList(
185        menuIconList = listOf(
186          MenuButtonData(
187            icon = MenuButtonData.DefaultMenuIcon.EDIT,
188            onClick = {},
189          ),
190          MenuButtonData(
191            icon = MenuButtonData.DefaultMenuIcon.CLOSE,
192            onClick = {},
193          ),
194          MenuButtonData(
195            icon = NOTIFICATION,
196            onClick = {},
197          ),
198        ),
199      ),
200    )
201  
202    private fun getMediumTopAppBar() = TopAppBarData.Medium(
203      title = "Medium Medium Medium Medium Medium Medium".toLabel(),
204      navigationButtonData = NavigationButtonData(
205        icon = NavigationButtonData.Icon.BACK_ARROW,
206        onClick = {},
207      ),
208      menuType = MenuType.IconList(
209        menuIconList = listOf(
210          MenuButtonData(
211            icon = MenuButtonData.DefaultMenuIcon.QUESTION_MARK,
212            onClick = {},
213          ),
214          MenuButtonData(
215            icon = MenuButtonData.DefaultMenuIcon.EDIT,
216            onClick = {},
217          ),
218          MenuButtonData(
219            icon = NOTIFICATION,
220            onClick = {},
221          ),
222        ),
223      ),
224    )
225  
226  }
227  