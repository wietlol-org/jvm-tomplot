// hash: #42af5233
// data: serializationKey:da4cf0f7-183d-4c57-9d72-cbacf3e1b9e4
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

interface KtStringLiteralExpression : BitSerializable, KtExpression, Jsonable
{
	companion object
	{
		val serializationKey: UUID
			get() = UUID.fromString("da4cf0f7-183d-4c57-9d72-cbacf3e1b9e4")
	}
	
	override val serializationKey: UUID
		get() = Companion.serializationKey
	
	val value: String
	
	val isTripleQuoted: Boolean
	
	fun isEqualTo(other: Any?): Boolean
	{
		if (this === other) return true
		if (other == null) return false
		if (other !is KtStringLiteralExpression) return false
		
		if (value != other.value) return false
		if (isTripleQuoted != other.isTripleQuoted) return false
		
		return true
	}
	
	fun computeHashCode(): Int =
		emptyHashCode
			.with(value)
			.with(isTripleQuoted)
	
	override fun toJson(): String =
		"""{"value":${value.toJsonString()},"isTripleQuoted":${isTripleQuoted.toJsonString()}}"""
	
	override fun duplicate(): KtStringLiteralExpression
	
	// @formatter:on
	// @tomplot:customCode:start:32T3K8
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
