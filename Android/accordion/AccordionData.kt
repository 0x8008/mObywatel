1    package pl.gov.coi.common.ui.ds.accordion
2    
3    import androidx.compose.runtime.Composable
4    import pl.gov.coi.common.domain.label.Label
5    
6    interface CustomAccordionContent {
7      @Composable
8      fun Content()
9    }
10   
11   data class AccordionData(
12     val elements: List<AccordionElement>,
13   )
14   
15   data class AccordionElement(
16     val header: Label,
17     val initialExpanded: Boolean = false,
18     val onListExpanded: (Boolean) -> Unit = {},
19     val addContentPadding: Boolean = true,
20     val content: CustomAccordionContent,
21   )
22   