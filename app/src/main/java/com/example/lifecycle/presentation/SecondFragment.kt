package com.example.lifecycle.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.lifecycle.R
import com.example.lifecycle.databinding.FragmentSecondBinding
import com.example.lifecycle.presentation.counter.MainViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

  private val viewModel by activityViewModels<MainViewModel>() {
    ViewModelFactory()
  }

  private var _binding: FragmentSecondBinding? = null

  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {

    _binding = FragmentSecondBinding.inflate(inflater, container, false)
    return binding.root

  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.buttonSecond.setOnClickListener {
      findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
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
      binding.counterIncrement.text = it.toString()
    }
  }
}