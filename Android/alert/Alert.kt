1    package pl.gov.coi.common.ui.ds.alert
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
15   import androidx.compose.ui.draw.clip
16   import androidx.compose.ui.graphics.Color
17   import androidx.compose.ui.semantics.contentDescription
18   import androidx.compose.ui.semantics.semantics
19   import androidx.compose.ui.text.style.TextOverflow
20   import androidx.compose.ui.tooling.preview.Preview
21   import androidx.compose.ui.tooling.preview.PreviewParameter
22   import pl.gov.coi.common.ui.ds.alert.provider.AlertPreviewParameterProvider
23   import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIcon
24   import pl.gov.coi.common.ui.ds.button.buttontext.ButtonText
25   import pl.gov.coi.common.ui.ds.custom.icon.Icon
26   import pl.gov.coi.common.ui.ds.link.Link
27   import pl.gov.coi.common.ui.text.CustomText
28   import pl.gov.coi.common.ui.theme.AppTheme
29   
30   @Composable
31   fun Alert(
32     modifier: Modifier = Modifier,
33     data: AlertData,
34   ) {
35     val lightAlertSuccessColor = Color(0xFFEEFAE1)
36     Box(
37       modifier = modifier
38         .wrapContentHeight()
39         .fillMaxWidth()
40         .clip(shape = AppTheme.shapes.radius200)
41         .background(
42           color = when (data) {
43             is AlertData.Info -> AppTheme.colors.supportBlue20
44             is AlertData.Warning -> AppTheme.colors.supportOrange20
45             is AlertData.Error -> AppTheme.colors.supportRed20
46             is AlertData.Success -> lightAlertSuccessColor
47           },
48         )
49         .semantics(mergeDescendants = true) {
50           contentDescription = data.alertContentDescription.text
51         },
52     ) {
53       Row(
54         modifier = Modifier
55           .fillMaxWidth()
56           .padding(
57             all = AppTheme.dimensions.spacing200,
58           ),
59       ) {
60         Icon(data = data.iconData)
61         Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing200))
62         Column(
63           modifier = Modifier.weight(weight = 1f),
64         ) {
65           data.title?.let { title ->
66             CustomText(
67               testTag = data.testTag?.let { tag -> tag + "TitleText" },
68               label = title,
69               style = AppTheme.typography.bodyLargeMedium,
70               overflow = TextOverflow.Ellipsis,
71               color = AppTheme.colors.neutral500,
72             )
73             Spacer(
74               modifier = Modifier
75                 .fillMaxWidth()
76                 .height(AppTheme.dimensions.spacing50),
77             )
78           }
79           CustomText(
80             testTag = data.testTag?.let { tag -> tag + "BodyText" },
81             label = data.bodyText,
82             style = AppTheme.typography.bodyMediumRegular,
83             color = AppTheme.colors.neutral500,
84           )
85           data.alertButtonData?.let { alertActionButtonData ->
86             Spacer(
87               modifier = Modifier.height(height = AppTheme.dimensions.spacing100),
88             )
89             when (alertActionButtonData) {
90               is AlertButtonData.Link -> Link(data = alertActionButtonData.data)
91               is AlertButtonData.ButtonText -> ButtonText(data = alertActionButtonData.data)
92             }
93           }
94         }
95         data.closeButtonData?.let { buttonData ->
96           Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
97           ButtonIcon(
98             data = buttonData,
99           )
100        }
101      }
102    }
103  }
104  
105  @Preview
106  @Composable
107  fun AlertFullPreview(
108    @PreviewParameter(AlertPreviewParameterProvider::class) data: AlertData,
109  ) {
110    Alert(
111      data = data,
112    )
113  }
114  