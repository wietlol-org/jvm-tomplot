package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlInput(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlInput.AttributeSet>
{
	override val name = HtmlName("input")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var accept by string("accept")
		var alt by string("alt")
		var autoComplete by string("autocomplete")
		var autoFocus by boolean("autofocus")
		var checked by boolean("checked")
		var directionName by string("dirname")
		var disabled by boolean("disabled")
		var form by string("form")
		var formAction by string("formaction")
		var formEncType by string("formenctype")
		var formMethod by string("formmethod")
		var formNoValidate by string("formnovalidate")
		var formTarget by string("formtarget")
		var height by integer("height")
		var list by string("list")
		var max by string("max")
		var maxLength by integer("maxlength")
		var min by string("min")
		var minLength by integer("minlength")
		var multiple by boolean("multiple")
		var name by string("name")
		var pattern by string("pattern")
		var placeholder by string("placeholder")
		var popoverTarget by string("popovertarget")
		var popoverTargetAction by string("popovertargetaction")
		var readonly by boolean("readonly")
		var required by boolean("required")
		var size by integer("size")
		var source by string("src")
		var step by string("step")
		var type by string("type")
		var value by string("value")
		var width by integer("width")
	}
}
