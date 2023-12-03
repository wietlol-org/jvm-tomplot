package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlTrack(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlTrack.AttributeSet>
{
	override val name = HtmlName("track")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var default by boolean("default")
		var kind by string("kind")
		var label by string("label")
		var source by string("src")
		var sourceLanguage by string("srclang")
	}
}
