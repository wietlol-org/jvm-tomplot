package tomplot.pdf.renderers

import org.xhtmlrenderer.pdf.ITextRenderer
import java.io.ByteArrayOutputStream

class FlyingSaucerPdfRenderer : PdfRenderer
{
	override fun render(html: String): ByteArray =
		ByteArrayOutputStream().use { outputStream ->
				val renderer = ITextRenderer()
				val sharedContext = renderer.sharedContext
				sharedContext.isPrint = true
				sharedContext.isInteractive = false
				renderer.setDocumentFromString(html)
				renderer.layout()
				renderer.createPDF(outputStream)
				outputStream.toByteArray()
			}
}
