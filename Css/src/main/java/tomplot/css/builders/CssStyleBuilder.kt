package tomplot.css.builders

import tomplot.css.data.models.CssBuilderMarker
import tomplot.css.data.models.CssStyle
import tomplot.css.data.models.CssStyleApi
import tomplot.css.data.models.values.CssRawValue
import tomplot.css.data.models.values.CssValue

@CssBuilderMarker
class CssStyleBuilder(
	val style: CssStyle
) : CssStyleApi(), CssValueBuilder
{
	override val properties: MutableMap<String, CssValue> = style.properties
	
	fun rawProperty(name: String, value: String)
	{
		properties[name] = CssRawValue(value)
	}
	
	fun rawProperty(name: String, value: CssValue)
	{
		properties[name] = value
	}
}
