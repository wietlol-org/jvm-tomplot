package me.wietlol.tomplot.xml.writers

import me.wietlol.tomplot.core.writers.TomplotStringBuilder
import me.wietlol.tomplot.xml.data.XmlComment
import me.wietlol.tomplot.xml.data.XmlDocument
import me.wietlol.tomplot.xml.data.XmlElement
import me.wietlol.tomplot.xml.data.XmlName
import me.wietlol.tomplot.xml.data.XmlNode
import me.wietlol.tomplot.xml.data.XmlProlog
import me.wietlol.tomplot.xml.data.XmlTextElement

class XmlStringBuilder(
	options: XmlWriterOptions,
)
{
	companion object
	{
		fun ofOptions(
			newLine: String = "\n",
			indent: String = "\t",
			prettyPrint: Boolean = false,
		) = XmlStringBuilder(XmlWriterOptions(newLine, indent, prettyPrint))
	}
	
	val prettyPrint = options.prettyPrint
	val builder = TomplotStringBuilder.ofOptions(options.newLine, options.indent)
	
	fun append(element: XmlElement) =
		when (element)
		{
			is XmlDocument -> append(element)
			is XmlProlog -> append(element)
			is XmlNode -> append(element)
			is XmlTextElement -> append(element)
			is XmlComment -> append(element)
			else -> unsupportedType("XmlElement", element.javaClass.name)
		}
	
	fun append(document: XmlDocument): XmlStringBuilder
	{
		document.headers.forEach {
			append(it)
			
			if (prettyPrint)
				builder.appendLine()
		}
		append(document.root)
		return this
	}
	
	fun append(prolog: XmlProlog): XmlStringBuilder
	{
		with(builder) {
			append("<?")
			append(prolog.name)
			
			prolog.attributes.forEach {
				append(" ")
				append(it)
			}
			append("?>")
		}
		return this
	}
	
	fun append(node: XmlNode): XmlStringBuilder
	{
		with(builder) {
			append("<")
			append(node.name)
			
			node.attributes.forEach {
				append(" ")
				append(it)
			}
			
			if (node.children.isEmpty())
			{
				append("/>")
			}
			else
			{
				append(">")
				
				if (prettyPrint && node.children.any { it !is XmlTextElement })
				{
					appendLine()
					indented {
						node.children.forEach {
							append(it)
							appendLine()
						}
					}
				}
				else
					node.children.forEach { append(it) }
				
				append("</")
				append(node.name)
				append(">")
			}
		}
		return this
	}
	
	fun append(attribute: Pair<XmlName, String>): XmlStringBuilder
	{
		with(builder) {
			append(attribute.first)
			append("=\"")
			append(encodeXmlAttributeValue(attribute.second))
			append("\"")
		}
		return this
	}
	
	fun append(textNode: XmlTextElement): XmlStringBuilder
	{
		with(builder) {
			append(encodeXmlText(textNode.text))
		}
		return this
	}
	
	fun append(comment: XmlComment): XmlStringBuilder
	{
		with(builder) {
			append("<!--")
			append(encodeXmlComment(comment.text))
			append("-->")
		}
		return this
	}
	
	fun append(name: XmlName): XmlStringBuilder
	{
		with(builder) {
			name.namespace?.also {
				append(it)
				append(":")
			}
			append(name.name)
		}
		return this
	}
	
	override fun toString(): String =
		builder.toString()
	
	private fun encodeXmlAttributeValue(text: String): String =
		text
			.replace("&", "&amp;")
			.replace("\"", "&quot;")
			.replace(Regex("[\u0080-\uffff]")) { "&#${it.value.first().code};" }
	
	private fun encodeXmlText(text: String): String =
		text
			.replace("&", "&amp;")
			.replace("<", "&lt;")
			.replace(">", "&gt;")
			.replace(Regex("[\u0080-\uffff]")) { "&#${it.value.first().code};" }
	
	private fun encodeXmlComment(text: String): String =
		text
			.replace("--", "&ndash;")
			.replace(Regex("[\u0080-\uffff]")) { "&#${it.value.first().code};" }
	
	private fun unsupportedType(type: String, value: String): Nothing =
		throw UnsupportedOperationException("Unsupported $type '$value'.")
}
