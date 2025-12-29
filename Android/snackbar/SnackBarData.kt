1    package pl.gov.coi.common.ui.ds.snackbar
2    
3    import androidx.compose.material3.SnackbarDuration
4    import androidx.compose.material3.SnackbarVisuals
5    import pl.gov.coi.common.domain.label.CommonUILabelProvider
6    import pl.gov.coi.common.domain.label.Label
7    import pl.gov.coi.common.ui.R
8    import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
9    import pl.gov.coi.common.ui.theme.AppTheme
10   
11   sealed class SnackBarData(
12     open val messageLabel: Label,
13     descriptionLabel: Label? = null,
14     override val duration: SnackbarDuration = SnackbarDuration.Short,
15   ) : SnackbarVisuals {
16     override val actionLabel: String? = descriptionLabel?.text
17   
18     data class Default(
19       override val messageLabel: Label,
20       override val withDismissAction: Boolean = false,
21       override val message: String = messageLabel.text,
22     ) : SnackBarData(messageLabel = messageLabel)
23   
24     data class DefaultWithIcon(
25       override val messageLabel: Label,
26       override val withDismissAction: Boolean = true,
27       override val message: String = messageLabel.text,
28       val onAction: () -> Unit = {},
29     ) : SnackBarData(messageLabel = messageLabel) {
30       internal val iconButtonData = ButtonIconData(
31         iconResId = R.drawable.ab009_x_mark,
32         iconColorProvider = { AppTheme.colors.white },
33         contentDescription = CommonUILabelProvider.closeLabel(),
34         onClick = onAction,
35       )
36     }
37   }
38   