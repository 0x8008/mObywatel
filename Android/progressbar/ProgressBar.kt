1    package pl.gov.coi.common.ui.ds.progressbar
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.layout.Box
5    import androidx.compose.foundation.layout.Column
6    import androidx.compose.foundation.layout.Spacer
7    import androidx.compose.foundation.layout.fillMaxSize
8    import androidx.compose.foundation.layout.fillMaxWidth
9    import androidx.compose.foundation.layout.height
10   import androidx.compose.foundation.layout.padding
11   import androidx.compose.material.LinearProgressIndicator
12   import androidx.compose.runtime.Composable
13   import androidx.compose.runtime.remember
14   import androidx.compose.ui.Alignment
15   import androidx.compose.ui.Modifier
16   import androidx.compose.ui.graphics.StrokeCap
17   import androidx.compose.ui.semantics.semantics
18   import androidx.compose.ui.semantics.testTag
19   import androidx.compose.ui.text.style.TextAlign
20   import androidx.compose.ui.tooling.preview.Preview
21   import androidx.compose.ui.tooling.preview.PreviewParameter
22   import pl.gov.coi.common.ui.ds.progressbar.provider.ProgressBarPreviewParameterProvider
23   import pl.gov.coi.common.ui.text.CustomText
24   import pl.gov.coi.common.ui.theme.AppTheme
25   
26   @Composable
27   fun ProgressBar(
28     data: ProgressBarData,
29   ) {
30     val progress = remember { (data.value.toDouble() / PERCENTAGE).toFloat() }
31     Column(
32       modifier = Modifier
33         .fillMaxWidth()
34         .semantics { testTag = data.testTag ?: "Progress" },
35     ) {
36       if (data is ProgressBarData.IndicatorBar) {
37         CustomText(
38           modifier = Modifier
39             .fillMaxWidth(progress),
40           testTag = data.testTag?.let { tag -> tag + "Text" },
41           label = data.label,
42           style = AppTheme.typography.bodySmallRegular,
43           color = AppTheme.colors.neutral200,
44           textAlign = TextAlign.End,
45         )
46         Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
47       }
48       LinearProgressIndicator(
49         progress = progress,
50         modifier = Modifier
51           .fillMaxWidth(),
52         color = AppTheme.colors.primary900,
53         backgroundColor = AppTheme.colors.neutral30,
54         strokeCap = StrokeCap.Round,
55       )
56     }
57   }
58   
59   @Composable
60   @Preview
61   fun ProgressBarPreview(
62     @PreviewParameter(ProgressBarPreviewParameterProvider::class)
63     progressBarData: ProgressBarData,
64   ) {
65     Box(
66       contentAlignment = Alignment.Center,
67       modifier = Modifier
68         .fillMaxSize()
69         .background(AppTheme.colors.background),
70     ) {
71       Column(modifier = Modifier.padding(AppTheme.dimensions.spacing250)) {
72         ProgressBar(data = progressBarData)
73       }
74     }
75   }
76   
77   private const val PERCENTAGE = 100.00
78   