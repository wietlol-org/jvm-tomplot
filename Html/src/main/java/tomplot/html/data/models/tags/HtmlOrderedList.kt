package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlOrderedList(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlOrderedList.AttributeSet>
{
	override val name = HtmlName("ol")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var reversed by boolean("reversed")
		var start by integer("start")
		var type by string("type")
	}
}
