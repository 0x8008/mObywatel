1    package pl.gov.coi.common.ui.ds.emptystate
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.layout.Arrangement
5    import androidx.compose.foundation.layout.Box
6    import androidx.compose.foundation.layout.Column
7    import androidx.compose.foundation.layout.Spacer
8    import androidx.compose.foundation.layout.fillMaxSize
9    import androidx.compose.foundation.layout.fillMaxWidth
10   import androidx.compose.foundation.layout.height
11   import androidx.compose.runtime.Composable
12   import androidx.compose.ui.Alignment
13   import androidx.compose.ui.Modifier
14   import androidx.compose.ui.semantics.isTraversalGroup
15   import androidx.compose.ui.semantics.semantics
16   import androidx.compose.ui.text.style.TextAlign
17   import androidx.compose.ui.tooling.preview.Preview
18   import androidx.compose.ui.tooling.preview.PreviewParameter
19   import pl.gov.coi.common.ui.ds.button.Button
20   import pl.gov.coi.common.ui.ds.emptystate.provider.EmptyStatePreviewParameterProvider
21   import pl.gov.coi.common.ui.text.CustomText
22   import pl.gov.coi.common.ui.theme.AppTheme
23   
24   @Composable
25   fun EmptyState(
26     modifier: Modifier = Modifier,
27     data: EmptyStateData,
28   ) {
29     Column(
30       modifier = modifier
31         .fillMaxWidth()
32         .semantics { isTraversalGroup = true },
33       verticalArrangement = Arrangement.Center,
34       horizontalAlignment = Alignment.CenterHorizontally,
35     ) {
36       data.title?.let { title ->
37         CustomText(
38           label = title,
39           color = AppTheme.colors.neutral500,
40           style = AppTheme.typography.bodyLargeMedium,
41           textAlign = TextAlign.Center,
42         )
43         Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing200))
44       }
45       CustomText(
46         label = data.body,
47         color = AppTheme.colors.neutral200,
48         style = AppTheme.typography.bodyMediumRegular,
49         textAlign = TextAlign.Center,
50       )
51       data.buttonData?.let {
52         Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing200))
53         Button(data = it)
54       }
55     }
56   }
57   
58   @Preview
59   @Composable
60   fun EmptyStatePreview(@PreviewParameter(EmptyStatePreviewParameterProvider::class) data: EmptyStateData) {
61     Box(
62       contentAlignment = Alignment.Center,
63       modifier = Modifier.fillMaxSize().background(AppTheme.colors.background),
64     ) {
65       EmptyState(data = data)
66     }
67   }
68   