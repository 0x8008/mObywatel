1    package pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttoncontent
2    
3    import androidx.compose.animation.AnimatedVisibility
4    import androidx.compose.animation.expandVertically
5    import androidx.compose.animation.fadeIn
6    import androidx.compose.animation.fadeOut
7    import androidx.compose.animation.shrinkVertically
8    import androidx.compose.foundation.layout.Column
9    import androidx.compose.foundation.layout.Spacer
10   import androidx.compose.foundation.layout.height
11   import androidx.compose.runtime.Composable
12   import androidx.compose.ui.Modifier
13   import pl.gov.coi.common.ui.theme.AppTheme
14   
15   @Composable
16   internal fun RadioButtonContent(
17     isSelected: Boolean,
18     content: @Composable (() -> Unit)?,
19   ) {
20     content?.let {
21       AnimatedVisibility(
22         visible = isSelected,
23         enter = fadeIn() + expandVertically(),
24         exit = fadeOut() + shrinkVertically(),
25       ) {
26         Column {
27           Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing200))
28           content()
29         }
30       }
31     }
32   }
33   