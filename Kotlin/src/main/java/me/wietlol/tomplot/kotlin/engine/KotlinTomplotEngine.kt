package me.wietlol.tomplot.kotlin.engine

import me.wietlol.tomplot.api.engine.TomplotEngine
import me.wietlol.tomplot.api.writers.TomplotWriter
import me.wietlol.tomplot.kotlin.builders.KotlinScriptBuilder
import me.wietlol.tomplot.kotlin.data.models.KtElement
import me.wietlol.tomplot.kotlin.data.models.KtPackage
import me.wietlol.tomplot.kotlin.data.models.KtScript
import me.wietlol.tomplot.kotlin.data.models.KtScriptMember
import java.io.File

class KotlinTomplotEngine<O>(
	override val writer: TomplotWriter<KtScript, O>
) : TomplotEngine<KtScript, O>
{
	fun createScript(
		name: String,
		sourceFolder: File,
		`package`: KtPackage? = null,
		members: List<KtScriptMember> = emptyList(),
		body: KotlinScriptBuilder.() -> Unit
	): KtScript =
		createScript(name, sourceFolder.absolutePath, `package`, members, body)
	
	fun createScript(
		name: String,
		sourceFolder: String,
		`package`: KtPackage? = null,
		members: List<KtScriptMember> = emptyList(),
		body: KotlinScriptBuilder.() -> Unit
	): KtScript =
		KotlinScriptBuilder(
			name,
			`package`,
			mutableListOf(),
			mutableListOf(),
			members.toMutableList(),
			sourceFolder
		)
			.apply(body)
			.build()
			.also { writer.write(it) }
}
