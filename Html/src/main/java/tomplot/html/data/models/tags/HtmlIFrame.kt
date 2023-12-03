package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlIFrame(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlIFrame.AttributeSet>
{
	override val name = HtmlName("iframe")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var allow by string("allow")
		var allowFullScreen by boolean("allowfullscreen")
		var allowPaymentRequest by boolean("allowpaymentrequest")
		var height by integer("height")
		var loading by string("loading")
		var name by string("name")
		var referrerPolicy by string("referrerpolicy")
		var sandbox by string("sandbox")
		var source by string("src")
		var sourceDoc by string("srcdoc")
		var width by integer("width")
	}
}
