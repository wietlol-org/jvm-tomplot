// hash: #d709a0fd
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
import me.wietlol.tomplot.xml.data.builders.XmlTextElementBuilder
import me.wietlol.tomplot.xml.data.models.*
import me.wietlol.tomplot.xml.data.models.XmlTextElement
import me.wietlol.utils.common.streams.readUnsignedVarInt
import me.wietlol.utils.common.streams.writeUnsignedVarInt

// @formatter:on
// @tomplot:customCode:start:70v0f9
// @tomplot:customCode:end
// @formatter:off


object XmlTextElementSerializer : ModelSerializer<XmlTextElement, XmlTextElement>
{
	private val endOfObject: Int
		= 0
	
	private val textIndex: Int
		= 1
	
	override val modelId: UUID
		get() = XmlTextElement.serializationKey
	
	override val dataClass: Class<XmlTextElement>
		get() = XmlTextElement::class.java
	
	override fun serialize(serializationContext: SerializationContext, stream: OutputStream, schema: Schema, entity: XmlTextElement)
	{
		stream.writeUnsignedVarInt(textIndex)
		schema.serialize(serializationContext, stream, entity.text)
		
		stream.writeUnsignedVarInt(endOfObject)
	}
	
	override fun deserialize(deserializationContext: DeserializationContext, stream: InputStream, schema: Schema): XmlTextElement
	{
		var text: String? = null
		
		while (true)
		{
			when (stream.readUnsignedVarInt())
			{
				endOfObject -> return DefaultXmlTextElement(
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
