package com.esielkar.calificame.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.esielkar.calificame.R
import com.esielkar.calificame.databinding.FragmentReviewsListBinding
import com.esielkar.calificame.utils.AppContent
import com.esielkar.calificame.view.adapter.ReviewsAdapter

class ReviewsListFragment : Fragment() {
    private var _binding: FragmentReviewsListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReviewsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.headerCV.title = AppContent.currentProfessorStats?.first?.name ?: ""
        binding.headerCV.subtitle = AppContent.currentFaculty?.name
        binding.headerCV.overline = AppContent.currentUniversity?.name

        val recyclerView = binding.reviewsList
        setupRecyclerView(recyclerView)
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
        recyclerView.adapter = ReviewsAdapter(
            AppContent.currentProfessorStats?.second?.getReviews(
                AppContent.subject) ?: listOf(), onClickListener)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = ReviewsListFragment()
    }
}