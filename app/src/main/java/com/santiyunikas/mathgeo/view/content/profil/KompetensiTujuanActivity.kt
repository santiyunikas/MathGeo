package com.santiyunikas.mathgeo.view.content.profil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import com.santiyunikas.mathgeo.R

class KompetensiTujuanActivity : AppCompatActivity() {
    private lateinit var tujuan: TextView
    private lateinit var kompetensi: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kompetensi_tujuan)
        kompetensi = findViewById(R.id.kompetensi)
        tujuan = findViewById(R.id.tujuan)
        kompetensi.text=
            """1. KOMPETENSI PENGETAHUAN
                |  Memahami menerapkan, menganalisis dan mengevaluasi pengetahuan faktual, konseptual,prosedural dan metakognitif berdasarkan rasa ingin tahu tentang ilmu pengetahuan, teknologi, seni, budaya dan humaniora dengan wawasan kemanusiaan, kebangsaan, kenegaraan dan peradaban terkait penyebab fenomena dan kejadian, serta menerapkan pengetahuan prosedural pada bidang kajian yang spesifik sesuai dengan bakal dan minatnya untuk memecahkan masalah
                |
                |  1.1 KOMPETENSI DASAR
                |  Mendeskripsikan jarak dalam ruang (antar titik, titik ke garis dan titik ke bidang)
                |  
                |2. KOMPETENSI KETERAMPILAN
                |  Mengolah, menalar, menyaji dan mencipta dalam ranah konkret dan ranah abstrak terkait dengan pengembangan dari yang dipelajarinya di sekolah secara mandiri serta bertindak secara efektif dan kreatif dan mampu menggunakan metode sesuai kaidah keilmuan
                |  
                |  2.1 KOMPETENSI DASAR
                |  Menentukan jarak dalam ruang (antar titik, titik ke garis dan titik ke bidang)
            """.trimMargin()

        tujuan.text ="""
            1. Siswa dapat menentukan jarak antara titik ke titik dalam bangun ruang
            2. Siswa dapat menentukan jarak antara titik ke garis dalam bangun ruang
            3. Siswa dapat menentukan jarak antara titik ke bidang dalam bangun ruang
            4. Siswa dapat menentukan jarak antara dua garis
            5. Siswa dapat menentukan jarak antara garis dan bidang
            6. Siswa dapat menentukan jarak antara bidang ke bidang
            7. Menyelesaikan masalah nyata terkait dengan jarak antara titik, garis dan bidang
        """.trimIndent()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title="Kompetensi dan Tujuan"
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