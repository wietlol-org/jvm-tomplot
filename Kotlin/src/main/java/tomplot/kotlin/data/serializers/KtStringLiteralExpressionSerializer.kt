// hash: #dd304f88
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
import tomplot.kotlin.data.builders.KtStringLiteralExpressionBuilder
import tomplot.kotlin.data.models.*
import tomplot.kotlin.data.models.KtStringLiteralExpression
import utils.common.streams.readUnsignedVarInt
import utils.common.streams.writeUnsignedVarInt

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:70v0f9
// @tomplot:customCode:end
// @formatter:off

object KtStringLiteralExpressionSerializer : ModelSerializer<KtStringLiteralExpression, KtStringLiteralExpression>
{
	private val endOfObject: Int = 0
	
	private val valueIndex: Int = 1
	
	private val isTripleQuotedIndex: Int = 2
	
	override val modelId: UUID
		get() = KtStringLiteralExpression.serializationKey
	
	override val dataClass: Class<KtStringLiteralExpression>
		get() = KtStringLiteralExpression::class.java
	
	override fun serialize(serializationContext: SerializationContext, stream: OutputStream, schema: Schema, entity: KtStringLiteralExpression)
	{
		stream.writeUnsignedVarInt(valueIndex)
		schema.serialize(serializationContext, stream, entity.value)
		
		stream.writeUnsignedVarInt(isTripleQuotedIndex)
		schema.serialize(serializationContext, stream, entity.isTripleQuoted)
		
		stream.writeUnsignedVarInt(endOfObject)
	}
	
	override fun deserialize(deserializationContext: DeserializationContext, stream: InputStream, schema: Schema): KtStringLiteralExpression
	{
		var value: String? = null
		var isTripleQuoted: Boolean? = null
		
		while (true)
		{
			when (stream.readUnsignedVarInt())
			{
				endOfObject -> return DefaultKtStringLiteralExpression(
					value!!,
					isTripleQuoted!!,
				)
				valueIndex -> value = schema.deserialize(deserializationContext, stream)
				isTripleQuotedIndex -> isTripleQuoted = schema.deserialize(deserializationContext, stream)
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