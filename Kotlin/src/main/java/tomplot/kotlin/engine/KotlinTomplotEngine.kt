package tomplot.kotlin.engine

import tomplot.api.engine.TomplotEngine
import tomplot.api.writers.TomplotWriter
import tomplot.kotlin.builders.KotlinScriptBuilder
import tomplot.kotlin.data.models.KtElement
import tomplot.kotlin.data.models.KtPackage
import tomplot.kotlin.data.models.KtScript
import tomplot.kotlin.data.models.KtScriptMember
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
