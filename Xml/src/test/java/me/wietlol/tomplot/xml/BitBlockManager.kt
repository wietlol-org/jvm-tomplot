package me.wietlol.tomplot.xml

import me.wietlol.bitblock.codegenerator.BitModuleProcessor
import me.wietlol.bitblock.codegenerator.generators.kotlin.BitModuleKotlinGenerator
import me.wietlol.bitblock.core.BitSchemaBuilder
import me.wietlol.tomplot.xml.data.TomplotXml
import org.junit.Test
import java.io.File

class BitBlockManager
{
//	@Test
	fun processBitModule()
	{
		BitModuleProcessor.processBitModule(
			File("src/main/resources/me/wietlol/tomplot/xml/TomplotXml.bitmodule"),
			BitModuleKotlinGenerator()
		)
	}
	
//	@Test
	fun generateBitSchema()
	{
		BitSchemaBuilder.buildSchema(
			File("src/main/resources/me/wietlol/tomplot/xml/TomplotXml.bitschema"),
			TomplotXml.modelSerializers
		)
	}
}
