1    package pl.gov.coi.common.ui.ds.checkbox.group
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.layout.Box
5    import androidx.compose.foundation.layout.Column
6    import androidx.compose.foundation.layout.ColumnScope
7    import androidx.compose.foundation.layout.Row
8    import androidx.compose.foundation.layout.Spacer
9    import androidx.compose.foundation.layout.fillMaxSize
10   import androidx.compose.foundation.layout.height
11   import androidx.compose.foundation.layout.padding
12   import androidx.compose.foundation.layout.width
13   import androidx.compose.runtime.Composable
14   import androidx.compose.ui.Alignment
15   import androidx.compose.ui.Modifier
16   import androidx.compose.ui.text.style.TextAlign
17   import androidx.compose.ui.tooling.preview.Preview
18   import androidx.compose.ui.tooling.preview.PreviewParameter
19   import pl.gov.coi.common.domain.label.Label
20   import pl.gov.coi.common.ui.R
21   import pl.gov.coi.common.ui.ds.checkbox.common.CheckBoxBottomText
22   import pl.gov.coi.common.ui.ds.checkbox.common.CheckboxRow
23   import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckboxContentType
24   import pl.gov.coi.common.ui.ds.checkbox.group.model.CheckBoxGroupData
25   import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIcon
26   import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
27   import pl.gov.coi.common.ui.ds.contentbox.ContentBox
28   import pl.gov.coi.common.ui.text.CustomText
29   import pl.gov.coi.common.ui.theme.AppTheme
30   
31   @Composable
32   fun CheckBoxGroup(data: CheckBoxGroupData) {
33     Column {
34       data.header?.let { header ->
35         LabelRow(
36           label = header.label,
37           onHelperButtonClick = header.onClick,
38         )
39       }
40       when (data.contentType) {
41         CheckboxContentType.CONTENT_BOX -> ContentBox {
42           GroupCheckBoxContainerContent(data)
43         }
44   
45         CheckboxContentType.DEFAULT -> GroupCheckBoxContainerContent(data)
46       }
47     }
48   }
49   
50   @Composable
51   private fun GroupCheckBoxContainerContent(data: CheckBoxGroupData) {
52     Column {
53       data.checkboxes.forEachIndexed { index, checkboxData ->
54         CheckboxRow(data = checkboxData, type = data.type, isEnabled = data.isEnabled)
55         if (index != data.checkboxes.lastIndex) {
56           Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing250))
57         }
58       }
59       CheckBoxBottomText(data.type)
60     }
61   }
62   
63   @Composable
64   private fun ColumnScope.LabelRow(label: Label, onHelperButtonClick: (() -> Unit)?) {
65     Row(verticalAlignment = Alignment.CenterVertically) {
66       CustomText(
67         textAlign = TextAlign.Start,
68         label = label,
69         style = AppTheme.typography.subtitleMedium,
70         color = AppTheme.colors.neutral500,
71       )
72       onHelperButtonClick?.let { onClick ->
73         Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing50))
74         ButtonIcon(
75           data = ButtonIconData(
76             iconResId = R.drawable.ab015_help,
77             onClick = onClick,
78             iconColorProvider = { AppTheme.colors.primary900 },
79           ),
80         )
81       }
82     }
83     Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing200))
84   }
85   
86   @Composable
87   @Preview
88   fun GroupCheckBoxPreview(@PreviewParameter(GroupCheckBoxPPP::class) data: CheckBoxGroupData) {
89     Box(
90       modifier = Modifier
91         .background(AppTheme.colors.background)
92         .padding(AppTheme.dimensions.spacing200)
93         .fillMaxSize(),
94     ) {
95       CheckBoxGroup(data)
96     }
97   }
98   