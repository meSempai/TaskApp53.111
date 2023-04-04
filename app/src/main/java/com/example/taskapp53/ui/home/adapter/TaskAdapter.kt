package com.example.taskapp53.ui.home.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskapp53.databinding.ItemTaskBinding
import com.example.taskapp53.model.OnBoard
import com.example.taskapp53.model.Task

class TaskAdapter(val onLongClick: (Task)-> Unit) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private val data: ArrayList<Task> = arrayListOf()

    private var color = true
    fun addTask(task: Task) {
        data.add(0, task)
        notifyItemChanged(0)
    }
    @SuppressLint("NotifyDataSetChanged")
    fun addTasks(task:List<Task>) {
        data.clear()
        data.addAll(task)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size


    inner class TaskViewHolder(private val binding: ItemTaskBinding) : ViewHolder(binding.root) {
        fun bind(task: Task) {
            itemView.setOnLongClickListener(){
                onLongClick(task)
                false
            }
            binding.tvTitle.text = task.title
            binding.tvDesc.text = task.desc

            if (color){
                binding.itemTask.setBackgroundColor(Color.BLACK)
                binding.tvDesc.setTextColor(Color.WHITE)
                binding.tvTitle.setTextColor(Color.WHITE)
                color = false

            }else{
                binding.itemTask.setBackgroundColor(Color.WHITE)
                binding.tvDesc.setTextColor(Color.BLACK)
                binding.tvTitle.setTextColor(Color.BLACK)
                color = true
            }
        }
    }
}