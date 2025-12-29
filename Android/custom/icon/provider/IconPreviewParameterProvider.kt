1    package pl.gov.coi.common.ui.ds.custom.icon.provider
2    
3    import pl.gov.coi.common.domain.label.Label
4    import pl.gov.coi.common.ui.R
5    import pl.gov.coi.common.ui.ds.custom.icon.BackgroundShape
6    import pl.gov.coi.common.ui.ds.custom.icon.IconData
7    import pl.gov.coi.common.ui.ds.custom.icon.IconSize
8    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
9    import pl.gov.coi.common.ui.preview.ScreenShotTestData
10   import pl.gov.coi.common.ui.theme.AppTheme
11   
12   class IconPreviewParameterProvider : CustomPreviewParameterProvider<IconData>() {
13     override val screenShotTestValues: Sequence<ScreenShotTestData<IconData>>
14       get() = sequenceOf(
15         ScreenShotTestData(
16           screenShotTestName = "IconDataStandard",
17           value = providerIconDataStandard(),
18         ),
19         ScreenShotTestData(
20           screenShotTestName = "IconBackgroundRounded",
21           value = providerIconDataBackgroundRounded(),
22         ),
23         ScreenShotTestData(
24           screenShotTestName = "IconBackgroundSquare",
25           value = providerIconDataBackgroundSquare(),
26         ),
27         ScreenShotTestData(
28           screenShotTestName = "IconBackgroundRoundedSquare",
29           value = providerIconDataBackgroundRoundedSquare(),
30         ),
31         ScreenShotTestData(
32           screenShotTestName = "IconBackgroundRoundedExample",
33           value = providerIconDataBackgroundRoundedExample(),
34         ),
35       )
36   
37     companion object {
38       fun providerIconDataStandard() = IconData.Standard(
39         iconResId = R.drawable.aa008_change_password,
40         iconSize = IconSize.SIZE48,
41         iconColorProvider = { AppTheme.colors.supportRed100 },
42         contentDescription = Label.EMPTY,
43       )
44   
45       fun providerIconDataBackgroundRounded() = IconData.Background(
46         iconResId = R.drawable.c2_warning_mark,
47         backgroundSize = IconSize.SIZE48,
48         iconSize = IconSize.SIZE32,
49         iconColorProvider = { AppTheme.colors.primary900 },
50         backgroundColorProvider = { AppTheme.colors.secondary900 },
51         backgroundShape = BackgroundShape.Rounded,
52         contentDescription = Label.EMPTY,
53       )
54   
55       fun providerIconDataBackgroundSquare() = IconData.Background(
56         iconResId = R.drawable.c4_success,
57         backgroundSize = IconSize.SIZE48,
58         iconSize = IconSize.SIZE32,
59         iconColorProvider = { AppTheme.colors.primary900 },
60         backgroundColorProvider = { AppTheme.colors.secondary900 },
61         backgroundShape = BackgroundShape.Square,
62         contentDescription = Label.EMPTY,
63       )
64   
65       fun providerIconDataBackgroundRoundedSquare() = IconData.Background(
66         iconResId = R.drawable.c3_error_mark,
67         backgroundSize = IconSize.SIZE48,
68         iconSize = IconSize.SIZE32,
69         iconColorProvider = { AppTheme.colors.primary900 },
70         backgroundColorProvider = { AppTheme.colors.secondary900 },
71         backgroundShape = BackgroundShape.RoundedSquare({ AppTheme.shapes.radius150 }),
72         contentDescription = Label.EMPTY,
73       )
74   
75       fun providerIconDataBackgroundRoundedExample() = IconData.Background(
76         iconResId = R.drawable.ag005_globe,
77         backgroundSize = IconSize.SIZE96,
78         iconSize = IconSize.SIZE64,
79         iconColorProvider = { AppTheme.colors.primary900 },
80         backgroundColorProvider = { AppTheme.colors.secondary900 },
81         backgroundShape = BackgroundShape.Rounded,
82         contentDescription = Label.EMPTY,
83       )
84     }
85   }
86   