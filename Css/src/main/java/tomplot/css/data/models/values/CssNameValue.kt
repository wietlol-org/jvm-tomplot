package tomplot.css.data.models.values

class CssNameValue(
	val value: String
) : CssValueName
{
	override fun toCss(): String =
		value
}
