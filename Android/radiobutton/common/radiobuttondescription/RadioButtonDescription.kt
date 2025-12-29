1    package pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttondescription
2    
3    import androidx.compose.foundation.layout.Spacer
4    import androidx.compose.foundation.layout.height
5    import androidx.compose.runtime.Composable
6    import androidx.compose.ui.Modifier
7    import pl.gov.coi.common.domain.label.Label
8    import pl.gov.coi.common.ui.text.CustomText
9    import pl.gov.coi.common.ui.theme.AppTheme
10   
11   @Composable
12   internal fun RadioButtonDescription(
13     description: Label?,
14   ) {
15     description?.let { descriptionLabel ->
16       Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing100))
17       CustomText(
18         label = descriptionLabel,
19         style = AppTheme.typography.bodyLargeRegular,
20         color = AppTheme.colors.neutral200,
21       )
22     }
23   }
24   