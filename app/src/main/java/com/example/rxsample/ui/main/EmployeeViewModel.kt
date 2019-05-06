package com.example.rxsample.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxsample.data.model.Employee
import com.example.rxsample.data.repositories.EmployeeRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class EmployeeViewModel(private val employeeRepository: EmployeeRepository) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val _employeesLiveData = MutableLiveData<List<Employee>>()

    val employeesLiveData: LiveData<List<Employee>>
        get() = _employeesLiveData

    fun getEmployees() {
        val disposable = employeeRepository.getEmployees()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _employeesLiveData.postValue(it)
            }, {
                _employeesLiveData.value = null
            })
        compositeDisposable.add(disposable)
    }
}

