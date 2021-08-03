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
    private var _binding: FragmentSignUpBinding? = null
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
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.usernameEditText.setText(username)
        binding.emailEditText.setText(email)


        binding.signInTextButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(SignInFragment.ARG_USERNAME, username)
            bundle.putString(SignInFragment.ARG_USERNAME, email)
            it.findNavController().navigate(R.id.action_sign_up_fragment_to_sign_in_fragment, bundle)
        }

        binding.signUpButton.setOnClickListener {
            //VALIDAR SIGN UP
            toMainActivity()
        }

        binding.skipSignUpTextButton.setOnClickListener {
            toMainActivity()
        }
    }

    private fun toMainActivity() {
        var intent = Intent(context, MainActivity::class.java)
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
            SignUpFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_USERNAME, username)
                    putString(ARG_EMAIL, email)
                }
            }
    }
}