package com.github.cutaway_inc.cutaway.ui.cutaway

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.github.cutaway_inc.cutaway.ui.cutaway.social_network.SocialNetwork
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CutawayViewModel(application: Application) : AndroidViewModel(application) {

    fun getSocialNetworks(): Flow<List<SocialNetwork>> {
        return flow {
            val socialNetworks = listOf(
                SocialNetwork("telegram", "https://t.me/karchx"),
                SocialNetwork("vk", "https://vk.com/karchx"),
                SocialNetwork("instagram", "https://instagram.com/the_karchx"),
                SocialNetwork("linkedin", "some_link"),
                SocialNetwork("twitter", "link"),
                SocialNetwork("wechat", "link"),
                SocialNetwork("linkedin", "some_link"),
                SocialNetwork("twitter", "link"),
                SocialNetwork("wechat", "link")
            )
            emit(socialNetworks)
        }
    }
}