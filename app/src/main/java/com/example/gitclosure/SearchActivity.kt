package com.example.gitclosure

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gitclosure.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    lateinit var binding: ActivitySearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //code here
        val SearchQuary = binding.searchtext.text.toString()

        binding.searchbtn.setOnClickListener(){
            //code here

        }
    }
}