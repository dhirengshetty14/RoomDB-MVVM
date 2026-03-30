package com.projs.roomdb_mvvm.view

import androidx.recyclerview.widget.RecyclerView
import com.projs.roomdb_mvvm.databinding.ViewHolderProductBinding
import com.projs.roomdb_mvvm.model.Product

class ProductViewHolder(val binding: ViewHolderProductBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(p: Product){
        binding.tvProductDetails.text="""
            Product Name: ${p.productName}
            Category    : ${p.category}
            Price       : ${p.price}
        """.trimIndent()
    }
}