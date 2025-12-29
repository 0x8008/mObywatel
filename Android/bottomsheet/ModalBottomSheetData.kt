1    package pl.gov.coi.common.ui.ds.bottomsheet
2    
3    import androidx.compose.runtime.Composable
4    import androidx.compose.ui.graphics.Color
5    import pl.gov.coi.common.domain.label.Label
6    import pl.gov.coi.common.ui.theme.AppTheme
7    
8    data class ModalBottomSheetData(
9      val sheetState: ModalSheetState,
10     val title: Label? = null,
11     val onCloseClick: (() -> Unit)? = null,
12     val colorProvider: @Composable () -> Color = { AppTheme.colors.white },
13   )
14   
15   data class ModalSheetState(
16     val value: ModalSheetValue,
17     val skipHalfExpanded: Boolean = true,
18     val onValueChange: (ModalSheetValue) -> Unit,
19   )
20   
21   enum class ModalSheetValue {
22     EXPANDED, HIDDEN, HALF_EXPANDED
23   }
24   