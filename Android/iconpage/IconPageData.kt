1    package pl.gov.coi.common.ui.ds.iconpage
2    
3    import androidx.compose.runtime.Composable
4    import androidx.compose.ui.graphics.Color
5    import pl.gov.coi.common.domain.label.Label
6    import pl.gov.coi.common.ui.R
7    import pl.gov.coi.common.ui.ds.custom.icon.IconData
8    import pl.gov.coi.common.ui.ds.custom.icon.IconSize
9    import pl.gov.coi.common.ui.theme.AppTheme
10   
11   data class IconPageData<CONTENT, BOTTOM_CONTENT>(
12     val iconSection: IconSection,
13     val title: Label,
14     val descriptionFirst: Label? = null,
15     val descriptionSecond: Label? = null,
16     val content: CONTENT?,
17     val bottomContent: BOTTOM_CONTENT?,
18   )
19   
20   sealed class IconSection(
21     val icon: IconData,
22   ) {
23   
24     class Empty(
25       iconRes: Int = R.drawable.g002_document_box_big,
26     ) : IconSection(
27       icon = IconData.Standard(
28         iconResId = iconRes,
29         iconSize = IconSize.SIZE96,
30         iconColorProvider = { AppTheme.colors.primary900 },
31         contentDescription = null,
32       ),
33     )
34   
35     sealed class Result(
36       val iconResId: Int,
37       val iconColorProvider: @Composable () -> Color,
38     ) : IconSection(
39       icon = IconData.Standard(
40         iconResId = iconResId,
41         iconSize = IconSize.SIZE64,
42         iconColorProvider = iconColorProvider,
43         contentDescription = null,
44       ),
45     ) {
46       data object Info : Result(
47         iconResId = R.drawable.f1_info,
48         iconColorProvider = { AppTheme.colors.supportBlue100 },
49       )
50   
51       data object Warning : Result(
52         iconResId = R.drawable.f2_warning_mark,
53         iconColorProvider = { AppTheme.colors.supportOrange100 },
54       )
55   
56       data object Failure : Result(
57         iconResId = R.drawable.f3_failure,
58         iconColorProvider = { AppTheme.colors.supportRed100 },
59       )
60   
61       data object Success : Result(
62         iconResId = R.drawable.f4_success,
63         iconColorProvider = { AppTheme.colors.supportGreen100 },
64       )
65     }
66   }
67   