package com.example.taskapp53.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.taskapp53.R
import com.example.taskapp53.databinding.FragmentHomeBinding
import com.example.taskapp53.model.Task
import com.example.taskapp53.task.TaskFragment.Companion.TASK_KEY
import com.example.taskapp53.task.TaskFragment.Companion.TASK_REQUEST
import com.example.taskapp53.ui.home.adapter.TaskAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private lateinit var adapter: TaskAdapter

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TaskAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }

        setFragmentResultListener(TASK_REQUEST) { key, bundle ->
            val result = bundle.getSerializable(TASK_KEY) as Task
            adapter.addTask(result)
        }
        binding.recyclerView.adapter = adapter

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}