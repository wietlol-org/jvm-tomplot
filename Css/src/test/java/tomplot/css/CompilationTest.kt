package tomplot.css

import org.junit.Test
import tomplot.css.builders.styleSheet

class CompilationTest : LocalTestModule()
{
	@Test
	fun `assert that the api provides all options`() = unitTest {
		styleSheet {
			select("div") {
				rawProperty("accent-color", "initial") // by string
				rawProperty("accent-color", rawValue("red")) // as explicit raw value
				rawProperty("accent-color", red) // by value
				
				accentColor = accentColor
				accentColor = auto
				accentColor = inherit
				accentColor = initial
				accentColor = unset
				accentColor = currentColor
				accentColor = red
				accentColor = hex("ffffff")
				accentColor = rgb(0, 0, 0)
				accentColor = rgba(0, 0, 0, 0.0)
				accentColor = hsl(0, 0, 0)
				accentColor = hsla(0, 0, 0, 0.0)
				
				alignContent = alignContent
				alignContent = stretch
				alignContent = center
				alignContent = flexStart
				alignContent = flexEnd
				alignContent = spaceBetween
				alignContent = spaceAround
				alignContent = spaceEvenly
				alignContent = inherit
				alignContent = initial
				alignContent = unset
				
				alignItems = alignItems
				alignItems = normal
				alignItems = stretch
				alignItems = center
				alignItems = start
				alignItems = end
				alignItems = selfStart
				alignItems = selfEnd
				alignItems = flexStart
				alignItems = flexEnd
				alignItems = baseline
				alignItems = inherit
				alignItems = initial
				alignItems = revert
				alignItems = unset
				
				alignSelf = alignSelf
				alignSelf = auto
				alignSelf = stretch
				alignSelf = center
				alignSelf = flexStart
				alignSelf = flexEnd
				alignSelf = baseline
				alignSelf = inherit
				alignSelf = initial
				alignSelf = revert
				alignSelf = unset
				
				all = all
				all = initial
				all = inherit
				all = unset
				
				animation = animation
				animation = animation(
					"myanimation",
					0.s,
					linear,
					0.s,
					0.l,
					normal,
					forwards,
					running,
				)
				
				animationDelay = animationDelay
				animationDelay = 0.s
				animationDelay = 0.ms
				animationDelay = inherit
				animationDelay = initial
				animationDelay = unset
				
				animationDirection = animationDirection
				animationDirection = normal
				animationDirection = reverse
				animationDirection = alternate
				animationDirection = alternateReverse
				animationDirection = inherit
				animationDirection = initial
				animationDirection = unset
				
				animationDuration = animationDuration
				animationDuration = 0.s
				animationDuration = 0.ms
				animationDuration = inherit
				animationDuration = initial
				animationDuration = unset
				
				animationFillMode = animationFillMode
				animationFillMode = none
				animationFillMode = forwards
				animationFillMode = backwards
				animationFillMode = both
				animationFillMode = inherit
				animationFillMode = initial
				animationFillMode = unset
				
				animationIterationCount = animationIterationCount
				animationIterationCount = 0.l
				animationIterationCount = infinite
				animationIterationCount = inherit
				animationIterationCount = initial
				animationIterationCount = unset
				
				animationName = animationName
				animationName = "myanimation".name
				animationName = none
				animationName = inherit
				animationName = initial
				animationName = unset
				
				animationPlayState = animationPlayState
				animationPlayState = paused
				animationPlayState = running
				animationPlayState = inherit
				animationPlayState = initial
				animationPlayState = unset
				
				animationTimingFunction = animationTimingFunction
				animationTimingFunction = linear
				animationTimingFunction = ease
				animationTimingFunction = easeIn
				animationTimingFunction = easeOut
				animationTimingFunction = easeInOut
				animationTimingFunction = stepStart
				animationTimingFunction = stepEnd
				animationTimingFunction = steps(0, start)
				animationTimingFunction = steps(0, end)
				animationTimingFunction = cubicBezier(0.0, 0.0, 0.0, 0.0)
				animationTimingFunction = inherit
				animationTimingFunction = initial
				animationTimingFunction = unset
				
				aspectRatio = aspectRatio
				aspectRatio = ratio(0, 0)
				aspectRatio = inherit
				aspectRatio = initial
				aspectRatio = unset
				
//				backdropFilter = null // todo https://www.w3schools.com/cssref/css3_pr_backdrop-filter.php
				
				backfaceVisibility = backfaceVisibility
				backfaceVisibility = visible
				backfaceVisibility = hidden
				backfaceVisibility = inherit
				backfaceVisibility = initial
				backfaceVisibility = unset
				
//				background = null // todo https://www.w3schools.com/cssref/css3_pr_background.php
				
				backgroundAttachment = backgroundAttachment
				backgroundAttachment = scroll
				backgroundAttachment = fixed
				backgroundAttachment = local
				backgroundAttachment = inherit
				backgroundAttachment = initial
				backgroundAttachment = unset
				
				backgroundBlendMode = backgroundBlendMode
				backgroundBlendMode = normal
				backgroundBlendMode = multiply
				backgroundBlendMode = screen
				backgroundBlendMode = overlay
				backgroundBlendMode = darken
				backgroundBlendMode = lighten
				backgroundBlendMode = colorDodge
				backgroundBlendMode = saturation
				backgroundBlendMode = colorBm
				backgroundBlendMode = luminosity
				backgroundBlendMode = inherit
				backgroundBlendMode = initial
				backgroundBlendMode = unset
				
				backgroundClip = backgroundClip
				backgroundClip = borderBox
				backgroundClip = paddingBox
				backgroundClip = contentBox
				backgroundClip = inherit
				backgroundClip = initial
				backgroundClip = unset
				
				backgroundColor = backgroundColor
				backgroundColor = red
				backgroundColor = transparent
				backgroundColor = inherit
				backgroundColor = initial
				backgroundColor = unset
				
				backgroundImage = backgroundImage
				backgroundImage = url("paper.gif")
				
				//                conic-gradient(from 90deg at 60% 45%, red, yellow, green)
				backgroundImage = conicGradient(90.deg, position(60.pct, 45.pct), red, yellow, green)
				//                conic-gradient(red 0deg, red 90deg, yellow 90deg, yellow 180deg, green 180deg)
				backgroundImage = conicGradient(red at 0.deg, red at 90.deg, yellow at 90.deg, yellow at 180.deg, green at 180.deg)
				//                conic-gradient(at 60% 45%, red, yellow, green)
				backgroundImage = conicGradient(position(60.pct, 45.pct), red, yellow, green)
				
				// todo https://www.w3schools.com/cssref/pr_background-image.php
				// linear-gradient(red, yellow, blue);
				// linear-gradient(to right, red , blue);
				// linear-gradient(to bottom right, red, blue);
				// linear-gradient(180deg, red, blue);
				// linear-gradient(to right, red,orange,yellow,green,blue,indigo,violet);
//				backgroundImage = linearGradient()
				
//				backgroundImage = radialGradient()
//				backgroundImage = repeatingConicGradient()
//				backgroundImage = repeatingLinearGradient()
//				backgroundImage = repeatingRadialGradient()
				
				backgroundImage = images(url("paper.gif"), conicGradient(90.deg, position(60.pct, 45.pct), red, yellow, green))
				backgroundImage = none
				backgroundImage = inherit
				backgroundImage = initial
				backgroundImage = unset
				
				backgroundOrigin = backgroundOrigin
				backgroundOrigin = borderBox
				backgroundOrigin = paddingBox
				backgroundOrigin = contentBox
				backgroundOrigin = inherit
				backgroundOrigin = initial
				backgroundOrigin = unset
				
				backgroundPosition = backgroundPosition
				backgroundPosition = position(left, top)
				backgroundPosition = position(left, center)
				backgroundPosition = position(left,
					bottom
				)
				backgroundPosition = position(center, top)
				backgroundPosition = position(center, center)
				backgroundPosition = position(center,
					bottom
				)
				backgroundPosition = position(right, top)
				backgroundPosition = position(right, center)
				backgroundPosition = position(right,
					bottom
				)
				backgroundPosition = position(10.pct, 40.pct)
				backgroundPosition = position(50.px, 100.px)
				backgroundPosition = inherit
				backgroundPosition = initial
				backgroundPosition = unset
				
				backgroundPositionX = backgroundPositionX
				backgroundPositionX = left
				backgroundPositionX = center
				backgroundPositionX = right
				backgroundPositionX = 10.pct
				backgroundPositionX = 50.px
				backgroundPositionX = inherit
				backgroundPositionX = initial
				backgroundPositionX = unset
				
				backgroundPositionY = backgroundPositionY
				backgroundPositionY = top
				backgroundPositionY = center
				backgroundPositionY = bottom
				backgroundPositionY = 10.pct
				backgroundPositionY = 50.px
				backgroundPositionY = inherit
				backgroundPositionY = initial
				backgroundPositionY = unset
				
				backgroundRepeat = backgroundRepeat
				backgroundRepeat = repeat
				backgroundRepeat = repeatX
				backgroundRepeat = repeatY
				backgroundRepeat = noRepeat
				backgroundRepeat = space
				backgroundRepeat = round
				backgroundRepeat = inherit
				backgroundRepeat = initial
				backgroundRepeat = unset
				
				backgroundSize = backgroundSize
				backgroundSize = size(contain)
				backgroundSize = size(size(size(size(size(contain))))) // a bit ridiculous, and generates wrong css
				backgroundSize = size(70.pct, 50.pct)
				backgroundSize = size(contain, cover)
				backgroundSize = size(size(70.pct, 50.pct), cover, size(30.px, 40.px))
				backgroundSize = inherit
				backgroundSize = initial
				backgroundSize = unset
				
				blockSize = blockSize
				blockSize = auto
				blockSize = 42.px
				blockSize = 42.pct
				blockSize = inherit
				blockSize = initial
				blockSize = unset
				
				bottom_ = bottom_
				bottom_ = auto
				bottom_ = 42.px
				bottom_ = 42.pct
				bottom_ = inherit
				bottom_ = initial
				bottom_ = unset
				
				boxDecorationBreak = boxDecorationBreak
				boxDecorationBreak = clone
				boxDecorationBreak = slice
				boxDecorationBreak = inherit
				boxDecorationBreak = initial
				boxDecorationBreak = unset
				
				boxReflect = boxReflect
				boxReflect = none
				boxReflect = below
				boxReflect = above
				boxReflect = left
				boxReflect = right
				// todo https://www.w3schools.com/cssref/css_pr_box-reflect.php
//				boxReflect = position offset
//				boxReflect = position offset gradient
				boxReflect = inherit
				boxReflect = initial
				boxReflect = unset
				
				boxShadow = boxShadow
				boxShadow = none
				boxShadow = inset
				// todo https://www.w3schools.com/cssref/css3_pr_box-shadow.php
//				boxShadow = h-offset v-offset blur spread color
//				boxShadow = h-offset v-offset blur spread color, h-offset v-offset blur spread color, ...
				boxShadow = inherit
				boxShadow = initial
				boxShadow = unset
				
				boxSizing = boxSizing
				boxSizing = contentBox
				boxSizing = borderBox
				boxSizing = inherit
				boxSizing = initial
				boxSizing = unset
				
				breakAfter = breakAfter
				breakAfter = auto
				breakAfter = allKeyword
				breakAfter = always
				breakAfter = avoid
				breakAfter = avoidColumn
				breakAfter = avoidPage
				breakAfter = avoidRegion
				breakAfter = column
				breakAfter = left
				breakAfter = page
				breakAfter = recto
				breakAfter = region
				breakAfter = right
				breakAfter = verso
				breakAfter = inherit
				breakAfter = initial
				breakAfter = unset
				
				breakBefore = breakBefore
				breakBefore = auto
				breakBefore = allKeyword
				breakBefore = always
				breakBefore = avoid
				breakBefore = avoidColumn
				breakBefore = avoidPage
				breakBefore = avoidRegion
				breakBefore = column
				breakBefore = left
				breakBefore = page
				breakBefore = recto
				breakBefore = region
				breakBefore = right
				breakBefore = verso
				breakBefore = inherit
				breakBefore = initial
				breakBefore = unset
				
				breakInside = breakInside
				breakInside = auto
				breakInside = allKeyword
				breakInside = always
				breakInside = avoid
				breakInside = avoidColumn
				breakInside = avoidPage
				breakInside = avoidRegion
				breakInside = column
				breakInside = left
				breakInside = page
				breakInside = recto
				breakInside = region
				breakInside = right
				breakInside = verso
				breakInside = inherit
				breakInside = initial
				breakInside = unset
				
				fontSize = fontSize
				fontSize = auto
				fontSize = xxSmall
				fontSize = xSmall
				fontSize = smaller
				fontSize = small
				fontSize = medium
				fontSize = large
				fontSize = larger
				fontSize = xLarge
				fontSize = xXLarge
				fontSize = inherit
				fontSize = initial
				fontSize = unset
			}
		}
		
		assertThat(true).isTrue()
	}
}
