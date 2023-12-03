// hash: #91de81e5
// @formatter:off

package tomplot.xml.data.builders

import tomplot.xml.data.models.*
import tomplot.xml.data.models.DefaultXmlName

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:f5k3GB
// @tomplot:customCode:end
// @formatter:off

class XmlNameBuilder
{
	var name: String? = null
	
	var namespace: String? = null
	
	fun build(): XmlName =
		DefaultXmlName(
			name!!,
			namespace,
		)
	
	// @formatter:on
	// @tomplot:customCode:start:0ETUWm
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on