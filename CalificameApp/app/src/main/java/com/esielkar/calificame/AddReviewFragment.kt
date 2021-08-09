package com.esielkar.calificame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.esielkar.calificame.databinding.FragmentAddReviewBinding
import com.esielkar.calificame.model.*
import com.esielkar.calificame.placeholder.AppContent

class AddReviewFragment : Fragment() {

    private var _binding: FragmentAddReviewBinding? = null
    private val binding get() = _binding!!
    private lateinit var satisfaction : Satisfaction
    private lateinit var domain : Score
    private lateinit var clarity : Score
    private lateinit var complexity : Difficulty
    private lateinit var consultancies : Frecuency
    private lateinit var fairEvaluation : YesNo
    private lateinit var exams : YesNo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddReviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.headerCV.title = AppContent.currentProfessorStats?.first?.name.toString() //professor
        binding.headerCV.subtitle = AppContent.currentFaculty?.name  //faculty
        binding.headerCV.overline = AppContent.currentUniversity?.name  //university

        binding.addReviewButton.setOnClickListener {
            updateStats()
            AppContent.currentProfessorStats?.second?.add(
                SubjectStats(
                    recommendation = satisfaction.getValue(),
                    clarity = clarity.getValue(),
                    complexity = complexity.getValue(),
                    domain = domain.getValue(),
                    consultancies = consultancies.getValue(),
                    fairEvaluation = fairEvaluation.getValue(),
                    applyExams = exams.getValue(),
                    examsCount = 0,
                    facility = (satisfaction.getValue() + clarity.getValue() + domain.getValue()) / 3
                ), Subject("Prueba")
            )
            Toast.makeText(context, "Stats successfully added", Toast.LENGTH_LONG).show()
            it.findNavController().popBackStack()
        }

    }
    fun updateStats() {
        satisfaction = when (binding.satisfactionGroup.checkedRadioButtonId) {
            R.id.satisfaction_btn_satisfied -> Satisfaction.SATISFIED
            R.id.satisfaction_btn_half_satisfied -> Satisfaction.HALF_SATISFIED
            else -> Satisfaction.DISSATISFIED
        }

        domain = when (binding.domainGroup.checkedRadioButtonId) {
            R.id.domain_btn_excellent -> Score.EXCELLENT
            R.id.domain_btn_good -> Score.GOOD
            R.id.domain_btn_regular -> Score.REGULAR
            R.id.domain_btn_bad -> Score.BAD
            else -> Score.TERRIBLE
        }

        clarity = when (binding.domainGroup.checkedRadioButtonId) {
            R.id.domain_btn_excellent -> Score.EXCELLENT
            R.id.domain_btn_good -> Score.GOOD
            R.id.domain_btn_regular -> Score.REGULAR
            R.id.domain_btn_bad -> Score.BAD
            else -> Score.TERRIBLE
        }

        complexity = when (binding.complexityGroup.checkedRadioButtonId) {
            R.id.complexity_btn_very_hard -> Difficulty.VERY_HARD
            R.id.complexity_btn_hard -> Difficulty.HARD
            R.id.complexity_btn_regular -> Difficulty.REGULAR
            R.id.complexity_btn_easy -> Difficulty.EASY
            else ->  Difficulty.VERY_EASY
        }

        consultancies = when (binding.consultanciesGroup.checkedRadioButtonId) {
            R.id.consultancies_btn_always -> Frecuency.ALWAYS
            R.id.consultancies_btn_sometimes -> Frecuency.SOMETIMES
            else ->  Frecuency.NEVER
        }

        fairEvaluation = when (binding.fairEvaluationGroup.checkedRadioButtonId) {
            R.id.fairEvaluation_btn_yes -> YesNo.YES
            else ->  YesNo.NO
        }

        exams = when (binding.examsGroup.checkedRadioButtonId) {
            R.id.exams_btn_yes -> YesNo.YES
            else ->  YesNo.NO
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = AddReviewFragment()
    }
}