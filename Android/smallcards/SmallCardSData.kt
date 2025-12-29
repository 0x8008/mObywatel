1    package pl.gov.coi.common.ui.ds.smallcards
2    
3    import androidx.annotation.DrawableRes
4    import androidx.compose.runtime.Composable
5    import androidx.compose.ui.graphics.Color
6    import pl.gov.coi.common.domain.label.Label
7    
8    data class SmallCardSData(
9      val testTag: String? = null,
10     val title: Label,
11     @DrawableRes val iconResId: Int,
12     val iconColorProvider: @Composable () -> Color = { Color.Unspecified },
13     val onClick: () -> Unit,
14   )
15   