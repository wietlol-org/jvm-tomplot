package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlProgress(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlProgress.AttributeSet>
{
	override val name = HtmlName("progress")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var max by integer("max")
		var value by integer("value")
	}
}
