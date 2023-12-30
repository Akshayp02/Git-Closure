package com.example.gitclosure

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gitclosure.Adapters.ClosedIssueRVAdapter
import com.example.gitclosure.ApiHandle.RetrofitObject
import com.example.gitclosure.Models.ApiModel.myData

import com.example.gitclosure.Models.ClosedIssueModel
import com.example.gitclosure.databinding.ActivityMainBinding


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ClosedIssueRVAdapter
    private lateinit var issueList: ArrayList<ClosedIssueModel>
    private lateinit var tempArraylist: ArrayList<ClosedIssueModel>
    private var currentPage = 1
    private val itemsPerPage = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val rv = binding.CloseIssueListRV

        issueList = ArrayList()
        tempArraylist = ArrayList()
        adapter = ClosedIssueRVAdapter(this, tempArraylist)
        rv.adapter = adapter

        rv.layoutManager = LinearLayoutManager(this)
        getIssues()




        binding.CloseIssueListRV.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0) {
                    // Load more items only if the last item is visible
                    getIssues()
                }
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        val item = menu?.findItem(R.id.SearchAction)
        val searchView = item?.actionView as androidx.appcompat.widget.SearchView

        searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                tempArraylist.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                adapter.searchQuery = searchText

                if (searchText.isNotEmpty()) {
                    val searchResults = issueList.filter {
                        it.title.toLowerCase(Locale.getDefault()).contains(searchText)
                    }
                    tempArraylist.addAll(searchResults)

                    if (tempArraylist.isEmpty()) {
                        // Show a message indicating that no results were found
                        binding.username.visibility = View.VISIBLE
                    } else {
                        binding.username.visibility = View.GONE
                    }
                } else {
                    tempArraylist.addAll(issueList)
                    binding.username.visibility = View.GONE
                }

                adapter.notifyDataSetChanged()
                return false
            }


        })
        searchView.queryHint = "Search Here"
        return super.onCreateOptionsMenu(menu)
    }

    private fun getIssues() {
        val apiService = RetrofitObject().apiService
        val call: Call<List<myData.myDataItem>> =
            apiService.getIssuesData(currentPage, itemsPerPage)

        call.enqueue(object : Callback<List<myData.myDataItem>?> {
            override fun onResponse(
                call: Call<List<myData.myDataItem>?>,
                response: Response<List<myData.myDataItem>?>
            ) {
                if (response.isSuccessful) {
                    binding.progressBar.visibility = android.view.View.GONE
                    binding.CloseIssueListRV.visibility = android.view.View.VISIBLE

                    val issuesDataModel: List<myData.myDataItem>? = response.body()
                    if (issuesDataModel != null) {
                        Log.d("API_RESPONSE", "Number of items received: ${issuesDataModel.size}")

                        // Clear issueList only when it's the first page
                        if (currentPage == 1) {
                            issueList.clear()
                        }

                        for (i in issuesDataModel) {
                            val userName = i.user.login
                            val userImage = i.user.avatarUrl

                            val createdAt = formatDate(i.createdAt)
                            val closedAt = formatDate(i.closedAt)

                            val closedIssueModel = ClosedIssueModel(
                                i.title,
                                createdAt,
                                closedAt,
                                userName,
                                userImage
                            )
                            issueList.add(closedIssueModel)
                        }

                        tempArraylist.clear()
                        tempArraylist.addAll(issueList)

                        adapter.notifyDataSetChanged()
                        Log.d("MainActivity", "Current Page: $currentPage")
                        currentPage++
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<myData.myDataItem>?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failed to fetch data", Toast.LENGTH_SHORT).show()
            }
        })
    }


    private fun formatDate(inputDate: String?): String {
        if (inputDate.isNullOrEmpty()) {
            return ""
        }

        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
        val outputFormat = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH)

        try {
            val date = inputFormat.parse(inputDate)
            return outputFormat.format(date)
        } catch (e: Exception) {
            e.printStackTrace()
            // Handle parsing exception if needed
            return ""
        }


    }
}


