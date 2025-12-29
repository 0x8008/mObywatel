1    package pl.gov.coi.common.ui.ds.inforow
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.layout.Box
5    import androidx.compose.foundation.layout.Column
6    import androidx.compose.foundation.layout.Spacer
7    import androidx.compose.foundation.layout.height
8    import androidx.compose.foundation.layout.padding
9    import androidx.compose.foundation.layout.wrapContentHeight
10   import androidx.compose.runtime.Composable
11   import androidx.compose.ui.Modifier
12   import androidx.compose.ui.tooling.preview.Preview
13   import androidx.compose.ui.tooling.preview.PreviewParameter
14   import androidx.compose.ui.unit.Dp
15   import pl.gov.coi.common.ui.ds.inforow.model.InfoRowData
16   import pl.gov.coi.common.ui.ds.inforow.model.InfoRowListData
17   import pl.gov.coi.common.ui.ds.inforow.provider.InfoRowPPP
18   import pl.gov.coi.common.ui.theme.AppTheme
19   
20   @Composable
21   fun InfoRowList(
22     data: InfoRowListData,
23     spaceBetween: Dp = AppTheme.dimensions.spacing200,
24   ) {
25     Column(
26       modifier = Modifier
27         .wrapContentHeight(),
28     ) {
29       data.items.forEachIndexed { index, stepData ->
30         when (stepData) {
31           is InfoRowData.Default -> DefaultInfoRow(data = stepData)
32           is InfoRowData.Bullet -> BulletInfoRow(data = stepData)
33         }
34         if (index != data.items.lastIndex) {
35           Spacer(
36             modifier = Modifier.height(
37               height = spaceBetween,
38             ),
39           )
40         }
41       }
42     }
43   }
44   
45   @Composable
46   @Preview
47   fun InfoRowListPreview(@PreviewParameter(InfoRowPPP::class) data: InfoRowListData) {
48     Box(
49       modifier = Modifier
50         .background(AppTheme.colors.background)
51         .padding(horizontal = AppTheme.dimensions.spacing200),
52     ) {
53       InfoRowList(data)
54     }
55   }
56   