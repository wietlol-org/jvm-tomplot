package tomplot.core.writers

import tomplot.api.writers.TomplotWriter
import java.io.File

class FileWriter<I>(
	val innerWriter: TomplotWriter<I, String>,
	val fileExtractor: (I) -> File,
) : TomplotWriter<I, String>
{
	override fun write(component: I, oldComponent: String?): String
	{
		val file: File = fileExtractor(component)
		val oldContent: String? = file
			.takeIf { it.exists() }
			?.readText()
		val content: String = innerWriter.write(component, oldContent)
		file.writeText(content)
		return content
	}
}
