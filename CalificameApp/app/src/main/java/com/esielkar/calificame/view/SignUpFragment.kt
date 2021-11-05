package com.esielkar.calificame.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.esielkar.calificame.CalificameApplication
import com.esielkar.calificame.R
import com.esielkar.calificame.UniversityFacultiesActivity
import com.esielkar.calificame.databinding.FragmentSignUpBinding
import com.esielkar.calificame.utils.*
import com.esielkar.calificame.viewmodel.UserViewModel

class SignUpFragment : Fragment() {

    private lateinit var preferences: SharedPreferences
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    private val application by lazy { requireActivity().applicationContext as CalificameApplication }
    private val userViewModel : UserViewModel by lazy { UserViewModel(application.userRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferences = requireActivity().getSharedPreferences(AppContent.PREFS_NAME, Context.MODE_PRIVATE)
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_sign_up, container, false)
        binding.lifecycleOwner = this

        binding.apply {
            lifecycleOwner = this@SignUpFragment
            this.viewModel = userViewModel
        }

        userViewModel.apply {
            with(viewLifecycleOwner) {
                warning.observe(this) {
                    if (it != null) {
                        showToasty(requireContext(), WARNING, getString(it), Toast.LENGTH_SHORT, true, null, null)
                    }
                }
                error.observe(this) {
                    if (it != null) {
                        showToasty(requireContext(), ERROR, getString(it), Toast.LENGTH_SHORT, true, null, null)
                        //showSnackbar(requireView(), it, R.string.understood)
                    }
                }

                fError.observe(this) {
                    if (it != null) {
                        showToasty(requireContext(), ERROR, it, Toast.LENGTH_SHORT, true, null, null)
                    }
                }

                user.observe(this) {
                    UsersContent.currentUser = it
                    toUniversityFacultiesActivity()
                }
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInTextButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_sign_up_fragment_to_sign_in_fragment)
        }

        binding.signUpButton.setOnClickListener {
            userViewModel.signUp()
        }

        binding.skipSignUpTextButton.setOnClickListener {
            toUniversityFacultiesActivity()
        }
    }

    private fun toUniversityFacultiesActivity() {
        var intent = Intent(context, UniversityFacultiesActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}