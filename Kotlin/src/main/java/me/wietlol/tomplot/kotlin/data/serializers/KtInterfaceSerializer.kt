// hash: #cbc8c674
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
import me.wietlol.tomplot.kotlin.data.builders.KtInterfaceBuilder
import me.wietlol.tomplot.kotlin.data.models.*
import me.wietlol.tomplot.kotlin.data.models.KtInterface
import me.wietlol.utils.common.streams.readUnsignedVarInt
import me.wietlol.utils.common.streams.writeUnsignedVarInt

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:70v0f9
// @tomplot:customCode:end
// @formatter:off

object KtInterfaceSerializer : ModelSerializer<KtInterface, KtInterface>
{
	private val endOfObject: Int = 0
	
	private val nameIndex: Int = 1
	
	private val genericsIndex: Int = 2
	
	private val superTypesIndex: Int = 3
	
	private val isSealedIndex: Int = 4
	
	private val visibilityIndex: Int = 5
	
	private val membersIndex: Int = 6
	
	override val modelId: UUID
		get() = KtInterface.serializationKey
	
	override val dataClass: Class<KtInterface>
		get() = KtInterface::class.java
	
	override fun serialize(serializationContext: SerializationContext, stream: OutputStream, schema: Schema, entity: KtInterface)
	{
		stream.writeUnsignedVarInt(nameIndex)
		schema.serialize(serializationContext, stream, entity.name)
		
		stream.writeUnsignedVarInt(genericsIndex)
		schema.serialize(serializationContext, stream, entity.generics)
		
		stream.writeUnsignedVarInt(superTypesIndex)
		schema.serialize(serializationContext, stream, entity.superTypes)
		
		stream.writeUnsignedVarInt(isSealedIndex)
		schema.serialize(serializationContext, stream, entity.isSealed)
		
		stream.writeUnsignedVarInt(visibilityIndex)
		schema.serialize(serializationContext, stream, entity.visibility)
		
		stream.writeUnsignedVarInt(membersIndex)
		schema.serialize(serializationContext, stream, entity.members)
		
		stream.writeUnsignedVarInt(endOfObject)
	}
	
	override fun deserialize(deserializationContext: DeserializationContext, stream: InputStream, schema: Schema): KtInterface
	{
		var name: String? = null
		var generics: MutableList<KtGenericTypeDeclaration>? = mutableListOf()
		var superTypes: MutableList<KtTypeReference>? = mutableListOf()
		var isSealed: Boolean? = null
		var visibility: KtVisibility? = null
		var members: MutableList<KtInterfaceMember>? = mutableListOf()
		
		while (true)
		{
			when (stream.readUnsignedVarInt())
			{
				endOfObject -> return DefaultKtInterface(
					name!!,
					generics!!.toMutableList(),
					superTypes!!.toMutableList(),
					isSealed!!,
					visibility!!,
					members!!.toMutableList(),
				)
				nameIndex -> name = schema.deserialize(deserializationContext, stream)
				genericsIndex -> generics = schema.deserialize(deserializationContext, stream)
				superTypesIndex -> superTypes = schema.deserialize(deserializationContext, stream)
				isSealedIndex -> isSealed = schema.deserialize(deserializationContext, stream)
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