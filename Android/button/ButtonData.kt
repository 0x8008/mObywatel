1    package pl.gov.coi.common.ui.ds.button
2    
3    import pl.gov.coi.common.ui.ds.button.common.ButtonSize
4    import pl.gov.coi.common.ui.ds.button.common.ButtonState
5    import pl.gov.coi.common.ui.ds.button.common.ButtonType
6    import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
7    
8    data class ButtonData(
9      val testTag: String? = null,
10     val buttonSize: ButtonSize,
11     val buttonType: ButtonType,
12     val buttonVariant: ButtonVariant,
13     val buttonState: ButtonState = ButtonState.Enabled,
14     val onClick: () -> Unit,
15   )
16   