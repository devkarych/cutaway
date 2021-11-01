package com.github.cutaway_inc.cutaway.ui.navigation.home.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.cutaway_inc.cutaway.R
import com.github.cutaway_inc.cutaway.databinding.FragmentHomeBinding
import com.github.cutaway_inc.cutaway.databinding.FragmentUsersFeedBinding
import com.github.cutaway_inc.cutaway.ui.cutaway.CutawayFragment

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}