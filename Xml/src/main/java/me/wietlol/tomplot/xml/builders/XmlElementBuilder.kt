package me.wietlol.tomplot.xml.builders

import me.wietlol.tomplot.api.builder.TomplotBuilder
import me.wietlol.tomplot.core.writers.ConsoleWriter
import me.wietlol.tomplot.core.writers.GenericWriter
import me.wietlol.tomplot.xml.data.XmlAttributeSet
import me.wietlol.tomplot.xml.data.XmlElement
import me.wietlol.tomplot.xml.engine.XmlTomplotEngine
import me.wietlol.tomplot.xml.writers.XmlStringWriter

@XmlBuilderMarker
interface XmlElementBuilder<T : XmlElement> : TomplotBuilder<T>
