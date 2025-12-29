1    package pl.gov.coi.common.ui.ds.custom.singlecard.labelbuttonimage
2    
3    import android.graphics.Bitmap
4    import android.graphics.BitmapFactory
5    import android.util.Base64
6    import androidx.compose.foundation.Image
7    import androidx.compose.foundation.layout.Arrangement
8    import androidx.compose.foundation.layout.Column
9    import androidx.compose.foundation.layout.Row
10   import androidx.compose.foundation.layout.Spacer
11   import androidx.compose.foundation.layout.fillMaxWidth
12   import androidx.compose.foundation.layout.height
13   import androidx.compose.foundation.layout.size
14   import androidx.compose.runtime.Composable
15   import androidx.compose.ui.Alignment
16   import androidx.compose.ui.Modifier
17   import androidx.compose.ui.graphics.asImageBitmap
18   import androidx.compose.ui.layout.ContentScale
19   import androidx.compose.ui.tooling.preview.Preview
20   import androidx.compose.ui.unit.dp
21   import pl.gov.coi.common.domain.label.toLabel
22   import pl.gov.coi.common.ui.ds.button.Button
23   import pl.gov.coi.common.ui.ds.button.ButtonData
24   import pl.gov.coi.common.ui.ds.button.common.ButtonSize
25   import pl.gov.coi.common.ui.ds.button.common.ButtonType
26   import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
27   import pl.gov.coi.common.ui.text.CustomText
28   import pl.gov.coi.common.ui.theme.AppTheme
29   import pl.gov.coi.common.ui.unmapped.singlecard.CustomContent
30   import pl.gov.coi.common.ui.unmapped.singlecard.CustomSingleCardData
31   import pl.gov.coi.common.ui.unmapped.singlecard.MediaSection
32   import pl.gov.coi.common.ui.unmapped.singlecard.SingleCard
33   
34   class LabelButtonImageSingleCard(val data: LabelButtonImageSingleCardData) : CustomContent {
35     @Composable
36     override fun Content() {
37       Row(
38         horizontalArrangement = Arrangement.SpaceBetween,
39         verticalAlignment = Alignment.CenterVertically,
40         modifier = Modifier.fillMaxWidth(),
41       ) {
42         Column {
43           data.label?.let { label ->
44             CustomText(
45               label = label,
46               style = AppTheme.typography.bodyMediumRegular,
47               color = AppTheme.colors.neutral200,
48             )
49             Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
50           }
51           Image(
52             contentScale = ContentScale.FillBounds,
53             modifier = Modifier.size(100.dp),
54             bitmap = data.qrCodeImage.bitmap.asImageBitmap(),
55             contentDescription = data.qrCodeImage.contentDescription?.text,
56           )
57         }
58         Button(data = data.buttonData)
59       }
60     }
61   }
62   
63   @Composable
64   @Preview
65   fun QrCodeCustomSingleCardPreview() {
66     SingleCard(
67       singleCardData = CustomSingleCardData(
68         oldTestTag = "qrCodeCard".toLabel(tag = "qrCodeCard"),
69         customContent =
70         LabelButtonImageSingleCard(
71           data = LabelButtonImageSingleCardData(
72             label = "Kod QR".toLabel(tag = "qrCodeButton"),
73             buttonData = ButtonData(
74               buttonSize = ButtonSize.Small,
75               buttonType = ButtonType.WithText(
76                 label = "Powiększ kod QR".toLabel(tag = "zoomInQrCodeButton"),
77               ),
78               buttonVariant = ButtonVariant.Primary,
79               onClick = {},
80             ),
81             qrCodeImage = MediaSection.Image(
82               bitmap = provideBitmap(value = qrCodeValue),
83             ),
84           ),
85         ),
86       ),
87     )
88   }
89   
90   private fun provideBitmap(value: String): Bitmap {
91     val picture = Base64.decode(value, Base64.NO_WRAP)
92     return BitmapFactory
93       .decodeByteArray(picture, 0, picture.size)
94   }
95   
96   private val qrCodeValue =
97     "iVBORw0KGgoAAAANSUhEUgAAAH0AAAB9AQAAAACn+1GIAAAApklEQVR4Xu2UMQ4EMQgD/QP+/0vK6zjsvayUMm" +
98       "avWxQpMAUBkwS12wcveAAkgNSCD3rR5Lkgoai3GUCMgWqbAEYR3HxAkZlzU/0MyBisYRs" +
99       "gI1ERFfcpBpA+ze6k56Cj7KTdXNigFWZvSOpsgqLfd" +
100      "18i2aAukXh9TXBNmdWt5gzA/oqzWkkN8HtA7G8CNOwYAiZt3wZixUfkA32OHNQq7Bxs9oI/gC/9fV8AVCkPjQAAAABJRU5ErkJggg=="
101  