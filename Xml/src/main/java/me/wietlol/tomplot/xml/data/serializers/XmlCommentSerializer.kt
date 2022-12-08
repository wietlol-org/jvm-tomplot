// hash: #f344002d
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
import me.wietlol.tomplot.xml.data.builders.XmlCommentBuilder
import me.wietlol.tomplot.xml.data.models.*
import me.wietlol.tomplot.xml.data.models.XmlComment
import me.wietlol.utils.common.streams.readUnsignedVarInt
import me.wietlol.utils.common.streams.writeUnsignedVarInt

// @formatter:on
// @tomplot:customCode:start:70v0f9
// @tomplot:customCode:end
// @formatter:off


object XmlCommentSerializer : ModelSerializer<XmlComment, XmlComment>
{
	private val endOfObject: Int
		= 0
	
	private val textIndex: Int
		= 1
	
	override val modelId: UUID
		get() = XmlComment.serializationKey
	
	override val dataClass: Class<XmlComment>
		get() = XmlComment::class.java
	
	override fun serialize(serializationContext: SerializationContext, stream: OutputStream, schema: Schema, entity: XmlComment)
	{
		stream.writeUnsignedVarInt(textIndex)
		schema.serialize(serializationContext, stream, entity.text)
		
		stream.writeUnsignedVarInt(endOfObject)
	}
	
	override fun deserialize(deserializationContext: DeserializationContext, stream: InputStream, schema: Schema): XmlComment
	{
		var text: String? = null
		
		while (true)
		{
			when (stream.readUnsignedVarInt())
			{
				endOfObject -> return DefaultXmlComment(
					text!!,
				)
				textIndex -> text = schema.deserialize(deserializationContext, stream)
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
