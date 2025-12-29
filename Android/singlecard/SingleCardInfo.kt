1    package pl.gov.coi.common.ui.ds.singlecard
2    
3    import androidx.compose.foundation.Image
4    import androidx.compose.foundation.clickable
5    import androidx.compose.foundation.layout.Arrangement
6    import androidx.compose.foundation.layout.Column
7    import androidx.compose.foundation.layout.Row
8    import androidx.compose.foundation.layout.RowScope
9    import androidx.compose.foundation.layout.Spacer
10   import androidx.compose.foundation.layout.defaultMinSize
11   import androidx.compose.foundation.layout.fillMaxWidth
12   import androidx.compose.foundation.layout.padding
13   import androidx.compose.foundation.layout.size
14   import androidx.compose.foundation.layout.width
15   import androidx.compose.foundation.selection.toggleable
16   import androidx.compose.foundation.shape.RoundedCornerShape
17   import androidx.compose.material3.Card
18   import androidx.compose.material3.CardDefaults
19   import androidx.compose.runtime.Composable
20   import androidx.compose.ui.Alignment
21   import androidx.compose.ui.Modifier
22   import androidx.compose.ui.draw.clip
23   import androidx.compose.ui.graphics.Color
24   import androidx.compose.ui.graphics.asImageBitmap
25   import androidx.compose.ui.layout.ContentScale
26   import androidx.compose.ui.semantics.Role
27   import androidx.compose.ui.semantics.semantics
28   import androidx.compose.ui.semantics.testTag
29   import pl.gov.coi.common.domain.label.Label
30   import pl.gov.coi.common.ui.R
31   import pl.gov.coi.common.ui.ds.button.Button
32   import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIcon
33   import pl.gov.coi.common.ui.ds.custom.icon.Icon
34   import pl.gov.coi.common.ui.ds.custom.icon.IconData
35   import pl.gov.coi.common.ui.ds.custom.icon.IconSize
36   import pl.gov.coi.common.ui.ds.switchcomponent.Switch
37   import pl.gov.coi.common.ui.text.CustomText
38   import pl.gov.coi.common.ui.theme.AppTheme
39   import pl.gov.coi.common.ui.utils.NoRippleInteractionSource
40   
41   @Composable
42   internal fun SingleCardInfo(data: SingleCardData.Info) {
43     Card(
44       modifier = data.modifier.semantics { testTag = data.testTag ?: data.title.tag },
45       colors = CardDefaults.cardColors(containerColor = AppTheme.colors.white),
46       shape = RoundedCornerShape(AppTheme.dimensions.spacing200),
47     ) {
48       Row(
49         verticalAlignment = Alignment.CenterVertically,
50         modifier = Modifier
51           .defaultMinSize(minHeight = SINGLE_CARD_MINIMUM_HEIGHT)
52           .fillMaxWidth()
53           .padding(all = AppTheme.dimensions.spacing250),
54       ) {
55         when (data) {
56           is SingleCardData.Info.Title -> SingleCardInfoTitleContent(data = data)
57           is SingleCardData.Info.TitleDescription -> SingleCardInfoTitleDescriptionContent(data = data)
58           is SingleCardData.Info.InfoTitle -> SingleCardInfoTitleInfoContent(data = data)
59           is SingleCardData.Info.IconTitle -> SingleCardInfoTitleIconContent(data = data)
60           is SingleCardData.Info.IconTitleDescription -> SingleCardInfoTitleDescriptionIconContent(data = data)
61           is SingleCardData.Info.TitleStatusBadge -> SingleCardInfoTitleStatusBadgeContent(data = data)
62           is SingleCardData.Info.IconTitleDescriptionLeadingButton ->
63             SingleCardInfoIconTitleDescriptionLeadingButtonContent(data = data)
64   
65           is SingleCardData.Info.ImageTitleDescriptionLeadingButton ->
66             SingleCardInfoImageTitleDescriptionLeadingButtonContent(data = data)
67         }
68   
69         if (data.draggable) {
70           Icon(
71             modifier = Modifier.padding(start = AppTheme.dimensions.spacing200),
72             data = IconData.Standard(
73               testTag = data.testTag?.let { tag -> tag + "DraggableIcon" },
74               iconResId = R.drawable.aa040_handle_3,
75               iconSize = IconSize.SIZE24,
76               iconColorProvider = { Color.Unspecified },
77               contentDescription = Label.EMPTY,
78             ),
79           )
80         }
81       }
82     }
83   }
84   
85   @Composable
86   internal fun SingleCardInfoTitleContent(
87     data: SingleCardData.Info.Title,
88   ) {
89     fun toggleableModifier(): Modifier =
90       if (data.extras is SingleCardInfoExtras.Switch) {
91         Modifier.toggleable(
92           role = Role.Switch,
93           value = data.extras.switchData.checked,
94           enabled = data.extras.switchData.enabled,
95           onValueChange = { value -> data.extras.switchData.onCheckedChange?.invoke(value) },
96         )
97       } else {
98         Modifier
99       }
100  
101    Row(
102      verticalAlignment = Alignment.CenterVertically,
103      modifier = Modifier
104        .fillMaxWidth()
105        .then(toggleableModifier()),
106    ) {
107      CustomText(
108        testTag = data.testTag?.let { tag -> tag + "Text" },
109        label = data.title,
110        style = AppTheme.typography.bodyLargeMedium,
111        modifier = Modifier.weight(1f),
112        color = when (data.cardState) {
113          SingleCardInfoState.ENABLED -> Color.Unspecified
114          SingleCardInfoState.DISABLE -> AppTheme.colors.neutral60
115        },
116      )
117      data.extras?.let { extra ->
118        Spacer(
119          modifier = Modifier.width(width = AppTheme.dimensions.spacing100),
120        )
121        when (extra) {
122          is SingleCardInfoExtras.ButtonMore -> Button(data = extra.buttonData)
123          is SingleCardInfoExtras.Switch -> Switch(data = extra.switchData)
124        }
125      }
126    }
127  }
128  
129  @Composable
130  internal fun RowScope.SingleCardInfoTitleDescriptionContent(
131    data: SingleCardData.Info.TitleDescription,
132  ) {
133    Row(
134      verticalAlignment = Alignment.CenterVertically,
135      modifier = Modifier
136        .fillMaxWidth()
137        .weight(1f),
138    ) {
139      Column(
140        verticalArrangement = Arrangement.spacedBy(space = AppTheme.dimensions.spacing50),
141        modifier = Modifier
142          .fillMaxWidth()
143          .weight(1f),
144      ) {
145        CustomText(
146          label = data.title,
147          style = AppTheme.typography.bodyLargeMedium,
148          modifier = Modifier.fillMaxWidth(),
149          color = when (data.cardState) {
150            SingleCardInfoState.ENABLED -> Color.Unspecified
151            SingleCardInfoState.DISABLE -> AppTheme.colors.neutral60
152          },
153        )
154        CustomText(
155          label = data.description,
156          style = AppTheme.typography.bodyMediumRegular,
157          modifier = Modifier.fillMaxWidth(),
158          color = when (data.cardState) {
159            SingleCardInfoState.ENABLED -> Color.Unspecified
160            SingleCardInfoState.DISABLE -> AppTheme.colors.neutral60
161          },
162        )
163      }
164      data.extras?.let { extra ->
165        Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
166        when (extra) {
167          is SingleCardInfoExtras.ButtonMore -> Button(data = extra.buttonData)
168          is SingleCardInfoExtras.Switch -> Switch(data = extra.switchData)
169        }
170      }
171    }
172  }
173  
174  @Composable
175  internal fun RowScope.SingleCardInfoTitleInfoContent(
176    data: SingleCardData.Info.InfoTitle,
177  ) {
178    Row(
179      verticalAlignment = Alignment.CenterVertically,
180      modifier = Modifier
181        .fillMaxWidth()
182        .weight(1f),
183    ) {
184      Column(
185        verticalArrangement = Arrangement.spacedBy(space = AppTheme.dimensions.spacing50),
186        modifier = Modifier
187          .fillMaxWidth()
188          .weight(1f),
189      ) {
190        CustomText(
191          label = data.info,
192          style = AppTheme.typography.bodyMediumRegular,
193          modifier = Modifier.fillMaxWidth(),
194        )
195        CustomText(
196          label = data.title,
197          style = AppTheme.typography.bodyLargeMedium,
198          modifier = Modifier.fillMaxWidth(),
199          maxLines = data.titleMaxLines,
200          overflow = data.titleTextOverflow,
201        )
202      }
203      data.extras?.let { extra ->
204        Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
205        when (extra) {
206          is SingleCardInfoExtras.ButtonMore -> Button(data = extra.buttonData)
207          is SingleCardInfoExtras.Switch -> Switch(data = extra.switchData)
208        }
209      }
210    }
211  }
212  
213  @Composable
214  internal fun RowScope.SingleCardInfoTitleIconContent(
215    data: SingleCardData.Info.IconTitle,
216  ) {
217    Row(
218      verticalAlignment = Alignment.CenterVertically,
219      modifier = Modifier
220        .fillMaxWidth()
221        .weight(1f),
222    ) {
223      data.buttonIconData?.let { buttonDataIcon ->
224        ButtonIcon(
225          data = buttonDataIcon,
226        )
227      } ?: run {
228        Icon(data = data.iconData)
229      }
230      Spacer(
231        modifier = Modifier.width(width = AppTheme.dimensions.spacing100),
232      )
233      CustomText(
234        label = data.title,
235        style = AppTheme.typography.bodyLargeMedium,
236        modifier = Modifier.fillMaxWidth(),
237        color = when (data.cardState) {
238          SingleCardInfoState.ENABLED -> Color.Unspecified
239          SingleCardInfoState.DISABLE -> AppTheme.colors.neutral60
240        },
241        labelContentDescription = data.cardContentDescription,
242      )
243    }
244  }
245  
246  @Composable
247  internal fun RowScope.SingleCardInfoTitleDescriptionIconContent(
248    data: SingleCardData.Info.IconTitleDescription,
249  ) {
250    Row(
251      verticalAlignment = when (data.iconOnOneLineWithTitle) {
252        true -> Alignment.Top
253        false -> Alignment.CenterVertically
254      },
255      modifier = Modifier
256        .fillMaxWidth()
257        .weight(1f),
258    ) {
259      data.buttonIconData?.let { buttonDataIcon ->
260        ButtonIcon(
261          data = buttonDataIcon,
262        )
263      } ?: run {
264        Icon(data = data.iconData)
265      }
266      Spacer(
267        modifier = Modifier.width(width = AppTheme.dimensions.spacing200),
268      )
269      Column(
270        verticalArrangement = Arrangement.spacedBy(space = AppTheme.dimensions.spacing50),
271        modifier = Modifier
272          .fillMaxWidth()
273          .weight(1f),
274      ) {
275        CustomText(
276          label = data.title,
277          style = AppTheme.typography.bodyLargeMedium,
278          modifier = Modifier.fillMaxWidth(),
279          color = when (data.cardState) {
280            SingleCardInfoState.ENABLED -> Color.Unspecified
281            SingleCardInfoState.DISABLE -> AppTheme.colors.neutral60
282          },
283          labelContentDescription = data.cardContentDescription,
284        )
285        CustomText(
286          label = data.description,
287          style = AppTheme.typography.bodyMediumRegular,
288          modifier = Modifier.fillMaxWidth(),
289          color = when (data.cardState) {
290            SingleCardInfoState.ENABLED -> Color.Unspecified
291            SingleCardInfoState.DISABLE -> AppTheme.colors.neutral60
292          },
293        )
294      }
295    }
296  }
297  
298  @Composable
299  internal fun RowScope.SingleCardInfoTitleStatusBadgeContent(
300    data: SingleCardData.Info.TitleStatusBadge,
301  ) = with(data) {
302    Column(
303      verticalArrangement = Arrangement.spacedBy(space = AppTheme.dimensions.spacing50),
304      modifier = Modifier
305        .fillMaxWidth()
306        .weight(1f),
307    ) {
308      CustomText(
309        label = title,
310        style = AppTheme.typography.bodyMediumRegular,
311        modifier = Modifier.fillMaxWidth(),
312        color = AppTheme.colors.neutral200,
313      )
314      SingleCardStatusBadge(data = badgeData)
315    }
316  }
317  
318  @Composable
319  internal fun RowScope.SingleCardInfoIconTitleDescriptionLeadingButtonContent(
320    data: SingleCardData.Info.IconTitleDescriptionLeadingButton,
321  ) {
322    Row(
323      verticalAlignment = when (data.iconOnOneLineWithTitle) {
324        true -> Alignment.Top
325        false -> Alignment.CenterVertically
326      },
327      modifier = Modifier
328        .fillMaxWidth()
329        .weight(weight = 1f),
330    ) {
331      Icon(data = data.iconData)
332      Spacer(
333        modifier = Modifier.width(width = AppTheme.dimensions.spacing200),
334      )
335      Column(
336        verticalArrangement = Arrangement.spacedBy(space = AppTheme.dimensions.spacing50),
337        modifier = Modifier
338          .fillMaxWidth()
339          .weight(1f),
340      ) {
341        CustomText(
342          label = data.title,
343          maxLines = data.titleMaxLines,
344          overflow = data.titleOverflow,
345          style = AppTheme.typography.bodyLargeMedium,
346          modifier = Modifier.fillMaxWidth(),
347          color = when (data.cardState) {
348            SingleCardInfoState.ENABLED -> AppTheme.colors.neutral500
349            SingleCardInfoState.DISABLE -> AppTheme.colors.neutral60
350          },
351          labelContentDescription = data.cardContentDescription,
352        )
353        CustomText(
354          label = data.description,
355          style = AppTheme.typography.bodyMediumRegular,
356          modifier = Modifier.fillMaxWidth(),
357          color = when (data.cardState) {
358            SingleCardInfoState.ENABLED -> AppTheme.colors.neutral200
359            SingleCardInfoState.DISABLE -> AppTheme.colors.neutral60
360          },
361        )
362      }
363      Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
364      data.leadingButtonData?.let { ButtonIcon(data = it) }
365    }
366  }
367  
368  @Composable
369  internal fun RowScope.SingleCardInfoImageTitleDescriptionLeadingButtonContent(
370    data: SingleCardData.Info.ImageTitleDescriptionLeadingButton,
371  ) {
372    Row(
373      verticalAlignment = when (data.iconOnOneLineWithTitle) {
374        true -> Alignment.Top
375        false -> Alignment.CenterVertically
376      },
377      modifier = Modifier
378        .fillMaxWidth()
379        .weight(weight = 1f),
380    ) {
381      Image(
382        contentScale = ContentScale.Crop,
383        modifier = Modifier
384          .size(data.imageData.size.dimension)
385          .clip(data.imageData.shapeProvider())
386          .clickable(
387            interactionSource = NoRippleInteractionSource(),
388            indication = null,
389            onClick = data.imageData.onClick,
390          ),
391        bitmap = data.imageData.image.asImageBitmap(),
392        contentDescription = data.imageData.contentDescription.text,
393      )
394      Spacer(
395        modifier = Modifier.width(width = AppTheme.dimensions.spacing200),
396      )
397      Column(
398        verticalArrangement = Arrangement.spacedBy(space = AppTheme.dimensions.spacing50),
399        modifier = Modifier
400          .fillMaxWidth()
401          .weight(weight = 1f),
402      ) {
403        CustomText(
404          label = data.title,
405          maxLines = data.titleMaxLines,
406          overflow = data.titleOverflow,
407          style = AppTheme.typography.bodyLargeMedium,
408          modifier = Modifier.fillMaxWidth(),
409          color = when (data.cardState) {
410            SingleCardInfoState.ENABLED -> AppTheme.colors.neutral500
411            SingleCardInfoState.DISABLE -> AppTheme.colors.neutral60
412          },
413          labelContentDescription = data.cardContentDescription,
414        )
415        CustomText(
416          label = data.description,
417          style = AppTheme.typography.bodyMediumRegular,
418          modifier = Modifier.fillMaxWidth(),
419          color = when (data.cardState) {
420            SingleCardInfoState.ENABLED -> AppTheme.colors.neutral200
421            SingleCardInfoState.DISABLE -> AppTheme.colors.neutral60
422          },
423        )
424      }
425      Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
426      data.leadingButtonData?.let { ButtonIcon(data = it) }
427    }
428  }
429  