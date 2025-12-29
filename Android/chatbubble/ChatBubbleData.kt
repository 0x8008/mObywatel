1    package pl.gov.coi.common.ui.ds.chatbubble
2    
3    import pl.gov.coi.common.domain.label.CommonUILabelProvider
4    import pl.gov.coi.common.domain.label.Label
5    import pl.gov.coi.common.domain.label.toLabel
6    import pl.gov.coi.common.ui.R
7    import pl.gov.coi.common.ui.ds.button.ButtonData
8    import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
9    import pl.gov.coi.common.ui.ds.button.common.ButtonSize
10   import pl.gov.coi.common.ui.ds.button.common.ButtonType
11   import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
12   import pl.gov.coi.common.ui.theme.AppTheme
13   
14   sealed class ChatBubbleData(
15     open val label: Label?,
16     open val isLoading: Boolean,
17     open val content: List<Content>?,
18     open val additionalInfo: Label?,
19     open val footerData: FooterData?,
20     open val actions: List<ClickableContent>?,
21     open val suggestions: List<ClickableContent>?,
22     open val onUrlClick: (String) -> Unit,
23   ) {
24   
25     data class IncomingMessage(
26       override val label: Label?,
27       override val isLoading: Boolean = true,
28       override val content: List<Content>? = null,
29       override val additionalInfo: Label? = null,
30       override val footerData: FooterData? = null,
31       override val actions: List<ClickableContent>? = null,
32       override val suggestions: List<ClickableContent>? = null,
33       override val onUrlClick: (String) -> Unit = {},
34     ) : ChatBubbleData(
35       label = label,
36       isLoading = isLoading,
37       content = content,
38       additionalInfo = additionalInfo,
39       footerData = footerData,
40       actions = actions,
41       suggestions = suggestions,
42       onUrlClick = onUrlClick,
43     )
44   
45     data class OutgoingMessage(
46       override val label: Label? = null,
47       override val content: List<Content>,
48     ) : ChatBubbleData(
49       label = label,
50       isLoading = false,
51       content = content,
52       additionalInfo = null,
53       footerData = null,
54       actions = null,
55       suggestions = null,
56       onUrlClick = {},
57     )
58   }
59   
60   data class Content(
61     val type: ContentType,
62     val value: String,
63     val url: String? = null,
64   )
65   
66   enum class ContentType {
67     TEXT,
68     SOURCE,
69     LINK,
70     UNKNOWN,
71   }
72   
73   data class FooterData(
74     val sourcesData: SourcesData?,
75     val actionsData: List<FooterActionData>,
76   ) {
77     internal val isVisible = sourcesData != null || actionsData.isNotEmpty()
78   }
79   
80   data class SourcesData(
81     val title: Label,
82     val showMoreButtonLabel: Label,
83     val showLessButtonLabel: Label,
84     val items: List<ClickableContent>,
85   )
86   
87   data class ClickableContent(
88     val value: String,
89     val onClick: () -> Unit,
90   ) {
91     internal val actionButtonData = ButtonData(
92       buttonSize = ButtonSize.Large(),
93       buttonVariant = ButtonVariant.Secondary(),
94       buttonType = ButtonType.WithText(
95         label = value.toLabel(tag = "buttonTypeValue"),
96       ),
97       onClick = onClick,
98     )
99   }
100  
101  sealed class FooterActionData {
102    abstract val buttonData: ButtonIconData
103  
104    data class Share(val onClick: () -> Unit) : FooterActionData() {
105      override val buttonData: ButtonIconData = ButtonIconData(
106        iconResId = R.drawable.aa005_upload,
107        iconColorProvider = { AppTheme.colors.neutral200 },
108        onClick = onClick,
109        contentDescription = CommonUILabelProvider.commonAccessibilityAnswerShare(),
110      )
111    }
112  
113    sealed class Toggleable(
114      open val isSelected: Boolean,
115      open val onToggle: (selected: Boolean) -> Unit,
116    ) : FooterActionData() {
117      override val buttonData by lazy {
118        ButtonIconData(
119          iconResId = iconResId,
120          iconColorProvider = {
121            when (isSelected) {
122              true -> AppTheme.colors.primary900
123              else -> AppTheme.colors.neutral200
124            }
125          },
126          onClick = { onToggle(!isSelected) },
127          contentDescription = contentDescription(),
128        )
129      }
130  
131      data class PositiveRate(
132        override val isSelected: Boolean,
133        override val onToggle: (selected: Boolean) -> Unit,
134      ) : Toggleable(
135        isSelected = isSelected,
136        onToggle = onToggle,
137      )
138  
139      data class NegativeRate(
140        override val isSelected: Boolean,
141        override val onToggle: (selected: Boolean) -> Unit,
142      ) : Toggleable(
143        isSelected = isSelected,
144        onToggle = onToggle,
145      )
146    }
147  }
148  
149  private val FooterActionData.Toggleable.iconResId
150    get() = when (this) {
151      is FooterActionData.Toggleable.PositiveRate -> when (isSelected) {
152        true -> R.drawable.b013_like
153        false -> R.drawable.ah001_like
154      }
155      is FooterActionData.Toggleable.NegativeRate -> when (isSelected) {
156        true -> R.drawable.b014_dislike
157        false -> R.drawable.ah002_dislike
158      }
159    }
160  
161  private fun FooterActionData.Toggleable.contentDescription(): Label {
162    val statusContentDescription = if (isSelected) {
163      CommonUILabelProvider.commonAccessibilityChecked()
164    } else {
165      CommonUILabelProvider.commonAccessibilityUnchecked()
166    }
167    val iconContentDescription = when (this) {
168      is FooterActionData.Toggleable.PositiveRate -> CommonUILabelProvider.commonAccessibilityAnswerHelpful()
169      is FooterActionData.Toggleable.NegativeRate -> CommonUILabelProvider.commonAccessibilityAnswerUnhelpful()
170    }
171    return "${iconContentDescription.text}. ${statusContentDescription.text}."
172      .toLabel(
173        tag = "${iconContentDescription.tag}_${statusContentDescription.tag}",
174      )
175  }
176  