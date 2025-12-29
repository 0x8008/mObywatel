1    package pl.gov.coi.common.ui.ds.inforow.model
2    
3    import androidx.annotation.DrawableRes
4    import androidx.compose.runtime.Composable
5    import androidx.compose.ui.graphics.Color
6    import pl.gov.coi.common.domain.label.Label
7    import pl.gov.coi.common.ui.R
8    import pl.gov.coi.common.ui.ds.custom.icon.IconData
9    import pl.gov.coi.common.ui.ds.custom.icon.IconSize
10   import pl.gov.coi.common.ui.theme.AppTheme
11   
12   sealed class InfoRowData(
13     internal val description: Label,
14     internal val icon: IconData,
15   ) {
16     class Bullet(
17       description: Label,
18     ) : InfoRowData(
19       description = description,
20       icon = IconData.Standard(
21         iconResId = R.drawable.aa046_bullet,
22         iconSize = IconSize.SIZE24,
23         iconColorProvider = { AppTheme.colors.neutral200 },
24         contentDescription = null,
25       ),
26     )
27   
28     class Default(
29       description: Label,
30       @DrawableRes val iconResId: Int,
31       iconColorProvider: @Composable () -> Color,
32       val title: Label,
33     ) : InfoRowData(
34       description = description,
35       icon = IconData.Standard(
36         iconResId = iconResId,
37         iconSize = IconSize.SIZE32,
38         iconColorProvider = iconColorProvider,
39         contentDescription = null,
40       ),
41     )
42   }
43   