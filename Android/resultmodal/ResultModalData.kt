1    package pl.gov.coi.common.ui.ds.resultmodal
2    
3    import androidx.compose.runtime.Composable
4    import androidx.compose.ui.graphics.Color
5    import pl.gov.coi.common.domain.label.Label
6    import pl.gov.coi.common.ui.R
7    import pl.gov.coi.common.ui.ds.button.ButtonData
8    import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
9    import pl.gov.coi.common.ui.ds.custom.icon.IconData
10   import pl.gov.coi.common.ui.ds.custom.icon.IconSize
11   import pl.gov.coi.common.ui.theme.AppTheme
12   
13   class ResultModalData(
14     iconRes: Int,
15     iconColorProvider: @Composable () -> Color,
16     iconContentDescription: Label,
17     val title: Label,
18     val dataTitle1: Label,
19     val data1: Label,
20     val dataTitle2: Label,
21     val data2: Label,
22     val primaryButton: ButtonData?,
23     val secondaryButton: ButtonData?,
24     val tertiaryButton: ButtonData?,
25     closeIconContentDescription: Label,
26     closeAction: () -> Unit,
27   ) {
28     val closeIconButtonData = ButtonIconData(
29       iconResId = R.drawable.ab009_x_mark,
30       iconColorProvider = { AppTheme.colors.neutral500 },
31       contentDescription = closeIconContentDescription,
32       onClick = closeAction,
33     )
34     val iconData: IconData = IconData.Standard(
35       iconResId = iconRes,
36       iconSize = IconSize.SIZE64,
37       iconColorProvider = iconColorProvider,
38       contentDescription = iconContentDescription,
39     )
40   }
41   