package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlSelect(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlSelect.AttributeSet>
{
	override val name = HtmlName("select")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var autoFocus by boolean("autofocus")
		var disabled by boolean("disabled")
		var form by string("form")
		var multiple by boolean("multiple")
		var name by string("name")
		var required by boolean("required")
		var size by integer("size")
	}
}
