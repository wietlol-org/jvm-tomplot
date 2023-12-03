package tomplot.kotlin.builders

import tomplot.kotlin.data.models.DefaultKtObject
import tomplot.kotlin.data.models.KtImport
import tomplot.kotlin.data.models.KtInterfaceMember
import tomplot.kotlin.data.models.KtObject
import tomplot.kotlin.data.models.KtObjectMember
import tomplot.kotlin.data.models.KtTemplatedValue
import tomplot.kotlin.data.models.KtTypeReference
import tomplot.kotlin.data.models.KtVisibility

class KtObjectBuilder(
	var name: String?,
	var superTypes: MutableList<KtTypeReference>,
	var isCompanion: Boolean,
	var visibility: KtVisibility,
	override var members: MutableList<KtObjectMember>,
	val rootBuilder: KotlinElementBuilder<*>,
) : KotlinContainerBuilder<KtObject, KtObjectMember>
{
	override val imports: MutableList<KtImport> by rootBuilder::imports
	override val templatedValues: MutableList<KtTemplatedValue> by rootBuilder::templatedValues
	
	override fun build(): KtObject =
		DefaultKtObject(
			name,
			superTypes,
			isCompanion,
			visibility,
			members,
		)
}
