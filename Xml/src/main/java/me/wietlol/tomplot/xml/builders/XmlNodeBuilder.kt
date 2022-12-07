package me.wietlol.tomplot.xml.builders

import me.wietlol.tomplot.xml.data.XmlAttributeSet
import me.wietlol.tomplot.xml.data.XmlName
import me.wietlol.tomplot.xml.data.XmlNode
import me.wietlol.tomplot.xml.data.XmlNodeElement

class XmlNodeBuilder(
	var name: XmlName,
	var attributes: XmlAttributeSet,
	var children: MutableList<XmlNodeElement>,
) : XmlElementBuilder<XmlNode>
{
	override fun build(): XmlNode =
		XmlNode(
			name,
			attributes,
			children
		)
}
