1    package pl.gov.coi.common.ui.ds.button.buttontext
2    
3    import androidx.compose.foundation.clickable
4    import androidx.compose.foundation.layout.Row
5    import androidx.compose.foundation.layout.heightIn
6    import androidx.compose.runtime.Composable
7    import androidx.compose.runtime.remember
8    import androidx.compose.ui.Alignment
9    import androidx.compose.ui.Modifier
10   import androidx.compose.ui.platform.LocalFocusManager
11   import androidx.compose.ui.semantics.Role
12   import androidx.compose.ui.semantics.role
13   import androidx.compose.ui.semantics.semantics
14   import androidx.compose.ui.semantics.testTag
15   import androidx.compose.ui.tooling.preview.Preview
16   import androidx.compose.ui.tooling.preview.PreviewParameter
17   import pl.gov.coi.common.ui.ds.button.common.ButtonState
18   import pl.gov.coi.common.ui.text.CustomText
19   import pl.gov.coi.common.ui.theme.AppTheme
20   import pl.gov.coi.common.ui.utils.MultipleEventsCutter
21   import pl.gov.coi.common.ui.utils.NoRippleInteractionSource
22   import pl.gov.coi.common.ui.utils.get
23   
24   @Composable
25   fun ButtonText(
26     modifier: Modifier = Modifier,
27     data: ButtonTextData,
28   ) {
29     val focusManager = LocalFocusManager.current
30     val multipleEventsCutter = remember { MultipleEventsCutter.get() }
31     val textColor = when (data.buttonState) {
32       ButtonState.Enabled -> AppTheme.colors.primary900
33       ButtonState.Destructive -> AppTheme.colors.supportRed100
34       ButtonState.Disabled -> AppTheme.colors.neutral60
35     }
36     Row(
37       verticalAlignment = Alignment.CenterVertically,
38       modifier = modifier
39         .heightIn(min = AppTheme.dimensions.spacing250)
40         .semantics {
41           testTag = data.testTag ?: "button${data.label.tag}"
42           role = Role.Button
43         }
44         .clickable(
45           interactionSource = NoRippleInteractionSource(),
46           indication = null,
47           onClick = {
48             multipleEventsCutter.processEvent {
49               data.onClick()
50               focusManager.clearFocus(force = true)
51             }
52           },
53           enabled = data.buttonState == ButtonState.Enabled || data.buttonState == ButtonState.Destructive,
54         ),
55     ) {
56       CustomText(
57         label = data.label,
58         style = AppTheme.typography.bodyMediumMedium,
59         color = textColor,
60       )
61     }
62   }
63   
64   @Preview
65   @Composable
66   fun ButtonPreview(@PreviewParameter(ButtonTextPPP::class) buttonData: ButtonTextData) {
67     ButtonText(data = buttonData)
68   }
69   