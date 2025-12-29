1    package pl.gov.coi.common.ui.ds.searchbar.provider
2    
3    import pl.gov.coi.common.ui.ds.searchbar.SearchBarData
4    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
5    import pl.gov.coi.common.ui.preview.ScreenShotTestData
6    
7    class SearchBarPPP : CustomPreviewParameterProvider<SearchBarData>() {
8      override val screenShotTestValues: Sequence<ScreenShotTestData<SearchBarData>> = sequenceOf(
9        ScreenShotTestData(
10         screenShotTestName = "SearchBarInactive",
11         value = createInitializedState(
12           isActive = false,
13           query = "",
14         ),
15       ),
16       ScreenShotTestData(
17         screenShotTestName = "SearchBarActive",
18         value = createInitializedState(
19           isActive = true,
20           query = "",
21         ),
22       ),
23     )
24   
25     private fun createInitializedState(
26       isActive: Boolean,
27       query: String,
28     ) = SearchBarData(
29       placeholder = "Wyszukaj".toLabel(),
30       isActive = isActive,
31       query = query,
32       onQueryChange = { _ -> },
33       onActiveChange = { _ -> },
34       onClearClicked = {},
35     )
36   }
37   