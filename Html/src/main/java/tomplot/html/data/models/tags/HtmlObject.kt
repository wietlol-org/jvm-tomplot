package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlObject(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlObject.AttributeSet>
{
	override val name = HtmlName("object")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var data by string("data")
		var form by string("form")
		var height by integer("height")
		var name by string("name")
		var type by string("type")
		var typeMustMatch by boolean("typemustmatch")
		var useMap by string("usemap")
		var width by integer("width")
	}
}
