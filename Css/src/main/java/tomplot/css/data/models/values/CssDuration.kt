package tomplot.css.data.models.values

class CssSecondDuration(
	val value: Double
) : CssValueDuration
{
	override fun toCss(): String =
		"${value}s"
}

class CssMillisecondDuration(
	val value: Double
) : CssValueDuration
{
	override fun toCss(): String =
		"${value}ms"
}
