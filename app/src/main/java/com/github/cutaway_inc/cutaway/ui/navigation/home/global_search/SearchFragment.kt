package com.github.cutaway_inc.cutaway.ui.navigation.home.global_search

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.cutaway_inc.cutaway.R
import com.github.cutaway_inc.cutaway.databinding.FragmentUsersSearchBinding

class SearchFragment : Fragment(R.layout.fragment_users_search) {

    private lateinit var searchViewModel: SearchViewModel
    private var _binding: FragmentUsersSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        searchViewModel = ViewModelProvider(this)[SearchViewModel::class.java]

        _binding = FragmentUsersSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val globalSearchTiText = binding.globalSearchTiText
        binding.usersSearchScreen.setOnClickListener {
            hideKeyboard()
            globalSearchTiText.clearFocus()
        }

        Thread {
            globalSearchTiText.isFocusableInTouchMode = true
            globalSearchTiText.requestFocus()
            val lManager =
                requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            lManager.showSoftInput(globalSearchTiText, 0)
        }.run()


        binding.cancelSearchContainer.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStackImmediate()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun hideKeyboard() {
        val imm =
            requireActivity().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = requireActivity().currentFocus
        if (view == null) {
            view = View(requireActivity())
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}