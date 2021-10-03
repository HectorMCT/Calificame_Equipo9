package com.esielkar.calificame.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.esielkar.calificame.CameraActivity
import com.esielkar.calificame.databinding.FragmentUserInformationBinding
import com.esielkar.calificame.utils.AppContent
import com.esielkar.calificame.utils.UsersContent
import java.io.File

class UserInformationFragment : Fragment() {
    private val binding by lazy { FragmentUserInformationBinding.inflate(layoutInflater) }
    private lateinit var preferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        preferences = requireActivity().getSharedPreferences(AppContent.PREFS_NAME, Context.MODE_PRIVATE)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.userTextView.text = UsersContent.currentUser?.username ?: ""
        binding.emailTextView.text = UsersContent.currentUser?.email ?: ""
        binding.changePasswordButton.setOnClickListener {
            Toast.makeText(requireContext(), "Functionality not implemented yet", Toast.LENGTH_LONG).show()
        }

        binding.changeImageButton.setOnClickListener {
            val intent = Intent(requireContext(), CameraActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        loadImage()
    }

    private fun loadImage() {
        val imageURI = preferences.getString(UsersContent.SP_IMAGE, null)
        if (imageURI != null && imageURI.isNotBlank()) {
            binding.shapeableImageView.setImageURI(Uri.fromFile(File(imageURI)))
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = AboutUsFragment()
    }
}