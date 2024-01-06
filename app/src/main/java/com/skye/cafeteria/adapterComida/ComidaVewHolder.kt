package com.skye.cafeteria.adapterComida
import com.bumptech.glide.Glide
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.skye.cafeteria.DataClassMenu
import com.skye.cafeteria.R

class ComidaVewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val nombreComida = view.findViewById<TextView>(R.id.tvnombrecomida)
    val descripcionComida = view.findViewById<TextView>(R.id.tvdescripcioncomida)
    val precioComida = view.findViewById<TextView>(R.id.tvPreciocomida)
    val imagen = view.findViewById<ImageView>(R.id.imcomida)

    fun render(comidaModle: DataClassMenu) {
        nombreComida.text = comidaModle.nombre
        descripcionComida.text = comidaModle.descripcion
        precioComida.text = comidaModle.precio.toString()
        Glide.with(imagen.context)
            .load(comidaModle.imagen)
            .into(imagen)
       

    }
}


