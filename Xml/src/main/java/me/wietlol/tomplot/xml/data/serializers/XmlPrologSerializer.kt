// hash: #ab277203
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
import me.wietlol.tomplot.xml.data.builders.XmlPrologBuilder
import me.wietlol.tomplot.xml.data.models.*
import me.wietlol.tomplot.xml.data.models.XmlProlog
import me.wietlol.utils.common.streams.readUnsignedVarInt
import me.wietlol.utils.common.streams.writeUnsignedVarInt

// @formatter:on
// @tomplot:customCode:start:70v0f9
// @tomplot:customCode:end
// @formatter:off


object XmlPrologSerializer : ModelSerializer<XmlProlog, XmlProlog>
{
	private val endOfObject: Int
		= 0
	
	private val nameIndex: Int
		= 1
	
	private val attributesIndex: Int
		= 2
	
	override val modelId: UUID
		get() = XmlProlog.serializationKey
	
	override val dataClass: Class<XmlProlog>
		get() = XmlProlog::class.java
	
	override fun serialize(serializationContext: SerializationContext, stream: OutputStream, schema: Schema, entity: XmlProlog)
	{
		stream.writeUnsignedVarInt(nameIndex)
		schema.serialize(serializationContext, stream, entity.name)
		
		stream.writeUnsignedVarInt(attributesIndex)
		schema.serialize(serializationContext, stream, entity.attributes)
		
		stream.writeUnsignedVarInt(endOfObject)
	}
	
	override fun deserialize(deserializationContext: DeserializationContext, stream: InputStream, schema: Schema): XmlProlog
	{
		var name: String? = null
		var attributes: XmlAttributeSet? = null
		
		while (true)
		{
			when (stream.readUnsignedVarInt())
			{
				endOfObject -> return DefaultXmlProlog(
					name!!,
					attributes!!,
				)
				nameIndex -> name = schema.deserialize(deserializationContext, stream)
				attributesIndex -> attributes = schema.deserialize(deserializationContext, stream)
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
