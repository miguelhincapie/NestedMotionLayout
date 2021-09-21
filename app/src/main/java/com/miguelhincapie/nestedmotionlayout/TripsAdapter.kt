package com.miguelhincapie.nestedmotionlayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView

class TripsAdapter(private val dataSet: Array<Trip>) :
    RecyclerView.Adapter<TripsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.icon)
        val title: TextView = view.findViewById(R.id.text)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.rv_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) = with(dataSet[position]) {
        viewHolder.icon.setImageDrawable(
            AppCompatResources.getDrawable(
                viewHolder.itemView.context,
                iconRes
            )
        )
        viewHolder.title.text = description
    }

    override fun getItemCount() = dataSet.size
}