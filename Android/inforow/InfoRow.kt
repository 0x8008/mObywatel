1    package pl.gov.coi.common.ui.ds.inforow
2    
3    import androidx.compose.foundation.layout.Column
4    import androidx.compose.foundation.layout.Row
5    import androidx.compose.foundation.layout.Spacer
6    import androidx.compose.foundation.layout.fillMaxWidth
7    import androidx.compose.foundation.layout.height
8    import androidx.compose.foundation.layout.width
9    import androidx.compose.runtime.Composable
10   import androidx.compose.ui.Modifier
11   import pl.gov.coi.common.ui.ds.custom.icon.Icon
12   import pl.gov.coi.common.ui.ds.inforow.model.InfoRowData
13   import pl.gov.coi.common.ui.text.CustomText
14   import pl.gov.coi.common.ui.theme.AppTheme
15   
16   @Composable
17   internal fun DefaultInfoRow(
18     data: InfoRowData.Default,
19   ) {
20     Row(
21       modifier = Modifier
22         .fillMaxWidth(),
23     ) {
24       Icon(data = data.icon)
25       Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing100))
26       Column {
27         CustomText(
28           label = data.title,
29           style = AppTheme.typography.bodyLargeMedium,
30           color = AppTheme.colors.neutral500,
31         )
32         Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
33         CustomText(
34           label = data.description,
35           style = AppTheme.typography.bodyMediumRegular,
36           color = AppTheme.colors.neutral200,
37         )
38       }
39     }
40   }
41   
42   @Composable
43   internal fun BulletInfoRow(
44     data: InfoRowData.Bullet,
45   ) {
46     Row(modifier = Modifier.fillMaxWidth()) {
47       Icon(data = data.icon)
48       Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing100))
49       CustomText(
50         label = data.description,
51         style = AppTheme.typography.bodyLargeRegular,
52         color = AppTheme.colors.neutral200,
53       )
54     }
55   }
56   