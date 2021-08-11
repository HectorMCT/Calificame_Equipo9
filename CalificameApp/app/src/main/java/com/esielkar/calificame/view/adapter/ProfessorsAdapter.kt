package com.esielkar.calificame.view.adapter

import android.view.View
import android.view.ViewGroup
import com.esielkar.calificame.model.Professor
import com.esielkar.calificame.model.ProfessorStats
import com.esielkar.calificame.utils.ProfessorWithInfo
import com.esielkar.calificame.view.ProfessorCardView
import kotlin.random.Random

class ProfessorsAdapter(
    professorStats : List<Pair<Professor, ProfessorStats>>,
    //TODO: Revisar parametro referente al evento
    onItemClickListener : View.OnClickListener? = null,

) : CardViewAdapter<Pair<Professor, ProfessorStats>, ProfessorCardView>(professorStats, onItemClickListener) {
    class ProfessorViewHolder(professorCardView: ProfessorCardView) : BindableViewHolder<Pair<Professor, ProfessorStats>>(professorCardView) {

        override fun bind(item: Pair<Professor, ProfessorStats>) {
            val v = itemView as ProfessorCardView
            v.professorName = item.first.name

            val counters = item.second.getStatsAndReviewsCounts()
            v.statsCount = counters.first
            v.reviewsCount = counters.second

            v.percentage = item.second.average.toInt()
        }
    }

    /**
     * Called when RecyclerView needs a new [ViewHolder] of the given type to represent
     * an item.
     *
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     *
     *
     * The new ViewHolder will be used to display items of the adapter using
     * [.onBindViewHolder]. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary [View.findViewById] calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     * an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see .getItemViewType
     * @see .onBindViewHolder
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ProfessorViewHolder(this.applyStyle(ProfessorCardView(parent.context)))
}