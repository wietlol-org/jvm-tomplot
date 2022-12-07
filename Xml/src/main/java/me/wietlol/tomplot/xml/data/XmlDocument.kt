package me.wietlol.tomplot.xml.data

data class XmlDocument(
	val headers: List<XmlHeader>,
	val root: XmlNode,
) : XmlElement
