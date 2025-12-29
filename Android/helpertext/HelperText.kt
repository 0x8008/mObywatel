1    package pl.gov.coi.common.ui.ds.helpertext
2    
3    import androidx.compose.runtime.Composable
4    import androidx.compose.ui.text.style.TextAlign
5    import pl.gov.coi.common.domain.label.Label
6    import pl.gov.coi.common.ui.text.CustomText
7    import pl.gov.coi.common.ui.theme.AppTheme
8    
9    @Composable
10   fun HelperText(
11     testTag: String? = null,
12     helperLabel: Label,
13     ignoreForAccessibility: Boolean = false,
14   ) {
15     CustomText(
16       testTag = testTag,
17       textAlign = TextAlign.Start,
18       label = helperLabel,
19       style = AppTheme.typography.bodySmallRegular,
20       color = AppTheme.colors.neutral200,
21       ignoreForAccessibility = ignoreForAccessibility,
22     )
23   }
24   