1    package pl.gov.coi.common.ui.ds.switchcomponent.provider
2    
3    import pl.gov.coi.common.domain.validators.ValidationState
4    import pl.gov.coi.common.ui.ds.button.buttontext.ButtonTextData
5    import pl.gov.coi.common.ui.ds.link.LinkData
6    import pl.gov.coi.common.ui.ds.switchcomponent.SwitchData
7    import pl.gov.coi.common.ui.ds.switchcomponent.SwitchExtraType
8    import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
9    import pl.gov.coi.common.ui.preview.ScreenShotTestData
10   
11   class SwitchPreviewParameterProvider : CustomPreviewParameterProvider<SwitchData>() {
12   
13     override val screenShotTestValues: Sequence<ScreenShotTestData<SwitchData>> = sequenceOf(
14       ScreenShotTestData(
15         screenShotTestName = "SwitchEnabledStateOFF",
16         value = SwitchData.SwitchOnly(
17           checked = false,
18           onCheckedChange = {},
19         ),
20       ),
21       ScreenShotTestData(
22         screenShotTestName = "SwitchEnabledStateON",
23         value = SwitchData.SwitchOnly(
24           checked = true,
25           onCheckedChange = {},
26         ),
27       ),
28       ScreenShotTestData(
29         screenShotTestName = "SwitchDisabledStateOFF",
30         value = SwitchData.SwitchOnly(
31           enabled = false,
32           checked = false,
33           onCheckedChange = {},
34         ),
35       ),
36       ScreenShotTestData(
37         screenShotTestName = "SwitchDisabledStateON",
38         value = SwitchData.SwitchOnly(
39           checked = true,
40           enabled = false,
41           onCheckedChange = {},
42         ),
43       ),
44       ScreenShotTestData(
45         screenShotTestName = "SwitchWithShortText",
46         value = SwitchData.SwitchWithText(
47           label = "Krótka  treść".toLabel(),
48           checked = false,
49           onCheckedChange = {},
50         ),
51       ),
52       ScreenShotTestData(
53         screenShotTestName = "SwitchWithLongTextInvalid",
54         value = SwitchData.SwitchWithText(
55           label = "Switch component longer description, Lorem ipsum dolor sit amet, consectetur adipiscing elit"
56             .toLabel(),
57           onCheckedChange = {},
58           checked = false,
59           validationState = ValidationState.Invalid(
60             message = "Komunikat walidacyjny".toLabel(),
61           ),
62         ),
63       ),
64   
65       ScreenShotTestData(
66         screenShotTestName = "SwitchWithLink",
67         value = SwitchData.SwitchWithExtras(
68           checked = true,
69           enabled = true,
70           onCheckedChange = { },
71           label = "Switch with link".toLabel(),
72           customActionContentDescription = "Pobierz Switch with link".toLabel(),
73           type = SwitchExtraType.Link(
74             data = LinkData(
75               label = "Link".toLabel(),
76               linkType = LinkData.LinkType.WEBSITE,
77               url = "",
78               onClick = {},
79             ),
80           ),
81         ),
82       ),
83       ScreenShotTestData(
84         screenShotTestName = "SwitchWithButtonText",
85         value = SwitchData.SwitchWithExtras(
86           checked = true,
87           enabled = true,
88           onCheckedChange = { },
89           label = "Switch with text button".toLabel(),
90           customActionContentDescription = "Zobacz".toLabel(),
91           type = SwitchExtraType.TextButton(
92             data = ButtonTextData(
93               label = "button text label".toLabel(),
94               onClick = {},
95             ),
96           ),
97         ),
98       ),
99       ScreenShotTestData(
100        screenShotTestName = "SwitchWithLinkInvalid",
101        value = SwitchData.SwitchWithExtras(
102          checked = true,
103          enabled = true,
104          onCheckedChange = { },
105          label = "Switch with link".toLabel(),
106          type = SwitchExtraType.Link(
107            data = LinkData(
108              label = "Link".toLabel(),
109              linkType = LinkData.LinkType.EXTERNAL_APP,
110              url = "",
111              onClick = {},
112            ),
113          ),
114          validationState = ValidationState.Invalid(
115            message = "Komunikat walidacyjny".toLabel(),
116          ),
117          customActionContentDescription = "Pobierz Switch with link".toLabel(),
118        ),
119      ),
120    )
121  }
122  