1    package pl.gov.coi.common.ui.ds.banner
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.layout.Box
5    import androidx.compose.foundation.layout.Column
6    import androidx.compose.foundation.layout.Row
7    import androidx.compose.foundation.layout.Spacer
8    import androidx.compose.foundation.layout.fillMaxWidth
9    import androidx.compose.foundation.layout.height
10   import androidx.compose.foundation.layout.padding
11   import androidx.compose.foundation.layout.width
12   import androidx.compose.foundation.layout.wrapContentHeight
13   import androidx.compose.runtime.Composable
14   import androidx.compose.ui.Modifier
15   import androidx.compose.ui.graphics.Color
16   import androidx.compose.ui.text.style.TextOverflow
17   import androidx.compose.ui.tooling.preview.Preview
18   import androidx.compose.ui.tooling.preview.PreviewParameter
19   import pl.gov.coi.common.ui.ds.banner.provider.BannerPreviewParameterProvider
20   import pl.gov.coi.common.ui.ds.button.Button
21   import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIcon
22   import pl.gov.coi.common.ui.ds.button.buttontext.ButtonText
23   import pl.gov.coi.common.ui.ds.custom.icon.Icon
24   import pl.gov.coi.common.ui.text.CustomText
25   import pl.gov.coi.common.ui.theme.AppTheme
26   
27   @Deprecated(message = "This component is deprecated, please use DS component Alert.")
28   @Composable
29   fun Banner(
30     data: BannerData,
31   ) {
32     Box(
33       modifier = Modifier
34         .fillMaxWidth()
35         .wrapContentHeight()
36         .background(
37           color = when (data) {
38             is BannerData.Error -> AppTheme.colors.supportRed20
39             is BannerData.HighEmphasisError -> AppTheme.colors.supportRed100
40             is BannerData.HighEmphasisInfo -> AppTheme.colors.supportBlue100
41             is BannerData.Info -> AppTheme.colors.supportBlue20
42           },
43         ),
44     ) {
45       Row(
46         modifier = Modifier
47           .fillMaxWidth()
48           .padding(
49             start = AppTheme.dimensions.spacing200,
50             end = AppTheme.dimensions.spacing200,
51             top = AppTheme.dimensions.spacing200,
52             bottom = AppTheme.dimensions.spacing200,
53           ),
54       ) {
55         Icon(
56           data = data.iconData,
57         )
58         Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing150))
59         Column(
60           modifier = Modifier.weight(weight = 1f),
61         ) {
62           data.title?.let { title ->
63             CustomText(
64               label = title,
65               style = AppTheme.typography.bodyLargeMedium,
66               overflow = TextOverflow.Ellipsis,
67               color = when (data) {
68                 is BannerData.Error, is BannerData.Info -> Color.Black
69                 is BannerData.HighEmphasisError, is BannerData.HighEmphasisInfo -> Color.White
70               },
71             )
72             Spacer(
73               modifier = Modifier
74                 .fillMaxWidth()
75                 .height(AppTheme.dimensions.spacing50),
76             )
77           }
78           CustomText(
79             label = data.bodyText,
80             style = AppTheme.typography.bodyMediumRegular,
81             color = when (data) {
82               is BannerData.Error, is BannerData.Info -> AppTheme.colors.neutral500
83               is BannerData.HighEmphasisError, is BannerData.HighEmphasisInfo -> AppTheme.colors.white
84             },
85           )
86           when (data) {
87             is BannerData.Error -> data.buttonData?.let { buttonTextData ->
88               Spacer(
89                 modifier = Modifier.height(height = AppTheme.dimensions.spacing100),
90               )
91               ButtonText(data = buttonTextData)
92             }
93             is BannerData.HighEmphasisError -> data.buttonData?.let { buttonData ->
94               Spacer(
95                 modifier = Modifier.height(height = AppTheme.dimensions.spacing100),
96               )
97               Button(data = buttonData)
98             }
99             is BannerData.HighEmphasisInfo -> data.buttonData?.let { buttonData ->
100              Spacer(
101                modifier = Modifier.height(height = AppTheme.dimensions.spacing100),
102              )
103              Button(data = buttonData)
104            }
105            is BannerData.Info -> data.buttonData?.let { buttonTextData ->
106              Spacer(
107                modifier = Modifier.height(height = AppTheme.dimensions.spacing100),
108              )
109              ButtonText(data = buttonTextData)
110            }
111          }
112        }
113        data.closeButtonData?.let { buttonData ->
114          Spacer(
115            modifier = Modifier.width(width = AppTheme.dimensions.spacing150),
116          )
117          ButtonIcon(
118            data = buttonData,
119          )
120        }
121      }
122    }
123  }
124  
125  @Preview
126  @Composable
127  fun BannerHighEmphasisErrorFullPreview(
128    @PreviewParameter(BannerPreviewParameterProvider::class) data: BannerData,
129  ) {
130    Banner(
131      data = data,
132    )
133  }
134  