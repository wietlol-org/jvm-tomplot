package tomplot.html.writers

import tomplot.core.writers.TomplotStringBuilder
import tomplot.html.data.models.*

class HtmlStringBuilder(
	options: HtmlWriterOptions = HtmlWriterOptions(),
)
{
	companion object
	{
		fun ofOptions(
			newLine: String = "\n",
			indent: String = "\t",
			prettyPrint: Boolean = false,
			includeComments: Boolean = false,
		) =
			HtmlStringBuilder(
				HtmlWriterOptions(
					newLine,
					indent,
					prettyPrint,
					includeComments
				)
			)
	}
	
	private val builder = TomplotStringBuilder.ofOptions(
		if (options.prettyPrint) options.newLine else "",
		if (options.prettyPrint) options.indent else "",
	)
	
	private val includeComments = options.includeComments
	
	override fun toString(): String =
		builder.toString()
	
	fun append(element: HtmlElement)
	{
		when (element)
		{
			is HtmlDocument<*> -> append(element)
			is HtmlComment -> append(element)
			is HtmlNode<*> -> append(element)
			is HtmlTextElement -> append(element)
		}
	}
	
	private fun append(element: HtmlDocument<*>)
	{
		builder.appendLine("<!DOCTYPE html>")
		append(element.rootNode)
	}
	
	private fun append(element: HtmlComment)
	{
		if (element.text.isEmpty())
		{
			builder.append("<!-- -->")
		}
		else
		{
			val lines = element.text.lines()
			
			builder.append("<!--")
			
			if (lines.size == 1)
			{
				builder.append(" ")
				builder.append(escapeComment(lines[0]))
				builder.append(" ")
			}
			else
			{
				builder.appendLine()
				builder.indented {
					builder.appendJoin(lines) {
						builder.append(escapeComment(it))
					}
				}
				builder.appendLine()
			}
			
			builder.append("-->")
		}
	}
	
	private fun append(element: HtmlNode<*>)
	{
		val children = if (includeComments) element.children
		else element.children.filter { it !is HtmlComment }
		
		if (children.isEmpty())
		{
			builder.append("<")
			append(element.name)
			append(element.attributes)
			builder.append("/>")
		}
		else
		{
			builder.append("<")
			append(element.name)
			append(element.attributes)
			builder.append(">")
			
			val onlyChild = children.singleOrNull()
			if (onlyChild is HtmlTextElement && !onlyChild.text.contains("\n"))
			{
				append(children[0])
			}
			else
			{
				builder.appendLine()
				builder.indented {
					builder.appendJoin(children) {
						append(it)
					}
				}
				builder.appendLine()
			}
			
			builder.append("</")
			append(element.name)
			builder.append(">")
		}
	}
	
	private fun append(element: HtmlTextElement)
	{
		builder.appendJoin(element.text.lines()) {
			builder.append(escapeText(it))
		}
	}
	
	private fun append(name: HtmlName)
	{
		if (name.namespace != null)
		{
			builder.append(escapeName(name.namespace))
			builder.append(":")
		}
		builder.append(escapeName(name.name))
	}
	
	private fun append(attributes: HtmlAttributeSet)
	{
		attributes.map.forEach {
			builder.append(" ")
			append(it.key)
			builder.append("=\"")
			builder.append(escapeAttribute(it.value))
			builder.append("\"")
		}
	}
	
	private fun escapeComment(text: String): String =
		text.replace(
			"-->",
			"--|>"
		)
	
	private fun escapeText(text: String): String =
		text.replace(Regex("[&<\\x80-\\uffff]")) {
			when (it.value)
			{
				"&" -> "&amp;"
				"<" -> "&lt;"
				else -> "&#${it.value[0].code};"
			}
		}
	
	private fun escapeAttribute(text: String): String =
		text.replace(Regex("[&\"\\x80-\\uffff]")) {
			when (it.value)
			{
				"&" -> "&amp;"
				"\"" -> "&quot;"
				else -> "&#${it.value[0].code};"
			}
		}
	
	private fun escapeName(name: String): String =
		name.replace(Regex("[^a-zA-Z0-9._-]")) {
			"_${toHex(it.value)}_"
		}
	
	private fun toHex(text: String): String =
		text.toCharArray().joinToString("") {
			val hex = it.code.toString(16)
			if ((hex.length and 1) == 1) "0$hex"
			else hex
		}
}
