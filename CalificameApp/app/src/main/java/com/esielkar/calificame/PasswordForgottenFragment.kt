package com.esielkar.calificame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.esielkar.calificame.databinding.FragmentPasswordForgottenBinding

class PasswordForgottenFragment : Fragment() {
    private var username : String? = null
    private var email : String? = null
    private var _binding: FragmentPasswordForgottenBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            username = it.getString(ARG_USERNAME)
            email = it.getString(ARG_EMAIL)
        }
    }

    override fun onStart() {
        super.onStart()
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPasswordForgottenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.emailEditText.setText(email)

        binding.signUpButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(SignUpFragment.ARG_USERNAME, username)
            bundle.putString(SignUpFragment.ARG_USERNAME, email)
            it.findNavController().navigate(R.id.action_password_forgotten_fragment_to_sign_up_fragment, bundle)
        }
        binding.cancelButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(SignInFragment.ARG_USERNAME, username)
            bundle.putString(SignInFragment.ARG_USERNAME, email)
            it.findNavController().navigate(R.id.action_password_forgotten_fragment_to_sign_in_fragment, bundle)
        }

        binding.sendButton.setOnClickListener {
            //Metodo de recuperamiento de contraseña
        }
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
            PasswordForgottenFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_USERNAME, username)
                    putString(ARG_EMAIL, email)
                }
            }
    }
}