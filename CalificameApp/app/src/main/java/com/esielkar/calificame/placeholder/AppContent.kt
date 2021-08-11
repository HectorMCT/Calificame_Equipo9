package com.esielkar.calificame.placeholder
import com.esielkar.calificame.model.*
import com.esielkar.calificame.utils.ProfessorAndStats

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object AppContent {

    var currentUniversity: University? = null
    var currentFaculty: Faculty? = null
    var currentProfessorStats : ProfessorAndStats? = null

    private val _universities = mutableSetOf(
        University("Benemérita Universidad Autónoma de Puebla", setOf(
            Faculty("Facultad de Ciencias de la Computación",
                mapOf(
                    Professor("Hilda Castillo Zacatelco") to ProfessorStats(
                        subjectStats = mapOf(
                            Subject("Programación I") to listOf(
                                SubjectStats(100.0, 90.0, 80.0, 70.0, 60.0, 50.0, 40.0, 30.0, 1)
                            )
                        )
                    ),
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
        University("Universidad Autónoma de México", setOf(
            Faculty("Facultad de Ingeniería",
                mapOf(
                    Professor("Hilda Castillo Zacatelco") to ProfessorStats(),
                    Professor("Ana Patricia Cervantes Marquez") to ProfessorStats(),
                    Professor("Meliza Contreras Gonzales") to ProfessorStats(),
                    Professor("Ivan Olmos Pineda") to ProfessorStats(),
                    Professor("Pedro Bello Lopez") to ProfessorStats(),
                    Professor("Beatriz Beltran Martinez") to ProfessorStats()
                )
            )
        )),
        University("Universidad Autónoma de Guerrero"),
        University("Universidad Autónoma de Guadalajara"),
        University("Instituto Politécnico Nacional"),
        University("Universidad Autónoma de Oaxaca"),
        University("Universidad Autónoma de Nuevo León"),
        University("Universidad Autónoma de Sinaloa"),
        University("Colegio de México"))

    val universities = _universities.toSet()

    private fun add(university: University) {
        _universities.add(university)
    }
}