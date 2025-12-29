1    package pl.gov.coi.common.ui.ds.switchcomponent
2    
3    import pl.gov.coi.common.domain.label.Label
4    import pl.gov.coi.common.domain.validators.ValidationState
5    import pl.gov.coi.common.ui.ds.button.buttontext.ButtonTextData
6    import pl.gov.coi.common.ui.ds.link.LinkData
7    
8    sealed class SwitchData(
9      val testTag: String?,
10     val checked: Boolean,
11     val enabled: Boolean,
12     val onCheckedChange: ((Boolean) -> Unit)?,
13     val contentDescription: Label?,
14     val testIndexTag: Int? = null,
15   ) {
16     class SwitchOnly(
17       testTag: String? = null,
18       checked: Boolean,
19       enabled: Boolean = true,
20       onCheckedChange: ((Boolean) -> Unit)?,
21       contentDescription: Label? = null,
22       testIndexTag: Int? = null,
23     ) : SwitchData(
24       testTag = testTag,
25       checked = checked,
26       enabled = enabled,
27       onCheckedChange = onCheckedChange,
28       contentDescription = contentDescription,
29       testIndexTag = testIndexTag,
30     )
31   
32     class SwitchWithText(
33       testTag: String? = null,
34       checked: Boolean,
35       val label: Label,
36       val validationState: ValidationState = ValidationState.Default,
37       enabled: Boolean = true,
38       onCheckedChange: (Boolean) -> Unit,
39       testIndexTag: Int? = null,
40     ) : SwitchData(
41       testTag = testTag,
42       checked = checked,
43       enabled = enabled,
44       onCheckedChange = onCheckedChange,
45       contentDescription = null,
46       testIndexTag = testIndexTag,
47     )
48   
49     
50     
51     class SwitchWithExtras(
52       testTag: String? = null,
53       checked: Boolean,
54       val label: Label,
55       val validationState: ValidationState = ValidationState.Default,
56       enabled: Boolean = true,
57       onCheckedChange: (Boolean) -> Unit,
58       testIndexTag: Int? = null,
59       val type: SwitchExtraType,
60       val customActionContentDescription: Label,
61     ) : SwitchData(
62       testTag = testTag,
63       checked = checked,
64       enabled = enabled,
65       onCheckedChange = onCheckedChange,
66       contentDescription = null,
67       testIndexTag = testIndexTag,
68     )
69   }
70   
71   sealed interface SwitchExtraType {
72     data class Link(val data: LinkData) : SwitchExtraType
73     data class TextButton(val data: ButtonTextData) : SwitchExtraType
74   }
75   