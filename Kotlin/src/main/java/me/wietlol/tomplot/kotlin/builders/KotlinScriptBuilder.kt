package me.wietlol.tomplot.kotlin.builders

import me.wietlol.tomplot.kotlin.data.models.DefaultKtScript
import me.wietlol.tomplot.kotlin.data.models.KtImport
import me.wietlol.tomplot.kotlin.data.models.KtPackage
import me.wietlol.tomplot.kotlin.data.models.KtScript
import me.wietlol.tomplot.kotlin.data.models.KtScriptMember
import me.wietlol.tomplot.kotlin.data.models.KtTemplatedValue

class KotlinScriptBuilder(
	var name: String,
	var `package`: KtPackage?,
	override var imports: MutableList<KtImport>,
	override var templatedValues: MutableList<KtTemplatedValue>,
	override var members: MutableList<KtScriptMember>,
	var sourceFolder: String,
) : KotlinContainerBuilder<KtScript, KtScriptMember>
{
	override fun build(): KtScript =
		DefaultKtScript(
			name,
			`package`,
			imports,
			templatedValues,
			members,
			sourceFolder
		)
}
