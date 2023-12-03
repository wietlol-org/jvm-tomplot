package tomplot.xml.builders

import tomplot.api.builder.TomplotBuilder
import tomplot.xml.data.models.XmlElement

@XmlBuilderMarker
interface XmlElementBuilder<T : XmlElement> : TomplotBuilder<T>
