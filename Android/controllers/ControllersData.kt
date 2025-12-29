1    package pl.gov.coi.common.ui.ds.controllers
2    
3    import pl.gov.coi.common.domain.label.Label
4    
5    sealed class ControllersData {
6      data class Switch(
7        val leftItem: TabItem,
8        val rightItem: TabItem,
9        val selectedItemType: Type,
10       val onClick: (Type) -> Unit,
11     ) : ControllersData() {
12   
13       data class TabItem(
14         val label: Label,
15         val type: Type,
16       )
17   
18       enum class Type(val tabIndex: Int) {
19         LEFT(tabIndex = 0),
20         RIGHT(tabIndex = 1),
21       }
22     }
23   
24     data class Filter(
25       val items: List<Label>,
26       val selectedItemIndex: Int,
27       val onClick: (Int) -> Unit,
28     ) : ControllersData()
29   }
30   