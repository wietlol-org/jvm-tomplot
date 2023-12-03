package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlAudio(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlAudio.AttributeSet>
{
	override val name = HtmlName("audio")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var autoplay by string("autoplay")
		var controls by string("controls")
		var loop by string("loop")
		var muted by string("muted")
		var preload by string("preload")
		var source by string("src")
	}
}
