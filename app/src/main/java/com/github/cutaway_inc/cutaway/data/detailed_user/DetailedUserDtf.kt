package com.github.cutaway_inc.cutaway.data.detailed_user

import com.github.cutaway_inc.cutaway.data.detailed_user.user_link.LinkDtf
import com.github.cutaway_inc.cutaway.data.detailed_user.user_project.ProjectDtf
import com.github.cutaway_inc.cutaway.data.user.UserDtf

data class DetailedUserDtf(
    val user: UserDtf,
    val projects: List<ProjectDtf>,
    val bio: String,
    val links: List<LinkDtf>,
    val isFollowing: Boolean
)

fun DetailedUserDtf.toUser(): DetailedUser {
    return DetailedUser(
        user = user,
        projects = projects,
        bio = bio,
        links = links,
        isFollowing = isFollowing
    )
}