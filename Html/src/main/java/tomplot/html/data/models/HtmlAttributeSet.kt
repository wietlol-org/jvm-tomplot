package tomplot.html.data.models

import tomplot.css.builders.CssStyleBuilder
import tomplot.css.data.models.CssStyle
import tomplot.css.writers.CssStringWriter
import java.time.ZonedDateTime
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

private val decoratorCache = mutableMapOf<String, ReadWriteProperty<HtmlAttributeSet, *>>()

abstract class HtmlAttributeSet
{
	val map: MutableMap<HtmlName, String> = HashMap()
	
	operator fun get(name: String, namespace: String? = null): String? =
		map[HtmlName(name, namespace)]
	
	operator fun set(name: String, value: String) =
		set(name, null, value)
	
	operator fun set(name: String, namespace: String?, value: String) =
		map.set(HtmlName(name, namespace), value)
	
	fun remove(name: String): String? =
		map.remove(HtmlName(name))
	
	fun containsKey(name: String): Boolean =
		map.containsKey(HtmlName(name))
	
	var accessKey by string("accessKey")
	var `class` by string("class")
	var contentEditable by boolean("contentEditable")
	var dir by string("dir")
	var draggable by string("draggable")
	var enterKeyHint by string("enterkeyhint")
	var hidden by boolean("hidden")
	var id by string("id")
	var inert by boolean("inert")
	var inputMode by string("inputmode")
	var language by string("lang")
	var popover by boolean("popover")
	var spellCheck by boolean("spellcheck")
	var tabIndex by integer("tabindex")
	var title by string("title")
	var translate by string("translate")
	
	var classes: List<String>
		get()
		{
			val value = `class`
			
			return if (value.isNullOrEmpty())
				emptyList()
			else
				value.split(" ")
		}
		set(value)
		{
			`class` = if (value.isEmpty())
				null
			else
				value.joinToString(" ")
		}
	
	private val cssStyle: CssStyle by lazy { CssStyle() }
	fun style(body: CssStyleBuilder.() -> Unit)
	{
		body(CssStyleBuilder(cssStyle))
		set("style", cssWriter.write(cssStyle))
	}
	
	companion object
	{
		private val cssWriter = CssStringWriter()
	}
	
	@Suppress("UNCHECKED_CAST")
	protected fun string(name: String): ReadWriteProperty<HtmlAttributeSet, String?> =
		decoratorCache.computeIfAbsent("string_$name") {
			object : ReadWriteProperty<HtmlAttributeSet, String?>
			{
				override fun getValue(thisRef: HtmlAttributeSet, property: KProperty<*>): String?
				{
					return thisRef[name]
				}
				
				override fun setValue(thisRef: HtmlAttributeSet, property: KProperty<*>, value: String?)
				{
					if (value == null)
						thisRef.remove(name)
					else
						thisRef[name] = value
				}
			}
		} as ReadWriteProperty<HtmlAttributeSet, String?>
	
	@Suppress("UNCHECKED_CAST")
	protected fun integer(name: String): ReadWriteProperty<HtmlAttributeSet, Int?> =
		decoratorCache.computeIfAbsent("integer_$name") {
			object : ReadWriteProperty<HtmlAttributeSet, Int?>
			{
				override fun getValue(thisRef: HtmlAttributeSet, property: KProperty<*>): Int?
				{
					return thisRef[name]?.toInt()
				}
				
				override fun setValue(thisRef: HtmlAttributeSet, property: KProperty<*>, value: Int?)
				{
					if (value == null)
						thisRef.remove(name)
					else
						thisRef[name] = value.toString()
				}
			}
		} as ReadWriteProperty<HtmlAttributeSet, Int?>
	
	@Suppress("UNCHECKED_CAST")
	protected fun double(name: String): ReadWriteProperty<HtmlAttributeSet, Double?> =
		decoratorCache.computeIfAbsent("double_$name") {
			object : ReadWriteProperty<HtmlAttributeSet, Double?>
			{
				override fun getValue(thisRef: HtmlAttributeSet, property: KProperty<*>): Double?
				{
					return thisRef[name]?.toDouble()
				}
				
				override fun setValue(thisRef: HtmlAttributeSet, property: KProperty<*>, value: Double?)
				{
					if (value == null)
						thisRef.remove(name)
					else
						thisRef[name] = value.toString()
				}
			}
		} as ReadWriteProperty<HtmlAttributeSet, Double?>
	
	@Suppress("UNCHECKED_CAST")
	protected fun boolean(name: String): ReadWriteProperty<HtmlAttributeSet, Boolean?> =
		decoratorCache.computeIfAbsent("boolean_$name") {
			object : ReadWriteProperty<HtmlAttributeSet, Boolean?>
			{
				override fun getValue(thisRef: HtmlAttributeSet, property: KProperty<*>): Boolean?
				{
					return thisRef[name]?.toBoolean()
				}
				
				override fun setValue(thisRef: HtmlAttributeSet, property: KProperty<*>, value: Boolean?)
				{
					if (value == null)
						thisRef.remove(name)
					else
						thisRef[name] = value.toString()
				}
			}
		} as ReadWriteProperty<HtmlAttributeSet, Boolean?>
	
	@Suppress("UNCHECKED_CAST")
	protected fun zonedDateTime(name: String): ReadWriteProperty<HtmlAttributeSet, ZonedDateTime?> =
		decoratorCache.computeIfAbsent("zonedDateTime_$name") {
			object : ReadWriteProperty<HtmlAttributeSet, ZonedDateTime?>
			{
				override fun getValue(thisRef: HtmlAttributeSet, property: KProperty<*>): ZonedDateTime?
				{
					return thisRef[name]?.let(ZonedDateTime::parse)
				}
				
				override fun setValue(thisRef: HtmlAttributeSet, property: KProperty<*>, value: ZonedDateTime?)
				{
					if (value == null)
						thisRef.remove(name)
					else
						thisRef[name] = value.toString()
				}
			}
		} as ReadWriteProperty<HtmlAttributeSet, ZonedDateTime?>
}
