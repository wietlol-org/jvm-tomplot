// hash: #d82f8242
// @formatter:off
package me.wietlol.tomplot.xml.data.builders

import me.wietlol.tomplot.xml.data.models.*
import me.wietlol.tomplot.xml.data.models.DefaultXmlComment

// @formatter:on
// @tomplot:customCode:start:f5k3GB
// @tomplot:customCode:end
// @formatter:off


class XmlCommentBuilder
{
	var text: String?
		= null
	
	fun build(): XmlComment =
		DefaultXmlComment(
			text!!,
		)
	
	// @formatter:on
	// @tomplot:customCode:start:0ETUWm
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
