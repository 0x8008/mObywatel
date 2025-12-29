1    package pl.gov.coi.common.ui.ds.topappbar.large
2    
3    import androidx.compose.foundation.layout.Arrangement
4    import androidx.compose.foundation.layout.Row
5    import androidx.compose.foundation.layout.fillMaxWidth
6    import androidx.compose.material3.ExperimentalMaterial3Api
7    import androidx.compose.material3.LargeTopAppBar
8    import androidx.compose.material3.Text
9    import androidx.compose.material3.TopAppBarDefaults
10   import androidx.compose.material3.TopAppBarScrollBehavior
11   import androidx.compose.runtime.Composable
12   import androidx.compose.ui.Modifier
13   import androidx.compose.ui.semantics.heading
14   import androidx.compose.ui.semantics.semantics
15   import androidx.compose.ui.text.style.TextOverflow
16   import pl.gov.coi.common.ui.ds.topappbar.CreateMenuButtons
17   import pl.gov.coi.common.ui.ds.topappbar.CreateNavigationButton
18   import pl.gov.coi.common.ui.ds.topappbar.TEXT_MAX_ONE_LINE
19   import pl.gov.coi.common.ui.ds.topappbar.TEXT_MAX_TWO_LINES
20   import pl.gov.coi.common.ui.ds.topappbar.TopAppBarData
21   import pl.gov.coi.common.ui.ds.topappbar.forceFocusOnStart
22   import pl.gov.coi.common.ui.focus.FocusHost.Companion.focusHost
23   import pl.gov.coi.common.ui.theme.AppTheme
24   
25   @OptIn(ExperimentalMaterial3Api::class)
26   @Composable
27   internal fun LargeTopAppBar(
28     data: TopAppBarData.Large,
29     scrollBehavior: TopAppBarScrollBehavior,
30   ) {
31     LargeTopAppBar(
32       colors = TopAppBarDefaults.topAppBarColors(
33         containerColor = data.containerColor(),
34         scrolledContainerColor = data.containerColor(),
35       ),
36       title = {
37         if (scrollBehavior.state.collapsedFraction < 0.35) {
38           Text(
39             modifier = Modifier
40               .semantics {
41                 heading()
42               }
43               .focusHost(forceFocusOnStart(data.forceTitleFocusTrigger)),
44             text = data.title.text,
45             color = AppTheme.colors.neutral500,
46             style = AppTheme.typography.headlineLargeMedium,
47             overflow = TextOverflow.Ellipsis,
48             maxLines = TEXT_MAX_TWO_LINES,
49           )
50         }
51         if (scrollBehavior.state.collapsedFraction > 0.75) {
52           Row(
53             modifier = Modifier.fillMaxWidth(),
54             horizontalArrangement = Arrangement.Center,
55           ) {
56             Text(
57               modifier = Modifier.semantics {
58                 heading()
59               },
60               text = data.title.text,
61               color = AppTheme.colors.neutral500,
62               style = AppTheme.typography.subtitleMedium,
63               overflow = TextOverflow.Ellipsis,
64               maxLines = TEXT_MAX_ONE_LINE,
65             )
66           }
67         }
68       },
69       navigationIcon = { data.navigationButtonData.CreateNavigationButton() },
70       actions = {
71         data.menuType.CreateMenuButtons()
72       },
73       scrollBehavior = scrollBehavior,
74     )
75   }
76   