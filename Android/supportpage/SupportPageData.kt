1    package pl.gov.coi.common.ui.ds.supportpage
2    
3    import androidx.annotation.DrawableRes
4    import pl.gov.coi.common.domain.label.Label
5    import pl.gov.coi.common.ui.ds.button.ButtonData
6    import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
7    import pl.gov.coi.common.ui.ds.custom.icon.BackgroundShape
8    import pl.gov.coi.common.ui.ds.custom.icon.IconData
9    import pl.gov.coi.common.ui.ds.custom.icon.IconSize
10   import pl.gov.coi.common.ui.theme.AppTheme
11   
12   class SupportPageData<CONTENT_DATA>(
13     internal val topBarTitle: Label,
14     @DrawableRes topBarIconMainResId: Int?,
15     onTopBarIconMainClick: (() -> Unit)?,
16     @DrawableRes topBarIconMenuResId: Int?,
17     onTopBarIconMenuClick: (() -> Unit)?,
18     @DrawableRes iconResId: Int,
19     iconContentDescription: Label,
20     internal val title: Label,
21     internal val message: Label?,
22     internal val contentData: CONTENT_DATA,
23     internal val buttonData: ButtonData?,
24   ) {
25     internal val iconData: IconData.Background = IconData.Background(
26       iconResId = iconResId,
27       backgroundSize = IconSize.SIZE96,
28       iconSize = IconSize.SIZE64,
29       iconColorProvider = { AppTheme.colors.primary900 },
30       backgroundColorProvider = { AppTheme.colors.secondary900 },
31       backgroundShape = BackgroundShape.Rounded,
32       contentDescription = iconContentDescription,
33     )
34   
35     internal val mainButtonData: ButtonIconData? =
36       topBarIconMainResId?.let {
37         ButtonIconData(
38           
39           iconResId = it,
40           iconColorProvider = { AppTheme.colors.neutral200 },
41           onClick = onTopBarIconMainClick ?: {},
42         )
43       }
44   
45     internal val menuButtonData: ButtonIconData? =
46       topBarIconMenuResId?.let {
47         ButtonIconData(
48           
49           iconResId = it,
50           iconColorProvider = { AppTheme.colors.neutral200 },
51           onClick = onTopBarIconMenuClick ?: {},
52         )
53       }
54   }
55   