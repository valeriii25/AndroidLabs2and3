package com.example.androidlabs2and3

import android.content.Context
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.androidlabs2and3.databinding.ProductCardBinding

class ProductAdapter : RecyclerView.Adapter<ProductHolder>() {
    private val products = mutableListOf<Product>()
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ProductCardBinding.inflate(inflater, parent, false)
        context = parent.context
        return ProductHolder(binding)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val product = products[position]
        holder.binding.isFavorite.setOnClickListener{
            product.isFavorite = !product.isFavorite
            holder.binding.isFavorite.setColorFilter(
                ActivityCompat.getColor(context, if (product.isFavorite) R.color.red
                else R.color.grey), PorterDuff.Mode.MULTIPLY
            )
        }
        holder.binding.productName.text = product.name
        holder.binding.productImage.setImageResource(product.jpgID)
        holder.binding.productPrice.text = product.price.toString()
    }

     fun add(product: Product) {
        products.add(product)
        notifyItemInserted(products.size - 1)
    }
}