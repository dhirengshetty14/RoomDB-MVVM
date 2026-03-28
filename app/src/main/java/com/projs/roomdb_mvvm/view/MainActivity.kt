package com.projs.roomdb_mvvm.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.projs.roomdb_mvvm.R
import com.projs.roomdb_mvvm.databinding.ActivityMainBinding
import com.projs.roomdb_mvvm.model.ProductDB
import com.projs.roomdb_mvvm.model.local.Repository
import com.projs.roomdb_mvvm.viewmodel.ProductVMFactory
import com.projs.roomdb_mvvm.viewmodel.ProductViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var viewModel: ProductViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        setObservers()
        setUpEvents()

    }


    private fun initViewModel() {
        val repo= Repository(ProductDB.getInstance(this))

        val factory= ProductVMFactory(repo)
        viewModel= ViewModelProvider(this,factory)[ProductViewModel::class.java]
    }

    private fun setObservers() {
        viewModel.products.observe(this){
            binding.rvProducts.adapter
        }
    }
}