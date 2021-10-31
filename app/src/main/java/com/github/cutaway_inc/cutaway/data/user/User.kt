package com.github.cutaway_inc.cutaway.data.user

data class User(
    val userId: Int,
    val username: String,
    val fullName: String,
    val avatarLink: String,
    val numberOfFollowers: Int
)