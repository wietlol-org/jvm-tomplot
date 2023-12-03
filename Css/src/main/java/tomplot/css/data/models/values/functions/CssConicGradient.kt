package tomplot.css.data.models.values.functions

import tomplot.css.data.models.values.CssPropertyBackgroundImage
import tomplot.css.data.models.values.CssValue
import tomplot.css.data.models.values.CssValueAngle
import tomplot.css.data.models.values.CssValueColor

interface CssConicGradientColor : CssValue

class CssConicGradientColorValue(
	val color: CssValueColor,
	val angle: CssValueAngle,
) : CssConicGradientColor
{
	override fun toCss(): String =
		"${color.toCss()} ${angle.toCss()}"
}

class CssConicGradient(
	val from: CssValueAngle?,
	val to: CssPosition?,
	val colors: List<CssConicGradientColor>,
) : CssPropertyBackgroundImage
{
	override fun toCss(): String =
		"conic-gradient(${toCssPrefix()}${colors.joinToString { it.toCss() }})"
	
	private fun toCssPrefix(): String
	{
		if (from != null && to != null)
			return "from ${from.toCss()} at ${to.toCss()}, "
		if (from != null)
			return "from ${from.toCss()}, "
		if (to != null)
			return "at ${to.toCss()}, "
		return ""
	}
}
