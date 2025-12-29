1    package pl.gov.coi.common.ui.ds.controllers
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.layout.Box
5    import androidx.compose.foundation.layout.fillMaxSize
6    import androidx.compose.foundation.layout.padding
7    import androidx.compose.foundation.shape.RoundedCornerShape
8    import androidx.compose.material3.Tab
9    import androidx.compose.material3.TabRow
10   import androidx.compose.runtime.Composable
11   import androidx.compose.ui.Modifier
12   import androidx.compose.ui.draw.shadow
13   import androidx.compose.ui.graphics.Color
14   import androidx.compose.ui.text.style.TextAlign
15   import androidx.compose.ui.tooling.preview.Preview
16   import androidx.compose.ui.tooling.preview.PreviewParameter
17   import pl.gov.coi.common.ui.text.CustomText
18   import pl.gov.coi.common.ui.theme.AppTheme
19   import pl.gov.coi.common.ui.ds.controllers.provider.ControllerSwitchPreviewParameterProvider
20   import pl.gov.coi.common.ui.utils.NoRippleInteractionSource
21   
22   private const val MAX_LINES = 3
23   private const val ROUNDED_CORNER_SHAPE_PERCENTAGE_VALUE = 100
24   
25   @Composable
26   fun ControllerSwitch(
27     data: ControllersData.Switch,
28   ) {
29     TabRow(
30       selectedTabIndex = data.selectedItemType.tabIndex,
31       modifier = Modifier
32         .background(
33           color = AppTheme.colors.neutral30,
34           shape = RoundedCornerShape(percent = ROUNDED_CORNER_SHAPE_PERCENTAGE_VALUE),
35         ),
36       indicator = {},
37       divider = {},
38       containerColor = Color.Transparent,
39     ) {
40       listOf(
41         data.leftItem,
42         data.rightItem,
43       ).forEach { tabItem ->
44         val isSelected = data.selectedItemType.tabIndex == tabItem.type.tabIndex
45         Tab(
46           modifier = Modifier
47             .fillMaxSize()
48             .padding(
49               bottom = AppTheme.dimensions.spacing50,
50               top = AppTheme.dimensions.spacing50,
51               start = when (tabItem.type) {
52                 ControllersData.Switch.Type.LEFT -> AppTheme.dimensions.spacing50
53                 ControllersData.Switch.Type.RIGHT -> AppTheme.dimensions.spacing25
54               },
55               end = when (tabItem.type) {
56                 ControllersData.Switch.Type.LEFT -> AppTheme.dimensions.spacing25
57                 ControllersData.Switch.Type.RIGHT -> AppTheme.dimensions.spacing50
58               },
59             )
60             .shadow(
61               shape = RoundedCornerShape(percent = ROUNDED_CORNER_SHAPE_PERCENTAGE_VALUE),
62               elevation = when (isSelected) {
63                 true -> AppTheme.elevations.level1
64                 false -> AppTheme.elevations.level0
65               },
66             )
67             .background(
68               color = when (isSelected) {
69                 true -> Color.White
70                 false -> Color.Transparent
71               },
72               shape = RoundedCornerShape(percent = ROUNDED_CORNER_SHAPE_PERCENTAGE_VALUE),
73             ),
74           selected = isSelected,
75           onClick = { data.onClick(tabItem.type) },
76           selectedContentColor = Color.Blue,
77           interactionSource = NoRippleInteractionSource(),
78           text = {
79             CustomText(
80               label = tabItem.label,
81               textAlign = TextAlign.Center,
82               style = when (isSelected) {
83                 true -> AppTheme.typography.bodyMediumMedium
84                 false -> AppTheme.typography.bodyMediumRegular
85               },
86               color = when (isSelected) {
87                 true -> AppTheme.colors.primary900
88                 false -> AppTheme.colors.neutral200
89               },
90               maxLines = MAX_LINES,
91             )
92           },
93         )
94       }
95     }
96   }
97   
98   @Preview
99   @Composable
100  fun ControllerSwitchPreview(
101    @PreviewParameter(ControllerSwitchPreviewParameterProvider::class)
102    data: ControllersData.Switch,
103  ) {
104    Box(
105      modifier = Modifier
106        .background(AppTheme.colors.background)
107        .padding(all = AppTheme.dimensions.spacing200),
108    ) {
109      ControllerSwitch(data = data)
110    }
111  }
112  