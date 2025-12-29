1    package pl.gov.coi.common.ui.ds.cardlist
2    
3    import androidx.compose.foundation.layout.Column
4    import androidx.compose.foundation.layout.Row
5    import androidx.compose.foundation.layout.padding
6    import androidx.compose.foundation.lazy.LazyColumn
7    import androidx.compose.foundation.lazy.itemsIndexed
8    import androidx.compose.material.Card
9    import androidx.compose.material.Divider
10   import androidx.compose.material.Text
11   import androidx.compose.runtime.Composable
12   import androidx.compose.ui.Modifier
13   import androidx.compose.ui.tooling.preview.Preview
14   import androidx.compose.ui.tooling.preview.PreviewParameter
15   import pl.gov.coi.common.ui.ds.cardlist.provider.CardListPreviewProvider
16   import pl.gov.coi.common.ui.ds.cardlist.provider.ProvidedCardListData
17   import pl.gov.coi.common.ui.ds.singlecard.SingleCard
18   import pl.gov.coi.common.ui.ds.singlecard.SingleCardData
19   import pl.gov.coi.common.ui.model.ListType
20   import pl.gov.coi.common.ui.preview.WrappedValue
21   import pl.gov.coi.common.ui.theme.AppTheme
22   
23   data class CardListData(
24     val cards: List<SingleCardData>,
25     val type: ListType = ListType.COLUMN,
26   )
27   
28   @Composable
29   fun CardList(
30     data: CardListData,
31   ) {
32     Card(
33       shape = AppTheme.shapes.radius200,
34       elevation = AppTheme.elevations.level0,
35     ) {
36       when (data.type) {
37         ListType.COLUMN ->
38           Column {
39             data.cards.forEachIndexed { index, singleCardData ->
40               ItemContent(
41                 card = singleCardData,
42                 isLastItem = data.cards.lastIndex == index,
43               )
44             }
45           }
46   
47         ListType.LAZY ->
48           LazyColumn {
49             itemsIndexed(data.cards) { index, singleCardData ->
50               ItemContent(
51                 card = singleCardData,
52                 isLastItem = data.cards.lastIndex == index,
53               )
54             }
55           }
56       }
57     }
58   }
59   
60   @Composable
61   private fun ItemContent(
62     card: SingleCardData,
63     isLastItem: Boolean,
64   ) {
65     SingleCard(data = card)
66     if (!isLastItem) {
67       ListDivider()
68     }
69   }
70   
71   @Composable
72   private fun ListDivider() {
73     Row {
74       Divider(
75         modifier = Modifier.padding(
76           start = AppTheme.dimensions.spacing250,
77           end = AppTheme.dimensions.spacing250,
78         ),
79         thickness = AppTheme.dimensions.strokeWidth,
80         color = AppTheme.colors.neutral30,
81       )
82     }
83   }
84   
85   @Preview
86   @Composable
87   fun CardListPreview(
88     @PreviewParameter(CardListPreviewProvider::class)
89     wrappedValue: WrappedValue<ProvidedCardListData>,
90   ) = with(wrappedValue.value()) {
91     Column {
92       Text(
93         modifier = Modifier.padding(AppTheme.dimensions.spacing250),
94         text = previewName,
95       )
96       CardList(
97         data = data,
98       )
99     }
100  }
101  