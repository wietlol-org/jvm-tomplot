package me.wietlol.tomplot.xml.writers

import me.wietlol.tomplot.api.writers.TomplotWriter
import me.wietlol.tomplot.xml.data.XmlDocument

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
