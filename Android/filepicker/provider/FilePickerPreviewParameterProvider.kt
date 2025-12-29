1    package pl.gov.coi.common.ui.ds.filepicker.provider
2    
3    import android.graphics.BitmapFactory
4    import android.util.Base64
5    import androidx.compose.runtime.Composable
6    import androidx.compose.ui.tooling.preview.PreviewParameterProvider
7    import pl.gov.coi.common.domain.label.toLabel
8    import pl.gov.coi.common.ui.ds.filepicker.model.FilePickerData
9    import pl.gov.coi.common.ui.ds.filepicker.model.PickerFile
10   import pl.gov.coi.common.ui.ds.filepicker.model.PickerFile.Image.LeadingImageData
11   import pl.gov.coi.common.ui.preview.ScreenShotTestDataProvider
12   import pl.gov.coi.common.ui.preview.WrappedValue
13   import java.util.Locale
14   
15   internal class FilePickerPreviewParameterProvider : PreviewParameterProvider<WrappedValue<FilePickerData>> {
16   
17     private val userMockedPhoto by lazy {
18       Base64.decode(mockedPhoto, Base64.NO_WRAP).run {
19         BitmapFactory.decodeByteArray(this, 0, size)
20       }
21     }
22   
23     override val values: Sequence<WrappedValue<FilePickerData>>
24       get() = screenShotTestValues.map { it.wrappedValue }
25   
26     val screenShotTestValues = sequenceOf(
27       testScreenshotProvider(
28         name = "FileUploaderWithoutFiles",
29         files = { emptyList() },
30         maxAllowedFiles = 10,
31       ),
32       testScreenshotProvider(
33         name = "FileUploaderWithoutFilesWithError",
34         files = { emptyList() },
35         maxAllowedFiles = 10,
36         error = "Adding file is required",
37       ),
38       testScreenshotProvider(
39         name = "FileUploaderWithFilesSizeWhichNotExceedLimit",
40         files = { createMixedFiles(numberOfFiles = 2, longNames = false) },
41         maxAllowedFiles = 8,
42       ),
43       testScreenshotProvider(
44         name = "FileUploaderWithFilesSizeWhichNotExceedLimitLongNames",
45         files = { createMixedFiles(numberOfFiles = 2, longNames = true) },
46         maxAllowedFiles = 8,
47       ),
48       testScreenshotProvider(
49         name = "FileUploaderWithFilesSizeSameAsLimit",
50         files = { createMixedFiles(numberOfFiles = 4, longNames = false) },
51         maxAllowedFiles = 4,
52       ),
53       testScreenshotProvider(
54         name = "FileUploaderWithFilesSizeSameAsLimitLongNames",
55         files = { createMixedFiles(numberOfFiles = 4, longNames = true) },
56         maxAllowedFiles = 4,
57       ),
58     )
59   
60     private fun testScreenshotProvider(
61       name: String,
62       files: @Composable () -> List<PickerFile>,
63       maxAllowedFiles: Int,
64       error: String? = null,
65     ) =
66       ScreenShotTestDataProvider(
67         screenShotTestName = name,
68         wrappedValue = WrappedValue {
69           FilePickerData(
70             addFileLabel = "Add file".toLabel(""),
71             errorLabel = error?.toLabel(""),
72             files = files(),
73             requirements = listOf(
74               "Dopuszczalne formaty: .jpg, .jpeg, .png, .pdf.".toLabel(""),
75               "Maksymalny rozmiar plików: 96,4 MB.".toLabel(""),
76               "Dopuszczalna liczba plików: 4.".toLabel(""),
77             ),
78             onAddFileClicked = {},
79             maxAllowedFiles = maxAllowedFiles,
80           )
81         },
82       )
83   
84     @Composable
85     private fun createMixedFiles(numberOfFiles: Int, longNames: Boolean) = buildList {
86       repeat(numberOfFiles) { index ->
87         val innerIndex = index + 1
88         val isEven = (innerIndex % 2) == 0
89         add(
90           if (isEven) {
91             createRegularFile(index = innerIndex, longName = longNames)
92           } else {
93             createImageFile(index = innerIndex, longName = longNames)
94           },
95         )
96       }
97     }
98   
99     private fun createRegularFile(index: Int, longName: Boolean) = PickerFile.Regular(
100      title = createTitle(index = index, longName = longName),
101      description = (String.format(Locale.ENGLISH, "%.2f", index * 2.372) + " MB").toLabel(""),
102      onDeleteClick = {},
103    )
104  
105    private fun createTitle(index: Int, longName: Boolean) = buildString {
106      append("File $index ")
107      if (longName) {
108        repeat(12) {
109          append("Very ")
110        }
111        append("Long Text")
112      }
113    }.toLabel("")
114  
115    @Composable
116    private fun createImageFile(index: Int, longName: Boolean) = PickerFile.Image(
117      title = createTitle(index = index, longName = longName),
118      description = (String.format(Locale.ENGLISH, "%.2f", index * 2.372) + " MB").toLabel(""),
119      onDeleteClick = {},
120      onImageClick = {},
121      leadingImageData = LeadingImageData.Image(bitmap = userMockedPhoto),
122    )
123  
124    private val mockedPhoto = "iVBORw0KGgoAAAANSUhEUgAAALQAAADGCAYAAAB7J6r4AAAAAXNSR0IArs4c6QAAAA" +
125      "RnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAA7DSURBVHhe7Z37VxRHFoCLGYYZnoO8VFQQBUQUENS4GpMYY3Sj++cmumtcY9zd" +
126      "YzQKiA9UZMUHisjwfjMMO3dsTrLKdPdM36quun2/czzp8ReVfF1zq+6tews6uro3BMMQIWT9l2FIwEIzpGChGVKw0AwpWGiGFCw0QwoWmiEFC8" +
127      "2QgoVmSMFCM6RgoRlSsNAMKVhohhQsNEMKFpohBQvNkIKFZkjBQjOkYKEZUvCdQovqXVHR2FUmCkIF1u98zttnC2JsaFlsbPCPTFcCL3RDR5mo" +
128      "bYxZn9yxsrguHl6fsj4xOhHokKPnUk3OMgPRkrA4+rcaEQpnX80Zfwik0KF0WAFCFnj0sfuHalFRG7E+MToQSKG7L1ZbT95pOREXsbKw9Ynxm8" +
129      "AJDasqNofObLOeGL8JlNCR4pC0uLftdKX1xPhJoITuOCtvJS2tLLSeGD8JjNChdJhb4HUX6EDrybj1xPhFYIRu7KqwnuRRXs0nHn4TGKGr6ous" +
130      "J7lw6OEvgRC6vErdynngSw47/CQQQu//Qn64sQnE6Xb1IIxcAiF0uFCtYHuPlFlPjGrIC936F/UhQFV91HpiVENe6PIaf04eVMbtzB+QFrq4wr" +
131      "8aC5VxO/MHpIVu/9q/GgvVcTvzEbJCS04KuqL9Gy5aUg1ZoRu6/D9pKC7nslLVkBW6ZnfuN1FkUFGtJkPJfISk0Dqln1tO8uZQJSSFbjmhl0Qh" +
132      "st+D+kHyRx2O6PXP2neMV2lVkBO6+Xi59aQP8TqOo1VBTuj4dj3TzhV1nDlUASmhoxrfvt5/lMMOFZASuv0rfS+qclMaNZASWndp2s/wzXDZkB" +
133      "F6d3up9aQvxWV8PUs2ZITevq/YetKbCj7xkAoJoU1qxdXCZaVSISF02ymzYtMQl5ZKg4TQ4SKzBNEtNU8J44Xe16NfZtCJsm2cZJGF8UJvM/RC" +
134      "atUePcpbqWG00NFScwvo93bof8xoIkYLfegbcxMV3IxGDkYLbboUHeeqrCcGC2OFrm8tsZ7MpShm/BZGO4z9ie4kIDQQ38GZQ0yMFLqwiM7K1s" +
135      "y3WVAx0ox2gzeDWxGO+LMXgE6pRcUhESsrFCUVhZkSgkKf/i5YGDlJFmYMUmJhOime/Hva+oQPvDA1e2KirimWFjj3o87Z8VUxNrwk5ibXhNDc" +
136      "FuOE3tNRJurymP6qO/d+nLCecIAz+rbT8fSKi/8lPD6yLEYfL4hUSj91jBOa2uq8yejgQmYV9ArcMN+maKO5kRJi8OaUWJpft37Hf4yKoU3ODD" +
137      "qxq81b5rD1VEXmZVclM1CQtqf9zDbRc6laVG7X47TGKKEPUW5+mN6L5ZMo2nO4LCNyeZV/QsHmcv/xjy9Uic9dq4wSGlYEynR+5/6FhdMIEKhu" +
138      "r177iYOnK0XXef8yoMYosqOFRiLFjsKou/8dDemNcdcF/JnlWECeAF62SEx9iGiM0LsO0Bf6+Z056yk7sPrVGnLK03lum/IBSkYIHYSeFv/tmx" +
139      "Mz4yvWp8+B0c6w6pmWJa3eHVMaghjx0/FztIQKHt6YElOjNjIXFojuH8w9rtwMQVRghNDRUrNWpVzo/3tCrNic48IJQvdf9Y2Xc6HnknyptTdl" +
140      "R7MZ/Tbyof9qQqwn7fNacMZLBZh7c+SC3PBDe6G9Jhx0Zei3GbG+ai+zqq9plUDvbpkxtdZCR0tohhofXi2L2Yk169PWUJR5E4ip97TLObXS2h" +
141      "iKY9E2NjbEq4F569PWBKFvR92+EikLltbFSRRXqd6fJtJSWx+2oLgsnKmPkMXok0Uxkf6GSK6mrN/JTk1DTDR2yj1Hxq4y1Fbo+gMlYiex7OBI" +
142      "/5xIvMl+PAfIeImTKylx/9qkp1pm+NaoqMWvF5lLrIlnt2asT97RNuSgJjOsyk4yywix+q4kxP2fvckMDN2ezaymqXXc9a+8OpJeVq0PCNDcdW" +
143      "nI/asJ6yk7mJNn15bXpQgIL8jIfecUfS5gnrNrKfThs7T6VcBZ8/qavVgdOVTaOQFx8sC1KesTPonXK2IAVn0koLQBK6WvpdDUjusG/2V/XxAS" +
144      "Dvnc9duKkYF5MfZ80fokj7V0XI65oev8HueF1s4cih3uVxbsryjtO4bTQTXxZlkkXi1bn9Tw5D84l3shxY/RCUs7oal1uH/1wP7MGahEmK0IYc" +
145      "1Iv/Ofhc3CVFKMDeN8IzQhtEbWSugilwXuJvHhpf2KmdnlIwBFTn4xOogjNMZ9SK0MOvBl3HqiAWQFndiLsCq9R7gt7pXen3BeKK+bQ71W6BJa" +
146      "t7pfDixYT9nB+FZ6M+j858gGXt6kQ+WgGxq7vBWjaSM0ZAapkXhtH27A6YZX3j6Vf6LhlkfXvR8VVtZ5209oIzS1zKAbmrq9hxvvhvQR2k19iC" +
147      "MeX3IthMZYqXTDqXAfMHU+jB0z46vWkwc8+KCF0Ie+pVcmujyftJ7kMfnOvjbEDzDamXmZCqyF0FFim0FgegxhpXIAGibqxnzC/uKCG6BTar74" +
148      "LnRck55o2DgJjdGaYW0ZIWbVEOhZnS++C918nObtjNUle9kwjutcHHMbiZeX3VehKc+8dirbDEfp/tu94uVF9VXoA6doZQZzwbQOSCrxcurl60" +
149      "8V5noElSC0N/MD34Sua6LbQMYNGDdJ+KX4HN+E3nOI9qxrp/0BRlatkOjgTuNiaIqZwU+JOsiWdOia5IYWpIsBmBTHvYeRXvTwRehD39K6M7gV" +
150      "8Z32aW2MM+RYuX57kO1N3ntXewnHfBGaaouvP+M0RAfrNjZcXdIJ6AftlYWZ/MsGlJslo1mJjkAHJBXsltQjLh9CCHcCAS8XFpQLHYS+bYCqpJ" +
151      "FOp0Ud53CKzLxU7CkVOkw4M5gPM+9xCphUzzHJhg7JIqV/g/3HgrE6b+JUBjl8F6cDEUbc6hWsnnzrSW+bZaVCl9fg3HA2hV0H7c/a3VyidYuK" +
152      "cQ/ZwOz1POFwS94JZUJX7aZ3O8OJzAGEQ5SFcm0pDfxZB7+qtD6po7wqkun1jMWbJ96ulCkTurFDvySACpxmCr68j9ccpiReqDQDC3uiVuwCM4" +
153      "9fWsqEhjl7QaThsP2GbRppY7gJnHo0K9irRKIhcQR5OtfoU+83cJQIffgsvTuDuRAttX+b5ydx7x/GdxRJHZ1ctSsqOr/Hz/aODXm/j6hEaIp3" +
154      "BnOh/Wv72PbZb3gd7DfZHG4PYQgmneeqUdovfMrqkn1DS7dIFxqrd5vJQJlnsU3t90Zqw1Xbg3yAjWLPxWoR85C5hPQ6JMTgBYnE5OQSHv+K1M" +
155      "VU9owVioN/8gFO6GBgUDYK0ktLz0X5P6v3L5YyX+1Opyuh9N8Hip9UnJzAy4zVbFKq0JkZ1UTG+mIw0jcrEqPZN4EgNIitEpgskLLchj87nP4i" +
156      "UV3wBI0esc7kpf749iF01qTE3m7704fey7gjztwQTsfakejHXxB3q5Z5cSaJmmCSKnScYDd+rzQ7NHSfxWilZRBO4zpyRZrQVBvIeAVecrtFcO" +
157      "jOrPVEH4y2YZ8iTej9R4NViJQLRxzOiN2MsaDAqIS+1tKEVr25MQnYLJdUZj/GcxpjQYFHN3FDjU2kaHfwdHAbyLjl4Gn74zDMOYC6Acd0y7Ny" +
158      "urNKEbqkkpMpbmg+kf3FhzmAWJV4uiFzwBG60KXIqVbKxGsjtrd47l+lt0pPvpUbTqEL3eZDTa7JdJ23L/KhtkF80Sv334MqNKRLmdyA6alQvZ" +
159      "YN2CBCrQcFHt+UN398E1QFm/ioLi+cqtf6rvg3VBOLjfR2YGkWp6LODlShnZqrMNk5bDNnBjLD0+/1m6eSC71X1KT10YSmOHReJXAJoLAo+wZx" +
160      "+HecG+J+8PphOm5WFDWhCc2FSN7pOm+fQRz42bzQA1qejY+oSxShCc1NZHBo6Mx+B3FtZUOsLMiPQzFRPVQfRWid+quZTm1DzLZs4OEv8k8KsI" +
161      "CVGbEy1BUoQtc2BrsbPzZOlyJG+s2IpzOxs2JQhObRCLjA2fTO1uzfeok3+p94qA41NkGLoRlc6tNC290euWdzP9FvluaT0i79OsFCa0z3RZvQ" +
162      "I+3L2LC3tlmyeHxDTmmoG1hojYEFuqIue+Xi6OCi8k2XE1jtCPIFRWgqtQY60vKFfW15nw8Xa7MBqe2lOTl1zm5BEXrKYVA7442O7+zT4qNP9Q" +
163      "g9VBQfOYEi9Itec9OyJlBUHLYdtDQ25L/QD6/rUbuNFkNjTXVitubwWfu66T6fjsmA1eWUWFnU43YNmtAP/mlOBstUOm2G8qSSG75V5D24ps/N" +
164      "GjSh4f7bDMfSUonEwplf2fCjIm/otl59RNCEBp7fnRUpPvGQit0qDfT/Q13oAWHm7Ae9FjFUoYG+ywmxPG9WRZhpNNmU6kLzxclRNaGHjjdp0I" +
165      "UGHt2YEs8D1NJKNVX19gOYXvTJDz0GNIqb/4wUoQGYBnrvxwkji9JNwGkkhMxTDxi8jzF8XwbSG57rSteFKlEY8f4+D96cFouSugBlAya2RotD" +
166      "jkPeD5yMizIJExRgodIVaSs0Iw84UXKSGXh6awa91kP3UJKFJg7mGXHmaFbz/tUsNHGgR940Un7AhNZkLHQAGL7rPUww5S4jCx0QvJwZryykjL" +
167      "ltzkIHBMjqzYznl3B5+Iv+ocYmLHSAeH5nTuQ6cerpLX9voOQKCx0w+q+4X21nP6yJ+YS/N1ByhYUOGFA85mbcxfT7VTF0G38GuWxY6AACR3mQ" +
168      "7Zt69/lxHqS0ey8nxPDvZtbicOrbI36kvpns8ArNkIKFZkjBQjOkYKEZUrDQDCkCK/TaEs7hTnItkIdE2hJYoafHcC6Sri7xhWCdCKzQuraiZb" +
169      "wRWKFTCAurialh6gR6Uwg9RPLlY5OVNesTowuBFhoKdR79mt9NDArjiikSaKGB5bn1nJum6DzfJOgEtjhpK+rbSsTO5q2nT0Fd/PCdWTGjWS83" +
170      "5v9hoRlSBD7kYGjBQjOkYKEZUrDQDClYaIYULDRDChaaIQULzZCChWZIwUIzpGChGVKw0AwpWGiGFCw0QwoWmiEFC82QgoVmSMFCM6RgoRlSsN" +
171      "AMKVhohhQsNEMKFpohBQvNEEKI/wHB37T6AQz2eAAAAABJRU5ErkJggg==\n"
172  }
173  