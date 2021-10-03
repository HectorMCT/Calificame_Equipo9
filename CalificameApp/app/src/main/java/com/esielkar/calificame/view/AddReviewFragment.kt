package com.esielkar.calificame.view

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.esielkar.calificame.R
import com.esielkar.calificame.databinding.FragmentAddReviewBinding
import com.esielkar.calificame.model.*
import com.esielkar.calificame.placeholder.AppContent
import com.esielkar.calificame.placeholder.UsersContent

class AddReviewFragment : Fragment() {

    private var _binding: FragmentAddReviewBinding? = null
    private val binding get() = _binding!!
    private lateinit var thiscontext: Context
    private lateinit var satisfaction : Satisfaction
    private lateinit var domain : Score
    private lateinit var clarity : Score
    private lateinit var complexity : Difficulty
    private lateinit var consultancies : Frecuency
    private lateinit var fairEvaluation : YesNo
    private lateinit var exams : YesNo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddReviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        thiscontext = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.headerCV.title = AppContent.currentProfessorStats?.first?.name.toString() //professor
        binding.headerCV.subtitle = AppContent.currentFaculty?.name  //faculty
        binding.headerCV.overline = AppContent.currentUniversity?.name  //university

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            setNotificationChannel()
        }

        binding.addReviewButton.setOnClickListener {
            updateStats()
            simpleNotification()
            AppContent.currentProfessorStats?.second?.add(
                SubjectStats(
                    recommendation = satisfaction.getValue(),
                    clarity = clarity.getValue(),
                    complexity = complexity.getValue(),
                    domain = domain.getValue(),
                    consultancies = consultancies.getValue(),
                    fairEvaluation = fairEvaluation.getValue(),
                    applyExams = exams.getValue(),
                    examsCount = 0,
                    facility = (satisfaction.getValue() + clarity.getValue() + domain.getValue()) / 3
                ), AppContent.subject
            )
            if (binding.comments.text.toString().isNotBlank()){
                AppContent.currentProfessorStats?.second?.add(
                    Review(
                        user = UsersContent.currentUser!!,
                        comment = binding.comments.text.toString(),
                        satisfaction = satisfaction.getValue()
                    ), AppContent.subject
                )
            }

            Toast.makeText(context, "Stats successfully added", Toast.LENGTH_LONG).show()
            it.findNavController().popBackStack()
        }

    }
    fun updateStats() {
        satisfaction = when (binding.satisfactionGroup.checkedRadioButtonId) {
            R.id.satisfaction_btn_satisfied -> Satisfaction.SATISFIED
            R.id.satisfaction_btn_half_satisfied -> Satisfaction.HALF_SATISFIED
            else -> Satisfaction.DISSATISFIED
        }

        domain = when (binding.domainGroup.checkedRadioButtonId) {
            R.id.domain_btn_excellent -> Score.EXCELLENT
            R.id.domain_btn_good -> Score.GOOD
            R.id.domain_btn_regular -> Score.REGULAR
            R.id.domain_btn_bad -> Score.BAD
            else -> Score.TERRIBLE
        }

        clarity = when (binding.clarityGroup.checkedRadioButtonId) {
            R.id.clarity_btn_excellent -> Score.EXCELLENT
            R.id.clarity_btn_good -> Score.GOOD
            R.id.clarity_btn_regular -> Score.REGULAR
            R.id.clarity_btn_bad -> Score.BAD
            else -> Score.TERRIBLE
        }

        complexity = when (binding.complexityGroup.checkedRadioButtonId) {
            R.id.complexity_btn_very_hard -> Difficulty.VERY_HARD
            R.id.complexity_btn_hard -> Difficulty.HARD
            R.id.complexity_btn_regular -> Difficulty.REGULAR
            R.id.complexity_btn_easy -> Difficulty.EASY
            else ->  Difficulty.VERY_EASY
        }

        consultancies = when (binding.consultanciesGroup.checkedRadioButtonId) {
            R.id.consultancies_btn_always -> Frecuency.ALWAYS
            R.id.consultancies_btn_sometimes -> Frecuency.SOMETIMES
            else ->  Frecuency.NEVER
        }

        fairEvaluation = when (binding.fairEvaluationGroup.checkedRadioButtonId) {
            R.id.fairEvaluation_btn_yes -> YesNo.YES
            else ->  YesNo.NO
        }

        exams = when (binding.examsGroup.checkedRadioButtonId) {
            R.id.exams_btn_yes -> YesNo.YES
            else ->  YesNo.NO
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun simpleNotification(){

        var builder = NotificationCompat.Builder(thiscontext, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_review) //seteamos el ícono de la push notification
            .setColor(ContextCompat.getColor(thiscontext, R.color.light_blue)) //definimos el color del ícono y el título de la notificación
            .setContentTitle(getString(R.string.simple_title)) //seteamos el título de la notificación
            .setContentText(getString(R.string.simple_body)) //seteamos el cuerpo de la notificación
            .setPriority(NotificationCompat.PRIORITY_DEFAULT) //Ponemos una prioridad por defecto

        //lanzamos la notificación
        with(NotificationManagerCompat.from(thiscontext)) {
            notify(20, builder.build()) //en este caso pusimos un id genérico
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setNotificationChannel(){
        val channel = NotificationChannel(CHANNEL_ID, getString(R.string.channel_courses), NotificationManager.IMPORTANCE_DEFAULT).apply {
            description = getString(R.string.courses_description)
        }

        val notificationManager: NotificationManager = activity?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.createNotificationChannel(channel)
    }

    companion object {
        const val CHANNEL_ID = "CHANNEL_ID"
        @JvmStatic
        fun newInstance() = AddReviewFragment()
    }
}