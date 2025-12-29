1    package pl.gov.coi.common.ui.ds.link
2    
3    import pl.gov.coi.common.domain.label.Label
4    
5    data class LinkData(
6      val testTag: String? = null,
7      val label: Label,
8      val url: String,
9      val linkType: LinkType,
10     val enabled: Boolean = true,
11     val onClick: (String) -> Unit,
12   ) {
13     enum class LinkType {
14       WEBSITE, E_MAIL, EXTERNAL_APP
15     }
16   }
17   