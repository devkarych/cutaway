package com.github.cutaway_inc.cutaway.data.detailed_user

import com.github.cutaway_inc.cutaway.data.detailed_user.user_link.LinkDtf
import com.github.cutaway_inc.cutaway.data.detailed_user.user_project.ProjectDtf
import com.github.cutaway_inc.cutaway.data.user.UserDtf

data class DetailedUser(
    val user: UserDtf,
    val projects: List<ProjectDtf>,
    val bio: String,
    val links: List<LinkDtf>,
    val isFollowing: Boolean
)