package com.esielkar.calificame.model

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import com.esielkar.calificame.utils.StatsAndReviews
import com.esielkar.calificame.utils.StatsWrapper
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

    private var _subjectStats: MutableMap<Subject, MutableList<SubjectStats>> = mutableMapOf()
    private var _reviews: MutableMap<Subject, MutableList<Review>> = mutableMapOf()

    /**
     * @constructor Crea las estadisticas de un profesor dadas su facilidad, claridad y recomendación.
     * Opcionalmente, un [Map] de las estadisticas de cada materia que tenga estadisticas registradas
     * y un [Map] de reviews por cada materia que tenga reviews registradas
     * @throws StatsOutOfRangeException si facility, clarity o recommendation no están en el rango de valores de 1 - 100.
     */
    constructor(facility: Double = 0.0, clarity: Double = 0.0, recommendation: Double = 0.0,
                subjectStats: Map<Subject, List<SubjectStats>>? = null,
                reviews: Map<Subject, List<Review>>? = null
    ) : this(facility, clarity, recommendation) {
        subjectStats?.let { map ->
            _subjectStats.putAll(map.map { it.key to it.value.toMutableList() })
        }
        reviews?.let { map ->
            _reviews.putAll(map.map { it.key to it.value.toMutableList() }) }
    }

    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
    ) {
        _subjectStats = readParcelableMap(parcel, 0)
        _reviews = readParcelableMap(parcel, 0)
    }

    val signatures
    get() = (_subjectStats.map { it.key } + _reviews.map { it.key }).toSet()

    val average : Double
    get() {
        update()
        return (facility + clarity + recommendation) / 3
    }

    val generalStats : StatsWrapper
    get() {
        var a1 : Double? = null
        var a2 : Double? = null
        var a3 : Double? = null
        var a4 : Double? = null
        var a5 : Double? = null
        var a6 : Double? = null
        signatures.forEach {
            a1 = getStats(it)?.map { it.recommendation }?.average()
            a2 = getStats(it)?.map { it.complexity }?.average()
            a3 = getStats(it)?.map { it.clarity }?.average()
            a4 = getStats(it)?.map { it.domain }?.average()
            a5 = getStats(it)?.map { it.consultancies }?.average()
            a6 = getStats(it)?.map { it.fairEvaluation }?.average()
        }
        return StatsWrapper(
            Triple(a1 ?: 0.0, a2 ?: 0.0, a3 ?: 0.0),
            Triple(a4 ?: 0.0, a5 ?: 0.0, a6 ?: 0.0)
        )
    }

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

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        super.writeToParcel(parcel, flags)
        writeParcelableMap(parcel, flags, _subjectStats)
        writeParcelableMap(parcel, flags, _reviews)
    }

    private fun <K : Parcelable, V : List<E>, E : Parcelable> writeParcelableMap(
        parcel : Parcel, flags : Int, map : Map<K, V>) {
        parcel.writeInt(map.size)
        map.entries.forEach { entry ->
            parcel.writeParcelable(entry.key, flags)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                parcel.writeParcelableList(entry.value, flags)
            }else parcel.writeList(entry.value)
        }
    }

    private inline fun <reified K : Parcelable, V : MutableList<E>, reified E : Parcelable> readParcelableMap(
        parcel : Parcel, flags : Int) : MutableMap<K, V> {
        val map = mutableMapOf<K, V>()
        for (i in 1..parcel.readInt()){
            val key = parcel.readParcelable<K>(K::class.java.classLoader)
            val list = mutableListOf<E>()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                parcel.readParcelableList(list, E::class.java.classLoader)
            }else parcel.readList(list, E::class.java.classLoader)
            map.put(key!!, list as V)
        }
        return map
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<ProfessorStats> {
        override fun createFromParcel(parcel: Parcel): ProfessorStats {
            return ProfessorStats(parcel)
        }

        override fun newArray(size: Int): Array<ProfessorStats?> {
            return arrayOfNulls(size)
        }
    }

}