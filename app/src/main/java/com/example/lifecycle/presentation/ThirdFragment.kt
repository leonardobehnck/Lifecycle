package com.example.lifecycle.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.lifecycle.databinding.FragmentThirdBinding
import com.example.lifecycle.presentation.counter.MainViewModel

class ThirdFragment : Fragment() {

  private var _binding: FragmentThirdBinding? = null
  private val binding get() = _binding!!

  private val viewModel by activityViewModels<MainViewModel>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {

    _binding = FragmentThirdBinding.inflate(inflater, container, false)
    return binding.root

  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.done.setOnClickListener() {
      viewModel.incrementBy = binding.counterIncrement.text.toString().toInt()
      Toast.makeText(context, "Incremento alterado", Toast.LENGTH_SHORT).show()
    }
  }
}