package tomplot.api.writers

interface TomplotWriter<in I, O>
{
	fun write(component: I, oldComponent: O? = null): O
}
