package com.skye.cafeteria

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.skye.cafeteria.adapterBebida.BebidaAdapter
import com.skye.cafeteria.databinding.FragmentPagarBinding


class PagarFragment : Fragment() {
    private lateinit var binding: FragmentPagarBinding
    private lateinit var selectedBebidaAdapter: BebidaAdapter
    private var selectedBebidaList: List<DataClassMenu> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPagarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtén la lista de elementos seleccionados del Bundle
        val selectedBebidaList =
            arguments?.getParcelableArrayList<DataClassMenu>(SELECTED_BEBIDA_LIST_KEY)

        selectedBebidaAdapter = BebidaAdapter(selectedBebidaList ?: emptyList(), this)
        binding.recyclerViewProductosSeleccionados.adapter = selectedBebidaAdapter
        binding.recyclerViewProductosSeleccionados.layoutManager =
            LinearLayoutManager(requireContext())

        // Actualiza la cantidad total
        binding.tvCantidadTotal.text = "Cantidad Total: ${calcularCantidadTotal(selectedBebidaList)}"
    }

    companion object {
        private const val SELECTED_BEBIDA_LIST_KEY = "selected_bebida_list"

        fun newInstance(selectedBebidaList: List<DataClassMenu>): PagarFragment {
            val fragment = PagarFragment()
            val bundle = Bundle()
            val parcelableList: ArrayList<Parcelable> = ArrayList(selectedBebidaList)
            bundle.putParcelableArrayList(SELECTED_BEBIDA_LIST_KEY, parcelableList)
            fragment.arguments = bundle
            return fragment
        }
    }


    fun setSelectedBebidaList(selectedBebidaList: List<DataClassMenu>) {
        this.selectedBebidaList = selectedBebidaList
        binding.tvCantidadTotal.text = "Cantidad Total: ${calcularCantidadTotal(selectedBebidaList)}"
    }

    private fun calcularCantidadTotal(selectedBebidaList: List<DataClassMenu>?): Double {
        if (selectedBebidaList.isNullOrEmpty()) {
            return 0.0
        }
        return selectedBebidaList.sumByDouble { it.precio }
    }







}