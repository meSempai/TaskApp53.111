package com.example.taskapp53.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.taskapp53.databinding.FragmentTaskBinding
import com.example.taskapp53.model.Task


class TaskFragment : Fragment() {

    private lateinit var binding:FragmentTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener{
            val data =
            Task(title = binding.etTitle.text.toString(),   desc = binding.etDesc.text.toString())
            setFragmentResult(TASK_REQUEST, bundleOf(TASK_KEY to data))
            findNavController().navigateUp()
        }
    }

    companion object {
        const val  TASK_REQUEST = "task"
        const val  TASK_KEY = "task key"
    }

}