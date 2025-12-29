1    package pl.gov.coi.common.ui.ds.button.buttontext
2    
3    import pl.gov.coi.common.ui.ds.button.common.ButtonState
4    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
5    import pl.gov.coi.common.ui.preview.ScreenShotTestData
6    
7    class ButtonTextPPP : CustomPreviewParameterProvider<ButtonTextData>() {
8      override val screenShotTestValues: Sequence<ScreenShotTestData<ButtonTextData>> = sequenceOf(
9        ScreenShotTestData(
10         screenShotTestName = "TextEnabledButton",
11         value = ButtonTextData(
12           label = "Test".toLabel(),
13           onClick = {},
14         ),
15       ),
16       ScreenShotTestData(
17         screenShotTestName = "TextDestructiveButton",
18         value = ButtonTextData(
19           label = "Test".toLabel(),
20           buttonState = ButtonState.Destructive,
21           onClick = {},
22         ),
23       ),
24       ScreenShotTestData(
25         screenShotTestName = "TextDisabledButton",
26         value = ButtonTextData(
27           label = "Test".toLabel(),
28           buttonState = ButtonState.Disabled,
29           onClick = {},
30         ),
31       ),
32     )
33   }
34   