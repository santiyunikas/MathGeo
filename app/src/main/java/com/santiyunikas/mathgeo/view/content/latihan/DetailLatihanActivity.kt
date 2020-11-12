package com.santiyunikas.mathgeo.view.content.latihan

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.santiyunikas.mathgeo.R
import kotlinx.android.synthetic.main.activity_detail_latihan.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class DetailLatihanActivity : AppCompatActivity() {
    private var idLatihan = 0
    private var judulLatihan = ""

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_latihan)
        idLatihan = intent.getIntExtra(DaftarLatihanFragment.KEY_ID_LATIHAN, 0)
        judulLatihan= intent.getStringExtra(DaftarLatihanFragment.KEY_JUDUL_LATIHAN)
        id_latihan.text = "$idLatihan = $judulLatihan"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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