// hash: #9779a999
// @formatter:off
package me.wietlol.tomplot.xml.data.models

import me.wietlol.tomplot.xml.data.models.*

// @formatter:on
// @tomplot:customCode:start:B8CiSn
// @tomplot:customCode:end
// @formatter:off


data class DefaultXmlDocument(
	override val headers: List<XmlHeader>,
	override val root: XmlNode,
) : XmlDocument
{
	override fun equals(other: Any?): Boolean =
		isEqualTo(other)
	
	override fun hashCode(): Int =
		computeHashCode()
	
	override fun toString(): String =
		toJson()
	
	override fun duplicate(): DefaultXmlDocument =
		copy(
			headers = headers.map { it.duplicate() }.toMutableList(),
			root = root.duplicate(),
		)
	
	// @formatter:on
	// @tomplot:customCode:start:fIpaBB
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on