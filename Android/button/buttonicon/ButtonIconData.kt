1    package pl.gov.coi.common.ui.ds.button.buttonicon
2    
3    import androidx.annotation.DrawableRes
4    import androidx.compose.runtime.Composable
5    import androidx.compose.ui.graphics.Color
6    import pl.gov.coi.common.domain.label.Label
7    import pl.gov.coi.common.ui.ds.menus.MenuData
8    import pl.gov.coi.common.ui.theme.AppTheme
9    
10   
11   data class ButtonIconData(
12     val testTag: String? = null,
13     @DrawableRes val iconResId: Int,
14     val iconColorProvider: @Composable () -> Color = { AppTheme.colors.primary900 },
15     val menuData: MenuData? = null,
16     val contentDescription: Label = Label.EMPTY,
17     val onClick: () -> Unit,
18   )
19   