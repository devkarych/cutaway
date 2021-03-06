package com.github.cutaway_inc.cutaway.ui.navigation.home.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.github.cutaway_inc.cutaway.MainActivity
import com.github.cutaway_inc.cutaway.R
import com.github.cutaway_inc.cutaway.data.user.User
import com.github.cutaway_inc.cutaway.data.user.UserDtf
import com.github.cutaway_inc.cutaway.databinding.FragmentUsersFeedBinding
import com.github.cutaway_inc.cutaway.ui.features.AnimatedView
import com.github.cutaway_inc.cutaway.ui.navigation.home.global_search.SearchFragment

class FeedFragment : Fragment(R.layout.fragment_users_feed) {

    private lateinit var feedViewModel: FeedViewModel
    private var _binding: FragmentUsersFeedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        feedViewModel = ViewModelProvider(this)[FeedViewModel::class.java]

        _binding = FragmentUsersFeedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.globalSearchTiText.setOnClickListener {
            val searchFragment = SearchFragment()
            requireActivity().supportFragmentManager.beginTransaction().apply {
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                setCustomAnimations(
                    R.anim.slide_up,
                    R.anim.stub_anim,
                    R.anim.slide_down,
                    R.anim.stub_anim
                )
                replace(R.id.home_fragment_container, searchFragment)
                addToBackStack(null)
                commit()
            }
        }

        val recycler = binding.feedRv
        val feedList = mutableListOf<UserDtf>()
        for (i in 1..50) {
            feedList.add(UserDtf(1, "kaarych", "Andrey Karchevsky", "some_link", 1192),)
        }
        val adapter = FeedAdapter(
            requireContext(),
            requireActivity() as MainActivity,
            feedList
        )
        val layoutManager = GridLayoutManager(requireContext(), 1)
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter

        val rvAnimated = AnimatedView(recycler)
        rvAnimated.setScaleAnimation()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}