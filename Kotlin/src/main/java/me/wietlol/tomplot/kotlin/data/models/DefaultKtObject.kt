// hash: #ba757d5e
// @formatter:off

package me.wietlol.tomplot.kotlin.data.models

import me.wietlol.tomplot.kotlin.data.models.*

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:B8CiSn
// @tomplot:customCode:end
// @formatter:off

data class DefaultKtObject(
	override val name: String?,
	override val superTypes: List<KtTypeReference>,
	override val isCompanion: Boolean,
	override val visibility: KtVisibility,
	override val members: List<KtObjectMember>,
) : KtObject
{
	override fun equals(other: Any?): Boolean =
		isEqualTo(other)
	
	override fun hashCode(): Int =
		computeHashCode()
	
	override fun toString(): String =
		toJson()
	
	override fun duplicate(): DefaultKtObject =
		copy(
			name = name,
			superTypes = superTypes.map { it.duplicate() }.toMutableList(),
			isCompanion = isCompanion,
			visibility = visibility.duplicate(),
			members = members.map { it.duplicate() }.toMutableList(),
		)
	
	// @formatter:on
	// @tomplot:customCode:start:fIpaBB
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on