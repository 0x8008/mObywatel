1    package pl.gov.coi.common.ui.ds.filepicker.model
2    
3    import pl.gov.coi.common.domain.label.Label
4    import pl.gov.coi.common.domain.label.toLabel
5    import pl.gov.coi.common.ui.R
6    import pl.gov.coi.common.ui.theme.AppTheme
7    import pl.gov.coi.common.ui.unmapped.singlecard.BodySection
8    import pl.gov.coi.common.ui.unmapped.singlecard.BodyTitleSection
9    import pl.gov.coi.common.ui.unmapped.singlecard.DefaultSingleCardData
10   import pl.gov.coi.common.ui.unmapped.singlecard.LeadingSection
11   import pl.gov.coi.common.ui.unmapped.singlecard.MediaSection
12   import pl.gov.coi.common.ui.unmapped.singlecard.SingleCardLabel
13   import pl.gov.coi.common.ui.utils.textWithDotAndSpaceOrEmpty
14   
15   data class FilePickerData(
16     val addFileLabel: Label,
17     val errorLabel: Label?,
18     val files: List<PickerFile>,
19     val requirements: List<Label>,
20     val onAddFileClicked: () -> Unit,
21     val maxAllowedFiles: Int,
22   ) {
23     internal val cardsData = files.map { file -> file.cardData }
24   
25     internal val combinedRequirements = requirements.reduce { combinedRequirements, requirement ->
26       combinedRequirements + Label.SPACE + requirement
27     }
28   
29     internal val addFileCardData = DefaultSingleCardData(
30       leadingSection = LeadingSection(
31         mediaSection = MediaSection.Icon(
32           iconResId = R.drawable.ab016_add,
33           iconColor = { AppTheme.colors.primary900 },
34         ),
35       ),
36       bodySection = BodySection(
37         title = BodyTitleSection.Title(
38           singleCardLabel = SingleCardLabel(
39             label = addFileLabel,
40             labelColor = { AppTheme.colors.primary900 },
41             contentDescription = contentDescription().toLabel("filePicker_contentDescription"),
42           ),
43         ),
44       ),
45       onClick = onAddFileClicked,
46     )
47   }
48   
49   private fun FilePickerData.contentDescription() =
50     (addFileLabel.textWithDotAndSpaceOrEmpty() +
51       combinedRequirements.textWithDotAndSpaceOrEmpty() +
52       errorLabel.textWithDotAndSpaceOrEmpty()).trim()
53   
54   internal val FilePickerData.showAddButton
55     get() = files.size < maxAllowedFiles
56   
57   internal val FilePickerData.showError
58     get() = errorLabel != null
59   