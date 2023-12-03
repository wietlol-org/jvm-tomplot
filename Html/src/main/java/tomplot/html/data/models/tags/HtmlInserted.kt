package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlInserted(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlInserted.AttributeSet>
{
	override val name = HtmlName("ins")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var cite by string("cite")
		var dateTime by zonedDateTime("datetime")
	}
}
