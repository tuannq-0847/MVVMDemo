package com.example.rxsample.di

import com.example.rxsample.data.remote.EmployeeRemoteDataSource
import com.example.rxsample.data.repositories.EmployeeRepository
import com.example.rxsample.service.RetrofitInstance
import com.example.rxsample.ui.main.EmployeeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val employeeModule = module {
    viewModel { EmployeeViewModel(get()) }
    single { RetrofitInstance.getRetrofitInstance() }
    single { EmployeeRemoteDataSource(get()) }
    single { EmployeeRepository(get()) }
}

