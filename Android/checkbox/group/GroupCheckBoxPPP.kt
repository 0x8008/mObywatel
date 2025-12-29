1    package pl.gov.coi.common.ui.ds.checkbox.group
2    
3    import pl.gov.coi.common.ui.ds.button.buttontext.ButtonTextData
4    import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckBoxRowData
5    import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckBoxType
6    import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckboxContentType
7    import pl.gov.coi.common.ui.ds.checkbox.common.model.ClickableTextData
8    import pl.gov.coi.common.ui.ds.checkbox.group.model.CheckBoxGroupData
9    import pl.gov.coi.common.ui.ds.checkbox.group.model.CheckBoxHeaderData
10   import pl.gov.coi.common.ui.ds.link.LinkData
11   import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
12   import pl.gov.coi.common.ui.preview.ScreenShotTestData
13   
14   class GroupCheckBoxPPP : CustomPreviewParameterProvider<CheckBoxGroupData>() {
15     override val screenShotTestValues: Sequence<ScreenShotTestData<CheckBoxGroupData>> = sequenceOf(
16       ScreenShotTestData(
17         screenShotTestName = "CheckboxGroup",
18         value = CheckBoxGroupData(
19           checkboxes = listOf(
20             getCheckBoxData(isChecked = true),
21             getCheckBoxData(),
22           ),
23           getCheckBoxHeader(),
24           type = CheckBoxType.Default,
25         ),
26       ),
27       ScreenShotTestData(
28         screenShotTestName = "CheckboxesWithErrorText",
29         value = CheckBoxGroupData(
30           checkboxes = listOf(
31             getCheckBoxData(),
32             getCheckBoxData(),
33           ),
34           getCheckBoxHeader(),
35           type = CheckBoxType.Error(errorText = "errorText".toLabel()),
36         ),
37       ),
38       ScreenShotTestData(
39         screenShotTestName = "CheckboxesWithHelperText",
40         value = CheckBoxGroupData(
41           checkboxes = listOf(
42             getCheckBoxData(),
43             getCheckBoxData(),
44           ),
45           getCheckBoxHeader(),
46           type = CheckBoxType.Helper(helperText = "Helper text".toLabel()),
47         ),
48       ),
49       ScreenShotTestData(
50         screenShotTestName = "CheckboxesUrl",
51         value = CheckBoxGroupData(
52           checkboxes = listOf(
53             getCheckBoxData(isChecked = true),
54             getCheckBoxData(
55               clickableTextData = ClickableTextData.Link(
56                 linkData = LinkData(
57                   label = "urlText".toLabel(),
58                   url = "url",
59                   onClick = { url -> println("Checkbox $url clicked") },
60                   linkType = LinkData.LinkType.WEBSITE,
61                 ),
62               ),
63             ),
64           ),
65           type = CheckBoxType.Default,
66           header = getCheckBoxHeader(),
67         ),
68       ),
69       ScreenShotTestData(
70         screenShotTestName = "CheckboxesTextButton",
71         value = CheckBoxGroupData(
72           checkboxes = listOf(
73             getCheckBoxData(isChecked = true),
74             getCheckBoxData(
75               clickableTextData = ClickableTextData.Button(
76                 buttonData = ButtonTextData(
77                   label = "text button".toLabel(),
78                   onClick = {},
79                 ),
80               ),
81             ),
82           ),
83           type = CheckBoxType.Default,
84           header = getCheckBoxHeader(),
85         ),
86       ),
87       ScreenShotTestData(
88         screenShotTestName = "CheckboxesContentWithError",
89         value = CheckBoxGroupData(
90           header = getCheckBoxHeader(),
91           checkboxes = listOf(
92             getCheckBoxData(isChecked = true),
93             getCheckBoxData(),
94           ),
95           type = CheckBoxType.Error(
96             errorText = ("Lorem ipsum dolor sit amet, consectetur " +
97               "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore " +
98               "magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ").toLabel(),
99           ),
100          contentType = CheckboxContentType.CONTENT_BOX,
101        ),
102      ),
103      ScreenShotTestData(
104        screenShotTestName = "CheckboxesDisabled",
105        value = CheckBoxGroupData(
106          checkboxes = listOf(
107            getCheckBoxData(isChecked = true),
108            getCheckBoxData(isChecked = true),
109            getCheckBoxData(),
110          ),
111          header = getCheckBoxHeader(),
112          type = CheckBoxType.Error(errorText = "Error text".toLabel()),
113          isEnabled = false,
114        ),
115      ),
116    )
117  
118    private fun getCheckBoxData(
119      isChecked: Boolean = false,
120      clickableTextData: ClickableTextData? = null,
121    ) = CheckBoxRowData(
122      isChecked = isChecked,
123      onCheckedChange = {},
124      label = "Checkbox label".toLabel(),
125      clickableTextData = clickableTextData,
126    )
127  
128    private fun getCheckBoxHeader() = CheckBoxHeaderData(
129      label = "Checkbox group Label".toLabel(),
130      onClick = {},
131    )
132  }
133  