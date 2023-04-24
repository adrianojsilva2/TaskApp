package com.example.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.taskapp.R
import com.example.taskapp.databinding.FragmentFormTaskBinding
import com.example.taskapp.databinding.FragmentRecoverAccountBinding
import com.example.taskapp.util.initTollbar
import com.example.taskapp.util.showBottomSheet

class FormTaskFragment : Fragment() {

    private var _binding: FragmentFormTaskBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTollbar(binding.toolbar)
        initListener()
    }

    private fun initListener(){

        binding.btnSave.setOnClickListener {
            validateData()
            //findNavController().navigate(R.id.action_global_homeFragment)

            }}
    private fun validateData(){
        val description = binding.editDescription.text.toString().trim()


        if (description.isNotEmpty()){
            Toast.makeText(requireContext(), "Tudo certo", Toast.LENGTH_SHORT).show()
        } else {
            showBottomSheet(message = getString(R.string.description_empty_form_task_fragment))
            //Toast.makeText(requireContext(), "Preencha uma descrição", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}