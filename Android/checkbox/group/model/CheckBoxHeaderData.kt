1    package pl.gov.coi.common.ui.ds.checkbox.group.model
2    
3    import pl.gov.coi.common.domain.label.Label
4    
5    data class CheckBoxHeaderData(
6      val label: Label,
7      val onClick: (() -> Unit)? = null,
8    )
9    