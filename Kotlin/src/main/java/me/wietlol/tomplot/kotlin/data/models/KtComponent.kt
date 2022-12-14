// hash: #fa0c93eb
// @formatter:off

package me.wietlol.tomplot.kotlin.data.models

import me.wietlol.bitblock.api.serialization.BitSerializable
import me.wietlol.utils.common.Jsonable

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:WTcTph
// @tomplot:customCode:end
// @formatter:off

sealed interface KtComponent : BitSerializable, KtElement, Jsonable
{
	override fun duplicate(): KtComponent
	
	// @formatter:on
	// @tomplot:customCode:start:0MOZ71
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
