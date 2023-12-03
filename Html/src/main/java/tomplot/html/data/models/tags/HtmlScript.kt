package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlScript(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlScript.AttributeSet>
{
	override val name = HtmlName("script")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var async by boolean("async")
		var crossOrigin by string("crossorigin")
		var defer by boolean("defer")
		var integrity by string("integrity")
		var noModule by boolean("nomodule")
		var referrerPolicy by string("referrerpolicy")
		var source by string("src")
		var type by string("type")
	}
}
