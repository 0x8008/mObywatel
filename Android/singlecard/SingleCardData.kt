1    package pl.gov.coi.common.ui.ds.singlecard
2    
3    import androidx.annotation.DrawableRes
4    import androidx.compose.runtime.Composable
5    import androidx.compose.ui.Modifier
6    import androidx.compose.ui.graphics.Color
7    import androidx.compose.ui.text.TextStyle
8    import androidx.compose.ui.text.style.TextOverflow
9    import pl.gov.coi.common.domain.label.Label
10   import pl.gov.coi.common.ui.R
11   import pl.gov.coi.common.ui.ds.button.ButtonData
12   import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
13   import pl.gov.coi.common.ui.ds.checkbox.single.model.CheckBoxSingleData
14   import pl.gov.coi.common.ui.ds.custom.icon.IconData
15   import pl.gov.coi.common.ui.ds.custom.icon.IconSize
16   import pl.gov.coi.common.ui.ds.custom.icon.IconState
17   import pl.gov.coi.common.ui.ds.image.ImageData
18   import pl.gov.coi.common.ui.ds.singlecard.radiobutton.OldRadioButtonData
19   import pl.gov.coi.common.ui.ds.switchcomponent.SwitchData
20   import pl.gov.coi.common.ui.theme.AppTheme
21   
22   enum class SingleCardInfoState { ENABLED, DISABLE }
23   
24   enum class SingleCardClickableRadioButtonState { ENABLED, DISABLED, FOCUS }
25   
26   sealed interface SingleCardInfoExtras {
27     class ButtonMore(
28       val buttonData: ButtonData,
29     ) : SingleCardInfoExtras
30   
31     class Switch(
32       val switchData: SwitchData.SwitchOnly,
33     ) : SingleCardInfoExtras
34   }
35   
36   sealed class SingleCardData(
37     val testTag: String?,
38     val title: Label,
39   ) {
40   
41     sealed class Info(
42       testTag: String?,
43       title: Label,
44       val modifier: Modifier = Modifier,
45       val draggable: Boolean,
46       val cardState: SingleCardInfoState,
47     ) : SingleCardData(testTag = testTag, title = title) {
48   
49       class Title(
50         testTag: String? = null,
51         title: Label,
52         draggable: Boolean = false,
53         state: SingleCardInfoState = SingleCardInfoState.ENABLED,
54         val extras: SingleCardInfoExtras? = null,
55       ) : Info(testTag = testTag, title = title, draggable = draggable, cardState = state)
56   
57       class TitleDescription(
58         testTag: String? = null,
59         title: Label,
60         val description: Label,
61         draggable: Boolean = false,
62         state: SingleCardInfoState = SingleCardInfoState.ENABLED,
63         val extras: SingleCardInfoExtras? = null,
64       ) : Info(testTag = testTag, title = title, draggable = draggable, cardState = state)
65   
66       class InfoTitle(
67         testTag: String? = null,
68         val info: Label,
69         title: Label,
70         draggable: Boolean = false,
71         state: SingleCardInfoState = SingleCardInfoState.ENABLED,
72         val extras: SingleCardInfoExtras? = null,
73         val titleMaxLines: Int = Int.MAX_VALUE,
74         val titleTextOverflow: TextOverflow = TextOverflow.Clip,
75       ) : Info(testTag = testTag, title = title, draggable = draggable, cardState = state)
76   
77       class IconTitle(
78         testTag: String? = null,
79         @DrawableRes val iconResId: Int,
80         iconColorProvider: @Composable () -> Color = { Color.Unspecified },
81         modifier: Modifier = Modifier,
82         title: Label,
83         draggable: Boolean = false,
84         val iconSize: IconSize = IconSize.SIZE24,
85         state: SingleCardInfoState = SingleCardInfoState.ENABLED,
86         val cardContentDescription: Label = Label.EMPTY,
87         iconContentDescription: Label = Label.EMPTY,
88         val onIconClick: (() -> Unit)? = null,
89       ) : Info(testTag = testTag, title = title, modifier = modifier, draggable = draggable, cardState = state) {
90   
91         internal val iconData: IconData = IconData.Standard(
92           testTag = testTag?.let { tag -> tag + "Icon" },
93           iconResId = iconResId,
94           iconSize = iconSize,
95           iconColorProvider = iconColorProvider,
96           contentDescription = Label.EMPTY,
97           iconState = state.toIconState(),
98         )
99   
100        internal val buttonIconData: ButtonIconData? = when (onIconClick) {
101          null -> null
102          else -> ButtonIconData(
103            testTag = testTag?.let { tag -> tag + "ButtonIcon" },
104            iconResId = iconResId,
105            iconColorProvider = iconColorProvider,
106            contentDescription = iconContentDescription,
107            onClick = onIconClick,
108          )
109        }
110      }
111  
112      class IconTitleDescription(
113        testTag: String? = null,
114        @DrawableRes val iconResId: Int,
115        iconColorProvider: @Composable () -> Color = { Color.Unspecified },
116        modifier: Modifier = Modifier,
117        title: Label,
118        val description: Label,
119        draggable: Boolean = false,
120        val iconOnOneLineWithTitle: Boolean = false,
121        val iconSize: IconSize = IconSize.SIZE24,
122        state: SingleCardInfoState = SingleCardInfoState.ENABLED,
123        val cardContentDescription: Label = Label.EMPTY,
124        iconContentDescription: Label = Label.EMPTY,
125        val onIconClick: (() -> Unit)? = null,
126      ) : Info(testTag = testTag, title = title, modifier = modifier, draggable = draggable, cardState = state) {
127        internal val iconData: IconData = IconData.Standard(
128          testTag = testTag?.let { tag -> tag + "Icon" },
129          iconResId = iconResId,
130          iconSize = iconSize,
131          iconColorProvider = iconColorProvider,
132          contentDescription = Label.EMPTY,
133          iconState = state.toIconState(),
134        )
135  
136        internal val buttonIconData: ButtonIconData? = when (onIconClick) {
137          null -> null
138          else -> ButtonIconData(
139            testTag = testTag?.let { tag -> tag + "ButtonIcon" },
140            iconResId = iconResId,
141            iconColorProvider = iconColorProvider,
142            contentDescription = iconContentDescription,
143            onClick = onIconClick,
144          )
145        }
146      }
147  
148      class TitleStatusBadge(
149        testTag: String? = null,
150        title: Label,
151        state: SingleCardInfoState = SingleCardInfoState.ENABLED,
152        draggable: Boolean = false,
153        val badgeData: SingleCardStatusBadgeData,
154      ) : Info(testTag = testTag, title = title, draggable = draggable, cardState = state)
155  
156      class IconTitleDescriptionLeadingButton(
157        testTag: String? = null,
158        modifier: Modifier = Modifier,
159        title: Label,
160        val iconData: IconData,
161        val description: Label,
162        val leadingButtonData: ButtonIconData? = null,
163        val titleMaxLines: Int = 2,
164        val titleOverflow: TextOverflow = TextOverflow.Ellipsis,
165        draggable: Boolean = false,
166        val iconOnOneLineWithTitle: Boolean = false,
167        val iconSize: IconSize = IconSize.SIZE48,
168        state: SingleCardInfoState = SingleCardInfoState.ENABLED,
169        val cardContentDescription: Label = Label.EMPTY,
170      ) : Info(testTag = testTag, title = title, modifier = modifier, draggable = draggable, cardState = state)
171  
172      class ImageTitleDescriptionLeadingButton(
173        testTag: String? = null,
174        modifier: Modifier = Modifier,
175        val imageData: ImageData,
176        title: Label,
177        val description: Label,
178        val leadingButtonData: ButtonIconData? = null,
179        val titleMaxLines: Int = 2,
180        val titleOverflow: TextOverflow = TextOverflow.Ellipsis,
181        draggable: Boolean = false,
182        val iconOnOneLineWithTitle: Boolean = false,
183        val iconSize: IconSize = IconSize.SIZE24,
184        state: SingleCardInfoState = SingleCardInfoState.ENABLED,
185        val cardContentDescription: Label = Label.EMPTY,
186      ) : Info(testTag = testTag, title = title, modifier = modifier, draggable = draggable, cardState = state)
187    }
188  
189    sealed class Clickable(
190      testTag: String?,
191      title: Label,
192      val modifier: Modifier = Modifier,
193      val state: SingleCardClickableRadioButtonState,
194      @DrawableRes val trailingIconResId: Int?,
195      val trailingIconColorProvider: @Composable () -> Color,
196      val trailingIconContentDescription: Label,
197      val onClick: () -> Unit,
198    ) : SingleCardData(testTag = testTag, title = title) {
199  
200      internal val trailingIcon = trailingIconResId?.let { iconResId ->
201        IconData.Standard(
202          testTag = testTag?.let { tag -> tag + "Icon" },
203          iconResId = iconResId,
204          iconSize = IconSize.SIZE24,
205          iconColorProvider = trailingIconColorProvider,
206          iconState = state.toIconState(),
207          contentDescription = trailingIconContentDescription,
208        )
209      }
210  
211      class Title(
212        testTag: String? = null,
213        title: Label,
214        state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
215        @DrawableRes trailingIonResId: Int? = DEFAULT_TRAILING_ICON_RES_ID,
216        trailingIconColorProvider: @Composable () -> Color = DEFAULT_TRAILING_ICON_COLOR_PROVIDER,
217        trailingIconContentDescription: Label = DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION,
218        onClick: () -> Unit,
219      ) : Clickable(
220        testTag = testTag,
221        title = title,
222        state = state,
223        trailingIconResId = trailingIonResId,
224        trailingIconColorProvider = trailingIconColorProvider,
225        trailingIconContentDescription = trailingIconContentDescription,
226        onClick = onClick,
227      )
228  
229      class TitleDescription(
230        testTag: String? = null,
231        val description: Label,
232        title: Label,
233        state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
234        @DrawableRes trailingIonResId: Int? = DEFAULT_TRAILING_ICON_RES_ID,
235        trailingIconColorProvider: @Composable () -> Color = DEFAULT_TRAILING_ICON_COLOR_PROVIDER,
236        trailingIconContentDescription: Label = DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION,
237        onClick: () -> Unit,
238      ) : Clickable(
239        testTag = testTag,
240        title = title,
241        state = state,
242        trailingIconResId = trailingIonResId,
243        trailingIconColorProvider = trailingIconColorProvider,
244        trailingIconContentDescription = trailingIconContentDescription,
245        onClick = onClick,
246      )
247  
248      class InfoTitle(
249        testTag: String? = null,
250        val info: Label,
251        title: Label,
252        state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
253        @DrawableRes trailingIonResId: Int? = null,
254        trailingIconColorProvider: @Composable () -> Color = DEFAULT_TRAILING_ICON_COLOR_PROVIDER,
255        trailingIconContentDescription: Label = DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION,
256        onClick: () -> Unit,
257      ) : Clickable(
258        testTag = testTag,
259        title = title,
260        state = state,
261        trailingIconResId = trailingIonResId,
262        trailingIconColorProvider = trailingIconColorProvider,
263        trailingIconContentDescription = trailingIconContentDescription,
264        onClick = onClick,
265      )
266  
267      class IconTitle(
268        testTag: String? = null,
269        @DrawableRes val iconResId: Int,
270        iconColorProvider: @Composable () -> Color = { Color.Unspecified },
271        title: Label,
272        modifier: Modifier = Modifier,
273        state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
274        @DrawableRes trailingIonResId: Int? = DEFAULT_TRAILING_ICON_RES_ID,
275        trailingIconColorProvider: @Composable () -> Color = DEFAULT_TRAILING_ICON_COLOR_PROVIDER,
276        trailingIconContentDescription: Label = DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION,
277        val iconSize: IconSize = IconSize.SIZE24,
278        onClick: () -> Unit,
279      ) : Clickable(
280        testTag = testTag,
281        title = title,
282        modifier = modifier,
283        state = state,
284        trailingIconResId = trailingIonResId,
285        trailingIconColorProvider = trailingIconColorProvider,
286        trailingIconContentDescription = trailingIconContentDescription,
287        onClick = onClick,
288      ) {
289  
290        internal val iconData: IconData = IconData.Standard(
291          testTag = testTag?.let { tag -> tag + "Icon" },
292          iconResId = iconResId,
293          iconSize = iconSize,
294          iconColorProvider = iconColorProvider,
295          contentDescription = Label.EMPTY,
296          iconState = state.toIconState(),
297        )
298      }
299  
300      class IconTitleColored(
301        testTag: String? = null,
302        @DrawableRes val iconResId: Int,
303        iconColorProvider: @Composable () -> Color = { Color.Unspecified },
304        title: Label,
305        titleColorProvider: @Composable () -> Color = { Color.Unspecified },
306        val titleStyleProvider: @Composable () -> TextStyle = { AppTheme.typography.bodyLargeMedium },
307        modifier: Modifier = Modifier,
308        state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
309        @DrawableRes trailingIonResId: Int? = DEFAULT_TRAILING_ICON_RES_ID,
310        trailingIconColorProvider: @Composable () -> Color = DEFAULT_TRAILING_ICON_COLOR_PROVIDER,
311        trailingIconContentDescription: Label = DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION,
312        val iconSize: IconSize = IconSize.SIZE24,
313        onClick: () -> Unit,
314      ) : Clickable(
315        testTag = testTag,
316        title = title,
317        modifier = modifier,
318        state = state,
319        trailingIconResId = trailingIonResId,
320        trailingIconColorProvider = trailingIconColorProvider,
321        trailingIconContentDescription = trailingIconContentDescription,
322        onClick = onClick,
323      ) {
324  
325        internal val iconData: IconData = IconData.Standard(
326          testTag = testTag?.let { tag -> tag + "Icon" },
327          iconResId = iconResId,
328          iconSize = iconSize,
329          iconColorProvider = iconColorProvider,
330          contentDescription = Label.EMPTY,
331          iconState = state.toIconState(),
332        )
333  
334        internal val textColorProvider: @Composable () -> Color = {
335          when (state) {
336            SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
337            else -> titleColorProvider()
338          }
339        }
340      }
341  
342      class ButtonIconTitle(
343        testTag: String? = null,
344        @DrawableRes val iconResId: Int,
345        iconColorProvider: @Composable () -> Color = { Color.Unspecified },
346        title: Label,
347        state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
348        @DrawableRes trailingIonResId: Int? = null,
349        trailingIconColorProvider: @Composable () -> Color = DEFAULT_TRAILING_ICON_COLOR_PROVIDER,
350        trailingIconContentDescription: Label = DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION,
351        onIconClick: () -> Unit,
352      ) : Clickable(
353        testTag = testTag,
354        title = title,
355        state = state,
356        trailingIconResId = trailingIonResId,
357        trailingIconColorProvider = trailingIconColorProvider,
358        trailingIconContentDescription = trailingIconContentDescription,
359        onClick = {},
360      ) {
361  
362        internal val buttonIconData: ButtonIconData = ButtonIconData(
363          testTag = testTag?.let { tag -> tag + "Icon" },
364          iconResId = iconResId,
365          iconColorProvider = iconColorProvider,
366          contentDescription = Label.EMPTY,
367          onClick = onIconClick,
368        )
369      }
370  
371      class ButtonIconTitleDescription(
372        testTag: String? = null,
373        @DrawableRes val iconResId: Int,
374        iconColorProvider: @Composable () -> Color = { Color.Unspecified },
375        title: Label,
376        val description: Label,
377        state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
378        @DrawableRes trailingIonResId: Int? = DEFAULT_TRAILING_ICON_RES_ID,
379        trailingIconColorProvider: @Composable () -> Color = DEFAULT_TRAILING_ICON_COLOR_PROVIDER,
380        trailingIconContentDescription: Label = DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION,
381        onIconClick: () -> Unit,
382      ) : Clickable(
383        testTag = testTag,
384        title = title,
385        state = state,
386        trailingIconResId = trailingIonResId,
387        trailingIconColorProvider = trailingIconColorProvider,
388        trailingIconContentDescription = trailingIconContentDescription,
389        onClick = {},
390      ) {
391  
392        internal val buttonIconData: ButtonIconData = ButtonIconData(
393          testTag = testTag?.let { tag -> tag + "Icon" },
394          iconResId = iconResId,
395          iconColorProvider = iconColorProvider,
396          contentDescription = Label.EMPTY,
397          onClick = onIconClick,
398        )
399      }
400  
401      class DeleteButtonIconTitle(
402        testTag: String? = null,
403        title: Label,
404        val iconSize: IconSize = IconSize.SIZE24,
405        state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
406        @DrawableRes trailingIonResId: Int? = null,
407        trailingIconColorProvider: @Composable () -> Color = DEFAULT_TRAILING_ICON_COLOR_PROVIDER,
408        trailingIconContentDescription: Label = DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION,
409        onClick: () -> Unit,
410      ) : Clickable(
411        testTag = testTag,
412        title = title,
413        state = state,
414        trailingIconResId = trailingIonResId,
415        trailingIconColorProvider = trailingIconColorProvider,
416        trailingIconContentDescription = trailingIconContentDescription,
417        onClick = onClick,
418      ) {
419  
420        internal val iconData: IconData.Standard = IconData.Standard(
421          testTag = testTag?.let { tag -> tag + "Icon" },
422          iconResId = R.drawable.aa002_delete,
423          iconSize = iconSize,
424          iconColorProvider = { AppTheme.colors.supportRed100 },
425          contentDescription = Label.EMPTY,
426        )
427  
428        internal val textColorProvider: @Composable () -> Color = { AppTheme.colors.supportRed100 }
429      }
430  
431      class IconTitleDescription(
432        testTag: String? = null,
433        @DrawableRes val iconResId: Int,
434        iconColorProvider: @Composable () -> Color = { Color.Unspecified },
435        val description: Label,
436        val iconOnOneLineWithTitle: Boolean = false,
437        title: Label,
438        val iconSize: IconSize = IconSize.SIZE24,
439        state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
440        @DrawableRes trailingIonResId: Int? = DEFAULT_TRAILING_ICON_RES_ID,
441        trailingIconColorProvider: @Composable () -> Color = DEFAULT_TRAILING_ICON_COLOR_PROVIDER,
442        trailingIconContentDescription: Label = DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION,
443        onClick: () -> Unit,
444      ) : Clickable(
445        testTag = testTag,
446        title = title,
447        state = state,
448        trailingIconResId = trailingIonResId,
449        trailingIconColorProvider = trailingIconColorProvider,
450        trailingIconContentDescription = trailingIconContentDescription,
451        onClick = onClick,
452      ) {
453  
454        internal val iconData: IconData = IconData.Standard(
455          testTag = testTag?.let { tag -> tag + "Icon" },
456          iconResId = iconResId,
457          iconSize = iconSize,
458          iconColorProvider = iconColorProvider,
459          contentDescription = Label.EMPTY,
460          iconState = state.toIconState(),
461        )
462      }
463  
464      class TitleDescriptionStatusBadge(
465        testTag: String? = null,
466        val description: Label,
467        title: Label,
468        state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
469        @DrawableRes trailingIonResId: Int? = DEFAULT_TRAILING_ICON_RES_ID,
470        trailingIconColorProvider: @Composable () -> Color = DEFAULT_TRAILING_ICON_COLOR_PROVIDER,
471        trailingIconContentDescription: Label = DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION,
472        val badgeData: SingleCardStatusBadgeData,
473        onClick: () -> Unit,
474      ) : Clickable(
475        testTag = testTag,
476        title = title,
477        state = state,
478        trailingIconResId = trailingIonResId,
479        trailingIconColorProvider = trailingIconColorProvider,
480        trailingIconContentDescription = trailingIconContentDescription,
481        onClick = onClick,
482      )
483  
484      private companion object {
485        val DEFAULT_TRAILING_ICON_RES_ID = R.drawable.ab006_chevron_right
486        val DEFAULT_TRAILING_ICON_COLOR_PROVIDER: @Composable () -> Color = { Color.Unspecified }
487        val DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION = Label.EMPTY
488      }
489    }
490  
491    sealed class SelectableRadioButton(
492      testTag: String?,
493      val radioButtonData: OldRadioButtonData,
494      val onClick: () -> Unit,
495      val state: SingleCardClickableRadioButtonState,
496      val drawBorder: Boolean = true,
497      title: Label,
498    ) : SingleCardData(testTag = testTag, title = title) {
499      class Title(
500        testTag: String? = null,
501        radioButtonData: OldRadioButtonData,
502        title: Label,
503        state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
504        drawBorder: Boolean = true, 
505        onClick: () -> Unit,
506      ) : SelectableRadioButton(
507        testTag = testTag,
508        title = title,
509        radioButtonData = radioButtonData,
510        state = state,
511        drawBorder = drawBorder,
512        onClick = onClick,
513      )
514  
515      class IconTitle(
516        testTag: String? = null,
517        @DrawableRes val iconResId: Int,
518        iconColorProvider: @Composable () -> Color = { Color.Unspecified },
519        radioButtonData: OldRadioButtonData,
520        title: Label,
521        state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
522        val iconSize: IconSize = IconSize.SIZE24,
523        drawBorder: Boolean = true, 
524        onClick: () -> Unit,
525      ) : SelectableRadioButton(
526        testTag = testTag,
527        title = title,
528        radioButtonData = radioButtonData,
529        state = state,
530        drawBorder = drawBorder,
531        onClick = onClick,
532      ) {
533  
534        internal val iconData: IconData = IconData.Standard(
535          testTag = testTag?.let { tag -> tag + "Icon" },
536          iconResId = iconResId,
537          iconSize = iconSize,
538          iconColorProvider = iconColorProvider,
539          contentDescription = Label.EMPTY,
540        )
541      }
542  
543      class TitleDescription(
544        testTag: String? = null,
545        val description: Label,
546        val descriptionSecond: Label? = null,
547        val descriptionThird: Label? = null,
548        radioButtonData: OldRadioButtonData,
549        title: Label,
550        state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
551        drawBorder: Boolean = true, 
552        onClick: () -> Unit,
553      ) : SelectableRadioButton(
554        testTag = testTag,
555        title = title,
556        radioButtonData = radioButtonData,
557        state = state,
558        drawBorder = drawBorder,
559        onClick = onClick,
560      )
561    }
562  
563    sealed class SelectableCheckbox(
564      testTag: String?,
565      val checkboxData: CheckBoxSingleData,
566      title: Label,
567    ) : SingleCardData(testTag = testTag, title = title) {
568      class Title(
569        testTag: String? = null,
570        checkboxData: CheckBoxSingleData,
571        title: Label,
572      ) : SelectableCheckbox(testTag = testTag, title = title, checkboxData = checkboxData)
573  
574      class IconTitle(
575        testTag: String? = null,
576        @DrawableRes val iconResId: Int,
577        iconColorProvider: @Composable () -> Color = { Color.Unspecified },
578        checkboxData: CheckBoxSingleData,
579        title: Label,
580      ) : SelectableCheckbox(testTag = testTag, title = title, checkboxData = checkboxData) {
581  
582        internal val iconData: IconData = IconData.Standard(
583          testTag = testTag?.let { tag -> tag + "Icon" },
584          iconResId = iconResId,
585          iconSize = IconSize.SIZE24,
586          iconColorProvider = iconColorProvider,
587          contentDescription = Label.EMPTY,
588        )
589      }
590  
591      class TitleDescription(
592        testTag: String? = null,
593        val description: Label,
594        val descriptionSecond: Label? = null,
595        val descriptionThird: Label? = null,
596        checkboxData: CheckBoxSingleData,
597        title: Label,
598      ) : SelectableCheckbox(testTag = testTag, title = title, checkboxData = checkboxData)
599    }
600  }
601  
602  fun SingleCardInfoState.toIconState() = when (this) {
603    SingleCardInfoState.ENABLED -> IconState.ENABLED
604    SingleCardInfoState.DISABLE -> IconState.DISABLED
605  }
606  
607  fun SingleCardClickableRadioButtonState.toIconState() = when (this) {
608    SingleCardClickableRadioButtonState.ENABLED,
609    SingleCardClickableRadioButtonState.FOCUS,
610    -> IconState.ENABLED
611  
612    SingleCardClickableRadioButtonState.DISABLED -> IconState.DISABLED
613  }
614  