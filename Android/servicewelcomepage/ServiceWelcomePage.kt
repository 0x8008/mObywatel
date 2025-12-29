1    package pl.gov.coi.common.ui.ds.servicewelcomepage
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
18   import androidx.compose.ui.tooling.preview.Preview
19   import androidx.compose.ui.tooling.preview.PreviewParameter
20   import pl.gov.coi.common.ui.ds.alert.Alert
21   import pl.gov.coi.common.ui.ds.button.Button
22   import pl.gov.coi.common.ui.ds.header.Header
23   import pl.gov.coi.common.ui.ds.inforow.InfoRowList
24   import pl.gov.coi.common.ui.ds.inforow.model.InfoRowListData
25   import pl.gov.coi.common.ui.ds.servicewelcomepage.provider.ServiceWelcomePagePreviewParameterProvider
26   import pl.gov.coi.common.ui.pulltorefresh.PullToRefresh
27   import pl.gov.coi.common.ui.theme.AppTheme
28   import pl.gov.coi.common.ui.topMenu.TopMenu
29   
30   @Deprecated("Use BaseScaffold and Header")
31   @Composable
32   fun <CONTENT_DATA> ServiceWelcomePage(
33     data: ServiceWelcomePageData<CONTENT_DATA>,
34     content: @Composable (CONTENT_DATA) -> Unit = {},
35   ) {
36     Scaffold(
37       modifier = Modifier.fillMaxSize(),
38       topBar = {
39         TopMenu(
40           label = data.topBarTitle,
41           menuButtonData = data.menuButtonData,
42           mainButtonData = data.mainButtonData,
43         )
44       },
45     ) { contentPadding ->
46       Column(
47         modifier = Modifier
48           .fillMaxSize()
49           .background(color = AppTheme.colors.background)
50           .padding(
51             top = contentPadding.calculateTopPadding(),
52             start = AppTheme.dimensions.spacing200,
53             end = AppTheme.dimensions.spacing200,
54           ),
55         horizontalAlignment = Alignment.CenterHorizontally,
56       ) {
57         PullToRefresh(
58           modifier = Modifier
59             .fillMaxWidth()
60             .weight(1f)
61             .background(color = AppTheme.colors.background),
62           isEnabled = data.pullToRefreshEnabled,
63           onRefresh = data.refreshAction,
64         ) {
65           Column(
66             modifier = Modifier
67               .fillMaxWidth()
68               .weight(1f)
69               .background(color = AppTheme.colors.background)
70               .verticalScroll(rememberScrollState())
71               .padding(
72                 top = AppTheme.dimensions.spacing100,
73                 bottom = AppTheme.dimensions.spacing200,
74               ),
75           ) {
76             data.alertData?.let {
77               Alert(data = it)
78               Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing200))
79             }
80             Header(data = data.headerData)
81             Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing300))
82             content(data.contentData)
83           }
84         }
85   
86         data.buttonData?.let {
87           Column(
88             modifier = Modifier
89               .background(color = AppTheme.colors.background)
90               .wrapContentHeight()
91               .fillMaxWidth()
92               .padding(
93                 top = AppTheme.dimensions.spacing200,
94                 bottom = AppTheme.dimensions.spacing200,
95               ),
96             verticalArrangement = Arrangement.Bottom,
97           ) {
98             Button(data = it)
99           }
100        }
101      }
102    }
103  }
104  
105  @Preview
106  @Composable
107  fun ServiceWelcomePagePreview(
108    @PreviewParameter(ServiceWelcomePagePreviewParameterProvider::class) data: ServiceWelcomePageData<*>,
109  ) {
110  
111    ServiceWelcomePage(data = data) {
112      if (it is InfoRowListData) {
113        InfoRowList(data = it)
114      }
115    }
116  }
117  