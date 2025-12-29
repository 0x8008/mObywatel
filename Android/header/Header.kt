1    package pl.gov.coi.common.ui.ds.header
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.layout.Column
5    import androidx.compose.foundation.layout.Spacer
6    import androidx.compose.foundation.layout.fillMaxWidth
7    import androidx.compose.foundation.layout.height
8    import androidx.compose.runtime.Composable
9    import androidx.compose.ui.Alignment
10   import androidx.compose.ui.Modifier
11   import androidx.compose.ui.tooling.preview.Preview
12   import androidx.compose.ui.tooling.preview.PreviewParameter
13   import pl.gov.coi.common.ui.ds.custom.icon.Icon
14   import pl.gov.coi.common.ui.ds.header.provider.HeaderPreviewParameterProvider
15   import pl.gov.coi.common.ui.text.CustomText
16   import pl.gov.coi.common.ui.theme.AppTheme
17   
18   @Composable
19   fun Header(
20     data: HeaderData,
21   ) {
22     Column(
23       modifier = Modifier
24         .fillMaxWidth()
25         .background(color = AppTheme.colors.background),
26       horizontalAlignment = Alignment.Start,
27     ) {
28       Icon(data = data.iconData)
29       Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing200))
30       CustomText(
31         label = data.title,
32         modifier = Modifier.fillMaxWidth(),
33         style = AppTheme.typography.headlineLargeMedium,
34       )
35       data.message?.let { label ->
36         Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing100))
37         CustomText(
38           label = label,
39           style = AppTheme.typography.bodyLargeRegular,
40           color = AppTheme.colors.neutral200,
41         )
42       }
43     }
44   }
45   
46   @Preview
47   @Composable
48   fun HeaderPreview(
49     @PreviewParameter(HeaderPreviewParameterProvider::class) data: HeaderData,
50   ) {
51     Header(data = data)
52   }
53   