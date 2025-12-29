1    package pl.gov.coi.common.ui.ds.searchbar
2    
3    import androidx.compose.foundation.layout.Row
4    import androidx.compose.foundation.layout.Spacer
5    import androidx.compose.foundation.layout.fillMaxWidth
6    import androidx.compose.foundation.layout.width
7    import androidx.compose.material3.ExperimentalMaterial3Api
8    import androidx.compose.material3.SearchBarDefaults
9    import androidx.compose.runtime.Composable
10   import androidx.compose.ui.ExperimentalComposeUiApi
11   import androidx.compose.ui.Modifier
12   import androidx.compose.ui.semantics.semantics
13   import androidx.compose.ui.semantics.testTag
14   import androidx.compose.ui.semantics.testTagsAsResourceId
15   import androidx.compose.ui.text.style.TextOverflow
16   import androidx.compose.ui.tooling.preview.Preview
17   import androidx.compose.ui.tooling.preview.PreviewParameter
18   import pl.gov.coi.common.domain.label.toLabel
19   import pl.gov.coi.common.ui.R
20   import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIcon
21   import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
22   import pl.gov.coi.common.ui.ds.searchbar.provider.SearchBarPPP
23   import pl.gov.coi.common.ui.text.CustomText
24   import pl.gov.coi.common.ui.theme.AppTheme
25   
26   @OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
27   @Composable
28   fun SearchBar(
29     modifier: Modifier = Modifier,
30     data: SearchBarData,
31     innerContent: @Composable () -> Unit,
32   ) {
33     androidx.compose.material3.SearchBar(
34       modifier = Modifier
35         .fillMaxWidth()
36         .semantics {
37           testTagsAsResourceId = true
38           testTag = "SearchBarComponent"
39         }
40         .then(other = modifier),
41       query = data.query,
42       colors = SearchBarDefaults.colors(
43         containerColor = if (data.isActive) AppTheme.colors.background else AppTheme.colors.white,
44         dividerColor = AppTheme.colors.neutral30,
45         inputFieldColors = SearchBarDefaults.inputFieldColors(
46           focusedTextColor = AppTheme.colors.neutral500,
47           unfocusedTextColor = AppTheme.colors.neutral500,
48           cursorColor = AppTheme.colors.primary900,
49         ),
50       ),
51       onSearch = {},
52       onQueryChange = { data.onQueryChange(it) },
53       active = data.isActive,
54       onActiveChange = { data.onActiveChange(true) },
55       placeholder = {
56         Row {
57           Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing50))
58           CustomText(
59             label = data.placeholder,
60             overflow = TextOverflow.Ellipsis,
61             style = AppTheme.typography.bodyLargeRegular,
62             color = AppTheme.colors.neutral100,
63           )
64         }
65       },
66       leadingIcon = {
67         SearchBarLeadingIcon(
68           isActive = data.isActive,
69           onActiveChanged = data.onActiveChange,
70         )
71       },
72       trailingIcon = {
73         if (data.isActive && data.query.isNotEmpty()) {
74           SearchBarTrailingIcon(
75             onClearClicked = data.onClearClicked,
76           )
77         }
78       },
79     ) {
80       innerContent()
81     }
82   }
83   
84   @Composable
85   private fun SearchBarLeadingIcon(
86     isActive: Boolean,
87     onActiveChanged: (Boolean) -> Unit,
88   ) {
89     ButtonIcon(
90       data = ButtonIconData(
91         iconResId = if (isActive) R.drawable.ab004_arrow_left else R.drawable.ab002_search,
92         iconColorProvider = { AppTheme.colors.neutral200 },
93         onClick = { onActiveChanged(!isActive) },
94       ),
95     )
96   }
97   
98   @Composable
99   private fun SearchBarTrailingIcon(
100    onClearClicked: () -> Unit,
101  ) {
102    ButtonIcon(
103      data = ButtonIconData(
104        iconResId = R.drawable.ab009_x_mark,
105        iconColorProvider = { AppTheme.colors.neutral200 },
106        onClick = { onClearClicked() },
107      ),
108    )
109  }
110  
111  @Preview
112  @Composable
113  fun SearchBarPreview(
114    @PreviewParameter(SearchBarPPP::class)
115    data: SearchBarData,
116  ) {
117    SearchBar(data = data) {
118      CustomText(
119        label = ("Inner content - results of the search should be placed in InnerContent")
120          .toLabel(tag = "searchBarText"),
121      )
122    }
123  }
124  