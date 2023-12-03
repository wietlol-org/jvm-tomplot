package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlTableData(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlTableData.AttributeSet>
{
	override val name = HtmlName("td")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var columnSpan by integer("colspan")
		var headers by string("headers")
		var rowSpan by integer("rowspan")
	}
}
