// hash: #406974d0
// @formatter:off
package me.wietlol.tomplot.xml.data.models

import me.wietlol.tomplot.xml.data.models.*

// @formatter:on
// @tomplot:customCode:start:B8CiSn
// @tomplot:customCode:end
// @formatter:off


data class DefaultXmlName(
	override val name: String,
	override val namespace: String? = null,
) : XmlName
{
	override fun equals(other: Any?): Boolean =
		isEqualTo(other)
	
	override fun hashCode(): Int =
		computeHashCode()
	
	override fun toString(): String =
		toJson()
	
	override fun duplicate(): DefaultXmlName =
		copy(
			name = name,
			namespace = namespace,
		)
	
	// @formatter:on
	// @tomplot:customCode:start:fIpaBB
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on