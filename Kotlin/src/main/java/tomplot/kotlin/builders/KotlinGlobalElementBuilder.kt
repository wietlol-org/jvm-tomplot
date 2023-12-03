package tomplot.kotlin.builders

import tomplot.kotlin.data.models.DefaultKtDirectTypeReference
import tomplot.kotlin.data.models.DefaultKtImport
import tomplot.kotlin.data.models.DefaultKtTemplatedValue
import tomplot.kotlin.data.models.KtGenericTypeArgument
import tomplot.kotlin.data.models.KtImport
import tomplot.kotlin.data.models.KtTypeReference
import tomplot.kotlin.data.models.KtValueProvider
import tomplot.kotlin.utils.PathParser
import kotlin.reflect.KClass

fun KotlinElementBuilder<*>.ktTemplated(key: String, valueProvider: () -> String): String
{
	templatedValues.add(DefaultKtTemplatedValue(key, KtValueProvider(valueProvider)))
	return "\u001B$key\u001B"
}

fun KotlinElementBuilder<*>.ktImport(path: String, alias: String? = null): KtImport
{
	val split: List<String> = PathParser.parsePath(path)
	return ktImport(split.filter { it != "*" }, split.last() == "*", alias)
}

fun KotlinElementBuilder<*>.ktImport(
	path: List<String>,
	isStarImport: Boolean = false,
	alias: String? = null,
): KtImport =
	DefaultKtImport(path.toMutableList(), isStarImport, alias)
		.also { imports.add(it) }

fun KotlinElementBuilder<*>.ktImportedTypeReference(
	clazz: KClass<*>,
	genericTypes: List<KtGenericTypeArgument> = emptyList(),
): KtTypeReference =
	ktImportedTypeReference(clazz.qualifiedName!!, genericTypes)

fun KotlinElementBuilder<*>.ktImportedTypeReference(
	clazz: Class<*>,
	genericTypes: List<KtGenericTypeArgument> = emptyList(),
): KtTypeReference =
	ktImportedTypeReference(clazz.name, genericTypes)

fun KotlinElementBuilder<*>.ktImportedTypeReference(
	path: String,
	genericTypes: List<KtGenericTypeArgument> = emptyList(),
): KtTypeReference
{
	val import: KtImport = ktImport(path.replace("?", ""))
	return DefaultKtDirectTypeReference(import.path.takeLast(1), genericTypes, path.endsWith("?"))
}
