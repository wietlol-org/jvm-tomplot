package tomplot.css.data.models.values

data class CssRawValue(
	val css: String
) : CssValueGlobal
{
	override fun toCss(): String =
		css
}
