1    package pl.gov.coi.common.ui.ds.checkbox.common.model
2    
3    import pl.gov.coi.common.domain.label.Label
4    
5    sealed interface CheckBoxType {
6      data class Error(
7        val testTag: String? = null,
8        val errorText: Label? = null,
9      ) : CheckBoxType
10     data class Helper(
11       val testTag: String? = null,
12       val helperText: Label,
13     ) : CheckBoxType
14     data object Default : CheckBoxType
15   }
16   