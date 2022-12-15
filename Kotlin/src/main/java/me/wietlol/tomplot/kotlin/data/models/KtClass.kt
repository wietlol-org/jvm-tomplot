// hash: #30eecfe2
// data: serializationKey:ba8b811a-32f2-492e-a2da-405ca090babd
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

interface KtClass : BitSerializable, KtComponent, KtInterfaceMember, KtObjectMember, KtClassMember, KtScriptMember, Jsonable
{
	companion object
	{
		val serializationKey: UUID
			get() = UUID.fromString("serializationKey")
	}
	
	override val serializationKey: UUID
		get() = Companion.serializationKey
	
	val name: String
	
	val generics: List<KtGenericTypeDeclaration>
	
	val superTypes: List<KtTypeReference>
	
	val isDataClass: Boolean
	
	val isValueClass: Boolean
	
	val isSealed: Boolean
	
	val primaryConstructorParameters: List<KtConstructorParameter>
	
	val visibility: KtVisibility
	
	val members: List<KtClassMember>
	
	fun isEqualTo(other: Any?): Boolean
	{
		if (this === other) return true
		if (other == null) return false
		if (other !is KtClass) return false
		
		if (name != other.name) return false
		if (generics != other.generics) return false
		if (superTypes != other.superTypes) return false
		if (isDataClass != other.isDataClass) return false
		if (isValueClass != other.isValueClass) return false
		if (isSealed != other.isSealed) return false
		if (primaryConstructorParameters != other.primaryConstructorParameters) return false
		if (visibility != other.visibility) return false
		if (members != other.members) return false
		
		return true
	}
	
	fun computeHashCode(): Int =
		emptyHashCode
			.with(name)
			.with(generics)
			.with(superTypes)
			.with(isDataClass)
			.with(isValueClass)
			.with(isSealed)
			.with(primaryConstructorParameters)
			.with(visibility)
			.with(members)
	
	override fun toJson(): String =
		"""{"name":${name.toJsonString()},"generics":${generics.toJsonString()},"superTypes":${superTypes.toJsonString()},"isDataClass":${isDataClass.toJsonString()},"isValueClass":${isValueClass.toJsonString()},"isSealed":${isSealed.toJsonString()},"primaryConstructorParameters":${primaryConstructorParameters.toJsonString()},"visibility":${visibility.toJsonString()},"members":${members.toJsonString()}}"""
	
	override fun duplicate(): KtClass
	
	// @formatter:on
	// @tomplot:customCode:start:32T3K8
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
