1    package pl.gov.coi.common.ui.ds.servicewelcomepage
2    
3    import androidx.annotation.DrawableRes
4    import pl.gov.coi.common.domain.label.Label
5    import pl.gov.coi.common.ui.ds.alert.AlertData
6    import pl.gov.coi.common.ui.ds.button.ButtonData
7    import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
8    import pl.gov.coi.common.ui.ds.header.HeaderData
9    import pl.gov.coi.common.ui.theme.AppTheme
10   
11   class ServiceWelcomePageData<CONTENT_DATA>(
12     internal val topBarTitle: Label,
13     @DrawableRes topBarIconMainResId: Int?,
14     topBarIconMainContentDescription: Label = Label.EMPTY,
15     onTopBarIconMainClick: (() -> Unit)?,
16     @DrawableRes topBarIconMenuResId: Int?,
17     onTopBarIconMenuClick: (() -> Unit)?,
18     internal val headerData: HeaderData,
19     internal val alertData: AlertData? = null,
20     internal val contentData: CONTENT_DATA,
21     internal val buttonData: ButtonData?,
22     internal val pullToRefreshEnabled: Boolean = false,
23     internal val refreshAction: () -> Unit = {},
24   ) {
25   
26     internal val mainButtonData: ButtonIconData? =
27       topBarIconMainResId?.let {
28         
29         ButtonIconData(
30           iconResId = it,
31           onClick = onTopBarIconMainClick ?: {},
32           iconColorProvider = { AppTheme.colors.neutral200 },
33           contentDescription = topBarIconMainContentDescription,
34         )
35       }
36   
37     internal val menuButtonData: ButtonIconData? =
38       topBarIconMenuResId?.let {
39         
40         ButtonIconData(
41           iconResId = it,
42           onClick = onTopBarIconMenuClick ?: {},
43           iconColorProvider = { AppTheme.colors.neutral200 },
44         )
45       }
46   }
47   