1    package pl.gov.coi.common.ui.ds.dialog
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.layout.Arrangement
5    import androidx.compose.foundation.layout.Column
6    import androidx.compose.foundation.layout.Row
7    import androidx.compose.foundation.layout.Spacer
8    import androidx.compose.foundation.layout.fillMaxWidth
9    import androidx.compose.foundation.layout.height
10   import androidx.compose.foundation.layout.padding
11   import androidx.compose.foundation.layout.width
12   import androidx.compose.runtime.Composable
13   import androidx.compose.ui.Alignment
14   import androidx.compose.ui.Modifier
15   import androidx.compose.ui.semantics.semantics
16   import androidx.compose.ui.semantics.testTag
17   import androidx.compose.ui.text.style.TextAlign
18   import androidx.compose.ui.tooling.preview.Preview
19   import androidx.compose.ui.tooling.preview.PreviewParameter
20   import androidx.compose.ui.window.DialogProperties
21   import pl.gov.coi.common.domain.label.Label
22   import pl.gov.coi.common.ui.ds.button.Button
23   import pl.gov.coi.common.ui.ds.custom.icon.Icon
24   import pl.gov.coi.common.ui.ds.custom.icon.IconData
25   import pl.gov.coi.common.ui.ds.custom.icon.IconSize
26   import pl.gov.coi.common.ui.ds.dialog.provider.DialogPreviewParameterProvider
27   import pl.gov.coi.common.ui.text.CustomText
28   import pl.gov.coi.common.ui.theme.AppTheme
29   
30   @Composable
31   fun Dialog(
32     data: DialogData,
33   ) {
34     androidx.compose.ui.window.Dialog(
35       properties = DialogProperties(usePlatformDefaultWidth = false),
36       onDismissRequest = data.onDismiss,
37     ) {
38       Column(
39         modifier = Modifier
40           .padding(AppTheme.dimensions.spacing300)
41           .background(color = AppTheme.colors.white, AppTheme.shapes.radius200)
42           .padding(
43             vertical = AppTheme.dimensions.spacing300,
44             horizontal = AppTheme.dimensions.spacing250,
45           )
46           .semantics { testTag = data.testTag ?: data.title.tag },
47         horizontalAlignment = data.horizontalAlignment,
48       ) {
49         if (data is DialogData.WithIcon) {
50           Icon(
51             data = IconData.Standard(
52               testTag = data.testTag?.let { tag -> tag + "Icon" },
53               iconResId = data.icon.iconResId,
54               iconColorProvider = data.icon.iconColorProvider,
55               iconSize = IconSize.SIZE24,
56               contentDescription = Label.EMPTY,
57             ),
58           )
59           Spacer(Modifier.height(AppTheme.dimensions.spacing200))
60         }
61   
62         CustomText(
63           testTag = data.testTag?.let { tag -> tag + "Title" },
64           label = data.title,
65           style = AppTheme.typography.titleMedium,
66           textAlign = data.textAlign,
67           color = AppTheme.colors.neutral500,
68         )
69         data.annotatedBody?.let { annotatedBody ->
70           Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing200))
71           CustomText(
72             testTag = data.testTag?.let { tag -> tag + "AnnotatedBody" },
73             annotatedContent = annotatedBody.invoke(),
74             style = AppTheme.typography.bodyMediumRegular,
75             textAlign = data.textAlign,
76             color = AppTheme.colors.neutral200,
77           )
78         } ?: data.body?.let {
79           Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing200))
80           CustomText(
81             testTag = data.testTag?.let { tag -> tag + "Body" },
82             label = data.body,
83             style = AppTheme.typography.bodyMediumRegular,
84             textAlign = TextAlign.Start,
85             color = AppTheme.colors.neutral200,
86           )
87         }
88         if (data is DialogData.WithThreeButtons) {
89           Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing300))
90           Column(
91             modifier = Modifier.fillMaxWidth(),
92             horizontalAlignment = Alignment.End,
93             verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.spacing150),
94           ) {
95             Button(data.primaryButtonData)
96             Button(data.secondaryButtonData)
97             Button(data.tertiaryButtonData)
98           }
99         } else {
100          Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing400))
101          Row(
102            Modifier.fillMaxWidth(),
103            horizontalArrangement = Arrangement.End,
104          ) {
105            data.secondaryButtonData?.let { secondaryButtonData ->
106              Button(data = secondaryButtonData)
107              Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing50))
108            }
109            Button(data = data.primaryButtonData)
110          }
111        }
112      }
113    }
114  }
115  
116  @Preview
117  @Composable
118  fun DialogPreview(
119    @PreviewParameter(DialogPreviewParameterProvider::class) dialogData: DialogData,
120  ) {
121    Dialog(data = dialogData)
122  }
123  