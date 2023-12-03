package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlTableHeader(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlTableHeader.AttributeSet>
{
	override val name = HtmlName("th")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var abbreviated by string("abbr")
		var columnSpan by integer("colspan")
		var headers by string("headers")
		var rowSpan by integer("rowspan")
		var scope by string("scope")
	}
}
