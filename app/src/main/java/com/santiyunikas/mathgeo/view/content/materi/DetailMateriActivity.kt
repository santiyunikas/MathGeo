package com.santiyunikas.mathgeo.view.content.materi

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.santiyunikas.mathgeo.R
import kotlinx.android.synthetic.main.activity_detail_materi.*

class DetailMateriActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_materi)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val sessionId = intent.getIntExtra("EXTRA_SESSION_ID", 0)
        tx_detail_materi.text = sessionId.toString()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                super.onOptionsItemSelected(item)
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}