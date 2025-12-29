1    package pl.gov.coi.common.ui.ds.supportpage
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.layout.Arrangement
5    import androidx.compose.foundation.layout.Column
6    import androidx.compose.foundation.layout.Spacer
7    import androidx.compose.foundation.layout.fillMaxSize
8    import androidx.compose.foundation.layout.fillMaxWidth
9    import androidx.compose.foundation.layout.height
10   import androidx.compose.foundation.layout.padding
11   import androidx.compose.foundation.layout.wrapContentHeight
12   import androidx.compose.foundation.rememberScrollState
13   import androidx.compose.foundation.verticalScroll
14   import androidx.compose.material.Scaffold
15   import androidx.compose.runtime.Composable
16   import androidx.compose.ui.Alignment
17   import androidx.compose.ui.Modifier
18   import androidx.compose.ui.text.style.TextAlign
19   import androidx.compose.ui.tooling.preview.Preview
20   import androidx.compose.ui.tooling.preview.PreviewParameter
21   import pl.gov.coi.common.ui.ds.button.Button
22   import pl.gov.coi.common.ui.ds.contentbox.ContentBox
23   import pl.gov.coi.common.ui.ds.custom.icon.Icon
24   import pl.gov.coi.common.ui.ds.supportpage.provider.SupportPagePreviewParameterProvider
25   import pl.gov.coi.common.ui.text.CustomText
26   import pl.gov.coi.common.ui.theme.AppTheme
27   import pl.gov.coi.common.ui.topMenu.TopMenu
28   import pl.gov.coi.common.ui.ds.inforow.InfoRowList
29   import pl.gov.coi.common.ui.ds.inforow.model.InfoRowListData
30   
31   @Deprecated("Use BaseScaffold with Header")
32   @Composable
33   fun <CONTENT_DATA> SupportPage(
34     data: SupportPageData<CONTENT_DATA>,
35     content: @Composable (CONTENT_DATA) -> Unit = {},
36   ) {
37     Scaffold(
38       modifier = Modifier.fillMaxSize(),
39       topBar = {
40         TopMenu(
41           label = data.topBarTitle,
42           menuButtonData = data.menuButtonData,
43           mainButtonData = data.mainButtonData,
44         )
45       },
46     ) { contentPadding ->
47       Column(
48         modifier = Modifier
49           .fillMaxSize()
50           .background(color = AppTheme.colors.background)
51           .padding(
52             top = contentPadding.calculateTopPadding(),
53             start = AppTheme.dimensions.spacing250,
54             end = AppTheme.dimensions.spacing250,
55           ),
56         horizontalAlignment = Alignment.CenterHorizontally,
57       ) {
58         Column(
59           modifier = Modifier
60             .fillMaxWidth()
61             .weight(1f)
62             .background(color = AppTheme.colors.background)
63             .verticalScroll(rememberScrollState()),
64           horizontalAlignment = Alignment.CenterHorizontally,
65         ) {
66           Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing200))
67           Icon(data = data.iconData)
68           Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing300))
69           CustomText(
70             label = data.title,
71             modifier = Modifier
72               .padding(horizontal = AppTheme.dimensions.spacing250)
73               .align(alignment = Alignment.CenterHorizontally),
74             style = AppTheme.typography.headlineMedium,
75             textAlign = TextAlign.Center,
76           )
77           data.message?.let {
78             Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing300))
79             CustomText(
80               label = it,
81               modifier = Modifier
82                 .padding(horizontal = AppTheme.dimensions.spacing250)
83                 .align(alignment = Alignment.CenterHorizontally),
84               style = AppTheme.typography.bodyLargeRegular,
85               color = AppTheme.colors.neutral200,
86               textAlign = TextAlign.Center,
87             )
88           }
89           Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing600))
90           content(data.contentData)
91         }
92   
93         data.buttonData?.let {
94           Column(
95             modifier = Modifier
96               .background(color = AppTheme.colors.background)
97               .wrapContentHeight()
98               .fillMaxWidth()
99               .padding(
100                top = AppTheme.dimensions.spacing300,
101                bottom = AppTheme.dimensions.spacing300,
102              ),
103            verticalArrangement = Arrangement.Bottom,
104          ) {
105            Button(data = it)
106          }
107        }
108      }
109    }
110  }
111  
112  @Preview
113  @Composable
114  fun SupportPagePreview(@PreviewParameter(SupportPagePreviewParameterProvider::class) data: SupportPageData<*>) {
115    SupportPage(data = data) {
116      if (it is InfoRowListData) {
117        ContentBox {
118          InfoRowList(data = it)
119        }
120      }
121    }
122  }
123  