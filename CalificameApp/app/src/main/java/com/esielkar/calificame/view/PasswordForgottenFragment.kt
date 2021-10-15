package com.esielkar.calificame.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.esielkar.calificame.R
import com.esielkar.calificame.databinding.FragmentPasswordForgottenBinding
import com.esielkar.calificame.utils.AppContent
import com.google.firebase.crashlytics.CustomKeysAndValues
import com.google.firebase.crashlytics.FirebaseCrashlytics

class PasswordForgottenFragment : Fragment() {
    private var _binding: FragmentPasswordForgottenBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
    }

    override fun onStop() {
        super.onStop()
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
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

        binding.signUpButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_password_forgotten_fragment_to_sign_up_fragment)
        }
        binding.cancelButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_password_forgotten_fragment_to_sign_in_fragment)
        }

        binding.sendButton.setOnClickListener {
            //TODO: METODO PARA RECUPERAR LA CONTRASEÑA: FUERA DEL ALCANCE ACTUAL DE LA APLICACIÓN
            FirebaseCrashlytics.getInstance().setCustomKeys(
                CustomKeysAndValues.Builder()
                    .putString("Name", "Password Forgotten Fragment")
                    .putString("Data User", arguments.toString())
                    .putBoolean("LogIn", false)
                    .build())
        }
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
            PasswordForgottenFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_USERNAME, username)
                    putString(ARG_EMAIL, email)
                    putString(ARG_PASSWORD, password)
                }
            }
    }
}