1    package pl.gov.coi.common.ui.ds.singlecard.radiobutton
2    
3    import pl.gov.coi.common.domain.validators.ValidationState
4    
5    data class OldRadioButtonData(
6      val id: RadioButtonId,
7      val isSelected: Boolean = false,
8      val enabled: Boolean = true,
9      val validationState: ValidationState = ValidationState.Default,
10   )
11   
12   interface RadioButtonId {
13     object Default : RadioButtonId
14   }
15   