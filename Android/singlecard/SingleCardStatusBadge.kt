1    package pl.gov.coi.common.ui.ds.singlecard
2    
3    import androidx.compose.foundation.BorderStroke
4    import androidx.compose.foundation.background
5    import androidx.compose.foundation.layout.Arrangement
6    import androidx.compose.foundation.layout.Box
7    import androidx.compose.foundation.layout.Row
8    import androidx.compose.foundation.layout.Spacer
9    import androidx.compose.foundation.layout.fillMaxSize
10   import androidx.compose.foundation.layout.height
11   import androidx.compose.foundation.layout.padding
12   import androidx.compose.foundation.layout.size
13   import androidx.compose.foundation.layout.width
14   import androidx.compose.foundation.layout.wrapContentHeight
15   import androidx.compose.foundation.layout.wrapContentWidth
16   import androidx.compose.foundation.shape.CircleShape
17   import androidx.compose.foundation.shape.RoundedCornerShape
18   import androidx.compose.material.ButtonDefaults
19   import androidx.compose.material.Surface
20   import androidx.compose.runtime.Composable
21   import androidx.compose.ui.Alignment
22   import androidx.compose.ui.Modifier
23   import androidx.compose.ui.tooling.preview.Preview
24   import androidx.compose.ui.tooling.preview.PreviewParameter
25   import androidx.compose.ui.unit.Dp
26   import androidx.compose.ui.unit.dp
27   import pl.gov.coi.common.ui.ds.custom.icon.Icon
28   import pl.gov.coi.common.ui.ds.singlecard.provider.SingleCardStatusBadgePreviewProvider
29   import pl.gov.coi.common.ui.text.CustomText
30   import pl.gov.coi.common.ui.theme.AppTheme
31   
32   private val STATUS_BADGE_SIZE: Dp = 10.dp
33   /* 
34    TODO REMOVE MOB-49304 
35    */
36   @Composable
37   fun SingleCardStatusBadge(data: SingleCardStatusBadgeData) {
38     when (data) {
39       is SingleCardStatusBadgeData.Default -> StatusBadge(data = data)
40       is SingleCardStatusBadgeData.WithNoIcon -> StatusBadge(data = data)
41       is SingleCardStatusBadgeData.WithIcon -> StatusBadge(data = data)
42       is SingleCardStatusBadgeData.WithIconAndBorder -> StatusBadge(data = data)
43       is SingleCardStatusBadgeData.WithDotAndBorder -> StatusBadge(data = data)
44       is SingleCardStatusBadgeData.Elevated -> StatusBadge(data = data)
45     }
46   }
47   
48   @Composable
49   internal fun StatusBadge(data: SingleCardStatusBadgeData.Default) {
50     Row(
51       horizontalArrangement = Arrangement.Center,
52       verticalAlignment = Alignment.CenterVertically,
53     ) {
54       Box(
55         modifier = Modifier
56           .size(size = STATUS_BADGE_SIZE)
57           .background(
58             color = data.dotColorProvider(),
59             shape = CircleShape,
60           ),
61       )
62       Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
63       CustomText(
64         label = data.text,
65         maxLines = 1,
66         color = AppTheme.colors.neutral500,
67         style = AppTheme.typography.bodyLargeMedium,
68       )
69     }
70   }
71   
72   @Composable
73   internal fun StatusBadge(data: SingleCardStatusBadgeData.WithNoIcon) {
74     CustomText(
75       modifier = Modifier
76         .wrapContentHeight()
77         .wrapContentWidth(),
78       label = data.text,
79       maxLines = 1,
80       color = when (data) {
81         is SingleCardStatusBadgeData.WithNoIcon.Error -> AppTheme.colors.supportRed100
82         is SingleCardStatusBadgeData.WithNoIcon.Normal -> AppTheme.colors.neutral200
83       },
84       style = when (data) {
85         is SingleCardStatusBadgeData.WithNoIcon.Error -> AppTheme.typography.bodyMediumMedium
86         is SingleCardStatusBadgeData.WithNoIcon.Normal -> AppTheme.typography.bodyMediumRegular
87       },
88     )
89   }
90   
91   @Composable
92   private fun StatusBadge(data: SingleCardStatusBadgeData.WithIcon) {
93     Row {
94       Icon(data = data.iconData)
95       Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing50))
96       CustomText(
97         label = data.text,
98         maxLines = 1,
99         color = AppTheme.colors.neutral200,
100        style = AppTheme.typography.bodySmallRegular,
101      )
102    }
103  }
104  
105  @Composable
106  private fun StatusBadge(data: SingleCardStatusBadgeData.WithIconAndBorder) {
107    Surface(
108      modifier = Modifier
109        .height(height = AppTheme.dimensions.spacing400),
110      shape = RoundedCornerShape(percent = 50),
111      color = AppTheme.colors.white,
112      border = BorderStroke(
113        width = ButtonDefaults.outlinedBorder.width,
114        color = AppTheme.colors.neutral80,
115      ),
116      elevation = AppTheme.elevations.level0,
117    ) {
118      Row(
119        horizontalArrangement = Arrangement.Center,
120        verticalAlignment = Alignment.CenterVertically,
121      ) {
122        Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
123        Icon(data = data.iconData)
124        Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing50))
125        CustomText(
126          label = data.text,
127          maxLines = 1,
128          color = AppTheme.colors.neutral200,
129          style = AppTheme.typography.bodySmallRegular,
130        )
131        Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
132      }
133    }
134  }
135  
136  @Composable
137  internal fun StatusBadge(data: SingleCardStatusBadgeData.WithDotAndBorder) {
138    Surface(
139      modifier = Modifier
140        .height(height = AppTheme.dimensions.spacing400),
141      shape = RoundedCornerShape(percent = 50),
142      color = data.backgroundColorProvider(),
143      border = BorderStroke(
144        width = ButtonDefaults.outlinedBorder.width,
145        color = data.strokeColorProvider(),
146      ),
147      elevation = AppTheme.elevations.level0,
148    ) {
149      Row(
150        horizontalArrangement = Arrangement.Center,
151        verticalAlignment = Alignment.CenterVertically,
152      ) {
153        Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
154        Box(
155          modifier = Modifier
156            .size(size = STATUS_BADGE_SIZE)
157            .background(
158              color = data.dotColorProvider(),
159              shape = CircleShape,
160            ),
161        )
162        Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing50))
163        CustomText(
164          label = data.text,
165          maxLines = 1,
166          color = AppTheme.colors.neutral200,
167          style = AppTheme.typography.bodySmallRegular,
168        )
169        Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
170      }
171    }
172  }
173  
174  @Composable
175  internal fun StatusBadge(data: SingleCardStatusBadgeData.Elevated) {
176    Surface(
177      modifier = Modifier
178        .height(height = AppTheme.dimensions.spacing300),
179      shape = RoundedCornerShape(percent = 50),
180      color = AppTheme.colors.white,
181      border = BorderStroke(
182        width = ButtonDefaults.outlinedBorder.width,
183        color = AppTheme.colors.neutral80,
184      ),
185      elevation = AppTheme.elevations.level0,
186    ) {
187      Row(
188        horizontalArrangement = Arrangement.Center,
189        verticalAlignment = Alignment.CenterVertically,
190      ) {
191        Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
192        Box(
193          modifier = Modifier
194            .size(size = AppTheme.dimensions.spacing100)
195            .background(
196              color = data.dotColorProvider(),
197              shape = CircleShape,
198            ),
199        )
200        Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing50))
201        CustomText(
202          label = data.text,
203          maxLines = 1,
204          color = AppTheme.colors.neutral200,
205          style = AppTheme.typography.bodySmallRegular,
206        )
207        Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
208      }
209    }
210  }
211  
212  @Preview
213  @Composable
214  fun StatusBadgePreview(@PreviewParameter(SingleCardStatusBadgePreviewProvider::class) data: SingleCardStatusBadgeData) {
215  
216    Box(
217      modifier = Modifier
218        .fillMaxSize()
219        .padding(all = AppTheme.dimensions.spacing200)
220        .background(color = AppTheme.colors.white),
221      contentAlignment = Alignment.Center,
222    ) {
223      SingleCardStatusBadge(data = data)
224    }
225  }
226  