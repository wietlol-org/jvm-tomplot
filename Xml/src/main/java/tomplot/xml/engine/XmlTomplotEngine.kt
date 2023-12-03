package tomplot.xml.engine

import tomplot.api.engine.TomplotEngine
import tomplot.api.writers.TomplotWriter
import tomplot.xml.builders.XmlDocumentBuilder
import tomplot.xml.builders.XmlNodeBuilder
import tomplot.xml.data.models.XmlAttributeSet
import tomplot.xml.data.models.DefaultXmlName
import tomplot.xml.data.models.XmlDocument
import tomplot.xml.data.models.XmlName
import tomplot.xml.data.models.XmlNodeElement

class XmlTomplotEngine<O>(
	override val writer: TomplotWriter<XmlDocument, O>
) : TomplotEngine<XmlDocument, O>
{
	fun xmlDocument(
		name: String,
		namespace: String? = null,
		attributes: XmlAttributeSet = XmlAttributeSet(),
		children: MutableList<XmlNodeElement> = mutableListOf(),
		body: XmlDocumentBuilder.() -> Unit
	): XmlDocument =
		xmlDocument(DefaultXmlName(name, namespace), attributes, children, body)
	
	fun xmlDocument(
		name: XmlName,
		attributes: XmlAttributeSet = XmlAttributeSet(),
		children: MutableList<XmlNodeElement> = mutableListOf(),
		body: XmlDocumentBuilder.() -> Unit
	): XmlDocument =
		XmlDocumentBuilder(XmlNodeBuilder(name, attributes, children))
			.apply(body)
			.build()
			.also(writer::write)
}
