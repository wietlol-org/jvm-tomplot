package me.wietlol.tomplot.kotlin.builders

import me.wietlol.tomplot.kotlin.data.models.DefaultKtObject
import me.wietlol.tomplot.kotlin.data.models.KtImport
import me.wietlol.tomplot.kotlin.data.models.KtInterfaceMember
import me.wietlol.tomplot.kotlin.data.models.KtObject
import me.wietlol.tomplot.kotlin.data.models.KtObjectMember
import me.wietlol.tomplot.kotlin.data.models.KtTemplatedValue
import me.wietlol.tomplot.kotlin.data.models.KtTypeReference
import me.wietlol.tomplot.kotlin.data.models.KtVisibility

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
