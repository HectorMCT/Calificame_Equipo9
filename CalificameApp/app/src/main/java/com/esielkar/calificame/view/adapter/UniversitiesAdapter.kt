package com.esielkar.calificame.view.adapter

import android.view.View
import android.view.ViewGroup
import com.esielkar.calificame.api.ApiUtils
import com.esielkar.calificame.model.University
import com.esielkar.calificame.utils.UniResponse
import com.esielkar.calificame.view.components.UniversityCardView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UniversitiesAdapter(
    universities : Set<University>,
    onItemClickListener: View.OnClickListener? = null,
) : CardViewAdapter<University, UniversityCardView>(universities, onItemClickListener) {
    class UniversityViewHolder(universityCardView: UniversityCardView) : BindableViewHolder<University>(universityCardView) {
        override fun bind(item: University) {
            (itemView as UniversityCardView).universityName = item.name
            //Asincrona
            ApiUtils.api.getUni().enqueue(object : Callback<UniResponse> {
                override fun onResponse(call: Call<UniResponse>, response: Response<UniResponse>) {
                    if (response.isSuccessful) {
                        response.body()?.uniList?.items?.find {
                            it.title == item.name
                        }?.thumbnail?.let {
                            (itemView as UniversityCardView).setImage(it)
                        }
                    } else (itemView as UniversityCardView).setDefaultUniversityImage()
                }
                override fun onFailure(call: Call<UniResponse>, t: Throwable) {
                    (itemView as UniversityCardView).setDefaultUniversityImage()
                }
            })
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