package tomplot.html

import org.junit.Test
import tomplot.html.engine.HtmlTomplotEngine
import tomplot.html.writers.HtmlStringWriter

class EscapingTest : LocalTestModule()
{
	@Test
	fun `assert that attribute values are escaped`() = unitTest {
		val engine = HtmlTomplotEngine()
		val writer = HtmlStringWriter.ofOptions(
			includeComments = true,
			prettyPrint = true,
		)
		
		val document = engine.createDocument {
			comment("escaped --> comment")
			+"escaped &< text"
			
			rawTag("test tag") {
				attributes {
					set("attribute key", "attribute &\" value")
				}
			}
		}
		
		val html = writer.write(document)
		
		assertThat(html).isEqualTo(
			/*language=html*/ """
				<!DOCTYPE html>
				<html>
					<!-- escaped --|> comment -->
					escaped &amp;&lt; text
					<test_20_tag attribute_20_key="attribute &amp;&quot; value"/>
				</html>
				""".trimIndent()
		)
	}
}
