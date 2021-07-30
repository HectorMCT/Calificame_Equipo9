package com.esielkar.calificame.model.adapter

import android.os.Parcelable
import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.esielkar.calificame.model.Bindable

//TODO: E : Parceable
abstract class BindableAdapter<E>(
    val items : Collection<E>,
    val onItemClickListener : ((E) -> Unit)? = null
) : RecyclerView.Adapter<BindableAdapter.BindableViewHolder<E>>() {
    abstract class BindableViewHolder<E>(view: View) : RecyclerView.ViewHolder(view), Bindable<E>

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the [ViewHolder.itemView] to reflect the item at the given
     * position.
     *
     *
     * Note that unlike [android.widget.ListView], RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the `position` parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use [ViewHolder.getBindingAdapterPosition] which
     * will have the updated adapter position.
     *
     * Override [.onBindViewHolder] instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: BindableViewHolder<E>, position: Int) {
        holder.bind(items.elementAt(position))
        onItemClickListener?.let {
            holder.itemView.setOnClickListener { it(items.elementAt(position)) }
        }
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int = items.size
}