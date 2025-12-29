1    package pl.gov.coi.common.ui.ds.snackbar.provider
2    
3    import pl.gov.coi.common.ui.ds.snackbar.SnackBarData
4    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
5    import pl.gov.coi.common.ui.preview.ScreenShotTestData
6    
7    class SnackBarPreviewParameterProvider : CustomPreviewParameterProvider<SnackBarData>() {
8    
9      override val screenShotTestValues: Sequence<ScreenShotTestData<SnackBarData>> = sequenceOf(
10       ScreenShotTestData(
11         screenShotTestName = "SnackBarDataSimple",
12         value = SnackBarData.Default(
13           messageLabel = "Single-line snackbar".toLabel(),
14         ),
15       ),
16       ScreenShotTestData(
17         screenShotTestName = "SnackBarDataSimple",
18         value = SnackBarData.Default(
19           ("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laore").toLabel(),
20         ),
21       ),
22       ScreenShotTestData(
23         screenShotTestName = "SnackBarDataClosable",
24         value = SnackBarData.DefaultWithIcon(
25           messageLabel = "Single-line snackbar with close affordance".toLabel(),
26         ) {},
27       ),
28       ScreenShotTestData(
29         screenShotTestName = "SnackBarDataClosable",
30         value = SnackBarData.DefaultWithIcon(
31           ("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laore").toLabel(),
32         ) {},
33       ),
34       ScreenShotTestData(
35         screenShotTestName = "SnackBarDataDefaultWithIcon",
36         value = SnackBarData.DefaultWithIcon(
37           ("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laore." +
38             " Lorem ipsum dolor sit amet.").toLabel(),
39         ),
40       ),
41     )
42   }
43   