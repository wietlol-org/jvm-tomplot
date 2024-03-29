// hash: #d3215858
// @formatter:off

package tomplot.kotlin.data.builders

import tomplot.kotlin.data.models.*
import tomplot.kotlin.data.models.DefaultKtInvokeExpression

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:f5k3GB
// @tomplot:customCode:end
// @formatter:off

class KtInvokeExpressionBuilder
{
	var function: KtExpression? = null
	
	var arguments: MutableList<KtExpression>? = mutableListOf()
	
	fun build(): KtInvokeExpression =
		DefaultKtInvokeExpression(
			function!!,
			arguments!!.toMutableList(),
		)
	
	// @formatter:on
	// @tomplot:customCode:start:0ETUWm
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
