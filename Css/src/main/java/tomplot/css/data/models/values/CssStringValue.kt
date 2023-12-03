package tomplot.css.data.models.values

class CssStringValue(
	val value: String
) : CssValueString
{
	override fun toCss(): String =
		encodeCssString(value)
	
	companion object
	{
		fun encodeCssString(raw: String): String =
			"\"$raw\"" // todo escaping and such
	}
}
