package me.wietlol.tomplot.kotlin.builders

import me.wietlol.tomplot.kotlin.data.models.DefaultKtComment
import me.wietlol.tomplot.kotlin.data.models.DefaultKtCustomCode
import me.wietlol.tomplot.kotlin.data.models.DefaultKtProperty
import me.wietlol.tomplot.kotlin.data.models.DefaultKtPropertyType.Companion.value
import me.wietlol.tomplot.kotlin.data.models.DefaultKtVisibility.Companion.public
import me.wietlol.tomplot.kotlin.data.models.KtClass
import me.wietlol.tomplot.kotlin.data.models.KtClassMember
import me.wietlol.tomplot.kotlin.data.models.KtComment
import me.wietlol.tomplot.kotlin.data.models.KtConstructorParameter
import me.wietlol.tomplot.kotlin.data.models.KtCustomCode
import me.wietlol.tomplot.kotlin.data.models.KtElement
import me.wietlol.tomplot.kotlin.data.models.KtExpression
import me.wietlol.tomplot.kotlin.data.models.KtFunction
import me.wietlol.tomplot.kotlin.data.models.KtGenericTypeDeclaration
import me.wietlol.tomplot.kotlin.data.models.KtInterface
import me.wietlol.tomplot.kotlin.data.models.KtInterfaceMember
import me.wietlol.tomplot.kotlin.data.models.KtObject
import me.wietlol.tomplot.kotlin.data.models.KtObjectMember
import me.wietlol.tomplot.kotlin.data.models.KtParameter
import me.wietlol.tomplot.kotlin.data.models.KtProperty
import me.wietlol.tomplot.kotlin.data.models.KtPropertyType
import me.wietlol.tomplot.kotlin.data.models.KtTypeReference
import me.wietlol.tomplot.kotlin.data.models.KtVisibility

interface KotlinContainerBuilder<T : KtElement, E : KtElement> : KotlinElementBuilder<T>
{
	val members: MutableList<E>
}

fun KotlinContainerBuilder<*, in KtComment>.ktComment(
	text: String,
): KtComment =
	ktComment(listOf(text))

fun KotlinContainerBuilder<*, in KtComment>.ktComment(
	text: List<String>,
): KtComment =
	DefaultKtComment(text)
		.also { members.add(it) }

fun KotlinContainerBuilder<*, in KtCustomCode>.ktCustomCode(
	id: String,
): KtCustomCode =
	DefaultKtCustomCode(id)
		.also { members.add(it) }

fun KotlinContainerBuilder<*, in KtProperty>.ktProperty(
	name: String,
	upperBound: KtTypeReference,
	type: KtPropertyType = value,
	isOverride: Boolean = false,
	visibility: KtVisibility = public,
	getter: KtExpression? = null,
	initialValue: KtExpression? = null
): KtProperty =
	DefaultKtProperty(name, type, isOverride, upperBound, getter, visibility, initialValue)
		.also { members.add(it) }

fun KotlinContainerBuilder<*, in KtFunction>.ktFunction(
	name: String,
	parameters: List<KtParameter> = emptyList(),
	returnType: KtTypeReference? = null,
	isOverride: Boolean = false,
	isExpressionBody: Boolean = false,
	visibility: KtVisibility = public,
	body: KtFunctionBuilder.() -> Unit,
): KtFunction =
	KtFunctionBuilder(name, parameters.toMutableList(), returnType, null, isOverride, isExpressionBody, visibility, this)
		.apply(body)
		.build()
		.also { members.add(it) }

fun KotlinContainerBuilder<*, in KtInterface>.ktInterface(
	name: String,
	generics: List<KtGenericTypeDeclaration> = emptyList(),
	superTypes: List<KtTypeReference> = emptyList(),
	members: List<KtInterfaceMember> = emptyList(),
	visibility: KtVisibility = public,
	body: KtInterfaceBuilder.() -> Unit
): KtInterface =
	KtInterfaceBuilder(name, generics.toMutableList(), superTypes.toMutableList(), false, members.toMutableList(), visibility, this)
		.apply(body)
		.build()
		.also { this.members.add(it) }

fun KotlinContainerBuilder<*, in KtObject>.ktCompanionObject(
	name: String? = null,
	superTypes: List<KtTypeReference> = emptyList(),
	members: List<KtObjectMember> = emptyList(),
	body: KtObjectBuilder.() -> Unit
): KtObject =
	KtObjectBuilder(name, superTypes.toMutableList(), true, public, members.toMutableList(), this)
		.apply(body)
		.build()
		.also { this.members.add(it) }

fun KotlinContainerBuilder<*, in KtObject>.ktObject(
	name: String,
	superTypes: List<KtTypeReference> = emptyList(),
	members: List<KtObjectMember> = emptyList(),
	visibility: KtVisibility = public,
	body: KtObjectBuilder.() -> Unit
): KtObject =
	KtObjectBuilder(name, superTypes.toMutableList(), false, visibility, members.toMutableList(), this)
		.apply(body)
		.build()
		.also { this.members.add(it) }

fun KotlinContainerBuilder<*, in KtClass>.ktClass(
	name: String,
	generics: List<KtGenericTypeDeclaration> = emptyList(),
	superTypes: List<KtTypeReference> = emptyList(),
	isDataClass: Boolean = false,
	primaryConstructorParameters: List<KtConstructorParameter> = emptyList(),
	members: List<KtClassMember> = emptyList(),
	visibility: KtVisibility = public,
	body: KtClassBuilder.() -> Unit
): KtClass =
	KtClassBuilder(name, generics.toMutableList(), superTypes.toMutableList(), isDataClass, false, false, primaryConstructorParameters.toMutableList(), members.toMutableList(), visibility, this)
		.apply(body)
		.build()
		.also { this.members.add(it) }
