/*
 * Created by Amwalul Ikhsani on 7/29/20 5:27 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.igdownloader.ui.main.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.amwa.domain.model.Media
import com.amwa.igdownloader.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_gallery.view.*

class GalleryAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val differ = AsyncListDiffer(this, object : DiffUtil.ItemCallback<Media>() {
        override fun areItemsTheSame(oldItem: Media, newItem: Media): Boolean {
            return oldItem.fileName == newItem.fileName
        }

        override fun areContentsTheSame(oldItem: Media, newItem: Media): Boolean {
            return oldItem == newItem
        }
    })

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return GalleryViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_gallery,
                parent,
                false
            ),
            interaction
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is GalleryViewHolder -> {
                holder.bind(differ.currentList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Media>) {
        differ.submitList(list)
    }

    inner class GalleryViewHolder
    constructor(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Media) = with(itemView) {
            setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }

            Glide.with(this).load(item.path).into(ivGallery)
        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: Media)
    }
}