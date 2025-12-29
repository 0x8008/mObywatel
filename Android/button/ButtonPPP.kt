1    package pl.gov.coi.common.ui.ds.button
2    
3    import pl.gov.coi.common.ui.ds.button.common.ButtonSize
4    import pl.gov.coi.common.ui.ds.button.common.ButtonState
5    import pl.gov.coi.common.ui.ds.button.common.ButtonType
6    import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
7    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
8    import pl.gov.coi.common.ui.preview.ScreenShotTestData
9    
10   class ButtonPPP : CustomPreviewParameterProvider<ButtonData>() {
11     override val screenShotTestValues: Sequence<ScreenShotTestData<ButtonData>> = sequenceOf(
12       ScreenShotTestData(
13         screenShotTestName = "SmallTextPrimaryEnabled",
14         value = ButtonData(
15           buttonSize = ButtonSize.Small,
16           buttonType = ButtonType.WithText(
17             label = "SmallTextPrimaryEnabled".toLabel(),
18           ),
19           buttonVariant = ButtonVariant.Primary,
20           onClick = {},
21         ),
22       ),
23       ScreenShotTestData(
24         screenShotTestName = "SmallTextPrimaryDestructive",
25         value = ButtonData(
26           buttonSize = ButtonSize.Small,
27           buttonType = ButtonType.WithText(
28             label = "SmallTextPrimaryDestructive".toLabel(),
29           ),
30           buttonVariant = ButtonVariant.Primary,
31           buttonState = ButtonState.Destructive,
32           onClick = {},
33         ),
34       ),
35       ScreenShotTestData(
36         screenShotTestName = "SmallPrimaryDisabled",
37         value = ButtonData(
38           buttonSize = ButtonSize.Small,
39           buttonType = ButtonType.WithText(
40             label = "SmallPrimaryDisabled".toLabel(),
41           ),
42           buttonVariant = ButtonVariant.Primary,
43           buttonState = ButtonState.Disabled,
44           onClick = {},
45         ),
46       ),
47       ScreenShotTestData(
48         screenShotTestName = "SmallSecondaryEnabled",
49         value = ButtonData(
50           buttonSize = ButtonSize.Small,
51           buttonType = ButtonType.WithText(
52             label = "SmallSecondaryEnabled".toLabel(),
53           ),
54           buttonVariant = ButtonVariant.Secondary(),
55           onClick = {},
56         ),
57       ),
58       ScreenShotTestData(
59         screenShotTestName = "SmallSecondaryDestructive",
60         value = ButtonData(
61           buttonSize = ButtonSize.Small,
62           buttonType = ButtonType.WithText(
63             label = "SmallSecondaryDestructive".toLabel(),
64           ),
65           buttonVariant = ButtonVariant.Secondary(),
66           buttonState = ButtonState.Destructive,
67           onClick = {},
68         ),
69       ),
70       ScreenShotTestData(
71         screenShotTestName = "SmallSecondaryDisabled",
72         value = ButtonData(
73           buttonSize = ButtonSize.Small,
74           buttonType = ButtonType.WithText(
75             label = "SmallSecondaryDisabled".toLabel(),
76           ),
77           buttonVariant = ButtonVariant.Secondary(),
78           buttonState = ButtonState.Disabled,
79           onClick = {},
80         ),
81       ),
82       ScreenShotTestData(
83         screenShotTestName = "SmallTertiaryEnabled",
84         value = ButtonData(
85           buttonSize = ButtonSize.Small,
86           buttonType = ButtonType.WithText(
87             label = "SmallTertiaryEnabled".toLabel(),
88           ),
89           buttonVariant = ButtonVariant.Tertiary,
90           onClick = {},
91         ),
92       ),
93       ScreenShotTestData(
94         screenShotTestName = "SmallTertiaryDestructive",
95         value = ButtonData(
96           buttonSize = ButtonSize.Small,
97           buttonType = ButtonType.WithText(
98             label = "SmallTertiaryDestructive".toLabel(),
99           ),
100          buttonVariant = ButtonVariant.Tertiary,
101          buttonState = ButtonState.Destructive,
102          onClick = {},
103        ),
104      ),
105      ScreenShotTestData(
106        screenShotTestName = "SmallTertiaryDisabled",
107        value = ButtonData(
108          buttonSize = ButtonSize.Small,
109          buttonType = ButtonType.WithText(
110            label = "SmallTertiaryDisabled".toLabel(),
111          ),
112          buttonVariant = ButtonVariant.Tertiary,
113          buttonState = ButtonState.Disabled,
114          onClick = {},
115        ),
116      ),
117      ScreenShotTestData(
118        screenShotTestName = "LargePrimaryEnabled",
119        value = ButtonData(
120          buttonSize = ButtonSize.Large(),
121          buttonType = ButtonType.WithText(
122            label = "LargePrimaryEnabled".toLabel(),
123          ),
124          buttonVariant = ButtonVariant.Primary,
125          onClick = {},
126        ),
127      ),
128      ScreenShotTestData(
129        screenShotTestName = "LargePrimaryDestructive",
130        value = ButtonData(
131          buttonSize = ButtonSize.Large(),
132          buttonType = ButtonType.WithText(
133            label = "LargePrimaryDestructive".toLabel(),
134          ),
135          buttonVariant = ButtonVariant.Primary,
136          buttonState = ButtonState.Destructive,
137          onClick = {},
138        ),
139      ),
140      ScreenShotTestData(
141        screenShotTestName = "LargePrimaryDisabled",
142        value = ButtonData(
143          buttonSize = ButtonSize.Large(),
144          buttonType = ButtonType.WithText(
145            label = "LargePrimaryDisabled".toLabel(),
146          ),
147          buttonVariant = ButtonVariant.Primary,
148          buttonState = ButtonState.Disabled,
149          onClick = {},
150        ),
151      ),
152      ScreenShotTestData(
153        screenShotTestName = "LargeSecondaryEnabled",
154        value = ButtonData(
155          buttonSize = ButtonSize.Large(),
156          buttonType = ButtonType.WithText(
157            label = "LargeSecondaryEnabled".toLabel(),
158          ),
159          buttonVariant = ButtonVariant.Secondary(),
160          onClick = {},
161        ),
162      ),
163      ScreenShotTestData(
164        screenShotTestName = "LargeSecondaryDestructive",
165        value = ButtonData(
166          buttonSize = ButtonSize.Large(),
167          buttonType = ButtonType.WithText(
168            label = "LargeSecondaryDestructive".toLabel(),
169          ),
170          buttonVariant = ButtonVariant.Secondary(),
171          buttonState = ButtonState.Destructive,
172          onClick = {},
173        ),
174      ),
175      ScreenShotTestData(
176        screenShotTestName = "LargeSecondaryDisabled",
177        value = ButtonData(
178          buttonSize = ButtonSize.Large(),
179          buttonType = ButtonType.WithText(
180            label = "LargeSecondaryDisabled".toLabel(),
181          ),
182          buttonVariant = ButtonVariant.Secondary(),
183          buttonState = ButtonState.Disabled,
184          onClick = {},
185        ),
186      ),
187      ScreenShotTestData(
188        screenShotTestName = "LargeTertiaryEnabled",
189        value = ButtonData(
190          buttonSize = ButtonSize.Large(),
191          buttonType = ButtonType.WithText(
192            label = "LargeTertiaryEnabled".toLabel(),
193          ),
194          buttonVariant = ButtonVariant.Tertiary,
195          onClick = {},
196        ),
197      ),
198      ScreenShotTestData(
199        screenShotTestName = "LargeTertiaryDestructive",
200        value = ButtonData(
201          buttonSize = ButtonSize.Large(),
202          buttonType = ButtonType.WithText(
203            label = "LargeTertiaryDestructive".toLabel(),
204          ),
205          buttonVariant = ButtonVariant.Tertiary,
206          buttonState = ButtonState.Destructive,
207          onClick = {},
208        ),
209      ),
210      ScreenShotTestData(
211        screenShotTestName = "LargeTertiaryDisabled",
212        value = ButtonData(
213          buttonSize = ButtonSize.Large(),
214          buttonType = ButtonType.WithText(
215            label = "LargeTertiaryDisabled".toLabel(),
216          ),
217          buttonVariant = ButtonVariant.Tertiary,
218          buttonState = ButtonState.Disabled,
219          onClick = {},
220        ),
221      ),
222    )
223  }
224  