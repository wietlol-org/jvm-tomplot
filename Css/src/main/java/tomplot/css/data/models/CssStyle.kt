package tomplot.css.data.models

import tomplot.css.data.models.values.CssValue
import kotlin.reflect.KProperty

data class CssStyle(
	override val properties: MutableMap<String, CssValue> = mutableMapOf()
) : CssStyleApi(), CssElement
{
	private inline operator fun <reified T : CssValue> getValue(self: CssStyle, property: KProperty<*>): T? =
		properties[property.name] as T?
	
	private operator fun setValue(self: CssStyle, property: KProperty<*>, value: CssValue?)
	{
		if (value == null)
			properties.remove(property.name)
		else
			properties[property.name] = value
	}
}
