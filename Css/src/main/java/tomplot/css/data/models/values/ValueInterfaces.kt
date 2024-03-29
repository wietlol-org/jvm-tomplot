package tomplot.css.data.models.values

import tomplot.css.data.models.CssElement
import tomplot.css.data.models.values.functions.CssConicGradientColor

interface CssValue : CssElement
{
	fun toCss(): String
}

interface CssValueGlobal : CssPropertyAccentColor, CssPropertyAlignContent, CssPropertyAlignItems, CssPropertyAlignSelf,
	CssPropertyAll, CssPropertyAnimation, CssPropertyAnimationDelay, CssPropertyAnimationDirection,
	CssPropertyAnimationDuration, CssPropertyAnimationFillMode, CssPropertyAnimationIterationCount,
	CssPropertyAnimationName, CssPropertyAnimationPlayState, CssPropertyAnimationTimingFunction, CssPropertyAspectRatio,
	CssPropertyBackdropFilter, CssPropertyBackfaceVisibility, CssPropertyBackground, CssPropertyBackgroundAttachment,
	CssPropertyBackgroundBlendMode, CssPropertyBackgroundClip, CssPropertyBackgroundColor, CssPropertyBackgroundImage,
	CssPropertyBackgroundOrigin, CssPropertyBackgroundPosition, CssPropertyBackgroundPositionX,
	CssPropertyBackgroundPositionY,	CssPropertyBackgroundRepeat, CssPropertyBackgroundSize, CssPropertyBlockSize,
	CssPropertyBorder, CssPropertyBorderBlock, CssPropertyBorderBlockColor, CssPropertyBorderBlockEnd,
	CssPropertyBorderBlockEndColor, CssPropertyBorderBlockEndStyle, CssPropertyBorderBlockEndWidth,
	CssPropertyBorderBlockStart, CssPropertyBorderBlockStartColor, CssPropertyBorderBlockStartStyle,
	CssPropertyBorderBlockStartWidth, CssPropertyBorderBlockStyle, CssPropertyBorderBlockWidth, CssPropertyBorderBottom,
	CssPropertyBorderBottomColor, CssPropertyBorderBottomLeftRadius, CssPropertyBorderBottomRightRadius,
	CssPropertyBorderBottomStyle, CssPropertyBorderBottomWidth, CssPropertyBorderCollapse, CssPropertyBorderColor,
	CssPropertyBorderEndEndRadius, CssPropertyBorderEndStartRadius, CssPropertyBorderImage,
	CssPropertyBorderImageOutset, CssPropertyBorderImageRepeat, CssPropertyBorderImageSlice,
	CssPropertyBorderImageSource, CssPropertyBorderImageWidth, CssPropertyBorderInline, CssPropertyBorderInlineColor,
	CssPropertyBorderInlineEnd, CssPropertyBorderInlineEndColor, CssPropertyBorderInlineEndStyle,
	CssPropertyBorderInlineEndWidth, CssPropertyBorderInlineStart, CssPropertyBorderInlineStartColor,
	CssPropertyBorderInlineStartStyle, CssPropertyBorderInlineStartWidth, CssPropertyBorderInlineStyle,
	CssPropertyBorderInlineWidth, CssPropertyBorderLeft, CssPropertyBorderLeftColor, CssPropertyBorderLeftStyle,
	CssPropertyBorderLeftWidth, CssPropertyBorderRadius, CssPropertyBorderRight, CssPropertyBorderRightColor,
	CssPropertyBorderRightStyle, CssPropertyBorderRightWidth, CssPropertyBorderSpacing, CssPropertyBorderStartEndRadius,
	CssPropertyBorderStartStartRadius, CssPropertyBorderStyle, CssPropertyBorderTop, CssPropertyBorderTopColor,
	CssPropertyBorderTopLeftRadius, CssPropertyBorderTopRightRadius, CssPropertyBorderTopStyle,
	CssPropertyBorderTopWidth, CssPropertyBorderWidth, CssPropertyBottom, CssPropertyBoxDecorationBreak,
	CssPropertyBoxReflect, CssPropertyBoxShadow, CssPropertyBoxSizing, CssPropertyBreakAfter, CssPropertyBreakBefore,
	CssPropertyBreakInside, CssPropertyCaptionSide, CssPropertyCaretColor, CssPropertyCharset, CssPropertyClear,
	CssPropertyClip, CssPropertyClipPath, CssPropertyColor, CssPropertyColumnCount, CssPropertyColumnFill,
	CssPropertyColumnGap, CssPropertyColumnRule, CssPropertyColumnRuleColor, CssPropertyColumnRuleStyle,
	CssPropertyColumnRuleWidth, CssPropertyColumnSpan, CssPropertyColumnWidth, CssPropertyColumns, CssPropertyContent,
	CssPropertyCounterIncrement, CssPropertyCounterReset, CssPropertyCounterSet, CssPropertyCursor,
	CssPropertyDirection, CssPropertyDisplay, CssPropertyEmptyCells, CssPropertyFilter, CssPropertyFlex,
	CssPropertyFlexBasis, CssPropertyFlexDirection, CssPropertyFlexFlow, CssPropertyFlexGrow, CssPropertyFlexShrink,
	CssPropertyFlexWrap, CssPropertyFloat, CssPropertyFont, CssPropertyFontFace, CssPropertyFontFamily,
	CssPropertyFontFeatureSettings, CssPropertyFontFeatureValues, CssPropertyFontKerning,
	CssPropertyFontLanguageOverride, CssPropertyFontSize, CssPropertyFontSizeAdjust, CssPropertyFontStretch,
	CssPropertyFontStyle, CssPropertyFontSynthesis, CssPropertyFontVariant, CssPropertyFontVariantAlternates,
	CssPropertyFontVariantCaps, CssPropertyFontVariantEastAsian, CssPropertyFontVariantLigatures,
	CssPropertyFontVariantNumeric, CssPropertyFontVariantPosition, CssPropertyFontWeight, CssPropertyGap,
	CssPropertyGrid, CssPropertyGridArea, CssPropertyGridAutoColumns, CssPropertyGridAutoFlow, CssPropertyGridAutoRows,
	CssPropertyGridColumn, CssPropertyGridColumnEnd, CssPropertyGridColumnGap, CssPropertyGridColumnStart,
	CssPropertyGridGap, CssPropertyGridRow, CssPropertyGridRowEnd, CssPropertyGridRowGap, CssPropertyGridRowStart,
	CssPropertyGridTemplate, CssPropertyGridTemplateAreas, CssPropertyGridTemplateColumns, CssPropertyGridTemplateRows,
	CssPropertyHangingPunctuation, CssPropertyHeight, CssPropertyHyphens, CssPropertyHypenateCharacter,
	CssPropertyImageRendering, CssPropertyImport, CssPropertyInlineSize, CssPropertyInset, CssPropertyInsetBlock,
	CssPropertyInsetBlockEnd, CssPropertyInsetBlockStart, CssPropertyInsetInline, CssPropertyInsetInlineEnd,
	CssPropertyInsetInlineStart, CssPropertyIsolation, CssPropertyJustifyContent, CssPropertyJustifyItems,
	CssPropertyJustifySelf, CssPropertyKeyframes, CssPropertyLeft, CssPropertyLetterSpacing, CssPropertyLineBreak,
	CssPropertyLineHeight, CssPropertyListStyle, CssPropertyListStyleImage, CssPropertyListStylePosition,
	CssPropertyListStyleType, CssPropertyMargin, CssPropertyMarginBlock, CssPropertyMarginBlockEnd,
	CssPropertyMarginBlockStart, CssPropertyMarginBottom, CssPropertyMarginInline, CssPropertyMarginInlineEnd,
	CssPropertyMarginInlineStart, CssPropertyMarginLeft, CssPropertyMarginRight, CssPropertyMarginTop, CssPropertyMask,
	CssPropertyMaskClip, CssPropertyMaskComposite, CssPropertyMaskImage, CssPropertyMaskMode, CssPropertyMaskOrigin,
	CssPropertyMaskPosition, CssPropertyMaskRepeat, CssPropertyMaskSize, CssPropertyMaskType, CssPropertyMaxHeight,
	CssPropertyMaxWidth, CssPropertyMedia, CssPropertyMaxBlockSize, CssPropertyMaxInlineSize, CssPropertyMinBlockSize,
	CssPropertyMinInlineSize, CssPropertyMinHeight, CssPropertyMinWidth, CssPropertyMixBlendMode, CssPropertyObjectFit,
	CssPropertyObjectPosition, CssPropertyOffset, CssPropertyOffsetAnchor, CssPropertyOffsetDistance,
	CssPropertyOffsetPath, CssPropertyOffsetRotate, CssPropertyOpacity, CssPropertyOrder, CssPropertyOrphans,
	CssPropertyOutline, CssPropertyOutlineColor, CssPropertyOutlineOffset, CssPropertyOutlineStyle,
	CssPropertyOutlineWidth, CssPropertyOverflow, CssPropertyOverflowAnchor, CssPropertyOverflowWrap,
	CssPropertyOverflowX, CssPropertyOverflowY, CssPropertyOverscrollBehavior, CssPropertyOverscrollBehaviorBlock,
	CssPropertyOverscrollBehaviorInline, CssPropertyOverscrollBehaviorX, CssPropertyOverscrollBehaviorY,
	CssPropertyPadding, CssPropertyPaddingBlock, CssPropertyPaddingBlockEnd, CssPropertyPaddingBlockStart,
	CssPropertyPaddingBottom, CssPropertyPaddingInline, CssPropertyPaddingInlineEnd, CssPropertyPaddingInlineStart,
	CssPropertyPaddingLeft, CssPropertyPaddingRight, CssPropertyPaddingTop, CssPropertyPageBreakAfter,
	CssPropertyPageBreakBefore, CssPropertyPageBreakInside, CssPropertyPaintOrder, CssPropertyPerspective,
	CssPropertyPerspectiveOrigin, CssPropertyPlaceContent, CssPropertyPlaceItems, CssPropertyPlaceSelf,
	CssPropertyPointerEvents, CssPropertyPosition, CssPropertyQuotes, CssPropertyResize, CssPropertyRight,
	CssPropertyRotate, CssPropertyRowGap, CssPropertyScale, CssPropertyScrollBehavior, CssPropertyScrollMargin,
	CssPropertyScrollMarginBlock, CssPropertyScrollMarginBlockEnd, CssPropertyScrollMarginBlockStart,
	CssPropertyScrollMarginBottom, CssPropertyScrollMarginInline, CssPropertyScrollMarginInlineEnd,
	CssPropertyScrollMarginInlineStart, CssPropertyScrollMarginLeft, CssPropertyScrollMarginRight,
	CssPropertyScrollMarginTop, CssPropertyScrollPadding, CssPropertyScrollPaddingBlock,
	CssPropertyScrollPaddingBlockEnd, CssPropertyScrollPaddingBlockStart, CssPropertyScrollPaddingBottom,
	CssPropertyScrollPaddingInline, CssPropertyScrollPaddingInlineEnd, CssPropertyScrollPaddingInlineStart,
	CssPropertyScrollPaddingLeft, CssPropertyScrollPaddingRight, CssPropertyScrollPaddingTop,
	CssPropertyScrollSnapAlign, CssPropertyScrollSnapStop, CssPropertyScrollSnapType, CssPropertyScrollbarColor,
	CssPropertyTabSize, CssPropertyTableLayout, CssPropertyTextAlign, CssPropertyTextAlignLast,
	CssPropertyTextCombineUpright, CssPropertyTextDecoration, CssPropertyTextDecorationColor,
	CssPropertyTextDecorationLine, CssPropertyTextDecorationStyle, CssPropertyTextDecorationThickness,
	CssPropertyTextEmphasis, CssPropertyTextEmphasisColor, CssPropertyTextEmphasisPosition,
	CssPropertyTextEmphasisStyle, CssPropertyTextIndent, CssPropertyTextJustify, CssPropertyTextOrientation,
	CssPropertyTextOverflow, CssPropertyTextShadow, CssPropertyTextTransform, CssPropertyTextUnderlineOffset,
	CssPropertyTextUnderlinePosition, CssPropertyTop, CssPropertyTransform, CssPropertyTransformOrigin,
	CssPropertyTransformStyle, CssPropertyTransition, CssPropertyTransitionDelay, CssPropertyTransitionDuration,
	CssPropertyTransitionProperty, CssPropertyTransitionTimingFunction, CssPropertyTranslate, CssPropertyUnicodeBidi,
	CssPropertyUserSelect, CssPropertyVerticalAlign, CssPropertyVisibility, CssPropertyWhiteSpace, CssPropertyWidows,
	CssPropertyWidth, CssPropertyWordBreak, CssPropertyWordSpacing, CssPropertyWordWrap, CssPropertyWritingMode,
	CssPropertyZIndex

interface CssValueColor : CssPropertyAccentColor, CssPropertyBackgroundColor, CssConicGradientColor, CssPropertyColor

interface CssValueName : CssPropertyAnimationName
interface CssValueString : CssValue
interface CssValueNumber : CssPropertyAnimationIterationCount
interface CssValueDuration : CssPropertyAnimationDelay, CssPropertyAnimationDuration
interface CssValueLength : CssValue, CssPropertyBackgroundPositionX, CssPropertyBackgroundPositionY, CssPropertyBlockSize, CssPropertyBottom, CssPropertyFontSize
interface CssValueAngle : CssValue
