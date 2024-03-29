// hash: #83949cee
// @formatter:off

package tomplot.xml.data.models

import tomplot.xml.data.models.*

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:B8CiSn
// @tomplot:customCode:end
// @formatter:off

data class DefaultXmlNode(
	override val name: XmlName,
	override val attributes: XmlAttributeSet,
	override val children: List<XmlNodeElement>,
) : XmlNode
{
	override fun equals(other: Any?): Boolean =
		isEqualTo(other)
	
	override fun hashCode(): Int =
		computeHashCode()
	
	override fun toString(): String =
		toJson()
	
	override fun duplicate(): DefaultXmlNode =
		copy(
			name = name.duplicate(),
			attributes = attributes.duplicate(),
			children = children.map { it.duplicate() }.toMutableList(),
		)
	
	// @formatter:on
	// @tomplot:customCode:start:fIpaBB
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
