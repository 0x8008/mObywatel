1    package pl.gov.coi.common.ui.ds.iconpage
2    
3    import pl.gov.coi.common.ui.R
4    import pl.gov.coi.common.ui.ds.button.ButtonData
5    import pl.gov.coi.common.ui.ds.button.common.ButtonSize
6    import pl.gov.coi.common.ui.ds.button.common.ButtonType
7    import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
8    import pl.gov.coi.common.ui.ds.inforow.model.InfoRowData
9    import pl.gov.coi.common.ui.ds.inforow.model.InfoRowListData
10   import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
11   import pl.gov.coi.common.ui.preview.ScreenShotTestData
12   
13   class IconPagePreviewProvider : CustomPreviewParameterProvider<IconPageData<*, *>>() {
14     override val screenShotTestValues: Sequence<ScreenShotTestData<IconPageData<*, *>>> = sequenceOf(
15       ScreenShotTestData(
16         screenShotTestName = "IconPageResultStateFailure",
17         value = IconPageData(
18           iconSection = IconSection.Result.Failure,
19           title = "Icon Page Result Failure".toLabel(),
20           descriptionFirst = "description first".toLabel(),
21           descriptionSecond = "description second".toLabel(),
22           content = null,
23           bottomContent = null,
24         ),
25       ),
26       ScreenShotTestData(
27         screenShotTestName = "IconPageResultStateInfoNoBottomButtons",
28         value = IconPageData(
29           iconSection = IconSection.Result.Info,
30           title = "Icon Page Result Info".toLabel(),
31           descriptionFirst = "description first".toLabel(),
32           content = null,
33           bottomContent = null,
34         ),
35       ),
36       ScreenShotTestData(
37         screenShotTestName = "IconPageResultStateInfoBottomButtons",
38         value = IconPageData(
39           iconSection = IconSection.Result.Info,
40           title = "Icon Page Result Info".toLabel(),
41           descriptionFirst = "description first".toLabel(),
42           content = null,
43           bottomContent = IconPageBottomContentData(
44             primaryButtonData = ButtonData(
45               buttonSize = ButtonSize.Large(),
46               buttonVariant = ButtonVariant.Primary,
47               buttonType = ButtonType.WithText(label = "Dalej".toLabel()),
48               onClick = { },
49             ),
50             secondaryButtonData = ButtonData(
51               buttonSize = ButtonSize.Large(),
52               buttonVariant = ButtonVariant.Secondary(),
53               buttonType = ButtonType.WithText(label = "Zamknij".toLabel()),
54               onClick = { },
55             ),
56           ),
57         ),
58       ),
59       ScreenShotTestData(
60         screenShotTestName = "IconPageResultStateSuccessNoBottomButtons",
61         value = IconPageData(
62           iconSection = IconSection.Result.Success,
63           title = "Icon Page Result Success".toLabel(),
64           descriptionFirst = "description first".toLabel(),
65           content = null,
66           bottomContent = null,
67         ),
68       ),
69       ScreenShotTestData(
70         screenShotTestName = "IconPageResultStateSuccessBottomButtons",
71         value = IconPageData(
72           iconSection = IconSection.Result.Success,
73           title = "Icon Page Result Success".toLabel(),
74           descriptionFirst = "description first".toLabel(),
75           content = null,
76           bottomContent = IconPageBottomContentData(
77             primaryButtonData = ButtonData(
78               buttonSize = ButtonSize.Large(),
79               buttonVariant = ButtonVariant.Primary,
80               buttonType = ButtonType.WithText(label = "Dalej".toLabel()),
81               onClick = { },
82             ),
83             secondaryButtonData = ButtonData(
84               buttonSize = ButtonSize.Large(),
85               buttonVariant = ButtonVariant.Secondary(),
86               buttonType = ButtonType.WithText(label = "Zamknij".toLabel()),
87               onClick = { },
88             ),
89           ),
90         ),
91       ),
92       ScreenShotTestData(
93         screenShotTestName = "IconPageResultStateWarning",
94         value = IconPageData(
95           iconSection = IconSection.Result.Warning,
96           title = "Icon Page Result Success".toLabel(),
97           descriptionFirst = "description first".toLabel(),
98           content = null,
99           bottomContent = null,
100        ),
101      ),
102      ScreenShotTestData(
103        screenShotTestName = "IconPageEmptyStateDescription",
104        value = IconPageData(
105          iconSection = IconSection.Empty(),
106          title = "Icon Page Empty state".toLabel(),
107          descriptionFirst = "description first".toLabel(),
108          content = null,
109          bottomContent = null,
110        ),
111      ),
112      ScreenShotTestData(
113        screenShotTestName = "IconPageEmptyStateNoBottomButtons",
114        value = IconPageData(
115          iconSection = IconSection.Empty(),
116          title = "Icon Page Empty State".toLabel(),
117          content = null,
118          bottomContent = null,
119        ),
120      ),
121      ScreenShotTestData(
122        screenShotTestName = "IconPageEmptyStateBottomButtons",
123        value = IconPageData(
124          iconSection = IconSection.Empty(),
125          title = "Icon Page Empty State".toLabel(),
126          content = null,
127          bottomContent = IconPageBottomContentData(
128            primaryButtonData = ButtonData(
129              buttonSize = ButtonSize.Large(),
130              buttonVariant = ButtonVariant.Primary,
131              buttonType = ButtonType.WithText(label = "Dalej".toLabel()),
132              onClick = { },
133            ),
134            secondaryButtonData = ButtonData(
135              buttonSize = ButtonSize.Large(),
136              buttonVariant = ButtonVariant.Secondary(),
137              buttonType = ButtonType.WithText(label = "Zamknij".toLabel()),
138              onClick = { },
139            ),
140          ),
141        ),
142      ),
143      ScreenShotTestData(
144        screenShotTestName = "IconPageEmptyIconDescription",
145        value = IconPageData(
146          iconSection = IconSection.Empty(
147            iconRes = R.drawable.g005_mbiznes,
148          ),
149          title = "Icon Page Empty State".toLabel(),
150          descriptionFirst = "description first".toLabel(),
151          descriptionSecond = "description second".toLabel(),
152          content = null,
153          bottomContent = null,
154        ),
155      ),
156      ScreenShotTestData(
157        screenShotTestName = "IconPageEmptyWithContentNoBottomButtons",
158        value = IconPageData(
159          iconSection = IconSection.Empty(
160            iconRes = R.drawable.g005_mbiznes,
161          ),
162          title = "Icon Page Empty State".toLabel(),
163          descriptionFirst = "description first".toLabel(),
164          descriptionSecond = "description second".toLabel(),
165          content = InfoRowListData(
166            items = listOf(
167              InfoRowData.Bullet(
168                description = "Support text font: bodyLargeRegular color: neutral200".toLabel(),
169              ),
170              InfoRowData.Bullet(
171                description = "Support text font: bodyLargeRegular color: neutral200".toLabel(),
172              ),
173              InfoRowData.Bullet(
174                description = "Support text font: bodyLargeRegular color: neutral200".toLabel(),
175              ),
176            ),
177          ),
178          bottomContent = null,
179        ),
180      ),
181      ScreenShotTestData(
182        screenShotTestName = "IconPageEmptyWithContentBottomButtons",
183        value = IconPageData(
184          iconSection = IconSection.Empty(
185            iconRes = R.drawable.g005_mbiznes,
186          ),
187          title = "Icon Page Empty State".toLabel(),
188          descriptionFirst = "description first".toLabel(),
189          descriptionSecond = "description second".toLabel(),
190          content = InfoRowListData(
191            items = listOf(
192              InfoRowData.Bullet(
193                description = "Support text font: bodyLargeRegular color: neutral200".toLabel(),
194              ),
195              InfoRowData.Bullet(
196                description = "Support text font: bodyLargeRegular color: neutral200".toLabel(),
197              ),
198              InfoRowData.Bullet(
199                description = "Support text font: bodyLargeRegular color: neutral200".toLabel(),
200              ),
201            ),
202          ),
203          bottomContent = IconPageBottomContentData(
204            primaryButtonData = ButtonData(
205              buttonSize = ButtonSize.Large(),
206              buttonVariant = ButtonVariant.Primary,
207              buttonType = ButtonType.WithText(label = "Dalej".toLabel()),
208              onClick = { },
209            ),
210            secondaryButtonData = ButtonData(
211              buttonSize = ButtonSize.Large(),
212              buttonVariant = ButtonVariant.Secondary(),
213              buttonType = ButtonType.WithText(label = "Zamknij".toLabel()),
214              onClick = { },
215            ),
216          ),
217        ),
218      ),
219    )
220  }
221  