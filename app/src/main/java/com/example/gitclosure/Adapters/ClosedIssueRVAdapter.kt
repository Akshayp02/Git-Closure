package com.example.gitclosure.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gitclosure.Models.ClosedIssueModel
import com.example.gitclosure.databinding.IssueslistRvBinding
import com.squareup.picasso.Picasso
import java.util.*

class ClosedIssueRVAdapter(val context: Context, var issueList: ArrayList<ClosedIssueModel>) :
    RecyclerView.Adapter<ClosedIssueRVAdapter.ViewHolder>() {

    // Property for search query
    var searchQuery: String = ""

    class ViewHolder(binding: IssueslistRvBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.title
        val createdAt = binding.Createddate
        val closedAt = binding.closwddate
        val user = binding.usename
        val imgURL = binding.profileImage
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            IssueslistRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return issueList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Code here to bind the data to the view
        val currentIssue = issueList[position]

        holder.title.text = currentIssue.title
        holder.createdAt.text = currentIssue.CreatedAt
        holder.closedAt.text = currentIssue.ClosedAt
        holder.user.text = currentIssue.user

        Picasso.get().load(currentIssue.ImgURL).into(holder.imgURL)

        // Handle visibility based on search query
        if (searchQuery.isNotEmpty() && !currentIssue.title.toLowerCase(Locale.getDefault())
                .contains(searchQuery)
        ) {
            holder.itemView.visibility = View.GONE
        } else {
            holder.itemView.visibility = View.VISIBLE
        }
    }

}
