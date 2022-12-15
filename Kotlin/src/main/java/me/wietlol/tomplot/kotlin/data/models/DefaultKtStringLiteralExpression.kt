// hash: #6772f37c
// @formatter:off

package me.wietlol.tomplot.kotlin.data.models

import me.wietlol.tomplot.kotlin.data.models.*

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:B8CiSn
// @tomplot:customCode:end
// @formatter:off

data class DefaultKtStringLiteralExpression(
	override val value: String,
	override val isTripleQuoted: Boolean,
) : KtStringLiteralExpression
{
	override fun equals(other: Any?): Boolean =
		isEqualTo(other)
	
	override fun hashCode(): Int =
		computeHashCode()
	
	override fun toString(): String =
		toJson()
	
	override fun duplicate(): DefaultKtStringLiteralExpression =
		copy(
			value = value,
			isTripleQuoted = isTripleQuoted,
		)
	
	// @formatter:on
	// @tomplot:customCode:start:fIpaBB
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on