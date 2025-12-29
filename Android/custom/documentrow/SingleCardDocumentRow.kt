1    package pl.gov.coi.common.ui.ds.custom.documentrow
2    
3    import androidx.compose.foundation.layout.Arrangement
4    import androidx.compose.foundation.layout.Column
5    import androidx.compose.foundation.layout.Row
6    import androidx.compose.foundation.layout.RowScope
7    import androidx.compose.foundation.layout.Spacer
8    import androidx.compose.foundation.layout.defaultMinSize
9    import androidx.compose.foundation.layout.fillMaxWidth
10   import androidx.compose.foundation.layout.height
11   import androidx.compose.foundation.layout.padding
12   import androidx.compose.foundation.layout.width
13   import androidx.compose.foundation.shape.RoundedCornerShape
14   import androidx.compose.material.Text
15   import androidx.compose.material3.Card
16   import androidx.compose.material3.CardDefaults
17   import androidx.compose.runtime.Composable
18   import androidx.compose.runtime.remember
19   import androidx.compose.ui.Alignment
20   import androidx.compose.ui.Modifier
21   import androidx.compose.ui.semantics.semantics
22   import androidx.compose.ui.semantics.testTag
23   import androidx.compose.ui.tooling.preview.Preview
24   import androidx.compose.ui.tooling.preview.PreviewParameter
25   import pl.gov.coi.common.ui.ds.custom.documentrow.provider.ProvidedSingleCardDocumentRowData
26   import pl.gov.coi.common.ui.ds.custom.documentrow.provider.SingleCardDocumentRowPPP
27   import pl.gov.coi.common.ui.ds.custom.icon.Icon
28   import pl.gov.coi.common.ui.ds.singlecard.SINGLE_CARD_MINIMUM_HEIGHT
29   import pl.gov.coi.common.ui.ds.statusbadge.StatusBadge
30   import pl.gov.coi.common.ui.preview.WrappedValue
31   import pl.gov.coi.common.ui.text.CustomText
32   import pl.gov.coi.common.ui.theme.AppTheme
33   import pl.gov.coi.common.ui.utils.MultipleEventsCutter
34   import pl.gov.coi.common.ui.utils.NoRippleInteractionSource
35   import pl.gov.coi.common.ui.utils.get
36   
37   @Composable
38   fun SingleCardDocumentRow(data: DocumentRowData) {
39     val multipleEventsCutter = remember { MultipleEventsCutter.get() }
40   
41     Card(
42       modifier = Modifier.semantics { testTag = data.testTag ?: data.title.tag },
43       colors = CardDefaults.cardColors(containerColor = AppTheme.colors.white),
44       interactionSource = NoRippleInteractionSource(),
45       onClick = { multipleEventsCutter.processEvent { data.onClick() } },
46       shape = RoundedCornerShape(AppTheme.dimensions.spacing200),
47     ) {
48       Row(
49         verticalAlignment = Alignment.CenterVertically,
50         modifier = Modifier
51           .defaultMinSize(minHeight = SINGLE_CARD_MINIMUM_HEIGHT)
52           .fillMaxWidth()
53           .padding(all = AppTheme.dimensions.spacing250),
54       ) {
55         SingleCardClickableContent(data = data)
56   
57         Icon(
58           modifier = Modifier.padding(start = AppTheme.dimensions.spacing200),
59           data = data.trailingIcon,
60         )
61       }
62     }
63   }
64   
65   @Composable
66   private fun RowScope.SingleCardClickableContent(
67     data: DocumentRowData,
68   ) {
69     Row(
70       verticalAlignment = Alignment.CenterVertically,
71       modifier = Modifier
72         .fillMaxWidth()
73         .weight(1f),
74     ) {
75       Icon(
76         data = data.iconData,
77       )
78       Spacer(
79         modifier = Modifier.width(width = AppTheme.dimensions.spacing200),
80       )
81       Column(
82         verticalArrangement = Arrangement.spacedBy(space = AppTheme.dimensions.spacing50),
83         modifier = Modifier
84           .fillMaxWidth()
85           .weight(1f),
86       ) {
87         CustomText(
88           testTag = data.testTag?.let { tag -> tag + "TitleText" },
89           label = data.title,
90           style = AppTheme.typography.bodyLargeMedium,
91           modifier = Modifier.fillMaxWidth(),
92         )
93         data.description?.let { description ->
94           CustomText(
95             testTag = data.testTag?.let { tag -> tag + "DescriptionText" },
96             label = description,
97             style = AppTheme.typography.bodyMediumRegular,
98             modifier = Modifier.fillMaxWidth(),
99           )
100        }
101  
102        data.badgeData?.let { badge ->
103          Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing25))
104          StatusBadge(data = badge)
105        }
106      }
107    }
108  }
109  
110  @Preview
111  @Composable
112  fun SingleCardDocumentRowPreview(
113    @PreviewParameter(SingleCardDocumentRowPPP::class)
114    wrappedValue: WrappedValue<ProvidedSingleCardDocumentRowData>,
115  ) = with(wrappedValue.value()) {
116    Column {
117      Text(
118        modifier = Modifier.padding(AppTheme.dimensions.spacing250),
119        text = previewName,
120      )
121      SingleCardDocumentRow(data = data)
122    }
123  }
124  