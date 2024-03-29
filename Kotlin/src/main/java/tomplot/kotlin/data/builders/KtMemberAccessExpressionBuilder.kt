// hash: #a5ca8ab9
// @formatter:off

package tomplot.kotlin.data.builders

import tomplot.kotlin.data.models.*
import tomplot.kotlin.data.models.DefaultKtMemberAccessExpression

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:f5k3GB
// @tomplot:customCode:end
// @formatter:off

class KtMemberAccessExpressionBuilder
{
	var supplier: KtExpression? = null
	
	var memberName: String? = null
	
	var isConditionalAccess: Boolean? = null
	
	var isReferencingAccess: Boolean? = null
	
	fun build(): KtMemberAccessExpression =
		DefaultKtMemberAccessExpression(
			supplier!!,
			memberName!!,
			isConditionalAccess!!,
			isReferencingAccess!!,
		)
	
	// @formatter:on
	// @tomplot:customCode:start:0ETUWm
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
