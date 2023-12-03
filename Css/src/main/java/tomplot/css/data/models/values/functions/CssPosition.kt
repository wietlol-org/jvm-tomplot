package tomplot.css.data.models.values.functions

import tomplot.css.data.models.values.CssPropertyBackgroundPosition
import tomplot.css.data.models.values.CssPropertyBackgroundPositionX
import tomplot.css.data.models.values.CssPropertyBackgroundPositionY

class CssPosition(
	val horizontal: CssPropertyBackgroundPositionX,
	val vertical: CssPropertyBackgroundPositionY,
) : CssPropertyBackgroundPosition
{
	override fun toCss(): String =
		"${horizontal.toCss()} ${vertical.toCss()}"
}
