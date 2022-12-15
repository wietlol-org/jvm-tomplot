package me.wietlol.tomplot.kotlin.builders

import me.wietlol.tomplot.kotlin.data.models.DefaultKtInterface
import me.wietlol.tomplot.kotlin.data.models.KtGenericTypeDeclaration
import me.wietlol.tomplot.kotlin.data.models.KtImport
import me.wietlol.tomplot.kotlin.data.models.KtInterface
import me.wietlol.tomplot.kotlin.data.models.KtInterfaceMember
import me.wietlol.tomplot.kotlin.data.models.KtTemplatedValue
import me.wietlol.tomplot.kotlin.data.models.KtTypeReference
import me.wietlol.tomplot.kotlin.data.models.KtVisibility

class KtInterfaceBuilder(
	var name: String,
	var generics: MutableList<KtGenericTypeDeclaration>,
	var superTypes: MutableList<KtTypeReference>,
	var isSealed: Boolean,
	override var members: MutableList<KtInterfaceMember>,
	var visibility: KtVisibility,
	val rootBuilder: KotlinElementBuilder<*>,
) : KotlinContainerBuilder<KtInterface, KtInterfaceMember>
{
	override val imports: MutableList<KtImport> by rootBuilder::imports
	override val templatedValues: MutableList<KtTemplatedValue> by rootBuilder::templatedValues
	
	override fun build(): KtInterface =
		DefaultKtInterface(
			name,
			generics,
			superTypes,
			isSealed,
			visibility,
			members
		)
}
