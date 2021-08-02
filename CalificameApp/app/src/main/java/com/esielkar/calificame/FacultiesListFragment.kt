package com.esielkar.calificame

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.esielkar.calificame.databinding.FragmentFacultiesListBinding
import com.esielkar.calificame.model.University
import com.esielkar.calificame.placeholder.UniversityPlaceholderContent
import com.esielkar.calificame.view.adapter.FacultiesAdapter
import com.esielkar.calificame.viewmodel.FacultiesListViewModel

class FacultiesListFragment : Fragment() {
    private var university: University? = null
    private var _binding: FragmentFacultiesListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_UNI)) {
                university = it.getParcelable(ARG_UNI)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFacultiesListBinding.inflate(inflater, container, false)

        binding.headerCV.title = university?.name.toString()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.facultiesList
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
        recyclerView.adapter = FacultiesAdapter(UniversityPlaceholderContent.universities.first().faculties)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = FacultiesListFragment()
        const val ARG_UNI = "UNIVERSITY"
    }
}