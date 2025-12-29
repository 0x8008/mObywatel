1    package pl.gov.coi.common.ui.ds.topappbar.small
2    
3    import androidx.compose.foundation.Image
4    import androidx.compose.foundation.layout.height
5    import androidx.compose.foundation.layout.padding
6    import androidx.compose.material3.CenterAlignedTopAppBar
7    import androidx.compose.material3.ExperimentalMaterial3Api
8    import androidx.compose.material3.TopAppBar
9    import androidx.compose.material3.TopAppBarDefaults
10   import androidx.compose.material3.TopAppBarScrollBehavior
11   import androidx.compose.runtime.Composable
12   import androidx.compose.ui.Modifier
13   import androidx.compose.ui.res.painterResource
14   import androidx.compose.ui.semantics.heading
15   import androidx.compose.ui.semantics.semantics
16   import androidx.compose.ui.text.style.TextOverflow
17   import pl.gov.coi.common.ui.R
18   import pl.gov.coi.common.ui.ds.progressbar.ProgressBar
19   import pl.gov.coi.common.ui.ds.topappbar.CreateMenuButtons
20   import pl.gov.coi.common.ui.ds.topappbar.CreateNavigationButton
21   import pl.gov.coi.common.ui.ds.topappbar.TEXT_MAX_ONE_LINE
22   import pl.gov.coi.common.ui.ds.topappbar.TitleAlignment
23   import pl.gov.coi.common.ui.ds.topappbar.TopAppBarData
24   import pl.gov.coi.common.ui.ds.topappbar.forceFocusOnStart
25   import pl.gov.coi.common.ui.focus.FocusHost.Companion.focusHost
26   import pl.gov.coi.common.ui.icon.CustomIcon
27   import pl.gov.coi.common.ui.icon.IconSize
28   import pl.gov.coi.common.ui.text.CustomText
29   import pl.gov.coi.common.ui.theme.AppTheme
30   
31   @OptIn(ExperimentalMaterial3Api::class)
32   @Composable
33   internal fun SmallTopAppBar(
34     data: TopAppBarData.Small,
35     scrollBehavior: TopAppBarScrollBehavior,
36   ) {
37     when (data is TopAppBarData.Small.Default && data.alignment == TitleAlignment.Left) {
38       true -> TopAppBar(
39         colors = TopAppBarDefaults.topAppBarColors(
40           containerColor = data.containerColor(),
41           scrolledContainerColor = data.containerColor(),
42         ),
43         title = {
44           CustomText(
45             modifier = Modifier
46               .semantics {
47                 heading()
48               }
49               .focusHost(forceFocusOnStart(data.forceTitleFocusTrigger)),
50             label = data.title,
51             color = AppTheme.colors.neutral500,
52             style = AppTheme.typography.subtitleMedium,
53             overflow = TextOverflow.Ellipsis,
54             maxLines = TEXT_MAX_ONE_LINE,
55             focusIndex = -1f,
56           )
57         },
58         navigationIcon = { data.navigationButtonData.CreateNavigationButton() },
59         actions = { data.menuType.CreateMenuButtons() },
60         scrollBehavior = scrollBehavior,
61       )
62   
63       false -> CenterAlignedTopAppBar(
64         colors = TopAppBarDefaults.topAppBarColors(
65           containerColor = data.containerColor(),
66           scrolledContainerColor = data.containerColor(),
67         ),
68         title = {
69           when (data) {
70             is TopAppBarData.Small.Default -> CustomText(
71               modifier = Modifier
72                 .semantics {
73                   heading()
74                 }
75                 .focusHost(forceFocusOnStart(data.forceTitleFocusTrigger)),
76               label = data.title,
77               color = AppTheme.colors.neutral500,
78               style = AppTheme.typography.subtitleMedium,
79               overflow = TextOverflow.Ellipsis,
80               maxLines = TEXT_MAX_ONE_LINE,
81               labelContentDescription = data.title,
82               focusIndex = -1f,
83             )
84   
85             is TopAppBarData.Small.Logo -> Image(
86               modifier = Modifier.height(AppTheme.dimensions.spacing400),
87               painter = painterResource(id = R.drawable.coi_common_ui_ic_mobywatel_horizontal_logo),
88               contentDescription = null,
89             )
90   
91             is TopAppBarData.Small.Sygnet -> Unit
92           }
93         },
94         navigationIcon = {
95           when (data) {
96             is TopAppBarData.Small.Default -> data.navigationButtonData.CreateNavigationButton()
97             is TopAppBarData.Small.Logo -> data.navigationButtonData.CreateNavigationButton()
98             is TopAppBarData.Small.Sygnet -> CustomIcon(
99               modifier = Modifier.padding(start = AppTheme.dimensions.spacing150),
100              iconResId = R.drawable.coi_common_ui_ic_mobywatel_logo,
101              iconSize = IconSize.SBig,
102              contentDescription = null, 
103            )
104          }
105        },
106        actions = {
107          data.menuType.CreateMenuButtons()
108        },
109        scrollBehavior = scrollBehavior,
110      )
111    }
112    when (data) {
113      is TopAppBarData.Small.Default -> if (data.progressBarData != null) {
114        ProgressBar(data = data.progressBarData)
115      }
116  
117      else -> Unit
118    }
119  }
120  