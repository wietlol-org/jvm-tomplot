package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlOption(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlOption.AttributeSet>
{
	override val name = HtmlName("option")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var disabled by boolean("disabled")
		var label by string("label")
		var selected by boolean("selected")
		var value by string("value")
	}
}
