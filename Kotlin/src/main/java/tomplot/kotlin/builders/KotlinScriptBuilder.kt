package tomplot.kotlin.builders

import tomplot.kotlin.data.models.DefaultKtScript
import tomplot.kotlin.data.models.KtImport
import tomplot.kotlin.data.models.KtPackage
import tomplot.kotlin.data.models.KtScript
import tomplot.kotlin.data.models.KtScriptMember
import tomplot.kotlin.data.models.KtTemplatedValue

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
