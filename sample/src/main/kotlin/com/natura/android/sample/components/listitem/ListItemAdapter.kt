package com.natura.android.sample.components.listitem

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.natura.android.listitem.ListItem
import com.natura.android.sample.R
import kotlinx.android.synthetic.main.item_list.view.*

class ListItemAdapter(
    private val context: Context,
    private val list: List<String>
) : RecyclerView.Adapter<ListItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position, list[position])

        holder.itemView.listItem.clickListener = {
            Toast.makeText(context, "Item Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val description = itemView.findViewById<TextView>(R.id.itemListDescription)
        private val listItem = itemView.findViewById<ListItem>(R.id.listItem)

        fun bind(position: Int, name: String) {

            description.text = name

            listItem.itemListDescription.setTextColor(Color.BLACK)

            when (position) {
                0 -> {
                    listItem.setTouchState(false)
                    listItem.itemListDescription.setTextColor(Color.GRAY)
                }
                2 -> listItem.enableSelectedState()
                3 -> listItem.setDivider(2)
                4 -> listItem.setDivider(3)
                5 -> listItem.setDivider(1)
            }
        }
    }
}
