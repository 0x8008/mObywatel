1    package pl.gov.coi.common.ui.ds.topappbar
2    
3    import androidx.compose.foundation.clickable
4    import androidx.compose.foundation.layout.Box
5    import androidx.compose.foundation.layout.size
6    import androidx.compose.runtime.Composable
7    import androidx.compose.ui.Alignment
8    import androidx.compose.ui.Modifier
9    import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIcon
10   import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
11   import pl.gov.coi.common.ui.theme.AppTheme
12   
13   @Composable
14   internal fun TopAppBarButton(buttonIconData: ButtonIconData) {
15     Box(
16       modifier = Modifier
17         .size(AppTheme.dimensions.spacing600)
18         .clickable {
19           buttonIconData.onClick()
20         },
21       contentAlignment = Alignment.Center,
22     ) {
23       ButtonIcon(data = buttonIconData)
24     }
25   }
26   
27   @Composable
28   internal fun MenuType?.CreateMenuButtons() = when (this) {
29     is MenuType.Icon -> TopAppBarButton(buttonIconData = menuButtonData.getButton())
30     is MenuType.IconList -> menuIconList.forEach { buttonData ->
31       TopAppBarButton(buttonIconData = buttonData.getButton())
32     }
33   
34     null -> Box(modifier = Modifier.size(AppTheme.dimensions.spacing600))
35   }
36   
37   @Composable
38   internal fun NavigationButtonData?.CreateNavigationButton() = when (this) {
39     null -> Box(modifier = Modifier.size(AppTheme.dimensions.spacing600))
40     else -> TopAppBarButton(
41       buttonIconData = ButtonIconData(
42         iconResId = this.icon.iconResId,
43         iconColorProvider = { AppTheme.colors.neutral200 },
44         contentDescription = this.icon.contentDescription,
45         onClick = this.onClick,
46       ),
47     )
48   }
49   