1    package pl.gov.coi.common.ui.ds.custom.icon
2    
3    import androidx.annotation.DrawableRes
4    import androidx.compose.runtime.Composable
5    import androidx.compose.ui.graphics.Color
6    import androidx.compose.ui.graphics.Shape
7    import androidx.compose.ui.unit.Dp
8    import androidx.compose.ui.unit.dp
9    import pl.gov.coi.common.domain.label.Label
10   
11   sealed class IconData(
12     internal val testTag: String?,
13     @DrawableRes internal val iconResId: Int,
14     internal val iconSize: IconSize,
15     internal val iconColorProvider: @Composable () -> Color,
16     internal val contentDescription: Label?,
17     internal val iconState: IconState,
18   ) {
19     class Standard(
20       testTag: String? = null,
21       iconResId: Int,
22       iconSize: IconSize,
23       iconColorProvider: @Composable () -> Color,
24       contentDescription: Label?,
25       iconState: IconState = IconState.ENABLED,
26     ) : IconData(
27       testTag = testTag,
28       iconResId = iconResId,
29       iconSize = iconSize,
30       iconColorProvider = iconColorProvider,
31       contentDescription = contentDescription,
32       iconState = iconState,
33     )
34   
35     class Background(
36       testTag: String? = null,
37       iconResId: Int,
38       iconSize: IconSize,
39       iconColorProvider: @Composable () -> Color,
40       internal val backgroundSize: IconSize,
41       internal val backgroundColorProvider: @Composable () -> Color,
42       internal val backgroundShape: BackgroundShape,
43       contentDescription: Label?,
44       iconState: IconState = IconState.ENABLED,
45     ) : IconData(
46       testTag = testTag,
47       iconResId = iconResId,
48       iconSize = iconSize,
49       iconColorProvider = iconColorProvider,
50       contentDescription = contentDescription,
51       iconState = iconState,
52     )
53   }
54   
55   val IconData.contentDescriptionTextOrEmpty
56     get() = contentDescription?.text.orEmpty()
57   
58   enum class IconSize(internal val dimension: Dp) {
59     SIZE2(dimension = 2.dp),
60     SIZE4(dimension = 4.dp),
61     SIZE6(dimension = 6.dp),
62     SIZE8(dimension = 8.dp),
63     SIZE12(dimension = 12.dp),
64     SIZE14(dimension = 14.dp),
65     SIZE16(dimension = 16.dp),
66     SIZE20(dimension = 20.dp),
67     SIZE24(dimension = 24.dp),
68     SIZE30(dimension = 30.dp),
69     SIZE32(dimension = 32.dp),
70     SIZE40(dimension = 40.dp),
71     SIZE48(dimension = 48.dp),
72     SIZE56(dimension = 56.dp),
73     SIZE64(dimension = 64.dp),
74     SIZE72(dimension = 72.dp),
75     SIZE96(dimension = 96.dp),
76   }
77   
78   sealed interface BackgroundShape {
79     object Rounded : BackgroundShape
80     object Square : BackgroundShape
81     class RoundedSquare(
82       val shape: @Composable () -> Shape,
83     ) : BackgroundShape
84   }
85   
86   enum class IconState(val alphaValue: Float) {
87     ENABLED(alphaValue = 1f),
88     DISABLED(alphaValue = 0.3f),
89   }
90   