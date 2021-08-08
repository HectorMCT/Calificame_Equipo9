package com.esielkar.calificame


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.esielkar.calificame.model.SubjectStats
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup

class AddReviewActivity : AppCompatActivity() {

    //Grupos de botones
    private lateinit var  toggle1 : MaterialButtonToggleGroup // PREGUNTA 1
    private lateinit var  toggle2 : MaterialButtonToggleGroup // PREGUNTA 2
    private lateinit var  toggle3 : MaterialButtonToggleGroup // PREGUNTA 3
    private lateinit var  toggle4 : MaterialButtonToggleGroup // PREGUNTA 4
    private lateinit var  toggle5 : MaterialButtonToggleGroup // PREGUNTA 5
    private lateinit var  toggle6 : MaterialButtonToggleGroup // PREGUNTA 6

    lateinit var button : Button

    //Estadisticas
    private val stats = SubjectStats()

    //
    private val controlQuestions : Array<Boolean> = TODO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_review)


        toggle1 = findViewById(R.id.toggleButton1)
        toggle2 = findViewById(R.id.toggleButton2)
        toggle3 = findViewById(R.id.toggleButton3)
        toggle4 = findViewById(R.id.toggleButton4)
        toggle5 = findViewById(R.id.toggleButton5)
        toggle6 = findViewById(R.id.toggleButton6)

        //PREGUNTA 1
        toggle1.addOnButtonCheckedListener { group, checkedId, isChecked ->

            if(isChecked){
                when (checkedId) {
                    R.id.quest1btn0 ->  stats.domain = 100.0
                    R.id.quest1btn1 ->  stats.domain = 75.0
                    R.id.quest1btn2 ->  stats.domain = 50.0
                    R.id.quest1btn3 ->  stats.domain = 25.0
                }
            } else {
                if(group.checkedButtonId == View.NO_ID){
                    Toast.makeText(applicationContext,
                        "Selecciona una opcion",
                        Toast.LENGTH_SHORT).show()

                }
            }
        }
        //PREGUNTA 2
        toggle2.addOnButtonCheckedListener { group, checkedId, isChecked ->

            if(isChecked){
                when (checkedId) {
                    R.id.quest2btn0 ->  stats.clarity = 100.0
                    R.id.quest2btn1 ->  stats.clarity = 75.0
                    R.id.quest2btn2 ->  stats.clarity = 50.0
                    R.id.quest2btn3 ->  stats.clarity = 25.0
                }
            } else {
                if(group.checkedButtonId == View.NO_ID){
                    Toast.makeText(applicationContext,
                        "Selecciona una opcion",
                        Toast.LENGTH_SHORT).show()

                }
            }
        }
        //PREGUNTA 3
        toggle3.addOnButtonCheckedListener { group, checkedId, isChecked ->

            if(isChecked){
                when (checkedId) {
                    R.id.quest3btn0 ->  stats.complexity = 100.0
                    R.id.quest3btn1 ->  stats.complexity = 75.0
                    R.id.quest3btn2 ->  stats.complexity = 50.0
                    R.id.quest3btn3 ->  stats.complexity = 25.0
                }
            } else {
                if(group.checkedButtonId == View.NO_ID){
                    Toast.makeText(applicationContext,
                        "Selecciona una opcion",
                        Toast.LENGTH_SHORT).show()

                }
            }
        }
        //PREGUNTA 4
        toggle4.addOnButtonCheckedListener { group, checkedId, isChecked ->

            if(isChecked){
                when (checkedId) {
                    R.id.quest4btn0 ->  stats.facility = 100.0
                    R.id.quest4btn1 ->  stats.facility = 50.0
                    R.id.quest4btn2 ->  stats.facility = 0.0
                }
            } else {
                if(group.checkedButtonId == View.NO_ID){
                    Toast.makeText(applicationContext,
                        "Selecciona una opcion",
                        Toast.LENGTH_SHORT).show()

                }
            }
        }

        //PREGUNTA 5
        toggle5.addOnButtonCheckedListener { group, checkedId, isChecked ->

            if(isChecked){
                when (checkedId) {
                    R.id.quest5btn0 ->  stats.fairEvaluation = 100.0
                    R.id.quest5btn1 ->  stats.fairEvaluation = 75.0
                    R.id.quest5btn2 ->  stats.fairEvaluation = 50.0
                }
            } else {
                if(group.checkedButtonId == View.NO_ID){
                    Toast.makeText(applicationContext,
                        "Selecciona una opcion",
                        Toast.LENGTH_SHORT).show()

                }
            }
        }

        //PREGUNTA 6
        toggle6.addOnButtonCheckedListener { group, checkedId, isChecked ->

            if(isChecked){
                when (checkedId) {
                    R.id.quest6btn0 ->  stats.applyExams = 100.0
                    R.id.quest6btn1 ->  stats.applyExams = 0.0
                }
            } else {
                if(group.checkedButtonId == View.NO_ID){
                    Toast.makeText(applicationContext,
                        "Selecciona una opcion",
                        Toast.LENGTH_SHORT).show()

                }
            }
        }


        //TODO: Código de prueba
        button = findViewById(R.id.buttonAddReview)
        button.setOnClickListener {
            val intent = Intent(this, SelectSubjectActivity::class.java)
            //putExtra(it) TODO: Parcelable
            startActivity(intent)
        }
    }



}