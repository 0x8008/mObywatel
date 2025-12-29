1    package pl.gov.coi.common.ui.ds.alert
2    
3    import androidx.compose.runtime.Composable
4    import androidx.compose.ui.graphics.Color
5    import pl.gov.coi.common.domain.label.CommonUILabelProvider
6    import pl.gov.coi.common.domain.label.Label
7    import pl.gov.coi.common.ui.R
8    import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
9    import pl.gov.coi.common.ui.ds.custom.icon.IconData
10   import pl.gov.coi.common.ui.ds.custom.icon.IconSize
11   import pl.gov.coi.common.ui.theme.AppTheme
12   
13   sealed class AlertData(
14     val testTag: String?,
15     val alertContentDescription: Label,
16     val title: Label?,
17     val bodyText: Label,
18     iconResId: Int,
19     iconColorProvider: @Composable () -> Color,
20     onCloseButtonClick: (() -> Unit)?,
21     closeIconContentDescription: Label,
22     val alertButtonData: AlertButtonData?,
23   ) {
24   
25     internal val closeButtonData = onCloseButtonClick?.let { onCloseButtonClick ->
26       ButtonIconData(
27         iconResId = R.drawable.ab009_x_mark,
28         iconColorProvider = { AppTheme.colors.neutral200 },
29         onClick = onCloseButtonClick,
30         contentDescription = closeIconContentDescription,
31       )
32     }
33   
34     internal val iconData: IconData = IconData.Standard(
35       iconResId = iconResId,
36       iconSize = IconSize.SIZE24,
37       iconColorProvider = iconColorProvider,
38       contentDescription = null,
39     )
40   
41     class Info(
42       testTag: String? = null,
43       alertContentDescription: Label = CommonUILabelProvider.commonAccessibilityInformation(),
44       title: Label? = null,
45       bodyText: Label,
46       onCloseButtonClick: (() -> Unit)? = null,
47       closeIconContentDescription: Label = CommonUILabelProvider.commonAccessibilityCloseInformation(),
48       alertButtonData: AlertButtonData? = null,
49     ) : AlertData(
50       testTag = testTag,
51       alertContentDescription = alertContentDescription,
52       title = title,
53       bodyText = bodyText,
54       iconResId = R.drawable.c1_info,
55       iconColorProvider = { AppTheme.colors.supportBlue100 },
56       onCloseButtonClick = onCloseButtonClick,
57       closeIconContentDescription = closeIconContentDescription,
58       alertButtonData = alertButtonData,
59     )
60   
61     class Warning(
62       testTag: String? = null,
63       alertContentDescription: Label = CommonUILabelProvider.commonAccessibilityWarningInformation(),
64       title: Label? = null,
65       bodyText: Label,
66       onCloseButtonClick: (() -> Unit)? = null,
67       closeIconContentDescription: Label = CommonUILabelProvider.commonAccessibilityCloseWarningInformation(),
68       alertButtonData: AlertButtonData? = null,
69     ) : AlertData(
70       testTag = testTag,
71       alertContentDescription = alertContentDescription,
72       title = title,
73       bodyText = bodyText,
74       iconResId = R.drawable.c2_warning_mark,
75       iconColorProvider = { AppTheme.colors.supportOrange100 },
76       onCloseButtonClick = onCloseButtonClick,
77       closeIconContentDescription = closeIconContentDescription,
78       alertButtonData = alertButtonData,
79     )
80   
81     class Success(
82       testTag: String? = null,
83       alertContentDescription: Label = CommonUILabelProvider.commonAccessibilitySuccessInformation(),
84       title: Label? = null,
85       bodyText: Label,
86       onCloseButtonClick: (() -> Unit)? = null,
87       closeIconContentDescription: Label = CommonUILabelProvider.commonAccessibilityCloseSuccessInformation(),
88       alertButtonData: AlertButtonData? = null,
89     ) : AlertData(
90       testTag = testTag,
91       alertContentDescription = alertContentDescription,
92       title = title,
93       bodyText = bodyText,
94       iconResId = R.drawable.c4_success,
95       iconColorProvider = {
96         val alertSuccessIconColor = Color(0xFF427639)
97         alertSuccessIconColor
98       },
99       onCloseButtonClick = onCloseButtonClick,
100      closeIconContentDescription = closeIconContentDescription,
101      alertButtonData = alertButtonData,
102    )
103  
104    class Error(
105      testTag: String? = null,
106      alertContentDescription: Label = CommonUILabelProvider.commonAccessibilityErrorInformation(),
107      title: Label? = null,
108      bodyText: Label,
109      onCloseButtonClick: (() -> Unit)? = null,
110      closeIconContentDescription: Label = CommonUILabelProvider.commonAccessibilityCloseSuccessInformation(),
111      alertButtonData: AlertButtonData? = null,
112    ) : AlertData(
113      testTag = testTag,
114      alertContentDescription = alertContentDescription,
115      title = title,
116      bodyText = bodyText,
117      iconResId = R.drawable.c3_error_mark,
118      iconColorProvider = { AppTheme.colors.supportRed100 },
119      onCloseButtonClick = onCloseButtonClick,
120      closeIconContentDescription = closeIconContentDescription,
121      alertButtonData = alertButtonData,
122    )
123  }
124  