package tomplot.xml.builders

import tomplot.xml.data.models.XmlAttributeSet
import tomplot.xml.data.models.DefaultXmlComment
import tomplot.xml.data.models.DefaultXmlName
import tomplot.xml.data.models.DefaultXmlNode
import tomplot.xml.data.models.DefaultXmlTextElement
import tomplot.xml.data.models.XmlComment
import tomplot.xml.data.models.XmlName
import tomplot.xml.data.models.XmlNode
import tomplot.xml.data.models.XmlNodeElement
import tomplot.xml.data.models.XmlTextElement

class XmlNodeBuilder(
	var name: XmlName,
	var attributes: XmlAttributeSet,
	var children: MutableList<XmlNodeElement>,
) : XmlElementBuilder<XmlNode>
{
	override fun build(): XmlNode =
		DefaultXmlNode(
			name,
			attributes,
			children
		)
}

fun XmlNodeBuilder.node(name: String, namespace: String? = null, body: XmlNodeBuilder.() -> Unit): XmlNode =
	node(DefaultXmlName(name, namespace), body)

fun XmlNodeBuilder.node(name: XmlName, body: XmlNodeBuilder.() -> Unit): XmlNode =
	XmlNodeBuilder(name, XmlAttributeSet(), mutableListOf())
		.apply(body)
		.build()
		.also(children::add)

fun XmlNodeBuilder.text(text: String): XmlTextElement =
	DefaultXmlTextElement(text)
		.also(children::add)

fun XmlNodeBuilder.comment(text: String): XmlComment =
	DefaultXmlComment(text)
		.also(children::add)
