package com.example.practiceapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practiceapp.R
import com.example.practiceapp.databinding.ItemLayoutBinding
import com.example.practiceapp.model.Product

class MainAdapter(private val products: ArrayList<Product>) :
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(var itemLayoutBinding: ItemLayoutBinding) : RecyclerView.ViewHolder(itemLayoutBinding.root) {

        fun bind(product: Product) {
            itemView.apply {
                itemLayoutBinding.tvCategory.text = product.category
                itemLayoutBinding.tvTitle.text = product.title
                Glide.with(itemLayoutBinding.imageViewProduct.context)
                    .load(product.image)
                    .into(itemLayoutBinding.imageViewProduct)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return DataViewHolder(ItemLayoutBinding.bind(view))
    }


    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(products[position])
    }

    fun refreshList(products: List<Product>) {
        this.products.apply {
            clear()
            addAll(products)
        }
    }
}