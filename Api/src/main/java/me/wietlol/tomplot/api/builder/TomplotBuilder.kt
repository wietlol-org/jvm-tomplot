package me.wietlol.tomplot.api.builder

import me.wietlol.tomplot.api.data.TomplotElement

interface TomplotBuilder<out T : TomplotElement>
{
	fun build(): T
}
