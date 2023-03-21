package com.example.taskapp53.ui.onBoard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskapp53.databinding.FragmentOnBoardBinding
import com.example.taskapp53.databinding.ItemOnboardingBinding
import com.example.taskapp53.model.OnBoard
import com.example.taskapp53.utils.loadImage

class OnBoardingAdapter(private val onClick:() -> Unit):
    Adapter<OnBoardingAdapter.OnBoardViewHolder>() {

private val data = arrayListOf(
    OnBoard("https://img.freepik.com/free-vector/hand-drawn-business-planning-with-task-list_23-2149164275.jpg?w=360", "Task Manager 1", "Task Manager Description"),
    OnBoard("https://w7.pngwing.com/pngs/209/1016/png-transparent-computer-icons-task-id-miscellaneous-computer-logo.png", "Task Manager 2", "Task Manager Description"),
    OnBoard("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR9qSfMo1AESOFhDotopT1V_gE4Cc7VzPG22A&usqp=CAU", "Task Manager 3", "Task Manager Description")

)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardViewHolder {
        return OnBoardViewHolder(ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class OnBoardViewHolder(private val binding: ItemOnboardingBinding): ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.tvTitle.text = onBoard.title
            binding.tvDesc.text = onBoard.description
            binding.imgBoard.loadImage(onBoard.image)
            binding.skip.isVisible = adapterPosition != 2
            binding.btnStart.isVisible = adapterPosition == 2
            binding.skip.setOnClickListener() {
                onClick()
            }
            binding.btnStart.setOnClickListener() {
                onClick()
            }
        }
    }
}