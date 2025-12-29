1    package pl.gov.coi.common.ui.ds.radiobutton.common.model
2    
3    import androidx.compose.runtime.Composable
4    import pl.gov.coi.common.domain.label.Label
5    
6    interface RadioButtonCustomContent {
7      fun content(): @Composable () -> Unit
8    }
9    
10   data class RadioButtonRow(
11     val item: RadioButtonItemData,
12     val onClick: () -> Unit,
13     val label: Label,
14     val description: Label? = null,
15     val content: RadioButtonCustomContent? = null,
16   )
17   