package com.esielkar.calificame

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.esielkar.calificame.databinding.FragmentFacultiesListBinding
import com.esielkar.calificame.model.Faculty
import com.esielkar.calificame.model.University
import com.esielkar.calificame.placeholder.UniversityContent
import com.esielkar.calificame.view.adapter.FacultiesAdapter

class FacultiesListFragment : Fragment() {
    private var university: University? = null //TODO: Parcelable
    private var _binding: FragmentFacultiesListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_UNI)) {
                university = it.getParcelable(ARG_UNI) //TODO: PARCELABLE
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFacultiesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.headerCV.title = university?.name.toString()
        val recyclerView = binding.facultiesList
        setupRecyclerView(recyclerView, onClickListener = {
            val bundle = Bundle()
            //TODO: PARCELABLE
            bundle.putString(ProfessorStatsListFragment.ARG_UNI_NAME, university?.name)
            bundle.putParcelable(ProfessorStatsListFragment.ARG_FAC, it.tag as Faculty)

            //TODO: CONTENT
            UniversityContent.currentFaculty = it.tag as Faculty
            //Intent
            var intent = Intent(requireActivity(), MainActivity::class.java)
            startActivity(intent, bundle)
            requireActivity().finish()
        })
    }

    private fun setupRecyclerView(
        recyclerView: RecyclerView,
        onClickListener: View.OnClickListener? = null,
    ) {
        ResourcesCompat.getDrawable(resources, R.drawable.divider, null)?.let {
            recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
                setDrawable(it)
            })
        }
        //recyclerView.adapter = FacultiesAdapter(university?.faculties ?: setOf(), onClickListener) //TODO: PARCELABLE
        recyclerView.adapter = FacultiesAdapter(UniversityContent.currentUniversity?.faculties ?: setOf(), onClickListener) //TODO: CONTENT
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(university: University) = FacultiesListFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ARG_UNI, university)
            }
        }
        const val ARG_UNI = "UNIVERSITY"
    }
}