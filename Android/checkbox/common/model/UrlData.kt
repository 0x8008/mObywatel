1    package pl.gov.coi.common.ui.ds.checkbox.common.model
2    
3    import pl.gov.coi.common.domain.label.Label
4    
5    data class UrlData(
6      val urlText: Label,
7      val onClick: (url: String) -> Unit,
8    )
9    