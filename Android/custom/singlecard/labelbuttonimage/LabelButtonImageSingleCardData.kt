1    package pl.gov.coi.common.ui.ds.custom.singlecard.labelbuttonimage
2    
3    import pl.gov.coi.common.domain.label.Label
4    import pl.gov.coi.common.ui.ds.button.ButtonData
5    import pl.gov.coi.common.ui.unmapped.singlecard.MediaSection
6    
7    data class LabelButtonImageSingleCardData(
8      val label: Label? = null,
9      val buttonData: ButtonData,
10     val qrCodeImage: MediaSection.Image,
11   )
12   