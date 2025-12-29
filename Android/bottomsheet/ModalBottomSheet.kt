1    package pl.gov.coi.common.ui.ds.bottomsheet
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.layout.Box
5    import androidx.compose.foundation.layout.Column
6    import androidx.compose.foundation.layout.Spacer
7    import androidx.compose.foundation.layout.fillMaxWidth
8    import androidx.compose.foundation.layout.height
9    import androidx.compose.foundation.layout.heightIn
10   import androidx.compose.foundation.layout.padding
11   import androidx.compose.foundation.layout.size
12   import androidx.compose.foundation.layout.width
13   import androidx.compose.foundation.shape.RoundedCornerShape
14   import androidx.compose.material.Divider
15   import androidx.compose.material.ExperimentalMaterialApi
16   import androidx.compose.material.IconButton
17   import androidx.compose.material.ModalBottomSheetLayout
18   import androidx.compose.material.ModalBottomSheetValue
19   import androidx.compose.material.rememberModalBottomSheetState
20   import androidx.compose.runtime.Composable
21   import androidx.compose.runtime.LaunchedEffect
22   import androidx.compose.runtime.remember
23   import androidx.compose.ui.Alignment
24   import androidx.compose.ui.Modifier
25   import androidx.compose.ui.draw.clip
26   import androidx.compose.ui.focus.FocusRequester
27   import androidx.compose.ui.focus.focusRequester
28   import androidx.compose.ui.platform.LocalConfiguration
29   import androidx.compose.ui.text.style.TextAlign
30   import androidx.compose.ui.tooling.preview.Preview
31   import androidx.compose.ui.unit.Dp
32   import androidx.compose.ui.unit.dp
33   import pl.gov.coi.common.domain.label.CommonUILabelProvider
34   import pl.gov.coi.common.domain.label.toLabel
35   import pl.gov.coi.common.ui.R
36   import pl.gov.coi.common.ui.icon.CustomIcon
37   import pl.gov.coi.common.ui.icon.IconSize
38   import pl.gov.coi.common.ui.text.CustomText
39   import pl.gov.coi.common.ui.theme.AppTheme
40   import pl.gov.coi.common.ui.utils.NoRippleInteractionSource
41   
42   private const val MAX_HEIGHT_PERCENT = 0.9f
43   
44   @OptIn(ExperimentalMaterialApi::class)
45   @Composable
46   fun ModalBottomSheet(
47     data: ModalBottomSheetData,
48     horizontalPadding: Dp = AppTheme.dimensions.spacing200,
49     bottomSheetContent: @Composable () -> Unit,
50     innerContent: @Composable () -> Unit,
51   ) = with(data) {
52     val configuration = LocalConfiguration.current
53     val screenHeight = configuration.screenHeightDp.dp
54     val maxHeight = screenHeight * MAX_HEIGHT_PERCENT
55   
56     val sheetState = rememberModalBottomSheetState(
57       initialValue = when (sheetState.value) {
58         ModalSheetValue.EXPANDED -> ModalBottomSheetValue.Expanded
59         ModalSheetValue.HIDDEN -> ModalBottomSheetValue.Hidden
60         ModalSheetValue.HALF_EXPANDED -> ModalBottomSheetValue.HalfExpanded
61       },
62       confirmValueChange = { value ->
63         when (value) {
64           ModalBottomSheetValue.Hidden -> sheetState.onValueChange(ModalSheetValue.HIDDEN)
65           ModalBottomSheetValue.Expanded -> sheetState.onValueChange(ModalSheetValue.EXPANDED)
66           ModalBottomSheetValue.HalfExpanded -> sheetState.onValueChange(ModalSheetValue.HALF_EXPANDED)
67         }
68         true
69       },
70       skipHalfExpanded = sheetState.skipHalfExpanded,
71     )
72   
73     val focusRequester = remember { FocusRequester() }
74     LaunchedEffect(sheetState.isVisible) {
75       if (sheetState.isVisible) {
76         focusRequester.requestFocus()
77       }
78     }
79   
80     ModalBottomSheetLayout(
81       modifier = Modifier.focusRequester(focusRequester),
82       sheetState = sheetState,
83       sheetElevation = AppTheme.elevations.level0,
84       sheetShape = RoundedCornerShape(
85         topStart = AppTheme.dimensions.spacing200,
86         topEnd = AppTheme.dimensions.spacing200,
87       ),
88       sheetContent = {
89         Column(
90           modifier = Modifier
91             .fillMaxWidth()
92             .heightIn(max = maxHeight)
93             .background(data.colorProvider())
94             .clip(
95               RoundedCornerShape(
96                 topStart = AppTheme.dimensions.spacing50,
97                 topEnd = AppTheme.dimensions.spacing50,
98               ),
99             ),
100        ) {
101          Column(
102            modifier = Modifier
103              .padding(horizontal = AppTheme.dimensions.spacing200),
104            horizontalAlignment = Alignment.CenterHorizontally,
105          ) {
106            Divider(
107              modifier = Modifier
108                .padding(
109                  top = AppTheme.dimensions.spacing100,
110                  bottom = AppTheme.dimensions.spacing100,
111                )
112                .clip(RoundedCornerShape(AppTheme.dimensions.spacing300))
113                .background(AppTheme.colors.neutral30)
114                .width(AppTheme.dimensions.spacing400)
115                .height(AppTheme.dimensions.spacing50),
116  
117            )
118            Box(modifier = Modifier.fillMaxWidth()) {
119              title?.let { title ->
120                CustomText(
121                  modifier = Modifier
122                    .fillMaxWidth()
123                    .padding(
124                      start = AppTheme.dimensions.spacing400,
125                      end = AppTheme.dimensions.spacing400,
126                    ),
127                  textAlign = TextAlign.Center,
128                  label = title,
129                  color = AppTheme.colors.neutral500,
130                  style = AppTheme.typography.subtitleMedium,
131                )
132              }
133              onCloseClick?.let { onCloseClick ->
134                IconButton(
135                  modifier = Modifier
136                    .align(Alignment.TopEnd)
137                    .size(IconSize.Medium.dimension),
138                  onClick = onCloseClick,
139                  interactionSource = NoRippleInteractionSource(),
140                ) {
141                  CustomIcon(
142                    iconResId = R.drawable.ab009_x_mark,
143                    iconColor = AppTheme.colors.neutral200,
144                    contentDescription = CommonUILabelProvider.closeLabel().text,
145                  )
146                }
147              }
148            }
149            if (title != null || onCloseClick != null) {
150              Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing100))
151            }
152          }
153          Box(
154            modifier = Modifier
155              .padding(horizontal = horizontalPadding),
156          ) {
157            bottomSheetContent()
158          }
159        }
160      },
161      content = innerContent,
162    )
163  }
164  
165  @Preview
166  @Composable
167  fun ModalBottomSheetPreview() {
168    val data = ModalBottomSheetData(
169      title = "Bottom Sheet (1.1.0)".toLabel(tag = "modalBottomSheetPreviewTitle"),
170      sheetState = ModalSheetState(
171        value = ModalSheetValue.EXPANDED,
172        skipHalfExpanded = true,
173        onValueChange = {},
174      ),
175      onCloseClick = {},
176    )
177    ModalBottomSheet(
178      data = data,
179      bottomSheetContent = {
180        Box(
181          modifier = Modifier.height(height = AppTheme.dimensions.spacing600),
182        )
183      },
184      innerContent = {},
185    )
186  }
187  