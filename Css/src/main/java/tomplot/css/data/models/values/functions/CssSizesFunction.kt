package tomplot.css.data.models.values.functions

import tomplot.css.data.models.values.CssPropertyBackgroundSize
import tomplot.css.data.models.values.CssValueLength

class CssSizeFunction(
	val horizontal: CssValueLength,
	val vertical: CssValueLength,
) : CssPropertyBackgroundSize
{
	override fun toCss(): String =
		"${horizontal.toCss()} ${vertical.toCss()}"
}

class CssSizesFunction(
	val sizes: List<CssPropertyBackgroundSize>,
) : CssPropertyBackgroundSize
{
	override fun toCss(): String =
		sizes.joinToString { it.toCss() }
}
