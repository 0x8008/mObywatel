1    package pl.gov.coi.common.ui.ds.pageindicator
2    
3    import androidx.compose.foundation.ExperimentalFoundationApi
4    import androidx.compose.foundation.background
5    import androidx.compose.foundation.border
6    import androidx.compose.foundation.layout.Arrangement
7    import androidx.compose.foundation.layout.Box
8    import androidx.compose.foundation.layout.Row
9    import androidx.compose.foundation.layout.Spacer
10   import androidx.compose.foundation.layout.fillMaxWidth
11   import androidx.compose.foundation.layout.size
12   import androidx.compose.foundation.layout.width
13   import androidx.compose.foundation.pager.PagerState
14   import androidx.compose.foundation.pager.rememberPagerState
15   import androidx.compose.foundation.shape.CircleShape
16   import androidx.compose.runtime.Composable
17   import androidx.compose.ui.Alignment
18   import androidx.compose.ui.Modifier
19   import androidx.compose.ui.draw.clip
20   import androidx.compose.ui.tooling.preview.Preview
21   import androidx.compose.ui.unit.dp
22   import pl.gov.coi.common.ui.theme.AppTheme
23   
24   private val DOT_SIZE = 8.dp
25   
26   @OptIn(ExperimentalFoundationApi::class)
27   @Composable
28   fun PageIndicator(pagerState: PagerState) {
29     Row(
30       modifier = Modifier.fillMaxWidth(),
31       horizontalArrangement = Arrangement.Center,
32       verticalAlignment = Alignment.Bottom,
33     ) {
34       repeat(times = pagerState.pageCount) { iteration ->
35         val modifier = if (pagerState.currentPage == iteration) {
36           Modifier.background(color = AppTheme.colors.primary900)
37         } else {
38           Modifier.border(
39             width = AppTheme.dimensions.strokeWidth,
40             color = AppTheme.colors.neutral80,
41             shape = CircleShape,
42           )
43         }
44         Box(
45           modifier = Modifier
46             .clip(shape = CircleShape)
47             .size(size = DOT_SIZE)
48             .then(other = modifier),
49         )
50         if (iteration < pagerState.pageCount - 1) {
51           Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing150))
52         }
53       }
54     }
55   }
56   
57   @OptIn(ExperimentalFoundationApi::class)
58   @Preview(showBackground = true)
59   @Composable
60   fun PageIndicatorPreview() {
61     val pagerState = rememberPagerState(
62       pageCount = { 4 },
63     )
64     PageIndicator(pagerState = pagerState)
65   }
66   