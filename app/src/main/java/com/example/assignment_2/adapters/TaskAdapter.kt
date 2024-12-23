package com.example.assignment_2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_2.R
import com.example.assignment_2.TaskModel
import com.example.assignment_2.databinding.TaskBinding

class TaskAdapter : ListAdapter<TaskModel,TaskAdapter.Holder>(Comparator()) {
    class Holder(view: View) : RecyclerView.ViewHolder(view){
        val binding = TaskBinding.bind(view)
        fun bind(task: TaskModel) = with(binding){
            descriptionTextView.text = task.description
            dateTextView.text = task.dueDate
        }
    }

    class Comparator: DiffUtil.ItemCallback<TaskModel>(){
        override fun areItemsTheSame(oldItem: TaskModel, newItem: TaskModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: TaskModel, newItem: TaskModel): Boolean {
            return oldItem.description == newItem.description && oldItem.dueDate == newItem.dueDate
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}