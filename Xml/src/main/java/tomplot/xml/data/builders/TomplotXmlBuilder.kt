// hash: #35db081a
// @formatter:off
package tomplot.xml.data.builders

import tomplot.xml.data.models.*

object TomplotXmlBuilder
{
	fun buildXmlComment(body: XmlCommentBuilder.() -> Unit) =
		XmlCommentBuilder()
			.apply(body)
			.build()
	
	fun buildXmlDocument(body: XmlDocumentBuilder.() -> Unit) =
		XmlDocumentBuilder()
			.apply(body)
			.build()
	
	fun buildXmlName(body: XmlNameBuilder.() -> Unit) =
		XmlNameBuilder()
			.apply(body)
			.build()
	
	fun buildXmlNode(body: XmlNodeBuilder.() -> Unit) =
		XmlNodeBuilder()
			.apply(body)
			.build()
	
	fun buildXmlProlog(body: XmlPrologBuilder.() -> Unit) =
		XmlPrologBuilder()
			.apply(body)
			.build()
	
	fun buildXmlTextElement(body: XmlTextElementBuilder.() -> Unit) =
		XmlTextElementBuilder()
			.apply(body)
			.build()
}
// @formatter:on
