package com.esielkar.calificame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.esielkar.calificame.databinding.FragmentGeneralStatsBinding
import com.esielkar.calificame.model.Score
import com.esielkar.calificame.placeholder.UniversityContent

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

        binding.headerCV.title = UniversityContent.currentProfessorStats?.first?.name ?: ""
        binding.headerCV.subtitle = UniversityContent.currentFaculty?.name
        binding.headerCV.overline = UniversityContent.currentUniversity?.name

        val stats = UniversityContent.currentProfessorStats?.second?.generalStats

        binding.recommendationCV.stats = stats?.first?.first?.toInt() ?: 0
        binding.complexityCV.stats = stats?.first?.second?.toInt() ?: 0
        binding.clarityCV.stats = stats?.first?.third?.toInt() ?: 0

        binding.domainCV.stats = stats?.second?.first?.toInt() ?: 0
        binding.consultanciesCV.stats = stats?.second?.second?.toInt() ?: 0
        binding.fairEvaluationCV.stats = stats?.second?.third?.toInt() ?: 0

        binding.addReviewButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_generalStatsFragment_to_addReviewFragment)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = GeneralStatsFragment()
    }
}