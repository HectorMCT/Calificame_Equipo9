package com.esielkar.calificame.model

import com.esielkar.calificame.utils.StatsAndReviews
import com.esielkar.calificame.utils.SubjectWithInfo

/**
 * Representa las estisticas generales de un profesor de la aplicación Califícame!
 * @constructor Crea las estadisticas de un profesor dadas su facilidad, claridad y recomendación.
 * @throws StatsOutOfRangeException si facility, clarity o recommendation no están en el rango de valores de 1 - 100.
 */
class ProfessorStats(
    facility: Double = 0.0,
    clarity: Double = 0.0,
    recommendation: Double = 0.0,
) : Stats(facility, clarity, recommendation) {

    private val _subjectStats: MutableMap<Subject, MutableList<SubjectStats>> = mutableMapOf()
    private val _reviews: MutableMap<Subject, MutableList<Review>> = mutableMapOf()

    /**
     * @constructor Crea las estadisticas de un profesor dadas su facilidad, claridad y recomendación.
     * Opcionalmente, un [Map] de las estadisticas de cada materia que tenga estadisticas registradas
     * y un [Map] de reviews por cada materia que tenga reviews registradas
     * @throws StatsOutOfRangeException si facility, clarity o recommendation no están en el rango de valores de 1 - 100.
     */
    constructor(facility: Double = 0.0, clarity: Double = 0.0, recommendation: Double = 0.0,
                subjectStats: Map<Subject, MutableList<SubjectStats>>? = null,
                reviews: Map<Subject, MutableList<Review>>? = null
    ) : this(facility, clarity, recommendation) {
        subjectStats?.let { _subjectStats.putAll(it) }
        reviews?.let { _reviews.putAll(it) }
    }

    val signatures
    get() = (_subjectStats.map { it.key } + _reviews.map { it.key }).toSet()
    fun getReviews(of: Subject) = _reviews[of]?.toList()
    fun getStats(of: Subject) = _subjectStats[of]?.toList()
    fun add(review: Review, to : Subject) = _reviews[to]?.add(review) ?: _reviews.put(to, mutableListOf(review))
    fun add(stats: SubjectStats, to : Subject) = _subjectStats[to]?.add(stats) ?: _subjectStats.put(to, mutableListOf(stats))

    fun getSubjectsWithStatsAndReviewsCounts() = signatures.map {
        SubjectWithInfo(
            it,
            getStats(of = it)?.size ?: 0,
            getReviews(of = it)?.size ?: 0)
    }

    fun getStatsAndReviewsCounts() : StatsAndReviews {
        val l = getSubjectsWithStatsAndReviewsCounts()
        return StatsAndReviews(l.sumOf { it.second }, l.sumOf { it.third })
    }

    private fun update() {
        var size: Int
        var facility= 0.0
        var clarity= 0.0
        var recommendation = 0.0

        for(key in _subjectStats.keys){

            var auxFacility = 0.0
            var auxClarity= 0.0
            var auxRecommendation = 0.0

            for (value in _subjectStats[key]!!){
                auxFacility += value.facility
                auxClarity += value.clarity
                auxRecommendation += value.recommendation
            }
            size = _subjectStats[key]!!.size
            facility += auxFacility / size
            clarity += auxClarity / size
            recommendation += auxRecommendation / size
        }

        size = _subjectStats.size
        if (size != 0){
            this.facility = facility / size
            this.clarity = clarity / size
            this.recommendation = recommendation / size
        }
    }

}