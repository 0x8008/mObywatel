1    package pl.gov.coi.common.ui.ds.header
2    
3    import androidx.annotation.DrawableRes
4    import androidx.compose.runtime.Composable
5    import androidx.compose.ui.graphics.Color
6    import pl.gov.coi.common.domain.label.Label
7    import pl.gov.coi.common.ui.ds.custom.icon.BackgroundShape
8    import pl.gov.coi.common.ui.ds.custom.icon.IconData
9    import pl.gov.coi.common.ui.ds.custom.icon.IconSize
10   import pl.gov.coi.common.ui.ds.custom.icon.IconState
11   
12   class HeaderData(
13     @DrawableRes iconResId: Int,
14     iconColorProvider: @Composable () -> Color,
15     iconBackgroundColorProvider: @Composable () -> Color,
16     internal val title: Label,
17     internal val message: Label?,
18   ) {
19     internal val iconData: IconData = IconData.Background(
20       iconResId = iconResId,
21       iconColorProvider = iconColorProvider,
22       backgroundSize = IconSize.SIZE72,
23       iconSize = IconSize.SIZE40,
24       backgroundColorProvider = iconBackgroundColorProvider,
25       backgroundShape = BackgroundShape.Rounded,
26       contentDescription = null,
27     )
28   }
29   
30   class CustomHeaderIconData(
31     internal val iconResId: Int,
32     internal val iconColorProvider: @Composable () -> Color,
33     internal val backgroundColorProvider: @Composable () -> Color,
34     internal val contentDescription: Label?,
35     internal val iconState: IconState = IconState.ENABLED,
36   )
37   