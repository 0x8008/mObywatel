1    package pl.gov.coi.common.ui.ds.chatbubble.provider
2    
3    import pl.gov.coi.common.ui.ds.chatbubble.ChatBubbleData
4    import pl.gov.coi.common.ui.ds.chatbubble.ClickableContent
5    import pl.gov.coi.common.ui.ds.chatbubble.Content
6    import pl.gov.coi.common.ui.ds.chatbubble.ContentType
7    import pl.gov.coi.common.ui.ds.chatbubble.FooterData
8    import pl.gov.coi.common.ui.ds.chatbubble.FooterActionData
9    import pl.gov.coi.common.ui.ds.chatbubble.SourcesData
10   import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
11   import pl.gov.coi.common.ui.preview.ScreenShotTestData
12   
13   class ChatBubblePreviewParameterProvider : CustomPreviewParameterProvider<ChatBubbleData>() {
14   
15     override val screenShotTestValues: Sequence<ScreenShotTestData<ChatBubbleData>> = sequenceOf(
16       ScreenShotTestData(
17         screenShotTestName = "ChatBubbleBotLoading",
18         value = provideChatBubbleBotLoadingPreviewData(),
19       ),
20       ScreenShotTestData(
21         screenShotTestName = "ChatBubbleBot",
22         value = provideChatBubbleBotPreviewData(),
23       ),
24       ScreenShotTestData(
25         screenShotTestName = "ChatBubbleUser",
26         value = provideChatBubbleUserPreviewData(),
27       ),
28       ScreenShotTestData(
29         screenShotTestName = "ChatBubbleBotWithOptionsWithSources",
30         value = provideChatBubbleBotWithOptionsPreviewData(
31           sourcesData = SourcesData(
32             title = "Źródło".toLabel(),
33             showMoreButtonLabel = "+ X więcej".toLabel(),
34             showLessButtonLabel = "Pokaż mniej".toLabel(),
35             items = listOf(
36               ClickableContent(
37                 value = "1. Gov.pl",
38                 onClick = {},
39               ),
40               ClickableContent(
41                 value = "2. Gov.pl",
42                 onClick = {},
43               ),
44               ClickableContent(
45                 value = "3. Gov.pl",
46                 onClick = {},
47               ),
48             ),
49           ),
50         ),
51       ),
52       ScreenShotTestData(
53         screenShotTestName = "ChatBubbleBotWithOptionsWithoutSources",
54         value = provideChatBubbleBotWithOptionsPreviewData(
55           sourcesData = null,
56         ),
57       ),
58     )
59   
60     private fun provideChatBubbleBotLoadingPreviewData() =
61       ChatBubbleData.IncomingMessage(
62         label = "Wirtualny asystent".toLabel(),
63       )
64   
65     private fun provideChatBubbleBotPreviewData() =
66       ChatBubbleData.IncomingMessage(
67         label = "Wirtualny asystent".toLabel(),
68         isLoading = false,
69         content = listOf(
70           Content(
71             type = ContentType.TEXT,
72             value = "Treść odpowiedzi bota - jakaś dłuższa, żeby było widać jak wygląda wielolinijkowo. " +
73               "Dalsza część odpowiedzi, jeszcze trochę znaków.",
74           ),
75         ),
76       )
77   
78     private fun provideChatBubbleUserPreviewData() =
79       ChatBubbleData.OutgoingMessage(
80         content = listOf(
81           Content(
82             type = ContentType.TEXT,
83             value = "Treść pytania użytkownika",
84           ),
85         ),
86       )
87   
88     private fun provideChatBubbleBotWithOptionsPreviewData(sourcesData: SourcesData?) =
89       ChatBubbleData.IncomingMessage(
90         label = "Wirtualny asystent".toLabel(),
91         isLoading = false,
92         content = listOf(
93           Content(
94             type = ContentType.TEXT,
95             value = "To jest jakiś tekst, a tutaj jest ",
96           ),
97           Content(
98             type = ContentType.LINK,
99             value = "link",
100            url = "www.gov.pl",
101          ),
102          Content(
103            type = ContentType.TEXT,
104            value = ". To wszystko jest z naszego źródła ",
105          ),
106          Content(
107            type = ContentType.SOURCE,
108            value = "(1)",
109            url = "www.gov.pl",
110          ),
111          Content(
112            type = ContentType.TEXT,
113            value = ". Dalszy tekst.",
114          ),
115        ),
116        additionalInfo = "Odpowiedź 2 z 10".toLabel(),
117        footerData = FooterData(
118          sourcesData = sourcesData,
119          actionsData = listOf(
120            FooterActionData.Toggleable.PositiveRate(isSelected = true, onToggle = {}),
121            FooterActionData.Toggleable.NegativeRate(isSelected = false, onToggle = {}),
122            FooterActionData.Share(onClick = {}),
123          ),
124        ),
125        actions = listOf(
126          ClickableContent(
127            value = "Zgłoś naruszenie",
128            onClick = {},
129          ),
130          ClickableContent(
131            value = "Akcja",
132            onClick = {},
133          ),
134        ),
135        suggestions = listOf(
136          ClickableContent(
137            value = "Jak założyć profil zaufany?",
138            onClick = {},
139          ),
140          ClickableContent(
141            value = "Jak złożyć wniosek o dodatek elektryczny?",
142            onClick = {},
143          ),
144        ),
145        onUrlClick = {},
146      )
147  }
148  