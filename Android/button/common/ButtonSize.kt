1    package pl.gov.coi.common.ui.ds.button.common
2    
3    sealed interface ButtonSize {
4      data class Large(
5        val fillMaxWidth: Boolean = true,
6      ) : ButtonSize
7    
8      data object Small : ButtonSize
9    }
10   