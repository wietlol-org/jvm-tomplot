package tomplot.kotlin.utils

object PathParser
{
	fun parsePath(path: String): List<String> =
		readNames(path).toList()
	
	private fun readNames(path: String) = sequence {
		var remainingPath = path
		do
		{
			val isEscaped = remainingPath.startsWith("`")
			
			val head: Int = if (isEscaped) 1 else 0
			
			val tail: Int = remainingPath.indexOf('.', if (isEscaped) remainingPath.indexOf('`', head) else 0)
			
			val hasMore: Boolean = tail > 0
			
			val endIndex = (if (hasMore) tail else remainingPath.length)
				.minus(if (isEscaped) 1 else 0)
			
			val name: String = remainingPath.substring(head, endIndex)
			
			yield(name)
			remainingPath = remainingPath.substring(tail + 1)
		} while (hasMore)
	}
}
