1    package pl.gov.coi.common.ui.ds.resultmodal.provider
2    
3    import pl.gov.coi.common.domain.label.Label
4    import pl.gov.coi.common.domain.label.toLabel
5    import pl.gov.coi.common.ui.R
6    import pl.gov.coi.common.ui.ds.button.ButtonData
7    import pl.gov.coi.common.ui.ds.button.common.ButtonSize
8    import pl.gov.coi.common.ui.ds.button.common.ButtonType
9    import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
10   import pl.gov.coi.common.ui.ds.resultmodal.ResultModalData
11   import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
12   import pl.gov.coi.common.ui.preview.ScreenShotTestData
13   import pl.gov.coi.common.ui.theme.AppTheme
14   
15   class ResultModalPreviewParameterProvider : CustomPreviewParameterProvider<ResultModalData>() {
16     override val screenShotTestValues: Sequence<ScreenShotTestData<ResultModalData>> = sequenceOf(
17       ScreenShotTestData(
18         screenShotTestName = "ResultModalData",
19         value = provideResultModalData(),
20       ),
21     )
22   
23     private fun provideResultModalData() = ResultModalData(
24       iconRes = R.drawable.f4_success,
25       iconColorProvider = { AppTheme.colors.supportGreen100 },
26       iconContentDescription = Label.EMPTY,
27       title = "Title Roboto Medium 20".toLabel(),
28       dataTitle1 = "Data title 2 Roboto Regular 16".toLabel(),
29       data1 = "Data 1 Roboto Medium 18\nData 1 Roboto Medium 18".toLabel(),
30       dataTitle2 = "Data title 2 Roboto Regular 16".toLabel(),
31       data2 = "Data 2 Roboto Medium 18".toLabel(),
32       primaryButton = ButtonData(
33         buttonSize = ButtonSize.Large(),
34         buttonVariant = ButtonVariant.Primary,
35         buttonType = ButtonType.WithText(
36           label = "Primary button".toLabel(),
37         ),
38         onClick = {},
39       ),
40       secondaryButton = ButtonData(
41         buttonSize = ButtonSize.Large(),
42         buttonVariant = ButtonVariant.Secondary(),
43         buttonType = ButtonType.WithText(
44           label = "Secondary button".toLabel(),
45         ),
46         onClick = {},
47       ),
48       tertiaryButton = ButtonData(
49         buttonSize = ButtonSize.Large(),
50         buttonVariant = ButtonVariant.Tertiary,
51         buttonType = ButtonType.WithText(
52           label = "Tertiary button".toLabel(),
53         ),
54         onClick = {},
55       ),
56       closeIconContentDescription = Label.EMPTY,
57       closeAction = {},
58     )
59   }
60   