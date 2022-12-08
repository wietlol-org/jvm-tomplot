// hash: #506ac06b
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
import me.wietlol.tomplot.xml.data.builders.XmlDocumentBuilder
import me.wietlol.tomplot.xml.data.models.*
import me.wietlol.tomplot.xml.data.models.XmlDocument
import me.wietlol.utils.common.streams.readUnsignedVarInt
import me.wietlol.utils.common.streams.writeUnsignedVarInt

// @formatter:on
// @tomplot:customCode:start:70v0f9
// @tomplot:customCode:end
// @formatter:off


object XmlDocumentSerializer : ModelSerializer<XmlDocument, XmlDocument>
{
	private val endOfObject: Int
		= 0
	
	private val headersIndex: Int
		= 1
	
	private val rootIndex: Int
		= 2
	
	override val modelId: UUID
		get() = XmlDocument.serializationKey
	
	override val dataClass: Class<XmlDocument>
		get() = XmlDocument::class.java
	
	override fun serialize(serializationContext: SerializationContext, stream: OutputStream, schema: Schema, entity: XmlDocument)
	{
		stream.writeUnsignedVarInt(headersIndex)
		schema.serialize(serializationContext, stream, entity.headers)
		
		stream.writeUnsignedVarInt(rootIndex)
		schema.serialize(serializationContext, stream, entity.root)
		
		stream.writeUnsignedVarInt(endOfObject)
	}
	
	override fun deserialize(deserializationContext: DeserializationContext, stream: InputStream, schema: Schema): XmlDocument
	{
		var headers: MutableList<XmlHeader>? = mutableListOf()
		var root: XmlNode? = null
		
		while (true)
		{
			when (stream.readUnsignedVarInt())
			{
				endOfObject -> return DefaultXmlDocument(
					headers!!.toMutableList(),
					root!!,
				)
				headersIndex -> headers = schema.deserialize(deserializationContext, stream)
				rootIndex -> root = schema.deserialize(deserializationContext, stream)
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
