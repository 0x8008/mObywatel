1    package pl.gov.coi.common.ui.ds.errortext
2    
3    import androidx.compose.foundation.layout.Row
4    import androidx.compose.foundation.layout.Spacer
5    import androidx.compose.foundation.layout.width
6    import androidx.compose.runtime.Composable
7    import androidx.compose.ui.Alignment
8    import androidx.compose.ui.Modifier
9    import androidx.compose.ui.semantics.clearAndSetSemantics
10   import androidx.compose.ui.semantics.semantics
11   import androidx.compose.ui.text.style.TextAlign
12   import pl.gov.coi.common.domain.label.Label
13   import pl.gov.coi.common.ui.R
14   import pl.gov.coi.common.ui.ds.custom.icon.Icon
15   import pl.gov.coi.common.ui.ds.custom.icon.IconData
16   import pl.gov.coi.common.ui.ds.custom.icon.IconSize
17   import pl.gov.coi.common.ui.text.CustomText
18   import pl.gov.coi.common.ui.theme.AppTheme
19   
20   @Composable
21   fun ErrorText(
22     testTag: String? = null,
23     errorText: Label,
24     ignoreForAccessibility: Boolean = false,
25   ) {
26     Row(
27       modifier = Modifier.then(
28         if (ignoreForAccessibility) {
29           Modifier.clearAndSetSemantics { }
30         } else {
31           Modifier.semantics(
32             mergeDescendants = true,
33             properties = {},
34           )
35         },
36       ),
37       verticalAlignment = Alignment.CenterVertically,
38     ) {
39       Icon(
40         data = IconData.Standard(
41           testTag = testTag?.let { tag -> tag + "Icon" },
42           iconResId = R.drawable.c3_error_mark,
43           iconSize = IconSize.SIZE20,
44           iconColorProvider = { AppTheme.colors.supportRed100 },
45   
46           contentDescription = Label.EMPTY,
47         ),
48       )
49       Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing50))
50       CustomText(
51         testTag = testTag?.let { tag -> tag + "Text" },
52         textAlign = TextAlign.Start,
53         label = errorText,
54         style = AppTheme.typography.bodySmallRegular,
55         color = AppTheme.colors.supportRed100,
56         ignoreForAccessibility = ignoreForAccessibility,
57       )
58     }
59   }
60   