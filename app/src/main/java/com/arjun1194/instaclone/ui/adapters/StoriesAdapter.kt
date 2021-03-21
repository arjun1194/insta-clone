package com.arjun1194.instaclone.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arjun1194.instaclone.R
import com.arjun1194.instaclone.data.model.User
import com.arjun1194.instaclone.databinding.StoryItemBinding

class StoriesAdapter : ListAdapter<User, StoriesAdapter.ViewHolder>(STORY_DIFF) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.story_item,parent,false)
        return ViewHolder(StoryItemBinding.bind(view))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: StoryItemBinding ): RecyclerView.ViewHolder(binding.root){
        fun bind(item: User){
            binding.user = item
            binding.executePendingBindings()
        }
    }

    companion object {
         val STORY_DIFF = object : DiffUtil.ItemCallback<User>(){
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                 return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }


        }
    }

}
