package com.github.cutaway_inc.cutaway.ui.navigation.home.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.cutaway_inc.cutaway.MainActivity
import com.github.cutaway_inc.cutaway.R
import com.github.cutaway_inc.cutaway.data.user.UserDtf
import com.github.cutaway_inc.cutaway.databinding.FragmentUsersFeedBinding
import com.github.cutaway_inc.cutaway.ui.features.anim.AnimationForce
import com.github.cutaway_inc.cutaway.ui.features.anim.ViewAnimation
import com.github.cutaway_inc.cutaway.ui.navigation.home.global_search.SearchFragment
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

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

        val feedRecycler = initFeedRecycler()

        binding.globalSearchTiText.setOnClickListener {
            transactSearchFragment(SearchFragment())
        }

        lifecycleScope.launch {
            feedViewModel.getUsersResp().collectLatest { usersResp ->
                setAdapter(recycler = feedRecycler, content = usersResp)
                ViewAnimation().submitScaleAnim(view = feedRecycler, force = AnimationForce.LOW)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initFeedRecycler(): RecyclerView {
        val recycler = binding.feedRv
        val layoutManager = GridLayoutManager(requireContext(), 1)
        recycler.layoutManager = layoutManager
        setAdapter(recycler)
        return recycler
    }

    private fun setAdapter(recycler: RecyclerView, content: List<UserDtf> = emptyList()) {
        val adapter = FeedAdapter(
            requireContext(),
            requireActivity() as MainActivity,
            users = content
        )
        recycler.adapter = adapter
    }

    private fun transactSearchFragment(frag: SearchFragment) {
        requireActivity().supportFragmentManager.beginTransaction().apply {
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            setCustomAnimations(
                R.anim.slide_up,
                R.anim.stub_anim,
                R.anim.slide_down,
                R.anim.stub_anim
            )
            replace(R.id.home_fragment_container, frag)
            addToBackStack(null)
            commit()
        }
    }
}