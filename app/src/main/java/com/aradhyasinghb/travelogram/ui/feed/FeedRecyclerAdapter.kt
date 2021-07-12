package com.aradhyasinghb.travelogram.ui.feed

import android.annotation.SuppressLint
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.aradhyasinghb.travelogram.R
import com.aradhyasinghb.travelogram.databinding.ListItemGalleryImageBinding

class FeedRecyclerAdapter() :
    ListAdapter<Image, FeedRecyclerAdapter.FeedViewHolder>(FeedDiffCallBack()) {

    class FeedViewHolder( val binding: ListItemGalleryImageBinding) : RecyclerView.ViewHolder(binding.root)


    private class FeedDiffCallBack : DiffUtil.ItemCallback<Image>(){
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem.toString() == newItem.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val inflater: LayoutInflater = parent.context.getSystemService(LayoutInflater::class.java)

        val binding = ListItemGalleryImageBinding.inflate(inflater, parent, false)

        return FeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val image = getItem(position)
        holder.binding.captionTextView.text = image.title
        holder.binding.imageView.load("https://i.imgur.com/${image.cover}.jpeg") {
            placeholder(R.drawable.placeholder_image)
            error(R.drawable.placeholder_broken_image)
        }
            // TODO imageview.kt and disposable.kt nahi hai and red wali pata ni kya dikat hai

    }
}