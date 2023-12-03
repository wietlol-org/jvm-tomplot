package tomplot.html.data.models

class HtmlDocument<T : HtmlNode<*>>(
	val declaration: HtmlDoctypeDeclaration,
	val rootNode: T,
) : HtmlElement
