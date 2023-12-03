// hash: #8fad67ba
// @formatter:off

package tomplot.kotlin.data.models

import tomplot.kotlin.data.models.*

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:B8CiSn
// @tomplot:customCode:end
// @formatter:off

data class DefaultKtProperty(
	override val name: String,
	override val type: KtPropertyType,
	override val isOverride: Boolean,
	override val upperBound: KtTypeReference,
	override val getter: KtExpression?,
	override val visibility: KtVisibility,
	override val initialValue: KtExpression?,
) : KtProperty
{
	override fun equals(other: Any?): Boolean =
		isEqualTo(other)
	
	override fun hashCode(): Int =
		computeHashCode()
	
	override fun toString(): String =
		toJson()
	
	override fun duplicate(): DefaultKtProperty =
		copy(
			name = name,
			type = type.duplicate(),
			isOverride = isOverride,
			upperBound = upperBound.duplicate(),
			getter = getter?.duplicate(),
			visibility = visibility.duplicate(),
			initialValue = initialValue?.duplicate(),
		)
	
	// @formatter:on
	// @tomplot:customCode:start:fIpaBB
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on