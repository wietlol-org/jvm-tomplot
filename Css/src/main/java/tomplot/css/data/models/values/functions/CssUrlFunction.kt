package tomplot.css.data.models.values.functions

import tomplot.css.data.models.values.CssPropertyBackgroundImage
import tomplot.css.data.models.values.CssStringValue

class CssUrlFunction(
	val url: String
) : CssPropertyBackgroundImage
{
	override fun toCss(): String =
		"url(${CssStringValue.encodeCssString(url)})"
}
