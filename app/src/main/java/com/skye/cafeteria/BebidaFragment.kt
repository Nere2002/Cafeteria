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

        bebidaAdapter.setOnItemClickListener { selectedBebida ->
            // Aquí debes navegar al fragmento de PagarFragment y pasar la lista de bebidas seleccionadas
            val pagarFragment = PagarFragment.newInstance(listOf(selectedBebida))
            parentFragmentManager.beginTransaction()
                .replace(R.id.navHostFragment, pagarFragment)
                .addToBackStack(null)
                .commit()
        }
    }

    fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }


}