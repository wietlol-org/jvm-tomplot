package me.wietlol.tomplot.xml.builders

import me.wietlol.tomplot.xml.data.XmlDocument
import me.wietlol.tomplot.xml.data.XmlHeader
import me.wietlol.tomplot.xml.data.XmlNode

class XmlDocumentBuilder(
	val rootBuilder: XmlNodeBuilder,
	var headers: MutableList<XmlHeader> = mutableListOf(),
) : XmlElementBuilder<XmlDocument>
{
	override fun build(): XmlDocument =
		XmlDocument(
			headers,
			rootBuilder.build(),
		)
}
