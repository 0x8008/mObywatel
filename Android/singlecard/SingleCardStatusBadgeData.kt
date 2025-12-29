1    package pl.gov.coi.common.ui.ds.singlecard
2    
3    import androidx.annotation.DrawableRes
4    import androidx.compose.runtime.Composable
5    import androidx.compose.ui.graphics.Color
6    import pl.gov.coi.common.domain.label.Label
7    import pl.gov.coi.common.ui.R
8    import pl.gov.coi.common.ui.ds.custom.icon.IconData
9    import pl.gov.coi.common.ui.ds.custom.icon.IconSize
10   import pl.gov.coi.common.ui.theme.AppTheme
11   
12   /* 
13    TODO REMOVE MOB-49304 
14    */
15   sealed class SingleCardStatusBadgeData(
16     internal open val testTag: String?,
17     internal open val text: Label,
18   ) {
19     sealed class Default(
20       testTag: String?,
21       text: Label,
22       internal open val dotColorProvider: @Composable () -> Color,
23     ) : SingleCardStatusBadgeData(
24       testTag = testTag,
25       text = text,
26     ) {
27       data class Green(
28         override val testTag: String? = null,
29         override val text: Label,
30       ) : Default(
31         testTag = testTag,
32         text = text,
33         dotColorProvider = { AppTheme.colors.supportGreen100 },
34       )
35   
36       data class Yellow(
37         override val testTag: String? = null,
38         override val text: Label,
39       ) : Default(
40         testTag = testTag,
41         text = text,
42         dotColorProvider = { AppTheme.colors.supportOrange100 },
43       )
44   
45       data class Red(
46         override val testTag: String? = null,
47         override val text: Label,
48       ) : Default(
49         testTag = testTag,
50         text = text,
51         dotColorProvider = { AppTheme.colors.supportRed100 },
52       )
53   
54       data class Blue(
55         override val testTag: String? = null,
56         override val text: Label,
57       ) : Default(
58         testTag = testTag,
59         text = text,
60         dotColorProvider = { AppTheme.colors.supportBlue100 },
61       )
62     }
63   
64     sealed class WithNoIcon(
65       testTag: String?,
66       text: Label,
67     ) : SingleCardStatusBadgeData(
68       testTag = testTag,
69       text = text,
70     ) {
71       data class Normal(
72         override val testTag: String? = null,
73         override val text: Label,
74       ) : WithNoIcon(
75         testTag = testTag,
76         text = text,
77       )
78   
79       data class Error(
80         override val testTag: String? = null,
81         override val text: Label,
82       ) : WithNoIcon(
83         testTag = testTag,
84         text = text,
85       )
86     }
87   
88     sealed class WithIcon(
89       testTag: String?,
90       text: Label,
91       @DrawableRes iconResId: Int,
92       iconColorProvider: @Composable () -> Color,
93       iconContentDescription: Label,
94     ) : SingleCardStatusBadgeData(
95       testTag = testTag,
96       text = text,
97     ) {
98   
99       internal val iconData: IconData = IconData.Standard(
100        testTag = testTag?.let { tag -> tag + "Icon" },
101        iconResId = iconResId,
102        iconSize = IconSize.SIZE16,
103        iconColorProvider = iconColorProvider,
104        contentDescription = iconContentDescription,
105      )
106  
107      class Success(
108        testTag: String? = null,
109        text: Label,
110        iconContentDescription: Label,
111      ) : WithIcon(
112        testTag = testTag,
113        text = text,
114        iconResId = R.drawable.c4_success,
115        iconColorProvider = { AppTheme.colors.supportGreen100 },
116        iconContentDescription = iconContentDescription,
117      )
118  
119      class Error(
120        testTag: String? = null,
121        text: Label,
122        iconContentDescription: Label,
123      ) : WithIcon(
124        testTag = testTag,
125        text = text,
126        iconResId = R.drawable.c3_error_mark,
127        iconColorProvider = { AppTheme.colors.supportRed100 },
128        iconContentDescription = iconContentDescription,
129      )
130  
131      class Warning(
132        testTag: String? = null,
133        text: Label,
134        iconContentDescription: Label,
135      ) : WithIcon(
136        testTag = testTag,
137        text = text,
138        iconResId = R.drawable.c2_warning_mark,
139        iconColorProvider = { AppTheme.colors.supportOrange100 },
140        iconContentDescription = iconContentDescription,
141      )
142  
143      class Info(
144        testTag: String? = null,
145        text: Label,
146        iconContentDescription: Label,
147      ) : WithIcon(
148        testTag = testTag,
149        text = text,
150        iconResId = R.drawable.c1_info,
151        iconColorProvider = { AppTheme.colors.supportBlue100 },
152        iconContentDescription = iconContentDescription,
153      )
154    }
155  
156    sealed class WithIconAndBorder(
157      testTag: String?,
158      text: Label,
159      @DrawableRes iconResId: Int,
160      iconColorProvider: @Composable () -> Color,
161      iconContentDescription: Label,
162    ) : SingleCardStatusBadgeData(
163      testTag = testTag,
164      text = text,
165    ) {
166  
167      internal val iconData: IconData = IconData.Standard(
168        testTag = testTag?.let { tag -> tag + "Icon" },
169        iconResId = iconResId,
170        iconSize = IconSize.SIZE14,
171        iconColorProvider = iconColorProvider,
172        contentDescription = iconContentDescription,
173      )
174  
175      class Active(
176        testTag: String? = null,
177        text: Label,
178        iconContentDescription: Label,
179      ) : WithIconAndBorder(
180        testTag = testTag,
181        text = text,
182        iconResId = R.drawable.b009_check_mark,
183        iconColorProvider = { AppTheme.colors.supportGreen100 },
184        iconContentDescription = iconContentDescription,
185      )
186  
187      class Failure(
188        testTag: String? = null,
189        text: Label,
190        iconContentDescription: Label,
191      ) : WithIconAndBorder(
192        testTag = testTag,
193        text = text,
194        iconResId = R.drawable.b010_x_mark,
195        iconColorProvider = { AppTheme.colors.supportRed100 },
196        iconContentDescription = iconContentDescription,
197      )
198  
199      class ActionNeeded(
200        testTag: String? = null,
201        text: Label,
202        iconContentDescription: Label,
203      ) : WithIconAndBorder(
204        testTag = testTag,
205        text = text,
206        iconResId = R.drawable.b011_exclamation_mark,
207        iconColorProvider = { AppTheme.colors.supportOrange100 },
208        iconContentDescription = iconContentDescription,
209      )
210  
211      class Canceled(
212        testTag: String? = null,
213        text: Label,
214        iconContentDescription: Label,
215      ) : WithIconAndBorder(
216        testTag = testTag,
217        text = text,
218        iconResId = R.drawable.b010_x_mark,
219        iconColorProvider = { AppTheme.colors.neutral100 },
220        iconContentDescription = iconContentDescription,
221      )
222    }
223  
224    sealed class WithDotAndBorder(
225      testTag: String?,
226      text: Label,
227      private val variant: WithDotAndBorderVariant,
228      internal val dotColorProvider: @Composable () -> Color,
229    ) : SingleCardStatusBadgeData(
230      testTag = testTag,
231      text = text,
232    ) {
233      internal val strokeColorProvider: @Composable () -> Color = {
234        when (variant) {
235          WithDotAndBorderVariant.Default -> AppTheme.colors.neutral80
236          is WithDotAndBorderVariant.Colored -> dotColorProvider()
237        }
238      }
239      internal val backgroundColorProvider: @Composable () -> Color = {
240        when (variant) {
241          WithDotAndBorderVariant.Default -> AppTheme.colors.white
242          is WithDotAndBorderVariant.Colored -> variant.backgroundColorProvider()
243        }
244      }
245  
246      class Green(
247        testTag: String? = null,
248        text: Label,
249        isColored: Boolean,
250      ) : WithDotAndBorder(
251        testTag = testTag,
252        text = text,
253        variant = if (isColored) {
254          val lightGreen20 = Color(0xFFEEFAE1)
255          WithDotAndBorderVariant.Colored { lightGreen20 }
256        } else {
257          WithDotAndBorderVariant.Default
258        },
259        dotColorProvider = { AppTheme.colors.supportGreen100 },
260      )
261  
262      class Red(
263        testTag: String? = null,
264        text: Label,
265        isColored: Boolean,
266      ) : WithDotAndBorder(
267        testTag = testTag,
268        text = text,
269        variant = if (isColored) {
270          WithDotAndBorderVariant.Colored { AppTheme.colors.supportRed20 }
271        } else {
272          WithDotAndBorderVariant.Default
273        },
274        dotColorProvider = { AppTheme.colors.supportRed100 },
275      )
276  
277      class Yellow(
278        testTag: String? = null,
279        text: Label,
280        isColored: Boolean,
281      ) : WithDotAndBorder(
282        testTag = testTag,
283        text = text,
284        variant = if (isColored) {
285          WithDotAndBorderVariant.Colored { AppTheme.colors.supportOrange20 }
286        } else {
287          WithDotAndBorderVariant.Default
288        },
289        dotColorProvider = { AppTheme.colors.supportOrange100 },
290      )
291  
292      class Blue(
293        testTag: String? = null,
294        text: Label,
295        isColored: Boolean,
296      ) : WithDotAndBorder(
297        testTag = testTag,
298        text = text,
299        variant = if (isColored) {
300          WithDotAndBorderVariant.Colored { AppTheme.colors.supportBlue20 }
301        } else {
302          WithDotAndBorderVariant.Default
303        },
304        dotColorProvider = { AppTheme.colors.supportBlue100 },
305      )
306    }
307  
308    sealed class Elevated(
309      testTag: String?,
310      text: Label,
311      internal val dotColorProvider: @Composable () -> Color,
312    ) : SingleCardStatusBadgeData(
313      testTag = testTag,
314      text = text,
315    ) {
316      class Green(
317        testTag: String? = null,
318        text: Label,
319      ) : Elevated(
320        testTag = testTag,
321        text = text,
322        dotColorProvider = { AppTheme.colors.supportGreen100 },
323      )
324  
325      class Yellow(
326        testTag: String? = null,
327        text: Label,
328      ) : Elevated(
329        testTag = testTag,
330        text = text,
331        dotColorProvider = { AppTheme.colors.supportOrange100 },
332      )
333  
334      class Red(
335        testTag: String? = null,
336        text: Label,
337      ) : Elevated(
338        testTag = testTag,
339        text = text,
340        dotColorProvider = { AppTheme.colors.supportRed100 },
341      )
342  
343      class Blue(
344        testTag: String? = null,
345        text: Label,
346      ) : Elevated(
347        testTag = testTag,
348        text = text,
349        dotColorProvider = { AppTheme.colors.supportBlue100 },
350      )
351    }
352  }
353  
354  internal sealed interface WithDotAndBorderVariant {
355    object Default : WithDotAndBorderVariant
356    data class Colored(val backgroundColorProvider: @Composable () -> Color) : WithDotAndBorderVariant
357  }
358  