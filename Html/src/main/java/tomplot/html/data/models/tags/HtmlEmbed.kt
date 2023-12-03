package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlEmbed(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlEmbed.AttributeSet>
{
	override val name = HtmlName("embed")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var height by integer("height")
		var source by string("src")
		var type by string("type")
		var width by integer("width")
	}
}
