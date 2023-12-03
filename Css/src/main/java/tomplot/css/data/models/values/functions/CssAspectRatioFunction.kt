package tomplot.css.data.models.values.functions

import tomplot.css.data.models.values.CssPropertyAspectRatio
import utils.common.prepend

class CssAspectRatioFunction(
	val width: Int,
	val height: Int?
) : CssPropertyAspectRatio
{
	override fun toCss(): String =
		"$width${height?.toString()?.prepend("/")}"
}
