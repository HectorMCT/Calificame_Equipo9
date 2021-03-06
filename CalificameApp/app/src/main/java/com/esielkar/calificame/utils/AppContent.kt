package com.esielkar.calificame.utils

import com.esielkar.calificame.model.*

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO ESTO ES PROVICIONAL Y SE ELIMINARA CUANDO SE OCUPE LA PERSISTENCIA DE DATOS REMOTA
 */
object AppContent {
    const val PREFS_NAME = "com.esielkar.calificame"
    var currentUniversity: University? = null
    var currentFaculty: Faculty? = null
    var currentProfessorStats : ProfessorAndStats? = null
    val subject = Subject("GENERAL")

    private val _users = setOf(
        User("Esiel15", "esiel_kar@hotmail.com"),
        User("Hector", "usuario2@hotmail.com"),
        User("Mayra", "usuario3@hotmail.com"),
        User("Jose GL", "usuario4@hotmail.com"),
        User("David LP", "usuario5@hotmail.com")
    )



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
                                Review(_users.elementAt(1), "Muy buenas clases, excelente profesora. Siempre dispuesta ayudar", 90.0),
                                Review(_users.elementAt(0), "Excelentes clases, de que aprendes, aprendes", 100.0),
                                Review(_users.elementAt(2), "La profesora siempre esta al pendiente del aprendizaje de los alumnos", 100.0),
                                Review(_users.elementAt(3), "Muy buenas clases, la profesora siempre ayuda cuando se lo pides", 90.0)
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
                                Review(UsersContent.users.elementAt(0), "La mejor profesora para aprender a programar", 100.0),
                                Review(_users.elementAt(2), "La profesora siempre esta al pendiente del aprendizaje de los alumnos y deja trabajos acorde al aprendizaje", 100.0),
                                Review(_users.elementAt(3), "Muy buenas clases, la profesora siempre ayuda cuando se lo pides", 90.0),
                                Review(_users.elementAt(4), "Excelentes clases, profesora exigente, pero muy buena", 100.0),
                                Review(_users.elementAt(0), "Muy buenas clases, excelente profesora. Siempre dispuesta ayudar", 90.0),
                                Review(_users.elementAt(1), "Excelentes clases, excelente profesore", 100.0),

                            )

                        )
                    ),
                    Professor("Elsa Chavira Martínez") to ProfessorStats(
                        subjectStats = mapOf(
                            subject to listOf(
                                SubjectStats(70.0, 60.0, 10.0, 20.0, 100.0, 50.0, 100.0, 100.0),
                                SubjectStats(60.0, 50.0, 10.0, 20.0, 100.0, 50.0, 100.0, 100.0),
                            )
                        ),
                        reviews = mapOf(
                            subject to listOf(
                                Review(_users.elementAt(2), "Casi nunca se presenta a las clases y los temas son muy complicados", 50.0),
                                Review(_users.elementAt(3), "Los trabajos son algo complicados y su puntualidad deja mucho que desear", 70.0),
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
                                Review(_users.elementAt(0), "La profesora siempre esta al pendiente del aprendizaje de los alumnos", 70.0),
                                Review(_users.elementAt(2), "Muy buenas clases, la profesora siempre ayuda cuando se lo pides", 80.0)
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
                                Review(_users.elementAt(0), "Muy buenas clases, excelente profesor. Siempre dispuesto ayudar", 90.0),
                                Review(_users.elementAt(3), "Excelentes clases, de que aprendes, aprendes", 100.0),
                                Review(_users.elementAt(2), "Siempre esta al pendiente del aprendizaje de los alumnos", 100.0),
                                Review(_users.elementAt(1), "Muy buenas clases, siempre ayuda cuando se lo pides", 90.0)
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
                                Review(_users.elementAt(2), "Muy buenas clases, excelente profesora. Siempre dispuesta ayudar", 90.0),
                                Review(_users.elementAt(3), "Excelentes clases, de que aprendes, aprendes", 100.0),
                                Review(_users.elementAt(1), "La profesora siempre esta al pendiente del aprendizaje de los alumnos", 100.0),
                                Review(_users.elementAt(0), "Muy buenas clases, la profesora siempre ayuda cuando se lo pides", 90.0)
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
        University("Universidad Autónoma de México", faculties = setOf(
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
}