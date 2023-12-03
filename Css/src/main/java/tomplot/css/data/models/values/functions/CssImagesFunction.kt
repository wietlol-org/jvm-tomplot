package tomplot.css.data.models.values.functions

import tomplot.css.data.models.values.CssPropertyBackgroundImage

class CssImagesFunction(
	val images: List<CssPropertyBackgroundImage>,
) : CssPropertyBackgroundImage
{
	override fun toCss(): String =
		images.joinToString { it.toCss() }
}
