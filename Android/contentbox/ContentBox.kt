1    package pl.gov.coi.common.ui.ds.contentbox
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.layout.Box
5    import androidx.compose.foundation.layout.Column
6    import androidx.compose.foundation.layout.fillMaxWidth
7    import androidx.compose.foundation.layout.padding
8    import androidx.compose.runtime.Composable
9    import androidx.compose.ui.Modifier
10   import androidx.compose.ui.draw.clip
11   import androidx.compose.ui.tooling.preview.Preview
12   import pl.gov.coi.common.domain.label.toLabel
13   import pl.gov.coi.common.ui.text.CustomText
14   import pl.gov.coi.common.ui.theme.AppTheme
15   
16   @Composable
17   fun ContentBox(
18     modifier: Modifier = Modifier,
19     content: @Composable () -> Unit,
20   ) {
21     Box(
22       modifier = modifier
23         .fillMaxWidth()
24         .clip(shape = AppTheme.shapes.radius200)
25         .background(color = AppTheme.colors.white)
26         .padding(all = AppTheme.dimensions.spacing200),
27     ) {
28       content()
29     }
30   }
31   
32   @Composable
33   @Preview
34   fun ContentBoxPreview() {
35     Box(
36       Modifier
37         .background(color = AppTheme.colors.background)
38         .padding(AppTheme.dimensions.spacing200),
39     ) {
40       ContentBox {
41         Column {
42           CustomText(label = "Text 1".toLabel(tag = "text1Label"))
43           CustomText(label = "Text 2".toLabel(tag = "text2Label"))
44           CustomText(label = "Text 3".toLabel(tag = "text3Label"))
45         }
46       }
47     }
48   }
49   