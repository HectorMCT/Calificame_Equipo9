package com.esielkar.calificame.model.adapter

import android.view.ViewGroup
import com.esielkar.calificame.model.University
import com.esielkar.calificame.view.UniversityCardView

class UniversitiesAdapter(universities : Set<University>) : CardViewAdapter<University, UniversityCardView>(universities) {
    class UniversityViewHolder(universityCardView: UniversityCardView) : BindableViewHolder<University>(universityCardView) {
        override fun bind(item: University) {
            (itemView as UniversityCardView).universityName = item.name
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
    ) = UniversityViewHolder(this.applyStyle(UniversityCardView(parent.context)))
}