package tomplot.core.writers

import tomplot.api.writers.TomplotWriter

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
