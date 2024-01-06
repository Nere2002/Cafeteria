package com.skye.cafeteria

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.skye.cafeteria.adapterComida.ComidaAdapter
import com.skye.cafeteria.databinding.FragmentComidaBinding

class ComidaFragment : Fragment() {

    private lateinit var binding: FragmentComidaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_comida, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerviewComida.adapter = ComidaAdapter(ComidaProvider.comidaList)
        binding.recyclerviewComida.layoutManager = LinearLayoutManager(requireContext())
    }

}
