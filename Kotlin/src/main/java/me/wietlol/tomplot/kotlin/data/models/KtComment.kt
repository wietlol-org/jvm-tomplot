// hash: #cb8e1a6d
// data: serializationKey:56b89e7f-a4d1-4e25-95e2-0ea8fb80d905
// @formatter:off

package me.wietlol.tomplot.kotlin.data.models

import java.util.UUID
import me.wietlol.bitblock.api.serialization.BitSerializable
import me.wietlol.utils.common.Jsonable
import me.wietlol.utils.common.emptyHashCode
import me.wietlol.utils.common.toJsonString
import me.wietlol.utils.common.with

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:gAeCSq
// @tomplot:customCode:end
// @formatter:off

interface KtComment : BitSerializable, KtInterfaceMember, KtObjectMember, KtClassMember, KtScriptMember, Jsonable
{
	companion object
	{
		val serializationKey: UUID
			get() = UUID.fromString("serializationKey")
	}
	
	override val serializationKey: UUID
		get() = Companion.serializationKey
	
	val text: List<String>
	
	fun isEqualTo(other: Any?): Boolean
	{
		if (this === other) return true
		if (other == null) return false
		if (other !is KtComment) return false
		
		if (text != other.text) return false
		
		return true
	}
	
	fun computeHashCode(): Int =
		emptyHashCode
			.with(text)
	
	override fun toJson(): String =
		"""{"text":${text.toJsonString()}}"""
	
	override fun duplicate(): KtComment
	
	// @formatter:on
	// @tomplot:customCode:start:32T3K8
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
