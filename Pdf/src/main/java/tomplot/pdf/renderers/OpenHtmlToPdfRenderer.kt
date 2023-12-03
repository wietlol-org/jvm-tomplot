package tomplot.pdf.renderers

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder
import java.io.ByteArrayOutputStream

class OpenHtmlToPdfRenderer : PdfRenderer
{
	override fun render(html: String): ByteArray =
		ByteArrayOutputStream().use { outputStream ->
			val builder = PdfRendererBuilder()
			builder.useFastMode()
			builder.withHtmlContent(html, "http://localhost/")
			builder.toStream(outputStream)
			builder.run()
			outputStream.toByteArray()
		}
}
