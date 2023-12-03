package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlDialog(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlDialog.AttributeSet>
{
	override val name = HtmlName("dialog")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var open by boolean("open")
	}
}
