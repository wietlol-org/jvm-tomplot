package tomplot.html.data.models

import tomplot.css.builders.CssStyleSheetBuilder
import tomplot.css.data.models.CssBuilderMarker
import tomplot.css.data.models.CssStyleSheet
import tomplot.css.writers.CssStringWriter
import tomplot.html.data.models.tags.*

@HtmlBuilderMarker
@CssBuilderMarker
interface HtmlNode<T : HtmlAttributeSet> : HtmlElement
{
	val name: HtmlName
	val attributes: T
	val children: MutableList<HtmlElement>
	
	fun attributes(body: T.() -> Unit) =
		body(attributes)
	
	operator fun String.unaryPlus() =
		HtmlTextElement(this)
			.also(children::add)
	
	fun comment(text: String) =
		HtmlComment(text)
			.also(children::add)
	
	fun <T : HtmlElement> addChild(child: T, builder: T.() -> Unit): T =
		child
			.also(builder)
			.also(children::add)
	
	fun a(builder: HtmlAnchor.() -> Unit) =
		addChild(HtmlAnchor(), builder)
	
	fun abbr(builder: HtmlAbbreviation.() -> Unit) =
		addChild(HtmlAbbreviation(), builder)
	
	fun address(builder: HtmlAddress.() -> Unit) =
		addChild(HtmlAddress(), builder)
	
	fun area(builder: HtmlArea.() -> Unit) =
		addChild(HtmlArea(), builder)
	
	fun article(builder: HtmlArticle.() -> Unit) =
		addChild(HtmlArticle(), builder)
	
	fun aside(builder: HtmlAside.() -> Unit) =
		addChild(HtmlAside(), builder)
	
	fun audio(builder: HtmlAudio.() -> Unit) =
		addChild(HtmlAudio(), builder)
	
	fun b(builder: HtmlBold.() -> Unit) =
		addChild(HtmlBold(), builder)
	
	fun base(builder: HtmlBase.() -> Unit) =
		addChild(HtmlBase(), builder)
	
	fun bdi(builder: HtmlBdi.() -> Unit) =
		addChild(HtmlBdi(), builder)
	
	fun bdo(builder: HtmlBdo.() -> Unit) =
		addChild(HtmlBdo(), builder)
	
	fun blockquote(builder: HtmlBlockQuote.() -> Unit) =
		addChild(HtmlBlockQuote(), builder)
	
	fun body(builder: HtmlBody.() -> Unit) =
		addChild(HtmlBody(), builder)
	
	fun br(builder: HtmlBreak.() -> Unit = {}) =
		addChild(HtmlBreak(), builder)
	
	fun button(builder: HtmlButton.() -> Unit) =
		addChild(HtmlButton(), builder)
	
	fun canvas(builder: HtmlCanvas.() -> Unit) =
		addChild(HtmlCanvas(), builder)
	
	fun caption(builder: HtmlCaption.() -> Unit) =
		addChild(HtmlCaption(), builder)
	
	fun cite(builder: HtmlCite.() -> Unit) =
		addChild(HtmlCite(), builder)
	
	fun code(builder: HtmlCode.() -> Unit) =
		addChild(HtmlCode(), builder)
	
	fun col(builder: HtmlCol.() -> Unit) =
		addChild(HtmlCol(), builder)
	
	fun colgroup(builder: HtmlColGroup.() -> Unit) =
		addChild(HtmlColGroup(), builder)
	
	fun data(builder: HtmlData.() -> Unit) =
		addChild(HtmlData(), builder)
	
	fun datalist(builder: HtmlDataList.() -> Unit) =
		addChild(HtmlDataList(), builder)
	
	fun dd(builder: HtmlDescription.() -> Unit) =
		addChild(HtmlDescription(), builder)
	
	fun del(builder: HtmlDeleted.() -> Unit) =
		addChild(HtmlDeleted(), builder)
	
	fun details(builder: HtmlDetails.() -> Unit) =
		addChild(HtmlDetails(), builder)
	
	fun dfn(builder: HtmlDefinition.() -> Unit) =
		addChild(HtmlDefinition(), builder)
	
	fun dialog(builder: HtmlDialog.() -> Unit) =
		addChild(HtmlDialog(), builder)
	
	fun div(builder: HtmlDiv.() -> Unit) =
		addChild(HtmlDiv(), builder)
	
	fun dl(builder: HtmlDescriptionList.() -> Unit) =
		addChild(HtmlDescriptionList(), builder)
	
	fun dt(builder: HtmlDescriptionTerm.() -> Unit) =
		addChild(HtmlDescriptionTerm(), builder)
	
	fun em(builder: HtmlEmphasis.() -> Unit) =
		addChild(HtmlEmphasis(), builder)
	
	fun embed(builder: HtmlEmbed.() -> Unit) =
		addChild(HtmlEmbed(), builder)
	
	fun fieldset(builder: HtmlFieldset.() -> Unit) =
		addChild(HtmlFieldset(), builder)
	
	fun figcaption(builder: HtmlFigureCaption.() -> Unit) =
		addChild(HtmlFigureCaption(), builder)
	
	fun figure(builder: HtmlFigure.() -> Unit) =
		addChild(HtmlFigure(), builder)
	
	fun footer(builder: HtmlFooter.() -> Unit) =
		addChild(HtmlFooter(), builder)
	
	fun form(builder: HtmlForm.() -> Unit) =
		addChild(HtmlForm(), builder)
	
	fun h1(builder: HtmlH1.() -> Unit) =
		addChild(HtmlH1(), builder)
	
	fun h2(builder: HtmlH2.() -> Unit) =
		addChild(HtmlH2(), builder)
	
	fun h3(builder: HtmlH3.() -> Unit) =
		addChild(HtmlH3(), builder)
	
	fun h4(builder: HtmlH4.() -> Unit) =
		addChild(HtmlH4(), builder)
	
	fun h5(builder: HtmlH5.() -> Unit) =
		addChild(HtmlH5(), builder)
	
	fun h6(builder: HtmlH6.() -> Unit) =
		addChild(HtmlH6(), builder)
	
	fun head(builder: HtmlHead.() -> Unit) =
		addChild(HtmlHead(), builder)
	
	fun header(builder: HtmlHeader.() -> Unit) =
		addChild(HtmlHeader(), builder)
	
	fun hgroup(builder: HtmlHeadingGroup.() -> Unit) =
		addChild(HtmlHeadingGroup(), builder)
	
	fun hr(builder: HtmlHorizontalRule.() -> Unit) =
		addChild(HtmlHorizontalRule(), builder)
	
	fun html(builder: HtmlHtml.() -> Unit) =
		addChild(HtmlHtml(), builder)
	
	fun i(builder: HtmlItalic.() -> Unit) =
		addChild(HtmlItalic(), builder)
	
	fun iframe(builder: HtmlIFrame.() -> Unit) =
		addChild(HtmlIFrame(), builder)
	
	fun img(builder: HtmlImage.() -> Unit) =
		addChild(HtmlImage(), builder)
	
	fun input(builder: HtmlInput.() -> Unit) =
		addChild(HtmlInput(), builder)
	
	fun ins(builder: HtmlInserted.() -> Unit) =
		addChild(HtmlInserted(), builder)
	
	fun kbd(builder: HtmlKeyboardDefinition.() -> Unit) =
		addChild(HtmlKeyboardDefinition(), builder)
	
	fun label(builder: HtmlLabel.() -> Unit) =
		addChild(HtmlLabel(), builder)
	
	fun legend(builder: HtmlLegend.() -> Unit) =
		addChild(HtmlLegend(), builder)
	
	fun li(builder: HtmlListItem.() -> Unit) =
		addChild(HtmlListItem(), builder)
	
	fun link(builder: HtmlLink.() -> Unit) =
		addChild(HtmlLink(), builder)
	
	fun main(builder: HtmlMain.() -> Unit) =
		addChild(HtmlMain(), builder)
	
	fun map(builder: HtmlMap.() -> Unit) =
		addChild(HtmlMap(), builder)
	
	fun mark(builder: HtmlMark.() -> Unit) =
		addChild(HtmlMark(), builder)
	
	fun menu(builder: HtmlMenu.() -> Unit) =
		addChild(HtmlMenu(), builder)
	
	fun meta(builder: HtmlMeta.() -> Unit) =
		addChild(HtmlMeta(), builder)
	
	fun meter(builder: HtmlMeter.() -> Unit) =
		addChild(HtmlMeter(), builder)
	
	fun nav(builder: HtmlNavigation.() -> Unit) =
		addChild(HtmlNavigation(), builder)
	
	fun noscript(builder: HtmlNoScript.() -> Unit) =
		addChild(HtmlNoScript(), builder)
	
	fun `object`(builder: HtmlObject.() -> Unit) =
		addChild(HtmlObject(), builder)
	
	fun ol(builder: HtmlOrderedList.() -> Unit) =
		addChild(HtmlOrderedList(), builder)
	
	fun optgroup(builder: HtmlOptionGroup.() -> Unit) =
		addChild(HtmlOptionGroup(), builder)
	
	fun option(builder: HtmlOption.() -> Unit) =
		addChild(HtmlOption(), builder)
	
	fun output(builder: HtmlOutput.() -> Unit) =
		addChild(HtmlOutput(), builder)
	
	fun p(builder: HtmlParagraph.() -> Unit) =
		addChild(HtmlParagraph(), builder)
	
	fun param(builder: HtmlParameter.() -> Unit) =
		addChild(HtmlParameter(), builder)
	
	fun picture(builder: HtmlPicture.() -> Unit) =
		addChild(HtmlPicture(), builder)
	
	fun pre(builder: HtmlPreformatted.() -> Unit) =
		addChild(HtmlPreformatted(), builder)
	
	fun progress(builder: HtmlProgress.() -> Unit) =
		addChild(HtmlProgress(), builder)
	
	fun q(builder: HtmlQuote.() -> Unit) =
		addChild(HtmlQuote(), builder)
	
	fun rp(builder: HtmlRubyParen.() -> Unit) =
		addChild(HtmlRubyParen(), builder)
	
	fun rt(builder: HtmlRubyPronunciation.() -> Unit) =
		addChild(HtmlRubyPronunciation(), builder)
	
	fun ruby(builder: HtmlRuby.() -> Unit) =
		addChild(HtmlRuby(), builder)
	
	fun s(builder: HtmlStrikethrough.() -> Unit) =
		addChild(HtmlStrikethrough(), builder)
	
	fun samp(builder: HtmlSample.() -> Unit) =
		addChild(HtmlSample(), builder)
	
	fun script(builder: HtmlScript.() -> Unit) =
		addChild(HtmlScript(), builder)
	
	fun search(builder: HtmlSearch.() -> Unit) =
		addChild(HtmlSearch(), builder)
	
	fun section(builder: HtmlSection.() -> Unit) =
		addChild(HtmlSection(), builder)
	
	fun select(builder: HtmlSelect.() -> Unit) =
		addChild(HtmlSelect(), builder)
	
	fun small(builder: HtmlSmall.() -> Unit) =
		addChild(HtmlSmall(), builder)
	
	fun source(builder: HtmlSource.() -> Unit) =
		addChild(HtmlSource(), builder)
	
	fun span(builder: HtmlSpan.() -> Unit) =
		addChild(HtmlSpan(), builder)
	
	fun strong(builder: HtmlStrong.() -> Unit) =
		addChild(HtmlStrong(), builder)
	
	fun style(builder: CssStyleSheetBuilder.() -> Unit): HtmlStyle
	{
		val stylesheet = CssStyleSheet()
		builder(CssStyleSheetBuilder(stylesheet))
		val content = cssWriter.write(stylesheet)
		
		return addChild(HtmlStyle()) {
			children.add(HtmlTextElement(content))
		}
	}
	
	fun sub(builder: HtmlSubscript.() -> Unit) =
		addChild(HtmlSubscript(), builder)
	
	fun summary(builder: HtmlSummary.() -> Unit) =
		addChild(HtmlSummary(), builder)
	
	fun sup(builder: HtmlSuperscript.() -> Unit) =
		addChild(HtmlSuperscript(), builder)
	
	fun svg(builder: HtmlScalableVectorGraphics.() -> Unit) =
		addChild(HtmlScalableVectorGraphics(), builder)
	
	fun table(builder: HtmlTable.() -> Unit) =
		addChild(HtmlTable(), builder)
	
	fun tbody(builder: HtmlTableBody.() -> Unit) =
		addChild(HtmlTableBody(), builder)
	
	fun td(builder: HtmlTableData.() -> Unit) =
		addChild(HtmlTableData(), builder)
	
	fun template(builder: HtmlTemplate.() -> Unit) =
		addChild(HtmlTemplate(), builder)
	
	fun textarea(builder: HtmlTextarea.() -> Unit) =
		addChild(HtmlTextarea(), builder)
	
	fun tfoot(builder: HtmlTableFoot.() -> Unit) =
		addChild(HtmlTableFoot(), builder)
	
	fun th(builder: HtmlTableHeader.() -> Unit) =
		addChild(HtmlTableHeader(), builder)
	
	fun thead(builder: HtmlTableHead.() -> Unit) =
		addChild(HtmlTableHead(), builder)
	
	fun time(builder: HtmlTime.() -> Unit) =
		addChild(HtmlTime(), builder)
	
	fun title(builder: HtmlTitle.() -> Unit) =
		addChild(HtmlTitle(), builder)
	
	fun tr(builder: HtmlTableRow.() -> Unit) =
		addChild(HtmlTableRow(), builder)
	
	fun track(builder: HtmlTrack.() -> Unit) =
		addChild(HtmlTrack(), builder)
	
	fun u(builder: HtmlUnderlined.() -> Unit) =
		addChild(HtmlUnderlined(), builder)
	
	fun ul(builder: HtmlUnorderedList.() -> Unit) =
		addChild(HtmlUnorderedList(), builder)
	
	fun `var`(builder: HtmlVariable.() -> Unit) =
		addChild(HtmlVariable(), builder)
	
	fun video(builder: HtmlVideo.() -> Unit) =
		addChild(HtmlVideo(), builder)
	
	fun wbr(builder: HtmlWordBreak.() -> Unit) =
		addChild(HtmlWordBreak(), builder)
	
	fun rawTag(name: String, namespace: String? = null, builder: HtmlCustomTag.() -> Unit) =
		rawTag(HtmlName(name, namespace), builder)
	
	fun rawTag(name: HtmlName, builder: HtmlCustomTag.() -> Unit) =
		addChild(HtmlCustomTag(name), builder)
	
	companion object
	{
		private val cssWriter = CssStringWriter.ofOptions(prettyPrint = true)
	}
}
