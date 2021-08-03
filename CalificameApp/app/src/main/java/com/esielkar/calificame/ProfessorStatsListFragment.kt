package com.esielkar.calificame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.esielkar.calificame.databinding.FragmentProfessorStatsListBinding
import com.esielkar.calificame.model.University
import com.esielkar.calificame.placeholder.UniversityContent
import com.esielkar.calificame.view.adapter.ProfessorsAdapter

class ProfessorStatsListFragment : Fragment() {

    private var _binding: FragmentProfessorStatsListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(FacultiesListFragment.ARG_UNI)) {
                //university = it.getParcelable(FacultiesListFragment.ARG_UNI) //TODO: Aqui se recibe el parametro
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfessorStatsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.headerCV.title = UniversityContent.universities.first().name
        binding.headerCV.subtitle = UniversityContent.universities.first().faculties.first().name
        val recyclerView = binding.rec
        setupRecyclerView(recyclerView)
    }

    private fun setupRecyclerView(
        recyclerView: RecyclerView,
        onClickListener: View.OnClickListener? = null,
        onLongClickListener: View.OnLongClickListener? = null
    ) {
        ResourcesCompat.getDrawable(resources, R.drawable.divider, null)?.let {
            recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
                setDrawable(it)
            })
        }
        recyclerView.adapter =
            UniversityContent.universities.first().faculties.first().getProfessorsWithStatsAndReviewsCounts().let {
                ProfessorsAdapter(
                    it.toSet()
                )
            } //TODO: Prueba
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(university: University) = ProfessorStatsListFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ARG_UNI, university)
            }
        }
        const val ARG_UNI = "UNIVERSITY"
    }
}