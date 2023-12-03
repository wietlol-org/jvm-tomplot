package tomplot.css.builders

import tomplot.css.data.models.CssStyle
import tomplot.css.data.models.CssStyleSheet

class CssStyleSheetBuilder(
	val styleSheet: CssStyleSheet
)
{
	fun select(selector: String, body: CssStyleBuilder.() -> Unit): CssStyle
	{
		val style = styleSheet.styles.computeIfAbsent(selector) { CssStyle() }
		body(CssStyleBuilder(style))
		return style
	}
}
