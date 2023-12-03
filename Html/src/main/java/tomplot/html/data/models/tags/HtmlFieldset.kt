package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlFieldset(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlFieldset.AttributeSet>
{
	override val name = HtmlName("fieldset")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var disabled by boolean("disabled")
		var form by string("form")
		var name by string("name")
	}
}
