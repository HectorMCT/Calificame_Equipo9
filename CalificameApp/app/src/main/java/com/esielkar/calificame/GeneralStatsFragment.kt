package com.esielkar.calificame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.esielkar.calificame.databinding.FragmentGeneralStatsBinding

class GeneralStatsFragment : Fragment() {

    private var _binding: FragmentGeneralStatsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGeneralStatsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addReviewButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_generalStatsFragment_to_addReviewFragment)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = GeneralStatsFragment()
    }
}