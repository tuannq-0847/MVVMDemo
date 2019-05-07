package com.example.rxsample.data.repositories

import com.example.rxsample.data.model.Employee
import com.example.rxsample.data.remote.EmployeeDataSource
import com.example.rxsample.data.remote.EmployeeRemoteDataSource
import io.reactivex.Observable
import io.reactivex.Single

class EmployeeRepository(private val dataSource: EmployeeRemoteDataSource) : EmployeeDataSource.Remote {
    override fun getEmployees(): Single<List<Employee>> = dataSource.getEmployees()
}

