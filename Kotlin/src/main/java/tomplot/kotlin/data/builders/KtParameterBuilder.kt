// hash: #92076c8f
// @formatter:off

package tomplot.kotlin.data.builders

import tomplot.kotlin.data.models.*
import tomplot.kotlin.data.models.DefaultKtParameter

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:f5k3GB
// @tomplot:customCode:end
// @formatter:off

class KtParameterBuilder
{
	var name: String? = null
	
	var upperBound: KtTypeReference? = null
	
	var defaultValueExpression: KtExpression? = null
	
	fun build(): KtParameter =
		DefaultKtParameter(
			name!!,
			upperBound!!,
			defaultValueExpression,
		)
	
	// @formatter:on
	// @tomplot:customCode:start:0ETUWm
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on