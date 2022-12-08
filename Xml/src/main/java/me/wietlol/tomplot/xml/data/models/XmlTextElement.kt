// hash: #b7be0201
// data: serializationKey:40f7c5b8-6b07-4f81-b095-bf650c82a0cf
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


interface XmlTextElement : BitSerializable, XmlNodeElement, Jsonable
{
	companion object
	{
		val serializationKey: UUID
			get() = UUID.fromString("40f7c5b8-6b07-4f81-b095-bf650c82a0cf")
	}
	
	override val serializationKey: UUID
		get() = Companion.serializationKey
	
	val text: String
	
	fun isEqualTo(other: Any?): Boolean
	{
		if (this === other) return true
		if (other == null) return false
		if (other !is XmlTextElement) return false
		
		if (text != other.text) return false
		
		return true
	}
	
	fun computeHashCode(): Int =
		emptyHashCode
			.with(text)
	
	override fun toJson(): String =
		"""{"text":${text.toJsonString()}}"""
	
	override fun duplicate(): XmlTextElement
	
	// @formatter:on
	// @tomplot:customCode:start:32T3K8
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
