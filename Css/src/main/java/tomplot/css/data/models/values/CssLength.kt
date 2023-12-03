package tomplot.css.data.models.values

data class CssPixelValue(
	val pixels: Double
) : CssValueLength
{
	override fun toCss(): String =
		"${pixels}px"
}

data class CssCentimeterValue(
	val centimeters: Double
) : CssValueLength
{
	override fun toCss(): String =
		"${centimeters}cm"
}

data class CssMillimeterValue(
	val millimeters: Double
) : CssValueLength
{
	override fun toCss(): String =
		"${millimeters}mm"
}

data class CssInchValue(
	val inches: Double
) : CssValueLength
{
	override fun toCss(): String =
		"${inches}in"
}

data class CssPointValue(
	val points: Double
) : CssValueLength
{
	override fun toCss(): String =
		"${points}pt"
}

data class CssPicaValue(
	val picas: Double
) : CssValueLength
{
	override fun toCss(): String =
		"${picas}pc"
}

data class CssEmValue(
	val value: Double
) : CssValueLength
{
	override fun toCss(): String =
		"${value}em"
}

data class CssExValue(
	val value: Double
) : CssValueLength
{
	override fun toCss(): String =
		"${value}ex"
}

data class CssChValue(
	val value: Double
) : CssValueLength
{
	override fun toCss(): String =
		"${value}ch"
}

data class CssRootEmValue(
	val value: Double
) : CssValueLength
{
	override fun toCss(): String =
		"${value}rem"
}

data class CssViewWidthValue(
	val value: Double
) : CssValueLength
{
	override fun toCss(): String =
		"${value}vw"
}

data class CssViewHeightValue(
	val value: Double
) : CssValueLength
{
	override fun toCss(): String =
		"${value}vh"
}

data class CssViewMinValue(
	val value: Double
) : CssValueLength
{
	override fun toCss(): String =
		"${value}vmin"
}

data class CssViewMaxValue(
	val value: Double
) : CssValueLength
{
	override fun toCss(): String =
		"${value}vmax"
}

data class CssPercentageValue(
	val percentage: Double
) : CssValueLength
{
	override fun toCss(): String =
		"$percentage%"
}
