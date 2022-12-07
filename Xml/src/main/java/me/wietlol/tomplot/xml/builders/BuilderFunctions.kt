package me.wietlol.tomplot.xml.builders

import me.wietlol.tomplot.xml.data.XmlAttributeSet
import me.wietlol.tomplot.xml.data.XmlComment
import me.wietlol.tomplot.xml.data.XmlName
import me.wietlol.tomplot.xml.data.XmlNode
import me.wietlol.tomplot.xml.data.XmlProlog
import me.wietlol.tomplot.xml.data.XmlTextElement

fun XmlDocumentBuilder.prolog(name: String, attributes: XmlAttributeSet): XmlProlog =
	XmlProlog(name, attributes)
		.also(headers::add)

fun XmlDocumentBuilder.node(name: String, namespace: String? = null, body: XmlNodeBuilder.() -> Unit): XmlNode =
	node(XmlName(name, namespace), body)

fun XmlDocumentBuilder.node(name: XmlName, body: XmlNodeBuilder.() -> Unit): XmlNode =
	rootBuilder.node(name, body)

fun XmlNodeBuilder.node(name: String, namespace: String? = null, body: XmlNodeBuilder.() -> Unit): XmlNode =
	node(XmlName(name, namespace), body)

fun XmlNodeBuilder.node(name: XmlName, body: XmlNodeBuilder.() -> Unit): XmlNode =
	XmlNodeBuilder(name, XmlAttributeSet(), mutableListOf())
		.apply(body)
		.build()
		.also(children::add)

fun XmlDocumentBuilder.text(text: String): XmlTextElement =
	rootBuilder.text(text)

fun XmlNodeBuilder.text(text: String): XmlTextElement =
	XmlTextElement(text)
		.also(children::add)

fun XmlDocumentBuilder.commentHeader(text: String): XmlComment =
	XmlComment(text)
		.also(headers::add)

fun XmlDocumentBuilder.comment(text: String): XmlComment =
	rootBuilder.comment(text)

fun XmlNodeBuilder.comment(text: String): XmlComment =
	XmlComment(text)
		.also(children::add)
