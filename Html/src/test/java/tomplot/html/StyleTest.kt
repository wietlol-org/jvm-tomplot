package tomplot.html

import org.junit.Test
import tomplot.html.engine.HtmlTomplotEngine
import tomplot.html.writers.HtmlStringWriter

class StyleTest : LocalTestModule()
{
	@Test
	fun `assert that style is applied`() =
		unitTest {
			val engine = HtmlTomplotEngine()
			val writer = HtmlStringWriter.ofOptions(
				includeComments = true,
				prettyPrint = true,
			)
			
			val document = engine.createDocument {
				div {
					attributes {
						style {
							backgroundColor = red
							color = black
						}
					}
				}
			}
			
			val html = writer.write(document)
			
			assertThat(html).isEqualTo(
				/*language=html*/ """
					<!DOCTYPE html>
					<html>
						<div style="background-color: #ff0000;color: #000000;"/>
					</html>
				""".trimIndent()
			)
		}
}
