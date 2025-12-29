1    package pl.gov.coi.common.ui.ds.switchcomponent
2    
3    import androidx.compose.foundation.ExperimentalFoundationApi
4    import androidx.compose.foundation.layout.Arrangement
5    import androidx.compose.foundation.layout.Column
6    import androidx.compose.foundation.layout.Row
7    import androidx.compose.foundation.layout.Spacer
8    import androidx.compose.foundation.layout.fillMaxWidth
9    import androidx.compose.foundation.layout.height
10   import androidx.compose.foundation.layout.width
11   import androidx.compose.foundation.layout.wrapContentHeight
12   import androidx.compose.foundation.relocation.BringIntoViewRequester
13   import androidx.compose.foundation.relocation.bringIntoViewRequester
14   import androidx.compose.foundation.selection.toggleable
15   import androidx.compose.runtime.Composable
16   import androidx.compose.runtime.getValue
17   import androidx.compose.runtime.mutableStateOf
18   import androidx.compose.runtime.remember
19   import androidx.compose.runtime.rememberCoroutineScope
20   import androidx.compose.runtime.setValue
21   import androidx.compose.ui.Alignment
22   import androidx.compose.ui.Modifier
23   import androidx.compose.ui.layout.onGloballyPositioned
24   import androidx.compose.ui.layout.positionInWindow
25   import androidx.compose.ui.semantics.Role
26   import androidx.compose.ui.unit.IntOffset
27   import kotlinx.coroutines.launch
28   import pl.gov.coi.common.domain.validators.ValidationState
29   import pl.gov.coi.common.ui.ds.errortext.ErrorText
30   import pl.gov.coi.common.ui.text.CustomText
31   import pl.gov.coi.common.ui.theme.AppTheme
32   
33   
34   @OptIn(ExperimentalFoundationApi::class)
35   @Composable
36   internal fun SwitchWithText(
37     data: SwitchData.SwitchWithText,
38   ) {
39     val bringIntoViewRequester = remember { BringIntoViewRequester() }
40     var inputFieldCoordinates by remember { mutableStateOf(IntOffset(0, 0)) }
41     val coroutineScope = rememberCoroutineScope()
42     var validationMessageShowed by remember { mutableStateOf(false) }
43   
44     Column(
45       modifier = Modifier
46         .fillMaxWidth()
47         .wrapContentHeight()
48         .bringIntoViewRequester(bringIntoViewRequester = bringIntoViewRequester)
49         .toggleable(
50           role = Role.Switch,
51           value = data.checked,
52           enabled = false,
53           onValueChange = { value -> data.onCheckedChange?.invoke(value) },
54         )
55         .onGloballyPositioned { coordinates ->
56           inputFieldCoordinates = IntOffset(
57             x = coordinates.positionInWindow().x.toInt(),
58             y = coordinates.positionInWindow().y.toInt(),
59           )
60           if ((data.validationState is ValidationState.Invalid) && !validationMessageShowed) {
61             coroutineScope.launch {
62               bringIntoViewRequester.bringIntoView()
63               validationMessageShowed = true
64             }
65           }
66         },
67     ) {
68       Row(
69         modifier = Modifier.fillMaxWidth(),
70         horizontalArrangement = Arrangement.Start,
71         verticalAlignment = Alignment.CenterVertically,
72       ) {
73         CustomText(
74           testTag = data.testTag?.let { tag -> tag + "Text" },
75           modifier = Modifier
76             .weight(1f),
77           label = data.label,
78           style = AppTheme.typography.bodyMediumRegular,
79           color = AppTheme.colors.neutral200,
80         )
81         Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing100))
82         SwitchOnly(
83           data = SwitchData.SwitchOnly(
84             testTag = data.testTag?.let { tag -> tag + "Switch" },
85             checked = data.checked,
86             enabled = data.enabled,
87             onCheckedChange = data.onCheckedChange,
88             contentDescription = data.label,
89             testIndexTag = data.testIndexTag,
90           ),
91         )
92       }
93       if (data.validationState is ValidationState.Invalid) {
94         Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing100))
95         ErrorText(testTag = data.testTag?.let { tag -> tag + "ErrorText" }, errorText = data.validationState.message)
96       }
97     }
98   }
99   