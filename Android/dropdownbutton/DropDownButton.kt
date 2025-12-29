1    package pl.gov.coi.common.ui.ds.dropdownbutton
2    
3    import androidx.compose.foundation.background
4    import androidx.compose.foundation.border
5    import androidx.compose.foundation.clickable
6    import androidx.compose.foundation.focusable
7    import androidx.compose.foundation.layout.Arrangement
8    import androidx.compose.foundation.layout.Box
9    import androidx.compose.foundation.layout.Column
10   import androidx.compose.foundation.layout.Row
11   import androidx.compose.foundation.layout.Spacer
12   import androidx.compose.foundation.layout.fillMaxSize
13   import androidx.compose.foundation.layout.fillMaxWidth
14   import androidx.compose.foundation.layout.height
15   import androidx.compose.foundation.layout.padding
16   import androidx.compose.foundation.layout.width
17   import androidx.compose.foundation.layout.wrapContentHeight
18   import androidx.compose.foundation.layout.wrapContentWidth
19   import androidx.compose.runtime.Composable
20   import androidx.compose.ui.Alignment
21   import androidx.compose.ui.ExperimentalComposeUiApi
22   import androidx.compose.ui.Modifier
23   import androidx.compose.ui.semantics.LiveRegionMode
24   import androidx.compose.ui.semantics.Role
25   import androidx.compose.ui.semantics.contentDescription
26   import androidx.compose.ui.semantics.invisibleToUser
27   import androidx.compose.ui.semantics.liveRegion
28   import androidx.compose.ui.semantics.semantics
29   import androidx.compose.ui.semantics.stateDescription
30   import androidx.compose.ui.tooling.preview.Preview
31   import androidx.compose.ui.tooling.preview.PreviewParameter
32   import pl.gov.coi.common.domain.label.Label
33   import pl.gov.coi.common.ui.R
34   import pl.gov.coi.common.ui.ds.custom.icon.Icon
35   import pl.gov.coi.common.ui.ds.custom.icon.IconData
36   import pl.gov.coi.common.ui.ds.custom.icon.IconSize
37   import pl.gov.coi.common.ui.ds.errortext.ErrorText
38   import pl.gov.coi.common.ui.ds.helpertext.HelperText
39   import pl.gov.coi.common.ui.text.CustomText
40   import pl.gov.coi.common.ui.theme.AppTheme
41   import pl.gov.coi.common.ui.utils.NoRippleInteractionSource
42   import pl.gov.coi.common.ui.utils.textWithDotAndSpaceOrEmpty
43   
44   @Composable
45   fun DropDownButton(data: DropDownButtonData) {
46     Column(
47       modifier = Modifier
48         .wrapContentHeight()
49         .semantics {
50           if (data.buttonType is DropDownButtonState.Error && data.buttonType.errorText != null) {
51             liveRegion = LiveRegionMode.Assertive
52             stateDescription = data.buttonType.errorText.text
53           }
54         },
55     ) {
56       CustomText(
57         color = data.buttonType.getLabelColor(),
58         label = data.label,
59         style = AppTheme.typography.bodyMediumRegular,
60         ignoreForAccessibility = true,
61       )
62       Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
63       DropDownClickableRow(data = data)
64       DropDownBottomText(data = data)
65     }
66   }
67   
68   @Composable
69   fun DropDownBottomText(data: DropDownButtonData) {
70     when (data.buttonType) {
71       is DropDownButtonState.Error -> data.buttonType.errorText?.let {
72         Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
73         ErrorText(errorText = data.buttonType.errorText, ignoreForAccessibility = true)
74       }
75   
76       is DropDownButtonState.Disabled ->
77         data.buttonType.helperText?.let {
78           DropDownHelperText(helperText = data.buttonType.helperText)
79         }
80   
81       is DropDownButtonState.Enabled -> data.buttonType.helperText?.let {
82         DropDownHelperText(helperText = data.buttonType.helperText)
83       }
84     }
85   }
86   
87   @Composable
88   private fun DropDownHelperText(helperText: Label) {
89     Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
90     HelperText(helperLabel = helperText, ignoreForAccessibility = true)
91   }
92   
93   @Composable
94   private fun DropDownButtonState.getLabelColor() =
95     when (this) {
96       is DropDownButtonState.Disabled -> AppTheme.colors.neutral60
97       else -> AppTheme.colors.neutral200
98     }
99   
100  @Composable
101  private fun DropDownButtonState.getPlaceholderColor() =
102    when (this) {
103      is DropDownButtonState.Disabled -> AppTheme.colors.neutral60
104      else -> AppTheme.colors.neutral100
105    }
106  
107  @Composable
108  private fun DropDownButtonState.getIconColor() =
109    when (this) {
110      is DropDownButtonState.Disabled -> AppTheme.colors.neutral60
111      else -> AppTheme.colors.neutral200
112    }
113  
114  @Composable
115  private fun DropDownButtonState.getFilledTextColor() =
116    when (this) {
117      is DropDownButtonState.Disabled -> AppTheme.colors.neutral60
118      else -> AppTheme.colors.neutral500
119    }
120  
121  @Composable
122  private fun DropDownButtonState.getBorderStroke() =
123    when (this) {
124      is DropDownButtonState.Disabled -> AppTheme.colors.neutral30
125      is DropDownButtonState.Enabled -> AppTheme.colors.neutral80
126      is DropDownButtonState.Error -> AppTheme.colors.supportRed100
127    }
128  
129  @OptIn(ExperimentalComposeUiApi::class)
130  @Composable
131  private fun DropDownClickableRow(
132    data: DropDownButtonData,
133  ) {
134    Row(
135      verticalAlignment = Alignment.CenterVertically,
136      horizontalArrangement = Arrangement.SpaceBetween,
137      modifier = Modifier
138        .focusable()
139        .semantics(mergeDescendants = true) {
140          contentDescription = data.contentDescription()
141        }
142        .fillMaxWidth()
143        .border(
144          width = AppTheme.dimensions.strokeWidth,
145          color = data.buttonType.getBorderStroke(),
146          shape = AppTheme.shapes.radius50,
147        )
148        .background(color = AppTheme.colors.white, shape = AppTheme.shapes.radius50)
149        .padding(all = AppTheme.dimensions.spacing200)
150        .clickable(
151          enabled = (data.buttonType is DropDownButtonState.Disabled).not(),
152          interactionSource = NoRippleInteractionSource(),
153          indication = null,
154          role = Role.Button,
155          onClick = {
156            data.onClick(data)
157          },
158        ),
159    ) {
160      Row(
161        modifier = Modifier
162          .weight(1.0f, fill = false)
163          .semantics { invisibleToUser() },
164      ) {
165        if (data.initialSelectedItem != null) {
166          CustomText(
167            modifier = Modifier.wrapContentWidth(),
168            ignoreForAccessibility = true,
169            color = data.buttonType.getFilledTextColor(),
170            label = data.items[data.initialSelectedItem],
171            style = AppTheme.typography.bodyLargeRegular,
172          )
173        } else {
174          CustomText(
175            modifier = Modifier.wrapContentWidth(),
176            ignoreForAccessibility = true,
177            label = data.placeholder,
178            color = data.buttonType.getPlaceholderColor(),
179            style = AppTheme.typography.bodyLargeRegular,
180          )
181        }
182        Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing100))
183      }
184  
185      Icon(
186        data = IconData.Standard(
187          iconResId = R.drawable.ab008_chevron_down,
188          iconSize = IconSize.SIZE24,
189          iconColorProvider = { data.buttonType.getIconColor() },
190          contentDescription = Label.EMPTY,
191        ),
192      )
193    }
194  }
195  
196  private fun DropDownButtonData.contentDescription() = label.textWithDotAndSpaceOrEmpty() +
197    (initialSelectedItem?.let { items[initialSelectedItem] } ?: placeholder).textWithDotAndSpaceOrEmpty() +
198    when (buttonType) {
199      is DropDownButtonState.Error -> buttonType.errorText
200      is DropDownButtonState.Disabled -> buttonType.helperText
201      is DropDownButtonState.Enabled -> buttonType.helperText
202    }
203      .textWithDotAndSpaceOrEmpty()
204      .trim()
205  
206  @Composable
207  @Preview
208  fun DropDownButtonPreview(@PreviewParameter(DropDownButtonPPP::class) data: DropDownButtonData) {
209    Box(
210      modifier = Modifier
211        .background(color = AppTheme.colors.background)
212        .padding(all = AppTheme.dimensions.spacing200)
213        .fillMaxSize(),
214    ) {
215      DropDownButton(data)
216    }
217  }
218  