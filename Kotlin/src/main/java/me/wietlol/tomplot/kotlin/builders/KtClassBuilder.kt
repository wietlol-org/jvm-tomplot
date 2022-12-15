package me.wietlol.tomplot.kotlin.builders

import me.wietlol.tomplot.kotlin.data.models.DefaultKtClass
import me.wietlol.tomplot.kotlin.data.models.KtClass
import me.wietlol.tomplot.kotlin.data.models.KtClassMember
import me.wietlol.tomplot.kotlin.data.models.KtConstructorParameter
import me.wietlol.tomplot.kotlin.data.models.KtGenericTypeDeclaration
import me.wietlol.tomplot.kotlin.data.models.KtImport
import me.wietlol.tomplot.kotlin.data.models.KtTemplatedValue
import me.wietlol.tomplot.kotlin.data.models.KtTypeReference
import me.wietlol.tomplot.kotlin.data.models.KtVisibility

class KtClassBuilder(
	var name: String,
	var generics: MutableList<KtGenericTypeDeclaration>,
	var superTypes: MutableList<KtTypeReference>,
	var isDataClass: Boolean,
	var isValueClass: Boolean,
	var isSealed: Boolean,
	var primaryConstructorParameters: MutableList<KtConstructorParameter>,
	override var members: MutableList<KtClassMember>,
	var visibility: KtVisibility,
	val rootBuilder: KotlinElementBuilder<*>,
) : KotlinContainerBuilder<KtClass, KtClassMember>
{
	override val imports: MutableList<KtImport> by rootBuilder::imports
	override val templatedValues: MutableList<KtTemplatedValue> by rootBuilder::templatedValues
	
	override fun build(): KtClass =
		DefaultKtClass(
			name,
			generics,
			superTypes,
			isDataClass,
			isValueClass,
			isSealed,
			primaryConstructorParameters,
			visibility,
			members
		)
}
