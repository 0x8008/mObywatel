1    package pl.gov.coi.common.ui.ds.filepicker.model
2    
3    import android.graphics.Bitmap
4    import androidx.annotation.DrawableRes
5    import androidx.compose.runtime.Composable
6    import androidx.compose.ui.graphics.Color
7    import pl.gov.coi.common.domain.label.CommonUILabelProvider
8    import pl.gov.coi.common.domain.label.Label
9    import pl.gov.coi.common.ui.R
10   import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
11   import pl.gov.coi.common.ui.ds.custom.icon.IconSize
12   import pl.gov.coi.common.ui.theme.AppTheme
13   import pl.gov.coi.common.ui.unmapped.singlecard.BodySection
14   import pl.gov.coi.common.ui.unmapped.singlecard.BodyTitleSection
15   import pl.gov.coi.common.ui.unmapped.singlecard.DefaultSingleCardData
16   import pl.gov.coi.common.ui.unmapped.singlecard.LeadingSection
17   import pl.gov.coi.common.ui.unmapped.singlecard.MediaSection
18   import pl.gov.coi.common.ui.unmapped.singlecard.MediaSection.RoundedSquareIcon
19   import pl.gov.coi.common.ui.unmapped.singlecard.TrailingSection
20   import pl.gov.coi.common.ui.unmapped.singlecard.toSingleCardLabel
21   
22   sealed class PickerFile(
23     open val title: Label,
24     open val description: Label,
25     open val onDeleteClick: () -> Unit,
26   ) {
27     internal abstract val cardData: DefaultSingleCardData
28   
29     val leadingButtonData by lazy {
30       ButtonIconData(
31         iconResId = R.drawable.aa002_delete,
32         iconColorProvider = { AppTheme.colors.supportRed100 },
33         contentDescription = CommonUILabelProvider.commonAccessibilityDeleteFile(),
34         onClick = onDeleteClick,
35       )
36     }
37   
38     data class Image(
39       override val title: Label,
40       override val description: Label,
41       override val onDeleteClick: () -> Unit,
42       val onImageClick: (() -> Unit)? = null,
43       val leadingImageData: LeadingImageData,
44     ) : PickerFile(
45       title = title,
46       description = description,
47       onDeleteClick = onDeleteClick,
48     ) {
49   
50       sealed class LeadingImageData {
51         data class Image(
52           val bitmap: Bitmap,
53         ) : LeadingImageData()
54   
55         data class Icon(
56           @DrawableRes val iconResId: Int,
57           val backgroundColor: @Composable () -> Color,
58         ) : LeadingImageData() {
59   
60           companion object {
61             val PLACEHOLDER = Icon(
62               iconResId = R.drawable.ae006_document,
63               backgroundColor = { AppTheme.colors.background },
64             )
65           }
66         }
67       }
68   
69       override val cardData = DefaultSingleCardData(
70         leadingSection = LeadingSection(
71           mediaSection = when (leadingImageData) {
72             is LeadingImageData.Image -> MediaSection.Image(
73               bitmap = leadingImageData.bitmap,
74               onClick = onImageClick,
75               contentDescription = onImageClick?.let { CommonUILabelProvider.commonAccessibilityPhotoPreview() },
76             )
77   
78             is LeadingImageData.Icon -> RoundedSquareIcon(
79               iconResId = leadingImageData.iconResId,
80               contentDescription = onImageClick?.let { CommonUILabelProvider.commonAccessibilityFilePreview() },
81               onClick = onImageClick,
82               backgroundColor = leadingImageData.backgroundColor,
83             )
84           },
85         ),
86         bodySection = BodySection(
87           title = BodyTitleSection.Title(
88             singleCardLabel = title.toSingleCardLabel(),
89           ),
90           description = description.toSingleCardLabel(),
91         ),
92         trailingSection = TrailingSection.IconButton(
93           data = leadingButtonData,
94         ),
95       )
96     }
97   
98     data class Regular(
99       override val title: Label,
100      override val description: Label,
101      override val onDeleteClick: () -> Unit,
102    ) : PickerFile(
103      title = title,
104      description = description,
105      onDeleteClick = onDeleteClick,
106    ) {
107  
108      override val cardData = DefaultSingleCardData(
109        leadingSection = LeadingSection(
110          mediaSection = RoundedSquareIcon(
111            iconSize = IconSize.SIZE32,
112            backgroundSize = IconSize.SIZE48,
113            iconResId = R.drawable.ae006_document,
114            backgroundColor = { AppTheme.colors.background },
115            iconColor = { AppTheme.colors.neutral200 },
116          ),
117        ),
118        bodySection = BodySection(
119          title = BodyTitleSection.Title(
120            singleCardLabel = title.toSingleCardLabel(),
121          ),
122          description = description.toSingleCardLabel(),
123        ),
124        trailingSection = TrailingSection.IconButton(
125          data = leadingButtonData,
126        ),
127      )
128    }
129  }
130  