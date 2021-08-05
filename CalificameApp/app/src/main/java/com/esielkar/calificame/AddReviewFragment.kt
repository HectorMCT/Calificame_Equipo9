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

        binding.satisfactionSpinner.adapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item,
            arrayListOf(
                Satisfaction.VERY_SATISFIED.toString(),
                Satisfaction.SATISFIED.toString(),
                Satisfaction.NORMAL.toString(),
                Satisfaction.DISSATISFIED.toString()
            )
        )

        binding.domainSpinner.adapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item,
            arrayListOf(
                Score.EXCELLENT.toString(),
                Score.GOOD.toString(),
                Score.REGULAR.toString(),
                Score.BAD.toString(),
                Score.TERRIBLE.toString()
            )
        )

        binding.claritySpinner.adapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item,
            arrayListOf(
                Score.EXCELLENT.toString(),
                Score.GOOD.toString(),
                Score.REGULAR.toString(),
                Score.BAD.toString(),
                Score.TERRIBLE.toString()
            )
        )

        binding.complexitySpinner.adapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item,
            arrayListOf(
                Dificulty.VERY_EASY.toString(),
                Dificulty.EASY.toString(),
                Dificulty.REGULAR.toString(),
                Dificulty.HARD.toString(),
                Dificulty.VERY_HARD.toString()
            )
        )

        binding.consultanciesSpinner.adapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item,
            arrayListOf(
                Frecuency.ALWAYS.toString(),
                Frecuency.SOMETIMES.toString(),
                Frecuency.NEVER.toString()
            )
        )

        binding.fairEvaluationSpinner.adapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item,
            arrayListOf(
                Frecuency.ALWAYS.toString(),
                Frecuency.SOMETIMES.toString(),
                Frecuency.NEVER.toString()
            )
        )

        binding.examsSpinner.adapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item,
            arrayListOf(
                YesNo.YES.toString(),
                YesNo.NO.toString(),
            )
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
        @JvmStatic
        fun newInstance() = AddReviewFragment()
    }
}