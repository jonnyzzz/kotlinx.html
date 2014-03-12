package kotlinx.html

val <T> empty_contents: T.() -> Unit = { }

public abstract class HtmlBodyTag(containingTag: HtmlTag?, name: String, renderStyle: RenderStyle = RenderStyle.expanded, contentStyle: ContentStyle = ContentStyle.block) : HtmlTag(containingTag, name, renderStyle, contentStyle) {
    public var id: String by Attributes.id
    public var styleClass: String by Attributes.styleClass
    public var style: String by Attributes.style

    fun addClass(styleClass: String) {
        val old = tryGet(Attributes.styleClass.name)
        setClass(if (old.isNotEmpty()) "$old $styleClass" else styleClass)
    }

    fun setClass(styleClass: String) {
        attribute(Attributes.styleClass.name, styleClass)
    }
}

fun <T : HtmlBodyTag> HtmlBodyTag.contentTag(tag: T, styleClass: String? = null, contents: T.() -> Unit = empty_contents) {
    if (styleClass != null) tag.addClass(styleClass)
    build(tag, contents)
}


fun HtmlBodyTag.a(c: String? = null, contents: A.() -> Unit = empty_contents) = contentTag(A(this), c, contents)
open class A(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "a", contentStyle = ContentStyle.propagate) {
    public var href: Link by Attributes.href
    public var rel: String by Attributes.rel
    public var target: String by Attributes.target
}

fun HtmlBodyTag.button(c: String? = null, contents: BUTTON.() -> Unit = empty_contents) = contentTag(BUTTON(this), c, contents)
open class BUTTON(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "button") {
    public var name: String by Attributes.name
    public var value: String by Attributes.value
    public var buttonType: String by Attributes.buttonType
    public var href: Link by Attributes.href
}

fun HTML.body(c: String? = null, contents: BODY.() -> Unit) {
    val tag = BODY(this)
    if (c != null) tag.styleClass = c
    build(tag, contents)
}

class BODY(containingTag: HTML) : HtmlBodyTag(containingTag, "body")

fun HtmlBodyTag.hr(c: String? = null) = contentTag(HR(this), c)
fun HtmlBodyTag.br(c: String? = null) = contentTag(BR(this), c)
fun HtmlBodyTag.wbr(c: String? = null) = contentTag(WBR(this), c)
fun HtmlBodyTag.div(c: String? = null, contents: DIV.() -> Unit = empty_contents) = contentTag(DIV(this), c, contents)
fun HtmlBodyTag.b(c: String? = null, contents: B.() -> Unit = empty_contents) = contentTag(B(this), c, contents)
fun HtmlBodyTag.i(c: String? = null, contents: I.() -> Unit = empty_contents) = contentTag(I(this), c, contents)
fun HtmlBodyTag.p(c: String? = null, contents: P.() -> Unit = empty_contents) = contentTag(P(this), c, contents)
fun HtmlBodyTag.pre(c: String? = null, contents: PRE.() -> Unit = empty_contents) = contentTag(PRE(this), c, contents)
fun HtmlBodyTag.span(c: String? = null, contents: SPAN.() -> Unit = empty_contents) = contentTag(SPAN(this), c, contents)
fun HtmlBodyTag.sub(c: String? = null, contents: SUB.() -> Unit = empty_contents) = contentTag(SUB(this), c, contents)
fun HtmlBodyTag.sup(c: String? = null, contents: SUP.() -> Unit = empty_contents) = contentTag(SUP(this), c, contents)
fun HtmlBodyTag.ins(c: String? = null, contents: INS.() -> Unit = empty_contents) = contentTag(INS(this), c, contents)
fun HtmlBodyTag.del(c: String? = null, contents: DEL.() -> Unit = empty_contents) = contentTag(DEL(this), c, contents)
fun HtmlBodyTag.s(c: String? = null, contents: S.() -> Unit = empty_contents) = contentTag(S(this), c, contents)
fun HtmlBodyTag.u(c: String? = null, contents: U.() -> Unit = empty_contents) = contentTag(U(this), c, contents)
fun HtmlBodyTag.abbr(c: String? = null, contents: ABBR.() -> Unit = empty_contents) = contentTag(ABBR(this), c, contents)
fun HtmlBodyTag.small(c: String? = null, contents: SMALL.() -> Unit = empty_contents) = contentTag(SMALL(this), c, contents)
fun HtmlBodyTag.mark(c: String? = null, contents: MARK.() -> Unit = empty_contents) = contentTag(MARK(this), c, contents)
fun HtmlBodyTag.address(c: String? = null, contents: ADDRESS.() -> Unit = empty_contents) = contentTag(ADDRESS(this), c, contents)
fun HtmlBodyTag.time(c: String? = null, contents: TIME.() -> Unit = empty_contents) = contentTag(TIME(this), c, contents)
fun HtmlBodyTag.cite(c: String? = null, contents: CITE.() -> Unit = empty_contents) = contentTag(CITE(this), c, contents)
fun HtmlBodyTag.q(c: String? = null, contents: Q.() -> Unit = empty_contents) = contentTag(Q(this), c, contents)
fun HtmlBodyTag.blockquote(c: String? = null, contents: BLOCKQUOTE.() -> Unit = empty_contents) = contentTag(BLOCKQUOTE(this), c, contents)

open class HR(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "hr", RenderStyle.empty)
open class BR(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "br", RenderStyle.empty)
open class WBR(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "wbr", RenderStyle.empty)
open class DIV(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "div")
open class B(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "b", contentStyle = ContentStyle.propagate)
open class I(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "i", contentStyle = ContentStyle.propagate)
open class P(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "p")
open class PRE(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "pre")
open class SPAN(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "span", contentStyle = ContentStyle.propagate)
open class SUB(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "sub", contentStyle = ContentStyle.propagate)
open class SUP(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "sup", contentStyle = ContentStyle.propagate)
open class INS(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "ins", contentStyle = ContentStyle.propagate)
open class DEL(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "del", contentStyle = ContentStyle.propagate)
open class S(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "s", contentStyle = ContentStyle.propagate)
open class U(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "u", contentStyle = ContentStyle.propagate)
open class ABBR(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "abbr", contentStyle = ContentStyle.propagate)
open class SMALL(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "small", contentStyle = ContentStyle.propagate)
open class MARK(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "mark", contentStyle = ContentStyle.propagate)
open class TIME(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "time")
open class ADDRESS(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "address")
open class CITE(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "cite", contentStyle = ContentStyle.propagate)
open class Q(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "q", contentStyle = ContentStyle.propagate)
open class BLOCKQUOTE(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "blockquote") {
    public var cite: Link by Attributes.cite
}

fun HtmlBodyTag.em(c: String? = null, contents: EM.() -> Unit = empty_contents) = contentTag(EM(this), c, contents)
fun HtmlBodyTag.strong(c: String? = null, contents: STRONG.() -> Unit = empty_contents) = contentTag(STRONG(this), c, contents)
fun HtmlBodyTag.code(c: String? = null, contents: CODE.() -> Unit = empty_contents) = contentTag(CODE(this), c, contents)
fun HtmlBodyTag.kbd(c: String? = null, contents: KBD.() -> Unit = empty_contents) = contentTag(KBD(this), c, contents)
fun HtmlBodyTag.dfn(c: String? = null, contents: DFN.() -> Unit = empty_contents) = contentTag(DFN(this), c, contents)
fun HtmlBodyTag.samp(c: String? = null, contents: SAMP.() -> Unit = empty_contents) = contentTag(SAMP(this), c, contents)
fun HtmlBodyTag.variable(c: String? = null, contents: VARIABLE.() -> Unit = empty_contents) = contentTag(VARIABLE(this), c, contents)
open class EM(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "em", contentStyle = ContentStyle.propagate)
open class STRONG(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "strong", contentStyle = ContentStyle.propagate)
open class CODE(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "code")
open class KBD(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "kbd", contentStyle = ContentStyle.propagate)
open class DFN(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "dfn", contentStyle = ContentStyle.propagate)
open class SAMP(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "samp", contentStyle = ContentStyle.propagate)
open class VARIABLE(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "var", contentStyle = ContentStyle.propagate)

fun HtmlBodyTag.progress(c: String? = null, contents: PROGRESS.() -> Unit = empty_contents) = contentTag(PROGRESS(this), c, contents)
fun HtmlBodyTag.meter(c: String? = null, contents: METER.() -> Unit = empty_contents) = contentTag(METER(this), c, contents)
open class PROGRESS(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "progress", contentStyle = ContentStyle.propagate)
open class METER(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "meter", contentStyle = ContentStyle.propagate)


fun HtmlBodyTag.dl(c: String? = null, contents: DL.() -> Unit = empty_contents) = contentTag(DL(this), c, contents)
fun DL.dt(c: String? = null, contents: DT.() -> Unit = empty_contents) = contentTag(DT(this), c, contents)
fun DL.dd(c: String? = null, contents: DD.() -> Unit = empty_contents) = contentTag(DD(this), c, contents)

open class DL(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "dl")
open class DD(containingTag: DL) : HtmlBodyTag(containingTag, "dd", contentStyle = ContentStyle.propagate)
open class DT(containingTag: DL) : HtmlBodyTag(containingTag, "dt", contentStyle = ContentStyle.propagate)

fun HtmlBodyTag.ul(c: String? = null, contents: UL.() -> Unit = empty_contents) = contentTag(UL(this), c, contents)
fun HtmlBodyTag.ol(c: String? = null, contents: OL.() -> Unit = empty_contents) = contentTag(OL(this), c, contents)
fun ListTag.li(c: String? = null, contents: LI.() -> Unit = empty_contents) = contentTag(LI(this), c, contents)

abstract class ListTag(containingTag: HtmlBodyTag, name: String) : HtmlBodyTag(containingTag, name)
open class OL(containingTag: HtmlBodyTag) : ListTag(containingTag, "ol")
open class UL(containingTag: HtmlBodyTag) : ListTag(containingTag, "ul")
open class LI(containingTag: ListTag) : HtmlBodyTag(containingTag, "li")

fun HtmlBodyTag.h1(c: String? = null, contents: H1.() -> Unit = empty_contents) = contentTag(H1(this), c, contents)
fun HtmlBodyTag.h2(c: String? = null, contents: H2.() -> Unit = empty_contents) = contentTag(H2(this), c, contents)
fun HtmlBodyTag.h3(c: String? = null, contents: H3.() -> Unit = empty_contents) = contentTag(H3(this), c, contents)
fun HtmlBodyTag.h4(c: String? = null, contents: H4.() -> Unit = empty_contents) = contentTag(H4(this), c, contents)
fun HtmlBodyTag.h5(c: String? = null, contents: H5.() -> Unit = empty_contents) = contentTag(H5(this), c, contents)
fun HtmlBodyTag.h6(c: String? = null, contents: H6.() -> Unit = empty_contents) = contentTag(H6(this), c, contents)

open class H1(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "h1")
open class H2(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "h2")
open class H3(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "h3")
open class H4(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "h4")
open class H5(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "h5")
open class H6(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "h6")

fun HtmlBodyTag.img(c: String? = null, contents: IMG.() -> Unit = empty_contents) = contentTag(IMG(this), c, contents)
open class IMG(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "img", RenderStyle.empty, ContentStyle.text) {
    public var width: Int by Attributes.width
    public var height: Int by Attributes.height
    public var src: Link by Attributes.src
    public var alt: String by Attributes.alt
}


fun HtmlBodyTag.table(c: String? = null, contents: TABLE.() -> Unit = empty_contents) = contentTag(TABLE(this), c, contents)
fun TABLE.caption(c: String? = null, contents: CAPTION.() -> Unit = empty_contents) = contentTag(CAPTION(this), c, contents)
fun TABLE.tbody(c: String? = null, contents: TBODY.() -> Unit = empty_contents) = contentTag(TBODY(this), c, contents)
fun TABLE.thead(c: String? = null, contents: THEAD.() -> Unit = empty_contents) = contentTag(THEAD(this), c, contents)
fun TABLE.colgroup(c: String? = null, contents: COLGROUP.() -> Unit = empty_contents) = contentTag(COLGROUP(this), c, contents)
fun COLGROUP.col(c: String? = null, contents: COL.() -> Unit = empty_contents) = contentTag(COL(this), c, contents)
fun TABLE.tfoot(c: String? = null, contents: TFOOT.() -> Unit = empty_contents) = contentTag(TFOOT(this), c, contents)
fun TableTag.tr(c: String? = null, contents: TR.() -> Unit = empty_contents) = contentTag(TR(this), c, contents)
fun TR.th(c: String? = null, contents: TH.() -> Unit = empty_contents) = contentTag(TH(this), c, contents)
fun TR.td(c: String? = null, contents: TD.() -> Unit = empty_contents) = contentTag(TD(this), c, contents)

abstract class TableTag(containingTag: HtmlBodyTag, name: String) : HtmlBodyTag(containingTag, name)
open class TABLE(containingTag: HtmlBodyTag) : TableTag(containingTag, "table")
open class CAPTION(containingTag: TABLE) : HtmlBodyTag(containingTag, "caption")
open class COLGROUP(containingTag: TABLE) : HtmlBodyTag(containingTag, "colgroup")
open class COL(containingTag: COLGROUP) : HtmlBodyTag(containingTag, "col")
open class THEAD(containingTag: TABLE) : TableTag(containingTag, "thead")
open class TFOOT(containingTag: TABLE) : TableTag(containingTag, "tfoot")
open class TBODY(containingTag: TABLE) : TableTag(containingTag, "tbody")
open class TR(containingTag: TableTag) : HtmlBodyTag(containingTag, "tr")
open class TH(containingTag: TR) : HtmlBodyTag(containingTag, "th")
open class TD(containingTag: TR) : HtmlBodyTag(containingTag, "td")

fun HtmlBodyTag.form(c: String? = null, contents: FORM.() -> Unit = empty_contents) = contentTag(FORM(this), c, contents)

public open class FORM(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "form") {
    public var action: Link by Attributes.action
    public var enctype: String by Attributes.enctype
    public var method: String by Attributes.method
}

fun HtmlBodyTag.select(c: String? = null, contents: SELECT.() -> Unit = empty_contents) = contentTag(SELECT(this), c, contents)
fun SelectTag.option(c: String? = null, contents: OPTION.() -> Unit = empty_contents) = contentTag(OPTION(this), c, contents)
fun SELECT.optgroup(c: String? = null, contents: OPTGROUP.() -> Unit = empty_contents) = contentTag(OPTGROUP(this), c, contents)
abstract class SelectTag(containingTag: HtmlBodyTag, name: String) : HtmlBodyTag(containingTag, name)
open class SELECT(containingTag: HtmlBodyTag) : SelectTag(containingTag, "select") {
    public var name: String by Attributes.name
    public var size: Int by Attributes.size
    public var multiple: Boolean by Attributes.multiple
    public var disabled: Boolean by Attributes.disabled
    public var required: Boolean by Attributes.required
}
open class OPTION(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "option") {
    public var value: String by Attributes.value
    public var label: String by Attributes.label
    public var disabled: Boolean by Attributes.disabled
    public var selected: Boolean by Attributes.selected
}
open class OPTGROUP(containingTag: HtmlBodyTag) : SelectTag(containingTag, "optgroup")

fun HtmlBodyTag.input(c: String? = null, contents: INPUT.() -> Unit = empty_contents) = contentTag(INPUT(this), c, contents)
open class INPUT(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "input") {
    public var alt: String by Attributes.alt
    public var autocomplete: Boolean by Attributes.autocomplete
    public var autofocus: Boolean by Attributes.autofocus
    public var checked: Boolean by Attributes.checked
    public var disabled: Boolean by Attributes.disabled
    public var height: Int by Attributes.height
    public var maxlength: Int by Attributes.maxlength
    public var multiple: Boolean by Attributes.multiple
    public var inputType: String by Attributes.inputType
    public var name: String by Attributes.name
    public var pattern: String by Attributes.pattern
    public var placeholder: String by Attributes.placeholder
    public var readonly: Boolean by Attributes.readonly
    public var required: Boolean by Attributes.required
    public var size: Int by Attributes.size
    public var src: Link by Attributes.src
    public var step: Int by Attributes.step
    public var value: String by Attributes.value
    public var width: Int by Attributes.width
}

fun HtmlBodyTag.label(c: String? = null, contents: LABEL.() -> Unit = empty_contents) = contentTag(LABEL(this), c, contents)
open class LABEL(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "label") {
    public var forId: String by Attributes.forId
}

fun HtmlBodyTag.textarea(c: String? = null, contents: TEXTAREA.() -> Unit = empty_contents) = contentTag(TEXTAREA(this), c, contents)
open class TEXTAREA(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "textarea") {
    public var autofocus: Boolean by Attributes.autofocus
    public var cols: Int by Attributes.cols
    public var disabled: Boolean by Attributes.disabled
    public var maxlength: Int by Attributes.maxlength
    public var name: String by Attributes.name
    public var placeholder: String by Attributes.placeholder
    public var readonly: Boolean by Attributes.readonly
    public var required: Boolean by Attributes.required
    public var rows: Int by Attributes.rows
    public var wrap: String by Attributes.wrap
}

fun HtmlBodyTag.fieldset(c: String? = null, contents: FIELDSET.() -> Unit = empty_contents) = contentTag(FIELDSET(this), c, contents)
fun FIELDSET.legend(c: String? = null, contents: LEGEND.() -> Unit = empty_contents) = contentTag(LEGEND(this), c, contents)
open class FIELDSET(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "fieldset")
open class LEGEND(containingTag: FIELDSET) : HtmlBodyTag(containingTag, "legend")

fun HtmlBodyTag.figure(c: String? = null, contents: FIGURE.() -> Unit = empty_contents) = contentTag(FIGURE(this), c, contents)
fun FIGURE.figcaption(c: String? = null, contents: FIGCAPTION.() -> Unit = empty_contents) = contentTag(FIGCAPTION(this), c, contents)
open class FIGURE(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "figure")
open class FIGCAPTION(containingTag: FIGURE) : HtmlBodyTag(containingTag, "figcaption")

fun HtmlBodyTag.canvas(c: String? = null, contents: CANVAS.() -> Unit = empty_contents) = contentTag(CANVAS(this), c, contents)
open class CANVAS(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "canvas") {
    public var width: Int by Attributes.width
    public var height: Int by Attributes.height
}

fun HtmlBodyTag.nav(c: String? = null, contents: NAV.() -> Unit = empty_contents) = contentTag(NAV(this), c, contents)
fun HtmlBodyTag.article(c: String? = null, contents: ARTICLE.() -> Unit = empty_contents) = contentTag(ARTICLE(this), c, contents)
fun HtmlBodyTag.aside(c: String? = null, contents: ASIDE.() -> Unit = empty_contents) = contentTag(ASIDE(this), c, contents)
fun HtmlBodyTag.section(c: String? = null, contents: SECTION.() -> Unit = empty_contents) = contentTag(SECTION(this), c, contents)
fun HtmlBodyTag.header(c: String? = null, contents: HEADER.() -> Unit = empty_contents) = contentTag(HEADER(this), c, contents)
fun HtmlBodyTag.footer(c: String? = null, contents: FOOTER.() -> Unit = empty_contents) = contentTag(FOOTER(this), c, contents)
fun HtmlBodyTag.details(c: String? = null, contents: DETAILS.() -> Unit = empty_contents) = contentTag(DETAILS(this), c, contents)
fun DETAILS.summary(c: String? = null, contents: SUMMARY.() -> Unit = empty_contents) = contentTag(SUMMARY(this), c, contents)

open class NAV(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "nav")
open class ARTICLE(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "article")
open class ASIDE(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "aside")
open class SECTION(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "section")
open class HEADER(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "header")
open class FOOTER(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "footer")
open class DETAILS(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "details")
open class SUMMARY(containingTag: DETAILS) : HtmlBodyTag(containingTag, "summary")

fun HtmlBodyTag.audio(c: String? = null, contents: AUDIO.() -> Unit = empty_contents) = contentTag(AUDIO(this), c, contents)
fun HtmlBodyTag.video(c: String? = null, contents: VIDEO.() -> Unit = empty_contents) = contentTag(VIDEO(this), c, contents)
fun MediaTag.track(c: String? = null, contents: TRACK.() -> Unit = empty_contents) = contentTag(TRACK(this), c, contents)
fun MediaTag.source(c: String? = null, contents: SOURCE.() -> Unit = empty_contents) = contentTag(SOURCE(this), c, contents)
abstract class MediaTag(containingTag: HtmlBodyTag, name: String) : HtmlBodyTag(containingTag, name)
open class AUDIO(containingTag: HtmlBodyTag) : MediaTag(containingTag, "audio")
open class VIDEO(containingTag: HtmlBodyTag) : MediaTag(containingTag, "video")
open class TRACK(containingTag: MediaTag) : HtmlBodyTag(containingTag, "track")
open class SOURCE(containingTag: MediaTag) : HtmlBodyTag(containingTag, "source")

fun HtmlBodyTag.embed(c: String? = null, contents: EMBED.() -> Unit = empty_contents) = contentTag(EMBED(this), c, contents)
open class EMBED(containingTag: HtmlBodyTag) : HtmlBodyTag(containingTag, "embed")
