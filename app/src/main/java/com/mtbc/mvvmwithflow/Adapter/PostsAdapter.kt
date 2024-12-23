package com.mtbc.mvvmwithflow.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mtbc.mvvmwithflow.databinding.PostItemBinding
import com.mtbc.mvvmwithflow.model.Posts

class PostsAdapter(private var postsList: List<Posts>) : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {
    private lateinit var  binding:PostItemBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
      binding = PostItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostsViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
    return postsList.size
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
      binding.tvTitle.text = postsList[position].title
      binding.tvBody.text = postsList[position].body
    }
    class PostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
    fun setData(postsList: List<Posts>){
        this.postsList = postsList
        notifyDataSetChanged()
    }
}