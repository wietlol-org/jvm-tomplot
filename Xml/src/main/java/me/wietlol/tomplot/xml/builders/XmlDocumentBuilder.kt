package me.wietlol.tomplot.xml.builders

import me.wietlol.tomplot.xml.data.models.DefaultXmlComment
import me.wietlol.tomplot.xml.data.models.DefaultXmlDocument
import me.wietlol.tomplot.xml.data.models.DefaultXmlName
import me.wietlol.tomplot.xml.data.models.DefaultXmlProlog
import me.wietlol.tomplot.xml.data.models.XmlAttributeSet
import me.wietlol.tomplot.xml.data.models.XmlComment
import me.wietlol.tomplot.xml.data.models.XmlDocument
import me.wietlol.tomplot.xml.data.models.XmlHeader
import me.wietlol.tomplot.xml.data.models.XmlName
import me.wietlol.tomplot.xml.data.models.XmlNode
import me.wietlol.tomplot.xml.data.models.XmlProlog
import me.wietlol.tomplot.xml.data.models.XmlTextElement

class XmlDocumentBuilder(
	val rootBuilder: XmlNodeBuilder,
	var headers: MutableList<XmlHeader> = mutableListOf(),
) : XmlElementBuilder<XmlDocument>
{
	override fun build(): XmlDocument =
		DefaultXmlDocument(
			headers,
			rootBuilder.build(),
		)
}

fun XmlDocumentBuilder.prolog(name: String, attributes: XmlAttributeSet): XmlProlog =
	DefaultXmlProlog(name, attributes)
		.also(headers::add)

fun XmlDocumentBuilder.node(name: String, namespace: String? = null, body: XmlNodeBuilder.() -> Unit): XmlNode =
	node(DefaultXmlName(name, namespace), body)

fun XmlDocumentBuilder.node(name: XmlName, body: XmlNodeBuilder.() -> Unit): XmlNode =
	rootBuilder.node(name, body)

fun XmlDocumentBuilder.text(text: String): XmlTextElement =
	rootBuilder.text(text)

fun XmlDocumentBuilder.commentHeader(text: String): XmlComment =
	DefaultXmlComment(text)
		.also(headers::add)

fun XmlDocumentBuilder.comment(text: String): XmlComment =
	rootBuilder.comment(text)
