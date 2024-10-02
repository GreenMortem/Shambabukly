package com.example.shambambukly

import android.content.ContentValues
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shambambukly.databinding.CellItemBinding

class Adapter:RecyclerView.Adapter<Adapter.Holder>() {
    val itemList = ArrayList<Cell>()

    class Holder(item: View): RecyclerView.ViewHolder(item){
        val binding = CellItemBinding.bind(item)
        fun bind(cell: Cell) = with(binding){
            im.setImageResource(cell.imageID)
            tvName.text = cell.name
            tvComment.text = cell.comment
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_item, parent, false)
        Log.d(ContentValues.TAG, " роб2 $view")
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(itemList[position])
        val x = itemList[position]
        Log.d(ContentValues.TAG, " роб1 $x")
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun createCell(cell: Cell){
        itemList.add(cell)
        notifyItemInserted(itemList.size - 1)
        Log.d(ContentValues.TAG, " роб1 $itemList")
    }

    fun update(){
        notifyDataSetChanged()
    }
}