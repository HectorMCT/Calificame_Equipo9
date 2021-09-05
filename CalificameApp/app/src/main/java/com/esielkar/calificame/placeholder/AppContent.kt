package com.esielkar.calificame.placeholder
import com.esielkar.calificame.model.*
import com.esielkar.calificame.utils.ProfessorAndStats

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 * TODO ESTO ES PROVICIONAL Y SE ELIMINARA CUANDO SE OCUPE LA PERSISTENCIA DE DATOS
 */
object AppContent {
    const val PREFS_NAME = "com.esielkar.calificame"

    var currentUniversity: University? = null
    var currentFaculty: Faculty? = null
    var currentProfessorStats : ProfessorAndStats? = null
    val subject = Subject("GENERAL")

    private val _universities = mutableSetOf(
        University("Benemérita Universidad Autónoma de Puebla", setOf(
            Faculty("Facultad de Ciencias de la Computación",
                mapOf(
                    Professor("Hilda Castillo Zacatelco") to ProfessorStats(
                        subjectStats = mapOf(
                            subject to listOf(
                                SubjectStats(100.0, 95.0, 100.0, 100.0, 100.0, 100.0, 100.0, 100.0),
                                SubjectStats(100.0, 80.0, 90.0, 100.0, 100.0, 100.0, 100.0, 100.0),
                                SubjectStats(100.0, 100.0, 100.0, 90.0, 100.0, 90.0, 100.0, 100.0),
                                SubjectStats(90.0, 90.0, 100.0, 100.0, 100.0, 90.0, 100.0, 100.0),
                                SubjectStats(100.0, 100.0, 90.0, 90.0, 100.0, 100.0, 100.0, 100.0),
                                SubjectStats(80.0, 80.0, 80.0, 100.0, 100.0, 100.0, 100.0, 100.0)
                            )
                        ),
                        reviews = mapOf(
                            subject to listOf(
                                Review(UsersContent.users.elementAt(1), "Muy buenas clases, excelente profesora. Siempre dispuesta ayudar", 90.0),
                                Review(UsersContent.users.elementAt(0), "Excelentes clases, de que aprendes, aprendes", 100.0),
                                Review(UsersContent.users.elementAt(2), "La profesora siempre esta al pendiente del aprendizaje de los alumnos", 100.0),
                                Review(UsersContent.users.elementAt(3), "Muy buenas clases, la profesora siempre ayuda cuando se lo pides", 90.0)
                            )

                        )
                    ),
                    Professor("Ana Patricia Cervantes Marquez") to ProfessorStats(
                        subjectStats = mapOf(
                            subject to listOf(
                                SubjectStats(100.0, 95.0, 100.0, 100.0, 100.0, 100.0, 100.0, 100.0),
                                SubjectStats(100.0, 80.0, 90.0, 100.0, 100.0, 100.0, 100.0, 100.0),
                                SubjectStats(100.0, 100.0, 100.0, 90.0, 100.0, 90.0, 50.0, 100.0),
                                SubjectStats(90.0, 90.0, 100.0, 100.0, 100.0, 90.0, 100.0, 100.0),
                                SubjectStats(100.0, 100.0, 90.0, 90.0, 100.0, 100.0, 50.0, 100.0),
                                SubjectStats(80.0, 80.0, 80.0, 100.0, 100.0, 100.0, 100.0, 100.0),
                                SubjectStats(100.0, 100.0, 100.0, 90.0, 100.0, 90.0, 50.0, 100.0),
                                SubjectStats(90.0, 90.0, 100.0, 100.0, 100.0, 90.0, 100.0, 100.0),
                                SubjectStats(100.0, 100.0, 90.0, 90.0, 100.0, 100.0, 50.0, 100.0),
                                SubjectStats(80.0, 80.0, 80.0, 100.0, 100.0, 100.0, 100.0, 100.0)

                            )
                        ),
                        reviews = mapOf(
                            subject to listOf(
                                Review(UsersContent.users.elementAt(1), "Muy buenas clases, excelente profesora. Siempre dispuesta ayudar", 90.0),
                                Review(UsersContent.users.elementAt(0), "Excelentes clases, de que aprendes, aprendes", 100.0),
                                Review(UsersContent.users.elementAt(2), "La profesora siempre esta al pendiente del aprendizaje de los alumnos", 100.0),
                                Review(UsersContent.users.elementAt(3), "Muy buenas clases, la profesora siempre ayuda cuando se lo pides", 90.0),
                                Review(UsersContent.users.elementAt(0), "Excelentes clases, profesora exigente, pero muy buena", 100.0),
                                Review(UsersContent.users.elementAt(0), "La mejor profesora para aprender a programar", 100.0),
                            )

                        )
                    ),
                    Professor("Pedro Bello Lopez") to ProfessorStats(
                        subjectStats = mapOf(
                            subject to listOf(
                                SubjectStats(70.0, 60.0, 10.0, 20.0, 100.0, 50.0, 100.0, 100.0),
                                SubjectStats(60.0, 50.0, 10.0, 20.0, 100.0, 50.0, 100.0, 100.0),
                            )
                        ),
                        reviews = mapOf(
                            subject to listOf(
                                Review(UsersContent.users.elementAt(3), "Casi nunca se presenta a las clases y los temas son muy complicados", 50.0),
                            )

                        )
                    ),
                    Professor("Meliza Contreras Gonzales") to ProfessorStats(
                        subjectStats = mapOf(
                            subject to listOf(

                                SubjectStats(100.0, 100.0, 90.0, 90.0, 100.0, 100.0, 50.0, 100.0),
                                SubjectStats(80.0, 80.0, 80.0, 100.0, 100.0, 100.0, 100.0, 100.0)
                            )
                        ),
                        reviews = mapOf(
                            subject to listOf(
                                Review(UsersContent.users.elementAt(2), "La profesora siempre esta al pendiente del aprendizaje de los alumnos", 70.0),
                                Review(UsersContent.users.elementAt(3), "Muy buenas clases, la profesora siempre ayuda cuando se lo pides", 80.0)
                            )

                        )
                    ),
                    Professor("Ivan Olmos Pineda") to ProfessorStats(
                        subjectStats = mapOf(
                            subject to listOf(
                                SubjectStats(100.0, 95.0, 100.0, 100.0, 100.0, 100.0, 100.0, 100.0),
                                SubjectStats(100.0, 80.0, 90.0, 100.0, 100.0, 100.0, 100.0, 100.0),
                                SubjectStats(100.0, 100.0, 100.0, 90.0, 100.0, 90.0, 50.0, 100.0),
                                SubjectStats(90.0, 90.0, 100.0, 100.0, 100.0, 90.0, 100.0, 100.0),
                                SubjectStats(100.0, 100.0, 90.0, 90.0, 100.0, 100.0, 50.0, 100.0),
                                SubjectStats(80.0, 80.0, 80.0, 100.0, 100.0, 100.0, 100.0, 100.0)
                            )
                        ),
                        reviews = mapOf(
                            subject to listOf(
                                Review(UsersContent.users.elementAt(1), "Muy buenas clases, excelente profesor. Siempre dispuesto ayudar", 90.0),
                                Review(UsersContent.users.elementAt(0), "Excelentes clases, de que aprendes, aprendes", 100.0),
                                Review(UsersContent.users.elementAt(2), "Siempre esta al pendiente del aprendizaje de los alumnos", 100.0),
                                Review(UsersContent.users.elementAt(3), "Muy buenas clases, siempre ayuda cuando se lo pides", 90.0)
                            )

                        )
                    ),
                    Professor("Beatriz Beltran Martinez") to ProfessorStats(
                        subjectStats = mapOf(
                            subject to listOf(
                                SubjectStats(100.0, 95.0, 100.0, 100.0, 100.0, 100.0, 100.0, 100.0),
                                SubjectStats(100.0, 80.0, 90.0, 100.0, 100.0, 100.0, 100.0, 100.0),
                                SubjectStats(100.0, 100.0, 100.0, 90.0, 100.0, 90.0, 50.0, 100.0),
                                SubjectStats(90.0, 90.0, 100.0, 100.0, 100.0, 90.0, 100.0, 100.0),
                                SubjectStats(100.0, 100.0, 90.0, 90.0, 100.0, 100.0, 50.0, 100.0),
                                SubjectStats(80.0, 80.0, 80.0, 100.0, 100.0, 100.0, 100.0, 100.0)
                            )
                        ),
                        reviews = mapOf(
                            subject to listOf(
                                Review(UsersContent.users.elementAt(1), "Muy buenas clases, excelente profesora. Siempre dispuesta ayudar", 90.0),
                                Review(UsersContent.users.elementAt(0), "Excelentes clases, de que aprendes, aprendes", 100.0),
                                Review(UsersContent.users.elementAt(2), "La profesora siempre esta al pendiente del aprendizaje de los alumnos", 100.0),
                                Review(UsersContent.users.elementAt(3), "Muy buenas clases, la profesora siempre ayuda cuando se lo pides", 90.0)
                            )

                        )
                    )
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