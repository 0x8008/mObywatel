1    @file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
2    
3    package pl.gov.coi.common.ui.ds.singlecard
4    
5    import androidx.compose.foundation.BorderStroke
6    import androidx.compose.foundation.layout.Arrangement
7    import androidx.compose.foundation.layout.Column
8    import androidx.compose.foundation.layout.Row
9    import androidx.compose.foundation.layout.RowScope
10   import androidx.compose.foundation.layout.Spacer
11   import androidx.compose.foundation.layout.defaultMinSize
12   import androidx.compose.foundation.layout.fillMaxWidth
13   import androidx.compose.foundation.layout.height
14   import androidx.compose.foundation.layout.padding
15   import androidx.compose.foundation.layout.width
16   import androidx.compose.foundation.shape.RoundedCornerShape
17   import androidx.compose.material3.Card
18   import androidx.compose.material3.CardDefaults
19   import androidx.compose.material3.ExperimentalMaterial3Api
20   import androidx.compose.runtime.Composable
21   import androidx.compose.runtime.remember
22   import androidx.compose.ui.Alignment
23   import androidx.compose.ui.Modifier
24   import androidx.compose.ui.graphics.Color
25   import androidx.compose.ui.semantics.semantics
26   import androidx.compose.ui.semantics.testTag
27   import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIcon
28   import pl.gov.coi.common.ui.ds.custom.icon.Icon
29   import pl.gov.coi.common.ui.text.CustomText
30   import pl.gov.coi.common.ui.theme.AppTheme
31   import pl.gov.coi.common.ui.utils.MultipleEventsCutter
32   import pl.gov.coi.common.ui.utils.NoRippleInteractionSource
33   import pl.gov.coi.common.ui.utils.get
34   
35   @OptIn(ExperimentalMaterial3Api::class)
36   @Composable
37   internal fun SingleCardClickable(data: SingleCardData.Clickable) {
38     val multipleEventsCutter = remember { MultipleEventsCutter.get() }
39   
40     Card(
41       modifier = Modifier.semantics { testTag = data.title.tag },
42       colors = CardDefaults.cardColors(containerColor = AppTheme.colors.white),
43       border = if (data.state == SingleCardClickableRadioButtonState.FOCUS) {
44         BorderStroke(
45           width = AppTheme.dimensions.spacing25,
46           color = AppTheme.colors.primary900,
47         )
48       } else {
49         null
50       },
51       interactionSource = NoRippleInteractionSource(),
52       onClick = {
53         if (data.state != SingleCardClickableRadioButtonState.DISABLED) {
54           multipleEventsCutter.processEvent { data.onClick() }
55         }
56       },
57       shape = RoundedCornerShape(AppTheme.dimensions.spacing200),
58     ) {
59       Row(
60         verticalAlignment = Alignment.CenterVertically,
61         modifier = Modifier
62           .defaultMinSize(minHeight = SINGLE_CARD_MINIMUM_HEIGHT)
63           .fillMaxWidth()
64           .padding(all = AppTheme.dimensions.spacing250),
65       ) {
66         when (data) {
67           is SingleCardData.Clickable.Title -> SingleCardClickableTitleContent(data = data)
68           is SingleCardData.Clickable.TitleDescription -> SingleCardClickableTitleDescriptionContent(data = data)
69           is SingleCardData.Clickable.InfoTitle -> SingleCardClickableInfoTitleContent(data = data)
70           is SingleCardData.Clickable.IconTitle -> SingleCardClickableIconTitleContent(data = data)
71           is SingleCardData.Clickable.IconTitleColored -> SingleCardClickableIconTitleColoredContent(data = data)
72           is SingleCardData.Clickable.IconTitleDescription -> SingleCardClickableIconTitleDescriptionContent(data = data)
73           is SingleCardData.Clickable.ButtonIconTitle ->
74             SingleCardClickableButtonIconTitleContent(data = data)
75   
76           is SingleCardData.Clickable.ButtonIconTitleDescription ->
77             SingleCardClickableButtonIconTitleDescriptionContent(data = data)
78   
79           is SingleCardData.Clickable.DeleteButtonIconTitle ->
80             SingleCardClickableDeleteButtonIconTitleContent(data = data)
81   
82           is SingleCardData.Clickable.TitleDescriptionStatusBadge ->
83             SingleCardClickableTitleDescriptionStatusBadgeContent(data = data)
84         }
85   
86         data.trailingIcon?.let { iconData ->
87           Icon(
88             modifier = Modifier.padding(start = AppTheme.dimensions.spacing200),
89             data = iconData,
90           )
91         }
92       }
93     }
94   }
95   
96   @Composable
97   internal fun RowScope.SingleCardClickableTitleContent(
98     data: SingleCardData.Clickable.Title,
99   ) {
100    CustomText(
101      label = data.title,
102      style = AppTheme.typography.bodyLargeMedium,
103      modifier = Modifier.weight(1f),
104      color = when (data.state) {
105        SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
106        else -> Color.Unspecified
107      },
108    )
109  }
110  
111  @Composable
112  internal fun RowScope.SingleCardClickableTitleDescriptionContent(
113    data: SingleCardData.Clickable.TitleDescription,
114  ) {
115    Column(
116      verticalArrangement = Arrangement.spacedBy(space = AppTheme.dimensions.spacing50),
117      modifier = Modifier
118        .fillMaxWidth()
119        .weight(1f),
120    ) {
121      CustomText(
122        label = data.title,
123        style = AppTheme.typography.bodyLargeMedium,
124        modifier = Modifier.fillMaxWidth(),
125        color = when (data.state) {
126          SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
127          else -> Color.Unspecified
128        },
129      )
130      CustomText(
131        label = data.description,
132        style = AppTheme.typography.bodyMediumRegular,
133        modifier = Modifier.fillMaxWidth(),
134        color = when (data.state) {
135          SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
136          else -> Color.Unspecified
137        },
138      )
139    }
140  }
141  
142  @Composable
143  internal fun RowScope.SingleCardClickableInfoTitleContent(
144    data: SingleCardData.Clickable.InfoTitle,
145  ) {
146    Column(
147      verticalArrangement = Arrangement.spacedBy(space = AppTheme.dimensions.spacing50),
148      modifier = Modifier
149        .fillMaxWidth()
150        .weight(1f),
151    ) {
152      CustomText(
153        label = data.info,
154        style = AppTheme.typography.bodyMediumRegular,
155        modifier = Modifier.fillMaxWidth(),
156        color = when (data.state) {
157          SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
158          else -> Color.Unspecified
159        },
160      )
161      CustomText(
162        label = data.title,
163        style = AppTheme.typography.bodyLargeMedium,
164        modifier = Modifier.fillMaxWidth(),
165        color = when (data.state) {
166          SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
167          else -> Color.Unspecified
168        },
169      )
170    }
171  }
172  
173  @Composable
174  internal fun RowScope.SingleCardClickableIconTitleContent(
175    data: SingleCardData.Clickable.IconTitle,
176  ) {
177    Row(
178      verticalAlignment = Alignment.CenterVertically,
179      modifier = Modifier
180        .fillMaxWidth()
181        .weight(1f),
182    ) {
183      Icon(
184        data = data.iconData,
185      )
186      Spacer(
187        modifier = Modifier.width(width = AppTheme.dimensions.spacing200),
188      )
189      CustomText(
190        label = data.title,
191        style = AppTheme.typography.bodyLargeMedium,
192        modifier = Modifier.fillMaxWidth(),
193        color = when (data.state) {
194          SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
195          else -> Color.Unspecified
196        },
197      )
198    }
199  }
200  
201  @Composable
202  internal fun RowScope.SingleCardClickableIconTitleColoredContent(
203    data: SingleCardData.Clickable.IconTitleColored,
204  ) {
205    Row(
206      verticalAlignment = Alignment.CenterVertically,
207      modifier = Modifier
208        .fillMaxWidth()
209        .weight(weight = 1f),
210    ) {
211      Icon(
212        data = data.iconData,
213      )
214      Spacer(
215        modifier = Modifier.width(width = AppTheme.dimensions.spacing200),
216      )
217      CustomText(
218        label = data.title,
219        style = data.titleStyleProvider(),
220        modifier = Modifier.fillMaxWidth(),
221        color = data.textColorProvider(),
222      )
223    }
224  }
225  
226  @Composable
227  internal fun RowScope.SingleCardClickableIconTitleDescriptionContent(
228    data: SingleCardData.Clickable.IconTitleDescription,
229  ) {
230    Row(
231      verticalAlignment = when (data.iconOnOneLineWithTitle) {
232        true -> Alignment.Top
233        false -> Alignment.CenterVertically
234      },
235      modifier = Modifier
236        .fillMaxWidth()
237        .weight(1f),
238    ) {
239      Icon(
240        data = data.iconData,
241      )
242      Spacer(
243        modifier = Modifier.width(width = AppTheme.dimensions.spacing200),
244      )
245      Column(
246        verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.spacing50),
247        modifier = Modifier.fillMaxWidth(),
248      ) {
249        CustomText(
250          label = data.title,
251          style = AppTheme.typography.bodyLargeMedium,
252          color = when (data.state) {
253            SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
254            else -> Color.Unspecified
255          },
256        )
257        CustomText(
258          label = data.description,
259          style = AppTheme.typography.bodyMediumRegular,
260          color = when (data.state) {
261            SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
262            else -> Color.Unspecified
263          },
264        )
265      }
266    }
267  }
268  
269  @Composable
270  internal fun RowScope.SingleCardClickableButtonIconTitleContent(
271    data: SingleCardData.Clickable.ButtonIconTitle,
272  ) {
273    Row(
274      verticalAlignment = Alignment.CenterVertically,
275      modifier = Modifier
276        .fillMaxWidth()
277        .weight(1f),
278    ) {
279      ButtonIcon(
280        data = data.buttonIconData,
281      )
282      Spacer(
283        modifier = Modifier.width(width = AppTheme.dimensions.spacing200),
284      )
285      CustomText(
286        label = data.title,
287        style = AppTheme.typography.bodyLargeMedium,
288        modifier = Modifier.fillMaxWidth(),
289      )
290    }
291  }
292  
293  @Composable
294  internal fun RowScope.SingleCardClickableButtonIconTitleDescriptionContent(
295    data: SingleCardData.Clickable.ButtonIconTitleDescription,
296  ) {
297    Row(
298      verticalAlignment = Alignment.CenterVertically,
299      modifier = Modifier
300        .fillMaxWidth()
301        .weight(1f),
302    ) {
303      ButtonIcon(
304        data = data.buttonIconData,
305      )
306      Spacer(
307        modifier = Modifier.width(width = AppTheme.dimensions.spacing200),
308      )
309      Column(
310        verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.spacing50),
311        modifier = Modifier.fillMaxWidth(),
312      ) {
313        CustomText(
314          label = data.title,
315          style = AppTheme.typography.bodyLargeMedium,
316          color = when (data.state) {
317            SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
318            else -> Color.Unspecified
319          },
320        )
321        CustomText(
322          label = data.description,
323          style = AppTheme.typography.bodyMediumRegular,
324          color = when (data.state) {
325            SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
326            else -> Color.Unspecified
327          },
328        )
329      }
330    }
331  }
332  
333  @Composable
334  internal fun RowScope.SingleCardClickableDeleteButtonIconTitleContent(
335    data: SingleCardData.Clickable.DeleteButtonIconTitle,
336  ) {
337    Row(
338      verticalAlignment = Alignment.CenterVertically,
339      modifier = Modifier
340        .fillMaxWidth()
341        .weight(1f),
342    ) {
343      Icon(
344        data = data.iconData,
345      )
346      Spacer(
347        modifier = Modifier.width(width = AppTheme.dimensions.spacing200),
348      )
349      CustomText(
350        label = data.title,
351        style = AppTheme.typography.bodyLargeMedium,
352        modifier = Modifier.fillMaxWidth(),
353        color = data.textColorProvider(),
354      )
355    }
356  }
357  
358  @Composable
359  internal fun RowScope.SingleCardClickableTitleDescriptionStatusBadgeContent(
360    data: SingleCardData.Clickable.TitleDescriptionStatusBadge,
361  ) {
362    Column(
363      verticalArrangement = Arrangement.spacedBy(space = AppTheme.dimensions.spacing50),
364      modifier = Modifier
365        .fillMaxWidth()
366        .weight(1f),
367    ) {
368      CustomText(
369        label = data.title,
370        style = AppTheme.typography.bodyLargeMedium,
371        modifier = Modifier.fillMaxWidth(),
372        color = when (data.state) {
373          SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
374          else -> Color.Unspecified
375        },
376      )
377      CustomText(
378        label = data.description,
379        style = AppTheme.typography.bodyMediumRegular,
380        modifier = Modifier.fillMaxWidth(),
381        color = when (data.state) {
382          SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
383          else -> Color.Unspecified
384        },
385      )
386      Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing100))
387      SingleCardStatusBadge(data = data.badgeData)
388    }
389  }
390  