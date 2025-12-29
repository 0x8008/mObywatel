1    package pl.gov.coi.common.ui.ds.bottomnavigation
2    
3    import androidx.annotation.DrawableRes
4    import androidx.compose.foundation.background
5    import androidx.compose.foundation.border
6    import androidx.compose.foundation.interaction.MutableInteractionSource
7    import androidx.compose.foundation.interaction.collectIsFocusedAsState
8    import androidx.compose.foundation.layout.Arrangement
9    import androidx.compose.foundation.layout.Box
10   import androidx.compose.foundation.layout.Column
11   import androidx.compose.foundation.layout.Row
12   import androidx.compose.foundation.layout.RowScope
13   import androidx.compose.foundation.layout.fillMaxWidth
14   import androidx.compose.foundation.layout.height
15   import androidx.compose.foundation.layout.padding
16   import androidx.compose.foundation.layout.width
17   import androidx.compose.foundation.selection.selectable
18   import androidx.compose.foundation.shape.RoundedCornerShape
19   import androidx.compose.material3.Surface
20   import androidx.compose.runtime.Composable
21   import androidx.compose.runtime.remember
22   import androidx.compose.ui.Alignment
23   import androidx.compose.ui.ExperimentalComposeUiApi
24   import androidx.compose.ui.Modifier
25   import androidx.compose.ui.draw.clip
26   import androidx.compose.ui.graphics.Color
27   import androidx.compose.ui.platform.LocalDensity
28   import androidx.compose.ui.semantics.Role
29   import androidx.compose.ui.semantics.isTraversalGroup
30   import androidx.compose.ui.semantics.selectableGroup
31   import androidx.compose.ui.semantics.semantics
32   import androidx.compose.ui.semantics.testTag
33   import androidx.compose.ui.semantics.testTagsAsResourceId
34   import androidx.compose.ui.text.font.FontWeight
35   import androidx.compose.ui.text.style.TextAlign
36   import androidx.compose.ui.text.style.TextOverflow
37   import androidx.compose.ui.unit.dp
38   import androidx.compose.ui.unit.sp
39   import pl.gov.coi.common.domain.label.Label
40   import pl.gov.coi.common.ui.ds.custom.icon.Icon
41   import pl.gov.coi.common.ui.ds.custom.icon.IconData
42   import pl.gov.coi.common.ui.ds.custom.icon.IconSize
43   import pl.gov.coi.common.ui.text.CustomText
44   import pl.gov.coi.common.ui.theme.AppTheme
45   import pl.gov.coi.common.ui.utils.defaultRippleEffect
46   
47   @Composable
48   fun BottomNavigation(
49     data: BottomNavigationData,
50   ) {
51     val bottomNavigationHeight = 80.dp
52     Surface(
53       color = AppTheme.colors.background,
54       contentColor = AppTheme.colors.background,
55       modifier = Modifier,
56     ) {
57       Row(
58         Modifier
59           .height(bottomNavigationHeight)
60           .fillMaxWidth()
61           .semantics {
62             isTraversalGroup = true
63             selectableGroup()
64           },
65         content = {
66           data.items.forEachIndexed { index, item ->
67             this.BottomNavigationItem(
68               testTag = item.testTag,
69               selected = data.selectedItemIndex == index,
70               unselectedIconResId = item.unselectedIconResId,
71               selectedIconResId = item.selectedIconResId,
72               label = item.label,
73               onClick = { item.onClickAction.invoke() },
74             )
75           }
76         },
77         horizontalArrangement = Arrangement.SpaceEvenly,
78         verticalAlignment = Alignment.CenterVertically,
79       )
80     }
81   }
82   
83   @OptIn(ExperimentalComposeUiApi::class)
84   @Composable
85   private fun RowScope.BottomNavigationItem(
86     testTag: String?,
87     selected: Boolean,
88     onClick: () -> Unit,
89     @DrawableRes unselectedIconResId: Int,
90     @DrawableRes selectedIconResId: Int,
91     modifier: Modifier = Modifier,
92     enabled: Boolean = true,
93     label: Label? = null,
94     interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
95     selectedContentColor: Color = AppTheme.colors.primary900,
96     unselectedContentColor: Color = AppTheme.colors.neutral200,
97     selectedIconBackground: Color = AppTheme.colors.secondary900,
98     unselectedIconBackground: Color = Color(0x00000000),
99   ) {
100    val isFocused = interactionSource.collectIsFocusedAsState()
101  
102    Box(
103      modifier
104        .selectable(
105          selected = selected,
106          onClick = onClick,
107          enabled = enabled,
108          role = Role.Tab,
109          interactionSource = interactionSource,
110          indication = null,
111        )
112        .weight(1f)
113        .semantics { testTagsAsResourceId = true }
114        .semantics { this.testTag = testTag ?: "navigationItem${label?.tag ?: "Undefined"}" },
115      contentAlignment = Alignment.Center,
116    ) {
117      Column {
118        Box(
119          Modifier
120            .align(Alignment.CenterHorizontally)
121            .clip(RoundedCornerShape(40.dp))
122            .border(
123              width = AppTheme.dimensions.spacing25,
124              color = if (isFocused.value) AppTheme.colors.neutral500 else Color.Transparent,
125              shape = AppTheme.shapes.radius500,
126            )
127            .border(
128              width = AppTheme.dimensions.spacing50,
129              color = if (isFocused.value) AppTheme.colors.white else Color.Transparent,
130              shape = AppTheme.shapes.radius500,
131            )
132            .background(
133              when {
134                selected -> selectedIconBackground
135                isFocused.value -> AppTheme.colors.neutral500.copy(alpha = 0.1f)
136                else -> unselectedIconBackground
137              },
138            )
139            .defaultRippleEffect(interactionSource = interactionSource)
140            .padding(12.dp, 6.dp)
141            .width(42.dp),
142        ) {
143          Icon(
144            modifier = Modifier.align(Alignment.Center),
145            data = IconData.Standard(
146              testTag = testTag?.let { tag -> tag + "Icon" },
147              iconResId = if (selected) selectedIconResId else unselectedIconResId,
148              iconSize = IconSize.SIZE24,
149              iconColorProvider = { if (selected) selectedContentColor else unselectedContentColor },
150              contentDescription = Label.EMPTY,
151            ),
152          )
153        }
154        if (label != null) {
155          val fontSize = AppTheme.typography.bodySmallMedium.fontSize.value / LocalDensity.current.fontScale
156          CustomText(
157            testTag = testTag?.let { tag -> tag + "Text" },
158            label = label,
159            fontSize = fontSize.sp,
160            style = AppTheme.typography.bodySmallMedium,
161            fontWeight = FontWeight(500),
162            color = if (selected) selectedContentColor else unselectedContentColor,
163            modifier = Modifier.fillMaxWidth(),
164            overflow = TextOverflow.Visible,
165            softWrap = false,
166            textAlign = TextAlign.Center,
167          )
168        }
169      }
170    }
171  }
172  