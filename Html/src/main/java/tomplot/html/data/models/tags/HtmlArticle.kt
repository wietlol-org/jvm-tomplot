package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlArticle(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlArticle.AttributeSet>
{
	override val name = HtmlName("article")
	
	class AttributeSet : HtmlAttributeSet()
}