1    package pl.gov.coi.common.ui.ds.topappbar
2    
3    import androidx.compose.runtime.Composable
4    import androidx.compose.runtime.LaunchedEffect
5    import androidx.compose.ui.platform.LocalFocusManager
6    import kotlinx.coroutines.delay
7    import pl.gov.coi.common.ui.focus.FocusHost
8    import pl.gov.coi.common.ui.focus.createFocusHost
9    
10   @Deprecated(
11     "This is hack for WCAG requirements to focus titles on every screen enter." +
12       " Should be deleted with task MOB-72178",
13   )
14   @Composable
15   fun forceFocusOnStart(forceFocusTrigger: Boolean?): FocusHost {
16   
17     val focusHost = createFocusHost(false)
18     val focusManager = LocalFocusManager.current
19     if (forceFocusTrigger != null) {
20       LaunchedEffect(forceFocusTrigger) {
21         delay(1L)
22         focusManager.clearFocus(true)
23         delay(1L)
24         focusHost.requestFocus()
25       }
26     }
27     return focusHost
28   }
29   