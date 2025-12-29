1    package pl.gov.coi.common.ui.ds.textinput
2    
3    import androidx.compose.foundation.layout.Column
4    import androidx.compose.foundation.layout.Spacer
5    import androidx.compose.foundation.layout.height
6    import androidx.compose.foundation.layout.wrapContentHeight
7    import androidx.compose.runtime.Composable
8    import androidx.compose.ui.Modifier
9    import androidx.compose.ui.platform.LocalFocusManager
10   import androidx.compose.ui.semantics.LiveRegionMode
11   import androidx.compose.ui.semantics.liveRegion
12   import androidx.compose.ui.semantics.semantics
13   import androidx.compose.ui.semantics.stateDescription
14   import androidx.compose.ui.tooling.preview.Preview
15   import androidx.compose.ui.tooling.preview.PreviewParameter
16   import pl.gov.coi.common.domain.validators.ValidationState
17   import pl.gov.coi.common.ui.ds.button.buttontext.ButtonText
18   import pl.gov.coi.common.ui.ds.errortext.ErrorText
19   import pl.gov.coi.common.ui.ds.helpertext.HelperText
20   import pl.gov.coi.common.ui.ds.textinput.model.TextInputData
21   import pl.gov.coi.common.ui.ds.textinput.provider.TextInputPreviewParameterProvider
22   import pl.gov.coi.common.ui.focus.FocusHost
23   import pl.gov.coi.common.ui.focus.createFocusHost
24   import pl.gov.coi.common.ui.text.CustomText
25   import pl.gov.coi.common.ui.theme.AppTheme
26   
27   @Composable
28   fun TextInput(
29     data: TextInputData,
30     focusHost: FocusHost = createFocusHost(),
31   ) {
32     val focusManager = LocalFocusManager.current
33     Column(
34       modifier = Modifier
35         .wrapContentHeight()
36         .semantics {
37           if (data.validationState is ValidationState.Invalid) {
38             liveRegion = LiveRegionMode.Assertive
39             stateDescription = (data.validationState as ValidationState.Invalid).message.text
40           }
41         },
42     ) {
43       data.label?.let { label ->
44         CustomText(
45           testTag = data.testTag?.let { tag -> tag + "Text" },
46           ignoreForAccessibility = true,
47           label = label,
48           style = AppTheme.typography.bodyMediumRegular,
49           color = when (data.enabled) {
50             true -> AppTheme.colors.neutral200
51             else -> AppTheme.colors.neutral60
52           },
53         )
54         Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
55       }
56   
57       when (data) {
58         is TextInputData.Pin -> TextFieldPin(
59           data = data,
60           focusHost = focusHost,
61           focusManager = focusManager,
62         )
63         is TextInputData.PhoneNumber -> TextFieldPhoneNumber(
64           data = data,
65           focusHost = focusHost,
66           focusManager = focusManager,
67         )
68         else -> TextField(
69           data = data,
70           focusHost = focusHost,
71           focusManager = focusManager,
72         )
73       }
74   
75       when (val validationState = data.validationState) {
76         is ValidationState.Invalid -> {
77           Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
78           ErrorText(
79             testTag = data.testTag?.let { tag -> tag + "ErrorText" },
80             errorText = validationState.message,
81             ignoreForAccessibility = true,
82           )
83         }
84         else -> data.helperText?.let { helperText ->
85           Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
86           HelperText(
87             testTag = data.testTag?.let { tag -> tag + "HelperText" },
88             helperLabel = helperText,
89             ignoreForAccessibility = true,
90           )
91         }
92       }
93   
94       data.infoButtonData?.let { infoButtonData ->
95         Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing100))
96         ButtonText(data = infoButtonData)
97       }
98     }
99   }
100  
101  @Preview
102  @Composable
103  fun TextInputPreview(@PreviewParameter(TextInputPreviewParameterProvider::class) data: TextInputData) {
104    TextInput(data = data)
105  }
106  