package tomplot.css.data.models.values.functions

import tomplot.css.data.models.values.CssPropertyAnimationTimingFunction

class CssCubicBezierFunction(
	val x1: Double,
	val y1: Double,
	val x2: Double,
	val y2: Double,
) : CssPropertyAnimationTimingFunction
{
	override fun toCss(): String =
		"cubic-bezier($x1, $y1, $x2, $y2)"
}
