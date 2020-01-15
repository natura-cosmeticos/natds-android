package com.natura.android.sample.components

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.natura.android.sample.R

class IconAdapter(
    private val context: Context,
    private val itemList: List<Int>
) : RecyclerView.Adapter<IconAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_icon, parent, false))

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(context.getString(itemList[position]))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemIcon = itemView.findViewById<AppCompatTextView>(R.id.item_icon)
        private val code = itemView.findViewById<TextView>(R.id.item_icon_code)

        fun bind(option: CharSequence) {
            itemIcon.text = option
            code.text = option
        }
    }
}