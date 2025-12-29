1    package pl.gov.coi.common.ui.ds.datepicker
2    
3    import java.time.Instant
4    import java.time.LocalDate
5    import java.time.ZoneOffset
6    
7    interface DatePickerDataVMS {
8      fun isDateSelectable(currentCalendarDate: Long): Boolean
9      fun getInitialSelectedDate(initialDate: LocalDate?): Long?
10   }
11   
12   class DatePickerDataVMSImpl(
13     val minDate: LocalDate?,
14     val maxDate: LocalDate?,
15   ) : DatePickerDataVMS {
16     override fun isDateSelectable(currentCalendarDate: Long): Boolean {
17       /* 
18       Probably ZoneOffset.systemDefault should be used, but it returns wrong values. 
19       Will be checked in MOB-60795 
20        */
21       val currentLocalDate = LocalDate.ofInstant(Instant.ofEpochMilli(currentCalendarDate), ZoneOffset.UTC)
22       return (minDate?.isBefore(currentLocalDate) ?: true || minDate?.isEqual(currentLocalDate) ?: true) &&
23         (maxDate?.isAfter(currentLocalDate) ?: true || maxDate?.isEqual(currentLocalDate) ?: true)
24     }
25   
26     override fun getInitialSelectedDate(initialDate: LocalDate?): Long? {
27       /* 
28       Probably ZoneOffset.systemDefault should be used, but it returns wrong values. 
29       Will be checked in MOB-60795 
30        */
31       return initialDate?.atStartOfDay()?.atZone(ZoneOffset.UTC)?.toInstant()?.toEpochMilli()
32     }
33   }
34   