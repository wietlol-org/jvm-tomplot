package tomplot.css.data.models.values.functions

import tomplot.css.data.models.values.*

class CssAnimationFunction(
	val name: CssPropertyAnimationName?,
	val duration: CssPropertyAnimationDuration?,
	val timingFunction: CssPropertyAnimationTimingFunction?,
	val delay: CssPropertyAnimationDelay?,
	val iterationCount: CssPropertyAnimationIterationCount?,
	val direction: CssPropertyAnimationDirection?,
	val fillMode: CssPropertyAnimationFillMode?,
	val playState: CssPropertyAnimationPlayState?,
) : CssPropertyAnimation
{
	override fun toCss(): String =
		listOfNotNull(
			name?.toCss(),
			duration?.toCss(),
			timingFunction?.toCss(),
			delay?.toCss(),
			iterationCount?.toCss(),
			direction?.toCss(),
			fillMode?.toCss(),
			playState?.toCss(),
		).joinToString(" ")
}
