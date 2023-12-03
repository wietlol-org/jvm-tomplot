package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlMeter(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlMeter.AttributeSet>
{
	override val name = HtmlName("meter")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var form by string("form")
		var high by double("high")
		var low by double("low")
		var max by double("max")
		var min by double("min")
		var optimum by double("optimum")
		var value by double("value")
	}
}
