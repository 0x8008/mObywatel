1    package pl.gov.coi.common.ui.ds.switchcomponent
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.layout.Box
5    import androidx.compose.foundation.layout.padding
6    import androidx.compose.foundation.layout.wrapContentHeight
7    import androidx.compose.runtime.Composable
8    import androidx.compose.ui.Modifier
9    import androidx.compose.ui.tooling.preview.Preview
10   import androidx.compose.ui.tooling.preview.PreviewParameter
11   import pl.gov.coi.common.ui.ds.switchcomponent.provider.SwitchPreviewParameterProvider
12   import pl.gov.coi.common.ui.theme.AppTheme
13   
14   @Composable
15   fun Switch(
16     data: SwitchData,
17   ) {
18     when (data) {
19       is SwitchData.SwitchOnly -> SwitchOnly(data = data)
20       is SwitchData.SwitchWithText -> SwitchWithText(data = data)
21       is SwitchData.SwitchWithExtras -> SwitchWithExtras(data = data)
22     }
23   }
24   
25   @Preview
26   @Composable
27   fun SwitchPreview(
28     @PreviewParameter(SwitchPreviewParameterProvider::class) data: SwitchData,
29   ) {
30     Box(
31       modifier = Modifier
32         .wrapContentHeight()
33         .background(color = AppTheme.colors.background)
34         .padding(horizontal = AppTheme.dimensions.spacing600),
35     ) {
36       Switch(data = data)
37     }
38   }
39   