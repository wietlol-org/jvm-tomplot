package tomplot.html.data.models.tags

import tomplot.html.data.models.HtmlAttributeSet
import tomplot.html.data.models.HtmlElement
import tomplot.html.data.models.HtmlName
import tomplot.html.data.models.HtmlNode

class HtmlVideo(
	override val attributes: AttributeSet = AttributeSet(),
	override val children: MutableList<HtmlElement> = mutableListOf(),
) : HtmlNode<HtmlVideo.AttributeSet>
{
	override val name = HtmlName("video")
	
	class AttributeSet : HtmlAttributeSet()
	{
		var autoPlay by boolean("autoplay")
		var controls by boolean("controls")
		var height by integer("height")
		var loop by boolean("loop")
		var muted by boolean("muted")
		var poster by string("poster")
		var preload by string("preload")
		var source by string("src")
		var width by integer("width")
	}
}
