package com.example.taskapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.taskapp.R
import com.google.android.material.appbar.AppBarLayout;
import com.example.taskapp.databinding.FragmentRegisterBinding
import com.example.taskapp.util.initTollbar
import com.example.taskapp.util.showBottomSheet


class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTollbar(binding.toolbar)

        initListener()
    }

    private fun initListener(){

        binding.btnRegister.setOnClickListener {
            validateData()
            //findNavController().navigate(R.id.action_global_homeFragment)
        }

    }

    private fun validateData(){
        val email = binding.editEmail.text.toString().trim()
        val password = binding.editPassword.text.toString().trim()


        if (email.isNotEmpty()){
            if(password.isNotEmpty()){
                Toast.makeText(requireContext(), "tudo certo", Toast.LENGTH_SHORT).show()
            } else {
               showBottomSheet(message = getString(R.string.password_empty_register_fragment))
               //Toast.makeText(requireContext(), "Preencha uma senha", Toast.LENGTH_SHORT).show()
            }
        } else {
            showBottomSheet(message = getString(R.string.email_empty_register_fragment))
            //Toast.makeText(requireContext(), "Preencha um email valido", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}