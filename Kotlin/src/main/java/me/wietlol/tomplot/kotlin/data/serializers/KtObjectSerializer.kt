// hash: #732cbb5c
// @formatter:off

package me.wietlol.tomplot.kotlin.data.serializers

import java.io.InputStream
import java.io.OutputStream
import java.util.UUID
import me.wietlol.bitblock.api.serialization.DeserializationContext
import me.wietlol.bitblock.api.serialization.ModelSerializer
import me.wietlol.bitblock.api.serialization.Schema
import me.wietlol.bitblock.api.serialization.SerializationContext
import me.wietlol.bitblock.api.serialization.deserialize
import me.wietlol.tomplot.kotlin.data.builders.KtObjectBuilder
import me.wietlol.tomplot.kotlin.data.models.*
import me.wietlol.tomplot.kotlin.data.models.KtObject
import me.wietlol.utils.common.streams.readUnsignedVarInt
import me.wietlol.utils.common.streams.writeUnsignedVarInt

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:70v0f9
// @tomplot:customCode:end
// @formatter:off

object KtObjectSerializer : ModelSerializer<KtObject, KtObject>
{
	private val endOfObject: Int = 0
	
	private val nameIndex: Int = 1
	
	private val superTypesIndex: Int = 2
	
	private val isCompanionIndex: Int = 3
	
	private val visibilityIndex: Int = 4
	
	private val membersIndex: Int = 5
	
	override val modelId: UUID
		get() = KtObject.serializationKey
	
	override val dataClass: Class<KtObject>
		get() = KtObject::class.java
	
	override fun serialize(serializationContext: SerializationContext, stream: OutputStream, schema: Schema, entity: KtObject)
	{
		entity.name?.also {
			stream.writeUnsignedVarInt(nameIndex)
			schema.serialize(serializationContext, stream, it)
		}
		
		stream.writeUnsignedVarInt(superTypesIndex)
		schema.serialize(serializationContext, stream, entity.superTypes)
		
		stream.writeUnsignedVarInt(isCompanionIndex)
		schema.serialize(serializationContext, stream, entity.isCompanion)
		
		stream.writeUnsignedVarInt(visibilityIndex)
		schema.serialize(serializationContext, stream, entity.visibility)
		
		stream.writeUnsignedVarInt(membersIndex)
		schema.serialize(serializationContext, stream, entity.members)
		
		stream.writeUnsignedVarInt(endOfObject)
	}
	
	override fun deserialize(deserializationContext: DeserializationContext, stream: InputStream, schema: Schema): KtObject
	{
		var name: String? = null
		var superTypes: MutableList<KtTypeReference>? = mutableListOf()
		var isCompanion: Boolean? = null
		var visibility: KtVisibility? = null
		var members: MutableList<KtObjectMember>? = mutableListOf()
		
		while (true)
		{
			when (stream.readUnsignedVarInt())
			{
				endOfObject -> return DefaultKtObject(
					name,
					superTypes!!.toMutableList(),
					isCompanion!!,
					visibility!!,
					members!!.toMutableList(),
				)
				nameIndex -> name = schema.deserialize(deserializationContext, stream)
				superTypesIndex -> superTypes = schema.deserialize(deserializationContext, stream)
				isCompanionIndex -> isCompanion = schema.deserialize(deserializationContext, stream)
				visibilityIndex -> visibility = schema.deserialize(deserializationContext, stream)
				membersIndex -> members = schema.deserialize(deserializationContext, stream)
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