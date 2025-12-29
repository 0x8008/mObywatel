1    package pl.gov.coi.common.ui.ds.radiobutton.common.model
2    
3    import pl.gov.coi.common.domain.label.Label
4    
5    sealed interface RadioButtonSupportText {
6      data object None : RadioButtonSupportText
7      data class Helper(val helperText: Label = Label.EMPTY) : RadioButtonSupportText
8      data class Error(val errorText: Label = Label.EMPTY) : RadioButtonSupportText
9    }
10   