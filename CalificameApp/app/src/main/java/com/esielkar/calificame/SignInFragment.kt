package com.esielkar.calificame

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.esielkar.calificame.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {
    private var username : String? = null
    private var email : String? = null
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            username = it.getString(ARG_USERNAME)
            email = it.getString(ARG_EMAIL)
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

        binding.signUpTextButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(SignUpFragment.ARG_USERNAME, username)
            bundle.putString(SignUpFragment.ARG_USERNAME, email)
            it.findNavController().navigate(R.id.action_sign_in_fragment_to_sign_up_fragment, bundle)
        }

        binding.forgotPasswordTextButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(PasswordForgottenFragment.ARG_USERNAME, username)
            bundle.putString(PasswordForgottenFragment.ARG_USERNAME, email)
            it.findNavController().navigate(R.id.action_sign_in_fragment_to_password_forgotten_fragment, bundle)
        }

        binding.signInButton.setOnClickListener {
            //VALIDAR SIGN IN
            toMainActivity()
        }

        binding.skipSignInTextButton.setOnClickListener {
            toMainActivity()
        }
    }

    private fun toMainActivity() {
        val intent = Intent(context, MainActivity::class.java)
        startActivity(intent)
        activity?.finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val ARG_USERNAME = "USERNAME"
        const val ARG_EMAIL = "EMAIL"
        @JvmStatic
        fun newInstance(username: String, email: String) =
            SignInFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_USERNAME, username)
                    putString(ARG_EMAIL, email)
                }
            }
    }
}