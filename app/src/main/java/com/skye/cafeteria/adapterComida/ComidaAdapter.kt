package com.skye.cafeteria.adapterComida

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skye.cafeteria.DataClassMenu
import com.skye.cafeteria.R

class ComidaAdapter (private val comidaList:List<DataClassMenu>) : RecyclerView.Adapter<ComidaVewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComidaVewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        return ComidaVewHolder(layoutInflater.inflate(R.layout.itemcomida , parent , false))
    }

    override fun onBindViewHolder(holder: ComidaVewHolder, position: Int) {

        val item=comidaList[position]
        holder.render(item)

    }

    override fun getItemCount(): Int=comidaList.size



}