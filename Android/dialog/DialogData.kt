1    package pl.gov.coi.common.ui.ds.dialog
2    
3    import androidx.annotation.DrawableRes
4    import androidx.compose.runtime.Composable
5    import androidx.compose.ui.Alignment
6    import androidx.compose.ui.graphics.Color
7    import androidx.compose.ui.text.AnnotatedString
8    import androidx.compose.ui.text.style.TextAlign
9    import pl.gov.coi.common.domain.label.Label
10   import pl.gov.coi.common.ui.ds.button.ButtonData
11   
12   sealed class DialogData(
13     open val testTag: String?,
14     open val title: Label,
15     open val body: Label? = null,
16     open val annotatedBody: (@Composable () -> AnnotatedString)? = null,
17     open val primaryButtonData: ButtonData,
18     open val secondaryButtonData: ButtonData? = null,
19     internal val horizontalAlignment: Alignment.Horizontal = Alignment.Start,
20     internal val textAlign: TextAlign = TextAlign.Start,
21     open val onDismiss: () -> Unit,
22   ) {
23     data class WithThreeButtons(
24       override val testTag: String? = null,
25       override val title: Label,
26       override val body: Label? = null,
27       override val annotatedBody: (@Composable () -> AnnotatedString)? = null,
28       override val primaryButtonData: ButtonData,
29       override val secondaryButtonData: ButtonData,
30       val tertiaryButtonData: ButtonData,
31       override val onDismiss: () -> Unit,
32     ) : DialogData(
33       testTag = testTag,
34       title = title,
35       body = body,
36       annotatedBody = annotatedBody,
37       primaryButtonData = primaryButtonData,
38       secondaryButtonData = secondaryButtonData,
39       onDismiss = onDismiss,
40       horizontalAlignment = Alignment.Start,
41       textAlign = TextAlign.Start,
42     )
43   
44     data class WithText(
45       override val testTag: String? = null,
46       override val title: Label,
47       override val body: Label? = null,
48       override val annotatedBody: (@Composable () -> AnnotatedString)? = null,
49       override val primaryButtonData: ButtonData,
50       override val secondaryButtonData: ButtonData? = null,
51       override val onDismiss: () -> Unit,
52     ) : DialogData(
53       testTag = testTag,
54       title = title,
55       body = body,
56       annotatedBody = annotatedBody,
57       primaryButtonData = primaryButtonData,
58       secondaryButtonData = secondaryButtonData,
59       onDismiss = onDismiss,
60       horizontalAlignment = Alignment.Start,
61       textAlign = TextAlign.Start,
62     )
63   
64     data class WithIcon(
65       override val testTag: String? = null,
66       override val title: Label,
67       override val body: Label? = null,
68       override val annotatedBody: (@Composable () -> AnnotatedString)? = null,
69       override val primaryButtonData: ButtonData,
70       override val secondaryButtonData: ButtonData? = null,
71       val icon: DialogIconData,
72       override val onDismiss: () -> Unit,
73     ) : DialogData(
74       testTag = testTag,
75       title = title,
76       body = body,
77       annotatedBody = annotatedBody,
78       primaryButtonData = primaryButtonData,
79       secondaryButtonData = secondaryButtonData,
80       onDismiss = onDismiss,
81       horizontalAlignment = Alignment.CenterHorizontally,
82       textAlign = TextAlign.Center,
83     )
84   }
85   
86   data class DialogIconData(
87     @DrawableRes val iconResId: Int,
88     val iconColorProvider: @Composable () -> Color,
89   )
90   