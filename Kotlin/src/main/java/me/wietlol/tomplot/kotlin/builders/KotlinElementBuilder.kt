package me.wietlol.tomplot.kotlin.builders

import me.wietlol.tomplot.api.builder.TomplotBuilder
import me.wietlol.tomplot.kotlin.data.models.DefaultKtConstructorParameter
import me.wietlol.tomplot.kotlin.data.models.DefaultKtDirectGenericTypeArgument
import me.wietlol.tomplot.kotlin.data.models.DefaultKtDirectTypeReference
import me.wietlol.tomplot.kotlin.data.models.DefaultKtFunctionTypeReference
import me.wietlol.tomplot.kotlin.data.models.DefaultKtGenericTypeDeclaration
import me.wietlol.tomplot.kotlin.data.models.DefaultKtNameExpression
import me.wietlol.tomplot.kotlin.data.models.DefaultKtPackage
import me.wietlol.tomplot.kotlin.data.models.DefaultKtParameter
import me.wietlol.tomplot.kotlin.data.models.DefaultKtRawCodeExpression
import me.wietlol.tomplot.kotlin.data.models.DefaultKtStarGenericTypeArgument
import me.wietlol.tomplot.kotlin.data.models.DefaultKtStringLiteralExpression
import me.wietlol.tomplot.kotlin.data.models.KtConstructorParameter
import me.wietlol.tomplot.kotlin.data.models.KtDirectGenericTypeArgument
import me.wietlol.tomplot.kotlin.data.models.KtDirectTypeReference
import me.wietlol.tomplot.kotlin.data.models.KtElement
import me.wietlol.tomplot.kotlin.data.models.KtExpression
import me.wietlol.tomplot.kotlin.data.models.KtFunctionTypeReference
import me.wietlol.tomplot.kotlin.data.models.KtGenericTypeArgument
import me.wietlol.tomplot.kotlin.data.models.KtGenericTypeDeclaration
import me.wietlol.tomplot.kotlin.data.models.KtImport
import me.wietlol.tomplot.kotlin.data.models.KtNameExpression
import me.wietlol.tomplot.kotlin.data.models.KtPackage
import me.wietlol.tomplot.kotlin.data.models.KtParameter
import me.wietlol.tomplot.kotlin.data.models.KtPropertyType
import me.wietlol.tomplot.kotlin.data.models.KtRawCodeExpression
import me.wietlol.tomplot.kotlin.data.models.KtStarGenericTypeArgument
import me.wietlol.tomplot.kotlin.data.models.KtStringLiteralExpression
import me.wietlol.tomplot.kotlin.data.models.KtTemplatedValue
import me.wietlol.tomplot.kotlin.data.models.KtTypeReference
import me.wietlol.tomplot.kotlin.utils.PathParser

@KotlinBuilderMarker
interface KotlinElementBuilder<T : KtElement> : TomplotBuilder<T>
{
	val imports: MutableList<KtImport>
	val templatedValues: MutableList<KtTemplatedValue>
}

fun ktPackage(path: String): KtPackage =
	ktPackage(PathParser.parsePath(path))

fun ktPackage(path: List<String>): KtPackage =
	DefaultKtPackage(path)

fun ktDirectTypeReference(
	path: String,
	genericTypeArguments: List<KtGenericTypeArgument> = emptyList(),
	isNullable: Boolean = false
): KtDirectTypeReference =
	ktDirectTypeReference(PathParser.parsePath(path), genericTypeArguments, isNullable)

fun ktDirectTypeReference(
	path: List<String>,
	genericTypeArguments: List<KtGenericTypeArgument> = emptyList(),
	isNullable: Boolean = false
): KtDirectTypeReference =
	DefaultKtDirectTypeReference(path, genericTypeArguments, isNullable)

fun ktFunctionTypeReference(
	parameters: List<KtTypeReference>,
	result: KtTypeReference = ktDirectTypeReference("Unit"),
	isNullable: Boolean = false,
	scope: KtTypeReference? = null,
): KtFunctionTypeReference =
	DefaultKtFunctionTypeReference(parameters, result, isNullable, scope)

fun ktDirectGenericTypeArgument(
	path: String,
	genericTypeArguments: List<KtGenericTypeArgument> = emptyList(),
	isNullable: Boolean = false
): KtDirectGenericTypeArgument =
	ktDirectGenericTypeArgument(ktDirectTypeReference(PathParser.parsePath(path), genericTypeArguments, isNullable))

fun ktDirectGenericTypeArgument(typeReference: KtTypeReference): KtDirectGenericTypeArgument =
	DefaultKtDirectGenericTypeArgument(typeReference)

fun ktStarGenericTypeArgument(): KtStarGenericTypeArgument =
	DefaultKtStarGenericTypeArgument()

fun ktGenericTypeDeclaration(
	name: String,
	variance: String? = null,
	superType: KtTypeReference? = null,
): KtGenericTypeDeclaration =
	DefaultKtGenericTypeDeclaration(name, variance, superType)

fun ktParameter(name: String, upperBound: KtTypeReference, defaultValueExpression: KtExpression? = null): KtParameter =
	DefaultKtParameter(name, upperBound, defaultValueExpression)

fun ktConstructorParameter(
	name: String,
	upperBound: KtTypeReference,
	defaultValueExpression: KtExpression? = null,
	propertyType: KtPropertyType? = null,
	isOverride: Boolean = false,
): KtConstructorParameter =
	DefaultKtConstructorParameter(name, upperBound, defaultValueExpression, propertyType, isOverride)

fun ktNameExpression(name: String): KtNameExpression =
	DefaultKtNameExpression(name)

fun ktStringLiteralExpression(value: String, isTripleQuoted: Boolean = false): KtStringLiteralExpression =
	DefaultKtStringLiteralExpression(value, isTripleQuoted)

fun ktRawCodeExpression(code: String): KtRawCodeExpression =
	DefaultKtRawCodeExpression(code)

fun KtTypeReference.nullable(): KtTypeReference =
	when (this)
	{
		is KtDirectTypeReference -> DefaultKtDirectTypeReference(
			path,
			genericTypeArguments,
			true
		)
		is KtFunctionTypeReference -> DefaultKtFunctionTypeReference(
			parameters,
			result,
			true,
			scope,
		)
	}
