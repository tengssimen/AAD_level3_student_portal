package com.example.studentportal

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*

const val EXTRA_PORTAL = "EXTRA PORTAL"

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        initViews()
    }

    private fun initViews() {
        btnAdd.setOnClickListener { onAddClick() }
    }

    private fun onAddClick() {
        val title = etTitle.text.toString()
        val url = etUrl.text.toString()

        if (title.isNotBlank() && url.isNotBlank()) {
            val portal = Portal(title, url)
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_PORTAL, portal)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            Toast.makeText(
                this, getString(R.string.no_empty_portal)
                , Toast.LENGTH_SHORT
            ).show()
        }
    }
}