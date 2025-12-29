1    package pl.gov.coi.common.ui.ds.radiobutton.common.model
2    
3    sealed interface RadioButtonVariant {
4      data object Default : RadioButtonVariant
5      data object ContentBox : RadioButtonVariant
6    }
7    