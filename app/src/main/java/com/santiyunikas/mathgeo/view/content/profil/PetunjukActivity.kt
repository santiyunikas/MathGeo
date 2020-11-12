package com.santiyunikas.mathgeo.view.content.profil

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import com.santiyunikas.mathgeo.R
import kotlinx.android.synthetic.main.activity_petunjuk.*

class PetunjukActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_petunjuk)
        petunjuk.text =
            """Pada media pembelajaran ini, kalian perlu menuju menu 'Materi Prasyarat' untuk mengetahui apakah kalian sudah siap menerima materi Jarak pada Dimensi Tiga. pada menu ini kalian akan diberikan 5 soal mengenai materi sebelumnya. Apabila kalian salah lebih dari 2 soal maka kalian perlu mengingat kembali materi sebelumnya yang bermanfaat untuk mempelajari materi berikutnya jika kalian mendapatkan minimal nilai 60, maka terdapat pilihan untuk memilih menu materi sebelumnya atau melanjutkan pada menu materi berikutnya yaitu, tentang jarak pada dimensi tiga.
                |
                |Media pembelajaran ini dilengkapi dengan materi dimensi tiga, latihan soal dan kuis. Pada menu materi materi terdiri dari jarak antara dua titik, jarak titik ke garis, jarak titik ke bidang, jarak antara dua garis, jarak antara garis dan bidang, serta jarak antara dua bidang.
                |
                |Kemudian pada menu latihan soal terdapat 10 soal yang dilengkapi dengan pembahasan. Kerjakanlah semua soal di menu kuis untuk mengetahui kemampuan terakhirmu mengenai materi dimensi tiga. Setiap kalian menyelesaikan soal di menu latihan soal dan kuis akan ditampilkan hasil skor yang diperoleh
            """.trimMargin()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title="Petunjuk Penggunaan"
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