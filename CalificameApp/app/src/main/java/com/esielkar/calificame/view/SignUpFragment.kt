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
import com.esielkar.calificame.databinding.FragmentSignUpBinding
import com.esielkar.calificame.model.User
import com.esielkar.calificame.utils.AppContent
import com.esielkar.calificame.utils.UIUtils
import com.esielkar.calificame.utils.UsersContent
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

        binding.signInTextButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_sign_up_fragment_to_sign_in_fragment)
        }

        binding.signUpButton.setOnClickListener {
            userViewModel.signup()
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

    private fun validateData(username: String, email: String, password: String): Boolean{
        return when {
            username.isNotBlank() && password.isNotBlank() && email.isNotBlank() -> {
                var vUsername = UsersContent.validUsername(username)
                var vEmail = UsersContent.validEmail(email)

                if(vUsername && vEmail){
                    UsersContent.add(User(
                        username = username,
                        email = email,
                        password = password)
                    )
                    UsersContent.currentUser = UsersContent.validUser(email, password)
                    preferences.edit()
                        .putString(UsersContent.SP_EMAIL, email)
                        .putString(UsersContent.SP_PASSWORD, password)
                        .putBoolean(UsersContent.SP_IS_LOGGED, true)
                        .apply()
                    return true
                }else{
                    if (!vUsername) binding.usernameEditText.error = getString(R.string.error_username)
                    if (!vEmail) binding.emailEditText.error = getString(R.string.error_email)
                    false
                }
            }
            else -> {
                binding.usernameEditText.error = getString(R.string.error_noUsername)
                binding.emailEditText.error = getString(R.string.error_noEmail)
                binding.passwordEditText.error = getString(R.string.error_noPassword)
                false
            }
        }
    }
}