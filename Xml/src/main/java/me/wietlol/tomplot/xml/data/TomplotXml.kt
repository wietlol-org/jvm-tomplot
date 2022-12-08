// hash: #9befc845
// @formatter:off
package me.wietlol.tomplot.xml.data

import me.wietlol.bitblock.api.registry.ModelRegistry
import me.wietlol.bitblock.api.registry.ModelRegistryKey
import me.wietlol.bitblock.api.registry.RegistrySet
import me.wietlol.bitblock.api.serialization.ModelSerializer
import me.wietlol.bitblock.core.BitBlockBase
import me.wietlol.bitblock.core.registry.CommonModelRegistryKey
import me.wietlol.tomplot.xml.data.serializers.*

object TomplotXml : RegistrySet
{
	override val modelSerializers: Map<ModelRegistryKey, ModelSerializer<*, *>>
		= createModelSerializers()
	
	private fun createModelSerializers(): Map<ModelRegistryKey, ModelSerializer<*, *>> =
		mapOf(
			CommonModelRegistryKey("XmlComment", "TomplotXml", "Wietlol", "1.0") to XmlCommentSerializer,
			CommonModelRegistryKey("XmlDocument", "TomplotXml", "Wietlol", "1.0") to XmlDocumentSerializer,
			CommonModelRegistryKey("XmlName", "TomplotXml", "Wietlol", "1.0") to XmlNameSerializer,
			CommonModelRegistryKey("XmlNode", "TomplotXml", "Wietlol", "1.0") to XmlNodeSerializer,
			CommonModelRegistryKey("XmlProlog", "TomplotXml", "Wietlol", "1.0") to XmlPrologSerializer,
			CommonModelRegistryKey("XmlTextElement", "TomplotXml", "Wietlol", "1.0") to XmlTextElementSerializer,
		)
	
	override fun initialize(registry: ModelRegistry?) =
		modelSerializers.forEach((registry ?: BitBlockBase.modelRegistry)::set)
}
// @formatter:on
