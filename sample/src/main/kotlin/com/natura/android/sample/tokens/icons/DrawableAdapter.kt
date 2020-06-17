package com.natura.android.sample.tokens.icons

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.natura.android.sample.R

class DrawableAdapter(
    private val context: Context,
    private val idList: List<Int>,
    private val nameList: List<String>
) : RecyclerView.Adapter<DrawableAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_drawable, parent, false))

    override fun getItemCount() = idList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(idList[position], nameList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemIcon = itemView.findViewById<ImageView>(R.id.item_icon)
        private val code = itemView.findViewById<TextView>(R.id.item_icon_code)

        fun bind(resourceId: Int, name: String) {
            itemIcon.setBackgroundResource(resourceId)
            code.text = name
        }
    }
}
