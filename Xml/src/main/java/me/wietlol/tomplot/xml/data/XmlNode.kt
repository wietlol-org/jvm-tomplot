package me.wietlol.tomplot.xml.data

data class XmlNode(
	val name: XmlName,
	val attributes: XmlAttributeSet,
	val children: List<XmlNodeElement>,
) : XmlNodeElement
