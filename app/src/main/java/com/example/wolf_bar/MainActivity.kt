package com.example.wolf_bar


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wolf_bar.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAuth = FirebaseAuth.getInstance()

        binding.btnLogin.setOnClickListener {
            loginUser()
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = mAuth!!.currentUser
        updateUI(currentUser)
    }

    private fun loginUser() {
        val email = binding.txtUsername.text.toString()
        val password = binding.txtPassword.text.toString()
        if (email.isNotEmpty() && password.isNotEmpty()) {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    val intent = Intent(this, AdminActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this,
                        "โปรดตรวจสอบอีเมลล์หรือรหัสผ่านอีกครั้ง",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        } else {
            Toast.makeText(this, "โปรดกรอกอีเมลล์และรหัสผ่าน", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user !== null) {
            val uid = user.uid
            val email = user.email
            Toast.makeText(
                this@MainActivity,
                "Wecome: $email your ID is : $uid",
                Toast.LENGTH_SHORT
            ).show()
            val intent = Intent(this, AdminActivity::class.java)
            startActivity(intent)
        }
    }
}
