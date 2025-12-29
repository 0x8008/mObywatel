1    package pl.gov.coi.common.ui.ds.textinput.visualtransformation
2    
3    import androidx.compose.ui.text.AnnotatedString
4    import androidx.compose.ui.text.input.KeyboardType
5    import androidx.compose.ui.text.input.OffsetMapping
6    import androidx.core.text.isDigitsOnly
7    import pl.gov.coi.common.domain.label.Label
8    import pl.gov.coi.common.domain.label.toLabel
9    
10   private const val POLAND_COUNTRY_CODE = "+48"
11   private const val PLACEHOLDER_POSTAL_CODE = "__-___"
12   
13   enum class MaskType(val keyboardType: KeyboardType) : OffsetMapping {
14     BLIK(
15       keyboardType = KeyboardType.Number,
16     ) {
17       override fun getPlaceholderValue() = Label.EMPTY
18       override fun getTextValue(text: String) = text.run { if (length < 6) this else substring(0..5) }
19   
20       override fun getDisplayText(text: AnnotatedString): String {
21         val trimmed = getTextValue(text.text)
22   
23         return StringBuilder().apply {
24           for (i in trimmed.indices) {
25             append(trimmed[i])
26             if (i == 2) append(" ")
27           }
28         }.toString()
29       }
30   
31       override fun filter(text: String): Boolean = text.isDigitsOnly() && text.length <= 6
32   
33       override fun originalToTransformed(offset: Int): Int {
34         if (offset <= 2) return offset
35         if (offset <= 6) return offset + 1
36         return 7
37       }
38   
39       override fun transformedToOriginal(offset: Int): Int {
40         if (offset <= 3) return offset
41         if (offset <= 7) return offset - 1
42         return 6
43       }
44     },
45     POST_CODE(
46       keyboardType = KeyboardType.Number,
47     ) {
48       override fun getPlaceholderValue() = PLACEHOLDER_POSTAL_CODE
49         .toLabel(tag = "placeholderValue")
50   
51       override fun getTextValue(text: String): String {
52         val trimmed = text.run { if (length >= 5) substring(0..4) else this }
53   
54         return StringBuilder().apply {
55           for (i in trimmed.indices) {
56             append(trimmed[i])
57             if (i == 1) append("-")
58           }
59         }.toString()
60       }
61   
62       override fun getDisplayText(text: AnnotatedString): String {
63         return getTextValue(text.text)
64       }
65   
66       override fun filter(text: String): Boolean = text.isDigitsOnly() && text.length <= 5
67   
68       override fun originalToTransformed(offset: Int): Int {
69         if (offset <= 1) return offset
70         if (offset <= 5) return offset + 1
71         return 6
72       }
73   
74       override fun transformedToOriginal(offset: Int): Int {
75         if (offset <= 2) return offset
76         if (offset <= 6) return offset - 1
77         return 5
78       }
79     },
80     PHONE_COUNTRY_CODE(
81       keyboardType = KeyboardType.Number,
82     ) {
83       private val prefixOffset = POLAND_COUNTRY_CODE.length + 1
84   
85       override fun getPlaceholderValue() = Label.EMPTY
86   
87       override fun getTextValue(text: String): String = "$POLAND_COUNTRY_CODE $text"
88   
89       override fun filter(text: String): Boolean = text.isDigitsOnly() && text.length <= 9
90   
91       override fun originalToTransformed(offset: Int): Int {
92         return offset + prefixOffset
93       }
94   
95       override fun transformedToOriginal(offset: Int): Int {
96         if (offset < prefixOffset) return 0
97         return offset - prefixOffset
98       }
99   
100      override fun getDisplayText(text: AnnotatedString): String {
101        return getTextValue(text.text)
102      }
103    },
104    ;
105  
106    /**
107     * Returns string displayed in input.
108     * For example for BLIK code you want to display 123 456 but you want to type just 123456,
109     * for post code you want to display 00-123 but you want to type 00123
110     */
111    abstract fun getDisplayText(text: AnnotatedString): String
112  
113    /**
114     * Returns real text input value
115     * For example for BLIK code you want to display 123 456 but you want to get just 123456 value,
116     * for post code you want to display 00-123 and get the same value as well
117     */
118    abstract fun getTextValue(text: String): String
119  
120    /**
121     * Filter input field value
122     */
123    abstract fun filter(text: String): Boolean
124  
125    /**
126     * Returns placeholder value to show in textField for concrete maskType
127     */
128    abstract fun getPlaceholderValue(): Label
129  }
130  