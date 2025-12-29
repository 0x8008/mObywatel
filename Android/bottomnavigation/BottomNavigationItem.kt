1    package pl.gov.coi.common.ui.ds.bottomnavigation
2    
3    import androidx.annotation.DrawableRes
4    import pl.gov.coi.common.domain.label.Label
5    
6    data class BottomNavigationItem(
7      val testTag: String? = null,
8      val label: Label,
9      @DrawableRes val unselectedIconResId: Int,
10     @DrawableRes val selectedIconResId: Int,
11     val onClickAction: () -> Unit,
12   )
13   