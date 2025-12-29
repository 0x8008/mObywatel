1    package pl.gov.coi.common.ui.ds.custom.bulletpoint
2    
3    import androidx.compose.foundation.layout.Box
4    import androidx.compose.foundation.layout.Row
5    import androidx.compose.foundation.layout.Spacer
6    import androidx.compose.foundation.layout.fillMaxWidth
7    import androidx.compose.foundation.layout.size
8    import androidx.compose.foundation.layout.width
9    import androidx.compose.runtime.Composable
10   import androidx.compose.ui.Alignment
11   import androidx.compose.ui.Modifier
12   import androidx.compose.ui.graphics.Color
13   import pl.gov.coi.common.domain.label.Label
14   import pl.gov.coi.common.ui.R
15   import pl.gov.coi.common.ui.ds.custom.icon.Icon
16   import pl.gov.coi.common.ui.ds.custom.icon.IconData
17   import pl.gov.coi.common.ui.ds.custom.icon.IconSize
18   import pl.gov.coi.common.ui.text.CustomText
19   import pl.gov.coi.common.ui.theme.AppTheme
20   
21   /**
22    * Temporary custom component for bullet lists. It will be replaced with a proper one, when it's done.
23    */
24   
25   @Composable
26   fun BulletPoint(
27     text: Label,
28   ) {
29     Row(modifier = Modifier.fillMaxWidth()) {
30       Box(
31         modifier = Modifier.size(size = AppTheme.dimensions.spacing300),
32         contentAlignment = Alignment.Center,
33       ) {
34         Icon(
35           data = IconData.Standard(
36             iconResId = R.drawable.e003_badge,
37             iconSize = IconSize.SIZE6,
38             iconColorProvider = { Color(0xFF4A4A4A) }, 
39             contentDescription = Label.EMPTY,
40           ),
41         )
42       }
43       Spacer(
44         modifier = Modifier.width(width = AppTheme.dimensions.spacing100),
45       )
46       CustomText(
47         modifier = Modifier.fillMaxWidth(),
48         label = text,
49         color = AppTheme.colors.neutral200,
50         style = AppTheme.typography.bodyLargeRegular,
51       )
52     }
53   }
54   