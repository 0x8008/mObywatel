1    package pl.gov.coi.common.ui.ds.link
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.clickable
5    import androidx.compose.foundation.layout.Box
6    import androidx.compose.foundation.layout.fillMaxWidth
7    import androidx.compose.foundation.layout.padding
8    import androidx.compose.runtime.Composable
9    import androidx.compose.runtime.remember
10   import androidx.compose.ui.Modifier
11   import androidx.compose.ui.semantics.disabled
12   import androidx.compose.ui.semantics.semantics
13   import androidx.compose.ui.text.style.TextAlign
14   import androidx.compose.ui.text.style.TextDecoration
15   import androidx.compose.ui.tooling.preview.Preview
16   import androidx.compose.ui.tooling.preview.PreviewParameter
17   import pl.gov.coi.common.domain.label.CommonUILabelProvider
18   import pl.gov.coi.common.domain.label.toLabel
19   import pl.gov.coi.common.ui.text.CustomText
20   import pl.gov.coi.common.ui.theme.AppTheme
21   import pl.gov.coi.common.ui.utils.MultipleEventsCutter
22   import pl.gov.coi.common.ui.utils.get
23   
24   @Composable
25   fun Link(data: LinkData) {
26     val multipleEventsCutter = remember { MultipleEventsCutter.get() }
27     CustomText(
28       testTag = data.testTag,
29       modifier = Modifier
30         .semantics {
31           if (data.enabled.not()) disabled()
32         }
33         .clickable(
34           enabled = data.enabled,
35           onClick = {
36             multipleEventsCutter.processEvent {
37               data.onClick(data.url)
38             }
39           },
40         ),
41       labelContentDescription = when (data.linkType) {
42         LinkData.LinkType.WEBSITE -> CommonUILabelProvider.linkToWebsite()
43         LinkData.LinkType.E_MAIL -> CommonUILabelProvider.linkToEMail()
44         LinkData.LinkType.EXTERNAL_APP -> CommonUILabelProvider.linkToExternalApp()
45       }.let { wcagLabel -> "${data.label.text}. ${wcagLabel.text}".toLabel(tag = "linkLabel") },
46       textAlign = TextAlign.Start,
47       label = data.label,
48       style = AppTheme.typography.bodyMediumMedium,
49       textDecoration = TextDecoration.Underline,
50       color = when {
51         data.enabled.not() -> AppTheme.colors.neutral60
52         else -> AppTheme.colors.primary900
53       },
54     )
55   }
56   
57   @Preview
58   @Composable
59   fun LinkPreview(
60     @PreviewParameter(LinkPreviewProvider::class)
61     data: LinkData,
62   ) {
63     Box(
64       modifier = Modifier
65         .fillMaxWidth()
66         .background(AppTheme.colors.white)
67         .padding(all = AppTheme.dimensions.spacing200),
68     ) {
69       Link(data = data)
70     }
71   }
72   