1    package pl.gov.coi.common.ui.ds.switchcomponent
2    
3    import androidx.compose.foundation.ExperimentalFoundationApi
4    import androidx.compose.foundation.layout.Arrangement
5    import androidx.compose.foundation.layout.Box
6    import androidx.compose.foundation.layout.Column
7    import androidx.compose.foundation.layout.Row
8    import androidx.compose.foundation.layout.Spacer
9    import androidx.compose.foundation.layout.fillMaxWidth
10   import androidx.compose.foundation.layout.height
11   import androidx.compose.foundation.layout.width
12   import androidx.compose.foundation.layout.wrapContentHeight
13   import androidx.compose.foundation.relocation.BringIntoViewRequester
14   import androidx.compose.foundation.relocation.bringIntoViewRequester
15   import androidx.compose.foundation.selection.toggleable
16   import androidx.compose.runtime.Composable
17   import androidx.compose.runtime.getValue
18   import androidx.compose.runtime.mutableStateOf
19   import androidx.compose.runtime.remember
20   import androidx.compose.runtime.rememberCoroutineScope
21   import androidx.compose.runtime.setValue
22   import androidx.compose.ui.Alignment
23   import androidx.compose.ui.Modifier
24   import androidx.compose.ui.layout.onGloballyPositioned
25   import androidx.compose.ui.layout.positionInWindow
26   import androidx.compose.ui.semantics.CustomAccessibilityAction
27   import androidx.compose.ui.semantics.LiveRegionMode
28   import androidx.compose.ui.semantics.Role
29   import androidx.compose.ui.semantics.clearAndSetSemantics
30   import androidx.compose.ui.semantics.customActions
31   import androidx.compose.ui.semantics.liveRegion
32   import androidx.compose.ui.semantics.role
33   import androidx.compose.ui.semantics.semantics
34   import androidx.compose.ui.semantics.stateDescription
35   import androidx.compose.ui.semantics.toggleableState
36   import androidx.compose.ui.state.ToggleableState
37   import androidx.compose.ui.unit.IntOffset
38   import kotlinx.coroutines.launch
39   import pl.gov.coi.common.domain.label.CommonUILabelProvider
40   import pl.gov.coi.common.domain.validators.ValidationState
41   import pl.gov.coi.common.ui.ds.button.buttontext.ButtonText
42   import pl.gov.coi.common.ui.ds.errortext.ErrorText
43   import pl.gov.coi.common.ui.ds.link.Link
44   import pl.gov.coi.common.ui.text.CustomText
45   import pl.gov.coi.common.ui.theme.AppTheme
46   
47   @OptIn(ExperimentalFoundationApi::class)
48   @Composable
49   fun SwitchWithExtras(data: SwitchData.SwitchWithExtras) {
50     val bringIntoViewRequester = remember { BringIntoViewRequester() }
51     var inputFieldCoordinates by remember { mutableStateOf(IntOffset(0, 0)) }
52     val coroutineScope = rememberCoroutineScope()
53     var validationMessageShowed by remember { mutableStateOf(false) }
54   
55     fun getSwitchLabel() = "${data.label.text} ${CommonUILabelProvider.switchLabel().text} " +
56       if (data.checked) {
57         CommonUILabelProvider.switchOnLabel().text
58       } else {
59         CommonUILabelProvider.switchOffLabel().text
60       }
61   
62     Column(
63       modifier = Modifier
64         .fillMaxWidth()
65         .wrapContentHeight()
66         .bringIntoViewRequester(bringIntoViewRequester = bringIntoViewRequester)
67         .onGloballyPositioned { coordinates ->
68           inputFieldCoordinates = IntOffset(
69             x = coordinates.positionInWindow().x.toInt(),
70             y = coordinates.positionInWindow().y.toInt(),
71           )
72           if ((data.validationState is ValidationState.Invalid) && !validationMessageShowed) {
73             coroutineScope.launch {
74               bringIntoViewRequester.bringIntoView()
75               validationMessageShowed = true
76             }
77           }
78         },
79     ) {
80       Row(
81         modifier = Modifier
82           .toggleable(
83             role = Role.Switch,
84             value = data.checked,
85             enabled = true,
86             onValueChange = { (data.onCheckedChange?.invoke(data.checked.not())) },
87           )
88           .semantics(
89             mergeDescendants = true,
90             properties = {},
91           )
92           .semantics {
93             if (data.validationState is ValidationState.Invalid) {
94               liveRegion = LiveRegionMode.Assertive
95               stateDescription = data.validationState.message.text
96             }
97             role = Role.Switch
98             toggleableState = ToggleableState(data.checked)
99             customActions = listOf(
100              CustomAccessibilityAction(
101                label = data.customActionContentDescription.text,
102                action = {
103                  when (data.type) {
104                    is SwitchExtraType.Link -> data.type.data.onClick(data.type.data.url)
105                    is SwitchExtraType.TextButton -> data.type.data.onClick()
106                  }
107                  true
108                },
109              ),
110              CustomAccessibilityAction(
111                label = getSwitchLabel(),
112                action = {
113                  data.onCheckedChange?.invoke(data.checked.not())
114                  true
115                },
116              ),
117            )
118          },
119        horizontalArrangement = Arrangement.Start,
120        verticalAlignment = Alignment.CenterVertically,
121      ) {
122        Column(
123          modifier = Modifier
124            .weight(1f),
125        ) {
126          CustomText(
127            testTag = data.testTag?.let { tag -> tag + "Text" },
128            label = data.label,
129            style = AppTheme.typography.bodyMediumRegular,
130            color = AppTheme.colors.neutral200,
131          )
132          Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing100))
133          when (data.type) {
134            is SwitchExtraType.Link -> Link(
135              data = data.type.data,
136            )
137  
138            is SwitchExtraType.TextButton -> ButtonText(
139              data = data.type.data,
140            )
141          }
142        }
143        Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing100))
144  
145        Box(
146          modifier = Modifier
147            .clearAndSetSemantics {}
148            .semantics(
149              mergeDescendants = true,
150              properties = {},
151            ),
152        ) {
153          SwitchOnly(
154            data = SwitchData.SwitchOnly(
155              testTag = data.testTag?.let { tag -> tag + "Switch" },
156              checked = data.checked,
157              enabled = data.enabled,
158              onCheckedChange = { value ->
159                data.onCheckedChange?.invoke(value)
160              },
161              contentDescription = data.label,
162              testIndexTag = data.testIndexTag,
163            ),
164          )
165        }
166      }
167      if (data.validationState is ValidationState.Invalid) {
168        Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing100))
169        ErrorText(
170          testTag = data.testTag?.let { tag -> tag + "ErrorText" },
171          errorText = data.validationState.message,
172          ignoreForAccessibility = true,
173        )
174      }
175    }
176  }
177  