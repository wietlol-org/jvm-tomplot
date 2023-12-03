package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlDescription(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlDescription.AttributeSet>
{
	override val name = HtmlName("dd")
	
	class AttributeSet : HtmlAttributeSet()
}
