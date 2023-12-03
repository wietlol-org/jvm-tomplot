package tomplot.xml

import tomplot.core.writers.NoOpWriter
import tomplot.xml.builders.node
import tomplot.xml.builders.text
import tomplot.xml.engine.XmlTomplotEngine
import tomplot.xml.writers.XmlStringWriter
import tomplot.xml.writers.XmlWriterOptions
import org.junit.Test

class XmlTests : LocalTestModule()
{
	@Test
	fun `asser that it works`() = unitTest {
	
		val engine = XmlTomplotEngine(NoOpWriter())
		val writer = XmlStringWriter(XmlWriterOptions())
		
		val document = engine.xmlDocument("root") {
			node("person") {
				node("name") { text("John Doe") }
				node("email") { text("j.doe@gmail.com") }
			}
			node("product") {
				node("code") { text("OP724") }
				node("reserve") { text("200") }
			}
		}
		
		val text = writer.write(document)
		
		assertThat(text)
			.isEqualTo("<root><person><name>John Doe</name><email>j.doe@gmail.com</email></person><product><code>OP724</code><reserve>200</reserve></product></root>")
	}
}
