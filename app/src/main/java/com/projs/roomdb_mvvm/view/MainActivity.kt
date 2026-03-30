package com.projs.roomdb_mvvm.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
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
import kotlin.toString

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
        setupEvents()

    }


    private fun initViewModel() {
        val repo= Repository(ProductDB.getInstance(this))

        val factory= ProductVMFactory(repo)
        viewModel= ViewModelProvider(this,factory)[ProductViewModel::class.java]
    }

    private fun setObservers() {
        viewModel.products.observe(this) {
            binding.rvProducts.adapter = ProductAdapter(it)
        }
        viewModel.newprodId.observe(this) {
            if (it > 0) {
                AlertDialog.Builder(this@MainActivity)
                    .setTitle("Success")
                    .setMessage("Product added successfully with product id = $it")
                    .show()
            } else {
                AlertDialog.Builder(this@MainActivity)
                    .setTitle("Error")
                    .setMessage("Failed to add the product due to unknown reason. Please retry.")
                    .show()
            }
        }
    }
        fun setupEvents() {
            binding.btnAddProduct.setOnClickListener {
                val name = binding.etName.text.toString()
                val price = binding.etPrice.text.toString().toFloat()
                val category = binding.etCategory.text.toString()

                viewModel.onInputDataChanged(name, category, price)

            }
        }
    }
