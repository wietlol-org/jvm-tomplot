package tomplot.html.engine

import tomplot.html.data.models.HtmlDoctypeDeclaration
import tomplot.html.data.models.HtmlDocument
import tomplot.html.data.models.HtmlNode
import tomplot.html.data.models.tags.HtmlHtml

class HtmlTomplotEngine
{
	fun createDocument(builder: HtmlHtml.() -> Unit): HtmlDocument<HtmlHtml> =
		createDocument(HtmlHtml(), builder)
	
	fun <T : HtmlNode<*>> createDocument(rootNode: T, builder: T.() -> Unit): HtmlDocument<T> =
		HtmlDocument(
			HtmlDoctypeDeclaration(),
			rootNode.also(builder)
		)
}
