package com.example.fashionnova.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fashionnova.Activities.Item_View_Activity
import com.example.fashionnova.Models.ItemDataItem
import com.example.fashionnova.databinding.ItemDisplayLayoutBinding

class Items_Adpater(private var mlist: MutableList<ItemDataItem>) :
    RecyclerView.Adapter<Items_Adpater.ProductItemView>() {

    companion object {
        private const val TITLE = 0
        private const val PRODUCT = 1
    }

    inner class ProductItemView(val binding: ItemDisplayLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemView {
        val binding = ItemDisplayLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductItemView(binding)
    }

    override fun onBindViewHolder(holder: ProductItemView, position: Int) {
        val item = mlist[position]
        with(holder.binding) {
            Glide.with(holder.itemView.context)
                .load(item.image)
                .into(imageItem)  // Use `.into()` to load the image

            itemName.text = item.title
            itemType.text = item.category
            priceItem.text = item.price.toString()
            ItemLayout.setOnClickListener{
                ItemLayout.setOnClickListener {
                    val context = holder.itemView.context
                    val intent = Intent(context, Item_View_Activity::class.java)

                    // Pass the whole item object
                    intent.putExtra("item", item)
                    context.startActivity(intent)
                }
            }
        }
    }
    override fun getItemCount(): Int {
        return mlist.size
    }
    fun clear() {
        mlist.clear()
        notifyDataSetChanged()
    }

    fun Setdata(products: List<ItemDataItem>) {
        this.mlist = products.toMutableList()
        notifyDataSetChanged()
    }
}
