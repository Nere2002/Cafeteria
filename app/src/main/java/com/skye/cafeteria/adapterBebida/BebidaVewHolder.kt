package com.skye.cafeteria.adapterBebida

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.skye.cafeteria.DataClassMenu
import com.skye.cafeteria.R

class BebidaVewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val nombrebebida = view.findViewById<TextView>(R.id.tvnombrebebida)
    val descripcionbebida = view.findViewById<TextView>(R.id.tvdescripcionbebida)
    val preciobebida = view.findViewById<TextView>(R.id.tvpreciobebida)
    val imagen = view.findViewById<ImageView>(R.id.imbebida)

    fun render(comidaModle: DataClassMenu) {
        nombrebebida.text = comidaModle.nombre
        descripcionbebida.text = comidaModle.descripcion
        preciobebida.text = comidaModle.precio.toString()
        Glide.with(imagen.context)
            .load(comidaModle.imagen)
            .into(imagen)


    }
}