package me.wietlol.tomplot.api.engine

import me.wietlol.tomplot.api.writers.TomplotWriter

interface TomplotEngine<in I, O>
{
	val writer: TomplotWriter<I, O>
}
