1    package pl.gov.coi.common.ui.ds.accordion
2    
3    import androidx.compose.animation.animateContentSize
4    import androidx.compose.animation.core.LinearOutSlowInEasing
5    import androidx.compose.animation.core.tween
6    import androidx.compose.foundation.clickable
7    import androidx.compose.foundation.layout.Arrangement
8    import androidx.compose.foundation.layout.Box
9    import androidx.compose.foundation.layout.Column
10   import androidx.compose.foundation.layout.Row
11   import androidx.compose.foundation.layout.Spacer
12   import androidx.compose.foundation.layout.fillMaxWidth
13   import androidx.compose.foundation.layout.heightIn
14   import androidx.compose.foundation.layout.padding
15   import androidx.compose.foundation.layout.width
16   import androidx.compose.material.Card
17   import androidx.compose.material.Divider
18   import androidx.compose.runtime.Composable
19   import androidx.compose.runtime.getValue
20   import androidx.compose.runtime.mutableStateOf
21   import androidx.compose.runtime.remember
22   import androidx.compose.runtime.setValue
23   import androidx.compose.ui.Alignment
24   import androidx.compose.ui.Modifier
25   import androidx.compose.ui.semantics.Role
26   import androidx.compose.ui.semantics.role
27   import androidx.compose.ui.semantics.semantics
28   import androidx.compose.ui.semantics.stateDescription
29   import androidx.compose.ui.tooling.preview.Preview
30   import androidx.compose.ui.tooling.preview.PreviewParameter
31   import androidx.compose.ui.unit.dp
32   import pl.gov.coi.common.domain.label.CommonUILabelProvider
33   import pl.gov.coi.common.domain.label.Label
34   import pl.gov.coi.common.ui.R
35   import pl.gov.coi.common.ui.ds.accordion.provider.AccordionPreviewParameterProvider
36   import pl.gov.coi.common.ui.ds.custom.icon.Icon
37   import pl.gov.coi.common.ui.ds.custom.icon.IconData
38   import pl.gov.coi.common.ui.ds.custom.icon.IconSize
39   import pl.gov.coi.common.ui.text.CustomText
40   import pl.gov.coi.common.ui.theme.AppTheme
41   import pl.gov.coi.common.ui.utils.NoRippleInteractionSource
42   
43   private val MIN_ACCORDION_ROW_HEIGHT = 48.dp
44   
45   @Composable
46   fun Accordion(
47     data: AccordionData,
48   ) {
49     Card(
50       shape = AppTheme.shapes.radius200,
51       elevation = AppTheme.elevations.level0,
52     ) {
53       Column {
54         data.elements.forEachIndexed { index, element ->
55           AccordionSingle(
56             data = element,
57           )
58           if (index != data.elements.size - 1) {
59             AccordionDivider()
60           }
61         }
62       }
63     }
64   }
65   
66   @Composable
67   private fun AccordionSingle(
68     data: AccordionElement,
69   ) {
70     var expanded by remember { mutableStateOf(data.initialExpanded) }
71   
72     val stateDesc = if (expanded) {
73       CommonUILabelProvider.expandedLabel().text
74     } else {
75       CommonUILabelProvider.notExpandedLabel().text
76     }
77   
78     Column(
79       verticalArrangement = Arrangement.Center,
80       modifier = Modifier
81         .fillMaxWidth()
82         .animateContentSize(
83           animationSpec = tween(
84             easing = LinearOutSlowInEasing,
85           ),
86         ),
87     ) {
88       Row(
89         verticalAlignment = Alignment.CenterVertically,
90         modifier = Modifier
91           .padding(
92             top = AppTheme.dimensions.spacing200,
93             start = AppTheme.dimensions.spacing200,
94             end = AppTheme.dimensions.spacing200,
95             bottom = if (!expanded) {
96               AppTheme.dimensions.spacing200
97             } else {
98               AppTheme.dimensions.zero
99             },
100          )
101          .heightIn(min = MIN_ACCORDION_ROW_HEIGHT)
102          .semantics {
103            stateDescription = stateDesc
104            role = Role.Button
105          }
106          .clickable(
107            indication = null,
108            interactionSource = NoRippleInteractionSource(),
109            onClick = {
110              expanded = !expanded
111              data.onListExpanded(expanded)
112            },
113          ),
114      ) {
115        CustomText(
116          label = data.header,
117          style = AppTheme.typography.bodyLargeMedium,
118          color = AppTheme.colors.neutral500,
119          modifier = Modifier
120            .fillMaxWidth()
121            .weight(weight = 1F),
122        )
123        Spacer(
124          modifier = Modifier
125            .width(AppTheme.dimensions.spacing100),
126        )
127        Icon(
128          data = IconData.Standard(
129            iconResId = when (expanded) {
130              true -> R.drawable.ab007_chevron_up
131              else -> R.drawable.ab008_chevron_down
132            },
133            iconSize = IconSize.SIZE24,
134            iconColorProvider = { AppTheme.colors.neutral200 },
135            contentDescription = Label.EMPTY,
136          ),
137        )
138      }
139      if (expanded) {
140        Box(
141          modifier = Modifier
142            .padding(
143              all = if (data.addContentPadding) {
144                AppTheme.dimensions.spacing200
145              } else {
146                AppTheme.dimensions.zero
147              },
148            ),
149        ) {
150          data.content.Content()
151        }
152      }
153    }
154  }
155  
156  @Composable
157  private fun AccordionDivider() {
158    Divider(
159      modifier = Modifier.padding(
160        horizontal = AppTheme.dimensions.spacing200,
161      ),
162      thickness = AppTheme.dimensions.strokeWidth,
163      color = AppTheme.colors.neutral30,
164    )
165  }
166  
167  @Preview
168  @Composable
169  fun AccordionPreview(
170    @PreviewParameter(provider = AccordionPreviewParameterProvider::class)
171    data: AccordionData,
172  ) {
173    Accordion(data = data)
174  }
175  