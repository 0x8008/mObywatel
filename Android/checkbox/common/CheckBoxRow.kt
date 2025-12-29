1    package pl.gov.coi.common.ui.ds.checkbox.common
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.border
5    import androidx.compose.foundation.layout.Box
6    import androidx.compose.foundation.layout.Column
7    import androidx.compose.foundation.layout.Row
8    import androidx.compose.foundation.layout.Spacer
9    import androidx.compose.foundation.layout.padding
10   import androidx.compose.foundation.layout.size
11   import androidx.compose.foundation.layout.width
12   import androidx.compose.foundation.selection.toggleable
13   import androidx.compose.foundation.shape.RoundedCornerShape
14   import androidx.compose.runtime.Composable
15   import androidx.compose.ui.Alignment
16   import androidx.compose.ui.ExperimentalComposeUiApi
17   import androidx.compose.ui.Modifier
18   import androidx.compose.ui.graphics.Color
19   import androidx.compose.ui.semantics.Role
20   import androidx.compose.ui.semantics.semantics
21   import androidx.compose.ui.semantics.testTag
22   import androidx.compose.ui.semantics.testTagsAsResourceId
23   import androidx.compose.ui.text.style.TextAlign
24   import pl.gov.coi.common.domain.label.Label
25   import pl.gov.coi.common.ui.R
26   import pl.gov.coi.common.ui.ds.button.buttontext.ButtonText
27   import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckBoxRowData
28   import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckBoxType
29   import pl.gov.coi.common.ui.ds.checkbox.common.model.ClickableTextData
30   import pl.gov.coi.common.ui.ds.custom.icon.Icon
31   import pl.gov.coi.common.ui.ds.custom.icon.IconData
32   import pl.gov.coi.common.ui.ds.custom.icon.IconSize
33   import pl.gov.coi.common.ui.ds.link.Link
34   import pl.gov.coi.common.ui.focus.FocusHost.Companion.focusHost
35   import pl.gov.coi.common.ui.focus.createFocusHost
36   import pl.gov.coi.common.ui.text.CustomText
37   import pl.gov.coi.common.ui.theme.AppTheme
38   
39   @OptIn(ExperimentalComposeUiApi::class)
40   @Composable
41   internal fun CheckboxRow(
42     data: CheckBoxRowData,
43     type: CheckBoxType,
44     isEnabled: Boolean,
45   ) {
46     Column {
47       Row(
48         modifier = Modifier
49           .toggleable(
50             enabled = isEnabled,
51             value = data.isChecked,
52             role = Role.Checkbox,
53             onValueChange = { checked ->
54               data.onCheckedChange(checked)
55             },
56           )
57           .semantics {
58             testTagsAsResourceId = true
59             testTag = data.testTag ?: "checkbox${data.label}"
60           },
61         verticalAlignment = Alignment.Top,
62       ) {
63         Box(
64           modifier = Modifier.size(IconSize.SIZE24.dimension),
65           contentAlignment = Alignment.Center,
66         ) {
67           Box(
68             modifier = Modifier
69               .background(
70                 color = type.getBackgroundColor(isChecked = data.isChecked, isEnabled = isEnabled),
71                 shape = RoundedCornerShape(AppTheme.dimensions.spacing50),
72               )
73               .border(
74                 width = AppTheme.dimensions.spacing25,
75                 color = type.getBorderStrokeColor(isChecked = data.isChecked, isEnabled = isEnabled),
76                 shape = RoundedCornerShape(AppTheme.dimensions.spacing50),
77               )
78               .size(IconSize.SIZE20.dimension)
79               .focusHost(createFocusHost()),
80   
81             contentAlignment = Alignment.Center,
82           ) {
83             if (data.isChecked) {
84               Icon(
85                 data = IconData.Standard(
86                   testTag = data.testTag?.let { tag -> tag + "Icon" },
87                   iconResId = R.drawable.e006_checkbox_mark,
88                   iconSize = IconSize.SIZE16,
89                   iconColorProvider = { AppTheme.colors.white },
90                   contentDescription = Label.EMPTY,
91                 ),
92               )
93             }
94           }
95         }
96   
97         if (data.label.isNotBlank()) {
98           Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing200))
99           CustomText(
100            testTag = data.testTag?.let { tag -> tag + "Text" },
101            textAlign = TextAlign.Start,
102            label = data.label,
103            style = AppTheme.typography.bodyLargeRegular,
104            color = getLabelColor(isEnabled = isEnabled),
105          )
106        }
107      }
108      data.clickableTextData?.let { clickableText ->
109        CheckBoxClickableText(data = clickableText)
110      }
111    }
112  }
113  
114  @Composable
115  private fun CheckBoxClickableText(data: ClickableTextData) {
116    Box(
117      modifier = Modifier.padding(
118        top = AppTheme.dimensions.spacing100,
119        start = AppTheme.dimensions.spacing500,
120        end = AppTheme.dimensions.spacing500,
121      ),
122    ) {
123      when (data) {
124        is ClickableTextData.Button -> ButtonText(data = data.buttonData)
125        is ClickableTextData.Link -> Link(data = data.linkData)
126      }
127    }
128  }
129  
130  @Composable
131  private fun getLabelColor(isEnabled: Boolean) =
132    if (isEnabled) {
133      AppTheme.colors.neutral500
134    } else {
135      AppTheme.colors.neutral30
136    }
137  
138  @Composable
139  private fun CheckBoxType.getBackgroundColor(isChecked: Boolean, isEnabled: Boolean) =
140    when {
141      isChecked.not() -> Color.Transparent
142      isEnabled.not() -> AppTheme.colors.neutral30
143      this is CheckBoxType.Error -> AppTheme.colors.supportRed100
144      else -> AppTheme.colors.primary900
145    }
146  
147  @Composable
148  private fun CheckBoxType.getBorderStrokeColor(isEnabled: Boolean, isChecked: Boolean) =
149    when {
150      isEnabled.not() -> AppTheme.colors.neutral30
151      this is CheckBoxType.Error -> AppTheme.colors.supportRed100
152      else -> if (isChecked) AppTheme.colors.primary900 else AppTheme.colors.neutral80
153    }
154  