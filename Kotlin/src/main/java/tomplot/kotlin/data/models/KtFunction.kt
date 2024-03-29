// hash: #10c0915b
// data: serializationKey:fab4e238-d609-458d-a3bc-c6e2787a7cc0
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

interface KtFunction : BitSerializable, KtComponent, KtInterfaceMember, KtObjectMember, KtClassMember, KtScriptMember, Jsonable
{
	companion object
	{
		val serializationKey: UUID
			get() = UUID.fromString("fab4e238-d609-458d-a3bc-c6e2787a7cc0")
	}
	
	override val serializationKey: UUID
		get() = Companion.serializationKey
	
	val name: String
	
	val parameters: List<KtParameter>
	
	val returnType: KtTypeReference?
	
	val body: List<KtExpression>?
	
	val isOverride: Boolean
	
	val isExpressionBody: Boolean
	
	val visibility: KtVisibility
	
	fun isEqualTo(other: Any?): Boolean
	{
		if (this === other) return true
		if (other == null) return false
		if (other !is KtFunction) return false
		
		if (name != other.name) return false
		if (parameters != other.parameters) return false
		if (returnType != other.returnType) return false
		if (body != other.body) return false
		if (isOverride != other.isOverride) return false
		if (isExpressionBody != other.isExpressionBody) return false
		if (visibility != other.visibility) return false
		
		return true
	}
	
	fun computeHashCode(): Int =
		emptyHashCode
			.with(name)
			.with(parameters)
			.with(returnType)
			.with(body)
			.with(isOverride)
			.with(isExpressionBody)
			.with(visibility)
	
	override fun toJson(): String =
		"""{"name":${name.toJsonString()},"parameters":${parameters.toJsonString()},"returnType":${returnType.toJsonString()},"body":${body.toJsonString()},"isOverride":${isOverride.toJsonString()},"isExpressionBody":${isExpressionBody.toJsonString()},"visibility":${visibility.toJsonString()}}"""
	
	override fun duplicate(): KtFunction
	
	// @formatter:on
	// @tomplot:customCode:start:32T3K8
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
