package tomplot.html.writers

data class HtmlWriterOptions(
	val newLine: String = "\n",
	val indent: String = "\t",
	val prettyPrint: Boolean = false,
	val includeComments: Boolean = false,
)
