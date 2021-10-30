package com.github.cutaway_inc.cutaway.ui.navigation.personal_cutaway

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.cutaway_inc.cutaway.databinding.FragmentPersonalCutawayBinding

class PersonalCutawayFragment : Fragment() {

    private lateinit var personalCutawayViewModel: PersonalCutawayViewModel
    private var _binding: FragmentPersonalCutawayBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        personalCutawayViewModel =
            ViewModelProvider(this)[PersonalCutawayViewModel::class.java]

        _binding = FragmentPersonalCutawayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}