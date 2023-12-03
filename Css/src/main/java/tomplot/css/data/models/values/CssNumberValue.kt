package tomplot.css.data.models.values

class CssNumberValue(
	val value: Double
) : CssValueNumber
{
	override fun toCss(): String =
		value.toString()
}
