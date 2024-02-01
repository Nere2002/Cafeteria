package com.skye.cafeteria.adapterBebida

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.skye.cafeteria.DataClassMenu
import com.skye.cafeteria.R


class BebidaAdapter(
    private val bebidaList: List<DataClassMenu>,
    private val pagarFragment: Fragment,

    ) : RecyclerView.Adapter<BebidaAdapter.BebidaViewHolder>() {

    // Nueva lista para almacenar elementos seleccionados
    private val selectedItems = mutableListOf<DataClassMenu>()

    // Listener para manejar eventos de selección
    private var onItemClickListener: ((DataClassMenu) -> Unit)? = null

    // Función para establecer el listener
    fun setOnItemClickListener(listener: (DataClassMenu) -> Unit) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BebidaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BebidaViewHolder(layoutInflater.inflate(R.layout.itembebida, parent, false))
    }


    override fun onBindViewHolder(holder: BebidaViewHolder, position: Int) {
        val item = bebidaList[position]
        holder.render(item)

        // Manejar eventos de clic en los elementos
        holder.itemView.setOnClickListener {
            toggleSelection(item)
            onItemClickListener?.invoke(item)
        }

        // Actualizar la apariencia del elemento según si está seleccionado o no
        holder.itemView.isSelected = selectedItems.contains(item)

        // Cambiar el color de fondo del elemento según si está seleccionado o no
        val colorResId = if (holder.itemView.isSelected) R.color.Logo else android.R.color.white
        holder.itemView.setBackgroundColor(holder.itemView.context.resources.getColor(colorResId))
    }



    override fun getItemCount(): Int = bebidaList.size

    // Función para alternar la selección de elementos
    private fun toggleSelection(item: DataClassMenu) {
        if (selectedItems.contains(item)) {
            selectedItems.remove(item)
        } else {
            selectedItems.add(item)
        }
        notifyDataSetChanged()

        // Llama a la función en el PagarFragment para actualizar la lista de elementos seleccionados
        //pagarFragment.setSelectedBebidaList(selectedItems)
    }


    inner class BebidaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // ... (resto del código)

        // Función para enlazar los datos con la vista
        fun render(item: DataClassMenu) {
            Log.d("BebidaAdapter", "Render - ${item.nombre}")
            itemView.findViewById<TextView>(R.id.tvnombrebebida).text = item.nombre
            itemView.findViewById<TextView>(R.id.tvdescripcionbebida).text = item.descripcion
            itemView.findViewById<TextView>(R.id.tvpreciobebida).text = item.precio.toString()
        }
    }

}