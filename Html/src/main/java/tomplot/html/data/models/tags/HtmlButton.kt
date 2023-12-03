package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlButton(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlButton.AttributeSet>
{
	override val name = HtmlName("button")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var autofocus by boolean("autofocus")
		var disabled by boolean("disabled")
		var form by string("form")
		var formAction by string("formaction")
		var formEncType by string("formenctype")
		var formMethod by string("formmethod")
		var formNoValidate by string("formnovalidate")
		var formTarget by string("formtarget")
		var popoverTarget by string("popovertarget")
		var popoverTargetAction by string("popovertargetaction")
		var name by string("name")
		var type by string("type")
		var value by string("value")
	}
}
