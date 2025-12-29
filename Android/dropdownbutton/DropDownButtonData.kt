1    package pl.gov.coi.common.ui.ds.dropdownbutton
2    
3    import pl.gov.coi.common.domain.label.Label
4    
5    data class DropDownButtonData(
6      val label: Label,
7      val items: List<Label>,
8      val initialSelectedItem: Int? = null,
9      val buttonType: DropDownButtonState = DropDownButtonState.Enabled(),
10     val placeholder: Label,
11     val onClick: (DropDownButtonData) -> Unit,
12   )
13   
14   sealed interface DropDownButtonState {
15   
16     data class Error(
17       val errorText: Label? = null,
18     ) : DropDownButtonState
19   
20     data class Enabled(
21       val helperText: Label? = null,
22     ) : DropDownButtonState
23   
24     data class Disabled(
25       val helperText: Label? = null,
26     ) : DropDownButtonState
27   
28   }
29   