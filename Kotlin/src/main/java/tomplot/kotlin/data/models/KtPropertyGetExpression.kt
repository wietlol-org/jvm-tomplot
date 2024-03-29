// hash: #398dd7b7
// data: serializationKey:d3e86cee-aff2-470b-8ff9-1c60fe1c61f4
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

interface KtPropertyGetExpression : BitSerializable, KtExpression, Jsonable
{
	companion object
	{
		val serializationKey: UUID
			get() = UUID.fromString("d3e86cee-aff2-470b-8ff9-1c60fe1c61f4")
	}
	
	override val serializationKey: UUID
		get() = Companion.serializationKey
	
	val supplierExpression: KtExpression
	
	val propertyName: String
	
	fun isEqualTo(other: Any?): Boolean
	{
		if (this === other) return true
		if (other == null) return false
		if (other !is KtPropertyGetExpression) return false
		
		if (supplierExpression != other.supplierExpression) return false
		if (propertyName != other.propertyName) return false
		
		return true
	}
	
	fun computeHashCode(): Int =
		emptyHashCode
			.with(supplierExpression)
			.with(propertyName)
	
	override fun toJson(): String =
		"""{"supplierExpression":${supplierExpression.toJsonString()},"propertyName":${propertyName.toJsonString()}}"""
	
	override fun duplicate(): KtPropertyGetExpression
	
	// @formatter:on
	// @tomplot:customCode:start:32T3K8
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
