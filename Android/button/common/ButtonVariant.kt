1    package pl.gov.coi.common.ui.ds.button.common
2    
3    sealed interface ButtonVariant {
4      data object Primary : ButtonVariant
5      data class Secondary(
6        val reversedColor: Boolean = false,
7      ) : ButtonVariant
8    
9      data object Tertiary : ButtonVariant
10   }
11   