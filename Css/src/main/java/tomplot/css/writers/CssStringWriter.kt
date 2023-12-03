package tomplot.css.writers

import tomplot.api.writers.TomplotWriter
import tomplot.css.data.models.CssElement

class CssStringWriter(
	val options: CssWriterOptions = CssWriterOptions(),
) : TomplotWriter<CssElement, String>
{
	companion object
	{
		fun ofOptions(
			newLine: String = "\n",
			indent: String = "\t",
			prettyPrint: Boolean = false,
			includeComments: Boolean = false,
		) =
			CssStringWriter(
				CssWriterOptions(
					newLine,
					indent,
					prettyPrint,
					includeComments
				)
			)
	}
	
	override fun write(component: CssElement, oldComponent: String?): String =
		CssStringBuilder(options).apply { append(component) }.toString()
}
