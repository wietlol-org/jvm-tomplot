package me.wietlol.tomplot.core.writers

import me.wietlol.tomplot.api.writers.TomplotWriter

class ConsoleWriter<in I, O : CharSequence>(
	val innerWriter: TomplotWriter<I, O>,
) : TomplotWriter<I, O>
{
	override fun write(component: I, oldComponent: O?): O
	{
		val content: O = innerWriter.write(component, oldComponent)
		println(content.toString())
		return content
	}
}
