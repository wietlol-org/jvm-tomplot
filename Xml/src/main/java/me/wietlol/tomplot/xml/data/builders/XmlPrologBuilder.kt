// hash: #352d4e9b
// @formatter:off
package me.wietlol.tomplot.xml.data.builders

import me.wietlol.tomplot.xml.data.models.*
import me.wietlol.tomplot.xml.data.models.DefaultXmlProlog

// @formatter:on
// @tomplot:customCode:start:f5k3GB
// @tomplot:customCode:end
// @formatter:off


class XmlPrologBuilder
{
	var name: String?
		= null
	
	var attributes: XmlAttributeSet?
		= null
	
	fun build(): XmlProlog =
		DefaultXmlProlog(
			name!!,
			attributes!!,
		)
	
	// @formatter:on
	// @tomplot:customCode:start:0ETUWm
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
