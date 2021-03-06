package com.esielkar.calificame.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.esielkar.calificame.R
import com.esielkar.calificame.databinding.FragmentUniversitiesListBinding
import com.esielkar.calificame.model.University
import com.esielkar.calificame.utils.AppContent
import com.esielkar.calificame.view.adapter.UniversitiesAdapter

class UniversitiesListFragment : Fragment() {

    private var _binding: FragmentUniversitiesListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUniversitiesListBinding.inflate(layoutInflater, container, false)
        //(requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (AppContent.currentFaculty != null) {
            findNavController().navigate(R.id.action_universities_list_fragment_to_faculties_list_fragment)
        }
        setupRecyclerView(binding.universitiesList, onClickListener = {
            val bundle = Bundle()

            bundle.putParcelable(FacultiesListFragment.ARG_UNI, it.tag as University) //TODO: Parcelable
            AppContent.currentUniversity = it.tag as University //TODO: Content

            it.findNavController().navigate(R.id.action_universities_list_fragment_to_faculties_list_fragment, bundle)
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setupRecyclerView(
        recyclerView: RecyclerView,
        onClickListener: View.OnClickListener? = null
    ) {
        ResourcesCompat.getDrawable(resources, R.drawable.divider, null)?.let {
            recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
                setDrawable(it)
            })
        }
        recyclerView.adapter = UniversitiesAdapter(AppContent.universities, onClickListener)
    }

    companion object {
        @JvmStatic
        fun newInstance() = UniversitiesListFragment()
    }
}