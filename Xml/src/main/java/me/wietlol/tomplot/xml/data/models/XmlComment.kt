// hash: #c7f035e7
// data: serializationKey:47d55930-9c71-4b82-b241-3f58270a9d99
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


interface XmlComment : BitSerializable, XmlHeader, XmlNodeElement, Jsonable
{
	companion object
	{
		val serializationKey: UUID
			get() = UUID.fromString("47d55930-9c71-4b82-b241-3f58270a9d99")
	}
	
	override val serializationKey: UUID
		get() = Companion.serializationKey
	
	val text: String
	
	fun isEqualTo(other: Any?): Boolean
	{
		if (this === other) return true
		if (other == null) return false
		if (other !is XmlComment) return false
		
		if (text != other.text) return false
		
		return true
	}
	
	fun computeHashCode(): Int =
		emptyHashCode
			.with(text)
	
	override fun toJson(): String =
		"""{"text":${text.toJsonString()}}"""
	
	override fun duplicate(): XmlComment
	
	// @formatter:on
	// @tomplot:customCode:start:32T3K8
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
