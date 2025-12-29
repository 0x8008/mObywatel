1    package pl.gov.coi.common.ui.ds.accordion.provider
2    
3    import androidx.compose.runtime.Composable
4    import pl.gov.coi.common.domain.label.toLabel
5    import pl.gov.coi.common.ui.ds.accordion.AccordionData
6    import pl.gov.coi.common.ui.ds.accordion.AccordionElement
7    import pl.gov.coi.common.ui.ds.accordion.CustomAccordionContent
8    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
9    import pl.gov.coi.common.ui.preview.ScreenShotTestData
10   import pl.gov.coi.common.ui.text.CustomText
11   import pl.gov.coi.common.ui.timeline.Timeline
12   import pl.gov.coi.common.ui.timeline.TimelineData
13   import pl.gov.coi.common.ui.timeline.TimelineItemData
14   import pl.gov.coi.common.ui.unmapped.cardlist.ColumnCardList
15   import pl.gov.coi.common.ui.unmapped.cardlist.model.CardListData
16   import pl.gov.coi.common.ui.unmapped.singlecard.BodySection
17   import pl.gov.coi.common.ui.unmapped.singlecard.BodyTitleSection
18   import pl.gov.coi.common.ui.unmapped.singlecard.DefaultSingleCardData
19   import pl.gov.coi.common.ui.unmapped.singlecard.SingleCardLabel
20   
21   class AccordionPreviewParameterProvider : CustomPreviewParameterProvider<AccordionData>() {
22   
23     override val screenShotTestValues: Sequence<ScreenShotTestData<AccordionData>> = sequenceOf(
24       ScreenShotTestData(
25         screenShotTestName = "AccordionSingle",
26         value = provideAccordionSinglePreviewData(),
27       ),
28       ScreenShotTestData(
29         screenShotTestName = "AccordionSingleExpanded",
30         value = provideAccordionSingleExpandedPreviewData(),
31       ),
32       ScreenShotTestData(
33         screenShotTestName = "AccordionSingleHistoryExpanded",
34         value = provideAccordionSingleHistoryExpandedPreviewData(),
35       ),
36       ScreenShotTestData(
37         screenShotTestName = "AccordionList",
38         value = provideAccordionListPreviewData(),
39       ),
40       ScreenShotTestData(
41         screenShotTestName = "AccordionListOneExpanded",
42         value = provideAccordionListOneExpandedPreviewData(),
43       ),
44       ScreenShotTestData(
45         screenShotTestName = "AccordionSingleCardContent",
46         value = provideAccordionSingleCardPreviewData(),
47       ),
48     )
49   
50     private fun provideAccordionSingleCardPreviewData() = AccordionData(
51       elements = listOf(
52         AccordionElement(
53           header = "Accordion single header".toLabel(),
54           addContentPadding = false,
55           content = object : CustomAccordionContent {
56             @Composable
57             override fun Content() {
58               ColumnCardList(
59                 data = CardListData(
60                   singleCardList = listOf(
61                     DefaultSingleCardData(
62                       bodySection = BodySection(
63                         title = BodyTitleSection.Title(
64                           singleCardLabel = SingleCardLabel(
65                             label = "SingleCard 1".toLabel(),
66                           ),
67                         ),
68                       ),
69                     ),
70                     DefaultSingleCardData(
71                       bodySection = BodySection(
72                         title = BodyTitleSection.Title(
73                           singleCardLabel = SingleCardLabel(
74                             label = "SingleCard 2".toLabel(),
75                           ),
76                         ),
77                       ),
78                     ),
79                     DefaultSingleCardData(
80                       bodySection = BodySection(
81                         title = BodyTitleSection.Title(
82                           singleCardLabel = SingleCardLabel(
83                             label = "SingleCard 3".toLabel(),
84                           ),
85                         ),
86                       ),
87                     ),
88                   ),
89                 ),
90               )
91             }
92           },
93           initialExpanded = true,
94           onListExpanded = {},
95         ),
96       ),
97     )
98   
99     private fun provideAccordionSinglePreviewData() =
100      AccordionData(
101        elements = listOf(
102          AccordionElement(
103            header = "Accordion single header".toLabel(),
104            content = CustomTextAccordionContent(),
105            initialExpanded = false,
106            onListExpanded = {},
107          ),
108        ),
109      )
110  
111    private fun provideAccordionSingleExpandedPreviewData() =
112      AccordionData(
113        elements = listOf(
114          AccordionElement(
115            header = "Accordion expanded header".toLabel(),
116            content = CustomTextAccordionContent(),
117            initialExpanded = true,
118            onListExpanded = {},
119          ),
120        ),
121      )
122  
123    private fun provideAccordionSingleHistoryExpandedPreviewData() =
124      AccordionData(
125        elements = listOf(
126          AccordionElement(
127            header = "Accordion history expanded header".toLabel(),
128            content = CustomTimelineAccordionContent(),
129            initialExpanded = true,
130            onListExpanded = {},
131          ),
132        ),
133      )
134  
135    private fun provideAccordionListPreviewData() =
136      AccordionData(
137        elements = listOf(
138          AccordionElement(
139            header = "Accordion header 1".toLabel(),
140            content = CustomTextAccordionContent(),
141            initialExpanded = false,
142            onListExpanded = {},
143          ),
144          AccordionElement(
145            header = "Accordion header 2".toLabel(),
146            content = CustomTextAccordionContent(),
147            initialExpanded = false,
148            onListExpanded = {},
149          ),
150          AccordionElement(
151            header = "Accordion header 3".toLabel(),
152            content = CustomTextAccordionContent(),
153            initialExpanded = false,
154            onListExpanded = {},
155          ),
156        ),
157      )
158  
159    private fun provideAccordionListOneExpandedPreviewData() =
160      AccordionData(
161        elements = listOf(
162          AccordionElement(
163            header = "Accordion header 1 expanded".toLabel(),
164            content = CustomTextAccordionContent(),
165            initialExpanded = true,
166            onListExpanded = {},
167          ),
168          AccordionElement(
169            header = "Accordion header 2".toLabel(),
170            content = CustomTextAccordionContent(),
171            initialExpanded = false,
172            onListExpanded = {},
173          ),
174          AccordionElement(
175            header = "Accordion header 3".toLabel(),
176            content = CustomTextAccordionContent(),
177            initialExpanded = false,
178            onListExpanded = {},
179          ),
180        ),
181      )
182  
183    private class CustomTextAccordionContent : CustomAccordionContent {
184      @Composable
185      override fun Content() {
186        CustomText(label = "Provide content here".toLabel(""))
187      }
188    }
189  
190    private class CustomTimelineAccordionContent : CustomAccordionContent {
191      @Composable
192      override fun Content() {
193        Timeline(
194          data = TimelineData(
195            items = listOf(
196              TimelineItemData(
197                label = "02.08.2023 12:00".toLabel(""),
198                title = "Primary Bold".toLabel(""),
199                description = "Urząd Stanu Cywilnego w Bolesławcu".toLabel(""),
200              ),
201              TimelineItemData(
202                label = "01.08.2023 12:00".toLabel(""),
203                title = "Primary Bold".toLabel(""),
204              ),
205            ),
206          ),
207        )
208      }
209    }
210  }
211  