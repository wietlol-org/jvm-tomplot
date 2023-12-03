package tomplot.kotlin

import bitblock.codegenerator.BitModuleProcessor
import bitblock.codegenerator.generators.kotlin.BitModuleKotlinGenerator
import bitblock.core.BitSchemaBuilder
import tomplot.kotlin.data.TomplotKotlin
import java.io.File

object BitBlockManager
{
	@JvmStatic
	fun main(args: Array<String>)
	{
		BitModuleProcessor.processBitModule(
			File("Kotlin/src/main/resources/tomplot/kotlin/TomplotKotlin.bitmodule"),
			BitModuleKotlinGenerator()
		)
		
		BitSchemaBuilder.buildSchema(
			File("Kotlin/src/main/resources/tomplot/kotlin/TomplotKotlin.bitschema"),
			TomplotKotlin.modelSerializers
		)
	}
}
