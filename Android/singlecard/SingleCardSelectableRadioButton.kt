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
20   import androidx.compose.ui.Alignment
21   import androidx.compose.ui.Modifier
22   import androidx.compose.ui.semantics.semantics
23   import androidx.compose.ui.semantics.testTag
24   import pl.gov.coi.common.ui.ds.custom.icon.Icon
25   import pl.gov.coi.common.ui.ds.singlecard.radiobutton.OldRadioButton
26   import pl.gov.coi.common.ui.text.CustomText
27   import pl.gov.coi.common.ui.theme.AppTheme
28   import pl.gov.coi.common.ui.utils.NoRippleInteractionSource
29   
30   @Composable
31   internal fun SingleCardSelectableRadioButton(
32     data: SingleCardData.SelectableRadioButton,
33   ) {
34     Card(
35       modifier = Modifier.semantics { testTag = data.testTag ?: data.title.tag },
36       colors = CardDefaults.cardColors(
37         containerColor = AppTheme.colors.white,
38       ),
39       border = if (data.state == SingleCardClickableRadioButtonState.FOCUS) {
40         BorderStroke(
41           width = AppTheme.dimensions.spacing25,
42           color = AppTheme.colors.primary900,
43         )
44       } else {
45         when {
46           data.radioButtonData.isSelected && data.drawBorder -> BorderStroke(
47             width = AppTheme.dimensions.strokeWidth,
48             color = AppTheme.colors.primary900,
49           )
50           else -> null
51         }
52       },
53       interactionSource = NoRippleInteractionSource(),
54       onClick = data.onClick,
55       shape = RoundedCornerShape(AppTheme.dimensions.spacing200),
56     ) {
57       Row(
58         verticalAlignment = Alignment.CenterVertically,
59         modifier = Modifier
60           .defaultMinSize(minHeight = SINGLE_CARD_MINIMUM_HEIGHT)
61           .fillMaxWidth()
62           .padding(all = AppTheme.dimensions.spacing250),
63       ) {
64         when (data) {
65           is SingleCardData.SelectableRadioButton.Title -> SingleCardSelectableRadioButtonTitleContent(data = data)
66           is SingleCardData.SelectableRadioButton.IconTitle ->
67             SingleCardSelectableRadioButtonIconTitleContent(data = data)
68           is SingleCardData.SelectableRadioButton.TitleDescription ->
69             SingleCardSelectableRadioButtonTitleDescriptionContent(data = data)
70         }
71         Spacer(
72           modifier = Modifier.width(width = AppTheme.dimensions.spacing200),
73         )
74         OldRadioButton(
75           data = data.radioButtonData,
76         )
77       }
78     }
79   }
80   
81   @Composable
82   internal fun RowScope.SingleCardSelectableRadioButtonTitleContent(
83     data: SingleCardData.SelectableRadioButton.Title,
84   ) {
85     CustomText(
86       testTag = data.testTag?.let { tag -> tag + "TitleText" },
87       label = data.title,
88       style = AppTheme.typography.bodyLargeMedium,
89       modifier = Modifier.weight(1f),
90     )
91   }
92   
93   @Composable
94   internal fun RowScope.SingleCardSelectableRadioButtonTitleDescriptionContent(
95     data: SingleCardData.SelectableRadioButton.TitleDescription,
96   ) {
97     Column(
98       modifier = Modifier
99         .fillMaxWidth()
100        .weight(1f),
101    ) {
102      CustomText(
103        testTag = data.testTag?.let { tag -> tag + "TitleText" },
104        label = data.title,
105        style = AppTheme.typography.bodyLargeMedium,
106        modifier = Modifier.fillMaxWidth(),
107      )
108      Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing100))
109      CustomText(
110        testTag = data.testTag?.let { tag -> tag + "DescriptionText" },
111        label = data.description,
112        style = AppTheme.typography.bodyMediumRegular,
113        color = AppTheme.colors.neutral200,
114        modifier = Modifier.fillMaxWidth(),
115      )
116      data.descriptionSecond?.let { descriptionSecond ->
117        Spacer(
118          modifier = Modifier.height(height = AppTheme.dimensions.spacing100),
119        )
120        CustomText(
121          testTag = data.testTag?.let { tag -> tag + "DescriptionSecondText" },
122          label = descriptionSecond,
123          style = AppTheme.typography.bodyMediumRegular,
124          color = AppTheme.colors.neutral200,
125          modifier = Modifier.fillMaxWidth(),
126        )
127      }
128      data.descriptionThird?.let { descriptionThird ->
129        Spacer(
130          modifier = Modifier.height(height = AppTheme.dimensions.spacing100),
131        )
132        CustomText(
133          testTag = data.testTag?.let { tag -> tag + "DescriptionThirdText" },
134          label = descriptionThird,
135          style = AppTheme.typography.bodyMediumRegular,
136          color = AppTheme.colors.neutral200,
137          modifier = Modifier.fillMaxWidth(),
138        )
139      }
140    }
141  }
142  
143  @Composable
144  internal fun RowScope.SingleCardSelectableRadioButtonIconTitleContent(
145    data: SingleCardData.SelectableRadioButton.IconTitle,
146  ) {
147    Row(
148      verticalAlignment = Alignment.CenterVertically,
149      modifier = Modifier
150        .fillMaxWidth()
151        .weight(1f),
152    ) {
153      Icon(
154        data = data.iconData,
155      )
156      Spacer(
157        modifier = Modifier.width(width = AppTheme.dimensions.spacing200),
158      )
159      CustomText(
160        testTag = data.testTag?.let { tag -> tag + "TitleText" },
161        label = data.title,
162        style = AppTheme.typography.bodyLargeMedium,
163        modifier = Modifier.fillMaxWidth(),
164      )
165    }
166  }
167  