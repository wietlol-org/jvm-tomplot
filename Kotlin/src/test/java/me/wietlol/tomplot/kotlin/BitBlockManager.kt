package me.wietlol.tomplot.kotlin

import me.wietlol.bitblock.codegenerator.BitModuleProcessor
import me.wietlol.bitblock.codegenerator.generators.kotlin.BitModuleKotlinGenerator
import me.wietlol.bitblock.core.BitSchemaBuilder
import me.wietlol.tomplot.kotlin.data.TomplotKotlin
import java.io.File

object BitBlockManager
{
	@JvmStatic
	fun main(args: Array<String>)
	{
		BitModuleProcessor.processBitModule(
			File("Kotlin/src/main/resources/me/wietlol/tomplot/kotlin/TomplotKotlin.bitmodule"),
			BitModuleKotlinGenerator()
		)
		
		BitSchemaBuilder.buildSchema(
			File("Kotlin/src/main/resources/me/wietlol/tomplot/kotlin/TomplotKotlin.bitschema"),
			TomplotKotlin.modelSerializers
		)
	}
}
