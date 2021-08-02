package com.esielkar.calificame.placeholder
import com.esielkar.calificame.model.Faculty
import com.esielkar.calificame.model.Professor
import com.esielkar.calificame.model.ProfessorStats
import com.esielkar.calificame.model.University

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object UniversityPlaceholderContent {

    /**
     * An set of sample (placeholder) universities.
     */
    val universities = mutableSetOf(
        University("Benemérita Universidad Autónoma de Puebla", setOf(
            Faculty("Facultad de Ciencias de la Computación",
                mapOf(
                    Professor("1") to ProfessorStats(),
                    Professor("2") to ProfessorStats(),
                    Professor("3") to ProfessorStats(),
                    Professor("4") to ProfessorStats(),
                    Professor("5") to ProfessorStats(),
                    Professor("6") to ProfessorStats()
                )
            ),
            Faculty("Facultad de Derecho y Ciencias Sociales",
                mapOf(
                    Professor("1") to ProfessorStats(),
                    Professor("2") to ProfessorStats(),
                    Professor("3") to ProfessorStats()
                )
            ),
            Faculty("Facultad de Cultura Física",
                mapOf(
                    Professor("1") to ProfessorStats(),
                    Professor("2") to ProfessorStats()
                )
            ),
            Faculty("Facultad de Psicología",
                mapOf(
                    Professor("1") to ProfessorStats(),
                    Professor("2") to ProfessorStats(),
                    Professor("3") to ProfessorStats(),
                    Professor("4") to ProfessorStats(),
                )
            ),
        )),
        University("Universidad Autónoma de México"),
        University("Universidad Autónoma de Guerrero"),
        University("Universidad Autónoma de Guadalajara"),
        University("Instituto Politécnico Nacional"),
        University("Universidad Autónoma de Oaxaca"),
        University("Universidad Autónoma de Nuevo León"),
        University("Universidad Autónoma de Sinaloa"),
        University("Colegio de México"))

    private fun add(university: University) {
        universities.add(university)
    }
}