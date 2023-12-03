package tomplot.css.writers

data class CssWriterOptions(
	val newLine: String = "\n",
	val indent: String = "\t",
	val prettyPrint: Boolean = false,
	val includeComments: Boolean = false,
)
