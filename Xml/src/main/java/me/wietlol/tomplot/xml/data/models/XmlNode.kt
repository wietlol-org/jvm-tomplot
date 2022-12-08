// hash: #45f40dd9
// data: serializationKey:cf0f7963-49cd-4084-aaab-fb62d5d08ce7
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


interface XmlNode : BitSerializable, XmlNodeElement, Jsonable
{
	companion object
	{
		val serializationKey: UUID
			get() = UUID.fromString("cf0f7963-49cd-4084-aaab-fb62d5d08ce7")
	}
	
	override val serializationKey: UUID
		get() = Companion.serializationKey
	
	val name: XmlName
	
	val attributes: XmlAttributeSet
	
	val children: List<XmlNodeElement>
	
	fun isEqualTo(other: Any?): Boolean
	{
		if (this === other) return true
		if (other == null) return false
		if (other !is XmlNode) return false
		
		if (name != other.name) return false
		if (attributes != other.attributes) return false
		if (children != other.children) return false
		
		return true
	}
	
	fun computeHashCode(): Int =
		emptyHashCode
			.with(name)
			.with(attributes)
			.with(children)
	
	override fun toJson(): String =
		"""{"name":${name.toJsonString()},"attributes":${attributes.toJsonString()},"children":${children.toJsonString()}}"""
	
	override fun duplicate(): XmlNode
	
	// @formatter:on
	// @tomplot:customCode:start:32T3K8
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
