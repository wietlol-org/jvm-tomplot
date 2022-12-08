// hash: #ef191b25
// data: serializationKey:0057c7db-8c9a-42e0-9ef5-53031dc1484d
// @formatter:off
package me.wietlol.tomplot.xml.data.models

import java.util.UUID
import me.wietlol.bitblock.api.serialization.BitSerializable
import me.wietlol.utils.common.Jsonable
import me.wietlol.utils.common.emptyHashCode
import me.wietlol.utils.common.toJsonString
import me.wietlol.utils.common.with

// @formatter:on
// @tomplot:customCode:start:gAeCSq
// @tomplot:customCode:end
// @formatter:off


interface XmlProlog : BitSerializable, XmlHeader, Jsonable
{
	companion object
	{
		val serializationKey: UUID
			get() = UUID.fromString("0057c7db-8c9a-42e0-9ef5-53031dc1484d")
	}
	
	override val serializationKey: UUID
		get() = Companion.serializationKey
	
	val name: String
	
	val attributes: XmlAttributeSet
	
	fun isEqualTo(other: Any?): Boolean
	{
		if (this === other) return true
		if (other == null) return false
		if (other !is XmlProlog) return false
		
		if (name != other.name) return false
		if (attributes != other.attributes) return false
		
		return true
	}
	
	fun computeHashCode(): Int =
		emptyHashCode
			.with(name)
			.with(attributes)
	
	override fun toJson(): String =
		"""{"name":${name.toJsonString()},"attributes":${attributes.toJsonString()}}"""
	
	override fun duplicate(): XmlProlog
	
	// @formatter:on
	// @tomplot:customCode:start:32T3K8
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
