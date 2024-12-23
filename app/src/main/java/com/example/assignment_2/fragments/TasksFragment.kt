package com.example.assignment_2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment_2.R
import com.example.assignment_2.TaskModel
import com.example.assignment_2.adapters.TaskAdapter
import com.example.assignment_2.databinding.FragmentTasksBinding

class TasksFragment : Fragment() {

    private lateinit var binding: FragmentTasksBinding
    private lateinit var adapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() = with(binding) {
        taskRecyclerView.layoutManager = GridLayoutManager(activity,1)
        adapter = TaskAdapter()
        taskRecyclerView.adapter = adapter
        adapter.submitList(listOf(
            TaskModel("Task 1", "01.01.2025"),
            TaskModel("Task 2", "02.01.2025"),
            TaskModel("Task 3", "03.01.2025")
        ))
    }

    companion object {
        @JvmStatic
        fun newInstance() = TasksFragment()
    }
}