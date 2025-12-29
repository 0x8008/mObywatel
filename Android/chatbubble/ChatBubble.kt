1    package pl.gov.coi.common.ui.ds.chatbubble
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.layout.Arrangement
5    import androidx.compose.foundation.layout.Box
6    import androidx.compose.foundation.layout.Column
7    import androidx.compose.foundation.layout.ExperimentalLayoutApi
8    import androidx.compose.foundation.layout.FlowRow
9    import androidx.compose.foundation.layout.Row
10   import androidx.compose.foundation.layout.Spacer
11   import androidx.compose.foundation.layout.fillMaxWidth
12   import androidx.compose.foundation.layout.height
13   import androidx.compose.foundation.layout.padding
14   import androidx.compose.foundation.layout.wrapContentWidth
15   import androidx.compose.material3.Card
16   import androidx.compose.material3.CardDefaults
17   import androidx.compose.runtime.Composable
18   import androidx.compose.runtime.getValue
19   import androidx.compose.runtime.mutableStateOf
20   import androidx.compose.runtime.remember
21   import androidx.compose.runtime.setValue
22   import androidx.compose.ui.Alignment
23   import androidx.compose.ui.Modifier
24   import androidx.compose.ui.graphics.Color
25   import androidx.compose.ui.text.SpanStyle
26   import androidx.compose.ui.text.buildAnnotatedString
27   import androidx.compose.ui.text.font.FontWeight
28   import androidx.compose.ui.text.style.TextAlign
29   import androidx.compose.ui.text.withStyle
30   import androidx.compose.ui.tooling.preview.Preview
31   import androidx.compose.ui.tooling.preview.PreviewParameter
32   import pl.gov.coi.common.domain.label.toLabel
33   import pl.gov.coi.common.ui.ds.button.Button
34   import pl.gov.coi.common.ui.ds.button.ButtonData
35   import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIcon
36   import pl.gov.coi.common.ui.ds.button.common.ButtonSize
37   import pl.gov.coi.common.ui.ds.button.common.ButtonType
38   import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
39   import pl.gov.coi.common.ui.ds.chatbubble.provider.ChatBubblePreviewParameterProvider
40   import pl.gov.coi.common.ui.ds.custom.clickabletext.CustomClickableText
41   import pl.gov.coi.common.ui.text.CustomText
42   import pl.gov.coi.common.ui.theme.AppTheme
43   
44   @OptIn(ExperimentalLayoutApi::class)
45   @Composable
46   fun ChatBubble(
47     modifier: Modifier = Modifier,
48     data: ChatBubbleData,
49   ) {
50     val darkestInfoStatus = Color(0xFF01498B)
51     val lightGrey4 = Color(0xFF333333)
52   
53     Column(
54       modifier = modifier.fillMaxWidth(),
55     ) {
56       Row {
57         Card(
58           modifier = Modifier
59             .padding(
60               start = when (data) {
61                 is ChatBubbleData.IncomingMessage -> AppTheme.dimensions.zero
62                 is ChatBubbleData.OutgoingMessage -> AppTheme.dimensions.spacing600
63               },
64               end = when (data) {
65                 is ChatBubbleData.IncomingMessage -> AppTheme.dimensions.spacing600
66                 is ChatBubbleData.OutgoingMessage -> AppTheme.dimensions.zero
67               },
68             )
69             .weight(1f)
70             .then(
71               when {
72                 data.isLoading -> Modifier.wrapContentWidth(align = Alignment.Start)
73                 data is ChatBubbleData.IncomingMessage -> Modifier.fillMaxWidth()
74                 else -> Modifier.wrapContentWidth(align = Alignment.End)
75               },
76             ),
77           shape = AppTheme.shapes.radius150,
78           colors = CardDefaults.cardColors(
79             containerColor = when (data) {
80               is ChatBubbleData.IncomingMessage -> Color.White
81               is ChatBubbleData.OutgoingMessage -> AppTheme.colors.primary900
82             },
83           ),
84           elevation = CardDefaults.cardElevation(
85             defaultElevation = AppTheme.elevations.level0,
86           ),
87         ) {
88           Column(
89             modifier = Modifier
90               .padding(
91                 start = AppTheme.dimensions.spacing200,
92                 top = AppTheme.dimensions.spacing150,
93                 end = AppTheme.dimensions.spacing200,
94                 bottom = AppTheme.dimensions.spacing200,
95               ),
96           ) {
97             Row(
98               modifier = Modifier
99                 .padding(bottom = AppTheme.dimensions.spacing50),
100              horizontalArrangement = Arrangement.SpaceBetween,
101            ) {
102              data.label?.let { label ->
103                CustomText(
104                  modifier = Modifier
105                    .weight(
106                      weight = 1F,
107                      fill = false,
108                    )
109                    .padding(
110                      top = AppTheme.dimensions.spacing50,
111                      bottom = AppTheme.dimensions.spacing50,
112                    ),
113                  style = AppTheme.typography.bodyMediumRegular,
114                  label = label,
115                )
116              }
117            }
118  
119            if (data.isLoading) {
120              DotsTyping()
121            }
122  
123            val annotatedString = buildAnnotatedString {
124              data.content?.forEach { content ->
125                when (content.type) {
126                  ContentType.TEXT,
127                  ContentType.SOURCE,
128                  ->
129                    withStyle(
130                      style = SpanStyle(
131                        fontStyle = AppTheme.typography.bodyLargeRegular.fontStyle,
132                        color = when (data) {
133                          is ChatBubbleData.IncomingMessage -> lightGrey4
134                          is ChatBubbleData.OutgoingMessage -> AppTheme.colors.white
135                        },
136                      ),
137                    ) {
138                      append(content.value)
139                    }
140  
141                  ContentType.LINK -> if (content.url == null) {
142                    withStyle(
143                      style = SpanStyle(
144                        fontStyle = AppTheme.typography.bodyLargeRegular.fontStyle,
145                        color = lightGrey4,
146                      ),
147                    ) {
148                      append(content.value)
149                    }
150                  } else {
151                    pushStringAnnotation(
152                      tag = content.url,
153                      annotation = content.url,
154                    )
155                    withStyle(
156                      style = SpanStyle(
157                        color = darkestInfoStatus,
158                        fontWeight = FontWeight.Bold,
159                      ),
160                    ) {
161                      append(content.value)
162                    }
163                    pop()
164                  }
165  
166                  ContentType.UNKNOWN -> Unit
167                }
168              }
169            }
170  
171            CustomClickableText(
172              annotatedText = annotatedString,
173              style = AppTheme.typography.bodyLargeRegular.copy(textAlign = TextAlign.Start),
174              onClick = data.onUrlClick,
175            )
176  
177            data.footerData?.let { data -> MessageFooter(footerData = data) }
178          }
179        }
180      }
181  
182      data
183        .actions
184        ?.takeIf { actions -> actions.isNotEmpty() }
185        ?.let { actions -> CtaSection(actions = actions) }
186  
187      data.additionalInfo?.let { additionalInfo ->
188        Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
189        CustomText(
190          label = additionalInfo,
191          style = AppTheme.typography.bodySmallRegular,
192          color = AppTheme.colors.neutral200,
193        )
194      }
195  
196      data.suggestions?.let { suggestions ->
197        Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing300))
198        FlowRow(
199          modifier = Modifier.fillMaxWidth(),
200          horizontalArrangement = Arrangement.spacedBy(
201            space = AppTheme.dimensions.spacing100,
202            alignment = Alignment.End,
203          ),
204          verticalArrangement = Arrangement.spacedBy(space = AppTheme.dimensions.spacing100),
205        ) {
206          suggestions.forEachIndexed { index, suggestion ->
207            Button(
208              data = ButtonData(
209                buttonSize = ButtonSize.Large(
210                  fillMaxWidth = false,
211                ),
212                buttonVariant = ButtonVariant.Secondary(),
213                buttonType = ButtonType.WithText(
214                  label = suggestion.value.toLabel(tag = "suggestionButton_$index"),
215                ),
216                onClick = suggestion.onClick,
217              ),
218            )
219          }
220        }
221      }
222      Spacer(
223        modifier = Modifier
224          .height(height = AppTheme.dimensions.spacing300)
225          .fillMaxWidth(),
226      )
227    }
228  }
229  
230  @ExperimentalLayoutApi
231  @Composable
232  private fun MessageFooter(footerData: FooterData) {
233    var sourcesExpanded by remember {
234      mutableStateOf(false)
235    }
236  
237    if (footerData.isVisible) {
238      Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing250))
239      Row(
240        modifier = Modifier.fillMaxWidth(),
241        verticalAlignment = Alignment.CenterVertically,
242      ) {
243        footerData.sourcesData?.let { sourcesData ->
244          CustomText(
245            label = sourcesData.title,
246            style = AppTheme.typography.bodyMediumMedium,
247            color = AppTheme.colors.neutral500,
248          )
249        }
250  
251        FlowRow(
252          modifier = Modifier.weight(weight = 1f),
253          horizontalArrangement = Arrangement.spacedBy(
254            space = AppTheme.dimensions.spacing100,
255            alignment = Alignment.End,
256          ),
257        ) {
258          footerData.actionsData.forEach { actionData ->
259            ButtonIcon(data = actionData.buttonData)
260          }
261        }
262      }
263    }
264    footerData.sourcesData?.let { sourcesData ->
265      Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing50))
266      Column(modifier = Modifier.fillMaxWidth()) {
267        val visibleSources =
268          when (sourcesExpanded || sourcesData.items.size == 2) {
269            true -> sourcesData.items
270            false -> sourcesData.items.take(1)
271          }
272        visibleSources.forEachIndexed { index, source ->
273          Row(
274            modifier = Modifier.fillMaxWidth(),
275            verticalAlignment = Alignment.CenterVertically,
276          ) {
277            Box(
278              modifier = Modifier
279                .weight(weight = 1F, fill = false),
280            ) {
281              Button(
282                data = ButtonData(
283                  buttonSize = ButtonSize.Small,
284                  buttonVariant = ButtonVariant.Primary,
285                  buttonType = ButtonType.WithText(
286                    label = source.value.toLabel(tag = "sourceButton_$index"),
287                  ),
288                  onClick = source.onClick,
289                ),
290              )
291            }
292            if ((!sourcesExpanded && index == 0 && sourcesData.items.size > 2) ||
293              (sourcesExpanded && index == sourcesData.items.size - 1)
294            ) {
295              Box(
296                modifier = Modifier
297                  .padding(start = AppTheme.dimensions.spacing100),
298              ) {
299                Button(
300                  data = ButtonData(
301                    buttonSize = ButtonSize.Small,
302                    buttonVariant = ButtonVariant.Tertiary,
303                    buttonType = ButtonType.WithText(
304                      label = when (sourcesExpanded) {
305                        true -> sourcesData.showLessButtonLabel
306                        false -> sourcesData.showMoreButtonLabel
307                      },
308                    ),
309                    onClick = {
310                      sourcesExpanded = !sourcesExpanded
311                    },
312                  ),
313                )
314              }
315            }
316          }
317        }
318      }
319    }
320  
321    if (footerData.isVisible) {
322      Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing50))
323    }
324  }
325  
326  @Composable
327  private fun CtaSection(actions: List<ClickableContent>) {
328    Column(
329      modifier = Modifier
330        .fillMaxWidth()
331        .padding(
332          top = AppTheme.dimensions.spacing200,
333          end = AppTheme.dimensions.spacing600,
334        ),
335    ) {
336      actions.forEachIndexed { index, action ->
337        Button(data = action.actionButtonData)
338        if (index != actions.lastIndex) {
339          Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing100))
340        }
341      }
342    }
343  }
344  
345  @Preview
346  @Composable
347  fun ChatBubblePreview(
348    @PreviewParameter(ChatBubblePreviewParameterProvider::class)
349    data: ChatBubbleData,
350  ) {
351    Column(
352      modifier = Modifier
353        .wrapContentWidth()
354        .background(color = AppTheme.colors.background)
355        .padding(all = AppTheme.dimensions.spacing50),
356    ) {
357      ChatBubble(data = data)
358    }
359  }
360  