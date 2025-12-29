1    package pl.gov.coi.common.ui.ds.custom.clickabletext
2    
3    import androidx.compose.foundation.text.ClickableText
4    import androidx.compose.runtime.Composable
5    import androidx.compose.runtime.remember
6    import androidx.compose.ui.Modifier
7    import androidx.compose.ui.platform.LocalFocusManager
8    import androidx.compose.ui.semantics.Role
9    import androidx.compose.ui.semantics.onClick
10   import androidx.compose.ui.semantics.role
11   import androidx.compose.ui.semantics.semantics
12   import androidx.compose.ui.text.AnnotatedString
13   import androidx.compose.ui.text.TextLayoutResult
14   import androidx.compose.ui.text.TextStyle
15   import androidx.compose.ui.text.style.TextOverflow
16   import pl.gov.coi.common.ui.utils.MultipleEventsCutter
17   import pl.gov.coi.common.ui.utils.get
18   import pl.gov.coi.common.ui.utils.semanticsContentDescription
19   
20   
21   @Composable
22   @Deprecated(message = "For external redirections use Link. For internal redirections use ButtonText")
23   fun CustomClickableText(
24     annotatedText: AnnotatedString,
25     style: TextStyle = TextStyle.Default,
26     softWrap: Boolean = true,
27     overflow: TextOverflow = TextOverflow.Clip,
28     maxLines: Int = Int.MAX_VALUE,
29     onTextLayout: (TextLayoutResult) -> Unit = {},
30     semanticsData: SemanticsData = SemanticsData(),
31     onClick: (String) -> Unit,
32   ) {
33     val focusManager = LocalFocusManager.current
34     val multipleEventsCutter = remember { MultipleEventsCutter.get() }
35   
36     ClickableText(
37       modifier = Modifier
38         .semantics {
39           role = Role.Button
40           onClick { false }
41         }
42         .semantics(
43           mergeDescendants = semanticsData.mergeDescendants,
44           properties = semanticsData.semanticsProperties,
45         )
46         .semanticsContentDescription(
47           semanticsData.semanticsContentDescription ?: annotatedText.text,
48         ),
49       text = annotatedText,
50       style = style,
51       softWrap = softWrap,
52       overflow = overflow,
53       maxLines = maxLines,
54       onTextLayout = onTextLayout,
55       onClick = { offset ->
56         multipleEventsCutter.processEvent {
57           annotatedText.getStringAnnotations(
58             start = offset,
59             end = offset,
60           )
61             .firstOrNull()
62             ?.let { annotation ->
63               onClick(annotation.item)
64             }
65           focusManager.clearFocus(force = true)
66         }
67       },
68     )
69   }
70   