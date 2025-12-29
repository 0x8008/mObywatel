1    package pl.gov.coi.common.ui.ds.badge
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.layout.Arrangement
5    import androidx.compose.foundation.layout.Box
6    import androidx.compose.foundation.layout.Column
7    import androidx.compose.foundation.layout.Spacer
8    import androidx.compose.foundation.layout.fillMaxSize
9    import androidx.compose.foundation.layout.height
10   import androidx.compose.foundation.layout.size
11   import androidx.compose.foundation.shape.CircleShape
12   import androidx.compose.material.Text
13   import androidx.compose.runtime.Composable
14   import androidx.compose.ui.Alignment
15   import androidx.compose.ui.Modifier
16   import androidx.compose.ui.draw.clip
17   import androidx.compose.ui.graphics.Color
18   import androidx.compose.ui.tooling.preview.Preview
19   import androidx.compose.ui.tooling.preview.PreviewParameter
20   import pl.gov.coi.common.ui.ds.badge.provider.BadgePreviewParameterProvider
21   import pl.gov.coi.common.ui.theme.AppTheme
22   
23   @Composable
24   fun Badge(
25     data: BadgeData = BadgeData.BadgeDefault,
26   ) {
27     val lightBadgeColor = Color(0xFF900E1D)
28     when (data) {
29       is BadgeData.BadgeDefault -> Box(
30         modifier = Modifier
31           .size(AppTheme.dimensions.spacing100)
32           .clip(CircleShape)
33           .background(lightBadgeColor),
34       )
35     }
36   }
37   
38   @Preview
39   @Composable
40   fun BadgePreview(
41     @PreviewParameter(BadgePreviewParameterProvider::class) data: BadgeData,
42   ) {
43     Column(
44       verticalArrangement = Arrangement.Center,
45       horizontalAlignment = Alignment.CenterHorizontally,
46       modifier = Modifier
47         .fillMaxSize()
48         .background(AppTheme.colors.background),
49     ) {
50       Text("Badge Dot")
51       Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing200))
52       Badge(data = data)
53     }
54   }
55   