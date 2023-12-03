// hash: #19fdd26c
// @formatter:off

package tomplot.xml.data.builders

import tomplot.xml.data.models.*
import tomplot.xml.data.models.DefaultXmlNode

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:f5k3GB
// @tomplot:customCode:end
// @formatter:off

class XmlNodeBuilder
{
	var name: XmlName? = null
	
	var attributes: XmlAttributeSet? = null
	
	var children: MutableList<XmlNodeElement>? = mutableListOf()
	
	fun build(): XmlNode =
		DefaultXmlNode(
			name!!,
			attributes!!,
			children!!.toMutableList(),
		)
	
	// @formatter:on
	// @tomplot:customCode:start:0ETUWm
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on