package me.wietlol.tomplot.xml.builders

import me.wietlol.tomplot.api.builder.TomplotBuilder
import me.wietlol.tomplot.xml.data.models.XmlElement

@XmlBuilderMarker
interface XmlElementBuilder<T : XmlElement> : TomplotBuilder<T>
