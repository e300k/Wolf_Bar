package com.example.wolf_bar.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wolf_bar.databinding.ActivityMemberAdminBinding

class AdminMemberActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMemberAdminBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemberAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

    fun onClickMember(){

    }

}