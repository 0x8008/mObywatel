1    package pl.gov.coi.common.ui.ds.searchbar
2    
3    import pl.gov.coi.common.domain.label.Label
4    
5    data class SearchBarData(
6      val query: String,
7      val onQueryChange: (String) -> Unit,
8      val isActive: Boolean,
9      val onActiveChange: (Boolean) -> Unit,
10     val onClearClicked: () -> Unit,
11     val placeholder: Label,
12   )
13   