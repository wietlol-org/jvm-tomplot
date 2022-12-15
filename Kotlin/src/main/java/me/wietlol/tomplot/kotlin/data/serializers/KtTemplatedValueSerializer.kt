// hash: #397a7150
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
import me.wietlol.tomplot.kotlin.data.builders.KtTemplatedValueBuilder
import me.wietlol.tomplot.kotlin.data.models.*
import me.wietlol.tomplot.kotlin.data.models.KtTemplatedValue
import me.wietlol.utils.common.streams.readUnsignedVarInt
import me.wietlol.utils.common.streams.writeUnsignedVarInt

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:70v0f9
// @tomplot:customCode:end
// @formatter:off

object KtTemplatedValueSerializer : ModelSerializer<KtTemplatedValue, KtTemplatedValue>
{
	private val endOfObject: Int = 0
	
	private val keyIndex: Int = 1
	
	private val valueProviderIndex: Int = 2
	
	override val modelId: UUID
		get() = KtTemplatedValue.serializationKey
	
	override val dataClass: Class<KtTemplatedValue>
		get() = KtTemplatedValue::class.java
	
	override fun serialize(serializationContext: SerializationContext, stream: OutputStream, schema: Schema, entity: KtTemplatedValue)
	{
		stream.writeUnsignedVarInt(keyIndex)
		schema.serialize(serializationContext, stream, entity.key)
		
		stream.writeUnsignedVarInt(valueProviderIndex)
		schema.serialize(serializationContext, stream, entity.valueProvider)
		
		stream.writeUnsignedVarInt(endOfObject)
	}
	
	override fun deserialize(deserializationContext: DeserializationContext, stream: InputStream, schema: Schema): KtTemplatedValue
	{
		var key: String? = null
		var valueProvider: KtValueProvider? = null
		
		while (true)
		{
			when (stream.readUnsignedVarInt())
			{
				endOfObject -> return DefaultKtTemplatedValue(
					key!!,
					valueProvider!!,
				)
				keyIndex -> key = schema.deserialize(deserializationContext, stream)
				valueProviderIndex -> valueProvider = schema.deserialize(deserializationContext, stream)
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