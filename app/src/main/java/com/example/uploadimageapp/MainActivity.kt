package com.example.uploadimageapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var imageView2: ImageView
    private val PICK_IMAGE_REQUEST = 1
    private var imageUri:Uri? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        imageView2 = findViewById(R.id.imageView2)
        val buttonButton = findViewById<Button>(R.id.button)
        val editTextText = findViewById<EditText>(R.id.editTextText)
        val editTextText2 = findViewById<EditText>(R.id.editTextText2)
        val editTextText3 = findViewById<EditText>(R.id.editTextText3)
        val button2Button = findViewById<Button>(R.id.button2)
        val textView3 = findViewById<TextView>(R.id.textView3)

        buttonButton.setOnClickListener {
            openImageChooser()
        }


        button2Button.setOnClickListener {
            val name = editTextText.text.toString()
            val address = editTextText2.text.toString()
            val position =editTextText3.text.toString()


            if (name.isNotEmpty() && address.isNotEmpty() && position.isNotEmpty()) {
                textView3.text = "Name: $name\nAddress: $address\nPosition: $position"
            } else {
                textView3.text = "Please fill in all fields."
            }
        }
    }


    private fun openImageChooser() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            imageUri = data.data
            imageView2.setImageURI(imageUri)
        }
    }
}