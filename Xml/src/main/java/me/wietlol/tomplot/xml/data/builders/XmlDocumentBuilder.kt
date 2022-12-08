// hash: #67667f75
// @formatter:off
package me.wietlol.tomplot.xml.data.builders

import me.wietlol.tomplot.xml.data.models.*
import me.wietlol.tomplot.xml.data.models.DefaultXmlDocument

// @formatter:on
// @tomplot:customCode:start:f5k3GB
// @tomplot:customCode:end
// @formatter:off


class XmlDocumentBuilder
{
	var headers: MutableList<XmlHeader>?
		= mutableListOf()
	
	var root: XmlNode?
		= null
	
	fun build(): XmlDocument =
		DefaultXmlDocument(
			headers!!.toMutableList(),
			root!!,
		)
	
	// @formatter:on
	// @tomplot:customCode:start:0ETUWm
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
