package me.wietlol.tomplot.core.writers

import me.wietlol.tomplot.api.writers.TomplotWriter

class GenericWriter<in I, O>(
	val innerWriter: TomplotWriter<I, O>,
	val write: (O) -> Unit,
) : TomplotWriter<I, O>
{
	override fun write(component: I, oldComponent: O?): O
	{
		val content: O = innerWriter.write(component, oldComponent)
		write(content)
		return content
	}
}
