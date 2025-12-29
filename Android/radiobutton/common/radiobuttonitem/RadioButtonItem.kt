1    package pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttonitem
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.layout.Arrangement
5    import androidx.compose.foundation.layout.Column
6    import androidx.compose.foundation.layout.fillMaxSize
7    import androidx.compose.foundation.layout.padding
8    import androidx.compose.material3.RadioButton
9    import androidx.compose.material3.RadioButtonDefaults
10   import androidx.compose.runtime.Composable
11   import androidx.compose.ui.Alignment
12   import androidx.compose.ui.Modifier
13   import androidx.compose.ui.graphics.Color
14   import androidx.compose.ui.tooling.preview.Preview
15   import androidx.compose.ui.tooling.preview.PreviewParameter
16   import pl.gov.coi.common.ui.preview.WrappedValue
17   import pl.gov.coi.common.ui.theme.AppTheme
18   import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonItemData
19   import pl.gov.coi.common.ui.utils.NoRippleInteractionSource
20   
21   @Composable
22   fun RadioButtonItem(
23     data: RadioButtonItemData,
24   ) {
25     RadioButton(
26       selected = data.isSelected,
27       enabled = data.enabled,
28       interactionSource = NoRippleInteractionSource(),
29       colors = RadioButtonDefaults.colors(
30         selectedColor = AppTheme.colors.primary900.orRedIfError(
31           isError = data.isError,
32         ),
33         unselectedColor = AppTheme.colors.neutral80.orRedIfError(
34           isError = data.isError,
35         ),
36         disabledSelectedColor = AppTheme.colors.neutral30,
37         disabledUnselectedColor = AppTheme.colors.neutral30,
38       ),
39       onClick = null,
40     )
41   }
42   
43   @Composable
44   private fun Color.orRedIfError(isError: Boolean) =
45     if (isError) {
46       AppTheme.colors.supportRed100
47     } else {
48       this
49     }
50   
51   @Preview
52   @Composable
53   fun RadioButtonItemPreview(
54     @PreviewParameter(RadioButtonItemPPP::class)
55     wrappedValue: WrappedValue<RadioButtonItemData>,
56   ) {
57     Column(
58       modifier = Modifier
59         .background(color = AppTheme.colors.background)
60         .fillMaxSize()
61         .padding(all = AppTheme.dimensions.spacing200),
62       horizontalAlignment = Alignment.CenterHorizontally,
63       verticalArrangement = Arrangement.Center,
64     ) {
65       RadioButtonItem(data = wrappedValue.value())
66     }
67   }
68   