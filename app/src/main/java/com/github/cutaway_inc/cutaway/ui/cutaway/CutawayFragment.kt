package com.github.cutaway_inc.cutaway.ui.cutaway

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.cutaway_inc.cutaway.MainActivity
import com.github.cutaway_inc.cutaway.R
import com.github.cutaway_inc.cutaway.databinding.FragmentCutawayBinding
import com.github.cutaway_inc.cutaway.ui.cutaway.social_network.SocialNetwork
import com.github.cutaway_inc.cutaway.ui.cutaway.social_network.SocialNetworksAdapter

class CutawayFragment : Fragment(R.layout.fragment_cutaway) {

    private lateinit var cutawayViewModel: CutawayViewModel
    private var _binding: FragmentCutawayBinding? = null
    private val binding get() = _binding!!

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
        val socialNetworksRecycler = binding.socialNetworksRv
        val adapter = SocialNetworksAdapter(
            requireContext(),
            requireActivity() as MainActivity,
            listOf(
                SocialNetwork("telegram", "https://t.me/karchx"),
                SocialNetwork("vk", "https://vk.com/karchx"),
                SocialNetwork("instagram", "https://instagram.com/the_karchx"),
                SocialNetwork("linkedin", "some_link"),
                SocialNetwork("twitter", "link"),
                SocialNetwork("wechat", "link")
            )
        )
        val layoutManager = getHorizontalRVManager()
        socialNetworksRecycler.layoutManager = layoutManager
        socialNetworksRecycler.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getHorizontalRVManager(): LinearLayoutManager {
        return LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }
}