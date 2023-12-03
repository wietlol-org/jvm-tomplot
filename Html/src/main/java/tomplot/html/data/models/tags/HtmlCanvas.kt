package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlCanvas(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlCanvas.AttributeSet>
{
	override val name = HtmlName("canvas")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var height by integer("height")
		var width by integer("width")
	}
}
