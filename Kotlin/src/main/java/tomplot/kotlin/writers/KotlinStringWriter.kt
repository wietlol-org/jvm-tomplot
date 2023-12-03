package tomplot.kotlin.writers

import tomplot.api.writers.TomplotWriter
import tomplot.kotlin.data.models.KtElement

class KotlinStringWriter(
	val options: KotlinWriterOptions,
) : TomplotWriter<KtElement, String>
{
	override fun write(component: KtElement, oldComponent: String?): String =
		KotlinStringBuilder(options, oldComponent)
			.append(component)
			.toString()
}
