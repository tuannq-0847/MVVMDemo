package com.example.rxsample.data.remote

import com.example.rxsample.data.model.Employee
import io.reactivex.Single

interface EmployeeDataSource {
    interface Remote {
        fun getEmployees(): Single<List<Employee>>
    }
}

