1    package pl.gov.coi.common.ui.ds.banner
2    
3    import androidx.compose.runtime.Composable
4    import androidx.compose.ui.graphics.Color
5    import pl.gov.coi.common.domain.label.Label
6    import pl.gov.coi.common.ui.R
7    import pl.gov.coi.common.ui.ds.button.ButtonData
8    import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
9    import pl.gov.coi.common.ui.ds.button.buttontext.ButtonTextData
10   import pl.gov.coi.common.ui.ds.custom.icon.IconData
11   import pl.gov.coi.common.ui.ds.custom.icon.IconSize
12   import pl.gov.coi.common.ui.theme.AppTheme
13   
14   sealed class BannerData(
15     val title: Label?,
16     val bodyText: Label,
17     iconResId: Int,
18     iconColorProvider: @Composable () -> Color,
19     iconContentDescription: Label,
20     onCloseButtonClick: (() -> Unit)?,
21     closeIconContentDescription: Label,
22   ) {
23   
24     internal open val closeButtonData = onCloseButtonClick?.let { onCloseButtonClick ->
25       ButtonIconData(
26         iconResId = R.drawable.ab009_x_mark,
27         iconColorProvider = { AppTheme.colors.neutral200 },
28         onClick = onCloseButtonClick,
29         contentDescription = closeIconContentDescription,
30       )
31     }
32   
33     internal val iconData: IconData = IconData.Standard(
34       iconResId = iconResId,
35       iconSize = IconSize.SIZE24,
36       iconColorProvider = iconColorProvider,
37       contentDescription = iconContentDescription,
38     )
39   
40     class Info(
41       title: Label? = null,
42       bodyText: Label,
43       iconContentDescription: Label,
44       val buttonData: ButtonTextData? = null,
45       onCloseButtonClick: (() -> Unit)? = null,
46       closeIconContentDescription: Label = Label.EMPTY,
47     ) : BannerData(
48       title = title,
49       bodyText = bodyText,
50       iconResId = R.drawable.c1_info,
51       iconColorProvider = { AppTheme.colors.supportBlue100 },
52       iconContentDescription = iconContentDescription,
53       onCloseButtonClick = onCloseButtonClick,
54       closeIconContentDescription = closeIconContentDescription,
55     )
56   
57     class Error(
58       title: Label? = null,
59       bodyText: Label,
60       iconContentDescription: Label,
61       val buttonData: ButtonTextData? = null,
62       onCloseButtonClick: (() -> Unit)? = null,
63       closeIconContentDescription: Label = Label.EMPTY,
64     ) : BannerData(
65       title = title,
66       bodyText = bodyText,
67       iconResId = R.drawable.c3_error_mark,
68       iconColorProvider = { AppTheme.colors.supportRed100 },
69       iconContentDescription = iconContentDescription,
70       onCloseButtonClick = onCloseButtonClick,
71       closeIconContentDescription = closeIconContentDescription,
72     )
73   
74     class HighEmphasisInfo(
75       title: Label? = null,
76       bodyText: Label,
77       iconContentDescription: Label,
78       val buttonData: ButtonData? = null,
79       onCloseButtonClick: (() -> Unit)? = null,
80       closeIconContentDescription: Label = Label.EMPTY,
81     ) : BannerData(
82       title = title,
83       bodyText = bodyText,
84       iconResId = R.drawable.c1_info,
85       iconColorProvider = { AppTheme.colors.white },
86       iconContentDescription = iconContentDescription,
87       onCloseButtonClick = onCloseButtonClick,
88       closeIconContentDescription = closeIconContentDescription,
89     ) {
90       override val closeButtonData = onCloseButtonClick?.let { onCloseButtonClick ->
91         ButtonIconData(
92           iconResId = R.drawable.ab009_x_mark,
93           iconColorProvider = { AppTheme.colors.white },
94           onClick = onCloseButtonClick,
95           contentDescription = closeIconContentDescription,
96         )
97       }
98     }
99   
100    class HighEmphasisError(
101      title: Label? = null,
102      bodyText: Label,
103      iconContentDescription: Label,
104      val buttonData: ButtonData? = null,
105      onCloseButtonClick: (() -> Unit)? = null,
106      closeIconContentDescription: Label = Label.EMPTY,
107    ) : BannerData(
108      title = title,
109      bodyText = bodyText,
110      iconResId = R.drawable.c3_error_mark,
111      iconColorProvider = { AppTheme.colors.white },
112      iconContentDescription = iconContentDescription,
113      onCloseButtonClick = onCloseButtonClick,
114      closeIconContentDescription = closeIconContentDescription,
115    ) {
116      override val closeButtonData = onCloseButtonClick?.let { onCloseButtonClick ->
117        ButtonIconData(
118          iconResId = R.drawable.ab009_x_mark,
119          iconColorProvider = { AppTheme.colors.white },
120          onClick = onCloseButtonClick,
121          contentDescription = closeIconContentDescription,
122        )
123      }
124    }
125  }
126  