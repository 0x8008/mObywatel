1    package pl.gov.coi.common.ui.ds.singlecard
2    
3    import androidx.compose.runtime.Composable
4    import androidx.compose.ui.tooling.preview.Preview
5    import androidx.compose.ui.tooling.preview.PreviewParameter
6    import androidx.compose.ui.unit.Dp
7    import androidx.compose.ui.unit.dp
8    import pl.gov.coi.common.ui.ds.singlecard.provider.SingleCardPreviewParameterProvider
9    
10   val SINGLE_CARD_MINIMUM_HEIGHT: Dp = 80.dp
11   
12   @Deprecated(
13     message = "Deprecated",
14     replaceWith = ReplaceWith(
15       expression = "SingleCard()",
16       imports = arrayOf("pl.gov.coi.common.ui.unmapped.singlecard"),
17     ),
18   )
19   @Composable
20   fun SingleCard(
21     data: SingleCardData,
22   ) {
23     when (data) {
24       is SingleCardData.Info -> SingleCardInfo(data = data)
25       is SingleCardData.Clickable -> SingleCardClickable(data = data)
26       is SingleCardData.SelectableRadioButton -> SingleCardSelectableRadioButton(data = data)
27       is SingleCardData.SelectableCheckbox -> SingleCardSelectableCheckbox(data = data)
28     }
29   }
30   
31   @Preview
32   @Composable
33   fun SingleCardPreview(
34     @PreviewParameter(SingleCardPreviewParameterProvider::class) singleCardData: SingleCardData,
35   ) {
36     SingleCard(
37       data = singleCardData,
38     )
39   }
40   