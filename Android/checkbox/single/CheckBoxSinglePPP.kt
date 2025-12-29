1    package pl.gov.coi.common.ui.ds.checkbox.single
2    
3    import pl.gov.coi.common.domain.label.toLabel
4    import pl.gov.coi.common.ui.ds.button.buttontext.ButtonTextData
5    import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckBoxRowData
6    import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckBoxType
7    import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckboxContentType
8    import pl.gov.coi.common.ui.ds.checkbox.common.model.ClickableTextData
9    import pl.gov.coi.common.ui.ds.checkbox.single.model.CheckBoxSingleData
10   import pl.gov.coi.common.ui.ds.link.LinkData
11   import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
12   import pl.gov.coi.common.ui.preview.ScreenShotTestData
13   
14   class CheckBoxSinglePPP : CustomPreviewParameterProvider<CheckBoxSingleData>() {
15     override val screenShotTestValues: Sequence<ScreenShotTestData<CheckBoxSingleData>> = sequenceOf(
16       ScreenShotTestData(
17         screenShotTestName = "Default",
18         value = CheckBoxSingleData(
19           checkbox = getCheckBoxData(),
20           type = CheckBoxType.Default,
21         ),
22       ),
23       ScreenShotTestData(
24         screenShotTestName = "HelperText",
25         value = CheckBoxSingleData(
26           checkbox = getCheckBoxData(isChecked = true),
27           type = CheckBoxType.Helper(helperText = "helper text".toLabel()),
28         ),
29       ),
30       ScreenShotTestData(
31         screenShotTestName = "ErrorText",
32         value = CheckBoxSingleData(
33           checkbox = getCheckBoxData(isChecked = true),
34           type = CheckBoxType.Error(errorText = "error text".toLabel()),
35         ),
36       ),
37       ScreenShotTestData(
38         screenShotTestName = "Disabled",
39         value = CheckBoxSingleData(
40           isEnabled = false,
41           checkbox = getCheckBoxData(isChecked = true),
42           type = CheckBoxType.Error(errorText = "error text".toLabel()),
43         ),
44       ),
45       ScreenShotTestData(
46         screenShotTestName = "ContentBox",
47         value = CheckBoxSingleData(
48           checkbox = getCheckBoxData(),
49           type = CheckBoxType.Helper(helperText = "helper text".toLabel()),
50           contentType = CheckboxContentType.CONTENT_BOX,
51         ),
52       ),
53       ScreenShotTestData(
54         screenShotTestName = "Url",
55         value = CheckBoxSingleData(
56           checkbox = getCheckBoxData(
57             clickableTextData = ClickableTextData.Link(
58               linkData = LinkData(
59                 label = "urlText".toLabel(),
60                 url = "url",
61                 linkType = LinkData.LinkType.WEBSITE,
62                 onClick = { url -> println("Checkbox $url clicked") },
63               ),
64             ),
65           ),
66           contentType = CheckboxContentType.CONTENT_BOX,
67         ),
68       ),
69       ScreenShotTestData(
70         screenShotTestName = "CheckBoxTextButton",
71         value = CheckBoxSingleData(
72           checkbox = getCheckBoxData(
73             clickableTextData = ClickableTextData.Button(
74               buttonData = ButtonTextData(
75                 label = "textButton".toLabel(),
76                 onClick = { println("buttonText clicked") },
77               ),
78             ),
79           ),
80           contentType = CheckboxContentType.CONTENT_BOX,
81         ),
82       ),
83       ScreenShotTestData(
84         screenShotTestName = "UrlWithError",
85         value = CheckBoxSingleData(
86           checkbox = getCheckBoxData(
87             clickableTextData = ClickableTextData.Link(
88               linkData = LinkData(
89                 label = "urlText".toLabel(),
90                 url = "url",
91                 linkType = LinkData.LinkType.WEBSITE,
92                 onClick = { url -> println("Checkbox $url clicked") },
93               ),
94             ),
95           ),
96           type = CheckBoxType.Error(errorText = "error text".toLabel()),
97         ),
98       ),
99     )
100  
101    private fun getCheckBoxData(
102      isChecked: Boolean = false,
103      clickableTextData: ClickableTextData? = null,
104    ) = CheckBoxRowData(
105      isChecked = isChecked,
106      onCheckedChange = {},
107      label = "Checkbox label".toLabel(),
108      clickableTextData = clickableTextData,
109    )
110  }
111  