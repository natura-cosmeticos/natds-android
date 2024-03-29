package com.natura.android.sample.components.listitem

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.natura.android.listitem.ListItem
import com.natura.android.sample.R

class ListItemAdapter(
    private val context: Context,
    private val list: List<String>
) : RecyclerView.Adapter<ListItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_listitem, parent, false))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position, list[position])

        holder.itemView.findViewById<ListItem>(R.id.listItem).clickListener = {
            Toast.makeText(context, "Item Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val description = itemView.findViewById<TextView>(R.id.itemListDescription)
        private val listItem = itemView.findViewById<ListItem>(R.id.listItem)

        fun bind(position: Int, name: String) {

            description.text = name

            // listItem.itemListDescription.setTextColor(Color.BLACK)

            when (position) {
                0 -> listItem.setTouchStateFalse()
                1 -> listItem.setSelectableStateTrue()
                2 -> listItem.setTouchStateTrue()
                3 -> listItem.enableSelectedState()
                4 -> listItem.setDividerInset()
                5 -> listItem.setDividerMiddle()
                6 -> listItem.setDividerFullbleed()
            }
        }
    }
}
