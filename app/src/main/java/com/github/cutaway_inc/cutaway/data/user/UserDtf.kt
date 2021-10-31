package com.github.cutaway_inc.cutaway.data.user

data class UserDtf(
    val userId: Int,
    val username: String,
    val fullName: String,
    val avatarLink: String,
    val numberOfFollowers: Int
)

fun UserDtf.toUser(): User {
    return User(
        userId = userId,
        username = username,
        fullName = fullName,
        avatarLink = avatarLink,
        numberOfFollowers = numberOfFollowers
    )
}