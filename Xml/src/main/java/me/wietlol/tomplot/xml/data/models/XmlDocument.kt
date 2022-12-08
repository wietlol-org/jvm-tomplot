// hash: #894c4c85
// data: serializationKey:f6520cdd-f538-4714-9336-bf5cba670585
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


interface XmlDocument : BitSerializable, XmlElement, Jsonable
{
	companion object
	{
		val serializationKey: UUID
			get() = UUID.fromString("f6520cdd-f538-4714-9336-bf5cba670585")
	}
	
	override val serializationKey: UUID
		get() = Companion.serializationKey
	
	val headers: List<XmlHeader>
	
	val root: XmlNode
	
	fun isEqualTo(other: Any?): Boolean
	{
		if (this === other) return true
		if (other == null) return false
		if (other !is XmlDocument) return false
		
		if (headers != other.headers) return false
		if (root != other.root) return false
		
		return true
	}
	
	fun computeHashCode(): Int =
		emptyHashCode
			.with(headers)
			.with(root)
	
	override fun toJson(): String =
		"""{"headers":${headers.toJsonString()},"root":${root.toJsonString()}}"""
	
	override fun duplicate(): XmlDocument
	
	// @formatter:on
	// @tomplot:customCode:start:32T3K8
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
