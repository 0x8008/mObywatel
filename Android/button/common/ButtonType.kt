1    package pl.gov.coi.common.ui.ds.button.common
2    
3    import androidx.annotation.DrawableRes
4    import pl.gov.coi.common.domain.label.Label
5    
6    sealed interface ButtonType {
7      data class WithText(
8        val testTag: String? = null,
9        val label: Label,
10       val contentDescription: Label = Label.EMPTY,
11     ) : ButtonType
12   
13     data class WithIcon(
14       val testTag: String? = null,
15       @DrawableRes val iconResId: Int,
16       val contentDescription: Label = Label.EMPTY,
17     ) : ButtonType
18   }
19   