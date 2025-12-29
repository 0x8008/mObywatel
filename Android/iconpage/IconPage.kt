1    package pl.gov.coi.common.ui.ds.iconpage
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.layout.Arrangement
5    import androidx.compose.foundation.layout.Column
6    import androidx.compose.foundation.layout.Spacer
7    import androidx.compose.foundation.layout.fillMaxSize
8    import androidx.compose.foundation.layout.fillMaxWidth
9    import androidx.compose.foundation.layout.height
10   import androidx.compose.foundation.layout.padding
11   import androidx.compose.foundation.rememberScrollState
12   import androidx.compose.foundation.verticalScroll
13   import androidx.compose.runtime.Composable
14   import androidx.compose.ui.Alignment
15   import androidx.compose.ui.Modifier
16   import androidx.compose.ui.text.style.TextAlign
17   import androidx.compose.ui.tooling.preview.Preview
18   import androidx.compose.ui.tooling.preview.PreviewParameter
19   import pl.gov.coi.common.domain.label.toLabel
20   import pl.gov.coi.common.ui.R
21   import pl.gov.coi.common.ui.ds.button.Button
22   import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
23   import pl.gov.coi.common.ui.ds.custom.icon.Icon
24   import pl.gov.coi.common.ui.ds.inforow.InfoRowList
25   import pl.gov.coi.common.ui.ds.inforow.model.InfoRowListData
26   import pl.gov.coi.common.ui.text.CustomText
27   import pl.gov.coi.common.ui.theme.AppTheme
28   import pl.gov.coi.common.ui.topMenu.TopMenu
29   
30   @Composable
31   fun <CONTENT_DATA, BOTTOM_CONTENT> IconPage(
32     data: IconPageData<CONTENT_DATA, BOTTOM_CONTENT>,
33     content: @Composable (CONTENT_DATA) -> Unit = {},
34     bottomContent: @Composable (BOTTOM_CONTENT) -> Unit = {},
35   ) {
36     Column(
37       modifier = Modifier
38         .fillMaxSize()
39         .background(AppTheme.colors.background)
40         .padding(horizontal = AppTheme.dimensions.spacing200)
41         .then(
42           other = if (data.bottomContent != null) {
43             Modifier.padding(vertical = AppTheme.dimensions.spacing200)
44           } else {
45             Modifier
46           },
47         ),
48     ) {
49       Column(
50         modifier = Modifier
51           .fillMaxWidth()
52           .verticalScroll(state = rememberScrollState())
53           .weight(weight = 1F),
54         verticalArrangement = Arrangement.Center,
55         horizontalAlignment = Alignment.CenterHorizontally,
56       ) {
57         if (data.content != null) Spacer(Modifier.height(height = AppTheme.dimensions.spacing100))
58         Icon(
59           data = data.iconSection.icon,
60         )
61         Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing200))
62         CustomText(
63           label = data.title,
64           style = AppTheme.typography.headlineMedium,
65           textAlign = TextAlign.Center,
66           color = AppTheme.colors.neutral500,
67         )
68   
69         data.descriptionFirst?.let { descriptionFirst ->
70           Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing200))
71           CustomText(
72             label = descriptionFirst,
73             style = AppTheme.typography.bodyLargeRegular,
74             textAlign = TextAlign.Center,
75             color = AppTheme.colors.neutral200,
76           )
77         }
78   
79         data.descriptionSecond?.let { descriptionSecond ->
80           Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing200))
81           CustomText(
82             label = descriptionSecond,
83             style = AppTheme.typography.bodyLargeRegular,
84             textAlign = TextAlign.Center,
85             color = AppTheme.colors.neutral200,
86           )
87         }
88   
89         data.content?.let { content ->
90           Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing200))
91           content(content)
92         }
93       }
94   
95       data.bottomContent?.let { bottomContent ->
96         Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing200))
97         bottomContent(bottomContent)
98       }
99     }
100  }
101  
102  @Preview
103  @Composable
104  fun IconPagePreview(
105    @PreviewParameter(
106      IconPagePreviewProvider::class,
107    ) data: IconPageData<*, *>,
108  ) {
109    Column(
110      modifier = Modifier
111        .fillMaxSize()
112        .background(color = AppTheme.colors.background),
113    ) {
114      TopMenu(
115        label = "IconPage 1.1.0".toLabel(tag = "topMenuLabel"),
116        mainButtonData = ButtonIconData(
117  
118          iconResId = R.drawable.ab004_arrow_left,
119          iconColorProvider = { AppTheme.colors.neutral200 },
120          onClick = { },
121        ),
122      )
123      IconPage(
124        data = data,
125        content = { contentData ->
126          if (contentData is InfoRowListData) InfoRowList(data = contentData)
127        },
128        bottomContent = { bottomContentData ->
129          if (bottomContentData is IconPageBottomContentData) {
130            Button(data = bottomContentData.primaryButtonData)
131            bottomContentData.secondaryButtonData?.let { secondaryButtonData ->
132              Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing150))
133              Button(data = secondaryButtonData)
134            }
135          }
136        },
137      )
138    }
139  }
140  