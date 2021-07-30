package com.esielkar.calificame.model.adapter

import android.view.ViewGroup
import com.esielkar.calificame.model.Professor
import com.esielkar.calificame.model.University
import com.esielkar.calificame.utils.ProfessorWithInfo
import com.esielkar.calificame.view.ProfessorCardView
import kotlin.random.Random

class ProfessorsAdapter(
    professorsWithInfo : Set<ProfessorWithInfo>,
    //TODO: Revisar parametro referente al evento
    onItemClickListener: ((ProfessorWithInfo) -> Unit)? = null,
) : CardViewAdapter<ProfessorWithInfo, ProfessorCardView>(professorsWithInfo, onItemClickListener) {
    class ProfessorViewHolder(professorCardView: ProfessorCardView) : BindableViewHolder<ProfessorWithInfo>(professorCardView) {
        override fun bind(item: ProfessorWithInfo) {
            val v = itemView as ProfessorCardView
            v.professorName = item.first.name
            v.statsCount = item.second
            v.reviewsCount = item.third
            //TODO: Corregir no debe ser Ramdom
            v.percentage = Random.nextInt(101)
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