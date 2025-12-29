1    package pl.gov.coi.common.ui.ds.datepicker
2    
3    import java.time.LocalDate
4    
5    data class DatePickerDialogData(
6      val initialDate: LocalDate? = null,
7      val onDateChange: (LocalDate) -> Unit,
8      val close: () -> Unit,
9      val datePickerDataVMS: DatePickerDataVMS,
10   )
11   