package me.wietlol.tomplot.kotlin.writers

import me.wietlol.tomplot.api.writers.TomplotWriter
import me.wietlol.tomplot.kotlin.data.models.KtElement

class KotlinStringWriter(
	val options: KotlinWriterOptions,
) : TomplotWriter<KtElement, String>
{
	override fun write(component: KtElement, oldComponent: String?): String =
		KotlinStringBuilder(options, oldComponent)
			.append(component)
			.toString()
}
