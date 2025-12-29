1    package pl.gov.coi.common.ui.ds.controllers
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.clickable
5    import androidx.compose.foundation.interaction.MutableInteractionSource
6    import androidx.compose.foundation.layout.Arrangement
7    import androidx.compose.foundation.layout.Box
8    import androidx.compose.foundation.layout.padding
9    import androidx.compose.foundation.layout.wrapContentWidth
10   import androidx.compose.foundation.lazy.LazyListState
11   import androidx.compose.foundation.lazy.LazyRow
12   import androidx.compose.foundation.lazy.itemsIndexed
13   import androidx.compose.foundation.lazy.rememberLazyListState
14   import androidx.compose.runtime.Composable
15   import androidx.compose.runtime.remember
16   import androidx.compose.ui.Alignment
17   import androidx.compose.ui.Modifier
18   import androidx.compose.ui.graphics.Color
19   import androidx.compose.ui.text.style.TextAlign
20   import androidx.compose.ui.tooling.preview.Preview
21   import androidx.compose.ui.tooling.preview.PreviewParameter
22   import pl.gov.coi.common.ui.text.CustomText
23   import pl.gov.coi.common.ui.theme.AppTheme
24   import pl.gov.coi.common.ui.ds.controllers.provider.ControllerFilterPreviewParameterProvider
25   
26   private const val MAX_LINES = 1
27   
28   @Composable
29   fun ControllerFilter(
30     data: ControllersData.Filter,
31     state: LazyListState = rememberLazyListState(),
32   ) {
33     LazyRow(
34       state = state,
35       horizontalArrangement = Arrangement.spacedBy(space = AppTheme.dimensions.spacing50),
36       content = {
37         itemsIndexed(data.items) { index, _ ->
38           Box(
39             modifier = Modifier
40               .background(
41                 color = when (data.selectedItemIndex == index) {
42                   true -> AppTheme.colors.secondary900
43                   false -> Color.Transparent
44                 },
45                 shape = AppTheme.shapes.radius200,
46               )
47               .clickable(
48                 interactionSource = remember { MutableInteractionSource() },
49                 indication = null,
50                 onClick = { data.onClick(index) },
51               )
52               .padding(
53                 horizontal = AppTheme.dimensions.spacing200,
54                 vertical = AppTheme.dimensions.spacing50,
55               )
56               .wrapContentWidth(align = Alignment.CenterHorizontally),
57             contentAlignment = Alignment.Center,
58           ) {
59             CustomText(
60               label = data.items[index],
61               textAlign = TextAlign.Center,
62               style = when (data.selectedItemIndex == index) {
63                 true -> AppTheme.typography.bodyMediumMedium
64                 false -> AppTheme.typography.bodyMediumRegular
65               },
66               color = when (data.selectedItemIndex == index) {
67                 true -> AppTheme.colors.primary900
68                 false -> AppTheme.colors.neutral200
69               },
70               maxLines = MAX_LINES,
71             )
72           }
73         }
74       },
75     )
76   }
77   
78   @Preview
79   @Composable
80   fun ControllerFilterPreview(
81     @PreviewParameter(ControllerFilterPreviewParameterProvider::class)
82     data: ControllersData.Filter,
83   ) {
84     Box(
85       modifier = Modifier
86         .background(AppTheme.colors.background)
87         .padding(all = AppTheme.dimensions.spacing200),
88     ) {
89       ControllerFilter(data = data)
90     }
91   }
92   