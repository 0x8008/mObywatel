1    package pl.gov.coi.common.ui.ds.emptystate.provider
2    
3    import pl.gov.coi.common.ui.ds.button.ButtonData
4    import pl.gov.coi.common.ui.ds.button.common.ButtonSize
5    import pl.gov.coi.common.ui.ds.button.common.ButtonType
6    import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
7    import pl.gov.coi.common.ui.ds.emptystate.EmptyStateData
8    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
9    import pl.gov.coi.common.ui.preview.ScreenShotTestData
10   
11   class EmptyStatePreviewParameterProvider : CustomPreviewParameterProvider<EmptyStateData>() {
12     override val screenShotTestValues: Sequence<ScreenShotTestData<EmptyStateData>> = sequenceOf(
13       ScreenShotTestData(
14         screenShotTestName = "EmptyStateDataNoTitle",
15         value = provideEmptyStateDataNoTitle(),
16       ),
17       ScreenShotTestData(
18         screenShotTestName = "EmptyStateStateDataWithTitle",
19         value = provideEmptyStateDataWithTitle(),
20       ),
21       ScreenShotTestData(
22         screenShotTestName = "EmptyStateDataStandardWithButton",
23         value = provideEmptyStateDataWithButton(),
24       ),
25       ScreenShotTestData(
26         screenShotTestName = "EmptyStateDataNoTitleWithButton",
27         value = provideEmptyStateDataNoTitleWithButton(),
28       ),
29     )
30   
31     private fun provideEmptyStateDataWithTitle() = EmptyStateData(
32       title = "Title section (optional)".toLabel(),
33       body = "Body section".toLabel(),
34     )
35   
36     private fun provideEmptyStateDataNoTitle() = EmptyStateData(
37       body = "Body section".toLabel(),
38     )
39   
40     private fun provideEmptyStateDataWithButton() = EmptyStateData(
41       title = "Title section (optional)".toLabel(),
42       body = "Body section".toLabel(),
43       buttonData = ButtonData(
44         buttonSize = ButtonSize.Small,
45         buttonVariant = ButtonVariant.Tertiary,
46         buttonType = ButtonType.WithText(
47           label = "Tertiary small button (optional)".toLabel(),
48         ),
49         onClick = {},
50       ),
51     )
52   
53     private fun provideEmptyStateDataNoTitleWithButton() = EmptyStateData(
54       body = "Body section".toLabel(),
55       buttonData = ButtonData(
56         buttonSize = ButtonSize.Small,
57         buttonVariant = ButtonVariant.Tertiary,
58         buttonType = ButtonType.WithText(
59           label = "Tertiary small button (optional)".toLabel(),
60         ),
61         onClick = {},
62       ),
63     )
64   }
65   