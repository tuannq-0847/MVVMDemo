package com.example.rxsample.resources.api

import com.example.rxsample.data.model.Employee
import io.reactivex.Single
import retrofit2.http.GET

interface ApiRequest {
    @GET(GET_ALL_EMPLOYEES)
    fun getData(): Single<List<Employee>>

    companion object {
        const val GET_ALL_EMPLOYEES = "api/v1/employees"
    }
}

