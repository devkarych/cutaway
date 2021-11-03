package com.github.cutaway_inc.cutaway.ui.navigation.home.feed

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.github.cutaway_inc.cutaway.data.user.UserDtf
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FeedViewModel(application: Application) : AndroidViewModel(application) {

    fun getUsersResp(): Flow<List<UserDtf>> {
        return flow {
            val users = listOf(
                UserDtf(1, "karchx", "Andrey Karchevsky", "some_link", 15),
                UserDtf(1, "karchx1", "Andrey Karchevsky", "some_link", 15),
                UserDtf(1, "karchx2", "Andrey Karchevsky", "some_link", 15),
                UserDtf(1, "karchx3", "Andrey Karchevsky", "some_link", 15),
                UserDtf(1, "karchx4", "Andrey Karchevsky", "some_link", 15),
                UserDtf(1, "karchx5", "Andrey Karchevsky", "some_link", 15),
                UserDtf(1, "karchx6", "Andrey Karchevsky", "some_link", 15),
                UserDtf(1, "karchx7", "Andrey Karchevsky", "some_link", 15),
                UserDtf(1, "karchx8", "Andrey Karchevsky", "some_link", 15),
                UserDtf(1, "karchx9", "Andrey Karchevsky", "some_link", 15),
                UserDtf(1, "karchx10", "Andrey Karchevsky", "some_link", 15),
                UserDtf(1, "karchx11", "Andrey Karchevsky", "some_link", 15),
                UserDtf(1, "karchx12", "Andrey Karchevsky", "some_link", 15),
                UserDtf(1, "karchx13", "Andrey Karchevsky", "some_link", 15),
                UserDtf(1, "karchx14", "Andrey Karchevsky", "some_link", 15),
                UserDtf(1, "karchx15", "Andrey Karchevsky", "some_link", 15),
                UserDtf(1, "karchx16", "Andrey Karchevsky", "some_link", 15),
                UserDtf(1, "karchx17", "Andrey Karchevsky", "some_link", 15),
                UserDtf(1, "karchx18", "Andrey Karchevsky", "some_link", 15)
            )
            emit(users)
        }
    }
}