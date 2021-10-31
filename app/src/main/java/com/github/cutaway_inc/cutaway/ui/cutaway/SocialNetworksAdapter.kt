package com.github.cutaway_inc.cutaway.ui.cutaway

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.github.cutaway_inc.cutaway.MainActivity
import com.github.cutaway_inc.cutaway.R

class SocialNetworksAdapter(
    private val context: Context,
    private val activity: MainActivity,
    private val socialNetworks: List<SocialNetwork>
) : RecyclerView.Adapter<SocialNetworksAdapter.SocialNetworksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SocialNetworksViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.social_network_item, parent, false)
        return SocialNetworksViewHolder(view)
    }

    override fun onBindViewHolder(holder: SocialNetworksViewHolder, position: Int) {
        val socialNetworkTitle = socialNetworks[position].title
        setImage(holder, socialNetworkTitle)
    }

    override fun getItemCount(): Int {
        return socialNetworks.size
    }

    private fun setImage(holder: SocialNetworksViewHolder, socialNetworkTitle: String) {
        try {
            val imageId = getImageId(socialNetworkTitle)
            val image = ContextCompat.getDrawable(activity, imageId)
            holder.socialNetworkIV.setImageDrawable(image)
        } catch (ex: java.lang.Exception) {
        }
    }

    private fun getImageId(socialNetworkTitle: String): Int {
        val defType = "drawable"
        val packageName = context.packageName
        return context.resources.getIdentifier(socialNetworkTitle.lowercase(), defType, packageName)
    }

    class SocialNetworksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val socialNetworkIV: ImageView = itemView.findViewById(R.id.social_network_image)
    }
}