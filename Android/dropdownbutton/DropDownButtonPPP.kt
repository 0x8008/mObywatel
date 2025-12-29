1    package pl.gov.coi.common.ui.ds.dropdownbutton
2    
3    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
4    import pl.gov.coi.common.ui.preview.ScreenShotTestData
5    
6    class DropDownButtonPPP : CustomPreviewParameterProvider<DropDownButtonData>() {
7      override val screenShotTestValues: Sequence<ScreenShotTestData<DropDownButtonData>> = sequenceOf(
8        ScreenShotTestData(
9          screenShotTestName = "DisabledDropDown",
10         value = DropDownButtonData(
11           "Dropdown Label".toLabel(),
12           placeholder = "DropDown placeholder placeholder placeholder".toLabel(),
13           items = emptyList(),
14           initialSelectedItem = null,
15           buttonType = DropDownButtonState.Disabled(
16             helperText = "helper text".toLabel(),
17           ),
18           onClick = { },
19         ),
20       ),
21       ScreenShotTestData(
22         screenShotTestName = "HelperDropDown",
23         value = DropDownButtonData(
24           "Dropdown Label".toLabel(),
25           placeholder = "DropDown placeholder placeholder placee".toLabel(),
26           items = emptyList(),
27           initialSelectedItem = null,
28           buttonType = DropDownButtonState.Enabled(
29             helperText = "helper text".toLabel(),
30           ),
31           onClick = { },
32         ),
33       ),
34       ScreenShotTestData(
35         screenShotTestName = "ErrorDropDown",
36         value = DropDownButtonData(
37           "Dropdown Label".toLabel(),
38           placeholder = "DropDown placeholder".toLabel(),
39           items = emptyList(),
40           initialSelectedItem = null,
41           buttonType = DropDownButtonState.Error(
42             errorText = "error text".toLabel(),
43           ),
44           onClick = { },
45         ),
46       ),
47     )
48   }
49   