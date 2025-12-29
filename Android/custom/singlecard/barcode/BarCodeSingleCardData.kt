1    package pl.gov.coi.common.ui.ds.custom.singlecard.barcode
2    
3    import pl.gov.coi.common.domain.label.Label
4    import pl.gov.coi.common.ui.unmapped.singlecard.MediaSection
5    
6    data class BarCodeSingleCardData(
7      val label: Label,
8      val barCodeImage: MediaSection.Image,
9    )
10   