// hash: #a3e94e37
// @formatter:off
package me.wietlol.tomplot.xml.data.models

import me.wietlol.bitblock.api.serialization.BitSerializable
import me.wietlol.utils.common.Jsonable

// @formatter:on
// @tomplot:customCode:start:WTcTph
// @tomplot:customCode:end
// @formatter:off


interface XmlNodeElement : BitSerializable, XmlElement, Jsonable
{
	override fun duplicate(): XmlNodeElement
	
	// @formatter:on
	// @tomplot:customCode:start:0MOZ71
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
