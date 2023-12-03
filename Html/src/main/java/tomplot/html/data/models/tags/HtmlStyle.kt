package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlStyle(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlStyle.AttributeSet>
{
	override val name = HtmlName("style")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var media by string("media")
		var type by string("type")
	}
}
