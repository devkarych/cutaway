package com.github.cutaway_inc.cutaway.data.detailed_user.user_link

data class LinkDtf(
    val title: String,
    val link: String
)

fun LinkDtf.toLink(): Link {
    return Link(
        title = title,
        link = link
    )
}