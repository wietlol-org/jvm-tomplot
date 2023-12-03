package tomplot.kotlin.data.models

class KtValueProvider(val func: () -> String)
{
	operator fun invoke(): String = func()
	
	fun toJsonString(): String = "{}"
	
	fun duplicate() = KtValueProvider(func)
}
