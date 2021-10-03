package com.esielkar.calificame.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.esielkar.calificame.CalificameApplication
import com.esielkar.calificame.R
import com.esielkar.calificame.UniversityFacultiesActivity
import com.esielkar.calificame.databinding.FragmentSignInBinding
import com.esielkar.calificame.utils.AppContent
import com.esielkar.calificame.utils.UIUtils
import com.esielkar.calificame.utils.UsersContent
import com.esielkar.calificame.viewmodel.UserViewModel

class SignInFragment : Fragment() {
    private lateinit var preferences: SharedPreferences
    private var _binding: FragmentSignInBinding? = null
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
    ): View {
        _binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_sign_in, container, false)
        binding.lifecycleOwner = this

        binding.apply {
            lifecycleOwner = this@SignInFragment
            this.viewModel = userViewModel
        }

        userViewModel.apply {
            with(viewLifecycleOwner) {
                error.observe(this) {
                    if (it != null) {
                        UIUtils.showSnackbar(requireView(), it, R.string.understood)
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

        binding.signUpTextButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_sign_in_fragment_to_sign_up_fragment)
        }

        binding.forgotPasswordTextButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(PasswordForgottenFragment.ARG_EMAIL, binding.emailEditText.text?.toString())
            bundle.putString(PasswordForgottenFragment.ARG_PASSWORD, binding.passwordEditText.text?.toString())
            it.findNavController().navigate(R.id.action_sign_in_fragment_to_password_forgotten_fragment, bundle)
        }

        binding.signInButton.setOnClickListener {
            userViewModel.signin()
        }

        binding.skipSignInTextButton.setOnClickListener {
            toUniversityFacultiesActivity()
        }
    }

    private fun toUniversityFacultiesActivity() {
        val intent = Intent(context, UniversityFacultiesActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val ARG_USERNAME = "USERNAME"
        const val ARG_EMAIL = "EMAIL"
        const val ARG_PASSWORD = "PASSWORD"
        @JvmStatic
        fun newInstance(username: String?, email: String?, password: String?) =
            SignInFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_USERNAME, username)
                    putString(ARG_EMAIL, email)
                    putString(ARG_PASSWORD, password)
                }
            }
    }
}