package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlColGroup(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlColGroup.AttributeSet>
{
	override val name = HtmlName("colgroup")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var span by integer("span")
	}
}
