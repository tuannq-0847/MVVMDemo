package com.example.rxsample.data.model

import com.google.gson.annotations.SerializedName

data class Employee(
    @SerializedName(EMPLOYEE_NAME)
    val employeeName: String,
    @SerializedName(EMPLOYEE_SALARY)
    val employeeSalary: String,
    @SerializedName(EMPLOYEE_AGE)
    val employeeAge: String
) {

    companion object {
        const val EMPLOYEE_NAME = "employee_name"
        const val EMPLOYEE_SALARY = "employee_salary"
        const val EMPLOYEE_AGE = "employee_age"
    }
}

