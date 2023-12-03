package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlImage(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlImage.AttributeSet>
{
	override val name = HtmlName("img")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var alt by string("alt")
		var crossOrigin by string("crossorigin")
		var height by integer("height")
		var isMap by boolean("ismap")
		var loading by string("loading")
		var longdesc by string("longdesc")
		var referrerPolicy by string("referrerpolicy")
		var sizes by string("sizes")
		var source by string("src")
		var sourceSet by string("srcset")
		var useMap by string("usemap")
		var width by integer("width")
	}
}
