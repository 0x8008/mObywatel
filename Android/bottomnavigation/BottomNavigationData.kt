1    package pl.gov.coi.common.ui.ds.bottomnavigation
2    
3    data class BottomNavigationData(
4      val items: List<BottomNavigationItem>,
5      val selectedItemIndex: Int = 0,
6    )
7    