1    package pl.gov.coi.common.ui.ds.button.buttonicon
2    
3    import pl.gov.coi.common.ui.R
4    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
5    import pl.gov.coi.common.ui.preview.ScreenShotTestData
6    
7    class ButtonIconPPP : CustomPreviewParameterProvider<ButtonIconData>() {
8      override val screenShotTestValues: Sequence<ScreenShotTestData<ButtonIconData>> = sequenceOf(
9        ScreenShotTestData(
10         screenShotTestName = "IconButton",
11         value = ButtonIconData(
12           iconResId = R.drawable.aa002_delete,
13           onClick = {},
14         ),
15       ),
16     )
17   }
18   