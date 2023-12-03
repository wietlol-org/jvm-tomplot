package tomplot.pdf.renderers

interface PdfRenderer
{
	fun render(html: String): ByteArray
}
