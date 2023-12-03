package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlListItem(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlListItem.AttributeSet>
{
	override val name = HtmlName("li")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var value by integer("value")
	}
}
