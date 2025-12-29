1    package pl.gov.coi.common.ui.ds.topappbar
2    
3    import androidx.compose.material3.ExperimentalMaterial3Api
4    import androidx.compose.material3.TopAppBarDefaults
5    import androidx.compose.material3.TopAppBarScrollBehavior
6    import androidx.compose.runtime.Composable
7    import androidx.compose.ui.tooling.preview.Preview
8    import androidx.compose.ui.tooling.preview.PreviewParameter
9    import pl.gov.coi.common.ui.ds.topappbar.large.LargeTopAppBar
10   import pl.gov.coi.common.ui.ds.topappbar.medium.MediumTopAppBar
11   import pl.gov.coi.common.ui.ds.topappbar.small.SmallTopAppBar
12   
13   internal const val TEXT_MAX_ONE_LINE = 1
14   internal const val TEXT_MAX_TWO_LINES = 2
15   
16   @OptIn(ExperimentalMaterial3Api::class)
17   @Composable
18   fun TopAppBar(
19     data: TopAppBarData,
20     scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
21   ) = when (data) {
22     is TopAppBarData.Medium -> MediumTopAppBar(data, scrollBehavior)
23     is TopAppBarData.Large -> LargeTopAppBar(data, scrollBehavior)
24     is TopAppBarData.Small -> SmallTopAppBar(data, scrollBehavior)
25   }
26   
27   @OptIn(ExperimentalMaterial3Api::class)
28   @Preview
29   @Composable
30   fun TopAppBarPreview(
31     @PreviewParameter(TopAppBarPPP::class) data: TopAppBarData,
32   ) {
33     TopAppBar(data = data)
34   }
35   