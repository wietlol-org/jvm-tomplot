package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlSource(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlSource.AttributeSet>
{
	override val name = HtmlName("source")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var media by string("media")
		var sizes by string("sizes")
		var source by string("src")
		var sourceSet by string("srcset")
		var type by string("type")
	}
}
