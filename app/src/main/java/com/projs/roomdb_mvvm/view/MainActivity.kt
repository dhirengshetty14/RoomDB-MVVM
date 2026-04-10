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
import com.projs.roomdb_mvvm.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.toString

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val viewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setObservers()
        setupEvents()
    }

    private fun setObservers() {

        viewModel.products.observe(this) {
            binding.rvProducts.adapter = ProductAdapter(it)
        }

        viewModel.newprodId.observe(this) {
            if (it > 0) {
                AlertDialog.Builder(this)
                    .setTitle("Success")
                    .setMessage("Product added with id = $it")
                    .show()
            } else {
                AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Failed to add product")
                    .show()
            }
        }
    }

    private fun setupEvents() {
        binding.btnAddProduct.setOnClickListener {
            val name = binding.etName.text.toString()
            val category = binding.etCategory.text.toString()
            val price = binding.etPrice.text.toString().toFloat()

            viewModel.onInputDataChanged(name, category, price)
        }
    }
}