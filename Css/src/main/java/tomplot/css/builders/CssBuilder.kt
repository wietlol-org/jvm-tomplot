package tomplot.css.builders

import tomplot.css.data.models.CssStyleSheet

fun styleSheet(body: CssStyleSheetBuilder.() -> Unit): CssStyleSheet
{
	return CssStyleSheet(mutableMapOf())
}
