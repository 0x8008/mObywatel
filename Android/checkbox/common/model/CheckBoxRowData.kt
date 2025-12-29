1    package pl.gov.coi.common.ui.ds.checkbox.common.model
2    
3    import pl.gov.coi.common.domain.label.Label
4    import pl.gov.coi.common.ui.ds.button.buttontext.ButtonTextData
5    import pl.gov.coi.common.ui.ds.link.LinkData
6    
7    data class CheckBoxRowData(
8      val testTag: String? = null,
9      val isChecked: Boolean,
10     val onCheckedChange: (Boolean) -> Unit,
11     val label: Label = Label.EMPTY,
12     val clickableTextData: ClickableTextData? = null,
13   )
14   
15   sealed interface ClickableTextData {
16     data class Link(
17       val linkData: LinkData,
18     ) : ClickableTextData
19   
20     data class Button(
21       val buttonData: ButtonTextData,
22     ) : ClickableTextData
23   }
24   