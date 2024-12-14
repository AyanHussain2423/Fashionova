package com.example.fashionnova.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fashionnova.Models.ItemDataItem
import com.example.fashionnova.databinding.CheckoutRcViewBinding
import com.example.fashionnova.databinding.ItemDisplayLayoutBinding

class Cart_Adapter(private var mlist: MutableList<ItemDataItem>) :
    RecyclerView.Adapter<Cart_Adapter.ProductItemView>() {
    inner class ProductItemView(val binding: CheckoutRcViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemView {
        val binding = CheckoutRcViewBinding.inflate(LayoutInflater
            .from(parent.context), parent, false)
        return ProductItemView(binding)
    }
    override fun onBindViewHolder(holder: ProductItemView, position: Int) {
        val item = mlist[position]
        val maxLength = 10
        with(holder.binding){
            Glide.with(holder.itemView.context)
                .load(item.image)
                .into(itemImage)
            ItemName.text = truncateText(item.title,maxLength)
            itemCatogory.text = item.category
            itemPrice.text = item.price.toString()
        }
    }
    override fun getItemCount(): Int {
      return mlist.size
    }
    fun updateItems(newItems: List<ItemDataItem>) {
        mlist.clear()
        mlist.addAll(newItems)
        notifyDataSetChanged()
    }
    fun truncateText(text: String, maxLength: Int): String {
        return if (text.length > maxLength) {
            text.take(maxLength) + "..."
        } else {
            text
        }
    }
}