package com.github.cutaway_inc.cutaway.ui.following

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.cutaway_inc.cutaway.databinding.FragmentFollowingBinding

class FollowingFragment : Fragment() {

    private lateinit var followingViewModel: FollowingViewModel
    private var _binding: FragmentFollowingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        followingViewModel =
            ViewModelProvider(this).get(FollowingViewModel::class.java)

        _binding = FragmentFollowingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        followingViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}