1    package pl.gov.coi.common.ui.ds.button.common
2    
3    sealed interface ButtonState {
4      data object Enabled : ButtonState
5      data object Destructive : ButtonState
6      data object Disabled : ButtonState
7    }
8    