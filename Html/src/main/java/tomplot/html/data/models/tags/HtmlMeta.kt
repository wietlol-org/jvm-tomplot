package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlMeta(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlMeta.AttributeSet>
{
	override val name = HtmlName("meta")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var charset by string("charset")
		var content by string("content")
		var httpEquiv by string("http-equiv")
		var name by string("name")
	}
}
