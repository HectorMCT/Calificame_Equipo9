package com.esielkar.calificame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.esielkar.calificame.databinding.FragmentAddReviewBinding
import com.esielkar.calificame.model.*

class AddReviewFragment : Fragment() {

    private var _binding: FragmentAddReviewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddReviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.satisfactionSpinner.adapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item,
            resources.getStringArray(R.array.satisfaction)
        )

        binding.domainSpinner.adapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item,
            resources.getStringArray(R.array.score)
        )

        binding.claritySpinner.adapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item,
            resources.getStringArray(R.array.score)
        )

        binding.complexitySpinner.adapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item,
            resources.getStringArray(R.array.difficulty)
        )

        binding.consultanciesSpinner.adapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item,
            resources.getStringArray(R.array.frecuency)
        )

        binding.fairEvaluationSpinner.adapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item,
            resources.getStringArray(R.array.frecuency)
        )

        binding.examsSpinner.adapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item,
            resources.getStringArray(R.array.YesNo)
        )

        binding.addReviewButton.setOnClickListener {
            //TODO: ADD REVIEW
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = AddReviewFragment()
    }
}