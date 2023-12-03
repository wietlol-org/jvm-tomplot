package tomplot.core.writers

import tomplot.api.writers.TomplotWriter

class NoOpWriter<T> : TomplotWriter<T, T>
{
	override fun write(component: T, oldComponent: T?): T =
		component
}
