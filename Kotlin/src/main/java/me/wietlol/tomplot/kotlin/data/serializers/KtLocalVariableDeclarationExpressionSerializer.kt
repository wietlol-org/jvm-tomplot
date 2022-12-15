// hash: #e8c1bd32
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
import me.wietlol.tomplot.kotlin.data.builders.KtLocalVariableDeclarationExpressionBuilder
import me.wietlol.tomplot.kotlin.data.models.*
import me.wietlol.tomplot.kotlin.data.models.KtLocalVariableDeclarationExpression
import me.wietlol.utils.common.streams.readUnsignedVarInt
import me.wietlol.utils.common.streams.writeUnsignedVarInt

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:70v0f9
// @tomplot:customCode:end
// @formatter:off

object KtLocalVariableDeclarationExpressionSerializer : ModelSerializer<KtLocalVariableDeclarationExpression, KtLocalVariableDeclarationExpression>
{
	private val endOfObject: Int = 0
	
	private val nameIndex: Int = 1
	
	private val upperBoundIndex: Int = 2
	
	private val initialValueIndex: Int = 3
	
	private val isVariableIndex: Int = 4
	
	override val modelId: UUID
		get() = KtLocalVariableDeclarationExpression.serializationKey
	
	override val dataClass: Class<KtLocalVariableDeclarationExpression>
		get() = KtLocalVariableDeclarationExpression::class.java
	
	override fun serialize(serializationContext: SerializationContext, stream: OutputStream, schema: Schema, entity: KtLocalVariableDeclarationExpression)
	{
		stream.writeUnsignedVarInt(nameIndex)
		schema.serialize(serializationContext, stream, entity.name)
		
		entity.upperBound?.also {
			stream.writeUnsignedVarInt(upperBoundIndex)
			schema.serialize(serializationContext, stream, it)
		}
		
		entity.initialValue?.also {
			stream.writeUnsignedVarInt(initialValueIndex)
			schema.serialize(serializationContext, stream, it)
		}
		
		stream.writeUnsignedVarInt(isVariableIndex)
		schema.serialize(serializationContext, stream, entity.isVariable)
		
		stream.writeUnsignedVarInt(endOfObject)
	}
	
	override fun deserialize(deserializationContext: DeserializationContext, stream: InputStream, schema: Schema): KtLocalVariableDeclarationExpression
	{
		var name: String? = null
		var upperBound: KtTypeReference? = null
		var initialValue: KtExpression? = null
		var isVariable: Boolean? = null
		
		while (true)
		{
			when (stream.readUnsignedVarInt())
			{
				endOfObject -> return DefaultKtLocalVariableDeclarationExpression(
					name!!,
					upperBound,
					initialValue,
					isVariable!!,
				)
				nameIndex -> name = schema.deserialize(deserializationContext, stream)
				upperBoundIndex -> upperBound = schema.deserialize(deserializationContext, stream)
				initialValueIndex -> initialValue = schema.deserialize(deserializationContext, stream)
				isVariableIndex -> isVariable = schema.deserialize(deserializationContext, stream)
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
