1    package pl.gov.coi.common.ui.ds.radiobutton
2    
3    import androidx.compose.animation.AnimatedVisibility
4    import androidx.compose.foundation.background
5    import androidx.compose.foundation.layout.Arrangement
6    import androidx.compose.foundation.layout.Column
7    import androidx.compose.foundation.layout.Row
8    import androidx.compose.foundation.layout.Spacer
9    import androidx.compose.foundation.layout.fillMaxSize
10   import androidx.compose.foundation.layout.height
11   import androidx.compose.foundation.layout.padding
12   import androidx.compose.foundation.layout.width
13   import androidx.compose.runtime.Composable
14   import androidx.compose.ui.Alignment
15   import androidx.compose.ui.Modifier
16   import androidx.compose.ui.tooling.preview.Preview
17   import androidx.compose.ui.tooling.preview.PreviewParameter
18   import pl.gov.coi.common.domain.label.Label
19   import pl.gov.coi.common.ui.R
20   import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIcon
21   import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
22   import pl.gov.coi.common.ui.ds.contentbox.ContentBox
23   import pl.gov.coi.common.ui.ds.errortext.ErrorText
24   import pl.gov.coi.common.ui.ds.helpertext.HelperText
25   import pl.gov.coi.common.ui.preview.WrappedValue
26   import pl.gov.coi.common.ui.text.CustomText
27   import pl.gov.coi.common.ui.theme.AppTheme
28   import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonSupportText
29   import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonVariant
30   import pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttons.RadioButtons
31   import pl.gov.coi.common.ui.ds.radiobutton.provider.RadioButtonPPP
32   
33   @Composable
34   fun RadioButton(
35     data: RadioButtonData,
36   ) {
37     Column {
38       RadioButtonHeader(
39         label = data.label,
40         onClickHelperIcon = data.onClickHelperIcon,
41       )
42       when (data.radioButtonVariant) {
43         is RadioButtonVariant.Default -> RadioButtonDefault(data = data)
44         is RadioButtonVariant.ContentBox -> RadioButtonContentBox(data = data)
45       }
46     }
47   }
48   
49   @Composable
50   private fun RadioButtonContentBox(
51     data: RadioButtonData,
52   ) {
53     ContentBox {
54       Column {
55         RadioButtonDefault(data = data)
56       }
57     }
58   }
59   
60   @Composable
61   private fun RadioButtonDefault(
62     data: RadioButtonData,
63   ) {
64     RadioButtons(
65       items = data.items,
66       state = data.supportText,
67     )
68     RadioButtonSupportText(supportText = data.supportText)
69   }
70   
71   @Composable
72   private fun RadioButtonHeader(
73     label: Label?,
74     onClickHelperIcon: (() -> Unit)?,
75   ) {
76     Row {
77       label?.let {
78         CustomText(
79           label = label,
80           style = AppTheme.typography.subtitleMedium,
81           color = AppTheme.colors.neutral500,
82         )
83       }
84       Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing50))
85       onClickHelperIcon?.let { onClick ->
86         ButtonIcon(
87           data = ButtonIconData(
88             iconResId = R.drawable.ab015_help,
89             onClick = onClick,
90             iconColorProvider = { AppTheme.colors.primary900 },
91           ),
92         )
93       }
94     }
95     if (label != null || onClickHelperIcon != null) {
96       Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing200))
97     }
98   }
99   
100  @Composable
101  private fun RadioButtonSupportText(supportText: RadioButtonSupportText) = when (supportText) {
102    is RadioButtonSupportText.Helper -> RadioButtonHelperText(helperText = supportText.helperText)
103    is RadioButtonSupportText.Error -> RadioButtonError(errorText = supportText.errorText)
104    RadioButtonSupportText.None -> Unit
105  }
106  
107  @Composable
108  private fun RadioButtonError(
109    errorText: Label,
110  ) {
111    AnimatedVisibility(visible = true) {
112      Column {
113        Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing200))
114        ErrorText(errorText = errorText)
115      }
116    }
117  }
118  
119  @Composable
120  private fun RadioButtonHelperText(
121    helperText: Label,
122  ) {
123    if (helperText.isNotBlank()) {
124      Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing200))
125      HelperText(helperLabel = helperText)
126    }
127  }
128  
129  @Preview
130  @Composable
131  fun RadioButtonPreview(
132    @PreviewParameter(RadioButtonPPP::class)
133    wrappedValue: WrappedValue<RadioButtonData>,
134  ) {
135    Column(
136      modifier = Modifier
137        .background(color = AppTheme.colors.background)
138        .fillMaxSize()
139        .padding(all = AppTheme.dimensions.spacing200),
140      horizontalAlignment = Alignment.CenterHorizontally,
141      verticalArrangement = Arrangement.Center,
142    ) {
143      RadioButton(data = wrappedValue.value())
144    }
145  }
146  