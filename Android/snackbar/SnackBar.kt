1    package pl.gov.coi.common.ui.ds.snackbar
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.layout.Box
5    import androidx.compose.foundation.layout.Row
6    import androidx.compose.foundation.layout.Spacer
7    import androidx.compose.foundation.layout.fillMaxSize
8    import androidx.compose.foundation.layout.fillMaxWidth
9    import androidx.compose.foundation.layout.padding
10   import androidx.compose.foundation.layout.width
11   import androidx.compose.material3.Card
12   import androidx.compose.material3.CardDefaults
13   import androidx.compose.runtime.Composable
14   import androidx.compose.ui.Alignment
15   import androidx.compose.ui.Modifier
16   import androidx.compose.ui.semantics.contentDescription
17   import androidx.compose.ui.semantics.semantics
18   import androidx.compose.ui.text.style.TextOverflow
19   import androidx.compose.ui.tooling.preview.Preview
20   import androidx.compose.ui.tooling.preview.PreviewParameter
21   import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIcon
22   import pl.gov.coi.common.ui.ds.snackbar.provider.SnackBarPreviewParameterProvider
23   import pl.gov.coi.common.ui.text.CustomText
24   import pl.gov.coi.common.ui.theme.AppTheme
25   
26   @Composable
27   fun SnackBar(data: SnackBarData) {
28     Card(
29       modifier = Modifier.semantics { contentDescription = data.messageLabel.text },
30       shape = AppTheme.shapes.radius50,
31       colors = CardDefaults.cardColors(containerColor = AppTheme.colors.neutral200),
32       elevation = CardDefaults.cardElevation(defaultElevation = AppTheme.elevations.level0),
33     ) {
34       Row(
35         modifier = Modifier
36           .fillMaxWidth()
37           .padding(all = AppTheme.dimensions.spacing200),
38       ) {
39         CustomText(
40           label = data.messageLabel,
41           modifier = Modifier
42             .weight(weight = 1f)
43             .align(Alignment.CenterVertically),
44           style = AppTheme.typography.bodyMediumRegular,
45           color = AppTheme.colors.white,
46           overflow = TextOverflow.Ellipsis,
47         )
48   
49         when (data) {
50           is SnackBarData.Default -> Unit
51           is SnackBarData.DefaultWithIcon -> {
52             Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing150))
53             Box(contentAlignment = Alignment.TopCenter) {
54               ButtonIcon(data = data.iconButtonData)
55             }
56           }
57         }
58       }
59     }
60   }
61   
62   @Preview
63   @Composable
64   fun SnackBarPreview(
65     @PreviewParameter(SnackBarPreviewParameterProvider::class) data: SnackBarData,
66   ) {
67     Box(
68       modifier = Modifier
69         .fillMaxSize()
70         .background(color = AppTheme.colors.background)
71         .padding(all = AppTheme.dimensions.spacing200),
72       contentAlignment = Alignment.BottomCenter,
73     ) {
74       SnackBar(data = data)
75     }
76   }
77   