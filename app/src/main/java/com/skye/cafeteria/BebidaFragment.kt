package com.skye.cafeteria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.skye.cafeteria.adapterBebida.BebidaAdapter

import com.skye.cafeteria.databinding.FragmentBebidaBinding


class BebidaFragment : Fragment() {
    private lateinit var binding: FragmentBebidaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bebida, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val bebidaAdapter = BebidaAdapter(BebidaProvider.bebidaList, this)

        binding.recyclerviewBebida.adapter = bebidaAdapter
        binding.recyclerviewBebida.layoutManager = LinearLayoutManager(requireContext())

//        bebidaAdapter.setOnItemClickListener { selectedBebida ->
//            // Aquí debes realizar alguna lógica para determinar si la bebida seleccionada es válida
//            // y devolver un valor booleano indicando si se debe permitir la navegación a PagarFragment
//            val isValidSelection = true // Ejemplo: supongamos que siempre permitimos la navegación
//
//            if (isValidSelection) {
//                val pagarFragment = PagarFragment.newInstance(BebidaProvider.bebidaList.filter { it.isSelected })
//                parentFragmentManager.beginTransaction()
//                    .replace(R.id.navHostFragment, pagarFragment)
//                    .addToBackStack(null)
//                    .commit()
//            } else {
//                // Si la selección no es válida, muestra un mensaje de error o realiza alguna acción apropiada
//                showToast("La bebida seleccionada no es válida")
//            }
//        }
    }



    fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }


}