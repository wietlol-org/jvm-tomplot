// hash: #79342419
// data: serializationKey:18049f09-51f8-4a3e-bb4e-aa0cb4e13c68
// @formatter:off

package tomplot.kotlin.data.models

import java.util.UUID
import bitblock.api.serialization.BitSerializable
import utils.common.Jsonable
import utils.common.emptyHashCode
import utils.common.toJsonString
import utils.common.with

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:gAeCSq
// @tomplot:customCode:end
// @formatter:off

interface KtCastExpression : BitSerializable, KtExpression, Jsonable
{
	companion object
	{
		val serializationKey: UUID
			get() = UUID.fromString("18049f09-51f8-4a3e-bb4e-aa0cb4e13c68")
	}
	
	override val serializationKey: UUID
		get() = Companion.serializationKey
	
	val expression: KtExpression
	
	val target: KtExpression
	
	val isConditionalCast: Boolean
	
	fun isEqualTo(other: Any?): Boolean
	{
		if (this === other) return true
		if (other == null) return false
		if (other !is KtCastExpression) return false
		
		if (expression != other.expression) return false
		if (target != other.target) return false
		if (isConditionalCast != other.isConditionalCast) return false
		
		return true
	}
	
	fun computeHashCode(): Int =
		emptyHashCode
			.with(expression)
			.with(target)
			.with(isConditionalCast)
	
	override fun toJson(): String =
		"""{"expression":${expression.toJsonString()},"target":${target.toJsonString()},"isConditionalCast":${isConditionalCast.toJsonString()}}"""
	
	override fun duplicate(): KtCastExpression
	
	// @formatter:on
	// @tomplot:customCode:start:32T3K8
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
