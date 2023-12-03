package tomplot.css.data.models.values

import utils.common.prepend

interface CssStepsPoint : CssValue

class CssStepsValue(
	val intervals: Int,
	val point: CssStepsPoint? = null,
) : CssPropertyAnimationTimingFunction
{
	override fun toCss(): String =
		"steps($intervals${point?.toCss()?.prepend(", ")})"
}
