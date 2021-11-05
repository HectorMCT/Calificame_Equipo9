package com.esielkar.calificame

import android.Manifest
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Size
import android.view.ViewGroup
import android.widget.Toast
import androidx.camera.core.*
import androidx.core.app.ActivityCompat
import com.esielkar.calificame.databinding.ActivityCameraBinding
import com.esielkar.calificame.utils.AppContent.PREFS_NAME
import com.esielkar.calificame.utils.UsersContent
import com.google.firebase.crashlytics.FirebaseCrashlytics
import java.io.File
import java.util.concurrent.Executors

class CameraActivity : AppCompatActivity() {
    companion object {
        const val PERMISSION_ID = 34
    }

    private val executor = Executors.newSingleThreadExecutor()
    private lateinit var binding: ActivityCameraBinding
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        if (checkCameraPermission())
            startCamera()
        else {
            requestPermissions()
        }
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_ID) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                startCamera()
            }
        }
    }

    private fun checkCameraPermission(): Boolean{
        return ActivityCompat
            .checkSelfPermission(this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.CAMERA),
            PERMISSION_ID
        )
    }

    fun startCamera() {
        val previewConfig = PreviewConfig.Builder().apply {
            setTargetResolution(Size(640, 480)) //ajustando resolución
        }.build()

        val preview = Preview(previewConfig)

        preview.setOnPreviewOutputUpdateListener {

            val parent = binding.root as ViewGroup
            parent.removeView(binding.cameraPreview)
            parent.addView(binding.cameraPreview, 0)

            binding.cameraPreview.setSurfaceTexture(it.surfaceTexture)
        }

        val imageCapture = captureConfig()
        CameraX.bindToLifecycle(this, preview, imageCapture)
    }


    fun captureConfig(): ImageCapture {
        val imageCaptureConfig = ImageCaptureConfig.Builder()
            .apply {
                setCaptureMode(ImageCapture.CaptureMode.MIN_LATENCY)
            }.build()

        val imageCapture = ImageCapture(imageCaptureConfig)


        binding.captureButton.setOnClickListener {
            val file = File(
                externalMediaDirs.first(),
                "${System.currentTimeMillis()}.jpg"
            )

            imageCapture.takePicture(file, executor,
                object : ImageCapture.OnImageSavedListener {

                    override fun onError(
                        imageCaptureError: ImageCapture.ImageCaptureError,
                        message: String,
                        exc: Throwable?
                    ) {
                        val msg = "Photo capture failed: $message"
                        Log.e("CameraXApp", msg, exc)
                        binding.cameraPreview.post {
                            Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onImageSaved(file: File) {
                        val msg = "¡Imagen guardada!: ${file.absolutePath}"
                        preferences.edit().putString(UsersContent.SP_IMAGE, file.absolutePath).apply()
                        Log.d("Camera", msg)
                        binding.cameraPreview.post {
                            Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
                        }

                    }
                })
        }

        return imageCapture
    }


}