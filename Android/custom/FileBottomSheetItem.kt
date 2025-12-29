1    package pl.gov.coi.common.ui.ds.custom
2    
3    import android.os.SystemClock
4    import androidx.annotation.DrawableRes
5    import androidx.compose.foundation.clickable
6    import androidx.compose.foundation.interaction.MutableInteractionSource
7    import androidx.compose.foundation.layout.Row
8    import androidx.compose.foundation.layout.Spacer
9    import androidx.compose.foundation.layout.fillMaxWidth
10   import androidx.compose.foundation.layout.height
11   import androidx.compose.foundation.layout.width
12   import androidx.compose.material.ripple.rememberRipple
13   import androidx.compose.runtime.Composable
14   import androidx.compose.runtime.remember
15   import androidx.compose.ui.Alignment
16   import androidx.compose.ui.Modifier
17   import pl.gov.coi.common.domain.label.Label
18   import pl.gov.coi.common.ui.ds.custom.icon.Icon
19   import pl.gov.coi.common.ui.ds.custom.icon.IconData
20   import pl.gov.coi.common.ui.ds.custom.icon.IconSize
21   import pl.gov.coi.common.ui.text.CustomText
22   import pl.gov.coi.common.ui.theme.AppTheme
23   
24   data class FileBottomSheetItemData(
25     @DrawableRes val iconResId: Int,
26     val title: Label,
27     val onClick: () -> Unit,
28   ) {
29     internal val iconData = IconData.Standard(
30       iconResId = iconResId,
31       iconSize = IconSize.SIZE24,
32       iconColorProvider = { AppTheme.colors.neutral200 },
33       contentDescription = null,
34     )
35   }
36   
37   
38   @Composable
39   fun FileBottomSheetItem(
40     data: FileBottomSheetItemData,
41   ) {
42     Row(
43       modifier = Modifier
44         .fillMaxWidth()
45         .height(height = AppTheme.dimensions.spacing600)
46         .debounceClick(onClick = data.onClick),
47       verticalAlignment = Alignment.CenterVertically,
48     ) {
49       Icon(data = data.iconData)
50       Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing200))
51       CustomText(
52         label = data.title,
53         style = AppTheme.typography.bodyLargeRegular,
54         color = AppTheme.colors.neutral500,
55       )
56     }
57   }
58   
59   @Composable
60   private fun Modifier.debounceClick(debounceTime: Long = 300L, onClick: () -> Unit): Modifier {
61     var lastClickTime = remember { 0L }
62     return this then clickable(
63       interactionSource = remember { MutableInteractionSource() },
64       indication = rememberRipple(),
65       onClick = {
66         val currentTime = SystemClock.elapsedRealtime()
67         if ((currentTime - lastClickTime) > debounceTime) {
68           lastClickTime = currentTime
69           onClick()
70         }
71       },
72     )
73   }
74   