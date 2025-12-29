1    package pl.gov.coi.common.ui.ds.pagecontroller
2    
3    import androidx.compose.foundation.ExperimentalFoundationApi
4    import androidx.compose.foundation.background
5    import androidx.compose.foundation.layout.Arrangement
6    import androidx.compose.foundation.layout.Box
7    import androidx.compose.foundation.layout.Column
8    import androidx.compose.foundation.layout.Row
9    import androidx.compose.foundation.layout.Spacer
10   import androidx.compose.foundation.layout.fillMaxSize
11   import androidx.compose.foundation.layout.fillMaxWidth
12   import androidx.compose.foundation.layout.height
13   import androidx.compose.foundation.layout.padding
14   import androidx.compose.foundation.pager.HorizontalPager
15   import androidx.compose.foundation.pager.rememberPagerState
16   import androidx.compose.runtime.Composable
17   import androidx.compose.runtime.rememberCoroutineScope
18   import androidx.compose.ui.Alignment
19   import androidx.compose.ui.Modifier
20   import androidx.compose.ui.tooling.preview.Preview
21   import androidx.compose.ui.tooling.preview.PreviewParameter
22   import kotlinx.coroutines.launch
23   import pl.gov.coi.common.ui.ds.button.Button
24   import pl.gov.coi.common.ui.ds.button.ButtonData
25   import pl.gov.coi.common.ui.ds.button.common.ButtonSize
26   import pl.gov.coi.common.ui.ds.button.common.ButtonType
27   import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
28   import pl.gov.coi.common.ui.ds.pagecontroller.provider.PageControllerPreviewParameterProvider
29   import pl.gov.coi.common.ui.ds.pageindicator.PageIndicator
30   import pl.gov.coi.common.ui.ds.smallcard.SmallCard
31   import pl.gov.coi.common.ui.ds.smallcard.SmallCardData
32   import pl.gov.coi.common.ui.onboarding.OnboardingPage
33   import pl.gov.coi.common.ui.onboarding.model.OnboardingPageData
34   import pl.gov.coi.common.ui.theme.AppTheme
35   
36   @OptIn(ExperimentalFoundationApi::class)
37   @Composable
38   fun <CONTENT_DATA> PageController(
39     data: PageControllerData<CONTENT_DATA>,
40     contents: @Composable (CONTENT_DATA) -> Unit = { },
41   ) {
42     val coroutineScope = rememberCoroutineScope()
43   
44     Column(
45       modifier = Modifier
46         .fillMaxSize()
47         .background(color = AppTheme.colors.background)
48         .padding(
49           vertical = AppTheme.dimensions.spacing500,
50         ),
51     ) {
52       val pageCount = data.contentsData.size
53       val pagerState = rememberPagerState(
54         pageCount = { pageCount },
55       )
56       HorizontalPager(
57         state = pagerState,
58         modifier = Modifier
59           .fillMaxSize()
60           .weight(10f),
61       ) { page ->
62         Box(
63           modifier = Modifier
64             .fillMaxSize(),
65           contentAlignment = Alignment.Center,
66         ) {
67           contents(data.contentsData[page].content)
68         }
69       }
70       PageIndicator(pagerState = pagerState)
71       Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing250))
72       Column(
73         modifier = Modifier.weight(1f),
74       ) {
75         data.contentsData[pagerState.currentPage].let { pageData ->
76           if (pageData.isButtonVisible) {
77             Row(
78               Modifier
79                 .padding(
80                   horizontal = AppTheme.dimensions.spacing200,
81                 )
82                 .fillMaxWidth(),
83               horizontalArrangement = Arrangement.Center,
84             ) {
85               Button(
86                 data = ButtonData(
87                   buttonSize = ButtonSize.Large(),
88                   buttonVariant = ButtonVariant.Primary,
89                   buttonType = ButtonType.WithText(
90                     label = pageData.buttonTitle,
91                   ),
92                   onClick = {
93                     when (pageData.buttonAction) {
94                       PageControllerData.PageData.ButtonAction.GoToNextPage -> coroutineScope.launch {
95                         pagerState.animateScrollToPage(pagerState.currentPage + 1)
96                       }
97                       is PageControllerData.PageData.ButtonAction.Custom -> pageData.buttonAction.invoke()
98                     }
99                   },
100                ),
101              )
102            }
103          }
104        }
105      }
106    }
107  }
108  
109  @Preview
110  @Composable
111  fun PageControllerPreview(
112    @PreviewParameter(PageControllerPreviewParameterProvider::class) data: PageControllerData<*>,
113  ) {
114    PageController(
115      data = data,
116      contents = { contentData ->
117        when (contentData) {
118          is SmallCardData -> SmallCard(data = contentData)
119          is OnboardingPageData -> OnboardingPage(page = contentData)
120        }
121      },
122    )
123  }
124  