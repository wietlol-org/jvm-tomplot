// hash: #f3917838
// @formatter:off

package me.wietlol.tomplot.kotlin.data.models

import me.wietlol.tomplot.kotlin.data.models.*

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:B8CiSn
// @tomplot:customCode:end
// @formatter:off

data class DefaultKtInterface(
	override val name: String,
	override val generics: List<KtGenericTypeDeclaration>,
	override val superTypes: List<KtTypeReference>,
	override val isSealed: Boolean,
	override val visibility: KtVisibility,
	override val members: List<KtInterfaceMember>,
) : KtInterface
{
	override fun equals(other: Any?): Boolean =
		isEqualTo(other)
	
	override fun hashCode(): Int =
		computeHashCode()
	
	override fun toString(): String =
		toJson()
	
	override fun duplicate(): DefaultKtInterface =
		copy(
			name = name,
			generics = generics.map { it.duplicate() }.toMutableList(),
			superTypes = superTypes.map { it.duplicate() }.toMutableList(),
			isSealed = isSealed,
			visibility = visibility.duplicate(),
			members = members.map { it.duplicate() }.toMutableList(),
		)
	
	// @formatter:on
	// @tomplot:customCode:start:fIpaBB
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
