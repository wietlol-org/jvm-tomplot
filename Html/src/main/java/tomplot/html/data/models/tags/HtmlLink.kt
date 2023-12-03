package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlLink(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlLink.AttributeSet>
{
	override val name = HtmlName("link")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var crossorigin by string("crossorigin")
		var href by string("href")
		var hrefLang by string("hreflang")
		var media by string("media")
		var referrerPolicy by string("referrerpolicy")
		var rel by string("rel")
		var sizes by string("sizes")
		var type by string("type")
	}
}
