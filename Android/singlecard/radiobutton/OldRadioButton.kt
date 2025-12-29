1    package pl.gov.coi.common.ui.ds.singlecard.radiobutton
2    
3    import androidx.compose.foundation.layout.size
4    import androidx.compose.material.RadioButton
5    import androidx.compose.material.RadioButtonDefaults
6    import androidx.compose.runtime.Composable
7    import androidx.compose.ui.Modifier
8    import androidx.compose.ui.graphics.Color
9    import pl.gov.coi.common.domain.validators.ValidationState
10   import pl.gov.coi.common.ui.theme.AppTheme
11   
12   @Deprecated(
13     message = "Do not use.",
14     replaceWith = ReplaceWith("pl.gov.coi.common.ui.ds.radiobutton.RadioButton"),
15   )
16   @Composable
17   fun OldRadioButton(
18     data: OldRadioButtonData,
19   ) {
20     RadioButton(
21       modifier = Modifier.size(size = AppTheme.dimensions.spacing300),
22       selected = data.isSelected,
23       onClick = null,
24       enabled = data.enabled,
25       colors = RadioButtonDefaults.colors(
26         selectedColor = AppTheme.colors.primary900,
27         unselectedColor = AppTheme.colors.neutral80.orRedIfInvalid(
28           validationState = data.validationState,
29         ),
30         disabledColor = AppTheme.colors.neutral30,
31       ),
32     )
33   }
34   
35   @Composable
36   fun Color.orRedIfInvalid(validationState: ValidationState) =
37     if (validationState is ValidationState.Invalid) {
38       AppTheme.colors.supportRed100
39     } else {
40       this
41     }
42   