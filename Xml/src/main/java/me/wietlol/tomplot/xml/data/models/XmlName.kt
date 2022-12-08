// hash: #979dfe42
// data: serializationKey:7481303e-78cd-4f5d-b1a6-ebf6153c8045
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


interface XmlName : BitSerializable, XmlElement, Jsonable
{
	companion object
	{
		val serializationKey: UUID
			get() = UUID.fromString("7481303e-78cd-4f5d-b1a6-ebf6153c8045")
	}
	
	override val serializationKey: UUID
		get() = Companion.serializationKey
	
	val name: String
	
	val namespace: String?
	
	fun isEqualTo(other: Any?): Boolean
	{
		if (this === other) return true
		if (other == null) return false
		if (other !is XmlName) return false
		
		if (name != other.name) return false
		if (namespace != other.namespace) return false
		
		return true
	}
	
	fun computeHashCode(): Int =
		emptyHashCode
			.with(name)
			.with(namespace)
	
	override fun toJson(): String =
		"""{"name":${name.toJsonString()},"namespace":${namespace.toJsonString()}}"""
	
	override fun duplicate(): XmlName
	
	// @formatter:on
	// @tomplot:customCode:start:32T3K8
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on