package tomplot.api.builder

import tomplot.api.data.TomplotElement

interface TomplotBuilder<out T : TomplotElement>
{
	fun build(): T
}
