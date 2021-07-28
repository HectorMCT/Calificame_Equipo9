package com.esielkar.calificame.model

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

    private val _signaturesStats: MutableMap<Signature, MutableList<SignatureStats>> = mutableMapOf()
    private val _reviews: MutableMap<Signature, MutableList<Review>> = mutableMapOf()

    /**
     * @constructor Crea las estadisticas de un profesor dadas su facilidad, claridad y recomendación.
     * Opcionalmente, un [Map] de las estadisticas de cada materia que tenga estadisticas registradas
     * y un [Map] de reviews por cada materia que tenga reviews registradas
     * @throws StatsOutOfRangeException si facility, clarity o recommendation no están en el rango de valores de 1 - 100.
     */
    constructor(facility: Double = 0.0, clarity: Double = 0.0, recommendation: Double = 0.0,
            signaturesStats: Map<Signature, MutableList<SignatureStats>>? = null,
            reviews: Map<Signature, MutableList<Review>>? = null
    ) : this(facility, clarity, recommendation) {
        signaturesStats?.let { _signaturesStats.putAll(it) }
        reviews?.let { _reviews.putAll(it) }
    }

    val signatures
    get() = (_signaturesStats.map { it.key } + _reviews.map { it.key }).toSet()
    fun getReviews(of: Signature) = _reviews[of]?.toList()
    fun getStats(of: Signature) = _signaturesStats[of]?.toList()
    fun add(review: Review, to : Signature) = _reviews[to]?.add(review) ?: _reviews.put(to, mutableListOf(review))
    fun add(stats: SignatureStats, to : Signature) = _signaturesStats[to]?.add(stats) ?: _signaturesStats.put(to, mutableListOf(stats))

    private fun update() {
        var size: Int
        var facility= 0.0
        var clarity= 0.0
        var recommendation = 0.0

        for(key in _signaturesStats.keys){

            var auxFacility = 0.0
            var auxClarity= 0.0
            var auxRecommendation = 0.0

            for (value in _signaturesStats[key]!!){
                auxFacility += value.facility
                auxClarity += value.clarity
                auxRecommendation += value.recommendation
            }
            size = _signaturesStats[key]!!.size
            facility += auxFacility / size
            clarity += auxClarity / size
            recommendation += auxRecommendation / size
        }

        size = _signaturesStats.size
        if (size != 0){
            this.facility = facility / size
            this.clarity = clarity / size
            this.recommendation = recommendation / size
        }
    }

}