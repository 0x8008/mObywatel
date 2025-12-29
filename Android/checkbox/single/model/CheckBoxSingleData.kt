1    package pl.gov.coi.common.ui.ds.checkbox.single.model
2    
3    import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckBoxRowData
4    import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckBoxType
5    import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckboxContentType
6    
7    data class CheckBoxSingleData(
8      val checkbox: CheckBoxRowData,
9      val type: CheckBoxType = CheckBoxType.Default,
10     val contentType: CheckboxContentType = CheckboxContentType.DEFAULT,
11     val isEnabled: Boolean = true,
12   )
13   