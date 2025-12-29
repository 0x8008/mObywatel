1    package pl.gov.coi.common.ui.ds.custom.documentrow
2    
3    import androidx.annotation.DrawableRes
4    import androidx.compose.runtime.Composable
5    import androidx.compose.ui.Modifier
6    import androidx.compose.ui.graphics.Color
7    import pl.gov.coi.common.domain.label.Label
8    import pl.gov.coi.common.ui.R
9    import pl.gov.coi.common.ui.ds.custom.icon.IconData
10   import pl.gov.coi.common.ui.ds.custom.icon.IconSize
11   import pl.gov.coi.common.ui.ds.singlecard.SingleCardClickableRadioButtonState
12   import pl.gov.coi.common.ui.ds.singlecard.toIconState
13   import pl.gov.coi.common.ui.ds.statusbadge.StatusBadgeData
14   
15   data class DocumentRowData(
16     val testTag: String? = null,
17     @DrawableRes val iconResId: Int,
18     val iconColorProvider: @Composable () -> Color = { Color.Unspecified },
19     val title: Label,
20     val description: Label? = null,
21     val modifier: Modifier = Modifier,
22     val badgeData: StatusBadgeData.WithIcon?,
23     val onClick: () -> Unit,
24   ) {
25     internal val iconData: IconData = IconData.Standard(
26       testTag = testTag?.let { tag -> tag + "Icon" },
27       iconResId = iconResId,
28       iconSize = IconSize.SIZE24,
29       iconColorProvider = iconColorProvider,
30       contentDescription = Label.EMPTY,
31       iconState = SingleCardClickableRadioButtonState.ENABLED.toIconState(),
32     )
33   
34     internal val trailingIcon = IconData.Standard(
35       testTag = testTag?.let { tag -> tag + "TrailingIcon" },
36       iconResId = DEFAULT_TRAILING_ICON_RES_ID,
37       iconSize = IconSize.SIZE24,
38       iconColorProvider = DEFAULT_TRAILING_ICON_COLOR_PROVIDER,
39       iconState = SingleCardClickableRadioButtonState.ENABLED.toIconState(),
40       contentDescription = DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION,
41     )
42   
43     private companion object {
44       val DEFAULT_TRAILING_ICON_RES_ID = R.drawable.ab006_chevron_right
45       val DEFAULT_TRAILING_ICON_COLOR_PROVIDER: @Composable () -> Color = { Color.Unspecified }
46       val DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION = Label.EMPTY
47     }
48   }
49   