1    package pl.gov.coi.common.ui.ds.alert
2    
3    import pl.gov.coi.common.ui.ds.button.buttontext.ButtonTextData
4    import pl.gov.coi.common.ui.ds.link.LinkData
5    
6    sealed interface AlertButtonData {
7      data class ButtonText(val data: ButtonTextData) : AlertButtonData
8      data class Link(val data: LinkData) : AlertButtonData
9    }
10   