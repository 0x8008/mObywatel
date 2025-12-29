1    package pl.gov.coi.common.ui.ds.smallcards
2    
3    import androidx.compose.foundation.clickable
4    import androidx.compose.foundation.layout.Column
5    import androidx.compose.foundation.layout.Spacer
6    import androidx.compose.foundation.layout.height
7    import androidx.compose.foundation.layout.width
8    import androidx.compose.runtime.Composable
9    import androidx.compose.ui.Alignment
10   import androidx.compose.ui.ExperimentalComposeUiApi
11   import androidx.compose.ui.Modifier
12   import androidx.compose.ui.semantics.Role
13   import androidx.compose.ui.semantics.semantics
14   import androidx.compose.ui.semantics.testTag
15   import androidx.compose.ui.semantics.testTagsAsResourceId
16   import androidx.compose.ui.text.style.TextAlign
17   import androidx.compose.ui.tooling.preview.Preview
18   import androidx.compose.ui.tooling.preview.PreviewParameter
19   import androidx.compose.ui.unit.dp
20   import pl.gov.coi.common.domain.label.Label
21   import pl.gov.coi.common.ui.ds.custom.icon.BackgroundShape
22   import pl.gov.coi.common.ui.ds.custom.icon.Icon
23   import pl.gov.coi.common.ui.ds.custom.icon.IconData
24   import pl.gov.coi.common.ui.ds.custom.icon.IconSize
25   import pl.gov.coi.common.ui.ds.smallcards.provider.SmallCardSPPP
26   import pl.gov.coi.common.ui.text.CustomText
27   import pl.gov.coi.common.ui.theme.AppTheme
28   import pl.gov.coi.common.ui.utils.NoRippleInteractionSource
29   
30   private val componentWidth = 80.dp
31   
32   @OptIn(ExperimentalComposeUiApi::class)
33   @Composable
34   fun SmallCardS(
35     smallCardSData: SmallCardSData,
36   ) {
37     Column(
38       horizontalAlignment = Alignment.CenterHorizontally,
39       modifier = Modifier
40         .width(componentWidth)
41         .semantics { testTagsAsResourceId = true }
42         .semantics { testTag = smallCardSData.testTag ?: smallCardSData.title.tag }
43         .clickable(
44           interactionSource = NoRippleInteractionSource(),
45           indication = null,
46           role = Role.Button,
47           onClick = smallCardSData.onClick,
48         ),
49     ) {
50       Icon(
51         data = IconData.Background(
52           testTag = smallCardSData.testTag?.let { tag -> tag + "Icon" },
53           iconResId = smallCardSData.iconResId,
54           backgroundSize = IconSize.SIZE48,
55           iconSize = IconSize.SIZE24,
56           iconColorProvider = smallCardSData.iconColorProvider,
57           backgroundColorProvider = { AppTheme.colors.white },
58           backgroundShape = BackgroundShape.Rounded,
59           contentDescription = Label.EMPTY,
60         ),
61       )
62       Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing100))
63       CustomText(
64         testTag = smallCardSData.testTag?.let { tag -> tag + "Text" },
65         label = smallCardSData.title,
66         style = AppTheme.typography.bodySmallRegular,
67         color = AppTheme.colors.neutral500,
68         textAlign = TextAlign.Center,
69         labelContentDescription = smallCardSData.title,
70         focusable = false,
71         maxLines = 3,
72       )
73     }
74   }
75   
76   @Preview(showBackground = true)
77   @Composable
78   fun SmallCardSPreview(@PreviewParameter(SmallCardSPPP::class) data: SmallCardSData) {
79     SmallCardS(data)
80   }
81   