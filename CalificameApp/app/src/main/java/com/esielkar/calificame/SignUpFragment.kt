package com.esielkar.calificame

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.esielkar.calificame.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private var username : String? = null
    private var email : String? = null
    private var password : String? = null
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            username = it.getString(SignInFragment.ARG_USERNAME)
            email = it.getString(SignInFragment.ARG_EMAIL)
            password = it.getString(SignInFragment.ARG_PASSWORD)
        }
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.usernameEditText.setText(username)
        binding.emailEditText.setText(email)
        binding.passwordEditText.setText(password)


        binding.signInTextButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(SignInFragment.ARG_USERNAME, binding.usernameEditText.text?.toString())
            bundle.putString(SignInFragment.ARG_EMAIL, binding.emailEditText.text?.toString())
            bundle.putString(SignInFragment.ARG_PASSWORD, binding.passwordEditText.text?.toString())
            it.findNavController().navigate(R.id.action_sign_up_fragment_to_sign_in_fragment, bundle)
        }

        binding.signUpButton.setOnClickListener {
            //TODO: VALIDAR SIGN UP (REGISTRAR AL USUARIO)
            toUniversityFacultiesActivity()
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

    companion object {
        const val ARG_USERNAME = "USERNAME"
        const val ARG_EMAIL = "EMAIL"
        const val ARG_PASSWORD = "PASSWORD"
        @JvmStatic
        fun newInstance(username: String?, email: String?, password : String?) =
            SignUpFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_USERNAME, username)
                    putString(ARG_EMAIL, email)
                    putString(ARG_PASSWORD, password)
                }
            }
    }
}