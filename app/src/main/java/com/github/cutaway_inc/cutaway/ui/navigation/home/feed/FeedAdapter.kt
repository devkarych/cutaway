package com.github.cutaway_inc.cutaway.ui.navigation.home.feed

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.github.cutaway_inc.cutaway.MainActivity
import com.github.cutaway_inc.cutaway.R
import com.github.cutaway_inc.cutaway.data.user.UserDtf
import com.github.cutaway_inc.cutaway.data.user.toUser

class FeedAdapter(
    private val context: Context,
    private val activity: MainActivity,
    private val users: List<UserDtf>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_HEADER = 0
    private val TYPE_ITEM = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == TYPE_ITEM) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.user_list_item, parent, false)
            return FeedViewHolder(view)
        } else if (viewType == TYPE_HEADER) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.rv_title_item, parent, false)
            return TitleViewHolder(view)
        }
        throw RuntimeException("there's no type that matches the allowed type.")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is FeedViewHolder) {
            val user = users[position - 1].toUser()
            setImage(holder, _imageId = "my_icon")
            holder.userUsername.text = "@${user.username}"
            holder.userFullName.text = user.fullName
            holder.userFollowers.text = ", ${user.numberOfFollowers} followers"
        } else if (holder is TitleViewHolder) {
            holder.title.text = activity.resources.getText(R.string.feed)
        }
    }

    override fun getItemCount(): Int {
        return users.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        if (isPositionHeader(position)) {
            return TYPE_HEADER
        }

        return TYPE_ITEM
    }

    private fun isPositionHeader(position: Int): Boolean {
        return position == 0
    }

    private fun setImage(holder: FeedViewHolder, _imageId: String) {
        try {
            val imageId = getImageId(_imageId)
            val image = ContextCompat.getDrawable(activity, imageId)
            holder.userImage.setImageDrawable(image)
        } catch (ex: java.lang.Exception) {
        }
    }

    private fun getImageId(imageId: String): Int {
        val defType = "drawable"
        val packageName = context.packageName
        return context.resources.getIdentifier(imageId.lowercase(), defType, packageName)
    }

    class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userImage: ImageView = itemView.findViewById(R.id.user_feed_icon)
        val userFullName: TextView = itemView.findViewById(R.id.user_feed_full_name)
        val userUsername: TextView = itemView.findViewById(R.id.user_feed_username)
        val userFollowers: TextView = itemView.findViewById(R.id.user_feed_followers)
    }

    class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.rv_title_tv)
    }
}