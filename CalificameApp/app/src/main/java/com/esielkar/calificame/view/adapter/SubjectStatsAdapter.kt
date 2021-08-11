package com.esielkar.calificame.view.adapter

import android.view.View
import android.view.ViewGroup
import com.esielkar.calificame.utils.SubjectWithInfo
import com.esielkar.calificame.view.SubjectStatsCardView

class SubjectStatsAdapter(
    subjectsWithInfo : List<SubjectWithInfo>,
    //TODO: Revisar parametro referente al evento
    onItemClickListener : View.OnClickListener? = null,
) : CardViewAdapter<SubjectWithInfo, SubjectStatsCardView>(subjectsWithInfo, onItemClickListener) {

    class SubjectViewHolder(subjectStatsCardView: SubjectStatsCardView
    ) : BindableViewHolder<SubjectWithInfo>(subjectStatsCardView) {
        override fun bind(item: SubjectWithInfo) {
            val v = itemView  as SubjectStatsCardView
            v.subjectName = item.first.name
            v.statsCount = item.second
            v.reviewsCount = item.third
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
    ) = SubjectViewHolder(this.applyStyle(SubjectStatsCardView(parent.context)))
}