package tomplot.css.data.models.values

class CssDegreeValue(
	val value: Double
) : CssValueAngle
{
	override fun toCss(): String =
		"${value}deg"
}

class CssRadianValue(
	val value: Double
) : CssValueAngle
{
	override fun toCss(): String =
		"${value}rad"
}

class CssTurnValue(
	val value: Double
) : CssValueAngle
{
	override fun toCss(): String =
		"${value}turn"
}
