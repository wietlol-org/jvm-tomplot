// hash: #a9984927
// @formatter:off
package me.wietlol.tomplot.xml.data.models

import me.wietlol.tomplot.xml.data.models.*

// @formatter:on
// @tomplot:customCode:start:B8CiSn
// @tomplot:customCode:end
// @formatter:off


data class DefaultXmlTextElement(
	override val text: String,
) : XmlTextElement
{
	override fun equals(other: Any?): Boolean =
		isEqualTo(other)
	
	override fun hashCode(): Int =
		computeHashCode()
	
	override fun toString(): String =
		toJson()
	
	override fun duplicate(): DefaultXmlTextElement =
		copy(
			text = text,
		)
	
	// @formatter:on
	// @tomplot:customCode:start:fIpaBB
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
