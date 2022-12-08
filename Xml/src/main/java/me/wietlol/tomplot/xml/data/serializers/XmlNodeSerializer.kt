// hash: #2309e76b
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
import me.wietlol.tomplot.xml.data.builders.XmlNodeBuilder
import me.wietlol.tomplot.xml.data.models.*
import me.wietlol.tomplot.xml.data.models.XmlNode
import me.wietlol.utils.common.streams.readUnsignedVarInt
import me.wietlol.utils.common.streams.writeUnsignedVarInt

// @formatter:on
// @tomplot:customCode:start:70v0f9
// @tomplot:customCode:end
// @formatter:off


object XmlNodeSerializer : ModelSerializer<XmlNode, XmlNode>
{
	private val endOfObject: Int
		= 0
	
	private val nameIndex: Int
		= 1
	
	private val attributesIndex: Int
		= 2
	
	private val childrenIndex: Int
		= 3
	
	override val modelId: UUID
		get() = XmlNode.serializationKey
	
	override val dataClass: Class<XmlNode>
		get() = XmlNode::class.java
	
	override fun serialize(serializationContext: SerializationContext, stream: OutputStream, schema: Schema, entity: XmlNode)
	{
		stream.writeUnsignedVarInt(nameIndex)
		schema.serialize(serializationContext, stream, entity.name)
		
		stream.writeUnsignedVarInt(attributesIndex)
		schema.serialize(serializationContext, stream, entity.attributes)
		
		stream.writeUnsignedVarInt(childrenIndex)
		schema.serialize(serializationContext, stream, entity.children)
		
		stream.writeUnsignedVarInt(endOfObject)
	}
	
	override fun deserialize(deserializationContext: DeserializationContext, stream: InputStream, schema: Schema): XmlNode
	{
		var name: XmlName? = null
		var attributes: XmlAttributeSet? = null
		var children: MutableList<XmlNodeElement>? = mutableListOf()
		
		while (true)
		{
			when (stream.readUnsignedVarInt())
			{
				endOfObject -> return DefaultXmlNode(
					name!!,
					attributes!!,
					children!!.toMutableList(),
				)
				nameIndex -> name = schema.deserialize(deserializationContext, stream)
				attributesIndex -> attributes = schema.deserialize(deserializationContext, stream)
				childrenIndex -> children = schema.deserialize(deserializationContext, stream)
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