// hash: #f1c487fb
// @formatter:off

package tomplot.kotlin.data.builders

import tomplot.kotlin.data.models.*
import tomplot.kotlin.data.models.DefaultKtTemplatedValue

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:f5k3GB
// @tomplot:customCode:end
// @formatter:off

class KtTemplatedValueBuilder
{
	var key: String? = null
	
	var valueProvider: KtValueProvider? = null
	
	fun build(): KtTemplatedValue =
		DefaultKtTemplatedValue(
			key!!,
			valueProvider!!,
		)
	
	// @formatter:on
	// @tomplot:customCode:start:0ETUWm
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on