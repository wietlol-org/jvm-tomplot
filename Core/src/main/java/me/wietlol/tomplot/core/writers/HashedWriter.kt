package me.wietlol.tomplot.core.writers

import me.wietlol.tomplot.api.writers.TomplotWriter
import java.nio.ByteBuffer

class HashedWriter<T>(
	val innerWriter: TomplotWriter<T, String>,
	val commentPrefix: String = "//",
) : TomplotWriter<T, String>
{
	override fun write(component: T, oldComponent: String?): String
	{
		if (oldComponent != null)
		{
			val storedHash = oldComponent
				.lines()
				.firstOrNull { it.startsWith("$commentPrefix hash: #") }
				?.replace("$commentPrefix hash: #", "")
			
			if (storedHash != null)
			{
				val generatedHash = generateHash(oldComponent)
				if (storedHash != generatedHash)
					throw HashMismatchException(storedHash, generatedHash)
			}
		}
		
		val text: String = innerWriter.write(component, oldComponent)
		val hash: String = generateHashStatement(text)
		
		return hash + text
	}
	
	private fun generateHashStatement(code: String): String
	{
		val newHash = generateHash(code)
		
		return "$commentPrefix hash: #$newHash\r\n"
	}
	
	private fun generateHash(code: String): String =
		code
			.lines()
			.asSequence()
			.map { it.trim() }
			.filter(customCodeFilter())
			.filter { it.startsWith(commentPrefix).not() }
			.filter { it.isNotEmpty() }
			.joinToString("")
			.replace(Regex("\\s"), "")
			.simpleHashCode()
			.hashToString()
	
	private fun String.simpleHashCode(): Int =
		toCharArray()
			.map { it.toInt() }
			.fold(0) { l, r -> l * 31 + r }
	
	private fun Int.hashToString(): String =
		ByteBuffer
			.allocate(4)
			.also { it.putInt(this) }
			.array()
			.joinToString("") { String.format("%02x", it) }
	
	private fun customCodeFilter(): (String) -> Boolean
	{
		var isCustomCode = false
		
		return {
			when
			{
				it.startsWith("$commentPrefix @tomplot:customCode:start") -> isCustomCode = true
				it.startsWith("$commentPrefix @tomplot:customCode:end") -> isCustomCode = false
			}
			
			!isCustomCode
		}
	}
}
