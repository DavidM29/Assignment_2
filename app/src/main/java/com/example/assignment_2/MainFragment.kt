package com.example.assignment_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.assignment_2.adapters.ViewPagerAdapter
import com.example.assignment_2.databinding.FragmentMainBinding
import com.example.assignment_2.fragments.AddTaskFragment
import com.example.assignment_2.fragments.TasksFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val fragments = listOf(
        AddTaskFragment.newInstance(),
        TasksFragment.newInstance()
    )

    private val titles = listOf(
        "Add Task",
        "Tasks"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() = with(binding){
        val adapter = ViewPagerAdapter(activity as FragmentActivity, fragments)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager){ tab, position ->
            tab.text = titles[position]
        }.attach()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}