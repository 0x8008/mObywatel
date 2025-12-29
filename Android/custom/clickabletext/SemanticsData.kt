1    package pl.gov.coi.common.ui.ds.custom.clickabletext
2    
3    import androidx.compose.ui.semantics.SemanticsPropertyReceiver
4    
5    data class SemanticsData(
6      val mergeDescendants: Boolean = false,
7      val semanticsContentDescription: String? = null,
8      val semanticsProperties: (SemanticsPropertyReceiver.() -> Unit) = {},
9    )
10   