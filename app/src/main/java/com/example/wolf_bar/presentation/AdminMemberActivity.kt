package com.example.wolf_bar.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wolf_bar.databinding.ActivityAdminMemberBinding


class AdminMemberActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminMemberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminMemberBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    private fun logout() {

    }
}