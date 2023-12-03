package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlAnchor(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlAnchor.AttributeSet>
{
	override val name = HtmlName("a")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var download by string("download")
		var href by string("href")
		var hrefLang by string("hreflang")
		var media by string("media")
		var ping by string("ping")
		var referrerPolicy by string("referrerpolicy")
		var rel by string("rel")
		var target by string("target")
		var type by string("type")
	}
}
