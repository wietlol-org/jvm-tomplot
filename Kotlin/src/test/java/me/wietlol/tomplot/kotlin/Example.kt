package me.wietlol.tomplot.kotlin

import me.wietlol.tomplot.core.writers.FileWriter
import me.wietlol.tomplot.core.writers.NoOpWriter
import me.wietlol.tomplot.kotlin.builders.*
import me.wietlol.tomplot.kotlin.engine.KotlinTomplotEngine
import me.wietlol.tomplot.kotlin.writers.KotlinStringWriter
import me.wietlol.tomplot.kotlin.writers.KotlinWriterOptions
import me.wietlol.tomplot.kotlin.writers.KotlinFileExtractor
import me.wietlol.tomplot.core.writers.HashedWriter
import java.util.*

object Example
{
	@JvmStatic
	fun main(args: Array<String>)
	{
		val engine = KotlinTomplotEngine(NoOpWriter())
		val writer = KotlinStringWriter(KotlinWriterOptions())
			.let { HashedWriter(it) }
			.let { FileWriter(it, KotlinFileExtractor::extractFile) }
		
		val script = engine.createScript("test", "/src") {
			`package` = ktPackage("example.package")
			
			ktImport("me.wietlol.utils.common.emptyHashCode")
			ktImport("me.wietlol.utils.common.with")
			ktImport("me.wietlol.utils.common.toJsonString")
			
			ktCustomCode("gAeCSq")
			
			ktInterface("Example") {
				ktCompanionObject {
					ktProperty(
						"serializationKey",
						ktImportedTypeReference(UUID::class),
						getter = ktRawCodeExpression("UUID.fromString(\"${ktTemplated("serializationKey") { UUID.randomUUID().toString() }}\")")
					)
				}
				
				ktProperty(
					"serializationKey",
					ktImportedTypeReference(UUID::class),
					isOverride = true,
					getter = ktRawCodeExpression("Companion.serializationKey")
				)
				
				ktProperty(
					"name",
					ktImportedTypeReference("String"),
					isOverride = false,
				)
				ktProperty(
					"value",
					ktImportedTypeReference("String"),
					isOverride = false,
				)
				
				val extendedProperties = listOf("foo", "bar", "baz")
				ktFunction("isEqualTo") {
					parameters = mutableListOf(
						ktParameter("other", ktImportedTypeReference(Any::class).nullable())
					)
					returnType = ktImportedTypeReference(Boolean::class)
					
					body = mutableListOf(
						ktRawCodeExpression("if (this === other) return true"),
						ktRawCodeExpression("if (other == null) return false"),
						ktRawCodeExpression("if (other !is Example) return false"),
						ktRawCodeExpression(""),
						*extendedProperties.map {
							ktRawCodeExpression("if ($it != other.$it) return false")
						}.toTypedArray(),
						ktRawCodeExpression(""),
						ktRawCodeExpression("return true"),
					)
				}
				
				ktFunction("computeHashCode") {
					returnType = ktImportedTypeReference(Int::class)
					
					isExpressionBody = true
					body = mutableListOf(
						ktNameExpression("emptyHashCode"),
						*extendedProperties.map {
							ktRawCodeExpression("\t.with(${it})")
						}.toTypedArray(),
					)
				}
				
				ktFunction("toJson") {
					returnType = ktImportedTypeReference(String::class)
					isOverride = true
					
					isExpressionBody = true
					
					body = mutableListOf(
						ktRawCodeExpression(
							"\"\"\"{${extendedProperties.asSequence().map { "\"${it}\":\${${it}.toJsonString()}" }.joinToString(",")}}\"\"\"",
						)
					)
				}
				
				ktFunction("duplicate") {
					returnType = ktDirectTypeReference("Example")
					isOverride = true
				}
				
				ktCustomCode("32T3K8")
			}
			ktInterface("Example") {
				ktCompanionObject {
					ktProperty(
						"serializationKey",
						ktImportedTypeReference(UUID::class),
						getter = ktRawCodeExpression("UUID.fromString(\"${ktTemplated("serializationKey") { UUID.randomUUID().toString() }}\")")
					)
				}
				
				ktProperty(
					"serializationKey",
					ktImportedTypeReference(UUID::class),
					isOverride = true,
					getter = ktRawCodeExpression("Companion.serializationKey")
				)
				
				ktProperty(
					"name",
					ktImportedTypeReference("String"),
					isOverride = false,
				)
				ktProperty(
					"value",
					ktImportedTypeReference("String"),
					isOverride = false,
				)
				
				val extendedProperties = listOf("foo", "bar", "baz")
				ktFunction("isEqualTo") {
					parameters = mutableListOf(
						ktParameter("other", ktImportedTypeReference(Any::class).nullable())
					)
					returnType = ktImportedTypeReference(Boolean::class)
					
					body = mutableListOf(
						ktRawCodeExpression("if (this === other) return true"),
						ktRawCodeExpression("if (other == null) return false"),
						ktRawCodeExpression("if (other !is Example) return false"),
						ktRawCodeExpression(""),
						*extendedProperties.map {
							ktRawCodeExpression("if ($it != other.$it) return false")
						}.toTypedArray(),
						ktRawCodeExpression(""),
						ktRawCodeExpression("return true"),
					)
				}
				
				ktFunction("computeHashCode") {
					returnType = ktImportedTypeReference(Int::class)
					
					isExpressionBody = true
					body = mutableListOf(
						ktNameExpression("emptyHashCode"),
						*extendedProperties.map {
							ktRawCodeExpression("\t.with(${it})")
						}.toTypedArray(),
					)
				}
				
				ktFunction("toJson") {
					returnType = ktImportedTypeReference(String::class)
					isOverride = true
					
					isExpressionBody = true
					
					body = mutableListOf(
						ktRawCodeExpression(
							"\"\"\"{${extendedProperties.asSequence().map { "\"${it}\":\${${it}.toJsonString()}" }.joinToString(",")}}\"\"\"",
						)
					)
				}
				
				ktFunction("duplicate") {
					returnType = ktDirectTypeReference("Example")
					isOverride = true
				}
				
				ktCustomCode("32T3K8")
			}
		}
		
		val text = writer.write(script)
		
		println(text)
	}
}
