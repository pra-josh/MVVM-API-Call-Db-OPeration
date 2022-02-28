package com.pra.modernappmvvm.Presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pra.modernappmvvm.Presentation.adapter.UserAdapter
import com.pra.modernappmvvm.Presentation.viewmodel.UserListVIewModel
import com.pra.modernappmvvm.Presentation.viewmodel.ViewModelFactory
import com.pra.modernappmvvm.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private lateinit var mViewModel: UserListVIewModel
    private var mAdapter: UserAdapter = UserAdapter(this, arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(_binding.root)

        // with factory val viewModel = ViewModelProvider(this, YourViewModelFactory).get(YourViewModel::class.java)
        val factory = ViewModelFactory(applicationContext)
        mViewModel = ViewModelProvider(this, factory)[UserListVIewModel::class.java]

        _binding.rvUser.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mAdapter
        }

        observableViewModel()
        mViewModel.refresh()
    }

    private fun observableViewModel() {
        mViewModel.users.observe(this, Observer {
            it.let {
                mAdapter.UpdateCountry(it)
                mAdapter.notifyDataSetChanged()
            }
        })

        mViewModel.countryLoadError.observe(this, Observer {
            it?.let {
                if (it) {
                    _binding.tvError.visibility = View.VISIBLE
                    _binding.rvUser.visibility = View.GONE
                } else {
                    _binding.tvError.visibility = View.GONE
                    _binding.rvUser.visibility = View.VISIBLE
                }
            }
        })

        mViewModel.loading.observe(this, Observer {
            it?.let {
                if (it) {
                    _binding.progressBar.visibility = View.VISIBLE
                  //  _binding.rvUser.visibility = View.GONE
                } else {
                    _binding.progressBar.visibility = View.GONE
                    _binding.rvUser.visibility = View.VISIBLE
                }
            }
        })
    }


}