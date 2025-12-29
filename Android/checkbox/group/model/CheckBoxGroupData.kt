1    package pl.gov.coi.common.ui.ds.checkbox.group.model
2    
3    import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckBoxRowData
4    import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckBoxType
5    import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckboxContentType
6    
7    data class CheckBoxGroupData(
8      val checkboxes: List<CheckBoxRowData>,
9      val header: CheckBoxHeaderData? = null,
10     val type: CheckBoxType = CheckBoxType.Default,
11     val contentType: CheckboxContentType = CheckboxContentType.DEFAULT,
12     val isEnabled: Boolean = true,
13   )
14   