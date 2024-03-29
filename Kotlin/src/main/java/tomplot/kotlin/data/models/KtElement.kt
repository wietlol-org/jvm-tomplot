// hash: #d613e29a
// @formatter:off

package tomplot.kotlin.data.models

import bitblock.api.serialization.BitSerializable
import tomplot.api.data.TomplotElement
import utils.common.Jsonable

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:WTcTph
// @tomplot:customCode:end
// @formatter:off

sealed interface KtElement : BitSerializable, TomplotElement, Jsonable
{
	override fun duplicate(): KtElement
	
	// @formatter:on
	// @tomplot:customCode:start:0MOZ71
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
