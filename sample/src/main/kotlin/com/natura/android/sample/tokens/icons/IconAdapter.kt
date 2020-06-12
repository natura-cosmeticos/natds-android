package com.natura.android.sample.tokens.icons

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
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
