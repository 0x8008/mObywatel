1    package pl.gov.coi.common.ui.ds.button.buttontext
2    
3    import pl.gov.coi.common.domain.label.Label
4    import pl.gov.coi.common.ui.ds.button.common.ButtonState
5    
6    data class ButtonTextData(
7      val testTag: String? = null,
8      val label: Label,
9      val buttonState: ButtonState = ButtonState.Enabled,
10     val onClick: () -> Unit,
11   )
12   