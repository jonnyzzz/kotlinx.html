package kotlinx.html

public trait Link {
    fun href(): String
}

class DirectLink(val href: String) : Link {
    override fun href() = href
}

public fun String.link(): Link = DirectLink(this)

