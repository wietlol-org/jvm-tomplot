package me.wietlol.tomplot.core.writers

class TomplotTemplatedStringBuilderOptions(
	val commentPrefix: String,
	newLine: String = "\n",
	indent: String = "\t",
) : TomplotStringBuilderOptions(newLine, indent)
