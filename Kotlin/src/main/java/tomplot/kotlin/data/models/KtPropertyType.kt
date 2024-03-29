// hash: #dbc74179
// data: serializationKey:9ff8d0d2-723d-4ddc-a64c-88b1f193c2d2
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

interface KtPropertyType : BitSerializable, KtElement, Jsonable
{
	companion object
	{
		val serializationKey: UUID
			get() = UUID.fromString("9ff8d0d2-723d-4ddc-a64c-88b1f193c2d2")
	}
	
	override val serializationKey: UUID
		get() = Companion.serializationKey
	
	val code: String
	
	fun isEqualTo(other: Any?): Boolean
	{
		if (this === other) return true
		if (other == null) return false
		if (other !is KtPropertyType) return false
		
		if (code != other.code) return false
		
		return true
	}
	
	fun computeHashCode(): Int =
		emptyHashCode
			.with(code)
	
	override fun toJson(): String =
		"""{"code":${code.toJsonString()}}"""
	
	override fun duplicate(): KtPropertyType
	
	// @formatter:on
	// @tomplot:customCode:start:32T3K8
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
