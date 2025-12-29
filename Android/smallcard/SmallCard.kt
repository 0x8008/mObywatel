1    package pl.gov.coi.common.ui.ds.smallcard
2    
3    import androidx.compose.foundation.Canvas
4    import androidx.compose.foundation.clickable
5    import androidx.compose.foundation.indication
6    import androidx.compose.foundation.interaction.MutableInteractionSource
7    import androidx.compose.foundation.interaction.collectIsFocusedAsState
8    import androidx.compose.foundation.layout.Box
9    import androidx.compose.foundation.layout.Column
10   import androidx.compose.foundation.layout.Spacer
11   import androidx.compose.foundation.layout.height
12   import androidx.compose.foundation.layout.size
13   import androidx.compose.foundation.layout.width
14   import androidx.compose.material.ripple.rememberRipple
15   import androidx.compose.runtime.Composable
16   import androidx.compose.runtime.remember
17   import androidx.compose.ui.Alignment
18   import androidx.compose.ui.Modifier
19   import androidx.compose.ui.draw.clip
20   import androidx.compose.ui.graphics.Color
21   import androidx.compose.ui.graphics.Path
22   import androidx.compose.ui.graphics.drawscope.DrawStyle
23   import androidx.compose.ui.graphics.drawscope.Fill
24   import androidx.compose.ui.graphics.drawscope.Stroke
25   import androidx.compose.ui.semantics.Role
26   import androidx.compose.ui.semantics.semantics
27   import androidx.compose.ui.semantics.testTag
28   import androidx.compose.ui.text.style.TextAlign
29   import androidx.compose.ui.text.style.TextOverflow
30   import androidx.compose.ui.tooling.preview.Preview
31   import androidx.compose.ui.tooling.preview.PreviewParameter
32   import androidx.compose.ui.unit.Dp
33   import androidx.compose.ui.unit.dp
34   import pl.gov.coi.common.ui.ds.custom.icon.Icon
35   import pl.gov.coi.common.ui.ds.smallcard.provider.SmallCardPreviewParameterProvider
36   import pl.gov.coi.common.ui.text.CustomText
37   import pl.gov.coi.common.ui.theme.AppTheme
38   import pl.gov.coi.common.ui.utils.MultipleEventsCutter
39   import pl.gov.coi.common.ui.utils.dpToPx
40   import pl.gov.coi.common.ui.utils.get
41   
42   private val SMALL_CARD_WIDTH: Dp = 92.dp
43   private val SMALL_CARD_SQUIRCLE_SIZE: Dp = 80.dp
44   
45   @Composable
46   fun SmallCard(
47     data: SmallCardData,
48   ) {
49     val multipleEventsCutter = remember { MultipleEventsCutter.get() }
50     val interactionSource = remember { MutableInteractionSource() }
51     val isFocused = interactionSource.collectIsFocusedAsState()
52   
53     Column(
54       modifier = Modifier
55         .width(width = SMALL_CARD_WIDTH)
56         .semantics {
57           testTag = "card_${data.title.tag}_indexTag_${data.indexTag ?: "noTag"}"
58         }
59         .clickable(
60           interactionSource = interactionSource,
61           indication = null,
62           role = Role.Button,
63           onClick = { multipleEventsCutter.processEvent { data.onClick() } },
64         ),
65       horizontalAlignment = Alignment.CenterHorizontally,
66     ) {
67       Box(
68         contentAlignment = Alignment.Center,
69       ) {
70         SmallCardSquircle(
71           modifier = Modifier
72             .clip(shape = AppTheme.shapes.radius200)
73             .indication(
74               interactionSource = interactionSource,
75               indication = rememberRipple(color = AppTheme.colors.neutral500.copy(alpha = 0.1f)),
76             ),
77           color = if (isFocused.value) AppTheme.colors.neutral500.copy(alpha = 0.1f) else Color.White,
78         )
79         SmallCardSquircle(
80           color = if (isFocused.value) AppTheme.colors.white else Color.Transparent,
81           style = Stroke(width = AppTheme.dimensions.spacing50.dpToPx()),
82         )
83         SmallCardSquircle(
84           color = if (isFocused.value) AppTheme.colors.neutral500 else Color.Transparent,
85           style = Stroke(width = AppTheme.dimensions.spacing25.dpToPx()),
86         )
87         Icon(data = data.iconData)
88       }
89       Spacer(
90         modifier = Modifier.height(AppTheme.dimensions.spacing100),
91       )
92       CustomText(
93         label = data.title,
94         style = AppTheme.typography.bodySmallRegular,
95         color = AppTheme.colors.neutral200,
96         textAlign = TextAlign.Center,
97         overflow = TextOverflow.Ellipsis,
98         maxLines = 2,
99       )
100    }
101  }
102  
103  @Composable
104  internal fun SmallCardSquircle(
105    modifier: Modifier = Modifier,
106    style: DrawStyle = Fill,
107    color: Color = AppTheme.colors.white,
108  ) {
109    Canvas(
110      modifier = modifier
111        .size(size = SMALL_CARD_SQUIRCLE_SIZE),
112    ) {
113      val width = size.width
114      val height = size.height
115      val path = Path().apply {
116        moveTo(width.times(0.4f), 0f)
117        lineTo(width.times(0.6f), 0f)
118        cubicTo(
119          x1 = width.times(0.98f),
120          y1 = 0f,
121          x2 = width.times(1f),
122          y2 = height.times(0.02f),
123          x3 = width.times(1f),
124          y3 = height.times(0.4f),
125        )
126        lineTo(
127          x = width.times(1f),
128          y = height.times(0.6f),
129        )
130        cubicTo(
131          x1 = width.times(1f),
132          y1 = height.times(0.98f),
133          x2 = width.times(0.98f),
134          y2 = height.times(1f),
135          x3 = width.times(0.6f),
136          y3 = height.times(1f),
137        )
138        lineTo(
139          x = width.times(0.4f),
140          y = height.times(1f),
141        )
142        cubicTo(
143          x1 = width.times(0.02f),
144          y1 = height.times(1f),
145          x2 = 0f,
146          y2 = height.times(0.98f),
147          x3 = 0f,
148          y3 = height.times(0.6f),
149        )
150        lineTo(
151          x = 0f,
152          y = height.times(0.4f),
153        )
154        cubicTo(
155          x1 = 0f,
156          y1 = height.times(0.02f),
157          x2 = width.times(0.02f),
158          y2 = 0f,
159          x3 = width.times(0.4f),
160          y3 = 0f,
161        )
162        close()
163      }
164      drawPath(
165        path = path,
166        color = color,
167        style = style,
168      )
169    }
170  }
171  
172  @Preview
173  @Composable
174  fun SmallCardPreview(
175    @PreviewParameter(SmallCardPreviewParameterProvider::class) smallCardData: SmallCardData,
176  ) {
177    SmallCard(
178      data = smallCardData,
179    )
180  }
181  