1    package pl.gov.coi.common.ui.ds.chatbubble
2    
3    import androidx.compose.animation.core.LinearEasing
4    import androidx.compose.animation.core.animateFloat
5    import androidx.compose.animation.core.infiniteRepeatable
6    import androidx.compose.animation.core.keyframes
7    import androidx.compose.animation.core.rememberInfiniteTransition
8    import androidx.compose.foundation.background
9    import androidx.compose.foundation.layout.Arrangement
10   import androidx.compose.foundation.layout.Row
11   import androidx.compose.foundation.layout.Spacer
12   import androidx.compose.foundation.layout.offset
13   import androidx.compose.foundation.layout.padding
14   import androidx.compose.foundation.layout.size
15   import androidx.compose.foundation.layout.width
16   import androidx.compose.foundation.shape.CircleShape
17   import androidx.compose.runtime.Composable
18   import androidx.compose.runtime.getValue
19   import androidx.compose.ui.Alignment
20   import androidx.compose.ui.Modifier
21   import androidx.compose.ui.graphics.Color
22   import androidx.compose.ui.unit.dp
23   import pl.gov.coi.common.ui.theme.AppTheme
24   
25   const val DELAY_UNIT = 300
26   
27   @Composable
28   internal fun DotsTyping() {
29     val maxOffset = 10f
30   
31     @Composable
32     fun Dot(
33       offset: Float,
34       color: Color,
35     ) = Spacer(
36       modifier = Modifier
37         .size(AppTheme.dimensions.spacing100)
38         .offset(y = -offset.dp)
39         .background(
40           color = color,
41           shape = CircleShape,
42         ),
43     )
44   
45     val infiniteTransition = rememberInfiniteTransition()
46   
47     @Composable
48     fun animateOffsetWithDelay(delay: Int) = infiniteTransition.animateFloat(
49       initialValue = 0f,
50       targetValue = 0f,
51       animationSpec = infiniteRepeatable(
52         animation = keyframes {
53           durationMillis = DELAY_UNIT * 4
54           0f at delay with LinearEasing
55           maxOffset at delay + DELAY_UNIT with LinearEasing
56           0f at delay + DELAY_UNIT * 2
57         },
58       ),
59     )
60   
61     val firstDotAnimationOffset by animateOffsetWithDelay(0)
62     val secondDotAnimationOffset by animateOffsetWithDelay(DELAY_UNIT)
63     val thirdDotAnimationOffset by animateOffsetWithDelay(DELAY_UNIT * 2)
64   
65     Row(
66       verticalAlignment = Alignment.CenterVertically,
67       horizontalArrangement = Arrangement.Center,
68       modifier = Modifier.padding(top = maxOffset.dp),
69     ) {
70       Dot(offset = firstDotAnimationOffset, color = AppTheme.colors.neutral200.copy(alpha = 0.25F))
71       Spacer(Modifier.width(AppTheme.dimensions.spacing50))
72       Dot(offset = secondDotAnimationOffset, color = AppTheme.colors.neutral200.copy(alpha = 0.5F))
73       Spacer(Modifier.width(AppTheme.dimensions.spacing50))
74       Dot(offset = thirdDotAnimationOffset, color = AppTheme.colors.neutral200)
75     }
76   }
77   