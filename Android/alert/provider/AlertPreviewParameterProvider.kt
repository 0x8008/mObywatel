1    package pl.gov.coi.common.ui.ds.alert.provider
2    
3    import pl.gov.coi.common.domain.label.Label
4    import pl.gov.coi.common.domain.label.toLabel
5    import pl.gov.coi.common.ui.ds.alert.AlertButtonData
6    import pl.gov.coi.common.ui.ds.alert.AlertData
7    import pl.gov.coi.common.ui.ds.button.buttontext.ButtonTextData
8    import pl.gov.coi.common.ui.ds.link.LinkData
9    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
10   import pl.gov.coi.common.ui.preview.ScreenShotTestData
11   
12   class AlertPreviewParameterProvider : CustomPreviewParameterProvider<AlertData>() {
13     override val screenShotTestValues: Sequence<ScreenShotTestData<AlertData>> = sequenceOf(
14       ScreenShotTestData(
15         screenShotTestName = "AlertInfoDescr",
16         value = provideAlertInfoOnlyDescription(),
17       ),
18       ScreenShotTestData(
19         screenShotTestName = "AlertInfoTitleDescr",
20         value = provideAlertInfoTitleDescription(),
21       ),
22       ScreenShotTestData(
23         screenShotTestName = "AlertInfoDescrTextBtn",
24         value = provideAlertInfoDescriptionTextBtn(),
25       ),
26       ScreenShotTestData(
27         screenShotTestName = "AlertInfoDescrLink",
28         value = provideAlertInfoDescriptionLink(),
29       ),
30       ScreenShotTestData(
31         screenShotTestName = "AlertInfoTitleDescrTextBtn",
32         value = provideAlertInfoTitleDescrTextBtn(),
33       ),
34       ScreenShotTestData(
35         screenShotTestName = "AlertInfoDescrTextBtnCloseBtn",
36         value = provideAlertInfoDescrTextBtnCloseBtn(),
37       ),
38       ScreenShotTestData(
39         screenShotTestName = "AlertInfoFull",
40         value = provideAlertInfoFull(),
41       ),
42       ScreenShotTestData(
43         screenShotTestName = "AlertErrorDescr",
44         value = provideAlertErrorOnlyDescription(),
45       ),
46       ScreenShotTestData(
47         screenShotTestName = "AlertErrorTitleDescr",
48         value = provideAlertErrorTitleDescription(),
49       ),
50       ScreenShotTestData(
51         screenShotTestName = "AlertErrorDescrTextBtn",
52         value = provideAlertErrorDescriptionTextBtn(),
53       ),
54       ScreenShotTestData(
55         screenShotTestName = "AlertErrorDescrLink",
56         value = provideAlertErrorDescriptionLink(),
57       ),
58       ScreenShotTestData(
59         screenShotTestName = "AlertErrorTitleDescrTextBtn",
60         value = provideAlertErrorTitleDescrTextBtn(),
61       ),
62       ScreenShotTestData(
63         screenShotTestName = "AlertErrorDescrTextBtnCloseBtn",
64         value = provideAlertErrorDescrTextBtnCloseBtn(),
65       ),
66       ScreenShotTestData(
67         screenShotTestName = "AlertErrorFull",
68         value = provideAlertErrorFull(),
69       ),
70       ScreenShotTestData(
71         screenShotTestName = "AlertWarningDescr",
72         value = provideAlertWarningOnlyDescription(),
73       ),
74       ScreenShotTestData(
75         screenShotTestName = "AlertWarningTitleDescr",
76         value = provideAlertWarningTitleDescription(),
77       ),
78       ScreenShotTestData(
79         screenShotTestName = "AlertWarningDescrTextBtn",
80         value = provideAlertWarningDescriptionTextBtn(),
81       ),
82       ScreenShotTestData(
83         screenShotTestName = "AlertWarningDescrLink",
84         value = provideAlertWarningDescriptionLink(),
85       ),
86       ScreenShotTestData(
87         screenShotTestName = "AlertWarningTitleDescrTextBtn",
88         value = provideAlertWarningTitleDescrTextBtn(),
89       ),
90       ScreenShotTestData(
91         screenShotTestName = "AlertWarningDescrTextBtnCloseBtn",
92         value = provideAlertWarningDescrTextBtnCloseBtn(),
93       ),
94       ScreenShotTestData(
95         screenShotTestName = "AlertWarningFull",
96         value = provideAlertWarningFull(),
97       ),
98       ScreenShotTestData(
99         screenShotTestName = "AlertSuccessDescr",
100        value = provideAlertSuccessOnlyDescription(),
101      ),
102      ScreenShotTestData(
103        screenShotTestName = "AlertSuccessTitleDescr",
104        value = provideAlertSuccessTitleDescription(),
105      ),
106      ScreenShotTestData(
107        screenShotTestName = "AlertSuccessDescrTextBtn",
108        value = provideAlertSuccessDescriptionTextBtn(),
109      ),
110      ScreenShotTestData(
111        screenShotTestName = "AlertSuccessDescrLink",
112        value = provideAlertSuccessDescriptionLink(),
113      ),
114      ScreenShotTestData(
115        screenShotTestName = "AlertSuccessTitleDescrTextBtn",
116        value = provideAlertSuccessTitleDescrTextBtn(),
117      ),
118      ScreenShotTestData(
119        screenShotTestName = "AlertSuccessDescrTextBtnCloseBtn",
120        value = provideAlertSuccessDescrTextBtnCloseBtn(),
121      ),
122      ScreenShotTestData(
123        screenShotTestName = "AlertSuccessFull",
124        value = provideAlertSuccessFull(),
125      ),
126    )
127  
128    private fun provideAlertInfoOnlyDescription() = AlertData.Info(
129      bodyText = (
130        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
131          "incididunt ut labore."
132        ).toLabel(),
133      alertContentDescription = Label.EMPTY,
134    )
135  
136    private fun provideAlertInfoTitleDescription() = AlertData.Info(
137      title = "Info alert".toLabel(),
138      bodyText = (
139        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
140          "incididunt ut labore."
141        ).toLabel(),
142      alertContentDescription = Label.EMPTY,
143    )
144  
145    private fun provideAlertInfoDescriptionTextBtn() = AlertData.Info(
146      bodyText = (
147        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
148          "incididunt ut labore."
149        ).toLabel(),
150      alertContentDescription = Label.EMPTY,
151      alertButtonData = AlertButtonData.ButtonText(
152        data = ButtonTextData(
153          label = "Text button".toLabel(),
154        ) {},
155      ),
156    )
157  
158    private fun provideAlertInfoDescriptionLink() = AlertData.Info(
159      bodyText = (
160        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
161          "incididunt ut labore."
162        ).toLabel(),
163      alertContentDescription = Label.EMPTY,
164      alertButtonData = AlertButtonData.Link(
165        data = LinkData(
166          label = "Link".toLabel(),
167          url = "",
168          linkType = LinkData.LinkType.WEBSITE,
169          onClick = {},
170        ),
171      ),
172    )
173  
174    private fun provideAlertInfoTitleDescrTextBtn() = AlertData.Info(
175      title = "Info alert".toLabel(),
176      bodyText = (
177        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
178          "incididunt ut labore."
179        ).toLabel(),
180      alertContentDescription = Label.EMPTY,
181      alertButtonData = AlertButtonData.ButtonText(
182        data = ButtonTextData(
183          label = "Text button".toLabel(),
184        ) {},
185      ),
186    )
187  
188    private fun provideAlertInfoDescrTextBtnCloseBtn() = AlertData.Info(
189      bodyText = (
190        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
191          "incididunt ut labore."
192        ).toLabel(),
193      alertContentDescription = Label.EMPTY,
194      onCloseButtonClick = {},
195      alertButtonData = AlertButtonData.ButtonText(
196        data = ButtonTextData(
197          label = "Text button".toLabel(),
198          onClick = {},
199        ),
200      ),
201    )
202  
203    private fun provideAlertInfoFull() = AlertData.Info(
204      title = "Info alert".toLabel(),
205      bodyText = (
206        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
207          "incididunt ut labore."
208        ).toLabel(),
209      alertContentDescription = Label.EMPTY,
210      onCloseButtonClick = {},
211      alertButtonData = AlertButtonData.ButtonText(
212        data = ButtonTextData(
213          label = "Text button".toLabel(),
214          onClick = {},
215        ),
216      ),
217    )
218  
219    private fun provideAlertErrorOnlyDescription() = AlertData.Error(
220      bodyText = (
221        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
222          "incididunt ut labore."
223        ).toLabel(),
224      alertContentDescription = Label.EMPTY,
225    )
226  
227    private fun provideAlertErrorTitleDescription() = AlertData.Error(
228      title = "Error alert".toLabel(),
229      bodyText = (
230        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
231          "incididunt ut labore."
232        ).toLabel(),
233      alertContentDescription = Label.EMPTY,
234    )
235  
236    private fun provideAlertErrorDescriptionTextBtn() = AlertData.Error(
237      bodyText = (
238        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
239          "incididunt ut labore."
240        ).toLabel(),
241      alertContentDescription = Label.EMPTY,
242      alertButtonData = AlertButtonData.ButtonText(
243        data = ButtonTextData(
244          label = "Text button".toLabel(),
245          onClick = {},
246        ),
247      ),
248    )
249  
250    private fun provideAlertErrorDescriptionLink() = AlertData.Error(
251      bodyText = (
252        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
253          "incididunt ut labore."
254        ).toLabel(),
255      alertContentDescription = Label.EMPTY,
256      alertButtonData = AlertButtonData.Link(
257        data = LinkData(
258          label = "Link".toLabel(),
259          url = "",
260          linkType = LinkData.LinkType.WEBSITE,
261          onClick = {},
262        ),
263      ),
264    )
265  
266    private fun provideAlertErrorTitleDescrTextBtn() = AlertData.Error(
267      title = "Error alert".toLabel(),
268      bodyText = (
269        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
270          "incididunt ut labore."
271        ).toLabel(),
272      alertContentDescription = Label.EMPTY,
273      alertButtonData = AlertButtonData.ButtonText(
274        data = ButtonTextData(
275          label = "Text button".toLabel(),
276          onClick = {},
277        ),
278      ),
279    )
280  
281    private fun provideAlertErrorDescrTextBtnCloseBtn() = AlertData.Error(
282      bodyText = (
283        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
284          "incididunt ut labore."
285        ).toLabel(),
286      alertContentDescription = Label.EMPTY,
287      onCloseButtonClick = {},
288      alertButtonData = AlertButtonData.ButtonText(
289        data = ButtonTextData(
290          label = "Text button".toLabel(),
291          onClick = {},
292        ),
293      ),
294    )
295  
296    private fun provideAlertErrorFull() = AlertData.Error(
297      title = "Error alert".toLabel(),
298      bodyText = (
299        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
300          "incididunt ut labore."
301        ).toLabel(),
302      alertContentDescription = Label.EMPTY,
303      onCloseButtonClick = {},
304      alertButtonData = AlertButtonData.ButtonText(
305        data = ButtonTextData(
306          label = "Text button".toLabel(),
307          onClick = {},
308        ),
309      ),
310    )
311  
312    private fun provideAlertWarningOnlyDescription() = AlertData.Warning(
313      bodyText = (
314        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
315          "incididunt ut labore."
316        ).toLabel(),
317      alertContentDescription = Label.EMPTY,
318    )
319  
320    private fun provideAlertWarningTitleDescription() = AlertData.Warning(
321      title = "Warning alert".toLabel(),
322      bodyText = (
323        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
324          "incididunt ut labore."
325        ).toLabel(),
326      alertContentDescription = Label.EMPTY,
327    )
328  
329    private fun provideAlertWarningDescriptionTextBtn() = AlertData.Warning(
330      bodyText = (
331        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
332          "incididunt ut labore."
333        ).toLabel(),
334      alertContentDescription = Label.EMPTY,
335      alertButtonData = AlertButtonData.ButtonText(
336        data = ButtonTextData(
337          label = "Text button".toLabel(),
338          onClick = {},
339        ),
340      ),
341    )
342  
343    private fun provideAlertWarningDescriptionLink() = AlertData.Warning(
344      bodyText = (
345        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
346          "incididunt ut labore."
347        ).toLabel(),
348      alertContentDescription = Label.EMPTY,
349      alertButtonData = AlertButtonData.Link(
350        data = LinkData(
351          label = "Link".toLabel(),
352          url = "",
353          linkType = LinkData.LinkType.WEBSITE,
354          onClick = {},
355        ),
356      ),
357    )
358  
359    private fun provideAlertWarningTitleDescrTextBtn() = AlertData.Warning(
360      title = "Warning alert".toLabel(),
361      bodyText = (
362        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
363          "incididunt ut labore."
364        ).toLabel(),
365      alertContentDescription = Label.EMPTY,
366      alertButtonData = AlertButtonData.ButtonText(
367        data = ButtonTextData(
368          label = "Text button".toLabel(),
369          onClick = {},
370        ),
371      ),
372    )
373  
374    private fun provideAlertWarningDescrTextBtnCloseBtn() = AlertData.Warning(
375      bodyText = (
376        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
377          "incididunt ut labore."
378        ).toLabel(),
379      alertContentDescription = Label.EMPTY,
380      onCloseButtonClick = {},
381      alertButtonData = AlertButtonData.ButtonText(
382        data = ButtonTextData(
383          label = "Text button".toLabel(),
384          onClick = {},
385        ),
386      ),
387    )
388  
389    private fun provideAlertWarningFull() = AlertData.Warning(
390      title = "Warning alert".toLabel(),
391      bodyText = (
392        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
393          "incididunt ut labore."
394        ).toLabel(),
395      alertContentDescription = Label.EMPTY,
396      onCloseButtonClick = {},
397      alertButtonData = AlertButtonData.ButtonText(
398        data = ButtonTextData(
399          label = "Text button".toLabel(),
400          onClick = {},
401        ),
402      ),
403    )
404  
405    private fun provideAlertSuccessOnlyDescription() = AlertData.Success(
406      bodyText = (
407        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
408          "incididunt ut labore."
409        ).toLabel(),
410      alertContentDescription = Label.EMPTY,
411    )
412  
413    private fun provideAlertSuccessTitleDescription() = AlertData.Success(
414      title = "Success alert".toLabel(),
415      bodyText = (
416        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
417          "incididunt ut labore."
418        ).toLabel(),
419      alertContentDescription = Label.EMPTY,
420    )
421  
422    private fun provideAlertSuccessDescriptionTextBtn() = AlertData.Success(
423      bodyText = (
424        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
425          "incididunt ut labore."
426        ).toLabel(),
427      alertContentDescription = Label.EMPTY,
428      alertButtonData = AlertButtonData.ButtonText(
429        data = ButtonTextData(
430          label = "Text button".toLabel(),
431          onClick = {},
432        ),
433      ),
434    )
435  
436    private fun provideAlertSuccessDescriptionLink() = AlertData.Success(
437      bodyText = (
438        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
439          "incididunt ut labore."
440        ).toLabel(),
441      alertContentDescription = Label.EMPTY,
442      alertButtonData = AlertButtonData.Link(
443        data = LinkData(
444          label = "Link".toLabel(),
445          url = "",
446          linkType = LinkData.LinkType.WEBSITE,
447          onClick = {},
448        ),
449      ),
450    )
451  
452    private fun provideAlertSuccessTitleDescrTextBtn() = AlertData.Success(
453      title = "Success alert".toLabel(),
454      bodyText = (
455        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
456          "incididunt ut labore."
457        ).toLabel(),
458      alertContentDescription = Label.EMPTY,
459      alertButtonData = AlertButtonData.ButtonText(
460        data = ButtonTextData(
461          label = "Text button".toLabel(),
462          onClick = {},
463        ),
464      ),
465    )
466  
467    private fun provideAlertSuccessDescrTextBtnCloseBtn() = AlertData.Success(
468      bodyText = (
469        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
470          "incididunt ut labore."
471        ).toLabel(),
472      alertContentDescription = Label.EMPTY,
473      onCloseButtonClick = {},
474      alertButtonData = AlertButtonData.ButtonText(
475        data = ButtonTextData(
476          label = "Text button".toLabel(),
477          onClick = {},
478        ),
479      ),
480    )
481  
482    private fun provideAlertSuccessFull() = AlertData.Success(
483      title = "Success alert".toLabel(),
484      bodyText = (
485        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
486          "incididunt ut labore."
487        ).toLabel(),
488      alertContentDescription = Label.EMPTY,
489      onCloseButtonClick = {},
490      alertButtonData = AlertButtonData.ButtonText(
491        data = ButtonTextData(
492          label = "Text button".toLabel(),
493          onClick = {},
494        ),
495      ),
496    )
497  }
498  