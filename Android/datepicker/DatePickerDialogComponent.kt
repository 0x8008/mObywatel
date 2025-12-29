1    package pl.gov.coi.common.ui.ds.datepicker
2    
3    import androidx.compose.foundation.layout.Box
4    import androidx.compose.foundation.layout.padding
5    import androidx.compose.material3.DatePicker
6    import androidx.compose.material3.DatePickerDefaults
7    import androidx.compose.material3.DatePickerDialog
8    import androidx.compose.material3.DisplayMode
9    import androidx.compose.material3.ExperimentalMaterial3Api
10   import androidx.compose.material3.SelectableDates
11   import androidx.compose.material3.rememberDatePickerState
12   import androidx.compose.runtime.Composable
13   import androidx.compose.runtime.remember
14   import androidx.compose.ui.Modifier
15   import androidx.compose.ui.tooling.preview.Preview
16   import androidx.compose.ui.unit.Dp
17   import androidx.compose.ui.unit.dp
18   import pl.gov.coi.common.domain.label.CommonUILabelProvider
19   import pl.gov.coi.common.ui.ds.button.Button
20   import pl.gov.coi.common.ui.ds.button.ButtonData
21   import pl.gov.coi.common.ui.ds.button.common.ButtonSize
22   import pl.gov.coi.common.ui.ds.button.common.ButtonType
23   import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
24   import pl.gov.coi.common.ui.text.CustomText
25   import pl.gov.coi.common.ui.theme.AppTheme
26   import java.time.Instant
27   import java.time.LocalDate
28   import java.time.ZoneId
29   
30   @OptIn(ExperimentalMaterial3Api::class)
31   @Composable
32   fun DatePickerDialogComponent(
33     data: DatePickerDialogData,
34   ) {
35     val customSpacing: Dp = 6.dp
36   
37     val datePickerColors = DatePickerDefaults.colors(
38       containerColor = AppTheme.colors.white,
39       titleContentColor = AppTheme.colors.neutral200,
40       headlineContentColor = AppTheme.colors.neutral500,
41       weekdayContentColor = AppTheme.colors.neutral200,
42       navigationContentColor = AppTheme.colors.neutral200,
43       yearContentColor = AppTheme.colors.neutral200,
44       currentYearContentColor = AppTheme.colors.primary900,
45       selectedYearContentColor = AppTheme.colors.white,
46       selectedYearContainerColor = AppTheme.colors.primary900,
47       dayContentColor = AppTheme.colors.neutral200,
48       selectedDayContentColor = AppTheme.colors.white,
49       selectedDayContainerColor = AppTheme.colors.primary900,
50       todayContentColor = AppTheme.colors.primary900,
51       todayDateBorderColor = AppTheme.colors.primary900,
52       dividerColor = AppTheme.colors.neutral30,
53     )
54   
55     val datePickerState = rememberDatePickerState(
56       initialSelectedDateMillis = data.datePickerDataVMS.getInitialSelectedDate(initialDate = data.initialDate),
57       initialDisplayMode = DisplayMode.Picker,
58       selectableDates = object : SelectableDates {
59         override fun isSelectableDate(utcTimeMillis: Long): Boolean {
60           return data.datePickerDataVMS.isDateSelectable(currentCalendarDate = utcTimeMillis)
61         }
62       },
63     )
64   
65     DatePickerDialog(
66       shape = AppTheme.shapes.radius200,
67       colors = datePickerColors,
68       onDismissRequest = data.close,
69       confirmButton = {
70         Box(
71           modifier = Modifier
72             .padding(end = customSpacing),
73         ) {
74           Button(
75             data = ButtonData(
76               buttonSize = ButtonSize.Small,
77               buttonType = ButtonType.WithText(
78                 label = CommonUILabelProvider.okLabel(),
79               ),
80               buttonVariant = ButtonVariant.Tertiary,
81               onClick = {
82                 datePickerState.selectedDateMillis?.let {
83                   data.onDateChange(Instant.ofEpochMilli(it).atZone(ZoneId.systemDefault()).toLocalDate())
84                 }
85                 data.close()
86               },
87             ),
88           )
89         }
90       },
91       dismissButton = {
92         Button(
93           data = ButtonData(
94             buttonSize = ButtonSize.Small,
95             buttonType = ButtonType.WithText(
96               label = CommonUILabelProvider.cancelLabel(),
97             ),
98             buttonVariant = ButtonVariant.Tertiary,
99             onClick = data.close,
100          ),
101        )
102      },
103    ) {
104      DatePicker(
105        state = datePickerState,
106        colors = datePickerColors,
107        title = {
108          CustomText(
109            label = CommonUILabelProvider.selectDateLabel(),
110            style = AppTheme.typography.bodySmallMedium,
111            color = AppTheme.colors.neutral200,
112            modifier = Modifier.padding(
113              start = AppTheme.dimensions.spacing300,
114              end = AppTheme.dimensions.spacing150,
115              top = AppTheme.dimensions.spacing250,
116              bottom = AppTheme.dimensions.spacing200,
117            ),
118          )
119        },
120        headline = {
121          DatePickerDefaults.DatePickerHeadline(
122            selectedDateMillis = datePickerState.selectedDateMillis,
123            displayMode = datePickerState.displayMode,
124            dateFormatter = remember { DatePickerDefaults.dateFormatter() },
125            modifier = Modifier.padding(
126              start = AppTheme.dimensions.spacing300,
127              end = AppTheme.dimensions.spacing150,
128              top = AppTheme.dimensions.zero,
129              bottom = AppTheme.dimensions.spacing100,
130            ),
131          )
132        },
133        showModeToggle = false,
134      )
135    }
136  }
137  
138  @Preview
139  @Composable
140  fun DatePickerDialogComponentPreview() {
141    DatePickerDialogComponent(
142      data = DatePickerDialogData(
143        initialDate = LocalDate.of(2024, 7, 16),
144        onDateChange = {},
145        close = {},
146        datePickerDataVMS = DatePickerDataVMSImpl(
147          minDate = LocalDate.of(2024, 7, 4),
148          maxDate = LocalDate.of(2024, 7, 24),
149        ),
150      ),
151    )
152  }
153  