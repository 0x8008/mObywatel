1    package pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttons
2    
3    import androidx.compose.foundation.layout.Spacer
4    import androidx.compose.foundation.layout.height
5    import androidx.compose.runtime.Composable
6    import androidx.compose.ui.Modifier
7    import pl.gov.coi.common.ui.theme.AppTheme
8    import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonRow
9    import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonSupportText
10   import pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttonrow.RadioButtonRow
11   
12   @Composable
13   internal fun RadioButtons(
14     items: List<RadioButtonRow>,
15     state: RadioButtonSupportText,
16   ) {
17     items.forEachIndexed { index, radioButtonItem ->
18       RadioButtonRow(
19         data = radioButtonItem
20           .setValidationState(state = state),
21       )
22       if (items.lastIndex != index) {
23         Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing250))
24       }
25     }
26   }
27   
28   private fun RadioButtonRow.setValidationState(
29     state: RadioButtonSupportText,
30   ) = this.copy(item = item.copy(isError = state is RadioButtonSupportText.Error))
31   