// hash: #352d4e9b
// @formatter:off

package tomplot.xml.data.builders

import tomplot.xml.data.models.*
import tomplot.xml.data.models.DefaultXmlProlog

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:f5k3GB
// @tomplot:customCode:end
// @formatter:off

class XmlPrologBuilder
{
	var name: String? = null
	
	var attributes: XmlAttributeSet? = null
	
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