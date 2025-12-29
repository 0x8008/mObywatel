1    package pl.gov.coi.common.ui.ds.iconpage
2    
3    import pl.gov.coi.common.ui.ds.button.ButtonData
4    
5    data class IconPageBottomContentData(
6      val primaryButtonData: ButtonData,
7      val secondaryButtonData: ButtonData? = null,
8      val tertiaryButtonData: ButtonData? = null,
9    )
10   