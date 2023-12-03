package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlForm(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlForm.AttributeSet>
{
	override val name = HtmlName("form")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var acceptCharset by string("accept-charset")
		var action by string("action")
		var autoComplete by string("autocomplete")
		var encType by string("enctype")
		var method by string("method")
		var name by string("name")
		var noValidate by string("novalidate")
		var rel by string("rel")
		var target by string("target")
	}
}
