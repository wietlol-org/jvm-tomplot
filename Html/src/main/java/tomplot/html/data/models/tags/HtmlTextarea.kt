package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlTextarea(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlTextarea.AttributeSet>
{
	override val name = HtmlName("textarea")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var autoFocus by boolean("autofocus")
		var columns by integer("cols")
		var directionName by string("dirname")
		var disabled by boolean("disabled")
		var form by string("form")
		var maxLength by integer("maxlength")
		var name by string("name")
		var placeholder by string("placeholder")
		var readonly by boolean("readonly")
		var required by boolean("required")
		var rows by integer("rows")
		var wrap by string("wrap")
	}
}
