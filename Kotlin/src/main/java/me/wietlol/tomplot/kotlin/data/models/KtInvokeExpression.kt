// hash: #bb1f63b1
// data: serializationKey:5180451e-2f90-4f79-a0fe-20993da62a2e
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

interface KtInvokeExpression : BitSerializable, KtExpression, Jsonable
{
	companion object
	{
		val serializationKey: UUID
			get() = UUID.fromString("serializationKey")
	}
	
	override val serializationKey: UUID
		get() = Companion.serializationKey
	
	val function: KtExpression
	
	val arguments: List<KtExpression>
	
	fun isEqualTo(other: Any?): Boolean
	{
		if (this === other) return true
		if (other == null) return false
		if (other !is KtInvokeExpression) return false
		
		if (function != other.function) return false
		if (arguments != other.arguments) return false
		
		return true
	}
	
	fun computeHashCode(): Int =
		emptyHashCode
			.with(function)
			.with(arguments)
	
	override fun toJson(): String =
		"""{"function":${function.toJsonString()},"arguments":${arguments.toJsonString()}}"""
	
	override fun duplicate(): KtInvokeExpression
	
	// @formatter:on
	// @tomplot:customCode:start:32T3K8
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on