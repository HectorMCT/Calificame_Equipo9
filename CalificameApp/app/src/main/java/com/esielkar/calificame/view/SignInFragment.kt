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
import androidx.navigation.findNavController
import com.esielkar.calificame.R
import com.esielkar.calificame.UniversityFacultiesActivity
import com.esielkar.calificame.databinding.FragmentSignInBinding
import com.esielkar.calificame.placeholder.AppContent
import com.esielkar.calificame.placeholder.UsersContent

class SignInFragment : Fragment() {
    private var username : String? = null
    private var email : String? = null
    private var password : String? = null
    private lateinit var preferences: SharedPreferences
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferences = requireActivity().getSharedPreferences(AppContent.PREFS_NAME, Context.MODE_PRIVATE)
        arguments?.let {
            username = it.getString(ARG_USERNAME)
            email = it.getString(ARG_EMAIL)
            password = it.getString(ARG_PASSWORD)
        }
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.emailEditText.setText(email)
        binding.passwordEditText.setText(password)

        binding.signUpTextButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(SignUpFragment.ARG_USERNAME, username)
            bundle.putString(SignUpFragment.ARG_EMAIL, binding.emailEditText.text?.toString())
            bundle.putString(SignUpFragment.ARG_PASSWORD, binding.passwordEditText.text?.toString())
            it.findNavController().navigate(R.id.action_sign_in_fragment_to_sign_up_fragment, bundle)
        }

        binding.forgotPasswordTextButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(PasswordForgottenFragment.ARG_USERNAME, username)
            bundle.putString(PasswordForgottenFragment.ARG_EMAIL, binding.emailEditText.text?.toString())
            bundle.putString(PasswordForgottenFragment.ARG_PASSWORD, binding.passwordEditText.text?.toString())
            it.findNavController().navigate(R.id.action_sign_in_fragment_to_password_forgotten_fragment, bundle)
        }

        binding.signInButton.setOnClickListener {
            //TODO: VALIDAR SIGN IN (EL USUARIO EXISTE)
            if (validateData(binding.emailEditText.text.toString(), binding.passwordEditText.text.toString()))
                toUniversityFacultiesActivity()
        }

        binding.skipSignInTextButton.setOnClickListener {
            //TODO: ENTRO COMO INVITADO
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


    private fun validateData(email: String, password: String): Boolean{
        return when {
            password.isNotBlank() && email.isNotBlank() -> {
                var vEmail = UsersContent.validEmail(email)
                var vUser = UsersContent.validUser(email, password)
                if(vEmail && vUser != null) {
                    UsersContent.currentUser = vUser
                    preferences.edit()
                        .putString(UsersContent.SP_EMAIL, email)
                        .putString(UsersContent.SP_PASSWORD, password)
                        .putBoolean(UsersContent.SP_IS_LOGGED, true)
                        .apply()
                    true
                }else{
                    if(vUser == null) binding.passwordEditText.error = getString(R.string.error_password)
                    if (!vEmail) binding.emailEditText.error = getString(R.string.error_email)
                    false
                }
            }else -> {
                binding.emailEditText.error = getString(R.string.error_noEmail)
                binding.passwordEditText.error = getString(R.string.error_noPassword)
                false
            }
        }
    }
}