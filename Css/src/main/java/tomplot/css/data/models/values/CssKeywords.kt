package tomplot.css.data.models.values

abstract class CssKeyword(
	private val keyword: String
) : CssValue
{
	override fun toCss(): String =
		keyword
}

object CssKeywordAuto : CssKeyword("auto"), CssValueGlobal
object CssKeywordInherit : CssKeyword("inherit"), CssValueGlobal
object CssKeywordInitial : CssKeyword("initial"), CssValueGlobal
object CssKeywordRevert : CssKeyword("revert"), CssValueGlobal
object CssKeywordUnset : CssKeyword("unset"), CssValueGlobal

object CssKeywordAlternate : CssKeyword("alternate"), CssPropertyAnimationDirection
object CssKeywordAlternateReverse : CssKeyword("alternate-reverse"), CssPropertyAnimationDirection
object CssKeywordBackwards : CssKeyword("backwards"), CssPropertyAnimationFillMode
object CssKeywordBaseline : CssKeyword("baseline"), CssPropertyAlignItems, CssPropertyAlignSelf
object CssKeywordBorderBox : CssKeyword("border-box"), CssPropertyBackgroundClip, CssPropertyBackgroundOrigin, CssPropertyBoxSizing
object CssKeywordBoth : CssKeyword("both"), CssPropertyAnimationFillMode
object CssKeywordBottom : CssKeyword("bottom"), CssPropertyBackgroundPositionY
object CssKeywordCenter : CssKeyword("center"), CssPropertyAlignContent, CssPropertyAlignItems, CssPropertyAlignSelf, CssPropertyBackgroundPositionX, CssPropertyBackgroundPositionY
object CssKeywordColor : CssKeyword("color"), CssPropertyBackgroundBlendMode
object CssKeywordColorDodge : CssKeyword("color-dodge"), CssPropertyBackgroundBlendMode
object CssKeywordContentBox : CssKeyword("content-box"), CssPropertyBackgroundClip, CssPropertyBackgroundOrigin, CssPropertyBoxSizing
object CssKeywordCurrentColor : CssKeyword("currentcolor"), CssValueColor
object CssKeywordDarken : CssKeyword("darken"), CssPropertyBackgroundBlendMode
object CssKeywordEase : CssKeyword("ease"), CssPropertyAnimationTimingFunction
object CssKeywordEaseIn : CssKeyword("ease-in"), CssPropertyAnimationTimingFunction
object CssKeywordEaseInOut : CssKeyword("ease-in-out"), CssPropertyAnimationTimingFunction
object CssKeywordEaseOut : CssKeyword("ease-out"), CssPropertyAnimationTimingFunction
object CssKeywordEnd : CssKeyword("end"), CssPropertyAlignItems, CssStepsPoint
object CssKeywordFixed : CssKeyword("fixed"), CssPropertyBackgroundAttachment
object CssKeywordFlexEnd : CssKeyword("flex-end"), CssPropertyAlignContent, CssPropertyAlignItems, CssPropertyAlignSelf
object CssKeywordFlexStart : CssKeyword("flex-start"), CssPropertyAlignContent, CssPropertyAlignItems, CssPropertyAlignSelf
object CssKeywordForwards : CssKeyword("forwards"), CssPropertyAnimationFillMode
object CssKeywordHidden : CssKeyword("hidden"), CssPropertyBackfaceVisibility
object CssKeywordInfinite : CssKeyword("infinite"), CssPropertyAnimationIterationCount
object CssKeywordLeft : CssKeyword("left"), CssPropertyBackgroundPositionX, CssPropertyBoxReflect, CssPropertyBreakAfter, CssPropertyBreakBefore, CssPropertyBreakInside
object CssKeywordLighten : CssKeyword("lighten"), CssPropertyBackgroundBlendMode
object CssKeywordLinear : CssKeyword("linear"), CssPropertyAnimationTimingFunction
object CssKeywordLocal : CssKeyword("local"), CssPropertyBackgroundAttachment
object CssKeywordLuminosity : CssKeyword("luminosity"), CssPropertyBackgroundBlendMode
object CssKeywordMultiply : CssKeyword("multiply"), CssPropertyBackgroundBlendMode
object CssKeywordNoRepeat : CssKeyword("no-repeat"), CssPropertyBackgroundRepeat
object CssKeywordNone : CssKeyword("none"), CssPropertyAnimationFillMode, CssPropertyAnimationName, CssPropertyBackgroundImage, CssPropertyBoxReflect, CssPropertyBoxShadow
object CssKeywordNormal : CssKeyword("normal"), CssPropertyAlignItems, CssPropertyAnimationDirection, CssPropertyBackgroundBlendMode
object CssKeywordOverlay : CssKeyword("overlay"), CssPropertyBackgroundBlendMode
object CssKeywordPaddingBox : CssKeyword("padding-box"), CssPropertyBackgroundClip, CssPropertyBackgroundOrigin
object CssKeywordPaused : CssKeyword("paused"), CssPropertyAnimationPlayState
object CssKeywordRepeat : CssKeyword("repeat"), CssPropertyBackgroundRepeat
object CssKeywordRepeatX : CssKeyword("repeat-x"), CssPropertyBackgroundRepeat
object CssKeywordRepeatY : CssKeyword("repeat-y"), CssPropertyBackgroundRepeat
object CssKeywordReverse : CssKeyword("reverse"), CssPropertyAnimationDirection
object CssKeywordRight : CssKeyword("right"), CssPropertyBackgroundPositionX, CssPropertyBoxReflect, CssPropertyBreakAfter, CssPropertyBreakBefore, CssPropertyBreakInside
object CssKeywordRunning : CssKeyword("running"), CssPropertyAnimationPlayState
object CssKeywordSaturation : CssKeyword("saturation"), CssPropertyBackgroundBlendMode
object CssKeywordScreen : CssKeyword("screen"), CssPropertyBackgroundBlendMode
object CssKeywordScroll : CssKeyword("scroll"), CssPropertyBackgroundAttachment
object CssKeywordSelfEnd : CssKeyword("self-end"), CssPropertyAlignItems
object CssKeywordSelfStart : CssKeyword("self-start"), CssPropertyAlignItems
object CssKeywordSpaceAround : CssKeyword("space-around"), CssPropertyAlignContent
object CssKeywordSpaceBetween : CssKeyword("space-between"), CssPropertyAlignContent
object CssKeywordSpaceEvenly : CssKeyword("space-evenly"), CssPropertyAlignContent
object CssKeywordStart : CssKeyword("start"), CssPropertyAlignItems, CssStepsPoint
object CssKeywordStepEnd : CssKeyword("step-end"), CssPropertyAnimationTimingFunction
object CssKeywordStepStart : CssKeyword("step-start"), CssPropertyAnimationTimingFunction
object CssKeywordStretch : CssKeyword("stretch"), CssPropertyAlignContent, CssPropertyAlignItems, CssPropertyAlignSelf
object CssKeywordTop : CssKeyword("top"), CssPropertyBackgroundPositionY
object CssKeywordTransparent : CssKeyword("transparent"), CssPropertyBackgroundColor
object CssKeywordVisible : CssKeyword("visible"), CssPropertyBackfaceVisibility
object CssKeywordSpace : CssKeyword("space"), CssPropertyBackgroundRepeat
object CssKeywordRound : CssKeyword("round"), CssPropertyBackgroundRepeat
object CssKeywordCover : CssKeyword("cover"), CssPropertyBackgroundSize
object CssKeywordContain : CssKeyword("contain"), CssPropertyBackgroundSize
object CssKeywordClone : CssKeyword("clone"), CssPropertyBoxDecorationBreak
object CssKeywordSlice : CssKeyword("slice"), CssPropertyBoxDecorationBreak
object CssKeywordBelow : CssKeyword("below"), CssPropertyBoxReflect
object CssKeywordAbove : CssKeyword("above"), CssPropertyBoxReflect
object CssKeywordInset : CssKeyword("inset"), CssPropertyBoxShadow
object CssKeywordAlways : CssKeyword("always"), CssPropertyBreakAfter, CssPropertyBreakBefore, CssPropertyBreakInside
object CssKeywordAvoid : CssKeyword("avoid"), CssPropertyBreakAfter, CssPropertyBreakBefore, CssPropertyBreakInside
object CssKeywordAvoidColumn : CssKeyword("avoid-column"), CssPropertyBreakAfter, CssPropertyBreakBefore, CssPropertyBreakInside
object CssKeywordAvoidPage : CssKeyword("avoid-page"), CssPropertyBreakAfter, CssPropertyBreakBefore, CssPropertyBreakInside
object CssKeywordAvoidRegion : CssKeyword("avoid-region"), CssPropertyBreakAfter, CssPropertyBreakBefore, CssPropertyBreakInside
object CssKeywordColumn : CssKeyword("column"), CssPropertyBreakAfter, CssPropertyBreakBefore, CssPropertyBreakInside
object CssKeywordPage : CssKeyword("page"), CssPropertyBreakAfter, CssPropertyBreakBefore, CssPropertyBreakInside
object CssKeywordRecto : CssKeyword("recto"), CssPropertyBreakAfter, CssPropertyBreakBefore, CssPropertyBreakInside
object CssKeywordRegion : CssKeyword("region"), CssPropertyBreakAfter, CssPropertyBreakBefore, CssPropertyBreakInside
object CssKeywordVerso : CssKeyword("verso"), CssPropertyBreakAfter, CssPropertyBreakBefore, CssPropertyBreakInside
object CssKeywordAll : CssKeyword("all"), CssPropertyBreakAfter, CssPropertyBreakBefore, CssPropertyBreakInside
object CssKeywordMedium : CssKeyword("medium"), CssPropertyFontSize
object CssKeywordXxSmall : CssKeyword("xx-small"), CssPropertyFontSize
object CssKeywordXSmall : CssKeyword("x-small"), CssPropertyFontSize
object CssKeywordSmall : CssKeyword("small"), CssPropertyFontSize
object CssKeywordLarge : CssKeyword("large"), CssPropertyFontSize
object CssKeywordXLarge : CssKeyword("x-large"), CssPropertyFontSize
object CssKeywordXXLarge : CssKeyword("xx-large"), CssPropertyFontSize
object CssKeywordSmaller : CssKeyword("smaller"), CssPropertyFontSize
object CssKeywordLarger : CssKeyword("larger"), CssPropertyFontSize








