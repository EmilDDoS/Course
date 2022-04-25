package com.example.usdcourse.presentation.screens.coursescreen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.usdcourse.databinding.MainScreenFragmentBinding
import com.example.usdcourse.di.ViewModelFactory
import com.example.usdcourse.presentation.adapters.CourseAdapter
import kotlinx.coroutines.flow.collect


class CourseFragment : Fragment() {

    lateinit var binding: MainScreenFragmentBinding
    private val viewModel: CourseFragmentViewModel by viewModels { ViewModelFactory() }
    private var adapter = CourseAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainScreenFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getMonthlyCourse()
        binding.recyclerCourse.adapter = adapter

        lifecycleScope.launchWhenCreated {
            viewModel.monthlyCourse.collect {
                adapter.courseList = it
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.enteredNumber.collect {
                setEnteredNumber(it)
            }
        }

        viewModel.getNumber()

        binding.saveButton.setOnClickListener {
            if(!binding.editTextNumber.text.isNullOrEmpty()) {
                val enteredNumber = binding.editTextNumber.text.toString().toFloat()
                viewModel.saveNumber(enteredNumber)
                closeInput()
                binding.editTextNumber.text.clear()
            }
        }

    }

    private fun closeInput() {
        try {
            val imm = requireActivity()
                .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
        } catch (e: Exception) {
            e.stackTraceToString()
        }
    }

    private fun setEnteredNumber(float: Float) {
        val number = float.toString()
        binding.savedNumberText.text = number
    }
}