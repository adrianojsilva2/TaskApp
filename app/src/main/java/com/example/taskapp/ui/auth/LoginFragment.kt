package com.example.taskapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.taskapp.R
import com.example.taskapp.databinding.FragmentLoginBinding
import com.example.taskapp.util.showBottomSheet

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
    }

    private fun initListener(){

        binding.btnLogin.setOnClickListener {
            validateData()
            //findNavController().navigate(R.id.action_global_homeFragment)
        }

        binding.btnRegister.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.btnRecover.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_recoverAccountFragment)
        }
    }

    private fun validateData(){
        val email = binding.editEmail.text.toString().trim()
        val password = binding.editPassword.text.toString().trim()


    if (email.isNotEmpty()){
        if(password.isNotEmpty()){
            findNavController().navigate(R.id.action_global_homeFragment)
            //Toast.makeText(requireContext(), "tudo certo", Toast.LENGTH_SHORT).show()
        } else {

            showBottomSheet(message = getString(R.string.password_empty))
            //Toast.makeText(requireContext(), "Preencha sua senha", Toast.LENGTH_SHORT).show()
        }
    } else {
        showBottomSheet(message = getString(R.string.email_empty))
        //Toast.makeText(requireContext(), "Preencha seu email", Toast.LENGTH_SHORT).show()
    }
}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}