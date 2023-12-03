package tomplot.css

import org.jsoup.Jsoup
import org.junit.Test

class CodeGenerator : LocalTestModule()
{
//	@Test
	fun foo() = unitTest {
		val reference = javaClass.getResourceAsStream("/tomplot/css/CssReference.html")!!
			.reader()
			.readText()
		
		val doc = Jsoup.parse(reference)
		
		println()
		println()
		println()
		doc.select("tr").forEach {
			val data = it.select("td")
			val name = data[0].text()
			val kotlinName = convertToKotlinName(name)
			val kotlinType = "CssProperty${kotlinName.replaceFirstChar(Char::uppercase)}"
			val description = data[1].text()
			
			generateProperty(name, kotlinName, kotlinType, description, false)
//			generatePropertyInterface(kotlinType)
		}
		println()
		println()
		println()
	}
	
	private fun generateProperty(name: String, kotlinName: String, kotlinType: String, description: String, addDoc: Boolean)
	{
		if (addDoc)
		{
			println("\t")
			println("\t/**")
			println("\t * $description")
			println("\t */")
		}
		println("\tvar $kotlinName: $kotlinType? by named(\"$name\")")
		
	}
	
	private fun generatePropertyInterface(name: String)
	{
		println("interface $name : CssValue")
	}
	
	private fun convertToKotlinName(cssName: String): String =
		cssName.replace(Regex("-\\w")) {
			it.value.last().uppercase()
		}.replace("@", "")
}
