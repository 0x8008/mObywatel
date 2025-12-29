1    package pl.gov.coi.common.ui.ds.menus
2    
3    import androidx.annotation.DrawableRes
4    import pl.gov.coi.common.domain.label.Label
5    import pl.gov.coi.common.ui.ds.custom.icon.IconData
6    import pl.gov.coi.common.ui.ds.custom.icon.IconSize
7    import pl.gov.coi.common.ui.theme.AppTheme
8    
9    data class MenuData(
10     val isMenuVisible: Boolean,
11     val onMenuClose: () -> Unit,
12     val items: List<MenuItem>,
13   )
14   
15   class MenuItem(
16     val testTag: String? = null,
17     val label: Label,
18     @DrawableRes leftIconResId: Int?,
19     @DrawableRes rightIconResId: Int?,
20     val onItemClick: () -> Unit,
21   ) {
22     internal val leftIconData = leftIconResId?.let {
23       IconData.Standard(
24         iconResId = leftIconResId,
25         iconSize = IconSize.SIZE24,
26         iconColorProvider = { AppTheme.colors.neutral200 },
27         contentDescription = Label.EMPTY,
28       )
29     }
30   
31     internal val rightIconData = rightIconResId?.let {
32       IconData.Standard(
33         iconResId = rightIconResId,
34         iconSize = IconSize.SIZE24,
35         iconColorProvider = { AppTheme.colors.neutral200 },
36         contentDescription = Label.EMPTY,
37       )
38     }
39   }
40   