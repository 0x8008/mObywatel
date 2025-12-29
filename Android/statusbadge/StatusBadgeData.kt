1    package pl.gov.coi.common.ui.ds.statusbadge
2    
3    import pl.gov.coi.common.domain.label.Label
4    
5    sealed class StatusBadgeData(
6      open val testTag: String?,
7      open val label: Label,
8      open val withBorder: Boolean = false,
9      open val contentDescription: Label = Label.EMPTY,
10     open val maxLines: Int,
11   ) {
12     data class WithDot(
13       override val testTag: String? = null,
14       override val label: Label,
15       override val contentDescription: Label = Label.EMPTY,
16       override val maxLines: Int = Int.MAX_VALUE,
17       val status: StatusBadgeWithDotStatus,
18     ) : StatusBadgeData(
19       testTag = testTag,
20       label = label,
21       withBorder = false,
22       maxLines = maxLines,
23     )
24   
25     data class WithIcon(
26       override val testTag: String? = null,
27       override val label: Label,
28       override val contentDescription: Label = Label.EMPTY,
29       override val maxLines: Int = Int.MAX_VALUE,
30       override val withBorder: Boolean = true,
31       val status: StatusBadgeWithIconStatus,
32     ) : StatusBadgeData(
33       testTag = testTag,
34       label = label,
35       withBorder = withBorder,
36       maxLines = maxLines,
37     )
38   }
39   
40   enum class StatusBadgeWithIconStatus {
41     POSITIVE,
42     INFORMATIVE,
43     NEGATIVE,
44     NOTICE,
45     MINUS,
46   }
47   
48   enum class StatusBadgeWithDotStatus {
49     POSITIVE,
50     INFORMATIVE,
51     NEGATIVE,
52     WARNING,
53   }
54   