// hash: #a8b387be
// @formatter:off
package me.wietlol.tomplot.xml.data.models

import me.wietlol.bitblock.api.serialization.BitSerializable
import me.wietlol.tomplot.api.data.TomplotElement
import me.wietlol.utils.common.Jsonable

// @formatter:on
// @tomplot:customCode:start:WTcTph
// @tomplot:customCode:end
// @formatter:off


interface XmlElement : BitSerializable, TomplotElement, Jsonable
{
	fun duplicate(): XmlElement
	
	// @formatter:on
	// @tomplot:customCode:start:0MOZ71
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
