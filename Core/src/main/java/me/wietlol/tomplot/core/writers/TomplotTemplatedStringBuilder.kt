package me.wietlol.tomplot.core.writers

class TomplotTemplatedStringBuilder(
	options: TomplotTemplatedStringBuilderOptions,
	oldOutput: String?,
) : TomplotStringBuilder(options)
{
	companion object
	{
		fun ofOptions(
			commentPrefix: String,
			newLine: String = "\n",
			indent: String = "\t",
			oldOutput: String?,
		) = TomplotTemplatedStringBuilder(TomplotTemplatedStringBuilderOptions(commentPrefix, newLine, indent), oldOutput)
	}
	
	val commentPrefix: String = options.commentPrefix
	private val data: MutableMap<String, String>
	private val customCodeMap: Map<String, List<String>>
	
	init
	{
		val customCodeMap = mutableMapOf<String, List<String>>()
		var isCustomCode = false
		var customCodeList = mutableListOf<String>()
		oldOutput
			?.lines()
			?.forEach {
				when
				{
					it.trim().startsWith("$commentPrefix @tomplot:customCode:start:") ->
					{
						customCodeList = mutableListOf()
						val id = it.replace("$commentPrefix @tomplot:customCode:start:", "").trim()
						customCodeMap[id] = customCodeList
						isCustomCode = true
					}
					it.trim().startsWith("$commentPrefix @tomplot:customCode:end") ->
					{
						isCustomCode = false
					}
					isCustomCode ->
					{
						customCodeList.add(it)
					}
				}
			}
		this.customCodeMap = customCodeMap
		
		data = oldOutput
			?.lines()
			?.asSequence()
			?.filter { it.startsWith("$commentPrefix data: ") }
			?.map { it.replace("$commentPrefix data: ", "") }
			?.map { it.split(":", limit = 2) }
			?.map { it[0] to it[1] }
			?.toMap(HashMap())
			?: mutableMapOf()
	}
	
	override fun toString(): String =
		builder
			.toString()
			.replace(Regex("\u001B([a-zA-Z0-9|._-]+)\u001B")) { data[it.groupValues[1]] ?: it.value }
}
