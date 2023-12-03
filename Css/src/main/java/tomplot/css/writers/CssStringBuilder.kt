package tomplot.css.writers

import tomplot.core.writers.TomplotStringBuilder
import tomplot.css.data.models.CssElement
import tomplot.css.data.models.CssStyle
import tomplot.css.data.models.CssStyleSheet
import tomplot.css.data.models.values.CssValue

class CssStringBuilder(
	options: CssWriterOptions = CssWriterOptions(),
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
			CssStringBuilder(
				CssWriterOptions(
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
	
	fun append(element: CssElement)
	{
		when (element)
		{
			is CssStyleSheet -> append(element)
			is CssStyle -> append(element)
			is CssValue -> append(element)
		}
	}
	
	fun append(element: CssStyleSheet)
	{
		builder.appendJoin(element.styles.entries) {
			builder.append(it.key)
			builder.appendLine(" {")
			builder.indented {
				append(it.value)
			}
			builder.appendLine("}")
		}
	}
	
	fun append(element: CssStyle)
	{
		builder.appendJoin(element.properties.entries) {
			builder.append(it.key)
			builder.append(": ")
			append(it.value)
			builder.append(";")
		}
	}
	
	fun append(element: CssValue)
	{
		builder.append(element.toCss())
	}
}
