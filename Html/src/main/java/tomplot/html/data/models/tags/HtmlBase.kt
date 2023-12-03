package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlBase(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlBase.AttributeSet>
{
	override val name = HtmlName("base")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var href by string("href")
		var target by string("target")
	}
}
