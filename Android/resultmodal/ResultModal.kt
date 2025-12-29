1    package pl.gov.coi.common.ui.ds.resultmodal
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.layout.Arrangement
5    import androidx.compose.foundation.layout.Column
6    import androidx.compose.foundation.layout.Spacer
7    import androidx.compose.foundation.layout.fillMaxSize
8    import androidx.compose.foundation.layout.height
9    import androidx.compose.foundation.layout.padding
10   import androidx.compose.foundation.layout.wrapContentWidth
11   import androidx.compose.foundation.rememberScrollState
12   import androidx.compose.foundation.verticalScroll
13   import androidx.compose.runtime.Composable
14   import androidx.compose.ui.Alignment
15   import androidx.compose.ui.Modifier
16   import androidx.compose.ui.text.style.TextAlign
17   import androidx.compose.ui.tooling.preview.Preview
18   import androidx.compose.ui.tooling.preview.PreviewParameter
19   import pl.gov.coi.common.ui.ds.button.Button
20   import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIcon
21   import pl.gov.coi.common.ui.ds.custom.icon.Icon
22   import pl.gov.coi.common.ui.ds.resultmodal.provider.ResultModalPreviewParameterProvider
23   import pl.gov.coi.common.ui.text.CustomText
24   import pl.gov.coi.common.ui.theme.AppTheme
25   import pl.gov.coi.common.ui.utils.get
26   
27   @Composable
28   fun ResultModal(data: ResultModalData) {
29     Column(
30       modifier = Modifier
31         .fillMaxSize()
32         .background(AppTheme.colors.background)
33         .padding(horizontal = AppTheme.dimensions.spacing200),
34       horizontalAlignment = Alignment.End,
35     ) {
36       Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing250))
37       ButtonIcon(data = data.closeIconButtonData)
38       Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing250))
39   
40       Column(
41         horizontalAlignment = Alignment.CenterHorizontally,
42       ) {
43         Column(
44           modifier = Modifier
45             .verticalScroll(rememberScrollState())
46             .weight(1F, fill = true)
47             .padding(horizontal = AppTheme.dimensions.spacing250),
48           verticalArrangement = Arrangement.Center,
49           horizontalAlignment = Alignment.CenterHorizontally,
50         ) {
51           Icon(data = data.iconData)
52           Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing300))
53           CustomText(
54             label = data.title,
55             style = AppTheme.typography.titleMedium,
56             textAlign = TextAlign.Center,
57           )
58           Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing400))
59           CustomText(
60             label = data.dataTitle1,
61             style = AppTheme.typography.bodyLargeRegular,
62             color = AppTheme.colors.neutral200,
63             textAlign = TextAlign.Center,
64           )
65           CustomText(
66             label = data.data1,
67             style = AppTheme.typography.subtitleMedium,
68             textAlign = TextAlign.Center,
69           )
70           Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing400))
71           CustomText(
72             label = data.dataTitle2,
73             style = AppTheme.typography.bodyLargeRegular,
74             color = AppTheme.colors.neutral200,
75           )
76           CustomText(
77             label = data.data2,
78             style = AppTheme.typography.subtitleMedium,
79           )
80         }
81   
82         Column(
83           modifier = Modifier.wrapContentWidth(),
84           verticalArrangement = Arrangement.Bottom,
85         ) {
86           data.primaryButton?.let {
87             Button(data = it)
88           }
89           data.secondaryButton?.let {
90             Spacer(
91               modifier = Modifier.height(AppTheme.dimensions.spacing100),
92             )
93             Button(
94               data = it,
95             )
96           }
97           data.tertiaryButton?.let {
98             Spacer(
99               modifier = Modifier.height(AppTheme.dimensions.spacing100),
100            )
101            Button(
102              data = it,
103            )
104          }
105          Spacer(
106            modifier = Modifier.height(AppTheme.dimensions.spacing300),
107          )
108        }
109      }
110    }
111  }
112  
113  @Preview
114  @Composable
115  fun ResultModalPreview(@PreviewParameter(ResultModalPreviewParameterProvider::class) data: ResultModalData) {
116    ResultModal(data = data)
117  }
118  