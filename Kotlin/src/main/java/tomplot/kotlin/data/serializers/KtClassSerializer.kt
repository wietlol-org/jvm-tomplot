// hash: #2ceb985c
// @formatter:off

package tomplot.kotlin.data.serializers

import java.io.InputStream
import java.io.OutputStream
import java.util.UUID
import bitblock.api.serialization.DeserializationContext
import bitblock.api.serialization.ModelSerializer
import bitblock.api.serialization.Schema
import bitblock.api.serialization.SerializationContext
import bitblock.api.serialization.deserialize
import tomplot.kotlin.data.builders.KtClassBuilder
import tomplot.kotlin.data.models.*
import tomplot.kotlin.data.models.KtClass
import utils.common.streams.readUnsignedVarInt
import utils.common.streams.writeUnsignedVarInt

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:70v0f9
// @tomplot:customCode:end
// @formatter:off

object KtClassSerializer : ModelSerializer<KtClass, KtClass>
{
	private val endOfObject: Int = 0
	
	private val nameIndex: Int = 1
	
	private val genericsIndex: Int = 2
	
	private val superTypesIndex: Int = 3
	
	private val isDataClassIndex: Int = 4
	
	private val isValueClassIndex: Int = 5
	
	private val isSealedIndex: Int = 6
	
	private val primaryConstructorParametersIndex: Int = 7
	
	private val visibilityIndex: Int = 8
	
	private val membersIndex: Int = 9
	
	override val modelId: UUID
		get() = KtClass.serializationKey
	
	override val dataClass: Class<KtClass>
		get() = KtClass::class.java
	
	override fun serialize(serializationContext: SerializationContext, stream: OutputStream, schema: Schema, entity: KtClass)
	{
		stream.writeUnsignedVarInt(nameIndex)
		schema.serialize(serializationContext, stream, entity.name)
		
		stream.writeUnsignedVarInt(genericsIndex)
		schema.serialize(serializationContext, stream, entity.generics)
		
		stream.writeUnsignedVarInt(superTypesIndex)
		schema.serialize(serializationContext, stream, entity.superTypes)
		
		stream.writeUnsignedVarInt(isDataClassIndex)
		schema.serialize(serializationContext, stream, entity.isDataClass)
		
		stream.writeUnsignedVarInt(isValueClassIndex)
		schema.serialize(serializationContext, stream, entity.isValueClass)
		
		stream.writeUnsignedVarInt(isSealedIndex)
		schema.serialize(serializationContext, stream, entity.isSealed)
		
		stream.writeUnsignedVarInt(primaryConstructorParametersIndex)
		schema.serialize(serializationContext, stream, entity.primaryConstructorParameters)
		
		stream.writeUnsignedVarInt(visibilityIndex)
		schema.serialize(serializationContext, stream, entity.visibility)
		
		stream.writeUnsignedVarInt(membersIndex)
		schema.serialize(serializationContext, stream, entity.members)
		
		stream.writeUnsignedVarInt(endOfObject)
	}
	
	override fun deserialize(deserializationContext: DeserializationContext, stream: InputStream, schema: Schema): KtClass
	{
		var name: String? = null
		var generics: MutableList<KtGenericTypeDeclaration>? = mutableListOf()
		var superTypes: MutableList<KtTypeReference>? = mutableListOf()
		var isDataClass: Boolean? = null
		var isValueClass: Boolean? = null
		var isSealed: Boolean? = null
		var primaryConstructorParameters: MutableList<KtConstructorParameter>? = mutableListOf()
		var visibility: KtVisibility? = null
		var members: MutableList<KtClassMember>? = mutableListOf()
		
		while (true)
		{
			when (stream.readUnsignedVarInt())
			{
				endOfObject -> return DefaultKtClass(
					name!!,
					generics!!.toMutableList(),
					superTypes!!.toMutableList(),
					isDataClass!!,
					isValueClass!!,
					isSealed!!,
					primaryConstructorParameters!!.toMutableList(),
					visibility!!,
					members!!.toMutableList(),
				)
				nameIndex -> name = schema.deserialize(deserializationContext, stream)
				genericsIndex -> generics = schema.deserialize(deserializationContext, stream)
				superTypesIndex -> superTypes = schema.deserialize(deserializationContext, stream)
				isDataClassIndex -> isDataClass = schema.deserialize(deserializationContext, stream)
				isValueClassIndex -> isValueClass = schema.deserialize(deserializationContext, stream)
				isSealedIndex -> isSealed = schema.deserialize(deserializationContext, stream)
				primaryConstructorParametersIndex -> primaryConstructorParameters = schema.deserialize(deserializationContext, stream)
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