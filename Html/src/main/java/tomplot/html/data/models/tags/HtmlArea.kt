package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlArea(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlArea.AttributeSet>
{
	override val name = HtmlName("area")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var alt by string("alt")
		var coords by string("coords")
		var download by string("download")
		var href by string("href")
		var hrefLang by string("hreflang")
		var media by string("media")
		var referrerPolicy by string("referrerpolicy")
		var rel by string("rel")
		var shape by string("shape")
		var target by string("target")
		var type by string("type")
	}
}
