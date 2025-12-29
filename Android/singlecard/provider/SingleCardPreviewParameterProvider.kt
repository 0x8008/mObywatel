1    package pl.gov.coi.common.ui.ds.singlecard.provider
2    
3    import pl.gov.coi.common.domain.label.toLabel
4    import pl.gov.coi.common.ui.R
5    import pl.gov.coi.common.ui.ds.button.ButtonData
6    import pl.gov.coi.common.ui.ds.button.common.ButtonSize
7    import pl.gov.coi.common.ui.ds.button.common.ButtonType
8    import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
9    import pl.gov.coi.common.ui.ds.custom.icon.IconSize
10   import pl.gov.coi.common.ui.ds.singlecard.radiobutton.OldRadioButtonData
11   import pl.gov.coi.common.ui.ds.singlecard.radiobutton.RadioButtonId
12   import pl.gov.coi.common.ui.ds.singlecard.SingleCardClickableRadioButtonState
13   import pl.gov.coi.common.ui.ds.singlecard.SingleCardData
14   import pl.gov.coi.common.ui.ds.singlecard.SingleCardInfoExtras
15   import pl.gov.coi.common.ui.ds.singlecard.SingleCardInfoState
16   import pl.gov.coi.common.ui.ds.singlecard.SingleCardStatusBadgeData
17   import pl.gov.coi.common.ui.ds.switchcomponent.SwitchData
18   import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
19   import pl.gov.coi.common.ui.preview.ScreenShotTestData
20   
21   class SingleCardPreviewParameterProvider : CustomPreviewParameterProvider<SingleCardData>() {
22     override val screenShotTestValues: Sequence<ScreenShotTestData<SingleCardData>> = sequenceOf(
23       ScreenShotTestData(
24         screenShotTestName = "SingleCardInfoTitle",
25         value = provideSingleCardInfoTitle(),
26       ),
27       ScreenShotTestData(
28         screenShotTestName = "SingleCardInfoTitleLong",
29         value = provideSingleCardInfoTitleLong(),
30       ),
31       ScreenShotTestData(
32         screenShotTestName = "SingleCardInfoTitleDescription",
33         value = provideSingleCardInfoTitleDescription(),
34       ),
35       ScreenShotTestData(
36         screenShotTestName = "SingleCardInfoTitleDescriptionLong",
37         value = provideSingleCardInfoTitleDescriptionLong(),
38       ),
39       ScreenShotTestData(
40         screenShotTestName = "SingleCardInfoTitleInfo",
41         value = provideSingleCardInfoTitleInfo(),
42       ),
43       ScreenShotTestData(
44         screenShotTestName = "SingleCardInfoTitleInfoLong",
45         value = provideSingleCardInfoTitleInfoLong(),
46       ),
47       ScreenShotTestData(
48         screenShotTestName = "SingleCardInfoTitleIcon",
49         value = provideSingleCardInfoTitleIcon(),
50       ),
51       ScreenShotTestData(
52         screenShotTestName = "SingleCardInfoTitleInfoLong",
53         value = provideSingleCardInfoTitleIconBigger(),
54       ),
55       ScreenShotTestData(
56         screenShotTestName = "SingleCardInfoTitleDescriptionIcon",
57         value = provideSingleCardInfoTitleDescriptionIcon(),
58       ),
59       ScreenShotTestData(
60         screenShotTestName = "SingleCardInfoTitleDescriptionIconDisabledState",
61         value = provideSingleCardInfoTitleDescriptionIconDisabledState(),
62       ),
63       ScreenShotTestData(
64         screenShotTestName = "SingleCardInfoTitleWithButton",
65         value = provideSingleCardInfoTitleWithButton(),
66       ),
67       ScreenShotTestData(
68         screenShotTestName = "SingleCardInfoTitleWithSwitch",
69         value = provideSingleCardInfoTitleWithSwitch(),
70       ),
71       ScreenShotTestData(
72         screenShotTestName = "SingleCardInfoDraggableTitle",
73         value = provideSingleCardInfoDraggableTitle(),
74       ),
75       ScreenShotTestData(
76         screenShotTestName = "SingleCardInfoDraggableTitleDescription",
77         value = provideSingleCardInfoDraggableTitleDescription(),
78       ),
79       ScreenShotTestData(
80         screenShotTestName = "SingleCardClickableTitle",
81         value = provideSingleCardClickableTitle(),
82       ),
83       ScreenShotTestData(
84         screenShotTestName = "SingleCardClickableTitleWithoutTrailingIcon",
85         value = provideSingleCardClickableTitleWithoutTrailingIcon(),
86       ),
87       ScreenShotTestData(
88         screenShotTestName = "SingleCardClickableTitleLong",
89         value = provideSingleCardClickableTitleLong(),
90       ),
91       ScreenShotTestData(
92         screenShotTestName = "SingleCardClickableTitleDescription",
93         value = provideSingleCardClickableTitleDescription(),
94       ),
95       ScreenShotTestData(
96         screenShotTestName = "SingleCardClickableTitleDescriptionLong",
97         value = provideSingleCardClickableTitleDescriptionLong(),
98       ),
99       ScreenShotTestData(
100        screenShotTestName = "SingleCardClickableInfoTitle",
101        value = provideSingleCardClickableInfoTitle(),
102      ),
103      ScreenShotTestData(
104        screenShotTestName = "SingleCardClickableInfoTitleLong",
105        value = provideSingleCardClickableInfoTitleLong(),
106      ),
107      ScreenShotTestData(
108        screenShotTestName = "SingleCardClickableIconTitle",
109        value = provideSingleCardClickableIconTitle(),
110      ),
111      ScreenShotTestData(
112        screenShotTestName = "SingleCardClickableIconTitleLong",
113        value = provideSingleCardClickableIconTitleLong(),
114      ),
115      ScreenShotTestData(
116        screenShotTestName = "SingleCardClickableIconTitleDescription",
117        value = provideSingleCardClickableIconTitleDescription(),
118      ),
119      ScreenShotTestData(
120        screenShotTestName = "SingleCardClickableIconTitleDescriptionLong",
121        value = provideSingleCardClickableIconTitleDescriptionLong(),
122      ),
123      ScreenShotTestData(
124        screenShotTestName = "SingleCardClickableButtonIconTitle",
125        value = provideSingleCardButtonIconTitle(),
126      ),
127      ScreenShotTestData(
128        screenShotTestName = "SingleCardClickableButtonIconTitleDescription",
129        value = provideSingleCardButtonIconTitleDescription(),
130      ),
131      ScreenShotTestData(
132        screenShotTestName = "SingleCardClickableDeleteButtonIconTitle",
133        value = provideSingleCardDeleteButtonIconTitle(),
134      ),
135      ScreenShotTestData(
136        screenShotTestName = "SingleCardClickableIconTitleDescriptionLongEnabledState",
137        value = provideSingleCardClickableIconTitleDescriptionLong(),
138      ),
139      ScreenShotTestData(
140        screenShotTestName = "SingleCardClickableIconTitleDescriptionLongFocusState",
141        value = provideSingleCardClickableIconTitleDescriptionLongFocusState(),
142      ),
143      ScreenShotTestData(
144        screenShotTestName = "SingleCardClickableIconTitleDescriptionLongDisabledState",
145        value = provideSingleCardClickableIconTitleDescriptionLongDisabledState(),
146      ),
147      ScreenShotTestData(
148        screenShotTestName = "SingleCardClickableIconTitleDescriptionLongIconOnOneLineWithTitle",
149        value = provideSingleCardClickableIconTitleDescriptionLongIconOnOneLineWithTitle(),
150      ),
151      ScreenShotTestData(
152        screenShotTestName = "SingleCardClickableTitleDescriptionStatusBadge",
153        value = provideSingleCardClickableTitleDescriptionStatusBadge(),
154      ),
155      ScreenShotTestData(
156        screenShotTestName = "SingleCardSelectableRadioButtonTitleUnselected",
157        value = provideSingleCardSelectableRadioButtonTitleUnselected(),
158      ),
159      ScreenShotTestData(
160        screenShotTestName = "SingleCardSelectableRadioButtonTitleUnselectedLong",
161        value = provideSingleCardSelectableRadioButtonTitleUnselectedLong(),
162      ),
163      ScreenShotTestData(
164        screenShotTestName = "SingleCardSelectableRadioButtonTitleSelected",
165        value = provideSingleCardSelectableRadioButtonTitleSelected(),
166      ),
167      ScreenShotTestData(
168        screenShotTestName = "SingleCardSelectableRadioButtonIconTitleUnselected",
169        value = provideSingleCardSelectableRadioButtonIconTitleUnselected(),
170      ),
171      ScreenShotTestData(
172        screenShotTestName = "SingleCardSelectableRadioButtonIconTitleUnselectedLong",
173        value = provideSingleCardSelectableRadioButtonIconTitleUnselectedLong(),
174      ),
175      ScreenShotTestData(
176        screenShotTestName = "SingleCardSelectableRadioButtonIconTitleSelected",
177        value = provideSingleCardSelectableRadioButtonIconTitleSelected(),
178      ),
179      ScreenShotTestData(
180        screenShotTestName = "SingleCardSelectableRadioButtonTitleDescriptionUnselected",
181        value = provideSingleCardSelectableRadioButtonTitleDescriptionUnselected(),
182      ),
183      ScreenShotTestData(
184        screenShotTestName = "SingleCardSelectableRadioButtonTitleDescriptionUnselectedLong",
185        value = provideSingleCardSelectableRadioButtonTitleDescriptionUnselectedLong(),
186      ),
187      ScreenShotTestData(
188        screenShotTestName = "SingleCardSelectableRadioButtonTitleDescriptionSelected",
189        value = provideSingleCardSelectableRadioButtonTitleDescriptionSelected(),
190      ),
191      ScreenShotTestData(
192        screenShotTestName = "SingleCardSelectableRadioButtonTitleUnselectedEnabledState",
193        value = provideSingleCardSelectableRadioButtonTitleUnselected(),
194      ),
195      ScreenShotTestData(
196        screenShotTestName = "SingleCardSelectableRadioButtonTitleUnselectedFocusState",
197        value = provideSingleCardSelectableRadioButtonTitleUnselectedFocusState(),
198      ),
199      ScreenShotTestData(
200        screenShotTestName = "SingleCardSelectableRadioButtonTitleUnselectedDisabledState",
201        value = provideSingleCardSelectableRadioButtonTitleUnselectedDisabledState(),
202      ),
203      ScreenShotTestData(
204        screenShotTestName = "SingleCardSelectableRadioButtonBiggerIconTitleSelected",
205        value = provideSingleCardSelectableRadioButtonBiggerIconTitleSelected(),
206      ),
207      ScreenShotTestData(
208        screenShotTestName = "SingleCardInfoTitleDescriptionStatusBadge",
209        value = provideSingleCardInfoTitleDescriptionStatusBadge(),
210      ),
211    )
212  
213    private fun provideSingleCardInfoTitle() = SingleCardData.Info.Title(
214      title = "Card title".toLabel(),
215    )
216  
217    private fun provideSingleCardInfoTitleLong() = SingleCardData.Info.Title(
218      title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
219    )
220  
221    private fun provideSingleCardInfoTitleDescription() = SingleCardData.Info.TitleDescription(
222      title = "Card title".toLabel(),
223      description = "Card description".toLabel(),
224    )
225  
226    private fun provideSingleCardInfoTitleDescriptionLong() = SingleCardData.Info.TitleDescription(
227      title = "Card title".toLabel(),
228      description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt"
229        .toLabel(),
230    )
231  
232    private fun provideSingleCardInfoTitleInfo() = SingleCardData.Info.InfoTitle(
233      title = "Card title".toLabel(),
234      info = "Card info".toLabel(),
235    )
236  
237    private fun provideSingleCardInfoTitleInfoLong() = SingleCardData.Info.InfoTitle(
238      title = "Card title".toLabel(),
239      info = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
240    )
241  
242    private fun provideSingleCardInfoTitleIcon() = SingleCardData.Info.IconTitle(
243      title = "Card title".toLabel(),
244      iconResId = R.drawable.ab001_home,
245    )
246  
247    private fun provideSingleCardInfoTitleIconBigger() = SingleCardData.Info.IconTitle(
248      title = "Card title".toLabel(),
249      iconResId = R.drawable.ab001_home,
250      iconSize = IconSize.SIZE32,
251    )
252  
253    private fun provideSingleCardInfoTitleDescriptionIcon() = SingleCardData.Info.IconTitleDescription(
254      title = "Card title".toLabel(),
255      description = "Card description".toLabel(),
256      iconResId = R.drawable.ab001_home,
257    )
258  
259    private fun provideSingleCardInfoTitleDescriptionIconDisabledState() = SingleCardData.Info.IconTitleDescription(
260      title = "Card title".toLabel(),
261      description = "Card description".toLabel(),
262      iconResId = R.drawable.ab001_home,
263      state = SingleCardInfoState.DISABLE,
264    )
265  
266    private fun provideSingleCardInfoTitleWithButton() = SingleCardData.Info.Title(
267      title = "Card title".toLabel(),
268      extras = SingleCardInfoExtras.ButtonMore(
269        buttonData = ButtonData(
270          buttonSize = ButtonSize.Small,
271          buttonVariant = ButtonVariant.Primary,
272          buttonType = ButtonType.WithText(
273            label = "Więcej".toLabel(),
274          ),
275          onClick = {},
276        ),
277      ),
278    )
279  
280    private fun provideSingleCardInfoTitleWithSwitch() = SingleCardData.Info.Title(
281      title = "Card title".toLabel(),
282      extras = SingleCardInfoExtras.Switch(
283        switchData = SwitchData.SwitchOnly(
284          contentDescription = "Card title".toLabel(),
285          checked = false,
286          onCheckedChange = {},
287        ),
288      ),
289    )
290  
291    private fun provideSingleCardInfoDraggableTitle() = SingleCardData.Info.Title(
292      title = "Card title".toLabel(),
293      draggable = true,
294    )
295  
296    private fun provideSingleCardInfoDraggableTitleDescription() = SingleCardData.Info.TitleDescription(
297      title = "Card title".toLabel(),
298      description = "Card description".toLabel(),
299      draggable = true,
300    )
301  
302    private fun provideSingleCardClickableTitle() = SingleCardData.Clickable.Title(
303      title = "Card title".toLabel(),
304      onClick = {},
305    )
306  
307    private fun provideSingleCardClickableTitleWithoutTrailingIcon() = SingleCardData.Clickable.Title(
308      title = "Card title".toLabel(),
309      onClick = {},
310      trailingIonResId = null,
311    )
312  
313    private fun provideSingleCardClickableTitleLong() = SingleCardData.Clickable.Title(
314      title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
315      onClick = {},
316    )
317  
318    private fun provideSingleCardClickableTitleDescription() = SingleCardData.Clickable.TitleDescription(
319      title = "Card title".toLabel(),
320      description = "Card description".toLabel(),
321      onClick = {},
322    )
323  
324    private fun provideSingleCardClickableTitleDescriptionLong() = SingleCardData.Clickable.TitleDescription(
325      title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
326      description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor".toLabel(),
327      onClick = {},
328    )
329  
330    private fun provideSingleCardClickableInfoTitle() = SingleCardData.Clickable.InfoTitle(
331      title = "Card title".toLabel(),
332      info = "Card info".toLabel(),
333      onClick = {},
334    )
335  
336    private fun provideSingleCardClickableInfoTitleLong() = SingleCardData.Clickable.InfoTitle(
337      title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
338      info = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
339      onClick = {},
340    )
341  
342    private fun provideSingleCardClickableIconTitle() = SingleCardData.Clickable.IconTitle(
343      iconResId = R.drawable.ab001_home,
344      title = "Card title".toLabel(),
345      onClick = {},
346    )
347  
348    private fun provideSingleCardClickableIconTitleLong() = SingleCardData.Clickable.IconTitle(
349      iconResId = R.drawable.ab001_home,
350      title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
351      onClick = {},
352    )
353  
354    private fun provideSingleCardClickableIconTitleDescription() = SingleCardData.Clickable.IconTitleDescription(
355      iconResId = R.drawable.ab001_home,
356      title = "Card title".toLabel(),
357      description = "Card description".toLabel(),
358      onClick = {},
359    )
360  
361    private fun provideSingleCardClickableIconTitleDescriptionLong() = SingleCardData.Clickable.IconTitleDescription(
362      iconResId = R.drawable.ab001_home,
363      title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
364      description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor".toLabel(),
365      onClick = {},
366    )
367  
368    private fun provideSingleCardClickableIconTitleDescriptionLongIconOnOneLineWithTitle() =
369      SingleCardData.Clickable.IconTitleDescription(
370        iconResId = R.drawable.ab001_home,
371        iconOnOneLineWithTitle = true,
372        title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
373        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor".toLabel(),
374        onClick = {},
375      )
376  
377    private fun provideSingleCardClickableIconTitleDescriptionLongFocusState() =
378      SingleCardData.Clickable.IconTitleDescription(
379        iconResId = R.drawable.ab001_home,
380        title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
381        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor".toLabel(),
382        state = SingleCardClickableRadioButtonState.FOCUS,
383        onClick = {},
384      )
385  
386    private fun provideSingleCardClickableIconTitleDescriptionLongDisabledState() =
387      SingleCardData.Clickable.IconTitleDescription(
388        iconResId = R.drawable.ab001_home,
389        title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
390        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor".toLabel(),
391        state = SingleCardClickableRadioButtonState.DISABLED,
392        onClick = {},
393      )
394  
395    private fun provideSingleCardClickableTitleDescriptionStatusBadge() =
396      SingleCardData.Clickable.TitleDescriptionStatusBadge(
397        title = "Card title with status badge".toLabel(),
398        description = "Card description".toLabel(),
399        badgeData = SingleCardStatusBadgeData.WithIcon.Info(
400          text = "Badge status info".toLabel(),
401          iconContentDescription = "content desc".toLabel(),
402        ),
403        onClick = {},
404      )
405  
406    private fun provideSingleCardButtonIconTitle() = SingleCardData.Clickable.ButtonIconTitle(
407      iconResId = R.drawable.ab001_home,
408      title = "Card title".toLabel(),
409      onIconClick = {},
410    )
411  
412    private fun provideSingleCardButtonIconTitleDescription() = SingleCardData.Clickable.ButtonIconTitleDescription(
413      iconResId = R.drawable.ab001_home,
414      title = "Card title".toLabel(),
415      description = "Card description".toLabel(),
416      onIconClick = {},
417    )
418  
419    private fun provideSingleCardDeleteButtonIconTitle() = SingleCardData.Clickable.DeleteButtonIconTitle(
420      title = "Card title".toLabel(),
421      onClick = {},
422    )
423  
424    private fun provideSingleCardSelectableRadioButtonTitleUnselected() = SingleCardData.SelectableRadioButton.Title(
425      title = "Card title".toLabel(),
426      radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
427      onClick = {},
428    )
429  
430    private fun provideSingleCardSelectableRadioButtonTitleUnselectedFocusState() =
431      SingleCardData.SelectableRadioButton.Title(
432        title = "Card title".toLabel(),
433        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
434        state = SingleCardClickableRadioButtonState.FOCUS,
435        onClick = {},
436      )
437  
438    private fun provideSingleCardSelectableRadioButtonTitleUnselectedDisabledState() =
439      SingleCardData.SelectableRadioButton.Title(
440        title = "Card title".toLabel(),
441        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
442        state = SingleCardClickableRadioButtonState.DISABLED,
443        onClick = {},
444      )
445  
446    private fun provideSingleCardSelectableRadioButtonTitleUnselectedLong() =
447      SingleCardData.SelectableRadioButton.Title(
448        title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
449        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
450        onClick = {},
451      )
452  
453    private fun provideSingleCardSelectableRadioButtonTitleSelected() =
454      SingleCardData.SelectableRadioButton.Title(
455        title = "Card title".toLabel(),
456        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = true),
457        onClick = {},
458      )
459  
460    private fun provideSingleCardSelectableRadioButtonIconTitleUnselected() =
461      SingleCardData.SelectableRadioButton.IconTitle(
462        iconResId = R.drawable.ab001_home,
463        title = "Card title".toLabel(),
464        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
465        onClick = {},
466      )
467  
468    private fun provideSingleCardSelectableRadioButtonIconTitleUnselectedLong() =
469      SingleCardData.SelectableRadioButton.IconTitle(
470        iconResId = R.drawable.ab001_home,
471        title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
472        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
473        onClick = {},
474      )
475  
476    private fun provideSingleCardSelectableRadioButtonIconTitleSelected() =
477      SingleCardData.SelectableRadioButton.IconTitle(
478        iconResId = R.drawable.ab001_home,
479        title = "Card title".toLabel(),
480        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = true),
481        onClick = {},
482      )
483  
484    private fun provideSingleCardSelectableRadioButtonBiggerIconTitleSelected() =
485      SingleCardData.SelectableRadioButton.IconTitle(
486        iconResId = R.drawable.ab001_home,
487        iconSize = IconSize.SIZE32,
488        title = "Card title".toLabel(),
489        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = true),
490        onClick = {},
491      )
492  
493    private fun provideSingleCardSelectableRadioButtonTitleDescriptionUnselected() =
494      SingleCardData.SelectableRadioButton.TitleDescription(
495        title = "Card title".toLabel(),
496        description = "Card description no 1".toLabel(),
497        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
498        onClick = {},
499      )
500  
501    private fun provideSingleCardSelectableRadioButtonTitleDescriptionUnselectedLong() =
502      SingleCardData.SelectableRadioButton.TitleDescription(
503        title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
504        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor".toLabel(),
505        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
506        onClick = {},
507      )
508  
509    private fun provideSingleCardSelectableRadioButtonTitleDescriptionSelected() =
510      SingleCardData.SelectableRadioButton.TitleDescription(
511        title = "Card title".toLabel(),
512        description = "Card description no 1".toLabel(),
513        descriptionSecond = "Card description no 2".toLabel(),
514        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = true),
515        onClick = {},
516      )
517  
518    private fun provideSingleCardInfoTitleDescriptionStatusBadge() =
519      SingleCardData.Info.TitleStatusBadge(
520        title = "Status".toLabel(),
521        state = SingleCardInfoState.ENABLED,
522        badgeData = SingleCardStatusBadgeData.Default.Green(
523          text = "Opłacona".toLabel(),
524        ),
525      )
526  }
527  