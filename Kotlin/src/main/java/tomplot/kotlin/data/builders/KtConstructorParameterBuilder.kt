// hash: #e595edf1
// @formatter:off

package tomplot.kotlin.data.builders

import tomplot.kotlin.data.models.*
import tomplot.kotlin.data.models.DefaultKtConstructorParameter

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:f5k3GB
// @tomplot:customCode:end
// @formatter:off

class KtConstructorParameterBuilder
{
	var name: String? = null
	
	var upperBound: KtTypeReference? = null
	
	var defaultValueExpression: KtExpression? = null
	
	var propertyType: KtPropertyType? = null
	
	var isOverride: Boolean? = null
	
	fun build(): KtConstructorParameter =
		DefaultKtConstructorParameter(
			name!!,
			upperBound!!,
			defaultValueExpression,
			propertyType,
			isOverride!!,
		)
	
	// @formatter:on
	// @tomplot:customCode:start:0ETUWm
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
