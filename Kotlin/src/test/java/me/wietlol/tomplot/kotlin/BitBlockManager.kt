package me.wietlol.tomplot.kotlin

import me.wietlol.bitblock.codegenerator.BitModuleProcessor
import me.wietlol.bitblock.codegenerator.generators.kotlin.BitModuleKotlinGenerator
import me.wietlol.bitblock.core.BitSchemaBuilder
import me.wietlol.tomplot.kotlin.data.TomplotKotlin
import org.junit.Test
import java.io.File

class BitBlockManager
{
//	@Test
	fun processBitModule()
	{
		BitModuleProcessor.processBitModule(
			File("src/main/resources/me/wietlol/tomplot/kotlin/TomplotKotlin.bitmodule"),
			BitModuleKotlinGenerator()
		)
	}
	
//	@Test
	fun generateBitSchema()
	{
		BitSchemaBuilder.buildSchema(
			File("src/main/resources/me/wietlol/tomplot/kotlin/TomplotKotlin.bitschema"),
			TomplotKotlin.modelSerializers
		)
	}
}
