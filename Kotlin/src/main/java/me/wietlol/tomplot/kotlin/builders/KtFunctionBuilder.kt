package me.wietlol.tomplot.kotlin.builders

import me.wietlol.tomplot.core.writers.TomplotStringBuilder
import me.wietlol.tomplot.core.writers.TomplotStringBuilderOptions
import me.wietlol.tomplot.kotlin.data.models.DefaultKtFunction
import me.wietlol.tomplot.kotlin.data.models.KtExpression
import me.wietlol.tomplot.kotlin.data.models.KtFunction
import me.wietlol.tomplot.kotlin.data.models.KtImport
import me.wietlol.tomplot.kotlin.data.models.KtParameter
import me.wietlol.tomplot.kotlin.data.models.KtTemplatedValue
import me.wietlol.tomplot.kotlin.data.models.KtTypeReference
import me.wietlol.tomplot.kotlin.data.models.KtVisibility

class KtFunctionBuilder(
	var name: String,
	var parameters: MutableList<KtParameter>,
	var returnType: KtTypeReference?,
	var body: MutableList<KtExpression>?,
	var isOverride: Boolean,
	var isExpressionBody: Boolean,
	var visibility: KtVisibility,
	val rootBuilder: KotlinElementBuilder<*>,
) : KotlinElementBuilder<KtFunction>
{
	override val imports: MutableList<KtImport> by rootBuilder::imports
	override val templatedValues: MutableList<KtTemplatedValue> by rootBuilder::templatedValues
	
	override fun build(): KtFunction =
		DefaultKtFunction(
			name,
			parameters,
			returnType,
			body,
			isOverride,
			isExpressionBody,
			visibility
		)
}

fun KtFunctionBuilder.body(action: TomplotStringBuilder.() -> Unit)
{
	TomplotStringBuilder(TomplotStringBuilderOptions())
		.also(action)
		.toString()
		.split("\n")
		.dropWhile { it.isEmpty() }
		.dropLastWhile { it.isEmpty() }
		.map { ktRawCodeExpression(it) }
		.also {
			if (body == null)
				body = it.toMutableList()
			else
				body!!.addAll(it)
		}
}
