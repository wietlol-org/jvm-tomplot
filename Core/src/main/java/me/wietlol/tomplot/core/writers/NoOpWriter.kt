package me.wietlol.tomplot.core.writers

import me.wietlol.tomplot.api.writers.TomplotWriter

class NoOpWriter<T> : TomplotWriter<T, T>
{
	override fun write(component: T, oldComponent: T?): T =
		component
}
