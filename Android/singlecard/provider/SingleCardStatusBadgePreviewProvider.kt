1    package pl.gov.coi.common.ui.ds.singlecard.provider
2    
3    import pl.gov.coi.common.domain.label.Label
4    import pl.gov.coi.common.ui.ds.singlecard.SingleCardStatusBadgeData
5    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
6    import pl.gov.coi.common.ui.preview.ScreenShotTestData
7    
8    /* 
9     TODO REMOVE MOB-49304 
10    */
11   class SingleCardStatusBadgePreviewProvider : CustomPreviewParameterProvider<SingleCardStatusBadgeData>() {
12     override val screenShotTestValues: Sequence<ScreenShotTestData<SingleCardStatusBadgeData>>
13       get() = sequenceOf(
14         ScreenShotTestData(
15           screenShotTestName = " StatusBadgeDataDefaultGreen",
16           value = SingleCardStatusBadgeData.Default.Green(
17             text = "Roboto, Medium, 16, Neutral-500".toLabel(),
18           ),
19         ),
20         ScreenShotTestData(
21           screenShotTestName = " StatusBadgeDataDefaultYellow",
22           value = SingleCardStatusBadgeData.Default.Yellow(
23             text = "Roboto, Medium, 16, Neutral-500".toLabel(),
24           ),
25         ),
26         ScreenShotTestData(
27           screenShotTestName = " StatusBadgeDataDefaultRed",
28           value = SingleCardStatusBadgeData.Default.Red(
29             text = "Roboto, Medium, 16, Neutral-500".toLabel(),
30           ),
31         ),
32         ScreenShotTestData(
33           screenShotTestName = " StatusBadgeDataDefaultBlue",
34           value = SingleCardStatusBadgeData.Default.Blue(
35             text = "Roboto, Medium, 16, Neutral-500".toLabel(),
36           ),
37         ),
38         ScreenShotTestData(
39           screenShotTestName = " StatusBadgeDataWithNoIconNormal",
40           value = SingleCardStatusBadgeData.WithNoIcon.Normal(
41             text = "Roboto, Regular, 14, Neutral-200".toLabel(),
42           ),
43         ),
44         ScreenShotTestData(
45           screenShotTestName = " StatusBadgeDataWithNoIconError",
46           value = SingleCardStatusBadgeData.WithNoIcon.Error(
47             text = "Roboto, Medium, 14, Red-100".toLabel(),
48           ),
49         ),
50   
51         ScreenShotTestData(
52           screenShotTestName = " StatusBadgeDataWithIconSuccess",
53           value = SingleCardStatusBadgeData.WithIcon.Success(
54             text = "Roboto, Regular, 12, Neutral-200".toLabel(),
55             iconContentDescription = Label.EMPTY,
56           ),
57         ),
58         ScreenShotTestData(
59           screenShotTestName = " StatusBadgeDataWithIconError",
60           value = SingleCardStatusBadgeData.WithIcon.Error(
61             text = "Roboto, Regular, 12, Neutral-200".toLabel(),
62             iconContentDescription = Label.EMPTY,
63           ),
64         ),
65         ScreenShotTestData(
66           screenShotTestName = " StatusBadgeDataWithIconWarning",
67           value = SingleCardStatusBadgeData.WithIcon.Warning(
68             text = "Roboto, Regular, 12, Neutral-200".toLabel(),
69             iconContentDescription = Label.EMPTY,
70           ),
71         ),
72         ScreenShotTestData(
73           screenShotTestName = " StatusBadgeDataWithIconInfo",
74           value = SingleCardStatusBadgeData.WithIcon.Info(
75             text = "Roboto, Regular, 12, Neutral-200".toLabel(),
76             iconContentDescription = Label.EMPTY,
77           ),
78         ),
79         ScreenShotTestData(
80           screenShotTestName = " StatusBadgeDataWithIconAndBorderActive",
81           value = SingleCardStatusBadgeData.WithIconAndBorder.Active(
82             text = "Roboto, Regular, 12, Neutral-200".toLabel(),
83             iconContentDescription = Label.EMPTY,
84           ),
85         ),
86         ScreenShotTestData(
87           screenShotTestName = " StatusBadgeDataWithIconAndBorderActive",
88           value = SingleCardStatusBadgeData.WithIconAndBorder.ActionNeeded(
89             text = "Roboto, Regular, 12, Neutral-200".toLabel(),
90             iconContentDescription = Label.EMPTY,
91           ),
92         ),
93         ScreenShotTestData(
94           screenShotTestName = " StatusBadgeDataWithIconAndBorderFailure",
95           value = SingleCardStatusBadgeData.WithIconAndBorder.Failure(
96             text = "Roboto, Regular, 12, Neutral-200".toLabel(),
97             iconContentDescription = Label.EMPTY,
98           ),
99         ),
100        ScreenShotTestData(
101          screenShotTestName = " StatusBadgeDataWithIconAndBorderCanceled",
102          value = SingleCardStatusBadgeData.WithIconAndBorder.Canceled(
103            text = "Roboto, Regular, 12, Neutral-200".toLabel(),
104            iconContentDescription = Label.EMPTY,
105          ),
106        ),
107        ScreenShotTestData(
108          screenShotTestName = " StatusBadgeDataWithDotAndBorderGreen",
109          value = SingleCardStatusBadgeData.WithDotAndBorder.Green(
110            text = "Roboto, Regular, 12, Neutral-200".toLabel(),
111            isColored = false,
112          ),
113        ),
114        ScreenShotTestData(
115          screenShotTestName = " StatusBadgeDatWithDotAndBorderYellow",
116          value = SingleCardStatusBadgeData.WithDotAndBorder.Yellow(
117            text = "Roboto, Regular, 12, Neutral-200".toLabel(),
118            isColored = false,
119          ),
120        ),
121        ScreenShotTestData(
122          screenShotTestName = " StatusBadgeDataWithDotAndBorderRed",
123          value = SingleCardStatusBadgeData.WithDotAndBorder.Red(
124            text = "Roboto, Regular, 12, Neutral-200".toLabel(),
125            isColored = false,
126          ),
127        ),
128        ScreenShotTestData(
129          screenShotTestName = " StatusBadgeDataWithDotAndBorderBlue",
130          value = SingleCardStatusBadgeData.WithDotAndBorder.Blue(
131            text = "Roboto, Regular, 12, Neutral-200".toLabel(),
132            isColored = false,
133          ),
134        ),
135        ScreenShotTestData(
136          screenShotTestName = " StatusBadgeDataWithDotAndBorderGreenColored",
137          value = SingleCardStatusBadgeData.WithDotAndBorder.Green(
138            text = "Roboto, Regular, 12, Neutral-200".toLabel(),
139            isColored = true,
140          ),
141        ),
142        ScreenShotTestData(
143          screenShotTestName = " StatusBadgeDataWithDotAndBorderYellowColored",
144          value = SingleCardStatusBadgeData.WithDotAndBorder.Yellow(
145            text = "Roboto, Regular, 12, Neutral-200".toLabel(),
146            isColored = true,
147          ),
148        ),
149        ScreenShotTestData(
150          screenShotTestName = " StatusBadgeDatWithDotAndBorderRedColored",
151          value = SingleCardStatusBadgeData.WithDotAndBorder.Red(
152            text = "Roboto, Regular, 12, Neutral-200".toLabel(),
153            isColored = true,
154          ),
155        ),
156        ScreenShotTestData(
157          screenShotTestName = " StatusBadgeDataWithDotAndBorderBlueColored",
158          value = SingleCardStatusBadgeData.WithDotAndBorder.Blue(
159            text = "Roboto, Regular, 12, Neutral-200".toLabel(),
160            isColored = true,
161          ),
162        ),
163        ScreenShotTestData(
164          screenShotTestName = " StatusBadgeDataElevatedGreen",
165          value = SingleCardStatusBadgeData.Elevated.Green(
166            text = "Roboto, Regular, 12, Neutral-200".toLabel(),
167          ),
168        ),
169        ScreenShotTestData(
170          screenShotTestName = " StatusBadgeDataElevatedYellow",
171          value = SingleCardStatusBadgeData.Elevated.Yellow(
172            text = "Roboto, Regular, 12, Neutral-200".toLabel(),
173          ),
174        ),
175        ScreenShotTestData(
176          screenShotTestName = " StatusBadgeDataElevatedRed",
177          value = SingleCardStatusBadgeData.Elevated.Red(
178            text = "Roboto, Regular, 12, Neutral-200".toLabel(),
179          ),
180        ),
181        ScreenShotTestData(
182          screenShotTestName = " StatusBadgeDataElevatedBlue",
183          value = SingleCardStatusBadgeData.Elevated.Blue(
184            text = "Roboto, Regular, 12, Neutral-200".toLabel(),
185          ),
186        ),
187      )
188  }
189  