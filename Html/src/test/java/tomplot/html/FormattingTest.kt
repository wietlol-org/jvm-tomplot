package tomplot.html

import org.junit.Test
import tomplot.html.engine.HtmlTomplotEngine
import tomplot.html.writers.HtmlStringWriter

class FormattingTest : LocalTestModule()
{
	@Test
	fun `assert that html is formatted correctly`() = unitTest {
		val engine = HtmlTomplotEngine()
		val writer = HtmlStringWriter.ofOptions(
			includeComments = true,
			prettyPrint = true,
		)
		
		val document = engine.createDocument {
			comment("single line text")
			div {
				+"single line text"
			}
			
			comment("multi\nline\ntext")
			div {
				+"multi\nline\ntext"
			}
			div {
				+"multi"
				+"line"
				+"text"
			}
		}
		
		val html = writer.write(document)
		
		assertThat(html).isEqualTo(
			/*language=html*/ """
				<!DOCTYPE html>
				<html>
					<!-- single line text -->
					<div>single line text</div>
					<!--
						multi
						line
						text
					-->
					<div>
						multi
						line
						text
					</div>
					<div>
						multi
						line
						text
					</div>
				</html>
				""".trimIndent()
		)
	}
}
