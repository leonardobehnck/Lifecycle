package com.example.lifecycle.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.lifecycle.R
import com.example.lifecycle.databinding.FragmentFirstBinding
import com.example.lifecycle.presentation.counter.MainViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

  private var _binding: FragmentFirstBinding? = null

  private val viewModel by activityViewModels<MainViewModel>() {
    ViewModelFactory()
  }


  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {

    _binding = FragmentFirstBinding.inflate(inflater, container, false)
    return binding.root

  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.buttonFirst.setOnClickListener {
      findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }

    binding.edit.setOnClickListener {
      findNavController().navigate(R.id.action_FirstFragment_to_thirdFragment)
    }
    counter()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  fun counter() {
    //Sempre quando é alterado o observe atualiza o campo
    viewModel.counter.observe(viewLifecycleOwner) {
      binding.counter.text = it.toString()
    }

    binding.add.setOnClickListener() {
      viewModel.increment()
    }
  }
}