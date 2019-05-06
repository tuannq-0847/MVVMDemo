package com.example.rxsample.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rxsample.R.layout
import com.example.rxsample.data.remote.EmployeeRemoteDataSource
import com.example.rxsample.service.RetrofitInstance
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.recyclerEmployees
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        getData()
    }

    private fun getData() {
        val viewModel: EmployeeViewModel by viewModel()
        viewModel.getEmployees()
        viewModel.employeesLiveData.observe(this, Observer {
            recyclerEmployees.adapter = EmployeeAdapter(it)
            recyclerEmployees.layoutManager = LinearLayoutManager(this)
        })
    }
}

