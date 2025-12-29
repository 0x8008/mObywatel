1    package pl.gov.coi.common.ui.ds.image
2    
3    import android.graphics.Bitmap
4    import androidx.compose.runtime.Composable
5    import androidx.compose.ui.graphics.Shape
6    import pl.gov.coi.common.domain.label.Label
7    import pl.gov.coi.common.ui.ds.custom.icon.IconSize
8    
9    data class ImageData(
10     val image: Bitmap,
11     val onClick: () -> Unit,
12     val size: IconSize,
13     val shapeProvider: @Composable () -> Shape,
14     val contentDescription: Label,
15   )
16   