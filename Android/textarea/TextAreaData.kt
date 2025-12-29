1    package pl.gov.coi.common.ui.ds.textarea
2    
3    import androidx.compose.ui.focus.FocusRequester
4    import androidx.compose.ui.text.input.ImeAction
5    import pl.gov.coi.common.domain.label.Label
6    
7    private const val DEFAULT_MIN_LINES = 4
8    
9    data class TextAreaData(
10     val testTag: String? = null,
11     val label: Label? = null,
12     val type: TextAreaType,
13     val indexTag: Int? = null,
14     val state: TextAreaDataState,
15     val content: String = "",
16     val enabled: Boolean = true,
17     val counterState: CounterState,
18     val hint: Label = Label.EMPTY,
19     val imeAction: ImeAction = ImeAction.Done,
20     val focusRequester: FocusRequester? = null,
21     val onValueChanged: (String) -> Unit,
22   )
23   
24   sealed interface CounterState {
25     data object Hidden : CounterState
26     data class Visible(
27       val maxLength: Int,
28       val onCharsLimitReached: (Boolean) -> Unit = {},
29     ) : CounterState
30   }
31   
32   sealed interface TextAreaType {
33     data class Fix(
34       val lines: Int = DEFAULT_MIN_LINES,
35     ) : TextAreaType
36   
37     data class Flexible(
38       val maxLines: Int = Integer.MAX_VALUE,
39     ) : TextAreaType
40   }
41   
42   sealed interface TextAreaDataState {
43     data class Error(val errorLabel: Label) : TextAreaDataState
44     data class Default(val helperLabel: Label = Label.EMPTY) : TextAreaDataState
45   }
46   