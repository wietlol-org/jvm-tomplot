// hash: #c1e1b89f
// @formatter:off

package tomplot.xml.data.models

import tomplot.xml.data.models.*

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:B8CiSn
// @tomplot:customCode:end
// @formatter:off

data class DefaultXmlProlog(
	override val name: String,
	override val attributes: XmlAttributeSet,
) : XmlProlog
{
	override fun equals(other: Any?): Boolean =
		isEqualTo(other)
	
	override fun hashCode(): Int =
		computeHashCode()
	
	override fun toString(): String =
		toJson()
	
	override fun duplicate(): DefaultXmlProlog =
		copy(
			name = name,
			attributes = attributes.duplicate(),
		)
	
	// @formatter:on
	// @tomplot:customCode:start:fIpaBB
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
