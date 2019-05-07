package com.example.rxsample.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rxsample.data.model.Employee
import com.example.rxsample.databinding.ItemEmployeeBinding
import com.example.rxsample.ui.main.EmployeeAdapter.ViewHolder

class EmployeeAdapter(private val employees: List<Employee>) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemEmployeeBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return employees.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val employee = employees[position]
        holder.onBind(employee)
    }

    inner class ViewHolder(private val itemBinding: ItemEmployeeBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(employee: Employee) {
            itemBinding.employee = employee
        }
    }
}

