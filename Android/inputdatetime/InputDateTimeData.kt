1    package pl.gov.coi.common.ui.ds.inputdatetime
2    
3    import pl.gov.coi.common.domain.label.Label
4    import pl.gov.coi.common.domain.validators.ValidationState
5    import pl.gov.coi.common.ui.R
6    
7    data class InputDateTimeData(
8      val label: Label,
9      val inputText: String? = null,
10     val type: Type,
11     val validationState: ValidationState = ValidationState.Default,
12     val helperText: Label? = null,
13     val enabled: Boolean = true,
14     val onClick: () -> Unit,
15   ) {
16   
17     sealed class Type(
18       val iconResId: Int,
19       val placeholder: String,
20     ) {
21       data object Time : Type(
22         iconResId = R.drawable.aa016_history,
23         placeholder = TIME_PLACEHOLDER,
24       )
25   
26       data object Date : Type(
27         iconResId = R.drawable.aa007_date_picker,
28         placeholder = DATE_PLACEHOLDER,
29       )
30     }
31   
32     companion object {
33       private const val DATE_PLACEHOLDER = "DD.MM.RRRR"
34       private const val TIME_PLACEHOLDER = "GG:MM"
35     }
36   }
37   