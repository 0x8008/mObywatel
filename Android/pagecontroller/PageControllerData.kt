1    package pl.gov.coi.common.ui.ds.pagecontroller
2    
3    import pl.gov.coi.common.domain.label.Label
4    
5    data class PageControllerData<CONTENT_DATA>(
6      val contentsData: List<PageData<CONTENT_DATA>>,
7    ) {
8    
9      data class PageData<CONTENT_DATA>(
10       val content: CONTENT_DATA,
11       val isButtonVisible: Boolean,
12       val buttonTitle: Label,
13       val buttonAction: ButtonAction = ButtonAction.GoToNextPage,
14     ) {
15       sealed interface ButtonAction {
16         data object GoToNextPage : ButtonAction
17         fun interface Custom : ButtonAction {
18           operator fun invoke()
19         }
20       }
21     }
22   }
23   