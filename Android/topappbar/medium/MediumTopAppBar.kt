1    package pl.gov.coi.common.ui.ds.topappbar.medium
2    
3    import androidx.compose.foundation.layout.Arrangement
4    import androidx.compose.foundation.layout.Row
5    import androidx.compose.foundation.layout.fillMaxWidth
6    import androidx.compose.material3.ExperimentalMaterial3Api
7    import androidx.compose.material3.MediumTopAppBar
8    import androidx.compose.material3.TopAppBarDefaults
9    import androidx.compose.material3.TopAppBarScrollBehavior
10   import androidx.compose.runtime.Composable
11   import androidx.compose.ui.Modifier
12   import androidx.compose.ui.semantics.heading
13   import androidx.compose.ui.semantics.semantics
14   import androidx.compose.ui.text.style.TextOverflow
15   import pl.gov.coi.common.ui.ds.topappbar.CreateMenuButtons
16   import pl.gov.coi.common.ui.ds.topappbar.CreateNavigationButton
17   import pl.gov.coi.common.ui.ds.topappbar.TEXT_MAX_ONE_LINE
18   import pl.gov.coi.common.ui.ds.topappbar.TopAppBarData
19   import pl.gov.coi.common.ui.ds.topappbar.forceFocusOnStart
20   import pl.gov.coi.common.ui.focus.FocusHost.Companion.focusHost
21   import pl.gov.coi.common.ui.text.CustomText
22   import pl.gov.coi.common.ui.theme.AppTheme
23   
24   @OptIn(ExperimentalMaterial3Api::class)
25   @Composable
26   internal fun MediumTopAppBar(
27     data: TopAppBarData.Medium,
28     scrollBehavior: TopAppBarScrollBehavior,
29   ) {
30     MediumTopAppBar(
31       colors = TopAppBarDefaults.topAppBarColors(
32         containerColor = data.containerColor(),
33         scrolledContainerColor = data.containerColor(),
34       ),
35       title = {
36         if (scrollBehavior.state.collapsedFraction < 0.35) {
37           CustomText(
38             modifier = Modifier
39               .semantics {
40                 heading()
41               }
42               .focusHost(forceFocusOnStart(data.forceTitleFocusTrigger)),
43             label = data.title,
44             color = AppTheme.colors.neutral500,
45             style = AppTheme.typography.headlineLargeMedium,
46             overflow = TextOverflow.Ellipsis,
47             maxLines = TEXT_MAX_ONE_LINE,
48           )
49         }
50         if (scrollBehavior.state.collapsedFraction > 0.75) {
51           Row(
52             modifier = Modifier.fillMaxWidth(),
53             horizontalArrangement = Arrangement.Center,
54           ) {
55             CustomText(
56               modifier = Modifier.semantics {
57                 heading()
58               },
59               label = data.title,
60               color = AppTheme.colors.neutral500,
61               style = AppTheme.typography.subtitleMedium,
62               overflow = TextOverflow.Ellipsis,
63               maxLines = TEXT_MAX_ONE_LINE,
64             )
65           }
66         }
67       },
68       navigationIcon = { data.navigationButtonData.CreateNavigationButton() },
69       actions = {
70         data.menuType.CreateMenuButtons()
71       },
72       scrollBehavior = scrollBehavior,
73     )
74   }
75   