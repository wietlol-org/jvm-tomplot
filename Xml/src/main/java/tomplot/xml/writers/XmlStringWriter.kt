package tomplot.xml.writers

import tomplot.api.writers.TomplotWriter
import tomplot.xml.data.models.XmlDocument

class XmlStringWriter(
	val options: XmlWriterOptions,
) : TomplotWriter<XmlDocument, String>
{
	companion object
	{
		fun ofOptions(
			newLine: String = "\n",
			indent: String = "\t",
			prettyPrint: Boolean = false,
		) = XmlStringWriter(XmlWriterOptions(newLine, indent, prettyPrint))
	}
	
	override fun write(component: XmlDocument, oldComponent: String?): String =
		XmlStringBuilder(options)
			.apply { append(component) }
			.toString()
}
