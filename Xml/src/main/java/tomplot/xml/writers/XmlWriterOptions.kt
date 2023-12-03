package tomplot.xml.writers

data class XmlWriterOptions(
	val newLine: String = "\n",
	val indent: String = "\t",
	val prettyPrint: Boolean = false,
)
