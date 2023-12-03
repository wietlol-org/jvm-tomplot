package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlTime(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlTime.AttributeSet>
{
	override val name = HtmlName("time")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var dateTime by zonedDateTime("datetime")
	}
}
