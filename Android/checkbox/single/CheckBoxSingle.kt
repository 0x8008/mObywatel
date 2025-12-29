1    package pl.gov.coi.common.ui.ds.checkbox.single
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.layout.Box
5    import androidx.compose.foundation.layout.Column
6    import androidx.compose.foundation.layout.fillMaxSize
7    import androidx.compose.foundation.layout.padding
8    import androidx.compose.runtime.Composable
9    import androidx.compose.ui.Modifier
10   import androidx.compose.ui.tooling.preview.Preview
11   import androidx.compose.ui.tooling.preview.PreviewParameter
12   import pl.gov.coi.common.ui.ds.checkbox.common.CheckBoxBottomText
13   import pl.gov.coi.common.ui.ds.checkbox.common.CheckboxRow
14   import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckboxContentType
15   import pl.gov.coi.common.ui.ds.checkbox.single.model.CheckBoxSingleData
16   import pl.gov.coi.common.ui.ds.contentbox.ContentBox
17   import pl.gov.coi.common.ui.theme.AppTheme
18   
19   @Composable
20   fun CheckBoxSingle(data: CheckBoxSingleData) {
21     Column {
22       when (data.contentType) {
23         CheckboxContentType.CONTENT_BOX -> ContentBox {
24           Column {
25             CheckboxRow(data = data.checkbox, type = data.type, isEnabled = data.isEnabled)
26             CheckBoxBottomText(data.type)
27           }
28         }
29   
30         CheckboxContentType.DEFAULT -> Column {
31           CheckboxRow(data = data.checkbox, type = data.type, isEnabled = data.isEnabled)
32           CheckBoxBottomText(data.type)
33         }
34       }
35     }
36   }
37   
38   @Composable
39   @Preview
40   fun CheckBoxSinglePreview(@PreviewParameter(CheckBoxSinglePPP::class) data: CheckBoxSingleData) {
41     Box(
42       modifier = Modifier
43         .background(AppTheme.colors.background)
44         .padding(AppTheme.dimensions.spacing200)
45         .fillMaxSize(),
46     ) {
47       CheckBoxSingle(data)
48     }
49   }
50   