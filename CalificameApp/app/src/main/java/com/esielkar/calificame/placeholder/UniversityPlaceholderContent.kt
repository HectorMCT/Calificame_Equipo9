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
                    Professor("Hilda Castillo Zacatelco") to ProfessorStats(),
                    Professor("Ana Patricia Cervantes Marquez") to ProfessorStats(),
                    Professor("Meliza Contreras Gonzales") to ProfessorStats(),
                    Professor("Ivan Olmos Pineda") to ProfessorStats(),
                    Professor("Pedro Bello Lopez") to ProfessorStats(),
                    Professor("Beatriz Beltran Martinez") to ProfessorStats()
                )
            ),
            Faculty("Facultad de Derecho y Ciencias Sociales",
                mapOf(
                    Professor("Jose Miguel Rodrigez Vargas") to ProfessorStats(),
                    Professor("Guadalupe Martinez Ramirez") to ProfessorStats(),
                    Professor("Ricardo Carmarada Cool") to ProfessorStats()
                )
            ),
            Faculty("Facultad de Cultura Física",
                mapOf(
                    Professor("Karla Lopez Vargas") to ProfessorStats(),
                    Professor("Santiago Gonzalez Ramirez") to ProfessorStats()
                )
            ),
            Faculty("Facultad de Psicología",
                mapOf(
                    Professor("Zoyla Luna Noches") to ProfessorStats(),
                    Professor("Facundo Ramirez Marihuana") to ProfessorStats(),
                    Professor("Omar Hernandez Hernandez") to ProfessorStats(),
                    Professor("Ramiro Cortez Cruz") to ProfessorStats(),
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