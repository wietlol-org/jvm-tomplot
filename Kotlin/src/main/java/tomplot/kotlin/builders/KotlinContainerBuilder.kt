package tomplot.kotlin.builders

import tomplot.kotlin.data.models.DefaultKtComment
import tomplot.kotlin.data.models.DefaultKtCustomCode
import tomplot.kotlin.data.models.DefaultKtProperty
import tomplot.kotlin.data.models.DefaultKtPropertyType.Companion.value
import tomplot.kotlin.data.models.DefaultKtVisibility.Companion.public
import tomplot.kotlin.data.models.KtClass
import tomplot.kotlin.data.models.KtClassMember
import tomplot.kotlin.data.models.KtComment
import tomplot.kotlin.data.models.KtConstructorParameter
import tomplot.kotlin.data.models.KtCustomCode
import tomplot.kotlin.data.models.KtElement
import tomplot.kotlin.data.models.KtExpression
import tomplot.kotlin.data.models.KtFunction
import tomplot.kotlin.data.models.KtGenericTypeDeclaration
import tomplot.kotlin.data.models.KtInterface
import tomplot.kotlin.data.models.KtInterfaceMember
import tomplot.kotlin.data.models.KtObject
import tomplot.kotlin.data.models.KtObjectMember
import tomplot.kotlin.data.models.KtParameter
import tomplot.kotlin.data.models.KtProperty
import tomplot.kotlin.data.models.KtPropertyType
import tomplot.kotlin.data.models.KtTypeReference
import tomplot.kotlin.data.models.KtVisibility

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
