// hash: #96af9720
// @formatter:off
package me.wietlol.tomplot.xml.data.serializers

import java.io.InputStream
import java.io.OutputStream
import java.util.UUID
import me.wietlol.bitblock.api.serialization.DeserializationContext
import me.wietlol.bitblock.api.serialization.ModelSerializer
import me.wietlol.bitblock.api.serialization.Schema
import me.wietlol.bitblock.api.serialization.SerializationContext
import me.wietlol.bitblock.api.serialization.deserialize
import me.wietlol.tomplot.xml.data.builders.XmlNameBuilder
import me.wietlol.tomplot.xml.data.models.*
import me.wietlol.tomplot.xml.data.models.XmlName
import me.wietlol.utils.common.streams.readUnsignedVarInt
import me.wietlol.utils.common.streams.writeUnsignedVarInt

// @formatter:on
// @tomplot:customCode:start:70v0f9
// @tomplot:customCode:end
// @formatter:off


object XmlNameSerializer : ModelSerializer<XmlName, XmlName>
{
	private val endOfObject: Int
		= 0
	
	private val nameIndex: Int
		= 1
	
	private val namespaceIndex: Int
		= 2
	
	override val modelId: UUID
		get() = XmlName.serializationKey
	
	override val dataClass: Class<XmlName>
		get() = XmlName::class.java
	
	override fun serialize(serializationContext: SerializationContext, stream: OutputStream, schema: Schema, entity: XmlName)
	{
		stream.writeUnsignedVarInt(nameIndex)
		schema.serialize(serializationContext, stream, entity.name)
		
		entity.namespace?.also {
			stream.writeUnsignedVarInt(namespaceIndex)
			schema.serialize(serializationContext, stream, it)
		}
		
		stream.writeUnsignedVarInt(endOfObject)
	}
	
	override fun deserialize(deserializationContext: DeserializationContext, stream: InputStream, schema: Schema): XmlName
	{
		var name: String? = null
		var namespace: String? = null
		
		while (true)
		{
			when (stream.readUnsignedVarInt())
			{
				endOfObject -> return DefaultXmlName(
					name!!,
					namespace,
				)
				nameIndex -> name = schema.deserialize(deserializationContext, stream)
				namespaceIndex -> namespace = schema.deserialize(deserializationContext, stream)
				else -> schema.deserialize<Any>(deserializationContext, stream)
			}
		}
	}
	
	// @formatter:on
	// @tomplot:customCode:start:5CFs54
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on