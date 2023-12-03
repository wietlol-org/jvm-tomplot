package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlParameter(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlParameter.AttributeSet>
{
	override val name = HtmlName("param")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var name by string("name")
		var value by string("value")
	}
}
