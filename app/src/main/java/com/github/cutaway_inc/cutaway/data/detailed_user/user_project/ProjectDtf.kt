package com.github.cutaway_inc.cutaway.data.detailed_user.user_project

data class ProjectDtf(
    val title: String,
    val description: String,
    val link: String
)

fun ProjectDtf.toProject(): Project {
    return Project(
        title = title,
        description = description,
        link = link
    )
}