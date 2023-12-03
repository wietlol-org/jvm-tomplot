package tomplot.css.builders

import tomplot.css.data.models.values.*
import tomplot.css.data.models.values.functions.*

interface CssValueBuilder
{
	// general keywords
	val auto get() = CssKeywordAuto
	val inherit get() = CssKeywordInherit
	val initial get() = CssKeywordInitial
	val revert get() = CssKeywordRevert
	val unset get() = CssKeywordUnset
	
	// special keywords
	val above get() = CssKeywordAbove
	val allKeyword get() = CssKeywordAll
	val alternate get() = CssKeywordAlternate
	val alternateReverse get() = CssKeywordAlternateReverse
	val always get() = CssKeywordAlways
	val avoid get() = CssKeywordAvoid
	val avoidColumn get() = CssKeywordAvoidColumn
	val avoidPage get() = CssKeywordAvoidPage
	val avoidRegion get() = CssKeywordAvoidRegion
	val backwards get() = CssKeywordBackwards
	val baseline get() = CssKeywordBaseline
	val below get() = CssKeywordBelow
	val borderBox get() = CssKeywordBorderBox
	val both get() = CssKeywordBoth
	val bottom get() = CssKeywordBottom
	val center get() = CssKeywordCenter
	val clone get() = CssKeywordClone
	val colorBm get() = CssKeywordColor
	val colorDodge get() = CssKeywordColorDodge
	val column get() = CssKeywordColumn
	val contain get() = CssKeywordContain
	val contentBox get() = CssKeywordContentBox
	val cover get() = CssKeywordCover
	val currentColor get() = CssKeywordCurrentColor
	val darken get() = CssKeywordDarken
	val ease get() = CssKeywordEase
	val easeIn get() = CssKeywordEaseIn
	val easeInOut get() = CssKeywordEaseInOut
	val easeOut get() = CssKeywordEaseOut
	val end get() = CssKeywordEnd
	val fixed get() = CssKeywordFixed
	val flexEnd get() = CssKeywordFlexEnd
	val flexStart get() = CssKeywordFlexStart
	val forwards get() = CssKeywordForwards
	val hidden get() = CssKeywordHidden
	val infinite get() = CssKeywordInfinite
	val inset get() = CssKeywordInset
	val large get() = CssKeywordLarge
	val larger get() = CssKeywordLarger
	val left get() = CssKeywordLeft
	val lighten get() = CssKeywordLighten
	val linear get() = CssKeywordLinear
	val local get() = CssKeywordLocal
	val luminosity get() = CssKeywordLuminosity
	val medium get() = CssKeywordMedium
	val multiply get() = CssKeywordMultiply
	val noRepeat get() = CssKeywordNoRepeat
	val none get() = CssKeywordNone
	val normal get() = CssKeywordNormal
	val overlay get() = CssKeywordOverlay
	val paddingBox get() = CssKeywordPaddingBox
	val page get() = CssKeywordPage
	val paused get() = CssKeywordPaused
	val recto get() = CssKeywordRecto
	val region get() = CssKeywordRegion
	val repeat get() = CssKeywordRepeat
	val repeatX get() = CssKeywordRepeatX
	val repeatY get() = CssKeywordRepeatY
	val reverse get() = CssKeywordReverse
	val right get() = CssKeywordRight
	val round get() = CssKeywordRound
	val running get() = CssKeywordRunning
	val saturation get() = CssKeywordSaturation
	val screen get() = CssKeywordScreen
	val scroll get() = CssKeywordScroll
	val selfEnd get() = CssKeywordSelfEnd
	val selfStart get() = CssKeywordSelfStart
	val slice get() = CssKeywordSlice
	val small get() = CssKeywordSmall
	val smaller get() = CssKeywordSmaller
	val space get() = CssKeywordSpace
	val spaceAround get() = CssKeywordSpaceAround
	val spaceBetween get() = CssKeywordSpaceBetween
	val spaceEvenly get() = CssKeywordSpaceEvenly
	val start get() = CssKeywordStart
	val stepEnd get() = CssKeywordStepEnd
	val stepStart get() = CssKeywordStepStart
	val stretch get() = CssKeywordStretch
	val top get() = CssKeywordTop
	val transparent get() = CssKeywordTransparent
	val verso get() = CssKeywordVerso
	val visible get() = CssKeywordVisible
	val xLarge get() = CssKeywordXLarge
	val xSmall get() = CssKeywordXSmall
	val xXLarge get() = CssKeywordXXLarge
	val xxSmall get() = CssKeywordXxSmall
	
	// literals
	val String.name: CssValueName get() = CssNameValue(this)
	val String.l: CssValueString get() = CssStringValue(this)
	val Int.l: CssValueNumber get() = CssNumberValue(toDouble())
	
	// durations
	val Int.s: CssValueDuration get() = CssSecondDuration(toDouble())
	val Double.s: CssValueDuration get() = CssSecondDuration(this)
	val Int.ms: CssValueDuration get() = CssMillisecondDuration(toDouble())
	val Double.ms: CssValueDuration get() = CssMillisecondDuration(this)
	
	// lengths
	val Int.cm: CssValueLength get() = CssCentimeterValue(toDouble())
	val Double.cm: CssValueLength get() = CssCentimeterValue(this)
	val Int.mm: CssValueLength get() = CssMillimeterValue(toDouble())
	val Double.mm: CssValueLength get() = CssMillimeterValue(this)
	val Int.inc: CssValueLength get() = CssInchValue(toDouble())
	val Double.inc: CssValueLength get() = CssInchValue(this)
	val Int.px: CssValueLength get() = CssPixelValue(toDouble())
	val Double.px: CssValueLength get() = CssPixelValue(this)
	val Int.pt: CssValueLength get() = CssPointValue(toDouble())
	val Double.pt: CssValueLength get() = CssPointValue(this)
	val Int.pc: CssValueLength get() = CssPicaValue(toDouble())
	val Double.pc: CssValueLength get() = CssPicaValue(this)
	val Int.em: CssValueLength get() = CssEmValue(toDouble())
	val Double.em: CssValueLength get() = CssEmValue(this)
	val Int.ex: CssValueLength get() = CssExValue(toDouble())
	val Double.ex: CssValueLength get() = CssExValue(this)
	val Int.ch: CssValueLength get() = CssChValue(toDouble())
	val Double.ch: CssValueLength get() = CssChValue(this)
	val Int.rem: CssValueLength get() = CssRootEmValue(toDouble())
	val Double.rem: CssValueLength get() = CssRootEmValue(this)
	val Int.vw: CssValueLength get() = CssViewWidthValue(toDouble())
	val Double.vw: CssValueLength get() = CssViewWidthValue(this)
	val Int.vh: CssValueLength get() = CssViewHeightValue(toDouble())
	val Double.vh: CssValueLength get() = CssViewHeightValue(this)
	val Int.vmin: CssValueLength get() = CssViewMinValue(toDouble())
	val Double.vmin: CssValueLength get() = CssViewMinValue(this)
	val Int.vmax: CssValueLength get() = CssViewMaxValue(toDouble())
	val Double.vmax: CssValueLength get() = CssViewMaxValue(this)
	val Int.pct: CssValueLength get() = CssPercentageValue(toDouble())
	val Double.pct: CssValueLength get() = CssPercentageValue(this)
	
	// angles
	val Int.deg: CssValueAngle get() = CssDegreeValue(toDouble())
	val Double.deg: CssValueAngle get() = CssDegreeValue(this)
	val Int.rad: CssValueAngle get() = CssRadianValue(toDouble())
	val Double.rad: CssValueAngle get() = CssRadianValue(this)
	val Int.turn: CssValueAngle get() = CssTurnValue(toDouble())
	val Double.turn: CssValueAngle get() = CssTurnValue(this)
	
	fun rawValue(value: String) =
		CssRawValue(value)
	
	// color functions
	fun hex(hex: String) =
		CssHexColor(hex)
	
	fun rgb(red: Int, green: Int, blue: Int) =
		CssRgbColor(
			red,
			green,
			blue
		)
	
	fun rgba(red: Int, green: Int, blue: Int, alpha: Double) =
		CssRgbaColor(
			red,
			green,
			blue,
			alpha
		)
	
	fun hsl(hue: Int, saturation: Int, light: Int) =
		CssHslColor(
			hue,
			saturation,
			light
		)
	
	fun hsla(hue: Int, saturation: Int, light: Int, alpha: Double) =
		CssHslaColor(
			hue,
			saturation,
			light,
			alpha
		)
	
	// css functions
	fun animation(
		name: CssPropertyAnimationName? = null,
		duration: CssPropertyAnimationDuration? = null,
		timingFunction: CssPropertyAnimationTimingFunction? = null,
		delay: CssPropertyAnimationDelay? = null,
		iterationCount: CssPropertyAnimationIterationCount? = null,
		direction: CssPropertyAnimationDirection? = null,
		fillMode: CssPropertyAnimationFillMode? = null,
		playState: CssPropertyAnimationPlayState? = null,
	) =
		CssAnimationFunction(
			name,
			duration,
			timingFunction,
			delay,
			iterationCount,
			direction,
			fillMode,
			playState
		)
	
	fun animation(
		name: String? = null,
		duration: CssPropertyAnimationDuration? = null,
		timingFunction: CssPropertyAnimationTimingFunction? = null,
		delay: CssPropertyAnimationDelay? = null,
		iterationCount: CssPropertyAnimationIterationCount? = null,
		direction: CssPropertyAnimationDirection? = null,
		fillMode: CssPropertyAnimationFillMode? = null,
		playState: CssPropertyAnimationPlayState? = null,
	) =
		CssAnimationFunction(
			name?.name,
			duration,
			timingFunction,
			delay,
			iterationCount,
			direction,
			fillMode,
			playState
		)
	
	fun steps(intervals: Int, point: CssStepsPoint? = null) =
		CssStepsValue(
			intervals,
			point
		)
	
	fun cubicBezier(x1: Double, y1: Double, x2: Double, y2: Double) =
		CssCubicBezierFunction(
			x1,
			y1,
			x2,
			y2
		)
	
	fun ratio(width: Int, height: Int? = null) =
		CssAspectRatioFunction(
			width,
			height
		)
	
	fun position(horizontal: CssPropertyBackgroundPositionX, vertical: CssPropertyBackgroundPositionY) =
		CssPosition(
			horizontal,
			vertical,
		)
	
	fun size(horizontal: CssValueLength, vertical: CssValueLength) =
		CssSizeFunction(
			horizontal,
			vertical,
		)
	
	fun size(vararg sizes: CssPropertyBackgroundSize) =
		size(sizes.toList())
	
	fun size(sizes: List<CssPropertyBackgroundSize>) =
		CssSizesFunction(sizes.toList())
	
	fun images(vararg images: CssPropertyBackgroundImage) =
		images(images.toList())
	
	fun images(images: List<CssPropertyBackgroundImage>) =
		CssImagesFunction(images.toList())
	
	fun url(url: String) =
		CssUrlFunction(url)
	
	infix fun CssValueColor.at(angle: CssValueAngle) =
		CssConicGradientColorValue(this, angle)
	
	fun conicGradient(vararg colors: CssConicGradientColor): CssPropertyBackgroundImage =
		conicGradient(colors.toList())
	
	fun conicGradient(from: CssValueAngle?, vararg colors: CssConicGradientColor): CssPropertyBackgroundImage =
		conicGradient(from, colors.toList())
	
	fun conicGradient(at: CssPosition?, vararg colors: CssConicGradientColor): CssPropertyBackgroundImage =
		conicGradient(at, colors.toList())
	
	fun conicGradient(from: CssValueAngle?, at: CssPosition?, vararg colors: CssConicGradientColor): CssPropertyBackgroundImage =
		conicGradient(from, at, colors.toList())
	
	fun conicGradient(colors: List<CssConicGradientColor>): CssPropertyBackgroundImage =
		conicGradient(null, null, colors)
	
	fun conicGradient(from: CssValueAngle?, colors: List<CssConicGradientColor>): CssPropertyBackgroundImage =
		conicGradient(from, null, colors)
	
	fun conicGradient(at: CssPosition?, colors: List<CssConicGradientColor>): CssPropertyBackgroundImage =
		conicGradient(null, at, colors)
	
	fun conicGradient(from: CssValueAngle?, at: CssPosition?, colors: List<CssConicGradientColor>): CssPropertyBackgroundImage =
		CssConicGradient(from, at, colors)
	
//	fun linearGradient(): CssPropertyBackgroundImage =
//		TODO()
//
//	fun radialGradient(): CssPropertyBackgroundImage =
//		TODO()
//
//	fun repeatingConicGradient(): CssPropertyBackgroundImage =
//		TODO()
//
//	fun repeatingLinearGradient(): CssPropertyBackgroundImage =
//		TODO()
//
//	fun repeatingRadialGradient(): CssPropertyBackgroundImage =
//		TODO()
	
	// color names
	val aliceBlue get() = hex("f0f8ff")
	val antiqueWhite get() = hex("faebd7")
	val aqua get() = hex("00ffff")
	val aquamarine get() = hex("7fffd4")
	val azure get() = hex("f0ffff")
	val beige get() = hex("f5f5dc")
	val bisque get() = hex("ffe4c4")
	val black get() = hex("000000")
	val blanchedAlmond get() = hex("ffebcd")
	val blue get() = hex("0000ff")
	val blueViolet get() = hex("8a2be2")
	val brown get() = hex("a52a2a")
	val burlyWood get() = hex("deb887")
	val cadetBlue get() = hex("5f9ea0")
	val chartreuse get() = hex("7fff00")
	val chocolate get() = hex("d2691e")
	val coral get() = hex("ff7f50")
	val cornflowerBlue get() = hex("6495ed")
	val cornsilk get() = hex("fff8dc")
	val crimson get() = hex("dc143c")
	val cyan get() = hex("00ffff")
	val darkBlue get() = hex("00008b")
	val darkCyan get() = hex("008b8b")
	val darkGoldenRod get() = hex("b8860b")
	val darkGray get() = hex("a9a9a9")
	val darkGreen get() = hex("006400")
	val darkKhaki get() = hex("bdb76b")
	val darkMagenta get() = hex("8b008b")
	val darkOliveGreen get() = hex("556b2f")
	val darkorange get() = hex("ff8c00")
	val darkOrchid get() = hex("9932cc")
	val darkRed get() = hex("8b0000")
	val darkSalmon get() = hex("e9967a")
	val darkSeaGreen get() = hex("8fbc8f")
	val darkSlateBlue get() = hex("483d8b")
	val darkSlateGray get() = hex("2f4f4f")
	val darkTurquoise get() = hex("00ced1")
	val darkViolet get() = hex("9400d3")
	val deepPink get() = hex("ff1493")
	val deepSkyBlue get() = hex("00bfff")
	val dimGray get() = hex("696969")
	val dodgerBlue get() = hex("1e90ff")
	val fireBrick get() = hex("b22222")
	val floralWhite get() = hex("fffaf0")
	val forestGreen get() = hex("228b22")
	val fuchsia get() = hex("ff00ff")
	val gainsboro get() = hex("dcdcdc")
	val ghostWhite get() = hex("f8f8ff")
	val gold get() = hex("ffd700")
	val goldenRod get() = hex("daa520")
	val gray get() = hex("808080")
	val green get() = hex("008000")
	val greenYellow get() = hex("adff2f")
	val honeyDew get() = hex("f0fff0")
	val hotPink get() = hex("ff69b4")
	val indianRed get() = hex("cd5c5c")
	val indigo get() = hex("4b0082")
	val ivory get() = hex("fffff0")
	val khaki get() = hex("f0e68c")
	val lavender get() = hex("e6e6fa")
	val lavenderBlush get() = hex("fff0f5")
	val lawnGreen get() = hex("7cfc00")
	val lemonChiffon get() = hex("fffacd")
	val lightBlue get() = hex("add8e6")
	val lightCoral get() = hex("f08080")
	val lightCyan get() = hex("e0ffff")
	val lightGoldenRodYellow get() = hex("fafad2")
	val lightGrey get() = hex("d3d3d3")
	val lightGreen get() = hex("90ee90")
	val lightPink get() = hex("ffb6c1")
	val lightSalmon get() = hex("ffa07a")
	val lightSeaGreen get() = hex("20b2aa")
	val lightSkyBlue get() = hex("87cefa")
	val lightSlateGray get() = hex("778899")
	val lightSteelBlue get() = hex("b0c4de")
	val lightYellow get() = hex("ffffe0")
	val lime get() = hex("00ff00")
	val limeGreen get() = hex("32cd32")
	val linen get() = hex("faf0e6")
	val magenta get() = hex("ff00ff")
	val maroon get() = hex("800000")
	val mediumAquaMarine get() = hex("66cdaa")
	val mediumBlue get() = hex("0000cd")
	val mediumOrchid get() = hex("ba55d3")
	val mediumPurple get() = hex("9370d8")
	val mediumSeaGreen get() = hex("3cb371")
	val mediumSlateBlue get() = hex("7b68ee")
	val mediumSpringGreen get() = hex("00fa9a")
	val mediumTurquoise get() = hex("48d1cc")
	val mediumVioletRed get() = hex("c71585")
	val midnightBlue get() = hex("191970")
	val mintCream get() = hex("f5fffa")
	val mistyRose get() = hex("ffe4e1")
	val moccasin get() = hex("ffe4b5")
	val navajoWhite get() = hex("ffdead")
	val navy get() = hex("000080")
	val oldLace get() = hex("fdf5e6")
	val olive get() = hex("808000")
	val oliveDrab get() = hex("6b8e23")
	val orange get() = hex("ffa500")
	val orangeRed get() = hex("ff4500")
	val orchid get() = hex("da70d6")
	val paleGoldenRod get() = hex("eee8aa")
	val paleGreen get() = hex("98fb98")
	val paleTurquoise get() = hex("afeeee")
	val paleVioletRed get() = hex("d87093")
	val papayaWhip get() = hex("ffefd5")
	val peachPuff get() = hex("ffdab9")
	val peru get() = hex("cd853f")
	val pink get() = hex("ffc0cb")
	val plum get() = hex("dda0dd")
	val powderBlue get() = hex("b0e0e6")
	val purple get() = hex("800080")
	val red get() = hex("ff0000")
	val rosyBrown get() = hex("bc8f8f")
	val royalBlue get() = hex("4169e1")
	val saddleBrown get() = hex("8b4513")
	val salmon get() = hex("fa8072")
	val sandyBrown get() = hex("f4a460")
	val seaGreen get() = hex("2e8b57")
	val seaShell get() = hex("fff5ee")
	val sienna get() = hex("a0522d")
	val silver get() = hex("c0c0c0")
	val skyBlue get() = hex("87ceeb")
	val slateBlue get() = hex("6a5acd")
	val slateGray get() = hex("708090")
	val snow get() = hex("fffafa")
	val springGreen get() = hex("00ff7f")
	val steelBlue get() = hex("4682b4")
	val tan get() = hex("d2b48c")
	val teal get() = hex("008080")
	val thistle get() = hex("d8bfd8")
	val tomato get() = hex("ff6347")
	val turquoise get() = hex("40e0d0")
	val violet get() = hex("ee82ee")
	val wheat get() = hex("f5deb3")
	val white get() = hex("ffffff")
	val whiteSmoke get() = hex("f5f5f5")
	val yellow get() = hex("ffff00")
	val yellowGreen get() = hex("9acd32")
}
