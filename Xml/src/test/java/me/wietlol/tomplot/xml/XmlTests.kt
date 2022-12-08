package me.wietlol.tomplot.xml

import me.wietlol.tomplot.core.writers.NoOpWriter
import me.wietlol.tomplot.xml.builders.node
import me.wietlol.tomplot.xml.builders.text
import me.wietlol.tomplot.xml.engine.XmlTomplotEngine
import me.wietlol.tomplot.xml.writers.XmlStringWriter
import me.wietlol.tomplot.xml.writers.XmlWriterOptions
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
