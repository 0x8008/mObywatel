1    package pl.gov.coi.common.ui.ds.button.buttonicon
2    
3    import androidx.compose.foundation.layout.Box
4    import androidx.compose.foundation.layout.PaddingValues
5    import androidx.compose.foundation.layout.size
6    import androidx.compose.foundation.layout.wrapContentSize
7    import androidx.compose.material.Button
8    import androidx.compose.material.ButtonDefaults
9    import androidx.compose.runtime.Composable
10   import androidx.compose.runtime.remember
11   import androidx.compose.ui.Modifier
12   import androidx.compose.ui.graphics.Color
13   import androidx.compose.ui.platform.LocalContext
14   import androidx.compose.ui.platform.LocalFocusManager
15   import androidx.compose.ui.semantics.Role
16   import androidx.compose.ui.semantics.role
17   import androidx.compose.ui.semantics.semantics
18   import androidx.compose.ui.semantics.testTag
19   import androidx.compose.ui.tooling.preview.Preview
20   import androidx.compose.ui.tooling.preview.PreviewParameter
21   import pl.gov.coi.common.ui.ds.custom.icon.Icon
22   import pl.gov.coi.common.ui.ds.custom.icon.IconData
23   import pl.gov.coi.common.ui.ds.custom.icon.IconSize
24   import pl.gov.coi.common.ui.ds.menus.Menu
25   import pl.gov.coi.common.ui.theme.AppTheme
26   import pl.gov.coi.common.ui.utils.MultipleEventsCutter
27   import pl.gov.coi.common.ui.utils.NoRippleInteractionSource
28   import pl.gov.coi.common.ui.utils.get
29   import pl.gov.coi.common.ui.utils.getResourceEntryNameIcon
30   
31   @Composable
32   fun ButtonIcon(
33     data: ButtonIconData,
34   ) {
35     val localContext = LocalContext.current
36     val focusManager = LocalFocusManager.current
37     val rippleInteractionSource = remember { NoRippleInteractionSource() }
38     val multipleEventsCutter = remember { MultipleEventsCutter.get() }
39   
40     val iconData = IconData.Standard(
41       iconResId = data.iconResId,
42       iconSize = IconSize.SIZE24,
43       iconColorProvider = data.iconColorProvider,
44       contentDescription = data.contentDescription,
45     )
46   
47     Box(
48       modifier = Modifier.wrapContentSize(),
49     ) {
50       Button(
51         modifier = Modifier
52           .size(size = AppTheme.dimensions.spacing300)
53           .semantics {
54             role = Role.Button
55             testTag = data.testTag ?: getResourceEntryNameIcon(iconData.iconResId, localContext)
56           },
57         contentPadding = PaddingValues(all = AppTheme.dimensions.zero),
58         interactionSource = rippleInteractionSource,
59         elevation = ButtonDefaults.elevation(AppTheme.elevations.level0),
60         colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
61         onClick = {
62           multipleEventsCutter.processEvent {
63             data.onClick()
64             focusManager.clearFocus(force = true)
65           }
66         },
67       ) {
68         Icon(
69           data = iconData,
70           focusable = false,
71         )
72       }
73       data.menuData?.let { menuData ->
74         Menu(
75           data = menuData,
76         )
77       }
78     }
79   }
80   
81   @Preview
82   @Composable
83   fun ButtonPreview(@PreviewParameter(ButtonIconPPP::class) buttonData: ButtonIconData) {
84     ButtonIcon(data = buttonData)
85   }
86   