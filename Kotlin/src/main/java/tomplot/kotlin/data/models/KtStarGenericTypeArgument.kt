// hash: #27e35c0f
// data: serializationKey:be27544b-e9aa-47c7-9045-036c5be1151c
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

interface KtStarGenericTypeArgument : BitSerializable, KtGenericTypeArgument, Jsonable
{
	companion object
	{
		val serializationKey: UUID
			get() = UUID.fromString("be27544b-e9aa-47c7-9045-036c5be1151c")
	}
	
	override val serializationKey: UUID
		get() = Companion.serializationKey
	
	fun isEqualTo(other: Any?): Boolean
	{
		if (this === other) return true
		if (other == null) return false
		if (other !is KtStarGenericTypeArgument) return false
		
		
		return true
	}
	
	fun computeHashCode(): Int =
		emptyHashCode
	
	override fun toJson(): String =
		"""{}"""
	
	override fun duplicate(): KtStarGenericTypeArgument
	
	// @formatter:on
	// @tomplot:customCode:start:32T3K8
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
