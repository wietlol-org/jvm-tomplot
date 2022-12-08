package me.wietlol.tomplot.xml.engine

import me.wietlol.tomplot.api.engine.TomplotEngine
import me.wietlol.tomplot.api.writers.TomplotWriter
import me.wietlol.tomplot.xml.builders.XmlDocumentBuilder
import me.wietlol.tomplot.xml.builders.XmlNodeBuilder
import me.wietlol.tomplot.xml.data.models.XmlAttributeSet
import me.wietlol.tomplot.xml.data.models.DefaultXmlName
import me.wietlol.tomplot.xml.data.models.XmlDocument
import me.wietlol.tomplot.xml.data.models.XmlName
import me.wietlol.tomplot.xml.data.models.XmlNodeElement

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
