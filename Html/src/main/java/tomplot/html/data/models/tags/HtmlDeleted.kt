package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlDeleted(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlDeleted.AttributeSet>
{
	override val name = HtmlName("del")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var cite by string("cite")
		var dateTime by zonedDateTime("datetime")
	}
}
