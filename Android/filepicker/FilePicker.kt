1    package pl.gov.coi.common.ui.ds.filepicker
2    
3    import androidx.compose.animation.AnimatedVisibility
4    import androidx.compose.foundation.background
5    import androidx.compose.foundation.layout.Column
6    import androidx.compose.foundation.layout.Spacer
7    import androidx.compose.foundation.layout.fillMaxWidth
8    import androidx.compose.foundation.layout.height
9    import androidx.compose.foundation.layout.wrapContentHeight
10   import androidx.compose.runtime.Composable
11   import androidx.compose.ui.Modifier
12   import androidx.compose.ui.tooling.preview.Preview
13   import androidx.compose.ui.tooling.preview.PreviewParameter
14   import pl.gov.coi.common.ui.ds.errortext.ErrorText
15   import pl.gov.coi.common.ui.ds.filepicker.model.FilePickerData
16   import pl.gov.coi.common.ui.ds.filepicker.model.showAddButton
17   import pl.gov.coi.common.ui.ds.filepicker.model.showError
18   import pl.gov.coi.common.ui.ds.filepicker.provider.FilePickerPreviewParameterProvider
19   import pl.gov.coi.common.ui.preview.WrappedValue
20   import pl.gov.coi.common.ui.text.CustomText
21   import pl.gov.coi.common.ui.theme.AppTheme
22   import pl.gov.coi.common.ui.unmapped.cardlist.ColumnCardList
23   import pl.gov.coi.common.ui.unmapped.cardlist.model.CardListData
24   import pl.gov.coi.common.ui.unmapped.singlecard.SingleCard
25   
26   @Composable
27   fun FilePicker(
28     modifier: Modifier = Modifier,
29     data: FilePickerData,
30   ) {
31     Column(
32       modifier = modifier
33         .fillMaxWidth()
34         .wrapContentHeight(),
35     ) {
36       if (data.files.isNotEmpty()) {
37         ColumnCardList(data = CardListData(singleCardList = data.cardsData))
38       }
39   
40       if (data.showAddButton) {
41         if (data.files.isNotEmpty()) {
42           Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing200))
43         }
44   
45         SingleCard(singleCardData = data.addFileCardData)
46   
47         AnimatedVisibility(visible = data.showError) {
48           data.errorLabel?.let { errorText ->
49             Column {
50               Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing100))
51               ErrorText(errorText = errorText, ignoreForAccessibility = true)
52             }
53           }
54         }
55   
56         Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing100))
57   
58         CustomText(
59           label = data.combinedRequirements,
60           style = AppTheme.typography.bodyMediumRegular,
61           color = AppTheme.colors.neutral200,
62           ignoreForAccessibility = true,
63         )
64       }
65     }
66   }
67   
68   @Preview
69   @Composable
70   internal fun FilePickerPreview(
71     @PreviewParameter(FilePickerPreviewParameterProvider::class)
72     wrappedValue: WrappedValue<FilePickerData>,
73   ) {
74     FilePicker(
75       modifier = Modifier.background(AppTheme.colors.background),
76       data = wrappedValue.value(),
77     )
78   }
79   