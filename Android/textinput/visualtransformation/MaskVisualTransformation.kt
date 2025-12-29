1    package pl.gov.coi.common.ui.ds.textinput.visualtransformation
2    
3    import androidx.compose.ui.text.AnnotatedString
4    import androidx.compose.ui.text.input.TransformedText
5    import androidx.compose.ui.text.input.VisualTransformation
6    
7    class MaskVisualTransformation(private val maskType: MaskType) : VisualTransformation {
8      override fun filter(text: AnnotatedString): TransformedText {
9        return TransformedText(AnnotatedString(maskType.getDisplayText(text)), maskType)
10     }
11   }
12   