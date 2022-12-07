package me.wietlol.tomplot.core.writers

open class TomplotStringBuilder(
	options: TomplotStringBuilderOptions,
)
{
	companion object
	{
		fun ofOptions(
			newLine: String = "\n",
			indent: String = "\t",
		) = TomplotStringBuilder(TomplotStringBuilderOptions(newLine, indent))
	}
	
	val newLine: String = options.newLine
	val indent: String = options.indent
	
	protected val builder = StringBuilder()
	private var indents = 0
	private var isNewLine = false
	
	fun append(text: String)
	{
		applyIndentsIfNecessary()
		builder.append(text)
	}
	
	fun appendLine(text: String? = null)
	{
		applyIndentsIfNecessary()
		appendLineNoIndents(text)
	}
	
	fun appendLineNoIndents(text: String? = null)
	{
		if (text != null)
			builder.append(text)
		builder.append(newLine)
		isNewLine = true
	}
	
	fun indented(body: () -> Unit)
	{
		indents++
		body()
		indents--
	}
	
	private fun applyIndentsIfNecessary()
	{
		if (isNewLine)
		{
			builder.append(indent.repeat(indents))
			isNewLine = false
		}
	}
	
	fun <T> appendJoin(items: Iterable<T>, infix: String = newLine, action: (T) -> Unit)
	{
		var isFirst = true
		
		val isNewLine = infix.endsWith(newLine)
		val realInfix = if (isNewLine)
			infix.substring(0, infix.length - newLine.length)
		else
			infix
		
		items.forEach {
			when
			{
				isFirst -> isFirst = false
				isNewLine -> appendLine(realInfix)
				else -> append(realInfix)
			}
			action(it)
		}
	}
	
	override fun toString(): String =
		builder.toString()
}
