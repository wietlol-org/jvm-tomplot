// hash: #f3ff22a8
// @formatter:off

package tomplot.kotlin.data.models

import tomplot.kotlin.data.models.*

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:B8CiSn
// @tomplot:customCode:end
// @formatter:off

data class DefaultKtParameter(
	override val name: String,
	override val upperBound: KtTypeReference,
	override val defaultValueExpression: KtExpression?,
) : KtParameter
{
	override fun equals(other: Any?): Boolean =
		isEqualTo(other)
	
	override fun hashCode(): Int =
		computeHashCode()
	
	override fun toString(): String =
		toJson()
	
	override fun duplicate(): DefaultKtParameter =
		copy(
			name = name,
			upperBound = upperBound.duplicate(),
			defaultValueExpression = defaultValueExpression?.duplicate(),
		)
	
	// @formatter:on
	// @tomplot:customCode:start:fIpaBB
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
