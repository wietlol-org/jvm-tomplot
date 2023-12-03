package tomplot.xml

import bitblock.codegenerator.BitModuleProcessor
import bitblock.codegenerator.generators.kotlin.BitModuleKotlinGenerator
import bitblock.core.BitSchemaBuilder
import tomplot.xml.data.TomplotXml
import java.io.File

object BitBlockManager
{
	@JvmStatic
	fun main(args: Array<String>)
	{
		BitModuleProcessor.processBitModule(
			File("Xml/src/main/resources/tomplot/xml/TomplotXml.bitmodule"),
			BitModuleKotlinGenerator()
		)
		
		BitSchemaBuilder.buildSchema(
			File("Xml/src/main/resources/tomplot/xml/TomplotXml.bitschema"),
			TomplotXml.modelSerializers
		)
	}
}
