1    package pl.gov.coi.common.ui.ds.custom.documentrow.provider
2    
3    import android.content.Context
4    import androidx.compose.ui.res.colorResource
5    import pl.gov.coi.common.domain.Mapper
6    import pl.gov.coi.common.domain.label.toLabel
7    import pl.gov.coi.common.ui.R
8    import pl.gov.coi.common.ui.ds.custom.documentrow.DocumentRowData
9    import pl.gov.coi.common.ui.ds.statusbadge.StatusBadgeData
10   import pl.gov.coi.common.ui.ds.statusbadge.StatusBadgeWithIconStatus
11   import pl.gov.coi.common.ui.preview.CustomWrappedDataPreviewParameterProvider
12   import pl.gov.coi.common.ui.preview.ScreenShotTestDataProvider
13   import pl.gov.coi.common.ui.preview.WrappedValue
14   
15   data class ProvidedSingleCardDocumentRowData(
16     val previewName: String,
17     val data: DocumentRowData,
18   )
19   
20   class SingleCardDocumentRowPPP : CustomWrappedDataPreviewParameterProvider
21     <Unit, DocumentRowData, Mapper<Unit, DocumentRowData>, ProvidedSingleCardDocumentRowData>() {
22   
23     override fun mapper(context: Context): Mapper<Unit, DocumentRowData> {
24       return object : Mapper<Unit, DocumentRowData> {
25         override fun invoke(p1: Unit): DocumentRowData = getSingleCardDocument()
26       }
27     }
28   
29     private val cards = mapOf(
30       "SingleCardDocumentRow" to getSingleCardDocument(),
31       "SingleCardDocumentRowWithDescription" to getSingleCardDocumentWithDescription(),
32       "SingleCardDocumentRowWithStatus" to getSingleCardDocumentWithStatus(),
33       "SingleCardDocumentRowWithDescriptionStatus" to getSingleCardDocumentWithDescriptionStatus(),
34     )
35   
36     override val screenShotTestValues: Sequence<ScreenShotTestDataProvider<ProvidedSingleCardDocumentRowData>>
37       get() = cards.map { (testName, cardData) ->
38         ScreenShotTestDataProvider(
39           screenShotTestName = testName,
40           wrappedValue = WrappedValue {
41             ProvidedSingleCardDocumentRowData(
42               previewName = testName,
43               data = cardData,
44             )
45           },
46         )
47       }.asSequence()
48   
49     private fun getSingleCardDocument() = DocumentRowData(
50       title = "Legitymacja poselska".toLabel(),
51       iconColorProvider = { colorResource(id = R.color.coi_mobywatel_feature_dashboard_deputy_card_primary) },
52       iconResId = R.drawable.db012_legitymacja_poselska,
53       badgeData = null,
54       onClick = {},
55     )
56   
57     private fun getSingleCardDocumentWithDescription() = getSingleCardDocument().copy(
58       description = "Opis dokumentu".toLabel(),
59     )
60   
61     private fun getSingleCardDocumentWithStatus() = getSingleCardDocument().copy(
62       badgeData = StatusBadgeData.WithIcon(
63         label = "Błąd pobierania".toLabel(),
64         withBorder = false,
65         status = StatusBadgeWithIconStatus.NEGATIVE,
66       ),
67     )
68   
69     private fun getSingleCardDocumentWithDescriptionStatus() = getSingleCardDocumentWithDescription().copy(
70       badgeData = StatusBadgeData.WithIcon(
71         label = "Błąd pobierania".toLabel(),
72         withBorder = false,
73         status = StatusBadgeWithIconStatus.NEGATIVE,
74       ),
75     )
76   }
77   