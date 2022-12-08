package me.wietlol.tomplot.xml.data.models

class XmlAttributeSet : Collection<Pair<XmlName, String>>
{
	override var size: Int = 0
		private set
	
	private val data: MutableMap<XmlName, MutableList<String>> = hashMapOf()
	
	operator fun set(name: String, namespace: String?, value: String) =
		set(DefaultXmlName(name, namespace), value)
	
	operator fun set(name: XmlName, value: String)
	{
		val existing = data[name]
		if (existing != null)
			size -= existing.size
		
		data[name] = mutableListOf(value)
		size += 1
	}
	
	operator fun plusAssign(entry: Triple<String, String, String?>) =
		add(entry)
	
	@JvmName("plusAssignRaw")
	operator fun plusAssign(entry: Pair<String, String>) =
		add(entry)
	
	operator fun plusAssign(entry: Pair<XmlName, String>) =
		add(entry)
	
	fun add(entry: Triple<String, String, String?>) =
		add(DefaultXmlName(entry.first, entry.third), entry.second)
	
	@JvmName("addRaw")
	fun add(entry: Pair<String, String>) =
		add(entry.first, entry.second)
	
	fun add(entry: Pair<XmlName, String>) =
		add(entry.first, entry.second)
	
	fun add(name: String, value: String, namespace: String? = null) =
		add(DefaultXmlName(name, namespace), value)
	
	fun add(name: XmlName, value: String)
	{
		data.computeIfAbsent(name) { mutableListOf() }.add(value)
		size += 1
	}
	
	operator fun get(name: String, namespace: String?): List<String>? =
		data[DefaultXmlName(name, namespace)]
	
	operator fun get(name: XmlName): List<String>? =
		data[name]
	
	fun getFirst(name: String, namespace: String?): String? =
		getFirst(DefaultXmlName(name, namespace))
	
	fun getFirst(name: XmlName): String? =
		get(name)?.firstOrNull()
	
	companion object
	{
		@JvmName("ofRaw")
		fun of(vararg values: Pair<String, String>): XmlAttributeSet =
			of(*values.map { DefaultXmlName(it.first) to it.second }.toTypedArray())
		
		fun of(vararg values: Pair<XmlName, String>): XmlAttributeSet =
			XmlAttributeSet().apply {
				values.forEach(::add)
			}
	}
	
	override fun isEmpty(): Boolean =
		size == 0
	
	override fun iterator(): Iterator<Pair<XmlName, String>> =
		data
			.flatMap { (key, value) -> value.map { key to it } }
			.iterator()
	
	override fun containsAll(elements: Collection<Pair<XmlName, String>>): Boolean =
		elements.all(::contains)
	
	override fun contains(element: Pair<XmlName, String>): Boolean =
		data[element.first].isNullOrEmpty().not()
	
	fun duplicate(): XmlAttributeSet
	{
		val newSet = XmlAttributeSet()
		forEach { newSet.add(it) }
		return newSet
	}
	
	fun toJsonString(): String
	{
		// todo
		return "{}"
	}
}
