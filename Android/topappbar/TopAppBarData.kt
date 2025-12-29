1    package pl.gov.coi.common.ui.ds.topappbar
2    
3    import androidx.annotation.DrawableRes
4    import androidx.compose.runtime.Composable
5    import androidx.compose.ui.graphics.Color
6    import pl.gov.coi.common.domain.label.CommonUILabelProvider
7    import pl.gov.coi.common.domain.label.Label
8    import pl.gov.coi.common.ui.R
9    import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
10   import pl.gov.coi.common.ui.ds.menus.MenuData
11   import pl.gov.coi.common.ui.ds.progressbar.ProgressBarData
12   import pl.gov.coi.common.ui.theme.AppTheme
13   
14   sealed interface TopAppBarData {
15     sealed class Small(
16       val menuType: MenuType? = null,
17       val containerColor: @Composable () -> Color,
18     ) : TopAppBarData {
19       class Default(
20         val navigationButtonData: NavigationButtonData? = null,
21         val title: Label? = null,
22         val alignment: TitleAlignment = TitleAlignment.Center,
23         menuType: MenuType? = null,
24         val progressBarData: ProgressBarData? = null,
25         val forceTitleFocusTrigger: Boolean? = true,
26         containerColor: @Composable () -> Color = { AppTheme.colors.background },
27       ) : Small(
28         menuType = menuType,
29         containerColor = containerColor,
30       )
31   
32       class Sygnet(
33         menuType: MenuType? = null,
34         containerColor: @Composable () -> Color = { AppTheme.colors.background },
35       ) : Small(
36         menuType = menuType,
37         containerColor = containerColor,
38       )
39   
40       class Logo(
41         val navigationButtonData: NavigationButtonData? = null,
42         containerColor: @Composable () -> Color = { AppTheme.colors.background },
43         menuType: MenuType? = null,
44       ) : Small(
45         menuType = menuType,
46         containerColor = containerColor,
47       )
48     }
49   
50     data class Medium(
51       val navigationButtonData: NavigationButtonData? = null,
52       val title: Label,
53       val menuType: MenuType? = null,
54       val forceTitleFocusTrigger: Boolean? = true,
55       val containerColor: @Composable () -> Color = { AppTheme.colors.background },
56     ) : TopAppBarData
57   
58     data class Large(
59       val navigationButtonData: NavigationButtonData? = null,
60       val title: Label,
61       val menuType: MenuType? = null,
62       val forceTitleFocusTrigger: Boolean? = true,
63       val containerColor: @Composable () -> Color = { AppTheme.colors.background },
64     ) : TopAppBarData
65   }
66   
67   data class NavigationButtonData(
68     val icon: Icon,
69     val onClick: () -> Unit,
70   ) {
71     data class Icon(
72       @DrawableRes val iconResId: Int,
73       val contentDescription: Label,
74     ) {
75       companion object {
76         val BACK_ARROW: Icon = Icon(
77           iconResId = R.drawable.ab004_arrow_left,
78           contentDescription = CommonUILabelProvider.topAppBarArrowBack(),
79         )
80       }
81     }
82   }
83   
84   enum class TitleAlignment {
85     Center, Left
86   }
87   
88   sealed interface MenuType {
89     data class Icon(
90       val menuButtonData: MenuButtonData,
91     ) : MenuType
92   
93     data class IconList(
94       val menuIconList: List<MenuButtonData>,
95     ) : MenuType
96   
97     data class MenuButtonData(
98       val icon: MenuIcon,
99       val iconColorProvider: @Composable () -> Color = { AppTheme.colors.neutral200 },
100      val menuData: MenuData? = null,
101      val onClick: () -> Unit,
102    ) {
103      fun getButton() = ButtonIconData(
104        iconResId = icon.iconResId,
105        iconColorProvider = iconColorProvider,
106        menuData = menuData,
107        contentDescription = icon.contentDescription,
108        onClick = onClick,
109      )
110  
111      interface MenuIcon {
112        @get:DrawableRes
113        val iconResId: Int
114        val contentDescription: Label
115      }
116  
117      enum class DefaultMenuIcon(
118        override val iconResId: Int,
119        override val contentDescription: Label,
120      ) : MenuIcon {
121        CLOSE(
122          iconResId = R.drawable.ab009_x_mark,
123          contentDescription = CommonUILabelProvider.commonAccessibilityClose(),
124        ),
125        QUESTION_MARK(
126          iconResId = R.drawable.ab015_help,
127          contentDescription = CommonUILabelProvider.commonAccessibilityFindOutMore(),
128        ),
129        EDIT(
130          iconResId = R.drawable.ab017_edit,
131          contentDescription = CommonUILabelProvider.commonAccessibilityEdit(),
132        ),
133        DELETE(
134          iconResId = R.drawable.aa002_delete,
135          contentDescription = CommonUILabelProvider.commonAccessibilityDelete(),
136        ),
137        SETTINGS(
138          iconResId = R.drawable.ab003_settings,
139          contentDescription = CommonUILabelProvider.commonAccessibilitySettings(),
140        ),
141      }
142    }
143  
144  }
145  