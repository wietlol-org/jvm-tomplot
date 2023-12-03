package tomplot.api.engine

import tomplot.api.writers.TomplotWriter

interface TomplotEngine<in I, O>
{
	val writer: TomplotWriter<I, O>
}
