1    package pl.gov.coi.common.ui.ds.textinput
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.border
5    import androidx.compose.foundation.layout.Box
6    import androidx.compose.foundation.layout.Column
7    import androidx.compose.foundation.layout.Row
8    import androidx.compose.foundation.layout.Spacer
9    import androidx.compose.foundation.layout.size
10   import androidx.compose.foundation.layout.width
11   import androidx.compose.foundation.text.BasicTextField
12   import androidx.compose.foundation.text.KeyboardOptions
13   import androidx.compose.runtime.Composable
14   import androidx.compose.ui.Alignment
15   import androidx.compose.ui.Modifier
16   import androidx.compose.ui.draw.clip
17   import androidx.compose.ui.focus.FocusManager
18   import androidx.compose.ui.text.TextRange
19   import androidx.compose.ui.text.input.TextFieldValue
20   import androidx.compose.ui.text.style.TextAlign
21   import androidx.core.text.isDigitsOnly
22   import pl.gov.coi.common.domain.label.toLabel
23   import pl.gov.coi.common.domain.validators.ValidationState
24   import pl.gov.coi.common.ui.ds.textinput.model.TextInputData
25   import pl.gov.coi.common.ui.focus.FocusHost
26   import pl.gov.coi.common.ui.focus.FocusHost.Companion.focusHost
27   import pl.gov.coi.common.ui.text.CustomText
28   import pl.gov.coi.common.ui.theme.AppTheme
29   
30   private const val DOT_CHAR = '\u2022'
31   private const val EMPTY_STRING = ""
32   
33   @Composable
34   internal fun TextFieldPin(
35     data: TextInputData.Pin,
36     focusHost: FocusHost,
37     focusManager: FocusManager,
38   ) {
39     Row(
40       verticalAlignment = Alignment.CenterVertically,
41     ) {
42       BasicTextField(
43         modifier = Modifier
44           .focusHost(focusHost = focusHost),
45         value = TextFieldValue(
46           text = data.value.text,
47           selection = TextRange(data.value.text.length),
48         ),
49         onValueChange = {
50           if (it.text.length <= data.length && it.text.isDigitsOnly()) {
51             data.onValueChanged(it.text)
52           }
53         },
54         enabled = data.enabled,
55         keyboardOptions = KeyboardOptions(
56           keyboardType = data.keyboardType,
57           imeAction = data.imeAction,
58         ),
59         keyboardActions = data.keyboardAction(focusManager),
60         decorationBox = {
61           Column {
62             Row {
63               repeat(times = data.length) { index ->
64                 PinCharField(
65                   characterIndex = index,
66                   pinValue = data.value.text,
67                   isError = data.validationState is ValidationState.Invalid,
68                   enabled = data.enabled,
69                 )
70                 if (index == data.length - 1) return@repeat
71                 Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing150))
72               }
73             }
74           }
75         },
76       )
77     }
78   }
79   
80   @Composable
81   private fun PinCharField(
82     characterIndex: Int,
83     pinValue: String,
84     isError: Boolean,
85     enabled: Boolean,
86   ) {
87     val isCharFieldFocused = characterIndex == pinValue.length
88   
89     val fieldValue = when {
90       characterIndex >= pinValue.length -> EMPTY_STRING
91       else -> DOT_CHAR
92     }.toString()
93   
94     Box(
95       modifier = Modifier
96         .size(
97           width = AppTheme.dimensions.spacing500,
98           height = AppTheme.dimensions.spacing600,
99         )
100        .clip(AppTheme.shapes.radius50)
101        .border(
102          width = when (isCharFieldFocused) {
103            true -> AppTheme.dimensions.spacing25
104            else -> AppTheme.dimensions.strokeWidth
105          },
106          color = when {
107            isError -> AppTheme.colors.supportRed100
108            isCharFieldFocused -> AppTheme.colors.primary900
109            !enabled -> AppTheme.colors.neutral30
110            else -> AppTheme.colors.neutral80
111          },
112          shape = AppTheme.shapes.radius50,
113        )
114        .background(AppTheme.colors.white),
115      contentAlignment = Alignment.Center,
116    ) {
117      CustomText(
118        modifier = Modifier.align(alignment = Alignment.Center),
119        label = fieldValue.toLabel(tag = "fieldValue"),
120        style = AppTheme.typography.headlineMedium
121          .copy(
122            color = when (enabled) {
123              true -> AppTheme.colors.neutral500
124              else -> AppTheme.colors.neutral60
125            },
126          ),
127        textAlign = TextAlign.Center,
128      )
129    }
130  }
131  