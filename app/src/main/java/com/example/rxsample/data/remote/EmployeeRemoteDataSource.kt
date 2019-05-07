package com.example.rxsample.data.remote

import com.example.rxsample.data.model.Employee
import com.example.rxsample.resources.api.ApiRequest
import io.reactivex.Single

class EmployeeRemoteDataSource(private val apiRequest: ApiRequest) : EmployeeDataSource.Remote {
    override fun getEmployees(): Single<List<Employee>> = apiRequest.getData()
}

