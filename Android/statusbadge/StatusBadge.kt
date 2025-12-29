1    package pl.gov.coi.common.ui.ds.statusbadge
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.border
5    import androidx.compose.foundation.layout.Arrangement
6    import androidx.compose.foundation.layout.Box
7    import androidx.compose.foundation.layout.Row
8    import androidx.compose.foundation.layout.fillMaxWidth
9    import androidx.compose.foundation.layout.padding
10   import androidx.compose.foundation.layout.size
11   import androidx.compose.runtime.Composable
12   import androidx.compose.ui.Alignment
13   import androidx.compose.ui.Modifier
14   import androidx.compose.ui.graphics.Color
15   import androidx.compose.ui.semantics.contentDescription
16   import androidx.compose.ui.semantics.semantics
17   import androidx.compose.ui.text.style.TextOverflow
18   import androidx.compose.ui.tooling.preview.Preview
19   import androidx.compose.ui.tooling.preview.PreviewParameter
20   import pl.gov.coi.common.domain.label.Label
21   import pl.gov.coi.common.ui.R
22   import pl.gov.coi.common.ui.ds.custom.icon.Icon
23   import pl.gov.coi.common.ui.ds.custom.icon.IconData
24   import pl.gov.coi.common.ui.ds.custom.icon.IconSize
25   import pl.gov.coi.common.ui.text.CustomText
26   import pl.gov.coi.common.ui.theme.AppTheme
27   
28   @Composable
29   fun StatusBadge(
30     data: StatusBadgeData,
31   ) {
32     val modifier = if (data.withBorder) {
33       Modifier
34         .border(
35           width = AppTheme.dimensions.strokeWidth,
36           color = AppTheme.colors.neutral60,
37           shape = AppTheme.shapes.radius300,
38         )
39         .background(
40           color = AppTheme.colors.white,
41           shape = AppTheme.shapes.radius300,
42         )
43         .padding(all = AppTheme.dimensions.spacing100)
44     } else {
45       Modifier
46     }
47     Row(
48       modifier = modifier.semantics {
49         contentDescription = "${data.contentDescription.text} ${data.label.text}"
50       },
51       horizontalArrangement = Arrangement.spacedBy(space = AppTheme.dimensions.spacing50),
52       verticalAlignment = Alignment.CenterVertically,
53     ) {
54       when (data) {
55         is StatusBadgeData.WithIcon -> Icon(
56           data = IconData.Standard(
57             testTag = data.testTag?.let { tag -> tag + "Icon" },
58             iconResId = data.status.getIconResId(),
59             contentDescription = Label.EMPTY,
60             iconColorProvider = { data.status.getIconColor() },
61             iconSize = IconSize.SIZE16,
62           ),
63         )
64   
65         is StatusBadgeData.WithDot -> DotIcon(data = data)
66       }
67       CustomText(
68         testTag = data.testTag?.let { tag -> tag + "Text" },
69         maxLines = data.maxLines,
70         label = data.label,
71         color = AppTheme.colors.neutral500,
72         style = AppTheme.typography.bodySmallRegular.takeIf { data.withBorder }
73           ?: AppTheme.typography.bodyLargeMedium,
74         focusable = false,
75         overflow = TextOverflow.Ellipsis,
76       )
77     }
78   }
79   
80   @Composable
81   internal fun DotIcon(
82     data: StatusBadgeData.WithDot,
83   ) {
84     Box(
85       modifier = Modifier.size(AppTheme.dimensions.spacing200),
86       contentAlignment = Alignment.Center,
87     ) {
88       Icon(
89         data = IconData.Standard(
90           testTag = data.testTag?.let { tag -> tag + "Icon" },
91           iconResId = R.drawable.e003_badge,
92           contentDescription = Label.EMPTY,
93           iconColorProvider = { data.status.getIconColor() },
94           iconSize = IconSize.SIZE8,
95         ),
96       )
97     }
98   }
99   
100  private fun StatusBadgeWithIconStatus.getIconResId() =
101    when (this) {
102      StatusBadgeWithIconStatus.POSITIVE -> R.drawable.b009_check_mark
103      StatusBadgeWithIconStatus.INFORMATIVE -> R.drawable.b008_info
104      StatusBadgeWithIconStatus.NEGATIVE -> R.drawable.b010_x_mark
105      StatusBadgeWithIconStatus.NOTICE -> R.drawable.b012_notice_mark
106      StatusBadgeWithIconStatus.MINUS -> R.drawable.b007_minus
107    }
108  
109  @Composable
110  private fun StatusBadgeWithIconStatus.getIconColor() = when (this) {
111    StatusBadgeWithIconStatus.POSITIVE -> AppTheme.colors.supportGreen100
112    StatusBadgeWithIconStatus.INFORMATIVE -> AppTheme.colors.supportBlue100
113    StatusBadgeWithIconStatus.NEGATIVE -> AppTheme.colors.supportRed100
114    StatusBadgeWithIconStatus.NOTICE -> Color.Unspecified
115    StatusBadgeWithIconStatus.MINUS -> AppTheme.colors.neutral200
116  }
117  
118  @Composable
119  private fun StatusBadgeWithDotStatus.getIconColor() = when (this) {
120    StatusBadgeWithDotStatus.POSITIVE -> AppTheme.colors.supportGreen100
121    StatusBadgeWithDotStatus.INFORMATIVE -> AppTheme.colors.supportBlue100
122    StatusBadgeWithDotStatus.NEGATIVE -> AppTheme.colors.supportRed100
123    StatusBadgeWithDotStatus.WARNING -> AppTheme.colors.supportOrange100
124  }
125  
126  @Composable
127  @Preview
128  fun StatusBadgePreview(@PreviewParameter(StatusBadgePreviewProvider::class) data: StatusBadgeData) {
129    Box(
130      modifier = Modifier
131        .fillMaxWidth()
132        .background(color = AppTheme.colors.background)
133        .padding(all = AppTheme.dimensions.spacing200),
134    ) {
135      StatusBadge(
136        data = data,
137      )
138    }
139  }
140  