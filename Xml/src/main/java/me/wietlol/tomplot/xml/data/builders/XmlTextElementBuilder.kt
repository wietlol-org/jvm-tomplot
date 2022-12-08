// hash: #142e6aa2
// @formatter:off
package me.wietlol.tomplot.xml.data.builders

import me.wietlol.tomplot.xml.data.models.*
import me.wietlol.tomplot.xml.data.models.DefaultXmlTextElement

// @formatter:on
// @tomplot:customCode:start:f5k3GB
// @tomplot:customCode:end
// @formatter:off


class XmlTextElementBuilder
{
	var text: String?
		= null
	
	fun build(): XmlTextElement =
		DefaultXmlTextElement(
			text!!,
		)
	
	// @formatter:on
	// @tomplot:customCode:start:0ETUWm
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
