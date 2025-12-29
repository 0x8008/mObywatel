1    package pl.gov.coi.common.ui.ds.radiobutton
2    
3    import pl.gov.coi.common.domain.label.Label
4    import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonRow
5    import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonSupportText
6    import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonVariant
7    
8    data class RadioButtonData(
9      val items: List<RadioButtonRow>,
10     val radioButtonVariant: RadioButtonVariant,
11     val supportText: RadioButtonSupportText = RadioButtonSupportText.None,
12     val label: Label? = null,
13     val onClickHelperIcon: (() -> Unit)? = null,
14   )
15   