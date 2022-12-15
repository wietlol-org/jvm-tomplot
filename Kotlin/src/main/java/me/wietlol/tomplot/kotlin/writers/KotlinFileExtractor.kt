package me.wietlol.tomplot.kotlin.writers

import me.wietlol.tomplot.kotlin.data.models.KtScript
import java.io.File

object KotlinFileExtractor
{
	fun extractFile(element: KtScript): File
	{
		val root = File(element.sourceFolder)
		val path = element.`package`?.path ?: emptyList()
		
		return path.fold(root) { parent, childName -> parent.resolve(childName) }
			.resolve(element.name + ".kt")
	}
}
