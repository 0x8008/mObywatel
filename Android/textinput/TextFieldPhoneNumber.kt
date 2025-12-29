1    package pl.gov.coi.common.ui.ds.textinput
2    
3    import androidx.compose.foundation.layout.Box
4    import androidx.compose.foundation.layout.Row
5    import androidx.compose.foundation.layout.Spacer
6    import androidx.compose.foundation.layout.width
7    import androidx.compose.foundation.layout.widthIn
8    import androidx.compose.runtime.Composable
9    import androidx.compose.ui.Modifier
10   import androidx.compose.ui.focus.FocusManager
11   import androidx.compose.ui.platform.LocalFocusManager
12   import androidx.compose.ui.tooling.preview.Preview
13   import androidx.compose.ui.unit.dp
14   import pl.gov.coi.common.domain.label.toLabel
15   import pl.gov.coi.common.domain.validators.ValidationState
16   import pl.gov.coi.common.ui.ds.textinput.model.TextInputData
17   import pl.gov.coi.common.ui.focus.FocusHost
18   import pl.gov.coi.common.ui.focus.createFocusHost
19   import pl.gov.coi.common.ui.theme.AppTheme
20   
21   private val COUNTRY_CODE_MIN_WIDTH = 70.dp
22   private val COUNTRY_CODE_MAX_WIDTH = 110.dp
23   
24   @Composable
25   internal fun TextFieldPhoneNumber(
26     data: TextInputData.PhoneNumber,
27     focusHost: FocusHost,
28     focusManager: FocusManager,
29   ) {
30     Row {
31       Box(modifier = Modifier.widthIn(min = COUNTRY_CODE_MIN_WIDTH, max = COUNTRY_CODE_MAX_WIDTH)) {
32         TextField(
33           data = data.countryCodeNumber,
34           focusHost = focusHost,
35           focusManager = focusManager,
36         )
37       }
38   
39       Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
40       Box(modifier = Modifier) {
41         TextField(
42           data = data.phoneNumber,
43           focusHost = focusHost,
44           focusManager = focusManager,
45         )
46       }
47     }
48   }
49   
50   @Preview
51   @Composable
52   fun Preview() {
53     TextFieldPhoneNumber(
54       data = TextInputData.PhoneNumber(
55         label = "Numer telefonu".toLabel(tag = "phoneNumberPreviewLabel"),
56         countryCodeValue = "+48".toLabel(tag = "countryCodePreviewValue"),
57         phoneNumberValue = "123456789".toLabel(tag = "phoneNumberPreviewValue"),
58         onCountryCodeChanged = {},
59         onPhoneNumberChanged = {},
60         isCountryCodeCorrect = null,
61         isPhoneNumberCorrect = null,
62         validationState = ValidationState.Default,
63       ),
64       focusHost = createFocusHost(),
65       focusManager = LocalFocusManager.current,
66     )
67   }
68   