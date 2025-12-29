1    package pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttonrow
2    
3    import androidx.compose.foundation.layout.Column
4    import androidx.compose.foundation.layout.Row
5    import androidx.compose.foundation.layout.Spacer
6    import androidx.compose.foundation.layout.fillMaxWidth
7    import androidx.compose.foundation.layout.width
8    import androidx.compose.foundation.layout.wrapContentHeight
9    import androidx.compose.foundation.selection.selectable
10   import androidx.compose.runtime.Composable
11   import androidx.compose.runtime.remember
12   import androidx.compose.ui.Modifier
13   import androidx.compose.ui.semantics.Role
14   import androidx.compose.ui.semantics.semantics
15   import androidx.compose.ui.semantics.testTag
16   import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonRow
17   import pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttoncontent.RadioButtonContent
18   import pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttondescription.RadioButtonDescription
19   import pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttonitem.RadioButtonItem
20   import pl.gov.coi.common.ui.text.CustomText
21   import pl.gov.coi.common.ui.theme.AppTheme
22   import pl.gov.coi.common.ui.utils.MultipleEventsCutter
23   import pl.gov.coi.common.ui.utils.NoRippleInteractionSource
24   import pl.gov.coi.common.ui.utils.get
25   
26   @Composable
27   internal fun RadioButtonRow(
28     data: RadioButtonRow,
29   ) {
30     val multipleEventsCutter = remember { MultipleEventsCutter.get() }
31     Row(
32       modifier = Modifier
33         .wrapContentHeight()
34         .semantics {
35           testTag = "radiobutton ${data.label.tag}"
36         }
37         .selectable(
38           selected = data.item.isSelected,
39           role = Role.RadioButton,
40           enabled = data.item.enabled,
41           interactionSource = NoRippleInteractionSource(),
42           indication = null,
43           onClick = {
44             if (data.item.enabled && data.item.isSelected.not()) {
45               multipleEventsCutter.processEvent {
46                 data.onClick()
47               }
48             }
49           },
50         ),
51     ) {
52       RadioButtonItem(data = data.item)
53       Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing200))
54       Column(modifier = Modifier.fillMaxWidth()) {
55         CustomText(
56           label = data.label,
57           style = AppTheme.typography.bodyLargeRegular,
58           color = AppTheme.colors.neutral500,
59         )
60         RadioButtonDescription(
61           description = data.description,
62         )
63         RadioButtonContent(
64           content = data.content?.content(),
65           isSelected = data.item.isSelected,
66         )
67       }
68     }
69   }
70   