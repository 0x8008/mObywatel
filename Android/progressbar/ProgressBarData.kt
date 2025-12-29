1    package pl.gov.coi.common.ui.ds.progressbar
2    
3    import androidx.compose.runtime.Stable
4    import pl.gov.coi.common.domain.label.Label
5    
6    sealed interface ProgressBarData {
7      val testTag: String?
8      val value: Int
9    
10     @Stable
11     data class Bar(
12       override val testTag: String? = null,
13       override val value: Int,
14     ) : ProgressBarData
15   
16     @Stable
17     data class IndicatorBar(
18       override val testTag: String? = null,
19       override val value: Int,
20       val label: Label,
21     ) : ProgressBarData
22   }
23   