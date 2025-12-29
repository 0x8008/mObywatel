1    package pl.gov.coi.common.ui.ds.checkbox.common
2    
3    import androidx.compose.foundation.layout.Spacer
4    import androidx.compose.foundation.layout.height
5    import androidx.compose.runtime.Composable
6    import androidx.compose.ui.Modifier
7    import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckBoxType
8    import pl.gov.coi.common.ui.ds.errortext.ErrorText
9    import pl.gov.coi.common.ui.ds.helpertext.HelperText
10   import pl.gov.coi.common.ui.theme.AppTheme
11   
12   @Composable
13   fun CheckBoxBottomText(type: CheckBoxType) {
14     when (type) {
15       is CheckBoxType.Error -> type.errorText?.let { errorText ->
16         Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing200))
17         ErrorText(testTag = type.testTag?.let { tag -> tag + "ErrorText" }, errorText = errorText)
18       }
19       is CheckBoxType.Helper -> if (type.helperText.isNotBlank()) {
20         Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing200))
21         HelperText(testTag = type.testTag?.let { tag -> tag + "HelperText" }, type.helperText)
22       }
23       is CheckBoxType.Default -> Unit
24     }
25   }
26   