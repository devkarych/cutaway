package com.github.cutaway_inc.cutaway.ui.cutaway

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.cutaway_inc.cutaway.R
import com.github.cutaway_inc.cutaway.databinding.FragmentCutawayBinding

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}