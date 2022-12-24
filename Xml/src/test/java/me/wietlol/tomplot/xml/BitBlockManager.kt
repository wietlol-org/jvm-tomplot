package me.wietlol.tomplot.xml

import me.wietlol.bitblock.codegenerator.BitModuleProcessor
import me.wietlol.bitblock.codegenerator.generators.kotlin.BitModuleKotlinGenerator
import me.wietlol.bitblock.core.BitSchemaBuilder
import me.wietlol.tomplot.xml.data.TomplotXml
import java.io.File

object BitBlockManager
{
	@JvmStatic
	fun main(args: Array<String>)
	{
		BitModuleProcessor.processBitModule(
			File("Xml/src/main/resources/me/wietlol/tomplot/xml/TomplotXml.bitmodule"),
			BitModuleKotlinGenerator()
		)
		
		BitSchemaBuilder.buildSchema(
			File("Xml/src/main/resources/me/wietlol/tomplot/xml/TomplotXml.bitschema"),
			TomplotXml.modelSerializers
		)
	}
}
