1    package pl.gov.coi.common.ui.ds.pagecontroller.provider
2    
3    import pl.gov.coi.common.ui.R
4    import pl.gov.coi.common.ui.ds.pagecontroller.PageControllerData
5    import pl.gov.coi.common.ui.ds.smallcard.SmallCardData
6    import pl.gov.coi.common.ui.onboarding.model.OnboardingPageData
7    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
8    import pl.gov.coi.common.ui.preview.ScreenShotTestData
9    import pl.gov.coi.common.ui.theme.AppTheme
10   
11   class PageControllerPreviewParameterProvider :
12     CustomPreviewParameterProvider<PageControllerData<*>>() {
13     override val screenShotTestValues: Sequence<ScreenShotTestData<PageControllerData<*>>> =
14       sequenceOf(
15         ScreenShotTestData(
16           screenShotTestName = "PageControllerSmallCardData",
17           value = providePageControllerSmallCardData(),
18         ),
19         ScreenShotTestData(
20           screenShotTestName = "PageControllerOnboardingPageData",
21           value = providePageControllerOnboardingPageData(),
22         ),
23         ScreenShotTestData(
24           screenShotTestName = "PageControllerSmallCardDataNoButton",
25           value = providePageControllerSmallCardDataNoButton(),
26         ),
27         ScreenShotTestData(
28           screenShotTestName = "PageControllerOnboardingPageDataNoButton",
29           value = providePageControllerOnboardingPageDataNoButton(),
30         ),
31       )
32   
33     private fun providePageControllerOnboardingPageDataNoButton() =
34       PageControllerData(
35         contentsData = listOf(
36           PageControllerData.PageData(
37             OnboardingPageData.Regular(
38               title = "Dokumenty zawsze pod ręką".toLabel(),
39               message = "Potwierdzaj tożsamość telefonem, na przykład w przychodni, pociągu, na poczcie.".toLabel() +
40                 " Nie musisz pamiętać, aby nosić ze sobą dokumenty.".toLabel(),
41               imageResId = R.drawable.coi_common_ui_ic_document_diia,
42             ),
43             isButtonVisible = false,
44             buttonTitle = "Dalej".toLabel(),
45           ),
46           PageControllerData.PageData(
47             OnboardingPageData.Regular(
48               title = "Dokumenty zawsze pod ręką".toLabel(),
49               message = "Potwierdzaj tożsamość telefonem, na przykład w przychodni, pociągu, na poczcie.".toLabel() +
50                 " Nie musisz pamiętać, aby nosić ze sobą dokumenty.".toLabel(),
51               imageResId = R.drawable.coi_common_ui_ic_document_doctor,
52             ),
53             isButtonVisible = false,
54             buttonTitle = "Dalej".toLabel(),
55           ),
56         ),
57       )
58   
59     private fun providePageControllerSmallCardDataNoButton() =
60       PageControllerData(
61         contentsData = listOf(
62           PageControllerData.PageData(
63             SmallCardData(
64               title = "Naruszenie środowiskowe".toLabel(),
65               iconResId = R.drawable.da002_naruszenie_srodowiskowe,
66               iconColorProvider = { AppTheme.colors.serviceLeafy100 },
67               onClick = {},
68             ),
69             isButtonVisible = false,
70             buttonTitle = "Dalej".toLabel(),
71           ),
72   
73           PageControllerData.PageData(
74             SmallCardData(
75               title = "PWZ Pielęgniarka".toLabel(),
76               iconResId = R.drawable.db017_pwz_pielegniarka,
77               iconColorProvider = { AppTheme.colors.documentOcean400 },
78               onClick = {},
79             ),
80             isButtonVisible = false,
81             buttonTitle = "Dalej".toLabel(),
82           ),
83         ),
84       )
85   
86     private fun providePageControllerSmallCardData() = PageControllerData(
87       contentsData = listOf(
88         PageControllerData.PageData(
89           SmallCardData(
90             title = "Naruszenie środowiskowe".toLabel(),
91             iconResId = R.drawable.da002_naruszenie_srodowiskowe,
92             iconColorProvider = { AppTheme.colors.serviceLeafy100 },
93             onClick = {},
94           ),
95           isButtonVisible = true,
96           buttonTitle = "Rozpocznij".toLabel(),
97         ),
98   
99         PageControllerData.PageData(
100          SmallCardData(
101            title = "PWZ Pielęgniarka".toLabel(),
102            iconResId = R.drawable.db017_pwz_pielegniarka,
103            iconColorProvider = { AppTheme.colors.documentOcean400 },
104            onClick = {},
105          ),
106          isButtonVisible = false,
107          buttonTitle = "Dalej".toLabel(),
108        ),
109  
110        PageControllerData.PageData(
111          SmallCardData(
112            title = "Legitymacja szkolna".toLabel(),
113            iconResId = R.drawable.db008_legitymacja_szkolna,
114            iconColorProvider = { AppTheme.colors.documentPink200 },
115            onClick = {},
116          ),
117          isButtonVisible = true,
118          buttonTitle = "Zakończ".toLabel(),
119        ),
120      ),
121    )
122  
123    private fun providePageControllerOnboardingPageData() = PageControllerData(
124      contentsData = listOf(
125        PageControllerData.PageData(
126          OnboardingPageData.Regular(
127            title = "Dokumenty zawsze pod ręką".toLabel(),
128            message = "Potwierdzaj tożsamość telefonem, na przykład w przychodni, pociągu, na poczcie.".toLabel() +
129              " Nie musisz pamiętać, aby nosić ze sobą dokumenty.".toLabel(),
130            imageResId = R.drawable.coi_common_ui_ic_document_diia,
131          ),
132          isButtonVisible = true,
133          buttonTitle = "Rozpocznij".toLabel(),
134        ),
135        PageControllerData.PageData(
136          OnboardingPageData.Regular(
137            title = "Dokumenty zawsze pod ręką".toLabel(),
138            message = "Potwierdzaj tożsamość telefonem, na przykład w przychodni, pociągu, na poczcie.".toLabel() +
139              " Nie musisz pamiętać, aby nosić ze sobą dokumenty.".toLabel(),
140            imageResId = R.drawable.coi_common_ui_ic_document_doctor,
141          ),
142          isButtonVisible = false,
143          buttonTitle = "Dalej".toLabel(),
144        ),
145        PageControllerData.PageData(
146          OnboardingPageData.Regular(
147            title = "Dokumenty zawsze pod ręką".toLabel(),
148            message = "Potwierdzaj tożsamość telefonem, na przykład w przychodni, pociągu, na poczcie.".toLabel() +
149              " Nie musisz pamiętać, aby nosić ze sobą dokumenty.".toLabel(),
150            imageResId = R.drawable.coi_common_ui_ic_document_id,
151          ),
152          isButtonVisible = true,
153          buttonTitle = "Zakończ".toLabel(),
154        ),
155      ),
156    )
157  }
158  