package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlRubyParen(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlRubyParen.AttributeSet>
{
	override val name = HtmlName("rp")
	
	class AttributeSet : HtmlAttributeSet()
}
