package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlLabel(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlLabel.AttributeSet>
{
	override val name = HtmlName("label")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var `for` by string("for")
		var form by string("form")
	}
}
