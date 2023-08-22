package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (performLogin(username, password)) {
                showPopup()

            } else {
                showPopup2()
            }
        }
    }

    private fun showPopup() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)

    }
    private fun showPopup2() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Login inválido!")
            .setMessage("tente novamente")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss() // Fecha o diálogo ao clicar em OK
            }
            .create()
            .show()
    }
    private fun performLogin(username: String, password: String): Boolean {
        val validUsername = "usuario"
        val validPassword = "senha123"

        return username == validUsername && password == validPassword
    }
}