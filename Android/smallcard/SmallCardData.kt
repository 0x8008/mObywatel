1    package pl.gov.coi.common.ui.ds.smallcard
2    
3    import androidx.annotation.DrawableRes
4    import androidx.compose.runtime.Composable
5    import androidx.compose.ui.graphics.Color
6    import pl.gov.coi.common.domain.label.Label
7    import pl.gov.coi.common.ui.ds.custom.icon.IconData
8    import pl.gov.coi.common.ui.ds.custom.icon.IconSize
9    
10   data class SmallCardData(
11     val title: Label,
12     @DrawableRes val iconResId: Int,
13     val iconColorProvider: @Composable () -> Color = { Color.Unspecified },
14     val indexTag: Int? = null,
15     val onClick: () -> Unit,
16   ) {
17     internal val iconData: IconData = IconData.Standard(
18       iconResId = iconResId,
19       iconSize = IconSize.SIZE32,
20       iconColorProvider = iconColorProvider,
21       contentDescription = Label.EMPTY,
22     )
23   }
24   