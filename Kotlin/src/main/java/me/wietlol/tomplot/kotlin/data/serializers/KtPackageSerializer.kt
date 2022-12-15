// hash: #041fc36d
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
import me.wietlol.tomplot.kotlin.data.builders.KtPackageBuilder
import me.wietlol.tomplot.kotlin.data.models.*
import me.wietlol.tomplot.kotlin.data.models.KtPackage
import me.wietlol.utils.common.streams.readUnsignedVarInt
import me.wietlol.utils.common.streams.writeUnsignedVarInt

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:70v0f9
// @tomplot:customCode:end
// @formatter:off

object KtPackageSerializer : ModelSerializer<KtPackage, KtPackage>
{
	private val endOfObject: Int = 0
	
	private val pathIndex: Int = 1
	
	override val modelId: UUID
		get() = KtPackage.serializationKey
	
	override val dataClass: Class<KtPackage>
		get() = KtPackage::class.java
	
	override fun serialize(serializationContext: SerializationContext, stream: OutputStream, schema: Schema, entity: KtPackage)
	{
		stream.writeUnsignedVarInt(pathIndex)
		schema.serialize(serializationContext, stream, entity.path)
		
		stream.writeUnsignedVarInt(endOfObject)
	}
	
	override fun deserialize(deserializationContext: DeserializationContext, stream: InputStream, schema: Schema): KtPackage
	{
		var path: MutableList<String>? = mutableListOf()
		
		while (true)
		{
			when (stream.readUnsignedVarInt())
			{
				endOfObject -> return DefaultKtPackage(
					path!!.toMutableList(),
				)
				pathIndex -> path = schema.deserialize(deserializationContext, stream)
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
