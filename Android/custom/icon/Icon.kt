1    package pl.gov.coi.common.ui.ds.custom.icon
2    
3    import androidx.compose.foundation.Canvas
4    import androidx.compose.foundation.layout.Box
5    import androidx.compose.foundation.layout.size
6    import androidx.compose.runtime.Composable
7    import androidx.compose.ui.Alignment
8    import androidx.compose.ui.ExperimentalComposeUiApi
9    import androidx.compose.ui.Modifier
10   import androidx.compose.ui.draw.alpha
11   import androidx.compose.ui.draw.clip
12   import androidx.compose.ui.platform.LocalContext
13   import androidx.compose.ui.res.painterResource
14   import androidx.compose.ui.semantics.semantics
15   import androidx.compose.ui.semantics.testTag
16   import androidx.compose.ui.semantics.testTagsAsResourceId
17   import androidx.compose.ui.tooling.preview.Preview
18   import androidx.compose.ui.tooling.preview.PreviewParameter
19   import pl.gov.coi.common.ui.ds.custom.icon.provider.IconPreviewParameterProvider
20   import pl.gov.coi.common.ui.utils.getResourceEntryNameIcon
21   import pl.gov.coi.common.ui.utils.semanticsContentDescription
22   
23   @OptIn(ExperimentalComposeUiApi::class)
24   @Composable
25   fun Icon(
26     modifier: Modifier = Modifier,
27     data: IconData,
28     focusable: Boolean? = null,
29   ) {
30     val localContext = LocalContext.current
31     Box(
32       modifier = modifier
33         .alpha(data.iconState.alphaValue)
34         .semantics { testTagsAsResourceId = true }
35         .semantics { testTag = data.testTag ?: "icon${getResourceEntryNameIcon(data.iconResId, localContext)}" }
36         .semanticsContentDescription(data.contentDescription?.text, focusable),
37       contentAlignment = Alignment.Center,
38     ) {
39       if (data is IconData.Background) {
40         val backgroundColor = data.backgroundColorProvider()
41         Canvas(
42           modifier = Modifier
43             .size(data.backgroundSize.dimension)
44             .then(
45               if (data.backgroundShape is BackgroundShape.RoundedSquare) {
46                 Modifier.clip(data.backgroundShape.shape())
47               } else {
48                 Modifier
49               },
50             ),
51           onDraw = {
52             when (data.backgroundShape) {
53               BackgroundShape.Rounded ->
54                 drawCircle(color = backgroundColor)
55   
56               BackgroundShape.Square,
57               is BackgroundShape.RoundedSquare,
58               ->
59                 drawRoundRect(
60                   color = backgroundColor,
61                 )
62             }
63           },
64         )
65       }
66   
67       androidx.compose.material.Icon(
68         modifier = Modifier
69           .size(data.iconSize.dimension),
70         painter = painterResource(id = data.iconResId),
71         contentDescription = null,
72         tint = data.iconColorProvider(),
73       )
74     }
75   }
76   
77   @Preview
78   @Composable
79   fun IconPreview(@PreviewParameter(IconPreviewParameterProvider::class) data: IconData) {
80     Icon(data = data)
81   }
82   