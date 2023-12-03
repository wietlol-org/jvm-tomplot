package tomplot.css.data.models

data class CssStyleSheet(
	val styles: MutableMap<String, CssStyle> = mutableMapOf()
) : CssElement
