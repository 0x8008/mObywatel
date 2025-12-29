1    package pl.gov.coi.common.ui.ds.menus
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.layout.Box
5    import androidx.compose.foundation.layout.PaddingValues
6    import androidx.compose.foundation.layout.widthIn
7    import androidx.compose.foundation.layout.wrapContentHeight
8    import androidx.compose.material3.DropdownMenu
9    import androidx.compose.material3.DropdownMenuItem
10   import androidx.compose.material3.HorizontalDivider
11   import androidx.compose.runtime.Composable
12   import androidx.compose.runtime.remember
13   import androidx.compose.ui.ExperimentalComposeUiApi
14   import androidx.compose.ui.Modifier
15   import androidx.compose.ui.graphics.Color
16   import androidx.compose.ui.semantics.semantics
17   import androidx.compose.ui.semantics.testTag
18   import androidx.compose.ui.semantics.testTagsAsResourceId
19   import androidx.compose.ui.tooling.preview.Preview
20   import androidx.compose.ui.tooling.preview.PreviewParameter
21   import androidx.compose.ui.unit.dp
22   import pl.gov.coi.common.ui.ds.custom.icon.Icon
23   import pl.gov.coi.common.ui.ds.menus.provider.MenuPreviewParameterProvider
24   import pl.gov.coi.common.ui.text.CustomText
25   import pl.gov.coi.common.ui.theme.AppTheme
26   import pl.gov.coi.common.ui.utils.MultipleEventsCutter
27   import pl.gov.coi.common.ui.utils.NoRippleInteractionSource
28   import pl.gov.coi.common.ui.utils.get
29   
30   private val MENU_MIN_WIDTH = 112.dp
31   private val MENU_MAX_WIDTH = 280.dp
32   
33   @OptIn(ExperimentalComposeUiApi::class)
34   @Composable
35   fun Menu(
36     data: MenuData,
37   ) {
38     val multipleEventsCutter = remember { MultipleEventsCutter.get() }
39   
40     DropdownMenu(
41       modifier = Modifier
42         .background(Color.White)
43         .widthIn(
44           min = MENU_MIN_WIDTH,
45           max = MENU_MAX_WIDTH,
46         ),
47       expanded = data.isMenuVisible,
48       onDismissRequest = data.onMenuClose,
49     ) {
50       data.items.forEachIndexed { index, item ->
51         DropdownMenuItem(
52           contentPadding = PaddingValues(horizontal = AppTheme.dimensions.spacing200),
53           interactionSource = NoRippleInteractionSource(),
54           modifier = Modifier
55             .semantics { testTagsAsResourceId = true }
56             .semantics { testTag = item.testTag ?: "menuItem_${item.label.tag}" },
57           onClick = {
58             multipleEventsCutter.processEvent {
59               data.onMenuClose()
60               item.onItemClick()
61             }
62           },
63           leadingIcon = item.leftIconData?.let { { Icon(data = it) } },
64           text = {
65             CustomText(
66               testTag = item.testTag?.let { tag -> tag + "Text" },
67               label = item.label,
68               color = AppTheme.colors.neutral500,
69               style = AppTheme.typography.bodyMediumRegular,
70             )
71           },
72           trailingIcon = item.rightIconData?.let { { Icon(data = it) } },
73         )
74         if (index != data.items.lastIndex) {
75           HorizontalDivider(
76             thickness = AppTheme.dimensions.strokeWidth,
77             color = AppTheme.colors.neutral30,
78           )
79         }
80       }
81     }
82   }
83   
84   @Preview
85   @Composable
86   fun MenuPreview(
87     @PreviewParameter(MenuPreviewParameterProvider::class) data: MenuData,
88   ) {
89     Box(
90       modifier = Modifier
91         .wrapContentHeight()
92         .background(color = AppTheme.colors.white),
93     ) {
94       Menu(
95         data = data,
96       )
97     }
98   }
99   