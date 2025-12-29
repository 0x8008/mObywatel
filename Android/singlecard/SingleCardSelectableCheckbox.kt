1    @file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
2    
3    package pl.gov.coi.common.ui.ds.singlecard
4    
5    import androidx.compose.foundation.BorderStroke
6    import androidx.compose.foundation.layout.Column
7    import androidx.compose.foundation.layout.Row
8    import androidx.compose.foundation.layout.RowScope
9    import androidx.compose.foundation.layout.Spacer
10   import androidx.compose.foundation.layout.defaultMinSize
11   import androidx.compose.foundation.layout.fillMaxWidth
12   import androidx.compose.foundation.layout.height
13   import androidx.compose.foundation.layout.padding
14   import androidx.compose.foundation.layout.width
15   import androidx.compose.foundation.shape.RoundedCornerShape
16   import androidx.compose.material3.Card
17   import androidx.compose.material3.CardDefaults
18   import androidx.compose.material3.ExperimentalMaterial3Api
19   import androidx.compose.runtime.Composable
20   import androidx.compose.runtime.getValue
21   import androidx.compose.runtime.setValue
22   import androidx.compose.ui.Alignment
23   import androidx.compose.ui.Modifier
24   import androidx.compose.ui.semantics.semantics
25   import androidx.compose.ui.semantics.testTag
26   import pl.gov.coi.common.ui.ds.checkbox.single.CheckBoxSingle
27   import pl.gov.coi.common.ui.ds.custom.icon.Icon
28   import pl.gov.coi.common.ui.text.CustomText
29   import pl.gov.coi.common.ui.theme.AppTheme
30   import pl.gov.coi.common.ui.utils.NoRippleInteractionSource
31   
32   @Composable
33   internal fun SingleCardSelectableCheckbox(
34     data: SingleCardData.SelectableCheckbox,
35   ) {
36     Card(
37       modifier = Modifier.semantics { testTag = data.testTag ?: data.title.tag },
38       enabled = data.checkboxData.isEnabled,
39       colors = CardDefaults.cardColors(
40         containerColor = AppTheme.colors.white,
41         disabledContainerColor = AppTheme.colors.neutral30,
42       ),
43       border = when {
44         data.checkboxData.checkbox.isChecked -> BorderStroke(
45           width = AppTheme.dimensions.strokeWidth,
46           color = AppTheme.colors.primary900,
47         )
48         else -> null
49       },
50       interactionSource = NoRippleInteractionSource(),
51       onClick = { },
52       shape = RoundedCornerShape(AppTheme.dimensions.spacing200),
53     ) {
54       Row(
55         verticalAlignment = Alignment.CenterVertically,
56         modifier = Modifier
57           .defaultMinSize(minHeight = SINGLE_CARD_MINIMUM_HEIGHT)
58           .fillMaxWidth()
59           .padding(all = AppTheme.dimensions.spacing250),
60       ) {
61         when (data) {
62           is SingleCardData.SelectableCheckbox.Title -> SingleCardSelectableCheckboxTitleContent(data = data)
63           is SingleCardData.SelectableCheckbox.IconTitle -> SingleCardSelectableCheckboxIconTitleContent(data = data)
64           is SingleCardData.SelectableCheckbox.TitleDescription ->
65             SingleCardSelectableCheckboxTitleDescriptionContent(data = data)
66         }
67         Spacer(
68           modifier = Modifier.width(width = AppTheme.dimensions.spacing200),
69         )
70         CheckBoxSingle(data = data.checkboxData)
71       }
72     }
73   }
74   
75   @Composable
76   internal fun RowScope.SingleCardSelectableCheckboxTitleContent(
77     data: SingleCardData.SelectableCheckbox.Title,
78   ) {
79     CustomText(
80       label = data.title,
81       style = AppTheme.typography.bodyLargeMedium,
82       modifier = Modifier.weight(1f),
83     )
84   }
85   
86   @Composable
87   internal fun RowScope.SingleCardSelectableCheckboxTitleDescriptionContent(
88     data: SingleCardData.SelectableCheckbox.TitleDescription,
89   ) {
90     Column(
91       modifier = Modifier
92         .fillMaxWidth()
93         .weight(1f),
94     ) {
95       CustomText(
96         label = data.title,
97         style = AppTheme.typography.bodyLargeMedium,
98         modifier = Modifier.fillMaxWidth(),
99       )
100      Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing100))
101      CustomText(
102        label = data.description,
103        style = AppTheme.typography.bodyMediumRegular,
104        color = AppTheme.colors.neutral200,
105        modifier = Modifier.fillMaxWidth(),
106      )
107      data.descriptionSecond?.let { descriptionSecond ->
108        Spacer(
109          modifier = Modifier.height(height = AppTheme.dimensions.spacing100),
110        )
111        CustomText(
112          label = descriptionSecond,
113          style = AppTheme.typography.bodyMediumRegular,
114          color = AppTheme.colors.neutral200,
115          modifier = Modifier.fillMaxWidth(),
116        )
117      }
118      data.descriptionThird?.let { descriptionThird ->
119        Spacer(
120          modifier = Modifier.height(height = AppTheme.dimensions.spacing100),
121        )
122        CustomText(
123          label = descriptionThird,
124          style = AppTheme.typography.bodyMediumRegular,
125          color = AppTheme.colors.neutral200,
126          modifier = Modifier.fillMaxWidth(),
127        )
128      }
129    }
130  }
131  
132  @Composable
133  internal fun RowScope.SingleCardSelectableCheckboxIconTitleContent(
134    data: SingleCardData.SelectableCheckbox.IconTitle,
135  ) {
136    Row(
137      verticalAlignment = Alignment.CenterVertically,
138      modifier = Modifier
139        .fillMaxWidth()
140        .weight(1f),
141    ) {
142      Icon(
143        data = data.iconData,
144      )
145      Spacer(
146        modifier = Modifier.width(width = AppTheme.dimensions.spacing200),
147      )
148      CustomText(
149        label = data.title,
150        style = AppTheme.typography.bodyLargeMedium,
151        modifier = Modifier.fillMaxWidth(),
152      )
153    }
154  }
155  