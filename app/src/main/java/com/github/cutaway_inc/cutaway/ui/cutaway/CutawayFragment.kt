package com.github.cutaway_inc.cutaway.ui.cutaway

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.cutaway_inc.cutaway.MainActivity
import com.github.cutaway_inc.cutaway.R
import com.github.cutaway_inc.cutaway.databinding.FragmentCutawayBinding
import com.github.cutaway_inc.cutaway.ui.cutaway.social_network.SocialNetwork
import com.github.cutaway_inc.cutaway.ui.cutaway.social_network.SocialNetworksAdapter
import com.github.cutaway_inc.cutaway.ui.features.anim.AnimationForce
import com.github.cutaway_inc.cutaway.ui.features.anim.ViewAnimator
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CutawayFragment : Fragment(R.layout.fragment_cutaway) {

    private lateinit var cutawayViewModel: CutawayViewModel
    private var _binding: FragmentCutawayBinding? = null
    private val binding get() = _binding!!
    private val viewAnimator = ViewAnimator()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        cutawayViewModel = ViewModelProvider(this)[CutawayViewModel::class.java]

        _binding = FragmentCutawayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val socialNetRv = initSocialNetworksRv()
        val followBtn = binding.userCutawayFollowBtn
        val fastConnectBtn = binding.userCutawayFastConnectBtn
        val userLinksBtn = binding.userCutawayLinksBtn
        val userAchievesBtn = binding.userCutawayAchievementsBtn


        listOf(followBtn, fastConnectBtn, userLinksBtn, userAchievesBtn).forEach {
            viewAnimator.submitScaleAnim(it, AnimationForce.STRONG)
        }

        lifecycleScope.launch {
            cutawayViewModel.getSocialNetworks().collectLatest { socialNetResp ->
                submitSocialNetworksRvAdapter(recycler = socialNetRv, content = socialNetResp)
                viewAnimator.submitScaleAnim(view = socialNetRv, force = AnimationForce.STRONG)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initSocialNetworksRv(): RecyclerView {
        val recycler = binding.socialNetworksRv
        val adapter = SocialNetworksAdapter(
            requireContext(),
            requireActivity() as MainActivity,
            listOf(
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
        )
        val layoutManager = getHorizontalRVManager()
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
        return recycler
    }

    private fun submitSocialNetworksRvAdapter(
        recycler: RecyclerView,
        content: List<SocialNetwork>
    ) {
        val adapter = SocialNetworksAdapter(
            requireContext(),
            requireActivity() as MainActivity,
            socialNetworks = content
        )
        recycler.adapter = adapter
    }

    private fun getHorizontalRVManager(): LinearLayoutManager {
        return LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }
}