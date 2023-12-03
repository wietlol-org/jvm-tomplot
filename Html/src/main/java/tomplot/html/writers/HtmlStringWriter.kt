package tomplot.html.writers

import tomplot.api.writers.TomplotWriter
import tomplot.html.data.models.HtmlElement

class HtmlStringWriter(
	val options: HtmlWriterOptions = HtmlWriterOptions(),
) : TomplotWriter<HtmlElement, String>
{
	companion object
	{
		fun ofOptions(
			newLine: String = "\n",
			indent: String = "\t",
			prettyPrint: Boolean = false,
			includeComments: Boolean = false,
		) = HtmlStringWriter(HtmlWriterOptions(newLine, indent, prettyPrint, includeComments))
	}
	
	override fun write(component: HtmlElement, oldComponent: String?): String =
		HtmlStringBuilder(options)
			.apply { append(component) }
			.toString()
}
