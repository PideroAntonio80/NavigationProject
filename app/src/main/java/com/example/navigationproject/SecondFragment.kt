package com.example.navigationproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationproject.databinding.FragmentSecondBinding
import com.google.android.material.snackbar.Snackbar

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    private var thing = Thing()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSecondBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvTitle.setOnClickListener {

            if (!binding.etId.text.isNullOrEmpty() && !binding.etName.text.isNullOrEmpty()) {
                val id: Int = binding.etId.text.toString().toInt()
                val name: String  = binding.etName.text.toString().trim()
                thing = Thing(id = id, name = name)

                val bundle = Bundle()
                bundle.putSerializable("my_thing", thing)
                findNavController().navigate(R.id.detailFragment, bundle)
            } else {
                Snackbar.make(binding.root, getString(R.string.fill_et_obligatory), Snackbar.LENGTH_LONG).setAnchorView(binding.tvTitle).show()
            }
        }
    }
}