package tomplot.css.data.models.values

class CssHexColor(
	val code: String,
) : CssValueColor
{
	override fun toCss(): String =
		"#$code"
}

class CssRgbColor(
	val red: Int,
	val green: Int,
	val blue: Int,
) : CssValueColor
{
	override fun toCss(): String =
		"rgb($red, $green, $blue)"
}

class CssRgbaColor(
	val red: Int,
	val green: Int,
	val blue: Int,
	val alpha: Double,
) : CssValueColor
{
	override fun toCss(): String =
		"rgb($red, $green, $blue, $alpha)"
}

class CssHslColor(
	val hue: Int,
	val saturation: Int,
	val light: Int,
) : CssValueColor
{
	override fun toCss(): String =
		"hsl($hue, $saturation%, $light%)"
}

class CssHslaColor(
	val hue: Int,
	val saturation: Int,
	val light: Int,
	val alpha: Double,
) : CssValueColor
{
	override fun toCss(): String =
		"hsl($hue, $saturation%, $light%, $alpha)"
}
