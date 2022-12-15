package me.wietlol.tomplot.kotlin.writers

import me.wietlol.tomplot.core.writers.TomplotStringBuilder
import me.wietlol.tomplot.core.writers.TomplotTemplatedStringBuilder
import me.wietlol.tomplot.kotlin.data.models.DefaultKtPropertyType.Companion.value
import me.wietlol.tomplot.kotlin.data.models.DefaultKtPropertyType.Companion.variable
import me.wietlol.tomplot.kotlin.data.models.DefaultKtVisibility.Companion.public
import me.wietlol.tomplot.kotlin.data.models.KtCastExpression
import me.wietlol.tomplot.kotlin.data.models.KtClass
import me.wietlol.tomplot.kotlin.data.models.KtComment
import me.wietlol.tomplot.kotlin.data.models.KtConstructorParameter
import me.wietlol.tomplot.kotlin.data.models.KtCustomCode
import me.wietlol.tomplot.kotlin.data.models.KtDirectGenericTypeArgument
import me.wietlol.tomplot.kotlin.data.models.KtDirectTypeReference
import me.wietlol.tomplot.kotlin.data.models.KtElement
import me.wietlol.tomplot.kotlin.data.models.KtFunction
import me.wietlol.tomplot.kotlin.data.models.KtFunctionTypeReference
import me.wietlol.tomplot.kotlin.data.models.KtGenericTypeDeclaration
import me.wietlol.tomplot.kotlin.data.models.KtImport
import me.wietlol.tomplot.kotlin.data.models.KtIntegerLiteralExpression
import me.wietlol.tomplot.kotlin.data.models.KtInterface
import me.wietlol.tomplot.kotlin.data.models.KtInvokeExpression
import me.wietlol.tomplot.kotlin.data.models.KtLambdaExpression
import me.wietlol.tomplot.kotlin.data.models.KtLocalVariableDeclarationExpression
import me.wietlol.tomplot.kotlin.data.models.KtMemberAccessExpression
import me.wietlol.tomplot.kotlin.data.models.KtNameExpression
import me.wietlol.tomplot.kotlin.data.models.KtObject
import me.wietlol.tomplot.kotlin.data.models.KtPackage
import me.wietlol.tomplot.kotlin.data.models.KtParameter
import me.wietlol.tomplot.kotlin.data.models.KtProperty
import me.wietlol.tomplot.kotlin.data.models.KtPropertyGetExpression
import me.wietlol.tomplot.kotlin.data.models.KtPropertyType
import me.wietlol.tomplot.kotlin.data.models.KtRawCodeExpression
import me.wietlol.tomplot.kotlin.data.models.KtReturnExpression
import me.wietlol.tomplot.kotlin.data.models.KtScript
import me.wietlol.tomplot.kotlin.data.models.KtStarGenericTypeArgument
import me.wietlol.tomplot.kotlin.data.models.KtStringLiteralExpression
import me.wietlol.tomplot.kotlin.data.models.KtTemplatedValue
import me.wietlol.tomplot.kotlin.data.models.KtThisExpression
import me.wietlol.tomplot.kotlin.data.models.KtTodoExpression
import me.wietlol.tomplot.kotlin.data.models.KtVisibility

class KotlinStringBuilder(
	options: KotlinWriterOptions, oldOutput: String?
)
{
	companion object
	{
		fun ofOptions(
			newLine: String = "\n",
			indent: String = "\t",
			oldOutput: String? = null,
		) = KotlinStringBuilder(KotlinWriterOptions(newLine, indent), oldOutput)
	}
	
	private val builder = TomplotTemplatedStringBuilder.ofOptions("//", null, options.newLine, options.indent)
	private val data: MutableMap<String, String>
	private val customCodeMap: Map<String, List<String>>
	
	init
	{
		val customCodeMap = mutableMapOf<String, List<String>>()
		var isCustomCode = false
		var customCodeList = mutableListOf<String>()
		oldOutput?.lines()?.forEach {
			when
			{
				it.trim().startsWith("// @tomplot:customCode:start:") ->
				{
					customCodeList = mutableListOf()
					val id = it.replace("// @tomplot:customCode:start:", "").trim()
					customCodeMap[id] = customCodeList
					isCustomCode = true
				}
				
				it.trim().startsWith("// @tomplot:customCode:end") ->
				{
					isCustomCode = false
				}
				
				isCustomCode ->
				{
					customCodeList.add(it)
				}
			}
		}
		this.customCodeMap = customCodeMap
		
		data = oldOutput?.lines()?.asSequence()?.filter { it.startsWith("// data: ") }?.map { it.replace("// data: ", "") }?.map { it.split(":", limit = 2) }?.map { it[0] to it[1] }?.toMap(HashMap()) ?: mutableMapOf()
	}
	
	fun append(element: KtElement): KotlinStringBuilder
	{
		when (element)
		{
			is KtScript -> append(element)
			is KtPackage -> append(element)
			is KtImport -> append(element)
			is KtComment -> append(element)
			is KtCustomCode -> append(element)
			is KtInterface -> append(element)
			is KtGenericTypeDeclaration -> append(element)
			is KtDirectTypeReference -> append(element)
			is KtFunctionTypeReference -> append(element)
			is KtDirectGenericTypeArgument -> append(element)
			is KtStarGenericTypeArgument -> append(element)
			is KtClass -> append(element)
			is KtConstructorParameter -> append(element)
			is KtProperty -> append(element)
			is KtObject -> append(element)
			is KtFunction -> append(element)
			is KtParameter -> append(element)
			is KtCastExpression -> append(element)
			is KtInvokeExpression -> append(element)
			is KtLocalVariableDeclarationExpression -> append(element)
			is KtMemberAccessExpression -> append(element)
			is KtNameExpression -> append(element)
			is KtLambdaExpression -> append(element)
			is KtStringLiteralExpression -> append(element)
			is KtIntegerLiteralExpression -> append(element)
			is KtReturnExpression -> append(element)
			is KtTodoExpression -> append(element)
			is KtPropertyGetExpression -> append(element)
			is KtThisExpression -> append(element)
			is KtRawCodeExpression -> append(element)
			is KtPropertyType -> append(element)
			is KtTemplatedValue -> append(element)
			is KtVisibility -> append(element)
		}
		return this
	}
	
	fun append(element: KtScript): KotlinStringBuilder
	{
		with(builder) {
			element.templatedValues.filter { data.containsKey(it.key).not() }.forEach { data[it.key] = it.valueProvider() }
			
			data.forEach { (key, value) ->
				appendLine("// data: $key:$value")
			}
			
			appendLine("// @formatter:off")
			appendLine()
			
			element.`package`?.also {
				append(it)
			}
			
			val imports = element.imports
				.filter { isDefaultImport(it).not() }
			if (imports.isNotEmpty())
			{
				imports
					.sortedBy { it.path.joinToString(".") }
					.distinct()
					.forEach { append(it) }
				appendLine()
			}
			
			appendJoin(element.members) {
				append(it)
			}
			
			appendLine("// @formatter:on")
		}
		return this
	}
	
	fun append(element: KtPackage): KotlinStringBuilder
	{
		with(builder) {
			append("package ")
			appendPath(element.path)
			appendLine()
			appendLine()
		}
		return this
	}
	
	fun append(element: KtImport): KotlinStringBuilder
	{
		with(builder) {
			append("import ")
			appendPath(element.path)
			if (element.isStarImport) append(".*")
			else
			{
				val alias: String? = element.alias
				if (alias != null)
				{
					append(" as ")
					appendName(alias)
				}
			}
			appendLine()
		}
		return this
	}
	
	fun append(element: KtComment): KotlinStringBuilder
	{
		with(builder) {
			element.text.forEach {
				append("// ")
				appendLine(it)
			}
		}
		return this
	}
	
	fun append(element: KtCustomCode): KotlinStringBuilder
	{
		with(builder) {
			appendLine("// @formatter:on")
			appendLine("// @tomplot:customCode:start:${element.id}")
			
			customCodeMap[element.id]?.forEach {
				appendLineNoIndents(it)
			}
			
			appendLine("// @tomplot:customCode:end")
			appendLine("// @formatter:off")
		}
		return this
	}
	
	fun append(element: KtInterface): KotlinStringBuilder
	{
		with(builder) {
			if (element.visibility != public)
			{
				append(element.visibility.code)
				append(" ")
			}
			if (element.isSealed)
				append("sealed ")
			append("interface ")
			appendName(element.name)
			append(element.generics)
			
			if (element.superTypes.isNotEmpty())
			{
				append(" : ")
				
				appendJoin(element.superTypes, ", ") {
					append(it)
				}
			}
			appendLine()
			
			if (element.members.isNotEmpty())
			{
				appendLine("{")
				indented {
					appendJoin(element.members) {
						append(it)
					}
				}
				appendLine("}")
			}
		}
		return this
	}
	
	fun append(elements: List<KtGenericTypeDeclaration>): KotlinStringBuilder
	{
		with(builder) {
			if (elements.isNotEmpty())
			{
				append("<")
				appendJoin(elements, ", ") { append(it) }
				append(">")
			}
		}
		return this
	}
	
	fun append(element: KtGenericTypeDeclaration): KotlinStringBuilder
	{
		with(builder) {
			element.variance?.also {
				append(it)
				append(" ")
			}
			appendName(element.name)
			element.superType?.also {
				append(" : ")
				append(it)
			}
		}
		return this
	}
	
	fun append(element: KtDirectTypeReference): KotlinStringBuilder
	{
		with(builder) {
			appendPath(element.path)
			
			if (element.genericTypeArguments.isNotEmpty())
			{
				append("<")
				appendJoin(element.genericTypeArguments, ", ") {
					append(it)
				}
				append(">")
			}
			
			if (element.isNullable)
				append("?")
		}
		return this
	}
	
	fun append(element: KtFunctionTypeReference): KotlinStringBuilder
	{
		with(builder) {
			if (element.isNullable)
				append("(")
			
			element.scope?.also {
				if (it is KtFunctionTypeReference)
					append("(")
				append(it)
				if (it is KtFunctionTypeReference)
					append(")")
				append(".")
			}
			
			append("(")
			appendJoin(element.parameters, ", ") {
				append(it)
			}
			append(") -> ")
			
			append(element.result)
			
			if (element.isNullable)
				append(")?")
		}
		return this
	}
	
	fun append(element: KtDirectGenericTypeArgument): KotlinStringBuilder
	{
		append(element.typeReference)
		return this
	}
	
	fun append(element: KtStarGenericTypeArgument): KotlinStringBuilder
	{
		builder.append("*")
		return this
	}
	
	fun append(element: KtClass): KotlinStringBuilder
	{
		with(builder) {
			if (element.visibility != public)
			{
				append(element.visibility.code)
				append(" ")
			}
			if (element.isSealed)
				append("sealed ")
			if (element.isValueClass)
				append("value ")
			if (element.isDataClass)
				append("data ")
			append("class ")
			appendName(element.name)
			
			append(element.generics)
			
			if (element.primaryConstructorParameters.isNotEmpty())
			{
				appendLine("(")
				indented {
					element.primaryConstructorParameters.forEach {
						append(it)
						appendLine(",")
					}
				}
				append(")")
			}
			
			if (element.superTypes.isNotEmpty())
			{
				append(" : ")
				appendJoin(element.superTypes, ",") {
					append(it)
				}
			}
			appendLine()
			
			if (element.members.isNotEmpty())
			{
				appendLine("{")
				indented {
					appendJoin(element.members) {
						append(it)
					}
				}
				appendLine("}")
			}
		}
		return this
	}
	
	fun append(element: KtConstructorParameter): KotlinStringBuilder
	{
		with(builder) {
			if (element.isOverride)
				append("override ")
			element.propertyType?.also {
				when (it)
				{
					value -> append("val ")
					variable -> append("var ")
				}
			}
			
			appendName(element.name)
			append(": ")
			append(element.upperBound)
			
			element.defaultValueExpression?.also {
				append(" = ")
				append(it)
			}
		}
		return this
	}
	
	fun append(element: KtProperty): KotlinStringBuilder
	{
		with(builder) {
			if (element.visibility != public)
			{
				append(element.visibility.code)
				append(" ")
			}
			if (element.isOverride)
				append("override ")
			
			when (element.type)
			{
				value -> append("val ")
				variable -> append("var ")
			}
			
			appendName(element.name)
			append(": ")
			append(element.upperBound)
			
			indented {
				element.initialValue?.also {
					append(" = ")
					append(it)
				}
			}
			appendLine()
			
			indented {
				element.getter?.also {
					append("get() = ")
					append(it)
					appendLine()
				}
			}
		}
		return this
	}
	
	fun append(element: KtObject): KotlinStringBuilder
	{
		with(builder) {
			if (element.visibility != public)
			{
				append(element.visibility.code)
				append(" ")
			}
			if (element.isCompanion)
				append("companion ")
			append("object")
			element.name?.also {
				append(" ")
				appendName(it)
			}
			if (element.superTypes.isNotEmpty())
			{
				append(" : ")
				appendJoin(element.superTypes, ", ") {
					append(it)
				}
			}
			appendLine()
			
			if (element.members.isNotEmpty())
			{
				appendLine("{")
				indented {
					appendJoin(element.members) {
						append(it)
					}
				}
				appendLine("}")
			}
		}
		return this
	}
	
	fun append(element: KtFunction): KotlinStringBuilder
	{
		with(builder) {
			if (element.visibility != public)
			{
				append(element.visibility.code)
				append(" ")
			}
			if (element.isOverride)
				append("override ")
			
			append("fun ")
			appendName(element.name)
			append("(")
			appendJoin(element.parameters, ", ") { append(it) }
			append(")")
			element.returnType?.also {
				append(": ")
				append(it)
			}
			
			if (element.isExpressionBody)
				append(" =")
			
			appendLine()
			
			element.body?.also { body ->
				if (element.isExpressionBody.not())
				{
					appendLine("{")
				}
				
				indented {
					body.forEach {
						append(it)
						appendLine()
					}
				}
				
				if (element.isExpressionBody.not())
				{
					appendLine("}")
				}
			}
		}
		return this
	}
	
	fun append(element: KtParameter): KotlinStringBuilder
	{
		with(builder) {
			appendName(element.name)
			append(": ")
			append(element.upperBound)
			
			element.defaultValueExpression?.also {
				append(" = ")
				append(it)
			}
		}
		return this
	}
	
	fun append(element: KtCastExpression): KotlinStringBuilder
	{
		with(builder) {
			append("(")
			append(element.expression)
			append(" as")
			if (element.isConditionalCast)
				append("?")
			append(" ")
			append(element.target)
			append(")")
		}
		return this
	}
	
	fun append(element: KtInvokeExpression): KotlinStringBuilder
	{
		with(builder) {
			append(element.function)
			append("(")
			appendJoin(element.arguments) {
				append(it)
			}
			append(")")
		}
		return this
	}
	
	fun append(element: KtLocalVariableDeclarationExpression): KotlinStringBuilder
	{
		with(builder) {
			append(if (element.isVariable) "var " else "val ")
			appendName(element.name)
			element.upperBound?.also {
				append(": ")
				append(it)
			}
			element.initialValue?.also {
				append(" = ")
				append(it)
			}
		}
		return this
	}
	
	fun append(element: KtMemberAccessExpression): KotlinStringBuilder
	{
		with(builder) {
			append(element.supplier)
			if (element.isConditionalAccess)
				append("?")
			append(if (element.isReferencingAccess) "::" else ".")
			appendName(element.memberName)
		}
		return this
	}
	
	fun append(element: KtNameExpression): KotlinStringBuilder
	{
		with(builder) {
			appendName(element.name)
		}
		return this
	}
	
	fun append(element: KtLambdaExpression): KotlinStringBuilder
	{
		with(builder) {
			append("{")
			
			if (element.parameters.isNotEmpty())
			{
				appendJoin(element.parameters, ",") { append(it.name) }
				append("->")
			}
			appendLine()
			indented {
				element.body.forEach {
					append(it)
					appendLine()
				}
			}
			append("}")
		}
		return this
	}
	
	fun append(element: KtStringLiteralExpression): KotlinStringBuilder
	{
		if (element.isTripleQuoted)
			builder.appendRawStringLiteral(element.value)
		else
			builder.appendStringLiteral(element.value)
		return this
	}
	
	fun append(element: KtIntegerLiteralExpression): KotlinStringBuilder
	{
		with(builder) {
			append(element.value.toString())
		}
		return this
	}
	
	fun append(element: KtReturnExpression): KotlinStringBuilder
	{
		with(builder) {
			append("return")
			element.value?.also {
				append(" ")
				append(it)
			}
		}
		return this
	}
	
	fun append(element: KtTodoExpression): KotlinStringBuilder
	{
		with(builder) {
			append("TODO(")
			element.text?.also {
				appendStringLiteral(it)
			}
			append(")")
		}
		return this
	}
	
	fun append(element: KtPropertyGetExpression): KotlinStringBuilder
	{
		with(builder) {
			append(element.supplierExpression)
			append(".")
			append(element.propertyName)
		}
		return this
	}
	
	fun append(element: KtThisExpression): KotlinStringBuilder
	{
		with(builder) {
			append("this")
			element.scopeName?.also {
				append("@")
				append(it)
			}
		}
		return this
	}
	
	fun append(element: KtRawCodeExpression): KotlinStringBuilder
	{
		with(builder) {
			append(element.code)
		}
		return this
	}
	
	fun append(element: KtPropertyType): KotlinStringBuilder
	{
		with(builder) {
			append(element.code)
		}
		return this
	}
	
	fun append(element: KtTemplatedValue): KotlinStringBuilder
	{
		with(builder) {
			append(element.key)
		}
		return this
	}
	
	fun append(element: KtVisibility): KotlinStringBuilder
	{
		with(builder) {
			append(element.code)
		}
		return this
	}
	
	private fun isDefaultImport(element: KtImport): Boolean
	{
		val pathWithoutName: List<String> = element.path.dropLast(1)
		return pathWithoutName == listOf("kotlin")
			|| pathWithoutName == listOf("kotlin", "collections")
			|| pathWithoutName == listOf("java", "lang")
	}
	
	private fun TomplotStringBuilder.appendPath(path: List<String>)
	{
		appendJoin(path, ".") { appendName(it) }
	}
	
	private val escapeRequiredRegex = Regex("[^0-9a-zA-Z_]|^[0-9]")
	private val keywords = setOf("private", "public", "protected", "package", "fun", "val", "var", "lateinit", "interface", "class", "enum")
	private fun TomplotStringBuilder.appendName(name: String)
	{
		if (name.contains(escapeRequiredRegex) || keywords.contains(name))
			appendEscapedName(name)
		else
			append(name)
	}
	
	private fun TomplotStringBuilder.appendEscapedName(name: String)
	{
		append("`")
		append(name)
		append("`")
	}
	
	fun TomplotTemplatedStringBuilder.appendStringLiteral(text: String)
	{
		append("\"")
		append(
			text
				.replace("\\", "\\\\")
				.replace("\"", "\\\"")
				.replace("\n", "\\n")
				.replace("\r", "\\r")
				.replace("\b", "\\b")
				.replace("\t", "\\t")
				.replace("$", "\\$")
		)
		append("\"")
	}
	
	fun TomplotTemplatedStringBuilder.appendRawStringLiteral(text: String)
	{
		append("\"\"\"")
		append(
			text
				.replace("\\", "\\\\")
				.replace("\n", "\\n")
				.replace("\r", "\\r")
				.replace("\b", "\\b")
				.replace("\t", "\\t")
				.replace("$", "\\$")
		)
		append("\"\"\"")
	}
	
	override fun toString(): String =
		builder.toString()
}
