1    package pl.gov.coi.common.ui.ds.emptystate
2    
3    import pl.gov.coi.common.domain.label.Label
4    import pl.gov.coi.common.ui.ds.button.ButtonData
5    
6    data class EmptyStateData(
7      val title: Label? = null,
8      val body: Label,
9      val buttonData: ButtonData? = null,
10   )
11   