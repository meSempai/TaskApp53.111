package com.example.taskapp53.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taskapp53.App
import com.example.taskapp53.R
import com.example.taskapp53.databinding.FragmentHomeBinding
import com.example.taskapp53.model.Task
import com.example.taskapp53.ui.home.adapter.TaskAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private lateinit var adapter: TaskAdapter

    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TaskAdapter(this::onLongClick)
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
        binding.recyclerView.adapter = adapter
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
        setData()
        binding.recyclerView.adapter = adapter

    }

    private fun setData(){
        val data = App.db.taskDao().getAll()
        adapter.addTasks(data)
    }
    private fun onLongClick(task: Task) {
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle("Delete?")
        alertDialog.setMessage("Are you sure you want to delete? ")
        alertDialog.setNegativeButton("No") { d, i ->
            d.cancel()
        }
        alertDialog.setPositiveButton("Yes") { d, i ->
            App.db.taskDao().delete(task)
            setData()
        }
        alertDialog.create().show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}