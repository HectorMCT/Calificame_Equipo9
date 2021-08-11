package com.esielkar.calificame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.esielkar.calificame.databinding.FragmentProfessorStatsListBinding
import com.esielkar.calificame.model.Faculty
import com.esielkar.calificame.placeholder.AppContent
import com.esielkar.calificame.utils.ProfessorAndStats
import com.esielkar.calificame.view.adapter.ProfessorsAdapter

class ProfessorStatsListFragment : Fragment() {

    private var _binding: FragmentProfessorStatsListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(FacultiesListFragment.ARG_UNI)) {
                //university = it.getParcelable(FacultiesListFragment.ARG_UNI) //TODO: PARCELABLE
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
        binding.headerCV.title = AppContent.currentUniversity?.name.toString()
        binding.headerCV.subtitle = AppContent.currentFaculty?.name
        
        val recyclerView = binding.rec
        setupRecyclerView(recyclerView, onClickListener = {

            //TODO: CONTENT
            AppContent.currentProfessorStats = (it.tag as ProfessorAndStats)
            it.findNavController().navigate(R.id.action_professorStatsListFragment_to_generalStatsFragment)
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

        recyclerView.adapter = AppContent.currentFaculty?.professorStats?.let {
            ProfessorsAdapter(it, onClickListener)
        } //TODO: CONTENT
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        fun newInstance(universityName: String, faculty: Faculty) = ProfessorStatsListFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_UNI_NAME, universityName)
                putParcelable(ARG_FAC, faculty)
            }
        }
        const val ARG_UNI_NAME = "UNI_NAME"
        const val ARG_FAC = "FACULTY"
    }
}