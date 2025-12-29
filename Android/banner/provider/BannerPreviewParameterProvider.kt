1    package pl.gov.coi.common.ui.ds.banner.provider
2    
3    import pl.gov.coi.common.domain.label.Label
4    import pl.gov.coi.common.domain.label.toLabel
5    import pl.gov.coi.common.ui.ds.banner.BannerData
6    import pl.gov.coi.common.ui.ds.button.ButtonData
7    import pl.gov.coi.common.ui.ds.button.buttontext.ButtonTextData
8    import pl.gov.coi.common.ui.ds.button.common.ButtonSize
9    import pl.gov.coi.common.ui.ds.button.common.ButtonType
10   import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
11   import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
12   import pl.gov.coi.common.ui.preview.ScreenShotTestData
13   
14   class BannerPreviewParameterProvider : CustomPreviewParameterProvider<BannerData>() {
15     override val screenShotTestValues: Sequence<ScreenShotTestData<BannerData>> = sequenceOf(
16       ScreenShotTestData(
17         screenShotTestName = "BannerInfoWithoutTitle",
18         value = provideBannerInfoWithoutTitle(),
19       ),
20       ScreenShotTestData(
21         screenShotTestName = "BannerInfo",
22         value = provideBannerInfo(),
23       ),
24       ScreenShotTestData(
25         screenShotTestName = "BannerInfoFull",
26         value = provideBannerInfoFull(),
27       ),
28       ScreenShotTestData(
29         screenShotTestName = "BannerInfoErrorWithoutTitle",
30         value = provideBannerErrorWithoutTitle(),
31       ),
32       ScreenShotTestData(
33         screenShotTestName = "BannerError",
34         value = provideBannerError(),
35       ),
36       ScreenShotTestData(
37         screenShotTestName = "BannerErrorFull",
38         value = provideBannerErrorFull(),
39       ),
40       ScreenShotTestData(
41         screenShotTestName = "BannerHighEmphasisInfoWithoutTitle",
42         value = provideBannerHighEmphasisInfoWithoutTitle(),
43       ),
44       ScreenShotTestData(
45         screenShotTestName = "BannerHighEmphasisInfo",
46         value = provideBannerHighEmphasisInfo(),
47       ),
48       ScreenShotTestData(
49         screenShotTestName = "BannerHighEmphasisInfoFull",
50         value = provideBannerHighEmphasisInfoFull(),
51       ),
52       ScreenShotTestData(
53         screenShotTestName = "BannerHighEmphasisErrorWithoutTitle",
54         value = provideBannerHighEmphasisErrorWithoutTitle(),
55       ),
56       ScreenShotTestData(
57         screenShotTestName = "BannerHighEmphasisError",
58         value = provideBannerHighEmphasisError(),
59       ),
60       ScreenShotTestData(
61         screenShotTestName = "BannerHighEmphasisErrorFull",
62         value = provideBannerHighEmphasisErrorFull(),
63       ),
64     )
65   
66     private fun provideBannerInfoWithoutTitle() = BannerData.Info(
67       bodyText = (
68         "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
69           "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
70         ).toLabel(),
71       iconContentDescription = Label.EMPTY,
72     )
73   
74     private fun provideBannerInfo() = BannerData.Info(
75       title = "Info banner".toLabel(),
76       bodyText = (
77         "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
78           "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
79         ).toLabel(),
80       iconContentDescription = Label.EMPTY,
81     )
82   
83     private fun provideBannerInfoFull() = BannerData.Info(
84       title = "Info banner".toLabel(),
85       bodyText = (
86         "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
87           "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
88         ).toLabel(),
89       iconContentDescription = Label.EMPTY,
90       buttonData = ButtonTextData(
91         label = "Text button".toLabel(),
92       ) {},
93       onCloseButtonClick = {},
94     )
95   
96     private fun provideBannerErrorWithoutTitle() = BannerData.Error(
97       bodyText = (
98         "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
99           "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
100        ).toLabel(),
101      iconContentDescription = Label.EMPTY,
102    )
103  
104    private fun provideBannerError() = BannerData.Error(
105      title = "Error banner".toLabel(),
106      bodyText = (
107        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
108          "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
109        ).toLabel(),
110      iconContentDescription = Label.EMPTY,
111    )
112  
113    private fun provideBannerErrorFull() = BannerData.Error(
114      title = "Error banner with very very very very long title".toLabel(),
115      bodyText = (
116        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
117          "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
118        ).toLabel(),
119      iconContentDescription = Label.EMPTY,
120      buttonData = ButtonTextData(
121        label = "Text Button".toLabel(),
122      ) {},
123      onCloseButtonClick = {},
124    )
125  
126    private fun provideBannerHighEmphasisInfoWithoutTitle() = BannerData.HighEmphasisInfo(
127      bodyText = (
128        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
129          "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
130        ).toLabel(),
131      iconContentDescription = Label.EMPTY,
132    )
133  
134    private fun provideBannerHighEmphasisInfo() = BannerData.HighEmphasisInfo(
135      title = "High emphasis info banner".toLabel(),
136      bodyText = (
137        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
138          "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
139        ).toLabel(),
140      iconContentDescription = Label.EMPTY,
141    )
142  
143    private fun provideBannerHighEmphasisInfoFull() = BannerData.HighEmphasisInfo(
144      title = "High emphasis info banner".toLabel(),
145      bodyText = (
146        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
147          "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
148        ).toLabel(),
149      iconContentDescription = Label.EMPTY,
150      buttonData = ButtonData(
151        buttonSize = ButtonSize.Small,
152        buttonVariant = ButtonVariant.Secondary(
153          reversedColor = true,
154        ),
155        buttonType = ButtonType.WithText(
156          label = "Small Button".toLabel(),
157        ),
158        onClick = {},
159      ),
160      onCloseButtonClick = {},
161    )
162  
163    private fun provideBannerHighEmphasisErrorWithoutTitle() = BannerData.HighEmphasisError(
164      bodyText = (
165        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
166          "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
167        ).toLabel(),
168      iconContentDescription = Label.EMPTY,
169    )
170  
171    private fun provideBannerHighEmphasisError() = BannerData.HighEmphasisError(
172      title = "High emphasis error banner".toLabel(),
173      bodyText = (
174        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
175          "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
176        ).toLabel(),
177      iconContentDescription = Label.EMPTY,
178    )
179  
180    private fun provideBannerHighEmphasisErrorFull() = BannerData.HighEmphasisError(
181      title = "High emphasis error banner".toLabel(),
182      bodyText = (
183        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
184          "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
185        ).toLabel(),
186      iconContentDescription = Label.EMPTY,
187      buttonData = ButtonData(
188        buttonSize = ButtonSize.Small,
189        buttonVariant = ButtonVariant.Secondary(
190          reversedColor = true,
191        ),
192        buttonType = ButtonType.WithText(
193          label = "Small Button".toLabel(),
194        ),
195        onClick = {},
196      ),
197      onCloseButtonClick = {},
198    )
199  }
200  