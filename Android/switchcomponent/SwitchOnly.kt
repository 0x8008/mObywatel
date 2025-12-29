1    package pl.gov.coi.common.ui.ds.switchcomponent
2    
3    import androidx.compose.foundation.layout.Box
4    import androidx.compose.material3.Switch
5    import androidx.compose.material3.SwitchDefaults
6    import androidx.compose.runtime.Composable
7    import androidx.compose.ui.Alignment
8    import androidx.compose.ui.ExperimentalComposeUiApi
9    import androidx.compose.ui.Modifier
10   import androidx.compose.ui.semantics.semantics
11   import androidx.compose.ui.semantics.testTag
12   import androidx.compose.ui.semantics.testTagsAsResourceId
13   import pl.gov.coi.common.ui.theme.AppTheme
14   import pl.gov.coi.common.ui.utils.semanticsContentDescription
15   
16   @OptIn(ExperimentalComposeUiApi::class)
17   @Composable
18   internal fun SwitchOnly(
19     data: SwitchData.SwitchOnly,
20   ) {
21     Box(
22       contentAlignment = Alignment.Center,
23     ) {
24       Switch(
25         modifier = Modifier
26           .semanticsContentDescription(data.contentDescription?.text ?: "")
27           .semantics { testTagsAsResourceId = true }
28           .semantics { testTag = data.testTag ?: "switch${data.testIndexTag?.let { "_${data.testIndexTag}" } ?: ""}" },
29         checked = data.checked,
30         enabled = data.enabled,
31         colors = SwitchDefaults.colors(
32           checkedThumbColor = AppTheme.colors.white,
33           checkedTrackColor = AppTheme.colors.primary900,
34           uncheckedThumbColor = AppTheme.colors.neutral80,
35           uncheckedTrackColor = AppTheme.colors.neutral10,
36           uncheckedBorderColor = AppTheme.colors.neutral80,
37           disabledCheckedThumbColor = AppTheme.colors.white,
38           disabledCheckedTrackColor = AppTheme.colors.neutral10,
39           disabledUncheckedThumbColor = AppTheme.colors.neutral60,
40           disabledUncheckedTrackColor = AppTheme.colors.neutral10,
41           disabledUncheckedBorderColor = AppTheme.colors.neutral30,
42         ),
43         onCheckedChange = data.onCheckedChange,
44       )
45     }
46   }
47   