1    package pl.gov.coi.common.ui.ds.inputdatetime
2    
3    import androidx.compose.foundation.BorderStroke
4    import androidx.compose.foundation.background
5    import androidx.compose.foundation.clickable
6    import androidx.compose.foundation.layout.Arrangement
7    import androidx.compose.foundation.layout.Box
8    import androidx.compose.foundation.layout.Column
9    import androidx.compose.foundation.layout.Row
10   import androidx.compose.foundation.layout.fillMaxWidth
11   import androidx.compose.foundation.layout.padding
12   import androidx.compose.foundation.layout.wrapContentHeight
13   import androidx.compose.material3.Card
14   import androidx.compose.material3.CardDefaults
15   import androidx.compose.material3.Text
16   import androidx.compose.runtime.Composable
17   import androidx.compose.runtime.remember
18   import androidx.compose.ui.Alignment
19   import androidx.compose.ui.Modifier
20   import androidx.compose.ui.graphics.Color
21   import androidx.compose.ui.semantics.disabled
22   import androidx.compose.ui.semantics.isTraversalGroup
23   import androidx.compose.ui.semantics.semantics
24   import androidx.compose.ui.semantics.testTag
25   import androidx.compose.ui.text.style.TextOverflow
26   import androidx.compose.ui.tooling.preview.Preview
27   import androidx.compose.ui.tooling.preview.PreviewParameter
28   import pl.gov.coi.common.domain.validators.ValidationState
29   import pl.gov.coi.common.ui.ds.custom.icon.Icon
30   import pl.gov.coi.common.ui.ds.custom.icon.IconData
31   import pl.gov.coi.common.ui.ds.custom.icon.IconSize
32   import pl.gov.coi.common.ui.ds.errortext.ErrorText
33   import pl.gov.coi.common.ui.ds.helpertext.HelperText
34   import pl.gov.coi.common.ui.ds.inputdatetime.provider.InputDateTimePreviewParameterProvider
35   import pl.gov.coi.common.ui.text.CustomText
36   import pl.gov.coi.common.ui.theme.AppTheme
37   import pl.gov.coi.common.ui.utils.MultipleEventsCutter
38   import pl.gov.coi.common.ui.utils.get
39   
40   @Composable
41   fun InputDateTime(
42     data: InputDateTimeData,
43   ) {
44     val multipleEventsCutter = remember { MultipleEventsCutter.get() }
45   
46     Column(
47       modifier = Modifier
48         .semantics { isTraversalGroup = true }
49         .fillMaxWidth()
50         .wrapContentHeight(),
51     ) {
52       CustomText(
53         label = data.label,
54         style = AppTheme.typography.bodyMediumRegular,
55         color = if (data.enabled) {
56           AppTheme.colors.neutral200
57         } else {
58           AppTheme.colors.neutral60
59         },
60       )
61       Card(
62         modifier = Modifier
63           .padding(vertical = AppTheme.dimensions.spacing50)
64           .semantics {
65             if (data.enabled.not()) disabled()
66             testTag = data.label.text + "Value"
67           }
68           .clickable(
69             enabled = data.enabled,
70             onClick = {
71               multipleEventsCutter.processEvent {
72                 data.onClick()
73               }
74             },
75           ),
76         border = BorderStroke(
77           width = AppTheme.dimensions.strokeWidth,
78           color = when {
79             data.validationState is ValidationState.Invalid -> AppTheme.colors.supportRed100
80             data.enabled.not() -> AppTheme.colors.neutral30
81             else -> AppTheme.colors.neutral80
82           },
83         ),
84         shape = AppTheme.shapes.radius50,
85         elevation = CardDefaults.cardElevation(defaultElevation = AppTheme.elevations.level0),
86       ) {
87         Row(
88           modifier = Modifier
89             .background(color = Color.White)
90             .padding(all = AppTheme.dimensions.spacing200)
91             .fillMaxWidth(),
92           horizontalArrangement = Arrangement.spacedBy(space = AppTheme.dimensions.spacing100),
93           verticalAlignment = Alignment.CenterVertically,
94         ) {
95           Text(
96             modifier = Modifier.weight(weight = 1f),
97             text = data.inputText?.takeIf { it.isNotBlank() } ?: data.type.placeholder,
98             maxLines = 1,
99             overflow = TextOverflow.Ellipsis,
100            style = AppTheme.typography.bodyLargeRegular,
101            color = when {
102              data.enabled.not() -> AppTheme.colors.neutral60
103              data.inputText.isNullOrBlank() -> AppTheme.colors.neutral100
104              else -> AppTheme.colors.neutral500
105            },
106          )
107          Icon(
108            data = IconData.Standard(
109              iconResId = data.type.iconResId,
110              iconSize = IconSize.SIZE24,
111              iconColorProvider = {
112                if (data.enabled) {
113                  AppTheme.colors.neutral200
114                } else {
115                  AppTheme.colors.neutral60
116                }
117              },
118              contentDescription = null,
119            ),
120          )
121        }
122      }
123      if (data.validationState is ValidationState.Invalid) {
124        ErrorText(errorText = data.validationState.message)
125      } else {
126        data.helperText?.let { text ->
127          HelperText(helperLabel = text)
128        }
129      }
130    }
131  }
132  
133  @Preview
134  @Composable
135  fun InputDateTimePreview(
136    @PreviewParameter(InputDateTimePreviewParameterProvider::class)
137    data: InputDateTimeData,
138  ) {
139    Box(modifier = Modifier.background(color = AppTheme.colors.white)) {
140      InputDateTime(data = data)
141    }
142  }
143  