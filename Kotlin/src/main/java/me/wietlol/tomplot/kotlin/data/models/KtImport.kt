// hash: #c6367786
// data: serializationKey:2bfb4d73-743d-4b4a-aee3-8141d5913f74
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

interface KtImport : BitSerializable, KtElement, Jsonable
{
	companion object
	{
		val serializationKey: UUID
			get() = UUID.fromString("2bfb4d73-743d-4b4a-aee3-8141d5913f74")
	}
	
	override val serializationKey: UUID
		get() = Companion.serializationKey
	
	val path: List<String>
	
	val isStarImport: Boolean
	
	val alias: String?
	
	fun isEqualTo(other: Any?): Boolean
	{
		if (this === other) return true
		if (other == null) return false
		if (other !is KtImport) return false
		
		if (path != other.path) return false
		if (isStarImport != other.isStarImport) return false
		if (alias != other.alias) return false
		
		return true
	}
	
	fun computeHashCode(): Int =
		emptyHashCode
			.with(path)
			.with(isStarImport)
			.with(alias)
	
	override fun toJson(): String =
		"""{"path":${path.toJsonString()},"isStarImport":${isStarImport.toJsonString()},"alias":${alias.toJsonString()}}"""
	
	override fun duplicate(): KtImport
	
	// @formatter:on
	// @tomplot:customCode:start:32T3K8
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
