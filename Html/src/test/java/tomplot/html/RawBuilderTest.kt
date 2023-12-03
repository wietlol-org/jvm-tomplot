package tomplot.html

import org.junit.Test
import tomplot.html.engine.HtmlTomplotEngine
import tomplot.html.writers.HtmlStringWriter

// show that tags, attributes, and style are all possible without prebuilt functions
class RawBuilderTest : LocalTestModule()
{
	@Test
	fun `assert that html is formatted correctly`() = unitTest {
		val engine = HtmlTomplotEngine()
		val writer = HtmlStringWriter.ofOptions(
			includeComments = true,
			prettyPrint = true,
		)
		
		val document = engine.createDocument {
			rawTag("div") {
				attributes {
					id = "root"
				}
				
				rawTag("span") {
					attributes {
						style {
							rawProperty("background-color", "red")
						}
					}
				}
			}
		}
		
		val html = writer.write(document)
		
		assertThat(html).isEqualTo(
			/*language=html*/ """
				<!DOCTYPE html>
				<html>
					<div id="root">
						<span style="background-color: red;"/>
					</div>
				</html>
				""".trimIndent()
		)
	}
}
