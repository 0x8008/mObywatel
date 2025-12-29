1    package pl.gov.coi.common.ui.ds.cardlist.provider
2    
3    import android.content.Context
4    import pl.gov.coi.common.domain.Mapper
5    import pl.gov.coi.common.domain.label.toLabel
6    import pl.gov.coi.common.ui.R
7    import pl.gov.coi.common.ui.ds.button.ButtonData
8    import pl.gov.coi.common.ui.ds.button.common.ButtonSize
9    import pl.gov.coi.common.ui.ds.button.common.ButtonType
10   import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
11   import pl.gov.coi.common.ui.ds.cardlist.CardListData
12   import pl.gov.coi.common.ui.ds.custom.icon.IconSize
13   import pl.gov.coi.common.ui.ds.singlecard.radiobutton.OldRadioButtonData
14   import pl.gov.coi.common.ui.ds.singlecard.radiobutton.RadioButtonId
15   import pl.gov.coi.common.ui.ds.singlecard.SingleCardClickableRadioButtonState
16   import pl.gov.coi.common.ui.ds.singlecard.SingleCardData
17   import pl.gov.coi.common.ui.ds.singlecard.SingleCardInfoExtras
18   import pl.gov.coi.common.ui.ds.singlecard.SingleCardInfoState
19   import pl.gov.coi.common.ui.ds.singlecard.SingleCardStatusBadgeData
20   import pl.gov.coi.common.ui.ds.switchcomponent.SwitchData
21   import pl.gov.coi.common.ui.preview.CustomWrappedDataPreviewParameterProvider
22   import pl.gov.coi.common.ui.preview.ScreenShotTestDataProvider
23   import pl.gov.coi.common.ui.preview.WrappedValue
24   
25   data class ProvidedCardListData(
26     val previewName: String,
27     val data: CardListData,
28   )
29   
30   class CardListPreviewProvider : CustomWrappedDataPreviewParameterProvider<
31     Unit,
32     CardListData,
33     Mapper<Unit, CardListData>,
34     ProvidedCardListData,
35     >() {
36   
37     private val cards = mapOf(
38       "InfoTitle" to getCardListInfoTitle(),
39       "InfoTitleLong" to getCardListInfoTitleLong(),
40       "InfoTitleDescriptionLong" to getCardListInfoTitleDescriptionLong(),
41       "InfoTitleInfo" to getCardListInfoTitleInfo(),
42       "InfoTitleDescription" to getCardListInfoTitleDescription(),
43       "InfoTitleInfoLong" to getCardListInfoTitleInfoLong(),
44       "InfoTitleIcon" to getCardListInfoTitleIcon(),
45       "InfoTitleIconBigger" to getCardListInfoTitleIconBigger(),
46       "InfoTitleDescriptionIcon" to getCardListInfoTitleDescriptionIcon(),
47       "InfoTitleDescriptionIconDisabledState" to getCardListInfoTitleDescriptionIconDisabledState(),
48       "InfoTitleWithButton" to getCardListInfoTitleWithButton(),
49       "InfoTitleWithSwitch" to getCardListInfoTitleWithSwitch(),
50       "ClickableTitle" to getCardListClickableTitle(),
51       "ClickableTitleLong" to getCardListClickableTitleLong(),
52       "ClickableTitleDescription" to getCardListClickableTitleDescription(),
53       "ClickableTitleDescriptionLong" to getCardListClickableTitleDescriptionLong(),
54       "ClickableInfoTitle" to getCardListClickableInfoTitle(),
55       "ClickableInfoTitleLong" to getCardListClickableInfoTitleLong(),
56       "ClickableIconTitle" to getCardListClickableIconTitle(),
57       "ClickableIconTitleLong" to getCardListClickableIconTitleLong(),
58       "ClickableIconTitleDescription" to getCardListClickableIconTitleDescription(),
59       "ClickableIconTitleDescriptionLong" to getCardListClickableIconTitleDescriptionLong(),
60       "ClickableIconTitleDescriptionLongIconOnOneLineWithTitle" to
61         getCardListClickableIconTitleDescriptionLongIconOnOneLineWithTitle(),
62       "ClickableIconTitleDescriptionLongFocusState" to getCardListClickableIconTitleDescriptionLongFocusState(),
63       "ClickableIconTitleDescriptionLongDisabledState" to getCardListClickableIconTitleDescriptionLongDisabledState(),
64       "ClickableTitleDescriptionStatusBadge" to getCardListClickableTitleDescriptionStatusBadge(),
65       "ClickableButtonIconTitle" to getCardListClickableButtonIconTitle(),
66       "ClickableDeleteButtonIconTitle" to getCardListClickableDeleteButtonIconTitle(),
67       "SelectableRadioButtonTitleUnselected" to getCardListSelectableRadioButtonTitleUnselected(),
68       "SelectableRadioButtonTitleUnselectedFocusState" to getCardListSelectableRadioButtonTitleUnselectedFocusState(),
69       "SelectableRadioButtonTitleUnselectedDisabledState" to
70         getCardListSelectableRadioButtonTitleUnselectedDisabledState(),
71       "SelectableRadioButtonTitleUnselectedLong" to getCardListSelectableRadioButtonTitleUnselectedLong(),
72       "SelectableRadioButtonTitleSelected" to getCardListSelectableRadioButtonTitleSelected(),
73       "SelectableRadioButtonIconTitleUnselected" to getCardListSelectableRadioButtonIconTitleUnselected(),
74       "SelectableRadioButtonIconTitleUnselectedLong" to getCardListSelectableRadioButtonIconTitleUnselectedLong(),
75       "SelectableRadioButtonIconTitleSelected" to getCardListSelectableRadioButtonIconTitleSelected(),
76       "SelectableRadioButtonBiggerIconTitleSelected" to getCardListSelectableRadioButtonBiggerIconTitleSelected(),
77       "SelectableRadioButtonTitleDescriptionUnselected" to getCardListSelectableRadioButtonTitleDescriptionUnselected(),
78       "SelectableRadioButtonTitleDescriptionUnselectedLong" to
79         getCardListSelectableRadioButtonTitleDescriptionUnselectedLong(),
80       "SelectableRadioButtonTitleDescriptionSelected" to getCardListSelectableRadioButtonTitleDescriptionSelected(),
81     )
82   
83     override fun mapper(context: Context): Mapper<Unit, CardListData> {
84       return object : Mapper<Unit, CardListData> {
85         override fun invoke(p1: Unit): CardListData = CardListData(cards = emptyList())
86       }
87     }
88   
89     override val screenShotTestValues: Sequence<ScreenShotTestDataProvider<ProvidedCardListData>>
90       get() = cards.map { (testName, cardData) ->
91         ScreenShotTestDataProvider(
92           screenShotTestName = testName,
93           wrappedValue = WrappedValue {
94             ProvidedCardListData(
95               previewName = testName,
96               data = cardData,
97             )
98           },
99         )
100      }.asSequence()
101  
102    private fun getCardListInfoTitle() = CardListData(
103      cards = listOf(
104        SingleCardData.Info.Title(
105          title = "Card title".toLabel(),
106        ),
107        SingleCardData.Info.Title(
108          title = "Card title 2".toLabel(),
109        ),
110      ),
111    )
112  
113    private fun getCardListInfoTitleLong() = CardListData(
114      cards = listOf(
115        SingleCardData.Info.Title(
116          title = (
117            "Lorem ipsum dolor sit amet, consectetur adipiscing " +
118              "elit, sed do eiusmod tempor incididunt"
119            ).toLabel(),
120        ),
121        SingleCardData.Info.Title(
122          title = (
123            "Lorem ipsum dolor sit amet, consectetur adipiscing " +
124              "elit, sed do eiusmod tempor incididunt 2"
125            ).toLabel(),
126        ),
127      ),
128    )
129  
130    private fun getCardListInfoTitleDescription() = CardListData(
131      cards = listOf(
132        SingleCardData.Info.TitleDescription(
133          title = "Card title".toLabel(),
134          description = "Card description".toLabel(),
135        ),
136        SingleCardData.Info.TitleDescription(
137          title = "Card title 2".toLabel(),
138          description = "Card description 2".toLabel(),
139        ),
140      ),
141    )
142  
143    private fun getCardListInfoTitleDescriptionLong() = CardListData(
144      cards = listOf(
145        SingleCardData.Info.TitleDescription(
146          title = "Card title".toLabel(),
147          description = (
148            "Lorem ipsum dolor sit amet, consectetur adipiscing " +
149              "elit, sed do eiusmod tempor incididunt"
150            )
151            .toLabel(),
152        ),
153        SingleCardData.Info.TitleDescription(
154          title = "Card title 2".toLabel(),
155          description = (
156            "Lorem ipsum dolor sit amet, consectetur adipiscing " +
157              "elit, sed do eiusmod tempor incididunt 2"
158            )
159            .toLabel(),
160        ),
161      ),
162    )
163  
164    private fun getCardListInfoTitleInfo() = CardListData(
165      cards = listOf(
166        SingleCardData.Info.InfoTitle(
167          title = "Card title".toLabel(),
168          info = "Card info".toLabel(),
169        ),
170        SingleCardData.Info.InfoTitle(
171          title = "Card title 2".toLabel(),
172          info = "Card info 2".toLabel(),
173        ),
174      ),
175    )
176  
177    private fun getCardListInfoTitleInfoLong() = CardListData(
178      cards = listOf(
179        SingleCardData.Info.InfoTitle(
180          title = "Card title".toLabel(),
181          info = (
182            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
183              "eiusmod tempor incididunt"
184            ).toLabel(),
185        ),
186        SingleCardData.Info.InfoTitle(
187          title = "Card title 2".toLabel(),
188          info = (
189            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
190              "eiusmod tempor incididunt 2"
191            ).toLabel(),
192        ),
193      ),
194    )
195  
196    private fun getCardListInfoTitleIcon() = CardListData(
197      cards = listOf(
198        SingleCardData.Info.IconTitle(
199          title = "Card title".toLabel(),
200          iconResId = R.drawable.ab001_home,
201        ),
202        SingleCardData.Info.IconTitle(
203          title = "Card title 2".toLabel(),
204          iconResId = R.drawable.ab001_home,
205        ),
206      ),
207    )
208  
209    private fun getCardListInfoTitleIconBigger() = CardListData(
210      cards = listOf(
211        SingleCardData.Info.IconTitle(
212          title = "Card title".toLabel(),
213          iconResId = R.drawable.ab001_home,
214          iconSize = IconSize.SIZE32,
215        ),
216        SingleCardData.Info.IconTitle(
217          title = "Card title 2".toLabel(),
218          iconResId = R.drawable.ab001_home,
219          iconSize = IconSize.SIZE32,
220        ),
221      ),
222    )
223  
224    private fun getCardListInfoTitleDescriptionIcon() = CardListData(
225      cards = listOf(
226        SingleCardData.Info.IconTitleDescription(
227          title = "Card title".toLabel(),
228          description = "Card description".toLabel(),
229          iconResId = R.drawable.ab001_home,
230        ),
231        SingleCardData.Info.IconTitleDescription(
232          title = "Card title 2".toLabel(),
233          description = "Card description 2".toLabel(),
234          iconResId = R.drawable.ab001_home,
235        ),
236      ),
237    )
238  
239    private fun getCardListInfoTitleDescriptionIconDisabledState() = CardListData(
240      cards = listOf(
241        SingleCardData.Info.IconTitleDescription(
242          title = "Card title".toLabel(),
243          description = "Card description".toLabel(),
244          iconResId = R.drawable.ab001_home,
245          state = SingleCardInfoState.DISABLE,
246        ),
247        SingleCardData.Info.IconTitleDescription(
248          title = "Card title 2".toLabel(),
249          description = "Card description 2".toLabel(),
250          iconResId = R.drawable.ab001_home,
251          state = SingleCardInfoState.DISABLE,
252        ),
253      ),
254    )
255  
256    private fun getCardListInfoTitleWithButton() = CardListData(
257      cards = listOf(
258        SingleCardData.Info.Title(
259          title = "Card title".toLabel(),
260          extras = SingleCardInfoExtras.ButtonMore(
261            buttonData = ButtonData(
262              buttonSize = ButtonSize.Small,
263              buttonVariant = ButtonVariant.Primary,
264              buttonType = ButtonType.WithText(
265                label = "Więcej".toLabel(),
266              ),
267              onClick = {},
268            ),
269          ),
270        ),
271        SingleCardData.Info.Title(
272          title = "Card title 2".toLabel(),
273          extras = SingleCardInfoExtras.ButtonMore(
274            buttonData = ButtonData(
275              buttonSize = ButtonSize.Small,
276              buttonVariant = ButtonVariant.Primary,
277              buttonType = ButtonType.WithText(
278                label = "Więcej 2".toLabel(),
279              ),
280              onClick = {},
281            ),
282          ),
283        ),
284      ),
285    )
286  
287    private fun getCardListInfoTitleWithSwitch() = CardListData(
288      cards = listOf(
289        SingleCardData.Info.Title(
290          title = "Card title".toLabel(),
291          extras = SingleCardInfoExtras.Switch(
292            switchData = SwitchData.SwitchOnly(
293              contentDescription = "Card title".toLabel(),
294              checked = false,
295              onCheckedChange = {},
296            ),
297          ),
298        ),
299        SingleCardData.Info.Title(
300          title = "Card title 2".toLabel(),
301          extras = SingleCardInfoExtras.Switch(
302            switchData = SwitchData.SwitchOnly(
303              checked = false,
304              contentDescription = "Card title 2".toLabel(),
305              onCheckedChange = {},
306            ),
307          ),
308        ),
309      ),
310    )
311  
312    private fun getCardListClickableTitle() = CardListData(
313      cards = listOf(
314        SingleCardData.Clickable.Title(
315          title = "Card title".toLabel(),
316          onClick = {},
317        ),
318        SingleCardData.Clickable.Title(
319          title = "Card title 2".toLabel(),
320          onClick = {},
321        ),
322      ),
323    )
324  
325    private fun getCardListClickableTitleLong() = CardListData(
326      cards = listOf(
327        SingleCardData.Clickable.Title(
328          title = (
329            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
330              "do eiusmod tempor incididunt"
331            ).toLabel(),
332          onClick = {},
333        ),
334        SingleCardData.Clickable.Title(
335          title = (
336            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
337              "do eiusmod tempor incididunt 2"
338            ).toLabel(),
339          onClick = {},
340        ),
341      ),
342    )
343  
344    private fun getCardListClickableTitleDescription() = CardListData(
345      cards = listOf(
346        SingleCardData.Clickable.TitleDescription(
347          title = "Card title".toLabel(),
348          description = "Card description".toLabel(),
349          onClick = {},
350        ),
351        SingleCardData.Clickable.TitleDescription(
352          title = "Card title 2".toLabel(),
353          description = "Card description 2".toLabel(),
354          onClick = {},
355        ),
356      ),
357    )
358  
359    private fun getCardListClickableTitleDescriptionLong() = CardListData(
360      cards = listOf(
361        SingleCardData.Clickable.TitleDescription(
362          title = (
363            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
364              "do eiusmod tempor incididunt"
365            ).toLabel(),
366          description = (
367            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
368              "sed do eiusmod tempor"
369            ).toLabel(),
370          onClick = {},
371        ),
372        SingleCardData.Clickable.TitleDescription(
373          title = (
374            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
375              "do eiusmod tempor incididunt 2"
376            ).toLabel(),
377          description = (
378            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
379              "sed do eiusmod tempor 2"
380            ).toLabel(),
381          onClick = {},
382        ),
383      ),
384    )
385  
386    private fun getCardListClickableInfoTitle() = CardListData(
387      cards = listOf(
388        SingleCardData.Clickable.InfoTitle(
389          title = "Card title".toLabel(),
390          info = "Card info".toLabel(),
391          onClick = {},
392        ),
393        SingleCardData.Clickable.InfoTitle(
394          title = "Card title 2".toLabel(),
395          info = "Card info 2".toLabel(),
396          onClick = {},
397        ),
398      ),
399    )
400  
401    private fun getCardListClickableInfoTitleLong() = CardListData(
402      cards = listOf(
403        SingleCardData.Clickable.InfoTitle(
404          title = (
405            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
406              "do eiusmod tempor incididunt"
407            ).toLabel(),
408          info = (
409            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
410              "do eiusmod tempor incididunt"
411            ).toLabel(),
412          onClick = {},
413        ),
414        SingleCardData.Clickable.InfoTitle(
415          title = (
416            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
417              "do eiusmod tempor incididunt 2"
418            ).toLabel(),
419          info = (
420            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
421              "do eiusmod tempor incididunt 2"
422            ).toLabel(),
423          onClick = {},
424        ),
425      ),
426    )
427  
428    private fun getCardListClickableIconTitle() = CardListData(
429      cards = listOf(
430        SingleCardData.Clickable.IconTitle(
431          iconResId = R.drawable.ab001_home,
432          title = "Card title".toLabel(),
433          onClick = {},
434        ),
435        SingleCardData.Clickable.IconTitle(
436          iconResId = R.drawable.ab001_home,
437          title = "Card title 2".toLabel(),
438          onClick = {},
439        ),
440      ),
441    )
442  
443    private fun getCardListClickableIconTitleLong() = CardListData(
444      cards = listOf(
445        SingleCardData.Clickable.IconTitle(
446          iconResId = R.drawable.ab001_home,
447          title = (
448            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
449              "do eiusmod tempor incididunt"
450            ).toLabel(),
451          onClick = {},
452        ),
453        SingleCardData.Clickable.IconTitle(
454          iconResId = R.drawable.ab001_home,
455          title = (
456            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
457              "do eiusmod tempor incididunt 2"
458            ).toLabel(),
459          onClick = {},
460        ),
461      ),
462    )
463  
464    private fun getCardListClickableIconTitleDescription() = CardListData(
465      cards = listOf(
466        SingleCardData.Clickable.IconTitleDescription(
467          iconResId = R.drawable.ab001_home,
468          title = "Card title".toLabel(),
469          description = "Card description".toLabel(),
470          onClick = {},
471        ),
472        SingleCardData.Clickable.IconTitleDescription(
473          iconResId = R.drawable.ab001_home,
474          title = "Card title 2".toLabel(),
475          description = "Card description 2".toLabel(),
476          onClick = {},
477        ),
478      ),
479    )
480  
481    private fun getCardListClickableIconTitleDescriptionLong() = CardListData(
482      cards = listOf(
483        SingleCardData.Clickable.IconTitleDescription(
484          iconResId = R.drawable.ab001_home,
485          title = (
486            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
487              "do eiusmod tempor incididunt"
488            ).toLabel(),
489          description = (
490            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
491              "sed do eiusmod tempor"
492            ).toLabel(),
493          onClick = {},
494        ),
495        SingleCardData.Clickable.IconTitleDescription(
496          iconResId = R.drawable.ab001_home,
497          title = (
498            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
499              "do eiusmod tempor incididunt 2"
500            ).toLabel(),
501          description = (
502            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
503              "sed do eiusmod tempor 2"
504            ).toLabel(),
505          onClick = {},
506        ),
507      ),
508    )
509  
510    private fun getCardListClickableIconTitleDescriptionLongIconOnOneLineWithTitle() = CardListData(
511      cards = listOf(
512        SingleCardData.Clickable.IconTitleDescription(
513          iconResId = R.drawable.ab001_home,
514          iconOnOneLineWithTitle = true,
515          title = (
516            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
517              "do eiusmod tempor incididunt"
518            ).toLabel(),
519          description = (
520            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
521              "sed do eiusmod tempor"
522            ).toLabel(),
523          onClick = {},
524        ),
525        SingleCardData.Clickable.IconTitleDescription(
526          iconResId = R.drawable.ab001_home,
527          iconOnOneLineWithTitle = true,
528          title = (
529            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
530              "do eiusmod tempor incididunt 2"
531            ).toLabel(),
532          description = (
533            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
534              "sed do eiusmod tempor 2"
535            ).toLabel(),
536          onClick = {},
537        ),
538      ),
539    )
540  
541    private fun getCardListClickableIconTitleDescriptionLongFocusState() = CardListData(
542      cards = listOf(
543        SingleCardData.Clickable.IconTitleDescription(
544          iconResId = R.drawable.ab001_home,
545          title = (
546            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
547              "do eiusmod tempor incididunt"
548            ).toLabel(),
549          description = (
550            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
551              "sed do eiusmod tempor"
552            ).toLabel(),
553          state = SingleCardClickableRadioButtonState.FOCUS,
554          onClick = {},
555        ),
556        SingleCardData.Clickable.IconTitleDescription(
557          iconResId = R.drawable.ab001_home,
558          title = (
559            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
560              "do eiusmod tempor incididunt 2"
561            ).toLabel(),
562          description = (
563            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
564              "sed do eiusmod tempor 2"
565            ).toLabel(),
566          state = SingleCardClickableRadioButtonState.ENABLED,
567          onClick = {},
568        ),
569      ),
570    )
571  
572    private fun getCardListClickableIconTitleDescriptionLongDisabledState() = CardListData(
573      cards = listOf(
574        SingleCardData.Clickable.IconTitleDescription(
575          iconResId = R.drawable.ab001_home,
576          title = (
577            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
578              "do eiusmod tempor incididunt"
579            ).toLabel(),
580          description = (
581            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
582              "sed do eiusmod tempor"
583            ).toLabel(),
584          state = SingleCardClickableRadioButtonState.DISABLED,
585          onClick = {},
586        ),
587        SingleCardData.Clickable.IconTitleDescription(
588          iconResId = R.drawable.ab001_home,
589          title = (
590            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
591              "do eiusmod tempor incididunt 2"
592            ).toLabel(),
593          description = (
594            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
595              "sed do eiusmod tempor 2"
596            ).toLabel(),
597          state = SingleCardClickableRadioButtonState.DISABLED,
598          onClick = {},
599        ),
600      ),
601    )
602  
603    private fun getCardListClickableTitleDescriptionStatusBadge() = CardListData(
604      cards = listOf(
605        SingleCardData.Clickable.TitleDescriptionStatusBadge(
606          title = "Card title with status badge".toLabel(),
607          description = "Card description".toLabel(),
608          badgeData = SingleCardStatusBadgeData.WithIcon.Info(
609            text = "Badge status info".toLabel(),
610            iconContentDescription = "content desc".toLabel(),
611          ),
612          onClick = {},
613        ),
614        SingleCardData.Clickable.TitleDescriptionStatusBadge(
615          title = "Card title with status badge 2".toLabel(),
616          description = "Card description 2".toLabel(),
617          badgeData = SingleCardStatusBadgeData.WithIcon.Info(
618            text = "Badge status info 2".toLabel(),
619            iconContentDescription = "content desc 2".toLabel(),
620          ),
621          onClick = {},
622        ),
623      ),
624    )
625  
626    private fun getCardListClickableButtonIconTitle() = CardListData(
627      cards = listOf(
628        SingleCardData.Clickable.ButtonIconTitle(
629          iconResId = R.drawable.ab001_home,
630          title = "Card title".toLabel(),
631          onIconClick = {},
632        ),
633        SingleCardData.Clickable.ButtonIconTitle(
634          iconResId = R.drawable.ab001_home,
635          title = "Card title 2".toLabel(),
636          onIconClick = {},
637        ),
638      ),
639    )
640  
641    private fun getCardListClickableDeleteButtonIconTitle() = CardListData(
642      cards = listOf(
643        SingleCardData.Clickable.DeleteButtonIconTitle(
644          title = "Card title".toLabel(),
645          onClick = {},
646        ),
647        SingleCardData.Clickable.DeleteButtonIconTitle(
648          title = "Card title 2".toLabel(),
649          onClick = {},
650        ),
651      ),
652    )
653  
654    private fun getCardListSelectableRadioButtonTitleUnselected() = CardListData(
655      cards = listOf(
656        SingleCardData.SelectableRadioButton.Title(
657          title = "Card title".toLabel(),
658          radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
659          onClick = {},
660        ),
661        SingleCardData.SelectableRadioButton.Title(
662          title = "Card title 2".toLabel(),
663          radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
664          onClick = {},
665        ),
666      ),
667    )
668  
669    private fun getCardListSelectableRadioButtonTitleUnselectedFocusState() = CardListData(
670      cards = listOf(
671        SingleCardData.SelectableRadioButton.Title(
672          title = "Card title".toLabel(),
673          radioButtonData = OldRadioButtonData(
674            id = RadioButtonId.Default,
675            isSelected = false,
676          ),
677          state = SingleCardClickableRadioButtonState.FOCUS,
678          onClick = {},
679        ),
680        SingleCardData.SelectableRadioButton.Title(
681          title = "Card title 2".toLabel(),
682          radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
683          state = SingleCardClickableRadioButtonState.FOCUS,
684          onClick = {},
685        ),
686      ),
687    )
688  
689    private fun getCardListSelectableRadioButtonTitleUnselectedDisabledState() = CardListData(
690      cards = listOf(
691        SingleCardData.SelectableRadioButton.Title(
692          title = "Card title".toLabel(),
693          radioButtonData = OldRadioButtonData(
694            id = RadioButtonId.Default,
695            isSelected = false,
696          ),
697          state = SingleCardClickableRadioButtonState.DISABLED,
698          onClick = {},
699        ),
700        SingleCardData.SelectableRadioButton.Title(
701          title = "Card title 2".toLabel(),
702          radioButtonData = OldRadioButtonData(
703            id = RadioButtonId.Default,
704            isSelected = false,
705          ),
706          state = SingleCardClickableRadioButtonState.DISABLED,
707          onClick = {},
708        ),
709      ),
710    )
711  
712    private fun getCardListSelectableRadioButtonTitleUnselectedLong() = CardListData(
713      cards = listOf(
714        SingleCardData.SelectableRadioButton.Title(
715          title = (
716            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
717              "do eiusmod tempor incididunt"
718            ).toLabel(),
719          radioButtonData = OldRadioButtonData(
720            id = RadioButtonId.Default,
721            isSelected = false,
722          ),
723          onClick = {},
724        ),
725        SingleCardData.SelectableRadioButton.Title(
726          title = (
727            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
728              "do eiusmod tempor incididunt 2"
729            ).toLabel(),
730          radioButtonData = OldRadioButtonData(
731            id = RadioButtonId.Default,
732            isSelected = false,
733          ),
734          onClick = {},
735        ),
736      ),
737    )
738  
739    private fun getCardListSelectableRadioButtonTitleSelected() = CardListData(
740      cards = listOf(
741        SingleCardData.SelectableRadioButton.Title(
742          title = "Card title".toLabel(),
743          radioButtonData = OldRadioButtonData(
744            id = RadioButtonId.Default,
745            isSelected = true,
746          ),
747          onClick = {},
748        ),
749        SingleCardData.SelectableRadioButton.Title(
750          title = "Card title 2".toLabel(),
751          radioButtonData = OldRadioButtonData(
752            id = RadioButtonId.Default,
753            isSelected = false,
754          ),
755          onClick = {},
756        ),
757      ),
758    )
759  
760    private fun getCardListSelectableRadioButtonIconTitleUnselected() = CardListData(
761      cards = listOf(
762        SingleCardData.SelectableRadioButton.IconTitle(
763          iconResId = R.drawable.ab001_home,
764          title = "Card title".toLabel(),
765          radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
766          onClick = {},
767        ),
768        SingleCardData.SelectableRadioButton.IconTitle(
769          iconResId = R.drawable.ab001_home,
770          title = "Card title 2".toLabel(),
771          radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
772          onClick = {},
773        ),
774      ),
775    )
776  
777    private fun getCardListSelectableRadioButtonIconTitleUnselectedLong() = CardListData(
778      cards = listOf(
779        SingleCardData.SelectableRadioButton.IconTitle(
780          iconResId = R.drawable.ab001_home,
781          title = (
782            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
783              "do eiusmod tempor incididunt"
784            ).toLabel(),
785          radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
786          onClick = {},
787        ),
788        SingleCardData.SelectableRadioButton.IconTitle(
789          iconResId = R.drawable.ab001_home,
790          title = (
791            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
792              "do eiusmod tempor incididunt 2"
793            ).toLabel(),
794          radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
795          onClick = {},
796        ),
797      ),
798    )
799  
800    private fun getCardListSelectableRadioButtonIconTitleSelected() = CardListData(
801      cards = listOf(
802        SingleCardData.SelectableRadioButton.IconTitle(
803          iconResId = R.drawable.ab001_home,
804          title = "Card title".toLabel(),
805          radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = true),
806          onClick = {},
807        ),
808        SingleCardData.SelectableRadioButton.IconTitle(
809          iconResId = R.drawable.ab001_home,
810          title = "Card title 2".toLabel(),
811          radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
812          onClick = {},
813        ),
814      ),
815    )
816  
817    private fun getCardListSelectableRadioButtonBiggerIconTitleSelected() = CardListData(
818      cards = listOf(
819        SingleCardData.SelectableRadioButton.IconTitle(
820          iconResId = R.drawable.ab001_home,
821          iconSize = IconSize.SIZE32,
822          title = "Card title".toLabel(),
823          radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = true),
824          onClick = {},
825        ),
826        SingleCardData.SelectableRadioButton.IconTitle(
827          iconResId = R.drawable.ab001_home,
828          iconSize = IconSize.SIZE32,
829          title = "Card title 2".toLabel(),
830          radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
831          onClick = {},
832        ),
833      ),
834    )
835  
836    private fun getCardListSelectableRadioButtonTitleDescriptionUnselected() = CardListData(
837      cards = listOf(
838        SingleCardData.SelectableRadioButton.TitleDescription(
839          title = "Card title".toLabel(),
840          description = "Card description no 1".toLabel(),
841          radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
842          onClick = {},
843        ),
844        SingleCardData.SelectableRadioButton.TitleDescription(
845          title = "Card title 2".toLabel(),
846          description = "Card description no 2".toLabel(),
847          radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
848          onClick = {},
849        ),
850      ),
851    )
852  
853    private fun getCardListSelectableRadioButtonTitleDescriptionUnselectedLong() = CardListData(
854      cards = listOf(
855        SingleCardData.SelectableRadioButton.TitleDescription(
856          title = (
857            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
858              "do eiusmod tempor incididunt"
859            ).toLabel(),
860          description = (
861            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
862              "sed do eiusmod tempor"
863            ).toLabel(),
864          radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
865          onClick = {},
866        ),
867        SingleCardData.SelectableRadioButton.TitleDescription(
868          title = (
869            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
870              "do eiusmod tempor incididunt 2"
871            ).toLabel(),
872          description = (
873            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
874              "sed do eiusmod tempor 2"
875            ).toLabel(),
876          radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
877          onClick = {},
878        ),
879      ),
880    )
881  
882    private fun getCardListSelectableRadioButtonTitleDescriptionSelected() = CardListData(
883      cards = listOf(
884        SingleCardData.SelectableRadioButton.TitleDescription(
885          title = "Card title".toLabel(),
886          description = "Card description no 1".toLabel(),
887          descriptionSecond = "Card description no 2".toLabel(),
888          radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = true),
889          onClick = {},
890        ),
891        SingleCardData.SelectableRadioButton.TitleDescription(
892          title = "Card title 2".toLabel(),
893          description = "Card description no 2".toLabel(),
894          descriptionSecond = "Card description no 2".toLabel(),
895          radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
896          onClick = {},
897        ),
898      ),
899    )
900  }
901  